INSERT INTO USUARIO (id, username, password) VALUES (1, 'admin', '123456');

INSERT INTO CARGO (id, descricao) VALUES (1, 'Desenvolvedor');
INSERT INTO CARGO (id, descricao) VALUES (2, 'Scrum Master');
INSERT INTO CARGO (id, descricao) VALUES (3, 'Designer');
INSERT INTO CARGO (id, descricao) VALUES (4, 'Coordenador');

INSERT INTO COLABORADOR (id, nome, cargo_id) VALUES (1, 'Felipe Caparelli', 1);
INSERT INTO COLABORADOR (id, nome, cargo_id) VALUES (2, 'Jose Wilker', 1);
INSERT INTO COLABORADOR (id, nome, cargo_id) VALUES (3, 'Maria Bonita', 1);
INSERT INTO COLABORADOR (id, nome, cargo_id) VALUES (4, 'Joao Santana', 2);
INSERT INTO COLABORADOR (id, nome, cargo_id) VALUES (5, 'Americo Vespucio', 3);
INSERT INTO COLABORADOR (id, nome, cargo_id) VALUES (6, 'Anita Garibaldi', 4);