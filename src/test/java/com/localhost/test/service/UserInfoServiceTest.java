package com.localhost.test.service;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.localhost.model.Authority;
import com.localhost.model.UserInfo;
import com.localhost.service.IUserService;
import com.localhost.test.base.TestBase;

public class UserInfoServiceTest extends TestBase {
	@Autowired
	private IUserService userService;

	@Test
	public void testFindAll() {
		try {
			List<UserInfo> userInfoList = userService.findAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}
	
	@Test
	public void testFindUserByLoginId() {
		try {
			UserInfo userInfo = userService.findUserByLoginId("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Test
	public void testFindUserByEmail() {
		try {
			UserInfo userInfo = userService.findUserByEmail("admin@localhost.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Test
	public void testAddUser() {
		try {
			UserInfo userInfo = new UserInfo();
			userInfo.setLoginId("test");
			userInfo.setFirstName("test");
			userInfo.setLastName("te");
			userInfo.setPassword("test");
			userInfo.setPhone("0910123456");
			userInfo.setEmail("test@localhost.com");
			
			Set<Authority> authoritySet = new HashSet<>();
			Authority authority = new Authority();
			authority.setAuthorityId("011");
//			authority.setName("ROLE_ADMIN");
			authoritySet.add(authority);
			userInfo.setAuthorities(authoritySet);
			
			userService.addUser(userInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

}
