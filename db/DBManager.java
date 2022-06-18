package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBManager {

	private static final String DBUrl = "jdbc:h2:/Users/sebamac/eclipse-workspace/HomeBanking";
	private static final String DBUser = "sa";
	private static final String DBPass = "sa";
	
	
	public static Connection conectar() {
		Connection c = null;
//		try {
//		     Class.forName("org.h2.Driver");
//		} catch (ClassNotFoundException e) {
//		     e.printStackTrace();
//		}
		try {
		c = DriverManager.getConnection(DBUrl, DBUser, DBPass);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR de DB" +e);
		    System.exit(0);
		}
		return c;
	}
	
}
