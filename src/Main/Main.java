package Main;
import Conexion.Conexion;

public class Main {

	public static void main(String[] args) {
		Conexion c = Conexion.getConexion();
		AdminPDD main= new AdminPDD(c);
	}

}
