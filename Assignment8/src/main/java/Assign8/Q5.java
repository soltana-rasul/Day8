package Assign8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ap","root","Ee3107695!");
			
			Statement stmt = con.createStatement();

			con.setAutoCommit(false);
			stmt.executeUpdate("insert into employees values (111, 'sam')");
			System.out.println("Line 1 Complete");

			stmt.executeUpdate("insert into vender_contacts values(113, 'hi')");
			System.out.println("Line 2 Complete");
			
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				
			}
		}
	}

}
