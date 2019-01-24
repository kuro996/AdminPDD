CREATE DATABASE IF NOT EXISTS AdminPDD;

USE AdminPDD;

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS wf_usuarios;

CREATE TABLE wf_usuarios
(
usu_id INT AUTO_INCREMENT PRIMARY KEY,
usu_nombre VARCHAR(50) NOT NULL,
usu_apellido VARCHAR(50) NOT NULL,
usu_password BLOB NOT NULL,
usu_login VARCHAR(100) NOT NULL,
usu_mail VARCHAR(100),
usu_imagen mediumblob,
usu_tipo CHAR(1) NOT NULL DEFAULT 'E',
usu_obs VARCHAR(255) NOT NULL DEFAULT '',
usu_alta_fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
usu_modi_fecha DATETIME,
usu_baja INT NOT NULL DEFAULT '0'
);


DROP TABLE IF EXISTS wf_funciones;

CREATE TABLE wf_funciones
(
fun_id INT AUTO_INCREMENT PRIMARY KEY,
fun_padre INT,FOREIGN KEY (fun_padre) REFERENCES wf_funciones (fun_id),
fun_nombre VARCHAR(100) NOT NULL,
fun_codigo VARCHAR(255) NOT NULL,
fun_obs VARCHAR(255) NOT NULL DEFAULT '',
fun_alta_fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
fun_modi_fecha DATETIME,
fun_baja INT NOT NULL DEFAULT '0'
);

DROP TABLE IF EXISTS wf_equipos;

CREATE TABLE wf_equipos
(
equ_id INT AUTO_INCREMENT PRIMARY KEY,
equ_codigo VARCHAR(10) NOT NULL,
equ_nombre VARCHAR(50) NOT NULL,
equ_obs VARCHAR(255) NOT NULL DEFAULT '',
equ_alta_fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
equ_modi_fecha DATETIME,
equ_baja INT NOT NULL DEFAULT '0'
);

DROP TABLE IF EXISTS wf_miembros;

CREATE TABLE wf_miembros
(
mie_id INT AUTO_INCREMENT PRIMARY KEY,
mie_usu INT NOT NULL,FOREIGN KEY (mie_usu) REFERENCES wf_usuarios (usu_id), 
mie_equ INT NOT NULL,FOREIGN KEY (mie_equ) REFERENCES wf_equipos (equ_id),
mie_obs VARCHAR(255) NOT NULL DEFAULT '',
mie_alta_fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
mie_modi_fecha DATETIME,
mie_baja INT NOT NULL DEFAULT '0'
);

DROP TABLE IF EXISTS wf_asignaciones;

CREATE TABLE wf_asignaciones
(
asi_id INT AUTO_INCREMENT PRIMARY KEY,
asi_fun INT, FOREIGN KEY (asi_fun) REFERENCES wf_funciones(fun_id),
asi_usu INT, FOREIGN KEY (asi_usu) REFERENCES wf_usuarios(usu_id),
asi_equ INT, FOREIGN KEY (asi_equ) REFERENCES wf_equipos(equ_id),
asi_alta_fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
asi_modi_fecha DATETIME,
asi_baja INT NOT NULL DEFAULT '0'
);

SET FOREIGN_KEY_CHECKS=1;