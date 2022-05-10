import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2UsuarioDAO implements UsuarioDAO{

	@Override
	public void listar() {
		Connection c = DBManager.conectar();
		try {
			String query = "select * from USUARIO";
			Statement statement = c.createStatement();
			ResultSet set = statement.executeQuery(query);
			while(set.next()) {
				int id = set.getInt("id");
				String nom = set.getString("nombre");
				String ape = set.getString("apellido");
				System.out.println(id + " " + " " + nom + " " + ape);
				}
			set.close();
			statement.close();
		}catch (SQLException e){
				e.printStackTrace();
			
		}finally {
			try {
					c.close();
			}catch (SQLException e){
					e.printStackTrace();
			}
		}
		
	}

	@Override
	public void insertar(Usuario v) {
		Connection c = DBManager.conectar();
		String query = "insert into USUARIO values ("+ v.getId() +",'"+ v.getNombre() + "','"+ v.getApellido() + "')";
		try {
			Statement statement = c.createStatement();
			statement.executeUpdate(query);
			statement.close();
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			try {
				c.close();
		}catch (SQLException e){
				e.printStackTrace();
			}			
		}
		
	}

	@Override
	public void modificar(Usuario v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Usuario v) {
		// TODO Auto-generated method stub
		
	}
}
