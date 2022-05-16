import java.util.List;

public interface DAO <I>{

	public List<Usuario> listar();
	public void insertar(I v);
	public void modificar(I v);
	public void eliminar(I v);
}
