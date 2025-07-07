INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO users(username, password) VALUES ('user','$2a$12$xI8BTqyGG2xmqf5xyS5RO.e7uUzTYc.oXMg.UfY0w/Paa2CJAAwya');
INSERT INTO users(username, password) VALUES ('admin','$2a$12$8XEhOZDg/fRAlvCFO7shTeME9Xen0wy3mA4CKGDNOMh0ZtQPmJCJK');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- user1 with ROLE_USER
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- admin with ROLE_ADMIN