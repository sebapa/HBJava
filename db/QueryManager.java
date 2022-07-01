package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Excepciones.DAOException;

public class QueryManager {


	public static void EjecutarUpdate(String query) throws DAOException {
		
        Connection c = DBManager.conectar();
		
		Statement s;

		try {
			s = c.createStatement();
			s.executeUpdate(query);
			c.commit();
		} catch (SQLException e) {
			System.out.println("error dao sql e - close: " + e.getMessage());
			try {
				c.rollback();
			} catch (SQLException e1) {
				System.out.println("error dao sql e - close: " + e.getMessage());
				throw new DAOException(e.getMessage());
			}
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				System.out.println("error dao sql e - close: " + e.getMessage());
				throw new DAOException(e.getMessage());
			}

		}
		 
	}

}