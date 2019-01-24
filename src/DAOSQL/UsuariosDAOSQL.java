package DAOSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import DTO.Usuario;

public class UsuariosDAOSQL {
	
	private static final String insert = "";
	private static final String delete = "";
	private static final String readall = "CALL get_usuarios();";
	private static final String update = "";
	private static final String validar="CALL validar_usu(?,?);";
	
	
	public static Usuario validar(String mail, String pass) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		Usuario resultados=null;
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(validar);
			statement.setString(1, mail);
			statement.setString(2, pass);
			resultSet = statement.executeQuery();
			
			while (resultSet.next())
			{
				resultados=new Usuario(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(5), resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
		
		return resultados;		
	}


	public static ArrayList<Usuario> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		 ArrayList<Usuario> resultados=new  ArrayList<Usuario>();
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while (resultSet.next())
			{
				resultados.add(new Usuario(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(5), resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
		
		return resultados;
	}
	
	

}
