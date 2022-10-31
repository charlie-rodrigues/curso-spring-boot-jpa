package com.cursospringboot.cursospringboot.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospringboot.cursospringboot.entities.Product;
import com.cursospringboot.cursospringboot.services.ProductService;

@RestController
@RequestMapping(value = "/products")

public class ProductResources {
	@Autowired
	private ProductService service;
	
@GetMapping	
public ResponseEntity<List<Product>> findAll(){
List<Product> list = service.findAll();
	return ResponseEntity.ok().body(list);
}
@GetMapping(value="/{id}")
public ResponseEntity<Product>findById(@PathVariable Long id){
	Product obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
}
}
