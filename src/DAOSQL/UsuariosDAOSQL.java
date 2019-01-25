package DAOSQL;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Conexion.Conexion;
import DTO.Usuario;

public class UsuariosDAOSQL
{

	private static final String insert = "";
	private static final String delete = "";
	private static final String readall = "CALL get_usuarios();";
	private static final String update = "";
	private static final String validar = "CALL validar_usu(?,?);";

	public static Usuario validar(String mail, String pass)
	{
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		Usuario resultados = null;
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(validar);
			statement.setString(1, mail);
			statement.setString(2, pass);
			resultSet = statement.executeQuery();

			while (resultSet.next())
			{
				ImageIcon imagen = null;
				Blob blob = resultSet.getBlob(7);
				if (blob != null)
				{
					byte[] data = blob.getBytes(1, (int) blob.length());
					imagen = new ImageIcon(data, "sada");
				} else
				{
					imagen = new ImageIcon("avatar.jpg");
				}

				resultados =new Usuario(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(5), resultSet.getString(6), resultSet.getString(8), resultSet.getString(9),
						imagen);
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
		ArrayList<Usuario> resultados = new ArrayList<Usuario>();
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next())
			{
				ImageIcon imagen = null;
				Blob blob = resultSet.getBlob(7);
				if (blob != null)
				{
					byte[] data = blob.getBytes(1, (int) blob.length());
					imagen = new ImageIcon(data, "sada");
				} else
				{
					imagen = new ImageIcon("avatar.jpg");
				}

				resultados.add(new Usuario(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(5), resultSet.getString(6), resultSet.getString(8), resultSet.getString(9),
						imagen));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		conexion.cerrarConexion();

		return resultados;
	}

	public ArrayList<ImageIcon> getImagenes()
	{
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		ArrayList<ImageIcon> lista = new ArrayList();
		try
		{
			statement = conexion.getSQLConexion()
					.prepareStatement("SELECT usu_imagen FROM wf_usuarios WHERE usu_imagen IS NOT NULL;");
			resultSet = statement.executeQuery();
			while (resultSet.next())
			{
				Blob blob = resultSet.getBlob(1);
				byte[] data = blob.getBytes(1, (int) blob.length());
				ImageIcon imagen = new ImageIcon(data, "sada");
				lista.add(imagen);
			}
			resultSet.close();
		} catch (Exception ex)
		{

		}
		return lista;
	}

}
