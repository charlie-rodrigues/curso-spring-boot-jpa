package com.cursospringboot.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringboot.cursospringboot.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
