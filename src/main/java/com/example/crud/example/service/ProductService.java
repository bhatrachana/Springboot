package com.example.crud.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.crud.example.Exception.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.crud.example.entity.Product;
import com.example.crud.example.repository.ProductRepository;
import java.util.List;
import javax.transaction.Transactional;


@Service
public class ProductService {
    @Autowired
	private ProductRepository repository;
    
    public Product saveProduct(Product product) {
    	return repository.save(product);
    	
    }
   
    public List<Product> getProducts() {
  
    	return repository.findAll();
    	
    }
    public Product getProductById(int id)
    {
    	return repository.findById(id).orElseThrow();
    }
  
    public String deleteProduct(int id) {
    	repository.deleteById(id);
    	return "product removed !!"+id;
    }
    
    @Transactional
    public Product updateProduct(Product product) {
    	 Product existingProduct=repository.findById(product.getId()).orElseThrow();
    	 existingProduct.setName(product.getName());
    	 existingProduct.setQuantity(product.getQuantity());
    	 existingProduct.setPrice(product.getPrice());
    	 return repository.save(existingProduct);
    }
}

