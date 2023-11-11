package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDemo1 {

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
			PreparedStatement ps = conn.prepareStatement("select * from bankAccountHolderDetail");
			//ps.setInt(1, 9841); // (pointing 1st ? , value)

			// Step 4: Executing queries
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				System.out.println("|"+rs.getInt(1)+" |"+rs.getString(2)+" |"+rs.getString(3)+" |"+rs.getDouble(4)+" |"+rs.getString(5)+" |"+rs.getString(6)+" |");
//				System.out.println(rs.getInt(1)); //first column
//				System.out.println(rs.getString(2)); //second column
//				System.out.println(rs.getString(3)); //third column
//				System.out.println(rs.getDouble(4)); //fourth column
//				System.out.println(rs.getString(5)); //fifth column
//				System.out.println(rs.getString(6)); //sixth column
			}
//			int modifiedRows = ps.executeUpdate();
//			//System.out.println(modifiedRows);
//
//			if (modifiedRows == 1) {
//				System.out.println("Modification successful.");
//			}

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
