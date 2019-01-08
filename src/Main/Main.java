package Main;
import Conexion.Conexion;
import Controladores.LoginController;
import Pantallas.frmLogin;

public class Main {

	public static void main(String[] args) {
		frmLogin formularioLogin = new frmLogin();
		LoginController ctrLogin = new LoginController(formularioLogin);
		ctrLogin.inicializar();
	}

}
