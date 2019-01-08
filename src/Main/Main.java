package Main;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controladores.LoginController;
import Pantallas.frmLogin;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdminPDD admin=new AdminPDD();
		frmLogin formularioLogin = new frmLogin();
		LoginController ctrLogin = new LoginController(formularioLogin,admin);
		ctrLogin.inicializar();
	}

}
