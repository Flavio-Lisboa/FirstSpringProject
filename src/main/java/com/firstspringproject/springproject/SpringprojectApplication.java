package com.firstspringproject.springproject;

import com.firstspringproject.springproject.entities.Category;
import com.firstspringproject.springproject.entities.Product;
import com.firstspringproject.springproject.repositories.CategoryRepository;
import com.firstspringproject.springproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringprojectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");

		Product product1 = new Product(null, "TV", 2200.00, cat1);
		Product product2 = new Product(null, "Domain Driven Design", 120.00, cat2);
		Product product3 = new Product(null, "PS5", 2800.00, cat1);
		Product product4 = new Product(null, "Docker", 100.00, cat2);

		cat1.getProducts().addAll(Arrays.asList(product1, product3));
		cat2.getProducts().addAll(Arrays.asList(product2, product4));

		categoryRepository.save(cat1);
		categoryRepository.save(cat2);

		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);
	}
}
