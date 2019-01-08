USE adminpdd;

DROP PROCEDURE IF EXISTS validar_usu;

DELIMITER //
CREATE PROCEDURE validar_usu(mail VARCHAR(100),pass VARCHAR(255))
BEGIN

SELECT * FROM wf_usuarios WHERE usu_mail=mail AND usu_password=pass AND usu_baja=0;

END //
DELIMITER ;
