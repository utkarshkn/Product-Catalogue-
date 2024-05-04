package com.ProductCatalogue.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Availibility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int availability_id;
	
	private boolean inStock;
	
	private int quantity;

	public Availibility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Availibility(int availability_id, boolean inStock, int quantity) {
		super();
		this.availability_id = availability_id;
		this.inStock = inStock;
		this.quantity = quantity;
	}

	public int getAvailability_id() {
		return availability_id;
	}

	public void setAvailability_id(int availability_id) {
		this.availability_id = availability_id;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Availibility [availability_id=" + availability_id + ", inStock=" + inStock + ", quantity=" + quantity
				+ "]";
	}

	
}
