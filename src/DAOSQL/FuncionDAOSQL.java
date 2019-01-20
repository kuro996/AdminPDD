package DAOSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import DTO.Funcion;

public class FuncionDAOSQL
{
	private static final String insert = "";
	private static final String delete = "";
	private static final String update = "";
	private static final String validar = "";
	private static final String readAll = "SELECT fun_id,fun_nombre,fun_codigo from wf_funciones WHERE fun_padre=(SELECT fun_id from wf_funciones WHERE fun_codigo=?);";
	private static final String permisos = "CALL get_permisos(?,?);";

	public static ArrayList<Funcion> permisos(String pantalla, int usuario)
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

}
