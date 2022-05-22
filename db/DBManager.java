package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

//	private static final String DBDriver = "org.h2.Driver";
	private static final String DBUrl = "jdbc:h2:/Users/sebamac/eclipse-workspace/HomeBanking";
	private static final String DBUser = "sa";
	private static final String DBPass = "sa";
	
	private static Connection c = null;
	
	public static Connection conectar() {
//		Connection c = null;
//		try {
//		     Class.forName("org.h2.Driver");
//		} catch (ClassNotFoundException e) {
//		     e.printStackTrace();
//		}
		try {
		c = DriverManager.getConnection(DBUrl, DBUser, DBPass);
		} catch (SQLException e) {
		     e.printStackTrace();
		     System.exit(0);
		}
		return c;
	}
	
//	public void cerrar() throws SQLException {
//		if (c != null)
//			c.close();
//	}
//	
}
