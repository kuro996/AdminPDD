Use AdminPDD;

INSERT INTO `adminpdd`.`wf_usuarios` (`usu_id`,`usu_nombre`, `usu_apellido`, `usu_password`, `usu_login`, `usu_mail`, `usu_baja`) VALUES (0,'Definir', 'Sin', 0x00, 'SDF', 'SDF@SDF.com', '1');
UPDATE wf_usuarios SET usu_id=0 WHERE usu_id=1;
ALTER TABLE wf_usuarios AUTO_INCREMENT = 0; 
INSERT INTO `adminpdd`.`wf_usuarios` (`usu_nombre`, `usu_apellido`, `usu_password`, `usu_login`, `usu_mail`, `usu_tipo`) VALUES ('Leandro', 'Ibañez', 'Kuro1996', 'libanez', 'Prueba@prueba.com', 'A');
INSERT INTO `adminpdd`.`wf_usuarios` (`usu_nombre`, `usu_apellido`, `usu_password`, `usu_login`, `usu_mail`) VALUES ('Prueba', ' ', '1234', 'prb', 'prueba@prueba.com');


INSERT INTO `adminpdd`.`wf_equipos` (`equ_id`, `equ_codigo`, `equ_nombre`,`equ_baja`) VALUES ('0', 'SD', 'Sin Definir', '1');
UPDATE wf_equipos SET equ_id=0 WHERE equ_id=1;
ALTER TABLE wf_equipos AUTO_INCREMENT = 0;
INSERT INTO `adminpdd`.`wf_equipos` (`equ_codigo`, `equ_nombre`) VALUES ('PRB', 'prueba');

INSERT INTO `adminpdd`.`wf_funciones` (`fun_id`, `fun_nombre`, `fun_codigo`) VALUES ('0', 'Sin Definir', 'SD');
UPDATE wf_funciones SET fun_id=0 WHERE fun_id=1;
ALTER TABLE wf_funciones AUTO_INCREMENT = 0; 
INSERT INTO `adminpdd`.`wf_funciones` (`fun_padre`, `fun_nombre`, `fun_codigo`) VALUES ('0', 'Principal', 'Principal');
INSERT INTO `adminpdd`.`wf_funciones` (`fun_padre`, `fun_nombre`, `fun_codigo`) VALUES ('1', 'Seguridad', 'Principal.Seguridad');
INSERT INTO `adminpdd`.`wf_funciones` (`fun_padre`, `fun_nombre`, `fun_codigo`) VALUES ('2','Permisos', 'Principal.Seguridad.Permisos');
INSERT INTO `adminpdd`.`wf_funciones` (`fun_padre`, `fun_nombre`, `fun_codigo`) VALUES ('3', 'Editar Permisos', 'Permisos.editar');

INSERT INTO `adminpdd`.`wf_miembros` ( `mie_usu`, `mie_equ`) VALUES ( '2', '1');

INSERT INTO `adminpdd`.`wf_asignaciones` (`asi_fun`, `asi_usu`,`asi_equ`) VALUES ('2', '0','1');