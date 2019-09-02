package com.quickbill.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.quickbill.db.Db;
import com.quickbill.model.Admin;
import com.quickbill.model.Cashier;
import com.quickbill.model.Product;

public class QuickBillControllerImpl implements QuickBillController {

	Connection con = null;

	public QuickBillControllerImpl() {
		con = Db.getConnection();
	}

	@Override
	public boolean addProduct(Product p) {
		String sql = "insert into Product(pid, name, quantity, added, mrp) values(?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, p.getId());
			pstm.setString(2, p.getName());
			pstm.setInt(3, p.getqAvailable());
			pstm.setInt(4, p.getqAdded());
			pstm.setFloat(5, p.getMrp());

			pstm.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean addCashier(Cashier c) {

		String sql = "insert into Cashier(name, number, address, email, password) values(?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, c.getName());
			pstm.setString(2, c.getNumber());
			pstm.setString(3, c.getAddress());
			pstm.setString(4, c.getEmail());
			pstm.setString(5, c.getPassword());

			pstm.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addAdmin(Admin a) {
		String sql = "insert into Admin(fname, lname, username, password, dob, address) values(?,?,?,?,?,?)";
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, a.getFname());
			pstm.setString(2, a.getLname());
			pstm.setString(3, a.getUsername());
			pstm.setString(4, a.getPassword());
			pstm.setDate(5, new Date(a.getDob().getTime()));
			pstm.setString(6, a.getAddress());

			pstm.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An exception occured: " + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Product> getAllProducts() {

		List<Product> pList = new ArrayList<Product>();
		String sql = "select * from Product";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("pid"));
				product.setName(rs.getString("name"));
				product.setqAvailable(rs.getInt("quantity"));
				product.setqAdded(rs.getInt("added"));
				product.setMrp(rs.getFloat("mrp"));

				pList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pList;
	}

	public Product getProductById(int id) {
		String sql = "select * from Product where pid = " + id;
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("pid"));
				p.setName(rs.getString("name"));
				p.setqAdded(rs.getInt("added"));
				p.setqAvailable(rs.getInt("quantity"));
				p.setMrp(rs.getFloat("mrp"));

				return p;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Cashier getCashierById(int id) {
		String sql = "select * from Cashier where id = " + id;
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				Cashier c = new Cashier();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setNumber(rs.getString("number"));
				c.setAddress(rs.getString("address"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));

				return c;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Cashier> getAllCashiers() {

		List<Cashier> cList = new ArrayList<Cashier>();
		String sql = "select * from Cashier";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Cashier cashier = new Cashier();
				cashier.setId(rs.getInt("id"));
				cashier.setName(rs.getString("name"));
				cashier.setNumber(rs.getString("number"));
				cashier.setAddress(rs.getString("address"));
				cashier.setEmail(rs.getString("email"));
				cashier.setPassword(rs.getString("password"));

				cList.add(cashier);
			}
			return cList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateCashier(Cashier c) {
		String sql = "update Cashier set name=?, number=?, address=?, email=?, password=? where id = "
				+ c.getId();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);

			pstm.setString(1, c.getName());
			pstm.setString(2, c.getNumber());
			pstm.setString(3, c.getAddress());
			pstm.setString(4, c.getEmail());
			pstm.setString(5, c.getPassword());

			pstm.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteById(int id) {
		String sql = "delete from Cashier where id = " + id;
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

	@Override
	public List<Product> searchProduct(String pname) {
		List<Product> pList = new ArrayList<Product>();
		String sql = "select * from Product where name like '%" + pname + "%' ";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("pid"));
				product.setName(rs.getString("name"));
				product.setqAvailable(rs.getInt("quantity"));
				product.setqAdded(rs.getInt("added"));
				product.setMrp(rs.getFloat("mrp"));

				pList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pList;

	}

	@Override
	public boolean updateProduct(Product p) {
		if(p.getId() <= 0) {
			return false;
		}
		String sql = "update Product set name=?, quantity=?, added=?, mrp=? where pid=" + p.getId();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getqAvailable());
			ps.setInt(3, p.getqAdded());
			ps.setFloat(4, p.getMrp());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
}








