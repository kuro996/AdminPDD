package Main;


import Conexion.Conexion;
import DAOSQL.UsuariosDAOSQL;

public class AdminPDD {

	public boolean logiado;
	private UsuariosDAOSQL usu;
	
	public AdminPDD() {
		this.logiado=false;
		this.usu = new UsuariosDAOSQL();
	}

	public boolean validarUsuario(String mail, String pass) {
		return UsuariosDAOSQL.validar(mail, pass);		
	}
}
