package Controladores;

import Pantallas.frmPrincipal;

public class PrincipalController {
	
	private frmPrincipal ventana;

	public PrincipalController(frmPrincipal ventana) {
		this.ventana = ventana;
	}
	
	public void inicializar() {
		this.ventana.setVisible(true);
	}
}
