package com.ProductCatalogue.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProductCatalogue.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	

}
