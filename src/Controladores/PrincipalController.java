package Controladores;

import java.awt.AWTEvent;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Main.AdminPDD;
import Main.main;
import Pantallas.frmBusquedaP;
import Pantallas.frmEquipos;
import Pantallas.frmPermisos;
import Pantallas.frmPrincipal;
import Pantallas.frmUsuarios;

public class PrincipalController implements ActionListener, WindowListener
{

	private frmPrincipal ventana;
	private AdminPDD modelo;
	private static final String name = "Principal";

	public PrincipalController(frmPrincipal ventana, AdminPDD admin)
	{
		this.ventana = ventana;
		this.modelo = admin;
		this.ventana.getItmCerrarSesion().addActionListener(this);
		this.ventana.getBtnSalir().addActionListener(this);
		this.ventana.getBtnPermisos().addActionListener(this);
		this.ventana.getBtnBusquedaP().addActionListener(this);
		this.ventana.addWindowListener(this);

		this.verificarPermisos(admin);
	}

	private void verificarPermisos(AdminPDD admin)
	{
		ArrayList<String> per = this.modelo.Permisos(name);

		this.ventana.getBtnPermisos().setVisible(per.contains((String) "Principal.Seguridad.Permisos"));
		this.ventana.getBtnBusquedaP().setVisible(per.contains((String) "Principal.Acciones.BusquedaP"));
	}

	public void inicializar()
	{
		Image img = this.modelo.getUsulog().getImagen().getImage();
		this.ventana.getLblNombre()
				.setText(this.modelo.getUsulog().getApellido() + " ," + this.modelo.getUsulog().getNombre());
		this.ventana.getLblCargo().setText("(" + this.modelo.getUsulog().getTipo() + ")");
		this.ventana.setVisible(true);

		ImageIcon img2 = new ImageIcon(img.getScaledInstance(this.ventana.getLblFoto().getWidth() + 10,
				this.ventana.getLblFoto().getHeight() + 10, Image.SCALE_FAST));
		this.ventana.getLblFoto().setIcon(img2);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.ventana.getItmCerrarSesion() && cerrar() == 0)
		{
			this.ventana.dispose();
			main.main(null);
		} else if (e.getSource() == this.ventana.getBtnSalir() && cerrar() == 0)
		{
			this.ventana.dispose();
		} else if (e.getSource() == this.ventana.getBtnPermisos())
		{
			PermisoController per = new PermisoController(new frmPermisos(), this.modelo);
			per.inicializar();
		} else if (e.getSource() == this.ventana.getBtnBusquedaP())
		{
			BusquedaPController bp = new BusquedaPController(new frmBusquedaP(), this.modelo);
			bp.inicializar();
		}

	}

	private int cerrar()
	{
		return JOptionPane.showConfirmDialog(this.ventana, "¿Seguro que desea salir?", "Salir de AdminPDD",
				JOptionPane.YES_NO_OPTION, 1);
	}

	@Override
	public void windowActivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0)
	{

	}

	@Override
	public void windowDeactivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		if (this.cerrar() == 0)
			this.ventana.dispose();
	}
}
