package Controladores;

import Main.AdminPDD;
import Pantallas.frmEquipos;
import Pantallas.frmUsuarios;

public class EquiposController {

	private frmEquipos ventana;
	private AdminPDD modelo;
	
	public EquiposController(frmEquipos frmEquipos, AdminPDD modelo) {
		this.ventana=frmEquipos;
		this.modelo=modelo;
	}
	
	public void inicializar() {
		this.ventana.setVisible(true);
	}

}
