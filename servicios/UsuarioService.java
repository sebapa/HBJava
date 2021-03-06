package servicios;

import java.util.List;

import javax.swing.JOptionPane;

import Excepciones.DAOException;
import Excepciones.ServicioException;
import dao.H2UsuarioDAO;
import dao.UsuarioDAO;
import entidades.Usuario;

public class UsuarioService {
	
	private UsuarioDAO ud = new H2UsuarioDAO();

	public void nuevoUsuario (Usuario user) throws ServicioException {
		
		try {
			ud.insertar(user);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "ERROR de ServicioException: " +e);
			throw new ServicioException(e.getMessage());
		}
	}
		
	public void modificarUsuario (Usuario user) throws ServicioException {
		
		try {
			ud.modificar(user);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "ERROR de ServicioException: " +e);
			throw new ServicioException(e.getMessage());
		}
	}
		
	public void eliminarUsuario (Usuario user) throws ServicioException {
		
		try {
			ud.eliminar(user);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "ERROR de ServicioException: " +e);
			throw new ServicioException(e.getMessage());
		}
	}
		
	public List<Usuario> mostrarUsuarios() throws ServicioException {

		List<Usuario> usuarios;
		try {
			usuarios = ud.listar();
			return usuarios;
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "ERROR de ServicioException: " +e);
			throw new ServicioException("Error de Servicio", e);
		}
	}

}

