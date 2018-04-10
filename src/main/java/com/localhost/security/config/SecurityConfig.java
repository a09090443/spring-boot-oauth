package com.localhost.security.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

public class SecurityConfig {

	@Configuration
	@EnableAuthorizationServer
	static class OAuthAuthorizationConfig extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;

		@Autowired
		private DataSource dataSource;

		@Autowired
		private UserDetailsService userDetailsService;

		@Bean
		public TokenStore tokenStore() {
			return new JdbcTokenStore(dataSource);
		}

		/**
		* 配置：安全檢查流程 默認過濾器：BasicAuthenticationFilter
		* 1、oauth_client_details表中clientSecret字段加密【ClientDetails屬性secret】
		* 2、CheckEndpoint類的接口 oauth/check_token 無需經過過濾器過濾，默認值：denyAll()
		*/
		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

			security.allowFormAuthenticationForClients();
			security.tokenKeyAccess("permitAll()");
			security.checkTokenAccess("isAuthenticated()");
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// clients
			// .inMemory()
			// .withClient("ClientId")
			// .secret("secret")
			// .authorizedGrantTypes("password")
			// .scopes("user_info")
			// .autoApprove(true);
			clients.jdbc(dataSource);
		}

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
			endpoints.tokenStore(tokenStore());
		}
	}

	@Configuration
	@EnableResourceServer
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	static class OAuthResourceConfig extends ResourceServerConfigurerAdapter {
		 @Override
		 public void configure(HttpSecurity http) throws Exception {
				http.anonymous().disable()
					.requestMatchers().antMatchers("/api/**", "/user/**")
					.and().authorizeRequests()
					.antMatchers("/api/test1").access("hasRole('ADMIN')")
					.antMatchers("/user/getAllUsers").authenticated()
					.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
		 }

//		@Override
//		public void configure(HttpSecurity http) throws Exception {
//			http.
//			anonymous().disable()
//			.requestMatchers().antMatchers("/test/**")
//			.and().authorizeRequests()
//			.antMatchers("/test/**").access("hasRole('ADMIN')")
//			.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//			http
//            .authorizeRequests()
//            .antMatchers("/api/get").access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_USER'))");  
//		}
	}
	
	@Configuration
	@EnableWebSecurity
	static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private UserDetailsService userDetailsService;

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		 @Override
		 protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable();
		//// http.authorizeRequests()
		//// .anyRequest()
		//// .authenticated()
		//// .and()
		//// .formLogin()
		//// .permitAll();
		
	        http.requestMatchers()
            .antMatchers("/login", "/oauth/**")
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .permitAll();

		 }

//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable();
//			http.authorizeRequests()
//				.anyRequest()
//				.authenticated()
//				.and()
//				.formLogin()
//				.permitAll();
//		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());
		}
	}
}
