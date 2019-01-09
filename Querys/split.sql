use prueba55;
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


DROP TABLE IF EXISTS resultados;
SET @res=(select strSplit('1,2,3,4',','));
select * from resultados;