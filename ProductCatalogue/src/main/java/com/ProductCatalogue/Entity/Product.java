package com.ProductCatalogue.Entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;

	private String name;

	private String description;

	private float price;

	@OneToOne(cascade = CascadeType.ALL)
	private Catagories catagories;

	@OneToOne(cascade = CascadeType.ALL)
	private Availibility availability;

	@OneToOne(cascade = CascadeType.ALL)
	private Rating ratings;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", catagories=" + catagories + ", availability=" + availability
				+ ", ratings=" + ratings + "]";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Catagories getCatagories() {
		return catagories;
	}

	public void setCatagories(Catagories catagories) {
		this.catagories = catagories;
	}


	public Availibility getAvailability() {
		return availability;
	}

	public void setAvailability(Availibility availability) {
		this.availability = availability;
	}

	public Rating getRatings() {
		return ratings;
	}

	public void setRatings(Rating ratings) {
		this.ratings = ratings;
	}

	public Product(int id, String name, String description, float price, Catagories catagories,
			Availibility availability, Rating ratings) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.catagories = catagories;
		this.availability = availability;
		this.ratings = ratings;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}