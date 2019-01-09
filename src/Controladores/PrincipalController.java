package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Main.AdminPDD;
import Main.Main;
import Pantallas.frmPrincipal;

public class PrincipalController implements ActionListener {
	
	private frmPrincipal ventana;
	private AdminPDD modelo;
	private static final String name = "Principal";

	public PrincipalController(frmPrincipal ventana, AdminPDD admin) {
		this.ventana = ventana;
		this.modelo=admin;
		this.ventana.getItmCerrarSesion().addActionListener(this);
		this.ventana.getItmSalir().addActionListener(this);
		this.verificarPermisos(admin);
	}
	
	private void verificarPermisos(AdminPDD admin) {
		ArrayList<String> per=this.modelo.Permisos(name);
		this.ventana.getMnNewMenu_1().setVisible(per.contains((String)"Principal.cosa"));
	}

	public void inicializar() {
		this.ventana.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.ventana.getItmCerrarSesion()) {
			this.ventana.dispose();
			Main.main(null);
		}else if(e.getSource()==this.ventana.getItmSalir()) {
			this.ventana.dispose();
		}
		
	}
}
