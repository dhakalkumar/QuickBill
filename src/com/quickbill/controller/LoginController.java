package com.quickbill.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.quickbill.db.Db;

public class LoginController {

	Connection con = Db.getConnection();
	public boolean adminLogin(String username, String password) {
		String sql = "select * from Admin where username=? and password=?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);

			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean userLogin(String username, String password) {
		String sql = "select * from Cashier where email=? and password=?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
}
