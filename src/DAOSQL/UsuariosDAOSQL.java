package DAOSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;
import DTO.Usuarios;

public class UsuariosDAOSQL {
	
	private static final String insert = "";
	private static final String delete = "";
	private static final String readall = "";
	private static final String update = "";
	private static final String validar="CALL validar_usu(?,?);";
	
	
	public static Usuarios validar(String mail, String pass) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		Usuarios resultados=null;
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(validar);
			statement.setString(1, mail);
			statement.setString(2, pass);
			resultSet = statement.executeQuery();
			
			while (resultSet.next())
			{
				resultados=new Usuarios(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(5), resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
		
		return resultados;		
	}
	
	

}
