package com.quickbill.model;

import java.util.Date;

public class Admin {

	private int id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private Date dob;
	private String address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date date) {
		this.dob =  date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", fname=" + fname + ", lname=" + lname + ", username=" + username + ", password="
				+ password + ", dob=" + dob + ", address=" + address + "]";
	}
	
}
