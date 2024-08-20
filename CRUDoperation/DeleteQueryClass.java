package CRUDoperation;

import java.sql.SQLException;
import java.io.IOException;
import java.util.Scanner;

import JDBCUtil.JDBCUtilClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class DeleteQueryClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement presmt=null;
		Scanner sc=new Scanner(System.in);
		try {
			con=JDBCUtilClass.getJDBCConnection();
			String delQuery1="Delete from studentDetail where name='chirag' ";
			presmt=con.prepareStatement(delQuery1);
			if(presmt!=null) {
				int rowAffected=presmt.executeUpdate();
				if(rowAffected!=0) {
					System.out.println("Row deleted ");
				}
				else {
					System.out.println("Nothing deleted");
				}
			}
			
			String delQuery2="Delete from studentdetail where rollno = ?";
			presmt=con.prepareStatement(delQuery2);
			if(presmt!=null) {
				System.out.println("Enter the roll no to delete the row: ");
				int rollno=sc.nextInt();
				presmt.setInt(1, rollno);
				int rowAffected=presmt.executeUpdate();
				if(rowAffected!=0) {
					System.out.println("Row deleted by Query 2");
				}
				else {
					System.out.println("Given roll no does not exists in database");
				}
			}
			
		}
		catch(IOException | SQLException e) {
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
