package com.cursospringboot.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringboot.cursospringboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
