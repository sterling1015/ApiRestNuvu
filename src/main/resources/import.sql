INSERT INTO tarjeta (nombre) values ('Visa');
INSERT INTO tarjeta (nombre) values ('Mastercard');
INSERT INTO tarjeta (nombre) values ('Otro');

INSERT INTO persona (nombre,apellido,telefono,tarjeta_credito) values ('Steven','Sterling',3213993321,1);
INSERT INTO persona (nombre,apellido,telefono,tarjeta_credito) values ('Charly','Sterling',3213993321,2);
INSERT INTO persona (nombre,apellido,telefono,tarjeta_credito) values ('Aldemar','Sterling',3213993321,3);

/* Usuarios y roles */
INSERT INTO `usuarios` (username,password,enabled) VALUES ('steven','$2a$10$LMz.4a2PJTXukBLZ846NFepe2htVXq.6DagTCa84duJP.Z6TTQoXS',1);
INSERT INTO `usuarios` (username,password,enabled) VALUES ('admin','$2a$10$LXFwu5xJixpIjXd/LDG5zuLY6s60fTZiRH9.IELkVZ4OfUZQw0YVG',1);

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');


INSERT INTO `usaurios_roles` (usuario_id, role_id) values (1,1);
INSERT INTO `usaurios_roles` (usuario_id, role_id) values (2,2);
INSERT INTO `usaurios_roles` (usuario_id, role_id) values (2,1);