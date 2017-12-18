package lab.persistent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorManager {
	public static Connection myConn = null;
	static Properties p;


	public static Connection getConnection() {
		if(myConn == null) {
			init();
		}
		return myConn;
	}
	
	private static void init(){
		setDataForConnection();
		try {
			myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
		} catch (SQLException e) {
			e.printStackTrace(); // the best way to write it in log. Bad practice to use printStackTrace(); 
		}
	}
	
	private static void setDataForConnection() {
		p  = new Properties();
		p.put("user", "root");
		p.put("password", "135135aa");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/mydb");
	}
	
}
