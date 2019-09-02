package com.quickbill.controller;

import java.util.List;

import com.quickbill.model.Bill;

public interface NewBillController {

	public boolean addBill(Bill bill);
	public Bill getBillById(int id);
	public List<Bill> getAllBills();
	
	public boolean deleteBill(int id);	
	
}
