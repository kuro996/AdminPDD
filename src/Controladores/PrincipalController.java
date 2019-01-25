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
import Main.Main;
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
		this.ventana.getItmSalir().addActionListener(this);
		this.ventana.getItmPermisos().addActionListener(this);
		this.ventana.getItmUsuarios().addActionListener(this);
		this.ventana.getItmEquipos().addActionListener(this);
		this.ventana.getItmImportar().addActionListener(this);
		this.ventana.getItmExportar().addActionListener(this);
		this.ventana.addWindowListener(this);

		this.verificarPermisos(admin);
	}

	private void verificarPermisos(AdminPDD admin)
	{
		ArrayList<String> per = this.modelo.Permisos(name);
		this.ventana.getMnSeguridad().setVisible(per.contains((String) "Principal.Seguridad"));
		this.ventana.getItmPermisos().setVisible(per.contains((String) "Principal.Seguridad.Permisos"));
		this.ventana.getItmUsuarios().setVisible(per.contains((String)"Principal.Seguridad.Usuarios"));
		this.ventana.getItmEquipos().setVisible(per.contains((String)"Principal.Seguridad.Equipos"));
		this.ventana.getMnBackUpDatos().setVisible(per.contains((String)"Principal.BackUpDatos"));
	}

	public void inicializar()
	{
		Image img= this.modelo.getUsulog().getImagen().getImage();
		ImageIcon img2=new ImageIcon(img.getScaledInstance(this.ventana.getLblFoto().getWidth(), this.ventana.getLblFoto().getHeight(), Image.SCALE_FAST));
		this.ventana.getLblFoto().setIcon(img2);

		this.ventana.getLblFoto().setToolTipText(this.modelo.getUsulog().getApellido()+" ,"+this.modelo.getUsulog().getNombre());
		
		this.ventana.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.ventana.getItmCerrarSesion() && cerrar()==0)
		{
			this.ventana.dispose();
			Main.main(null);
		} else if (e.getSource() == this.ventana.getItmSalir() && cerrar()==0)
		{
			this.ventana.dispose();
		} else if (e.getSource() == this.ventana.getItmPermisos())
		{
			PermisoController per = new PermisoController(new frmPermisos(), this.modelo);
			per.inicializar();
		}else if(e.getSource()==this.ventana.getItmUsuarios()) {
			UsuariosController usu= new UsuariosController(new frmUsuarios(),this.modelo);
			usu.inicializar();
		}

	}

	
	private int cerrar() {
		return JOptionPane.showConfirmDialog(this.ventana, "¿Seguro que desea salir?", "Salir de AdminPDD", JOptionPane.YES_NO_OPTION,
				1);
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
		if(this.cerrar()==0) this.ventana.dispose();		
	}
}
