package Assign8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q1Update {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ap","root","Ee3107695!");
			
			Statement stmt = con.createStatement();
			
			int count = (int) stmt.executeUpdate("update vendor_contacts set last_name = 'Smith' where vendor_id = 5");
			//or dynamic like args in insert
			System.out.println(count);
			
			
			ResultSet rs = stmt.executeQuery("select * from vendor_contacts");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
