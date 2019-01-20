USE adminpdd;

DROP PROCEDURE IF EXISTS validar_usu;

DELIMITER //
CREATE PROCEDURE validar_usu(login VARCHAR(100),pass VARCHAR(255))
BEGIN

SELECT * FROM wf_usuarios WHERE usu_login=login AND usu_password=pass AND usu_baja=0;

END //
DELIMITER ;

DROP FUNCTION IF EXISTS strSplit;
DELIMITER //
CREATE FUNCTION strSplit (cadena VARCHAR(255), delimitador VARCHAR(12)) RETURNS VARCHAR(255) 
BEGIN
	
	CREATE TEMPORARY TABLE resultados (item VARCHAR(500));
	
	SET @pocision=1;
	
	WHILE(SELECT ltrim(replace(substring(substring_index(cadena, delimitador, @pocision), length(substring_index(cadena, delimitador, @pocision - 1)) + 1), delimitador, ''))) <> '' DO
		
		INSERT INTO resultados SELECT ltrim(replace(substring(substring_index(cadena, delimitador, @pocision), length(substring_index(cadena, delimitador, @pocision - 1)) + 1), delimitador, ''));
	
	SET @pocision=@pocision+1;
	
	END WHILE;
	
	RETURN 1;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS get_permisos;

DELIMITER //
CREATE PROCEDURE get_permisos(codigo VARCHAR(255), usuario INT)
BEGIN

DROP TABLE IF EXISTS Funciones;
CREATE TEMPORARY TABLE Funciones (id INT,fun INT, codigo VARCHAR(255),pantalla VARCHAR(100)); 

SET @tipo_usu= (SELECT usu_tipo FROM wf_usuarios WHERE usu_id=usuario);
SET @fun_id = (SELECT fun_id FROM wf_funciones WHERE fun_codigo=codigo AND fun_baja=0);
SET @pantalla = (SELECT fun_nombre FROM wf_funciones WHERE fun_codigo=codigo AND fun_baja=0);
SET @count=0;

INSERT INTO Funciones VALUES(@count,@fun_id,codigo,@pantalla);

IF(@tipo_usu='A') THEN
	WHILE @count <= (SELECT MAX(id) FROM Funciones) DO
		
		INSERT INTO Funciones 
		SELECT (SELECT MAX(id) FROM Funciones)+ROW_NUMBER()OVER(ORDER BY (SELECT NULL)),
			fun_id,
			fun_codigo,
			fun_nombre
		FROM wf_funciones 
		WHERE fun_padre=(SELECT fun FROM Funciones WHERE id=@count) AND fun_baja=0;
		
		SET @count=@count+1;
		
	END WHILE;
ELSE
	WHILE @count <= (SELECT MAX(id) FROM Funciones) DO
		
		INSERT INTO Funciones 
		SELECT (SELECT MAX(id) FROM Funciones)+ ROW_NUMBER() OVER(ORDER BY (SELECT NULL)),
			fun_id,
			fun_codigo,
			fun_nombre
		FROM wf_funciones 
			INNER JOIN wf_asignaciones ON asi_fun=fun_id 
			INNER JOIN wf_usuarios ON usu_id=asi_usu OR asi_equ IN (SELECT equ_id FROM wf_equipos INNER JOIN wf_miembros ON mie_equ=equ_id WHERE mie_usu=usu_id AND mie_baja=0 AND equ_baja=0)
		WHERE fun_padre=(SELECT fun FROM Funciones WHERE id=@count) AND usu_id=usuario AND asi_baja=0 AND usu_baja=0 AND fun_baja=0;
		
		SET @count=@count+1;
		
	END WHILE;
END IF;

SELECT * FROM Funciones ORDER BY fun DESC;
DROP TABLE Funciones;

END //
DELIMITER ;
