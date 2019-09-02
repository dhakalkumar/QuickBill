package com.quickbill.controller;

import java.util.List;

import com.quickbill.model.Admin;
import com.quickbill.model.Cashier;
import com.quickbill.model.Product;

public interface QuickBillController {

	boolean addProduct(Product p);
	boolean addCashier(Cashier c);
	boolean addAdmin(Admin a);	
	
	List<Product> getAllProducts();
	List<Cashier> getAllCashiers();
	
	Product getProductById(int id);
	Cashier getCashierById(int id);
	
	boolean updateCashier(Cashier c);
	boolean deleteById(int id);
	
	List<Product> searchProduct(String s);
	boolean updateProduct(Product p);	
	
	
}
