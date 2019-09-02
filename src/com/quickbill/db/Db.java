package com.quickbill.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Db {

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An exception occured in the database: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
