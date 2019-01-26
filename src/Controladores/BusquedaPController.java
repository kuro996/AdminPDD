package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Conexion.Propiedades;
import Main.AdminPDD;
import Pantallas.frmBusquedaP;

public class BusquedaPController implements ActionListener
{
	private final static String name = "Principal.Acciones.BusquedaP";
	private frmBusquedaP ventana;
	private AdminPDD modelo;
	private ArrayList<String> grabadas;
	private ArrayList<String> predicas = new ArrayList<String>();

	public BusquedaPController(frmBusquedaP frmBusquedaP, AdminPDD modelo2)
	{
		this.ventana = frmBusquedaP;
		this.modelo = modelo2;
		this.ventana.getBtnExaminar().addActionListener(this);
		this.ventana.getBtnMostrarEnCarpeta().addActionListener(this);
	}

	public void inicializar()
	{
		// this.grabadas=this.modelo.predicasGrabadas();
		this.grabadas = new ArrayList<String>();
		this.grabadas.add("22-01-2019;19HS;Predica 1;Predicador 1.txt");

		verificarPermisos();
		String path = "Configuracion\\base.properties";

		if (Propiedades.getPropertyValue("direccionPre", path) == null)
		{
			this.ventana.getBtnExaminar().doClick();
		} else
		{
			this.ventana.getTextDireccion().setText(Propiedades.getPropertyValue("direccionPre", path));
			llenarTabla();
		}

		this.ventana.setVisible(true);
	}

	private void verificarPermisos()
	{
		ArrayList<String> per = this.modelo.Permisos(name);

		this.ventana.getPanelDireccion().setVisible(per.contains((String) "BusquedaP.EditarDireccion"));

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.ventana.getBtnExaminar())
		{
			JFileChooser archivo = new JFileChooser();
			archivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			archivo.showOpenDialog(archivo);

			if (archivo.getSelectedFile() != null)
			{
				this.ventana.getTextDireccion().setText(archivo.getSelectedFile().toString());
				String path = "Configuracion\\base.properties";
				Propiedades.setPropertyValue("direccionPre", path, archivo.getSelectedFile().toString());

				this.llenarTabla();
			}
		} else if (e.getSource() == this.ventana.getBtnMostrarEnCarpeta())
		{
			Runtime r = Runtime.getRuntime();
			Process p = null;

			try
			{
				int row = this.ventana.getTableArchivos().getSelectedRow();
				p = r.exec(
						"explorer.exe /select," + this.ventana.getTextDireccion().getText() + "\\" + predicas.get(row));
			} catch (Exception x)
			{
				System.out.println("Error al ejecutar");
			}
		}

	}

	private void llenarTabla()
	{
		File dir = new File(this.ventana.getTextDireccion().getText());

		String[] ficheros = dir.list(new FilenameFilter()
		{

			@Override
			public boolean accept(File f, String s)
			{
				if (new File(f.toString() + "\\" + s).isDirectory())
				{
					return false;
				}

				return s.substring(s.lastIndexOf('.')).equals(".txt");
			}
		});

		if (ficheros == null)
			JOptionPane.showMessageDialog(this.ventana, "No hay ficheros en el directorio especificado", "Aviso", 1);
		else
		{
			DefaultTableModel tabla = (DefaultTableModel) this.ventana.getTableArchivos().getModel();
			ArrayList<Object[]> filas = new ArrayList<Object[]>();
			for (int x = 0; x < ficheros.length; x++)
			{
				String name = ficheros[x].toString();
				String[] split = name.split(";");
				predicas.add(name);
				filas.add(new Object[] { split[2], split[3].substring(0, split[3].lastIndexOf('.')), split[0], split[1],
						this.grabadas.contains((String) name) });
			}

			for (Object[] u : filas)
			{
				tabla.addRow(u);
			}
		}
	}

}
