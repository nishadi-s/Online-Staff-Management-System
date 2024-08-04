package leaving_Emp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static String url="jdbc:mysql://localhost:3306/leaving_emp"; // URL for the database
	private static String userName="root"; // Username for database access
	private static String password="200160200546"; // Password for database access
	private static Connection con;  // Connection object for database
	
	
	// Method to establish a connection to the database
	public static Connection getConnection()
	{
	try {
		
		// Load the MySQL JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		
		
		// Establish a connection using the provided URL, username, and password
		con = DriverManager.getConnection(url,userName,password);
	}
	
	catch (Exception e)
	{
		// If an exception occurs, print an error message
		System.out.println("Database connection is not successful!!!");
	}
	return con; // Return the established connection
	}
		
}
