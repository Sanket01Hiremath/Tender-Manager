package DBUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	private static String url;
    private static String driverName;
    private static String username;
    private static String password;
	static {
        ResourceBundle rb= ResourceBundle.getBundle("TenderManagement");

        url= rb.getString("db.url");
        driverName= rb.getString("db.drivername");
        username= rb.getString("db.username");
        password= rb.getString("db.password");
    }
	public static Connection getConnection() { 
		Connection conn=null;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("--------------------------------------------------------------");
            System.out.println("                   Driver Connection Failed                   ");
            System.out.println("Error: "+e.getMessage());
            System.out.println("--------------------------------------------------------------");
		}
		
		try {
			conn=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			System.out.println("--------------------------------------------------------------");
            System.out.println("                       Connection Failed                      ");
            System.out.println("Error: "+e.getMessage());
            System.out.println("--------------------------------------------------------------");
		}
		return conn;
	}
}
