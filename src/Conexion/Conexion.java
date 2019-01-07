package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{
	public static Conexion instancia;
	private Connection connection;

	private Conexion()
	{
		try
		{
			String path = "Configuracion\\base.properties";
			String ip = Propiedades.getPropertyValue("baseIP", path);
			String puerto = Propiedades.getPropertyValue("basePuerto", path);
			String schema = Propiedades.getPropertyValue("baseSchema", path);
			String url = "jdbc:mysql://" + ip + ":" + puerto + "/" + schema + "";
			String username = Propiedades.getPropertyValue("baseUsuario", path);
			String password = Propiedades.getPropertyValue("baseContrasenia", path);
			this.connection = DriverManager.getConnection(url, username, password);
			System.out.println("Conexion exitosa");
		}
		catch (Exception e)
		{
			System.out.println("Conexion fallida");
			throw new RuntimeException("Conexion fallida");
		}
	}

	public static Conexion getConexion()
	{
		if (instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion()
	{
		return this.connection;
	}

	public void cerrarConexion()
	{
		try
		{
			this.connection.close();
			System.out.println("Conexion cerrada");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
