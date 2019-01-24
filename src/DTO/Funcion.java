package DTO;

public class Funcion
{
	private int fun;
	private String nombre;
	private String codigo;
	
	public Funcion(int id, String nombre, String codigo)
	{
		this.fun = id;
		this.nombre = nombre;
		this.codigo=codigo;
	}

		public Funcion(String string)
	{
			this.nombre = "";
			this.codigo=string;
	}

		public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public int getFun()
	{
		return fun;
	}

	public void setFun(int fun)
	{
		this.fun = fun;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	@Override
	public String toString()
	{
		return nombre;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcion other = (Funcion) obj;
		if (codigo == null)
		{
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	

}
