package Pantallas;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class frmPrincipal extends JFrame{
	
	JMenuItem itmCerrarSesion;
	JMenuItem itmSalir;
	
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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		itmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mnArchivo.add(itmCerrarSesion);
		
		itmSalir = new JMenuItem("Salir");
		mnArchivo.add(itmSalir);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
				
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

}
