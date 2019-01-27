package DTO;

import javax.swing.ImageIcon;

public class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
	private String mail;
	private ImageIcon imagen;
	private String login;
	private String tipo;
	private String obs;
	
	public Usuario(int id, String nombre, String apellido, String login, String mail,String tipo, String obs, ImageIcon img) {
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.login=login;
		this.mail=mail;
		this.imagen=img;
		this.tipo=tipo;
		this.obs=obs;
	}
	

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public ImageIcon getImagen()
	{
		return imagen;
	}

	public void setImagen(ImageIcon imagen)
	{
		this.imagen = imagen;
	}

	

}
