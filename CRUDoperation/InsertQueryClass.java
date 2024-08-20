package CRUDoperation;
import java.sql.Connection;

//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.SQLException;
import JDBCUtil.JDBCUtilClass;
import java.util.Scanner;

public class InsertQueryClass {

	public static void main(String[] args) {
		
		Connection connection=null;
//		Statement statement=null;
		PreparedStatement preparedStatement=null;
		// connection baar baar use karenge toh isliye iska ak variable bana liya hai
		// aur variable ko initialize karna hota hai isliye null se kiya hai;
		
		Scanner sc=new Scanner(System.in);

		
		try {
			connection=JDBCUtilClass.getJDBCConnection();  //import class from jdbcutil package
			if(connection!=null) {
				
//				statement =connection.createStatement();
//
//				String query1= "insert into studentdetail(rollno, name, city) values (7, 'utkarsh', \"lucknow\")";
//				int rowAffected=statement.executeUpdate(query1);
//				if(rowAffected==1) {
//					System.out.println("Query Executed Sucessfully");
//					System.out.println("Row Inserted");
//				}
//				else {
//					System.out.println("Not Executed");
//				}
				
				String query1="insert into studentdetail(name, rollno, city) values(?,?,?)";
				preparedStatement=connection.prepareStatement(query1); // it take string as argument
				
				if(preparedStatement!=null) {
					
//					preparedStatement.setString(1, "Gagan");
//					preparedStatement.setInt(2, 18);
//					preparedStatement.setString(3, "Canada");
					// we pass column and value correspond to that column
					
					
					System.out.println("Enter name: ");
					String name=sc.nextLine();
					System.out.println("Enter rollno");
					int rollno=sc.nextInt();
					sc.nextLine(); // to consume the leftover newline
					System.out.println("Enter city");
					String city=sc.nextLine();
					
					preparedStatement.setInt(2, rollno);
					preparedStatement.setString(1, name);
					preparedStatement.setString(3, city);
					int rowAffected=preparedStatement.executeUpdate();
					if(rowAffected==1) {
						System.out.println("row inserted");
					}
					else {
						System.out.println("no");
					}
				}
			}
			
			
		}
		catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
//				JDBCUtilClass.closeResources(connection, statement);
				JDBCUtilClass.closeResources(connection, preparedStatement);
				sc.close(); 
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

	}

}
