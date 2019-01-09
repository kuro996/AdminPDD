package Main;


import java.util.ArrayList;

import DAOSQL.GeneralSQL;
import DAOSQL.UsuariosDAOSQL;
import DTO.Usuarios;

public class AdminPDD {

	public boolean logiado;
	private UsuariosDAOSQL usu;
	private Usuarios usulog;
	private GeneralSQL gen;
	
	public AdminPDD() {
		this.logiado=false;
		this.usu = new UsuariosDAOSQL();
	}

	public Usuarios validarUsuario(String mail, String pass) {
		return UsuariosDAOSQL.validar(mail, pass);		
	}

	public ArrayList<String> Permisos(String name) {
		return gen.permisos(name, this.usulog.getId());
	}

	public Usuarios getUsulog() {
		return usulog;
	}

	public void setUsulog(Usuarios usulog) {
		this.usulog = usulog;
	}	
	
}
