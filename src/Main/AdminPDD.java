package Main;


import java.util.ArrayList;

import DAOSQL.EquiposDAOSQL;
import DAOSQL.FuncionDAOSQL;
import DAOSQL.UsuariosDAOSQL;
import DTO.Equipo;
import DTO.Funcion;
import DTO.Usuario;

public class AdminPDD {

	public boolean logiado;
	private UsuariosDAOSQL usu;
	private EquiposDAOSQL equ;
	private Usuario usulog;
	private FuncionDAOSQL fun;
	
	public AdminPDD() {
		this.logiado=false;
		this.usu = new UsuariosDAOSQL();
		this.equ= new EquiposDAOSQL();
		this.fun=new FuncionDAOSQL();
	}

	public Usuario validarUsuario(String mail, String pass) {
		return UsuariosDAOSQL.validar(mail, pass);		
	}

	public ArrayList<String> Permisos(String name) {
		return fun.permisosS(name, this.usulog.getId());
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

	public ArrayList<Funcion> obtenerHijos(String string)
	{
		return fun.readAll(string);
	}

	public ArrayList<Funcion> obtenerPermisos(int id)
	{
		return fun.permisos("Principal", this.usulog.getId());
		
	}	
	
}
