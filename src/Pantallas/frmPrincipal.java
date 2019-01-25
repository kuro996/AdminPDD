package Pantallas;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Componentes.CLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class frmPrincipal extends JFrame{
	
	private JMenuItem itmCerrarSesion;
	private JMenuItem itmSalir;
	private JMenu mnArchivo;
	private JMenu mnSeguridad;
	private JMenuBar menuSup;
	private JMenuItem itmPermisos;
	private CLabel LblFoto;
	private JPanel panel;
	private JMenuItem itmUsuarios;
	private JMenuItem itmEquipos;
	private JMenu mnBackUpDatos;
	private JMenuItem itmExportar;
	private JMenuItem itmImportar;
	
	public frmPrincipal() {
			
		setTitle("Administracion PDD Jos\u00E9 C. Paz");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		this.setBounds(0, 0, t.getScreenSize().width, t.getScreenSize().height);
		
		panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(1474)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(0)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(755))
		);
		
		LblFoto = new CLabel();
		LblFoto.setToolTipText("");
		LblFoto.setVerticalAlignment(SwingConstants.BOTTOM);
		LblFoto.setIconTextGap(0);
		LblFoto.setVerticalTextPosition(SwingConstants.BOTTOM);
		LblFoto.setText("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(3)
					.addComponent(LblFoto, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(LblFoto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		menuSup = new JMenuBar();
		setJMenuBar(menuSup);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setToolTipText("");
		mnArchivo.setName("");
		menuSup.add(mnArchivo);
		
		itmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mnArchivo.add(itmCerrarSesion);
		
		mnBackUpDatos = new JMenu("Back Up Datos");
		mnArchivo.add(mnBackUpDatos);
		
		itmExportar = new JMenuItem("Exportar");
		mnBackUpDatos.add(itmExportar);
		
		itmImportar = new JMenuItem("Importar");
		mnBackUpDatos.add(itmImportar);
		
		itmSalir = new JMenuItem("Salir");
		mnArchivo.add(itmSalir);
		
		mnSeguridad = new JMenu("Seguridad");
		menuSup.add(mnSeguridad);
		
		itmUsuarios = new JMenuItem("Usuarios");
		mnSeguridad.add(itmUsuarios);
		
		itmEquipos = new JMenuItem("Equipos");
		itmEquipos.setActionCommand("Equipos");
		mnSeguridad.add(itmEquipos);
		
		itmPermisos = new JMenuItem("Permisos");
		mnSeguridad.add(itmPermisos);
				
	}


	public JMenu getMnArchivo() {
		return mnArchivo;
	}

	public void setMnArchivo(JMenu mnArchivo) {
		this.mnArchivo = mnArchivo;
	}

	public JMenu getMnSeguridad1() {
		return mnSeguridad;
	}

	public void setMnSeguridad1(JMenu Seguridad) {
		this.mnSeguridad = Seguridad;
	}


	public void setMenuBar(JMenuBar menuBar) {
		this.menuSup = menuBar;
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

	public JMenuItem getItmPermisos() {
		return itmPermisos;
	}

	public void setItmPermisos(JMenuItem mntmPermisosPorUsuarios) {
		this.itmPermisos = mntmPermisosPorUsuarios;
	}


	public CLabel getLblFoto()
	{
		return LblFoto;
	}


	public void setLblFoto(CLabel lblFoto)
	{
		LblFoto = lblFoto;
	}


	public JMenuItem getItmUsuarios() {
		return itmUsuarios;
	}


	public JMenuItem getItmEquipos() {
		return itmEquipos;
	}


	public JMenuItem getItmExportar() {
		return itmExportar;
	}


	public JMenuItem getItmImportar() {
		return itmImportar;
	}


	public JMenu getMnBackUpDatos() {
		return mnBackUpDatos;
	}


}
