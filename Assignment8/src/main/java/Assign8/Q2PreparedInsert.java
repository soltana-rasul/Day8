package Assign8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q2PreparedInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ap","root","Ee3107695!");
			
			PreparedStatement pstmt = con.prepareStatement("insert into ap.vendor_contacts values(?,?)");
			pstmt.setInt(1, Integer.parseInt(args[1]));
			pstmt.setString(1, args[1]);
			
			int count = pstmt.executeUpdate();
			System.out.println(count);
			
			PreparedStatement stmt = con.prepareStatement("select * from vendor_contacts");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString("first_name"));
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
