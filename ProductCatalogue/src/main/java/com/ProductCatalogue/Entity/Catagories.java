package com.ProductCatalogue.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Catagories {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String catagories1;

	@Override
	public String toString() {
		return "Catagories [id=" + id + ", catagories1=" + catagories1 + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatagories1() {
		return catagories1;
	}

	public void setCatagories1(String catagories1) {
		this.catagories1 = catagories1;
	}

	public Catagories(int id, String catagories1) {
		super();
		this.id = id;
		this.catagories1 = catagories1;
	}

	public Catagories() {
		super();
		// TODO Auto-generated constructor stub
	}
}
