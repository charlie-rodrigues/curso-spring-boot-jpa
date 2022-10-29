package com.cursospringboot.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringboot.cursospringboot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
