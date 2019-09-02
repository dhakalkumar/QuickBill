package com.quickbill.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.quickbill.db.Db;
import com.quickbill.model.Bill;

public class NewBillControllerImpl implements NewBillController {

	Connection con;
	
	public NewBillControllerImpl() {
		super();
		con = Db.getConnection();
	}
	
	@Override
	public boolean addBill(Bill bill) {
		
		String sql = "insert into Bill(billno, customer, quantity, discount, date, total, productno)"
				+ " values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, bill.getBillno());
			pstm.setString(2, bill.getCustomer());
			pstm.setInt(3, bill.getQuantity());
			pstm.setFloat(4, bill.getDiscount());
			pstm.setDate(5, bill.getDate());
			pstm.setFloat(6, bill.getTotal());
			pstm.setInt(7, bill.getProduct().getId());
			
			pstm.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public Bill getBillById(int id) {
		String sql = "select * from Bill where id = " + id;
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				Bill bill = new Bill();
				QuickBillController qb = new QuickBillControllerImpl();
				bill.setBillno(rs.getInt("id"));
				bill.setCustomer(rs.getString("customer"));
				bill.setDate(rs.getDate("date"));
				bill.setDiscount(rs.getFloat("discount"));
				bill.setProduct(qb.getProductById(rs.getInt("productno")));
				bill.setQuantity(rs.getInt("quantity"));
				bill.setTotal(rs.getFloat("total"));
				
				return bill;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Bill> getAllBills() {
		String sql = "select * from Bill";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Bill> bList = new ArrayList<Bill>();
			while(rs.next()) {
				Bill bill = new Bill();
				QuickBillController qb = new QuickBillControllerImpl();
				bill.setBillno(rs.getInt("id"));
				bill.setCustomer(rs.getString("customer"));
				bill.setDate(rs.getDate("date"));
				bill.setDiscount(rs.getFloat("discount"));
				bill.setProduct(qb.getProductById(rs.getInt("productno")));
				bill.setQuantity(rs.getInt("quantity"));
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

	@Override
	public boolean deleteBill(int id) {
		String sql = "delete from Bill where id = " + id;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
