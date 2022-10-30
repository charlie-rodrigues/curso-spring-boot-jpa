package com.cursospringboot.cursospringboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursospringboot.cursospringboot.entities.Order;
import com.cursospringboot.cursospringboot.entities.User;
import com.cursospringboot.cursospringboot.enums.OrderStatus;
import com.cursospringboot.cursospringboot.repositories.OrderRepository;
import com.cursospringboot.cursospringboot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepsitory;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "charlie", "charlie@gmail", "88998877", "1234");
		User u2 = new User(null, "larissa", "larissa@gmail", "99889977", "1236");
		
		Order o1 = new Order(null, Instant.parse("2022-10-22T22:22:22Z"),OrderStatus.CANCELED,  u1);
		Order o2 = new Order(null,Instant.parse("2002-09-23T23:44:12Z"),OrderStatus.DELIVERED,u2);
		Order o3 = new Order(null, Instant.parse("2019-04-29T10:00:00Z"),OrderStatus.WAITING_PAYMENT,u1);
		userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepsitory.saveAll(Arrays.asList(o1,o2,o3));
	}
}
