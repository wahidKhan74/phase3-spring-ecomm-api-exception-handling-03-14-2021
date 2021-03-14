package com.simplilearn.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Product;
import com.simplilearn.webservice.exception.InvalidProductException;
import com.simplilearn.webservice.exception.ProductNotFoundException;

@RestController
public class ProductController {

	List<Product> products = new ArrayList<Product>();

	// get one product by id
	@GetMapping("/products/{id}") // or @RequestMapping(value="/products/{id}",method=RequestMethod.GET)
	public Product getOneProduct(@PathVariable("id") int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		throw new ProductNotFoundException();
	}

	// delete one product
	@DeleteMapping("/products/{id}") //
	public List<Product> removeOneProduct(@PathVariable("id") int id) {
		// counter for loop
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == id) {
				products.remove(i);
				return products;
			}
		}
		throw new ProductNotFoundException();
	}

	// add a product
	@PostMapping("/products")
	public List<Product> addProduct(@RequestBody Product product) {
		if(product.getId() > 0 && product.getName() != null && product.getPrice()>0 ){
			products.add(product);
			return products;
		}
		throw new InvalidProductException();
	}

	private List<Product> getDefaultProduct() {
		products.add(new Product(1001, "Iphone 11 Pro", "It is a smart phone", 70000));
		products.add(new Product(1002, "Lenovo Laptop XYZ series", "It is a Laptop", 20000));
		products.add(new Product(1003, "Ferari", "It is a racing car", 280000));
		products.add(new Product(1004, "Dimond Ring", "It is a ring", 230000));
		return products;
	}

	// get all products
	@GetMapping("/products") // or @RequestMapping(value="/products",method=RequestMethod.GET)
	public List<Product> getAllProducts() {
		return getDefaultProduct();
	}

}
