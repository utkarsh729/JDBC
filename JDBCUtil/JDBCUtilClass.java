package JDBCUtil;

import java.sql.Connection;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class JDBCUtilClass {
	
	// task to get the properties from the application file and loading the driver with connection

	public static Connection getJDBCConnection() throws IOException, SQLException {
		
		FileInputStream FIS=new FileInputStream("application.properties");
		
		// Properties is the subclass of hashtable
		Properties P=new Properties();
		P.load(FIS); // load the object of fileinputstream to Properties  object
		
		String url=P.getProperty("url");
		String user=P.getProperty("user");
		String password=P.getProperty("password");
		
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		Connection connection=DriverManager.getConnection(url, user, password);
		return connection;
	}
	
//	public static void closeResources(Connection connection, Statement statement) throws SQLException {
	public static void closeResources(Connection connection, PreparedStatement preparedStatement) throws SQLException {
		// remember always import from java.sql ..otherwise you get some error 
		if(connection!=null) {
			connection.close();			
		}
		if(preparedStatement!=null) {
			preparedStatement.close();	
		}
	
	}
	// method overloading
	public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet rset) throws SQLException {
		// remember always import from java.sql ..otherwise you get some error 
		if(connection!=null) {
			connection.close();			
		}
		if(preparedStatement!=null) {
			preparedStatement.close();	
		}
		if(rset!=null) {
			rset.close();
		}
		
	}
}
