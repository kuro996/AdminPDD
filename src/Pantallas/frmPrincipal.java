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

public class frmPrincipal extends JFrame{
	
	private JMenuItem itmCerrarSesion;
	private JMenuItem itmSalir;
	private JMenu mnArchivo;
	private JMenu mnSeguridad;
	private JMenuBar menuSup;
	private JMenuItem itmPermisosPorUsuarios;
	private CLabel LblFoto;
	private JLabel lblNombre;
	
	public frmPrincipal() {
			
		setTitle("Administracion PDD Jos\u00E9 C. Paz");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		this.setBounds(0, 0, t.getScreenSize().width, t.getScreenSize().height);
		
		LblFoto = new CLabel();
		LblFoto.setIconTextGap(0);
		LblFoto.setVerticalTextPosition(SwingConstants.TOP);
		LblFoto.setText("");
		
		lblNombre = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(1256)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
						.addComponent(LblFoto, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(LblFoto, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNombre)
					.addContainerGap(613, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		menuSup = new JMenuBar();
		setJMenuBar(menuSup);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setToolTipText("");
		mnArchivo.setName("");
		menuSup.add(mnArchivo);
		
		itmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mnArchivo.add(itmCerrarSesion);
		
		itmSalir = new JMenuItem("Salir");
		mnArchivo.add(itmSalir);
		
		mnSeguridad = new JMenu("Seguridad");
		menuSup.add(mnSeguridad);
		
		itmPermisosPorUsuarios = new JMenuItem("Permisos");
		mnSeguridad.add(itmPermisosPorUsuarios);
				
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
		return itmPermisosPorUsuarios;
	}

	public void setItmPermisos(JMenuItem mntmPermisosPorUsuarios) {
		this.itmPermisosPorUsuarios = mntmPermisosPorUsuarios;
	}


	public CLabel getLblFoto()
	{
		return LblFoto;
	}


	public void setLblFoto(CLabel lblFoto)
	{
		LblFoto = lblFoto;
	}


	public JLabel getLblNombre()
	{
		return lblNombre;
	}


	public void setLblNombre(JLabel lblNombre)
	{
		this.lblNombre = lblNombre;
	}
	
	

}
