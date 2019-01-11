package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Conexion.Conexion;
import Main.AdminPDD;
import Main.Main;
import Pantallas.frmLogin;
import Pantallas.frmPrincipal;

public class LoginController implements ActionListener, KeyListener {

	private frmLogin screen;
	private AdminPDD modelo;

	public LoginController(frmLogin formularioLogin, AdminPDD admin) {
		this.modelo = admin;
		this.screen = formularioLogin;
		this.screen.getTextUsu().addKeyListener(this);
		this.screen.getTextPass().addKeyListener(this);
		this.screen.getBtnIngresar().addActionListener(this);
		this.screen.getBtnCancelar().addActionListener(this);
	}

	public void inicializar() {
		this.screen.setVisible(true);
		this.screen.getTextUsu().setText("libanez");
		this.screen.getTextPass().setText("Kuro1996");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.screen.getBtnIngresar()) {
			this.modelo.setUsulog(modelo.validarUsuario(this.screen.getTextUsu().getText().trim(),
					this.screen.getTextPass().getText().trim()));
			if (this.modelo.getUsulog()!=null) {
				this.screen.dispose();
				PrincipalController principal = new PrincipalController(new frmPrincipal(),modelo);
				principal.inicializar();
			}else {
				JOptionPane.showMessageDialog(screen, "Usuario y/o contraseña incorrecto", "Error de Login", 1);
				this.screen.getTextPass().setText("");
			}

		} else if (e.getSource() == this.screen.getBtnCancelar()) {
			this.screen.dispose();
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
			this.screen.getBtnIngresar().doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
