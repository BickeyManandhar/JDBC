package com.jdbc.method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseUtils {

	Connection getConnection() {
		Connection conn = null;

		try {
			// Step 1: Loading the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Creating connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankAccountDB", "root", "Bickey@123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connection is ....." + conn);
		return conn;
	}

	void insertData(int accountNumber, String accountHolderName, String accountType, double balance, String emailId,
			String password) {
		try {
			Connection conn = getConnection();
			// Step 3: Creating statement where we pass our queries
			PreparedStatement ps = conn.prepareStatement("insert into bankAccountHolderDetail values (?,?,?,?,?,?)");
			ps.setInt(1, accountNumber); // (pointing 1st ? , value)
			ps.setString(2, accountHolderName);
			ps.setString(3, accountType);
			ps.setDouble(4, balance);
			ps.setString(5, emailId);
			ps.setString(6, password);

			// Step 4: Executing queries
			int modifiedRows = ps.executeUpdate();
			// System.out.println(modifiedRows);

			if (modifiedRows == 1) {
				System.out.println("Insert successful.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void updateData(int accountNumber, String accountHolderName, String accountType, double balance, String emailId,
			String password) {
		try {
			Connection conn = getConnection();
			// Step 3: Creating statement where we pass our queries
			PreparedStatement ps = conn.prepareStatement(
					"update bankAccountHolderDetail set accountHolderName=? , accountType=?, balance=?, emailId=?, password=? where accountNumber=?");
			ps.setString(1, accountHolderName);// (pointing 1st ? , value)
			ps.setString(2, accountType);
			ps.setDouble(3, balance);
			ps.setString(4, emailId);
			ps.setString(5, password);
			ps.setInt(6, accountNumber);

			// Step 4: Executing queries
			int modifiedRows = ps.executeUpdate();
			// System.out.println(modifiedRows);

			if (modifiedRows == 1) {
				System.out.println("Successfully updated.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void deleteData(int accountNumber) {
		// Step 3: Creating statement where we pass our queries
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from bankAccountHolderDetail where accountNumber=?");
			ps.setInt(1, accountNumber);// (pointing 1st ? , value)

			// Step 4: Executing queries
			int modifiedRows = ps.executeUpdate();
			// System.out.println(modifiedRows);

			if (modifiedRows == 1) {
				System.out.println("Successfully deleted.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void selectData() {
		Connection conn = getConnection();
		try {
			// Step 3: Creating statement where we pass our queries
			PreparedStatement ps = conn.prepareStatement("select * from bankAccountHolderDetail");
			//ps.setInt(1, accountNumber); // (pointing 1st ? , value)

			// Step 4: Executing queries
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(
						"|" + rs.getInt(1) + " |" + rs.getString(2) + " |" + rs.getString(3)
								+ " |" + rs.getDouble(4) + " |" + rs.getString(5) + " |" + rs.getString(6) + " |");
//						System.out.println(rs.getInt(1)); //first column
//						System.out.println(rs.getString(2)); //second column
//						System.out.println(rs.getString(3)); //third column
//						System.out.println(rs.getDouble(4)); //fourth column
//						System.out.println(rs.getString(5)); //fifth column
//						System.out.println(rs.getString(6)); //sixth column
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
