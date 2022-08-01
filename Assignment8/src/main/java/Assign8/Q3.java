package Assign8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ap","root","Ee3107695!");
			
			CallableStatement cstmt = con.prepareCall("{call empprocedure(1, 'smith')}");
			
			cstmt.execute();		
			
			
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
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