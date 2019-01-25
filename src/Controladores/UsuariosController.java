package Controladores;

import Main.AdminPDD;
import Pantallas.frmUsuarios;

public class UsuariosController {
	
	private frmUsuarios ventana;
	private AdminPDD modelo;

	public UsuariosController(frmUsuarios frmUsuarios, AdminPDD modelo2) {
		this.ventana=frmUsuarios;
		this.modelo=modelo2;
	}

	public void inicializar() {
		this.verificarPermisos();
		this.ventana.setVisible(true);
		
	}

	private void verificarPermisos() {
		// TODO Auto-generated method stub
		
	}

}
