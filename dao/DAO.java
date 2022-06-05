package dao;
import java.util.List;

import Excepciones.DAOException;
import entidades.Usuario;

public interface DAO <I>{

	public List<Usuario> listar() throws DAOException;
	public void insertar(I v) throws DAOException;
	public void modificar(I v) throws DAOException;
	public void eliminar(I v) throws DAOException;
}
