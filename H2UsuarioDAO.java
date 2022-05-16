import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class H2UsuarioDAO implements UsuarioDAO{

	@Override
//	public void listar() {
//		Connection c = DBManager.conectar();
//		try {
//			String query = "select * from USUARIO";
//			Statement statement = c.createStatement();
//			ResultSet set = statement.executeQuery(query);
//			while(set.next()) {
//				int id = set.getInt("id");
//				String nom = set.getString("nombre");
//				String ape = set.getString("apellido");
//				System.out.println(id + " " + " " + nom + " " + ape);
//				}
//			set.close();
//			statement.close();
//		}catch (SQLException e){
//				e.printStackTrace();
//			
//		}finally {
//			try {
//					c.close();
//			}catch (SQLException e){
//					e.printStackTrace();
//			}
//		}
//		
//	}
    public List<Usuario> listar() {
    	List<Usuario> resultado = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        Connection c = DBManager.conectar();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);

            
            while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nombre");
				String ape = rs.getString("apellido");
                Usuario u = new Usuario(id, nom, ape);
                resultado.add(u);
//                System.out.println(resultado);

            }
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return resultado;
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
		Connection c = DBManager.conectar();
		String query = "UPDATE USUARIO SET NOMBRE ='"+ v.getNombre() + "', APELLIDO ='"+ v.getApellido() + "' where ID = "+ v.getId();
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
	public void eliminar(Usuario v) {
		Connection c = DBManager.conectar();
		String query = "DELETE FROM USUARIO where ID = "+ v.getId();
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
}
