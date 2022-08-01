package Assign8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;

public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ap","root","Ee3107695!");
			
			Statement stmt = con.createStatement();

			DatabaseMetaData dbMt = con.getMetaData();
			System.out.println(dbMt.getDriverName());
			
			
			
			ResultSet rs = stmt.executeQuery("select * from employees");

			ResultSetMetaData rsMt = rs.getMetaData();
			System.out.println(rsMt.getColumnCount());
			System.out.println(rsMt.getColumnName(3));

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
