package dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;

//jdbc connections 2 steps we will write here
public class employedb {
	private static String Driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/employe";
	private static String username = "root";
	private static String password = "root";
	private static Connection conn;
	
//	to implement try and catch method there should be a method so getconnection() is created
	public static Connection getconnection() {
		try {
			
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
		
}
