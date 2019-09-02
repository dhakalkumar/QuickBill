package com.quickbill.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.quickbill.db.Db;
import com.quickbill.model.Bill;
import com.quickbill.model.Product;

public class SalesControllerImpl implements SalesController {

	@Override
	public List<Bill> getAllBills() {
		
		Connection con = Db.getConnection();
		String sql = "select * from bill";
		List<Bill> bList = new ArrayList<Bill>();
		try {
			Statement pstm = con.createStatement();
			ResultSet rs = pstm.executeQuery(sql);
			
			while(rs.next()) {
				Bill bill = new Bill();
				bill.setBillno(rs.getInt("billno"));
				bill.setCustomer(rs.getString("customer"));
				bill.setDate(rs.getDate("date"));
				bill.setDiscount(rs.getFloat("discount"));
				bill.setProduct((Product) rs.getObject("product"));
				bill.setTotal(rs.getFloat("total"));
				
				bList.add(bill);
			}
			return bList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
