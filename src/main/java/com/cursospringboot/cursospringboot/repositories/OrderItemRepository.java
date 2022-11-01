package com.cursospringboot.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringboot.cursospringboot.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
