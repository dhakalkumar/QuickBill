package com.quickbill.model;

public class Product {
	
	private int id;
	private String name;
	private int qAvailable;
	private int qAdded;
	private float mrp;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getqAvailable() {
		return qAvailable;
	}
	public void setqAvailable(int qAvailable) {
		this.qAvailable = qAvailable;
	}
	public int getqAdded() {
		return qAdded;
	}
	public void setqAdded(int qAdded) {
		this.qAdded = qAdded;
	}
	public float getMrp() {
		return mrp;
	}
	public void setMrp(float mrp) {
		this.mrp = mrp;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", qAvailable="
				+ qAvailable + ", qAdded=" + qAdded + ", mrp=" + mrp + "]";
	}
	
}
