-- Insertar roles
INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO roles (id, name) VALUES (2, 'ROLE_ADMIN')
    ON CONFLICT (id) DO NOTHING;

-- Insertar usuarios (las contraseñas ya están encriptadas con BCrypt)
INSERT INTO users (id, username, password, enabled) VALUES
                                                        (1, 'user1', '$2a$12$nBFNn4B2FXiBX4JILGkMaOH0iIOZl27zR17bBcbjm81wsigPca0Te', true),
                                                        (2, 'admin', '$2a$12$nBFNn4B2FXiBX4JILGkMaOH0iIOZl27zR17bBcbjm81wsigPca0Te', true)
    ON CONFLICT (id) DO NOTHING;

-- Asignar roles a los usuarios
INSERT INTO user_roles (user_id, role_id) VALUES
                                              (1, 1),  -- user1 con ROLE_USER
                                              (2, 2)   -- admin con ROLE_ADMIN
    ON CONFLICT DO NOTHING;
