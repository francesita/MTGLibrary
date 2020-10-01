import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;


public class DatabaseConnection {
	public static Connection getConnection() {
		String url, user, password;
		//Registering JBDC driver
		try {
			FileInputStream file = new FileInputStream("MTGLibrary/src/Database.properties");
			
			Properties prop = new Properties();
			prop.load(file);
			
			url = prop.getProperty("URL");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
			//get connection using DriverManager class
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
			
		}catch(SQLException | IOException ex){
			System.out.println("Connection not established");
			System.exit(0);
			return null;
		}
		
		//Database URL information


	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	

}
