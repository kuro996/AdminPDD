package Conexion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Propiedades
{
	public static String getPropertyValue(String propertyKey, String path)
	{
		Properties p = new Properties();
		try
		{
			p.load(new FileReader(path));
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			return "";
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			return "";
		}
		return p.getProperty(propertyKey);
	}

	public static void setPropertyValue(String propertyKey, String path, String valor)
	{
		Properties p = new Properties();
		try
		{
			p.load(new FileReader(path));
			OutputStream oute = new FileOutputStream(path);
			p.setProperty(propertyKey, valor);
			p.store(oute, "");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
