package DAOSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import DTO.Funcion;

public class FuncionDAOSQL
{
	private static final String insert = "CALL dar_permisos(?,?,?);";
	private static final String delete = "";
	private static final String update = "";
	private static final String validar = "";
	private static final String readAll = "CALL permismos_x_pantalla(?);";
	private static final String permisos = "CALL get_permisos(?,?,?,?);";

	public static ArrayList<Funcion> permisos(String pantalla, int usuario, int equipo)
	{
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		ArrayList<Funcion> resultados = new ArrayList<Funcion>();
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(permisos);
			statement.setString(1, pantalla);
			statement.setInt(2, usuario);
			statement.setInt(3, equipo);
			statement.setInt(4, 0);
			resultSet = statement.executeQuery();

			while (resultSet.next())
			{
				resultados.add(new Funcion(resultSet.getInt(2),resultSet.getString(4),resultSet.getString(3)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		conexion.cerrarConexion();

		return resultados;
	}
	
	public static ArrayList<String> permisosS(String pantalla, int usuario)
	{
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		ArrayList<String> resultados = new ArrayList<String>();
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(permisos);
			statement.setString(1, pantalla);
			statement.setInt(2, usuario);
			statement.setInt(3, 0);
			statement.setInt(4, 1);
			
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

	public ArrayList<Funcion> readAll(String fun)
	{
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		ArrayList<Funcion> resultados = new ArrayList<Funcion>();
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			statement.setString(1, fun);
			resultSet = statement.executeQuery();

			while (resultSet.next())
			{
				resultados.add(new Funcion(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		conexion.cerrarConexion();
		return resultados;
	}

	public void darPermisos(int usu, int equ, String ids)
	{
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		ArrayList<Funcion> resultados = new ArrayList<Funcion>();
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, usu);
			statement.setInt(2, equ);
			statement.setString(3, ids);
			resultSet = statement.executeQuery();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		conexion.cerrarConexion();
		
	}

}
