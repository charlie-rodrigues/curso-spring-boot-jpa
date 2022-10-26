package com.cursospringboot.cursospringboot.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospringboot.cursospringboot.entities.User;
import com.cursospringboot.cursospringboot.services.UserService;

@RestController
@RequestMapping(value = "/users")

public class UserResources {
	@Autowired
	private UserService service;
	
@GetMapping	
public ResponseEntity<List<User>> findAll(){
List<User> list = service.findAll();
	return ResponseEntity.ok().body(list);
}
@GetMapping(value="/{id}")
public ResponseEntity<User>findById(@PathVariable Long id){
	User obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
}
}
