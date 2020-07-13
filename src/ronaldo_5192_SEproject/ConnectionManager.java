package ronaldo_5192_SEproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static String url = "jdbc:sqlite:D:/mySEJavaProject/SEproject.db";
    private static Connection conn;

    public static Connection getConnection() {
    	
		try {
			// create a connection to the database
		    conn = DriverManager.getConnection(url); 
		} 
		catch (SQLException e) {
		    System.out.println(e.getMessage());
		} 
		
		return conn;
    }    
}