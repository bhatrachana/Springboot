package com.example.crud.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.example.entity.Product;
import com.example.crud.example.service.ProductService;
import java.util.List;


@RestController
public class ProductController {
	
	@Autowired
     private ProductService service;
	 @PostMapping("/addproduct")
     public Product addProduct(@RequestBody Product product)
     {
    	 return service.saveProduct(product);
     }
	 
	 @GetMapping("/products")
     public List<Product> findAllProducts() {
    	 return service.getProducts();
    	 
     }
	 @GetMapping("/getproduct/{id}")
     public Product findProductById(@PathVariable int id) {
    	 return service.getProductById(id);
     }
 
	 @PutMapping("/update")
     public Product updateProduct(@RequestBody Product product)
     {
    	 return service.updateProduct(product);
     }
	 
	 @DeleteMapping("/delete/{id}")
	 public String deleteProduct(@PathVariable int id)
	 {
		 return service.deleteProduct(id);
	 }
}
