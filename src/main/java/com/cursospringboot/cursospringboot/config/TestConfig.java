package com.cursospringboot.cursospringboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursospringboot.cursospringboot.entities.Category;
import com.cursospringboot.cursospringboot.entities.Order;
import com.cursospringboot.cursospringboot.entities.OrderItem;
import com.cursospringboot.cursospringboot.entities.Product;
import com.cursospringboot.cursospringboot.entities.User;
import com.cursospringboot.cursospringboot.enums.OrderStatus;
import com.cursospringboot.cursospringboot.repositories.CategoryRepository;
import com.cursospringboot.cursospringboot.repositories.OrderItemRepository;
import com.cursospringboot.cursospringboot.repositories.OrderRepository;
import com.cursospringboot.cursospringboot.repositories.ProductRepository;
import com.cursospringboot.cursospringboot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepsitory;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "eletrinic");
		Category cat2 = new Category(null, "movies");
		Category cat3 = new Category(null, "music");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		

		User u1 = new User(null, "charlie", "charlie@gmail", "88998877", "1234");
		User u2 = new User(null, "larissa", "larissa@gmail", "99889977", "1236");

		Order o1 = new Order(null, Instant.parse("2022-10-22T22:22:22Z"), OrderStatus.CANCELED, u1);
		Order o2 = new Order(null, Instant.parse("2002-09-23T23:44:12Z"), OrderStatus.DELIVERED, u2);
		Order o3 = new Order(null, Instant.parse("2019-04-29T10:00:00Z"), OrderStatus.WAITING_PAYMENT, u1);
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepsitory.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

	}
}
