package Componentes;

import java.io.File;
import java.io.FilenameFilter;

public class pruebass
{

	public static void main(String[] args)
	{
		File dir = new File("C:\\Users\\Leandro Ibañez\\Downloads");
		String[] ficheros=dir.list(new FilenameFilter()
		{
			
			@Override
			public boolean accept(File f, String s)
			{
				if(new File(f.toString()+"\\"+s).isDirectory())
				{
					return false;
				}
				
				return s.substring(s.lastIndexOf('.')).equals(".docx");
			}
		});
		
		if (ficheros == null)
			  System.out.println("No hay ficheros en el directorio especificado");
			else { 
			  for (int x=0;x<ficheros.length;x++)
			    System.out.println(ficheros[x]);
			}
	}

}
