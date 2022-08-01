package Assign8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ap","root","Ee3107695!");
			
			Statement stmt = con.createStatement();
			
			stmt.addBatch("insert into vendor_contacts values (125, 'f1', 'l1')");
			stmt.addBatch("insert into vendor_contacts values (126, 'f2', 'l2')");
			stmt.addBatch("insert into vendor_contacts values (127, 'f3', 'l3')");
			
			stmt.executeBatch();

			PreparedStatement pstmt = con.prepareStatement("insert into ap.vendor_contacts values (?, ?)");
			pstmt.setInt(200, 1);
			pstmt.setString(1, "sammy");
			pstmt.addBatch();
			
			stmt.executeBatch();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
