package dao;
import java.util.List;

import entidades.Usuario;

public interface DAO <I>{

	public List<Usuario> listar();
	public void insertar(I v);
	public void modificar(I v);
	public void eliminar(I v);
}
