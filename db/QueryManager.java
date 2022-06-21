package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Excepciones.DAOException;

public class QueryManager {


	public static ResultSet EjecutarQuery(String query) throws DAOException {

        Connection c = DBManager.conectar();
		
		Statement s;
		ResultSet rs;

		try {
			s = c.createStatement();
			rs = s.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR dao sql e - CreateStatement: "+ e.getMessage());
			throw new DAOException("Error de SQL", e);
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR dao sql e - CreateStatement: "+ e.getMessage());
				throw new DAOException(e.getMessage());
			}
		}

	}

	public static void EjecutarUpdate(String query) throws DAOException {
		
        Connection c = DBManager.conectar();
		
		Statement s;

		try {
			s = c.createStatement();
			s.executeUpdate(query);
			c.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
				throw new DAOException(e.getMessage());
			}
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR dao sql e - CreateStatement: "+ e.getMessage());
				throw new DAOException(e.getMessage());
			}

		}
		 
	}

}