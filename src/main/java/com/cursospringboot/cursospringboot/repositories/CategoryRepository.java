package com.cursospringboot.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringboot.cursospringboot.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
