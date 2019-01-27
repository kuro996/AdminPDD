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
import java.awt.Rectangle;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class frmPrincipal extends JFrame{
	private JLabel LblFoto;
	private JLabel lblNombre;
	private JLabel lblCargo;
	private JButton btnPerfil;
	private JButton btnCerrarSesion;
	private JButton btnCambiarCon;
	private JButton btnPermisos;
	private JButton btnBuscarPredicas;
	private JButton btnSalir;
	private JLabel lblLogo;
	
	
	public frmPrincipal() { 
			
		setTitle("Administracion PDD Jos\u00E9 C. Paz");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		this.setBounds(0, 0, t.getScreenSize().width, t.getScreenSize().height);
		
		LblFoto = new JLabel();
		LblFoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		LblFoto.setVerticalTextPosition(SwingConstants.BOTTOM);
		LblFoto.setVerticalAlignment(SwingConstants.BOTTOM);
		LblFoto.setToolTipText("");
		LblFoto.setText("");
		LblFoto.setIconTextGap(0);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		lblNombre = new JLabel("sads");
		lblNombre.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombre.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCargo = new JLabel("xz");
		lblCargo.setVerticalTextPosition(SwingConstants.TOP);
		lblCargo.setVerticalAlignment(SwingConstants.TOP);
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnPerfil = new JButton("Mi Perfil");
		
		btnCambiarCon = new JButton("Cambiar Contrase\u00F1a");
		
		btnCerrarSesion = new JButton("Cerrar Sesi\u00F2n");
		
		btnPermisos = new JButton("Permisos");
		
		btnBuscarPredicas = new JButton("Buscar Predicas");
		
		btnSalir = new JButton("Salir");
		
		lblLogo = new JLabel("Logo");
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1360, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(LblFoto, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
							.addGap(24))
						.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
						.addComponent(lblCargo, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(btnPerfil, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addGap(32))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(btnCambiarCon, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addGap(32))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(btnCerrarSesion, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addGap(32))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(69)
							.addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addGap(72)))
					.addGap(4)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnPermisos, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(btnBuscarPredicas, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(882))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
					.addGap(1305))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuscarPredicas)
						.addComponent(btnPermisos)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(LblFoto, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(lblNombre)
							.addGap(6)
							.addComponent(lblCargo)
							.addGap(18)
							.addComponent(btnPerfil)
							.addGap(6)
							.addComponent(btnCambiarCon)
							.addGap(6)
							.addComponent(btnCerrarSesion)
							.addGap(6)
							.addComponent(btnSalir)
							.addGap(348))
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 671, GroupLayout.PREFERRED_SIZE)))
		);
		getContentPane().setLayout(groupLayout);
				
	}



	public JButton getItmCerrarSesion() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesion(JButton itmCerrarSesion) {
		this.btnCerrarSesion = itmCerrarSesion;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton itmSalir) {
		this.btnSalir = itmSalir;
	}

	public JButton getBtnPermisos() {
		return btnPermisos;
	}

	public void setBtnPermisos(JButton mntmPermisosPorUsuarios) {
		this.btnPermisos = mntmPermisosPorUsuarios;
	}


	public JLabel getLblFoto()
	{
		return LblFoto;
	}


	public void setLblFoto(JLabel lblFoto)
	{
		LblFoto = lblFoto;
	}

	public JButton getBtnBusquedaP()
	{
		return btnBuscarPredicas;
	}



	public JLabel getLblNombre()
	{
		return lblNombre;
	}


	public void setLblNombre(JLabel lblNombre)
	{
		this.lblNombre = lblNombre;
	}


	public JLabel getLblCargo()
	{
		return lblCargo;
	}


	public void setLblCargo(JLabel lblCargo)
	{
		this.lblCargo = lblCargo;
	}
}
