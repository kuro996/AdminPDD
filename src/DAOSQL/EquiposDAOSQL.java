package DAOSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import DTO.Equipo;
import DTO.Usuario;

public class EquiposDAOSQL
{

	private static final String insert = "";
	private static final String delete = "";
	private static final String readall = "CALL get_equipos();";
	private static final String update = "";
	private static final String validar="";
	
	public static ArrayList<Equipo> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		 ArrayList<Equipo> resultados=new  ArrayList<Equipo>();
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while (resultSet.next())
			{
				resultados.add(new Equipo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
		
		return resultados;
	}
	
}
