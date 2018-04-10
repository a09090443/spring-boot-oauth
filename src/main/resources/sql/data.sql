INSERT INTO oauth_client_details
(client_id, resource_ids, client_secret, `scope`, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES('oauth_client', NULL, 'secret', 'read,write,test', 'password,refresh_token', '', 'ROLE_USER', 100, 86400, NULL, 'true');
INSERT INTO oauth_client_details
(client_id, resource_ids, client_secret, `scope`, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES('test', NULL, 'secret', 'read,write,test', 'authorization_code,refresh_token', '', 'ROLE_USER', 1800, 86400, NULL, 'true');
INSERT INTO oauth_client_details
(client_id, resource_ids, client_secret, `scope`, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES('test1', NULL, 'secret', 'user_info', 'authorization_code,refresh_token', 'http://www.baidu.com', 'ROLE_USER', 1800, 86400, NULL, 'true');

INSERT INTO dev_network.user_info
(user_id, login_id, password, first_name, last_name, email, address, birthday, image, phone, activated, register_time)
VALUES('000001', 'admin', '$2a$10$edhXzouCrFzV/8WhlT4pn.V.fro7J4rvAMFfjpFTxHmQj7.N4meDa', '&#26368;&#39640;', '&#25351;&#25582;&#23448;', 'admin@localhost.com', '&#22825;&#22530;&#36335; 001 &#34399;', '1992-01-01', '000001.jpg', '1234567890', 1, '2017-12-31 02:30:49');

INSERT INTO authority
(authority_id, name)
VALUES('01', 'ROLE_ADMIN');
INSERT INTO authority
(authority_id, name)
VALUES('02', 'ROLE_USER');

INSERT INTO user_authority
(user_id, authority_id)
VALUES('000001', '01');
INSERT INTO user_authority
(user_id, authority_id)
VALUES('000001', '02');