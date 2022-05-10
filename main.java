//import java.sql.SQLException;

public class main {
	public static void main (String[] args) {
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setId(31563322);
		nuevoUsuario.setNombre("Armando");
		nuevoUsuario.setApellido("Linar");
		UsuarioDAO cons = new H2UsuarioDAO();
		cons.eliminar(nuevoUsuario);
		cons.listar();

	}
}
