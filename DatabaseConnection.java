import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class to set up database connection
 * @author Frances Laureano De Leon
 * @version 2020-10-01
 */
public class DatabaseConnection {
	public static Connection getConnection() {
		String url, user, password;
		Connection connection = null;
		
		//loading the driver 
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Registering JBDC driver
		try {
			FileInputStream file = new FileInputStream("src/Database.properties");
			
			Properties prop = new Properties();
			prop.load(file);
			
			url = prop.getProperty("URL");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
			//get connection using DriverManager class
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection successful!");
			return connection;
			
		}catch(SQLException | IOException ex){
			System.out.printf(ex + "\n" + "Connection not established");
			System.exit(0);
			return null;
		}
		
	}
	
	public static void main(String[] args) {
			System.out.println(getConnection());

	}
	

}
