package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Conexion.Conexion;
import Pantallas.frmLogin;

public class LoginController implements ActionListener{

	private frmLogin screen;
	private Conexion con;
	
	public LoginController(frmLogin formularioLogin) {
		this.screen=formularioLogin;
		this.screen.getBtnIngresar().addActionListener(this);
		this.screen.getBtnCancelar().addActionListener(this);
	}

	public void inicializar() {
		this.screen.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.screen.getBtnIngresar()) {
			
		}else if(e.getSource()==this.screen.getBtnCancelar()) {
			this.screen.dispose();
		}
		
	}

}
