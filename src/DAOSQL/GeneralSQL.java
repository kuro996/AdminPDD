package DAOSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;

public class GeneralSQL {
	
	private static final String readall = "CALL get_permisos(?,?);";
	
	public static ArrayList<String> permisos(String pantalla, int usuario) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		ArrayList<String> resultados=new ArrayList<String>();
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setString(1, pantalla);
			statement.setInt(2, usuario);
			resultSet = statement.executeQuery();
			
			while (resultSet.next())
			{
				resultados.add(resultSet.getString(3));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
		
		return resultados;		
	}
}
