INSERT INTO tblrol (id, name) VALUES (NULL, 'ROLE_ADMIN'), (NULL, 'ROLE_USER');
INSERT INTO tbluser (id, create_at, enabled, name, second_name) VALUES (NULL, '2022-02-16', b'1', 'Efrain', 'Restrepo');
INSERT INTO tbluser_roles (user_id, roles_id) VALUES ('1', '1');