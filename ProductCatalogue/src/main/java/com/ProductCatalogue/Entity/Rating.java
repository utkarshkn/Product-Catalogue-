package com.ProductCatalogue.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	private int rating;
	
	private String comment;

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Rating(int user_id, int rating, String comment) {
		super();
		this.user_id = user_id;
		this.rating = rating;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Rating [user_id=" + user_id + ", rating=" + rating + ", comment=" + comment + "]";
	}
	
	
}
