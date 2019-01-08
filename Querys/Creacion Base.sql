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
usu_login VARCHAR(100),
usu_mail VARCHAR(100),
usu_obs VARCHAR(255),
usu_alta_fecha DATETIME NOT NULL,
usu_modi_fecha DATETIME,
usu_baja INT
);

DROP TABLE IF EXISTS wf_funciones;

CREATE TABLE wf_funciones
(
fun_id INT AUTO_INCREMENT PRIMARY KEY,
fun_padre INT,
fun_nombre VARCHAR(100) NOT NULL,
fun_codigo VARCHAR(255) NOT NULL,
fun_obs VARCHAR(255) NOT NULL,
fun_alta_fecha DATETIME NOT NULL,
fun_modi_fecha DATETIME,
fun_baja INT	
);

DROP TABLE IF EXISTS wf_asignaciones;

CREATE TABLE wf_asignaciones
(
asi_id INT AUTO_INCREMENT PRIMARY KEY,
asi_fun INT, FOREIGN KEY (asi_fun) REFERENCES wf_funciones(fun_id),
asi_usu INT, FOREIGN KEY (asi_usu) REFERENCES wf_usuarios(usu_id),
asi_alta_fecha DATETIME,
asi_modi_fecha DATETIME,
asi_baja INT
);

SET FOREIGN_KEY_CHECKS=1;