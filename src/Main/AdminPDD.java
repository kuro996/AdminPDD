package Main;


import java.util.ArrayList;

import DAOSQL.EquiposDAOSQL;
import DAOSQL.GeneralSQL;
import DAOSQL.UsuariosDAOSQL;
import DTO.Equipo;
import DTO.Usuario;

public class AdminPDD {

	public boolean logiado;
	private UsuariosDAOSQL usu;
	private EquiposDAOSQL equ;
	private Usuario usulog;
	private GeneralSQL gen;
	
	public AdminPDD() {
		this.logiado=false;
		this.usu = new UsuariosDAOSQL();
		this.equ= new EquiposDAOSQL();
	}

	public Usuario validarUsuario(String mail, String pass) {
		return UsuariosDAOSQL.validar(mail, pass);		
	}

	public ArrayList<String> Permisos(String name) {
		return gen.permisos(name, this.usulog.getId());
	}

	public Usuario getUsulog() {
		return usulog;
	}

	public void setUsulog(Usuario usulog) {
		this.usulog = usulog;
	}

	public ArrayList<Usuario> getUsuarios()
	{
		ArrayList<Usuario> usuarios = usu.readAll();
		return usuarios;
	}

	public ArrayList<Equipo> getEquipos()
	{
		
		return this.equ.readAll();
	}	
	
}
