package CRUDoperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;

import JDBCUtil.JDBCUtilClass;
public class SelectQueryClass {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement presmt=null;
		ResultSet rset=null;
		try {
			connection=JDBCUtilClass.getJDBCConnection();
			
			String selectQuery1="select * from studentdetail where rollno=?";
			// ? ye isliye use karte hai kyuki hum value dynamically pass karenge
			presmt=connection.prepareStatement(selectQuery1);
			
			if(presmt!=null) {
				presmt.setInt(1, 3); // rollno is our first parameter that why we use 1 
				// and we have the value of first parameter as 3
				
				rset=presmt.executeQuery();
				
				if(rset!=null) {
					if(rset.next()) {  //By default, when a ResultSet object is created, the cursor is positioned before the first row of the result set.
//					This means the cursor is in a state where it hasn't yet pointed to any actual row of data.
						System.out.println("RollNo\tName\tCity");
						System.out.println(rset.getInt(1)+"\t"+rset.getString(2)+"\t"+rset.getString(3));
						// rset.getString(2)...it means get the value of column 2
					}
				}
			}
			
			// Query2
			String selectQuery2="select * from studentdetail where name=? or city=?";
			presmt=connection.prepareStatement(selectQuery2);

			presmt.setString(1, "Gagan");
			presmt.setString(2, "");
			rset=presmt.executeQuery(); // executeQuery() for getting some result and executeupdate() for updating table
			
			if(rset!=null) { // result set is null doint rset.next() give error "Illegal operation on empty result set"
				// isliye if condition mai daal ke check karna hota hai
			
				System.out.println("RollNo\tName\tCity");
				while(rset.next()) {  // here is no concept of hasNext()
					System.out.println(rset.getInt(1)+"\t"+rset.getString(2)+"\t"+rset.getString(3));
					// column 1 is of int type
					
				}
				
				
			}
			
					

			
			
			
			
			System.out.println();
			
		}
		catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtilClass.closeResources(connection, presmt,rset);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
