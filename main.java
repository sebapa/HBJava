//import java.sql.SQLException;

public class main {
	public static void main (String[] args) {
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setId(31563322);
		nuevoUsuario.setNombre("Armando");
		nuevoUsuario.setApellido("Linares");
		UsuarioDAO cons = new H2UsuarioDAO();
		cons.insertar(nuevoUsuario);
		cons.listar();

	}
}
