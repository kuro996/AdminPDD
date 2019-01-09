package Pantallas;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class frmPrincipal extends JFrame{
	
	private JMenuItem itmCerrarSesion;
	private JMenuItem itmSalir;
	private JMenu mnArchivo;
	private JMenu mnSeguridad;
	private JMenuBar menuBar;
	private JMenuItem itmPermisosPorUsuarios;
	
	public frmPrincipal() {
		setTitle("Administracion PDD Jos\u00E9 C. Paz");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		this.setBounds(0, 0, t.getScreenSize().width, t.getScreenSize().height);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1584, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 861, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setToolTipText("");
		mnArchivo.setName("");
		menuBar.add(mnArchivo);
		
		itmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mnArchivo.add(itmCerrarSesion);
		
		itmSalir = new JMenuItem("Salir");
		mnArchivo.add(itmSalir);
		
		mnSeguridad = new JMenu("Seguridad");
		menuBar.add(mnSeguridad);
		
		mntmPermisosPorUsuarios = new JMenuItem("Permisos por Usuarios");
		mnSeguridad.add(mntmPermisosPorUsuarios);
				
	}

	public JMenu getMnArchivo() {
		return mnArchivo;
	}

	public void setMnArchivo(JMenu mnArchivo) {
		this.mnArchivo = mnArchivo;
	}

	public JMenu getMnNewMenu_1() {
		return mnSeguridad;
	}

	public void setMnNewMenu_1(JMenu mnNewMenu_1) {
		this.mnSeguridad = mnNewMenu_1;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenuItem getItmCerrarSesion() {
		return itmCerrarSesion;
	}

	public void setItmCerrarSesion(JMenuItem itmCerrarSesion) {
		this.itmCerrarSesion = itmCerrarSesion;
	}

	public JMenuItem getItmSalir() {
		return itmSalir;
	}

	public void setItmSalir(JMenuItem itmSalir) {
		this.itmSalir = itmSalir;
	}

	public JMenu getMnSeguridad() {
		return mnSeguridad;
	}

	public void setMnSeguridad(JMenu mnSeguridad) {
		this.mnSeguridad = mnSeguridad;
	}

	public JMenuItem getItmPermisosPorUsuarios() {
		return itmPermisosPorUsuarios;
	}

	public void setItmPermisosPorUsuarios(JMenuItem mntmPermisosPorUsuarios) {
		this.itmPermisosPorUsuarios = mntmPermisosPorUsuarios;
	}
	
	

}
