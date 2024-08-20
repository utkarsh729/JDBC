package CRUDoperation;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCUtil.JDBCUtilClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class UpdateQueryClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement presmt=null;
		Scanner sc=new Scanner(System.in);
		
		
		try {
			con=JDBCUtilClass.getJDBCConnection();
			String updateQuery1="Update studentdetail set city = \"Hathras\" where city= '' ";
			presmt=con.prepareStatement(updateQuery1);
			if(presmt!=null) {
				int rowAffected=presmt.executeUpdate(); // return the number of row affected
				
				System.out.println("Number of Row Affected: "+ rowAffected);
				if(rowAffected!=0) {
					System.out.println("Update Done");
				}
				else {
					System.out.println("Nothing Updated");
				}
			}
			
			//Query 2
			String updateQuery2="Update studentdetail set name =? , city = ? where city = ? and rollno=? ";
			presmt=con.prepareStatement(updateQuery2);
			if(presmt!=null) {
				
				presmt.setString(1, "Khushi");
				presmt.setString(2, "Delhi");
				presmt.setString(3,"Hathras");
				presmt.setInt(4,  43);
				
				int rowAffected=presmt.executeUpdate();
				if(rowAffected!=0) {
					System.out.println("Query 2 updated the details");
				}
				else {
					System.out.println("No updation done by Query 2");
				}
			}
			
			
				
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtilClass.closeResources(con, presmt);
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
