package DTO;

public class Usuarios {
	
	private int id;
	private String nombre;
	private String apellido;
	private String mail;
	private String obs;
	
	public Usuarios(int id, String nombre, String apellido, String mail, String obs) {
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.mail=mail;
		this.obs=obs;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public int getId() {
		return id;
	}

	public static void validar(String mail2, String pass) {
		
	}

}
