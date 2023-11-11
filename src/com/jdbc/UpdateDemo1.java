package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo1 {

	public static void main(String[] args) {

		Connection conn = null;

		try {
			// Step 1: Loading the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Creating connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankAccountDB", "root", "Bickey@123");
			if(conn!=null) {
				System.out.println("Connection establised successfully with database.");
			}
			
			// Step 3: Creating statement where we pass our queries
			PreparedStatement ps = conn.prepareStatement("update bankAccountHolderDetail set accountHolderName=? , accountType=? where accountNumber=?");
			ps.setString(1, "Ujwool");// (pointing 1st ? , value)
			ps.setString(2, "Checkingg");
			ps.setInt(3, 9844);

			// Step 4: Executing queries
			int modifiedRows = ps.executeUpdate();
			//System.out.println(modifiedRows);

			if (modifiedRows == 1) {
				System.out.println("Successfully updated.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Step 5: Closing connection
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
