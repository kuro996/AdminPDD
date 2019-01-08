package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Conexion.Conexion;
import Main.AdminPDD;
import Main.Main;
import Pantallas.frmLogin;
import Pantallas.frmPrincipal;

public class LoginController implements ActionListener {

	private frmLogin screen;
	private AdminPDD modelo;

	public LoginController(frmLogin formularioLogin, AdminPDD admin) {
		this.modelo = admin;
		this.screen = formularioLogin;
		this.screen.getBtnIngresar().addActionListener(this);
		this.screen.getBtnCancelar().addActionListener(this);
	}

	public void inicializar() {
		this.screen.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.screen.getBtnIngresar()) {
			if (modelo.validarUsuario(this.screen.getTextUsu().getText().trim(),
					this.screen.getTextPass().getText().trim())) {
				this.screen.dispose();
				PrincipalController principal = new PrincipalController(new frmPrincipal());
				principal.inicializar();
			}

		} else if (e.getSource() == this.screen.getBtnCancelar()) {
			this.screen.dispose();
		}

	}

}
