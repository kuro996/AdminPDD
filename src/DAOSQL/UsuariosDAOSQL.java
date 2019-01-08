package DAOSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;

public class UsuariosDAOSQL {
	
	private static final String insert = "";
	private static final String delete = "";
	private static final String readall = "";
	private static final String update = "";
	private static final String validar="CALL validar_usu(?,?);";
	
	
	public static boolean validar(String mail, String pass) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		int resultados=0;
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(validar);
			statement.setString(1, mail);
			statement.setString(2, pass);
			resultSet = statement.executeQuery();
			
			while (resultSet.next())
			{
				resultados++;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
		
		return resultados>0;		
	}
	
	

}
