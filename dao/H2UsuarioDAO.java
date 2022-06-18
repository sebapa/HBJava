package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Excepciones.DAOException;
import db.DBManager;
import db.QueryManager;
import entidades.Usuario;

public class H2UsuarioDAO implements UsuarioDAO{


    public List<Usuario> listar() throws DAOException {
    	
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

            }
        } catch (SQLException e) {
			System.out.println("error dao sql e - CreateStatement: " + e.getMessage());
			throw new DAOException("Error de SQL", e);
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
    			System.out.println("error dao sql e - CreateStatement: " + e1.getMessage());
    			throw new DAOException("Error de SQL", e1);
            }
        }
        return resultado;
    }

	@Override
	public void insertar(Usuario v) throws DAOException{
		String query = "insert into USUARIO values ("+ v.getId() +",'"+ v.getNombre() + "','"+ v.getApellido() + "')";
		QueryManager.EjecutarUpdate(query);
	
	}

	@Override
	public void modificar(Usuario v) throws DAOException {
		Connection c = DBManager.conectar();
		String query = "UPDATE USUARIO SET NOMBRE ='"+ v.getNombre() + "', APELLIDO ='"+ v.getApellido() + "' where ID = "+ v.getId();
		QueryManager.EjecutarUpdate(query);

	}


	@Override
	public void eliminar(Usuario v) throws DAOException{
		Connection c = DBManager.conectar();
		String query = "DELETE FROM USUARIO where ID = "+ v.getId();
		QueryManager.EjecutarUpdate(query);
	
	}
}
