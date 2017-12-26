INSERT INTO oauth_client_details
(client_id, resource_ids, client_secret, `scope`, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES('oauth_client', NULL, 'secret', 'read,write,test', 'password,refresh_token', '', 'ROLE_USER', 100, 86400, NULL, 'true');
INSERT INTO oauth_client_details
(client_id, resource_ids, client_secret, `scope`, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES('test', NULL, 'secret', 'read,write,test', 'authorization_code,refresh_token', '', 'ROLE_USER', 1800, 86400, NULL, 'true');
INSERT INTO oauth_client_details
(client_id, resource_ids, client_secret, `scope`, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES('test1', NULL, 'secret', 'user_info', 'authorization_code,refresh_token', 'http://www.baidu.com', 'ROLE_USER', 1800, 86400, NULL, 'true');

INSERT INTO user_info
(user_id, login_id, password, title_id, first_name, last_name, email, address, birthday, image, phone, activated, register_time)
VALUES('000001', 'admin', 'b8f57d6d6ec0a60dfe2e20182d4615b12e321cad9e2979e0b9f81e0d6eda78ad9b6dcfe53e4e22d1', '1', '最高', '指揮官', 'admin@localhost.com', '天堂路 001 號', '1992-01-01', '000001.jpg', '1234-567890', 1, NULL);

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