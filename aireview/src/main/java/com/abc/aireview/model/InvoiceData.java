package com.abc.aireview.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="invoice")
public class InvoiceData {
	@Id
	private int id;
	private String name;
	private String item;
	private double price;
	private String user;
	private String status;
	public InvoiceData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InvoiceData(int id, String name, String item, double price, String user, String status) {
		super();
		this.id = id;
		this.name = name;
		this.item = item;
		this.price = price;
		this.user = user;
		this.status = status;
	}

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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "InvoiceData [id=" + id + ", name=" + name + ", item=" + item + ", price=" + price + ", user=" + user
				+ ", status=" + status + "]";
	}

	
	

}
