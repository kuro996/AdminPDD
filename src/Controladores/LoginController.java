package Controladores;

import Pantallas.frmLogin;

public class LoginController {

	private frmLogin screen;
	
	public LoginController(frmLogin formularioLogin) {
		this.screen=formularioLogin;
	}

	public void inicializar() {
		System.out.println("asd");
		this.screen.setBounds(100, 100, 450, 300);
		this.screen.setVisible(true);
		
	}

}
