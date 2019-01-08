USE adminpdd;

DROP PROCEDURE IF EXISTS validar_usu;

DELIMITER //
CREATE PROCEDURE validar_usu(login VARCHAR(100),pass VARCHAR(255))
BEGIN

SELECT * FROM wf_usuarios WHERE usu_login=login AND usu_password=pass AND usu_baja=0;

END //
DELIMITER ;
