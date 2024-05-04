package com.ProductCatalogue.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProductCatalogue.Entity.Availibility;
import com.ProductCatalogue.Entity.Product;
import com.ProductCatalogue.Repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	SessionFactory sf;

	// Get product by id
	@GetMapping("getproductbyid/{id}")
	public Product getproduct(@PathVariable int id) {
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		Product p = ss.get(Product.class, id);
		ss.save(p);
		t.commit();
		return p;
	}

	// Get All Products
	@GetMapping("/allproduct")
	public List<Product> getallproduct() {
		Session ss = sf.openSession();
		Query<Product> q = ss.createQuery("from Product");
		List<Product> li = q.list();
		return li;

	}

	// Add Products in Products
	@PostMapping("/addproduct")
	public Product addproduct(@RequestBody Product p) {
		p = productRepository.save(p);
		return p;
	}

	// Add multiple Products
	@PostMapping("/addmultipleproducts")
	public List<Product> multipleproductinsert(@RequestBody List<Product> li) {
		for (Product p : li) {
			Session ss = sf.openSession();
			Transaction tt = ss.beginTransaction();
			ss.save(p);
			tt.commit();
		}
		return li;
	}

	// Update Products
	@PutMapping("/updateproduct")
	public String updateproduct(@RequestBody Product p) {
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		ss.update(p);
		t.commit();
		return "Updated Succesfully...." + p;

	}

	// Update Multiple Products by body
	@PutMapping("/updatemultipleproducts")
	public String updatemultipleproducts(@RequestBody List<Product> li) {
		for (Product p : li) {
			Session ss = sf.openSession();
			Transaction t = ss.beginTransaction();
			ss.update(p);
			t.commit();
		}
		return "Updated Multiple Products" + li;
	}

	// Update Single Column
	@PatchMapping("updateperticularcolumn/{description}")
	public String updateperticularcolumn(@PathVariable int id, @PathVariable String description) {
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		Product p = ss.get(Product.class, id);
		p.setDescription(description);
		ss.update(p);
		t.commit();
		return "Updated Succesfully...." + p;
	}

	// Update multiple columns
	@PatchMapping("/updatemultiplecolume/{id}/{description}/{price}/{inStock}/{quantity}")
	public String multiplefieldupdate(@PathVariable int id, @PathVariable String description, @PathVariable float price,
			@PathVariable boolean inStock, @PathVariable int quantity) {
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		Product p = ss.get(Product.class, id);
		p.setDescription(description);
		p.setPrice(price);
		p.getAvailability().setInStock(inStock);
		p.getAvailability().setQuantity(quantity);
		ss.update(p);
		t.commit();

		return "Updated Sussesfully...." + p;
	}

	// Delete Perticular Item
	@DeleteMapping("deleteProduct/{id}")
	public String deleteproduct(@PathVariable int id) {
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		Product p = ss.get(Product.class, id);
		ss.delete(p);
		t.commit();
		return "Deleted Succesfully.. Deleted Item is :- " + p;
	}

	// Delete All Products
	@DeleteMapping("deleteProduct")
	public String deleteallproducts() {
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		Query<Product> q = ss.createQuery("delete from Product");
		q.executeUpdate();
		t.commit();
		return "Deleted All Items..." + q;
	}
}
