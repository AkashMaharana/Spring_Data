package com.example.springdata;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entities.Product;
import com.example.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.example.repos")
@EntityScan(basePackages = "com.example.entities")
class ApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void findById() {
		Optional<Product> findById = productRepository.findById(1);
		assertEquals(findById.get().getName(), "Earphone");
	}

	@Test
	public void findAll() {
		List<Product> findAll = productRepository.findAll();
		assertTrue(findAll.size() > 0);
	}

	@Test
	public void findByIdAndDescription() {
		List<Product> product = productRepository.findByIdAndDescription(4, "Deploy to Azure cloud");
		assertTrue(product.size() == 1);
		assertEquals(product.get(0).getName(), "Microsoft Azure");
	}

	@Test
	public void findByPriceGreaterThan() {
		System.out.println("-----------------------findByPriceGreaterThan----------------------------");
		List<Product> products = productRepository.findByPriceGreaterThan(100.00);
		products.stream().forEach(System.out::println);
	}

	@Test
	public void findByDescriptionContains() {
		System.out.println("-----------------------findByDescriptionContains-----------------------------");
		List<Product> products = productRepository.findByDescriptionContains("Deploy");
		products.stream().forEach(System.out::println);
	}

	@Test
	public void findByPriceBetween() {
		System.out.println("-----------------------findByPriceBetween-----------------------------");
		List<Product> products = productRepository.findByPriceBetween(200.00, 500.00);
		products.stream().forEach(System.out::println);
	}

	@Test
	public void findByDescriptionLike() {
		System.out.println("-----------------------findByDescriptionLike-----------------------------");
		List<Product> products = productRepository.findByDescriptionLike("hello");
		products.stream().forEach(System.out::println);
	}

	@Test
	public void findByIdIn() {
		System.out.println("-----------------------findByIdIn-----------------------------");
		List<Integer> idList = new ArrayList<>();
		idList.add(1);
		idList.add(4);
		List<Product> products = productRepository.findByIdIn(idList);
		products.stream().forEach(System.out::println);
	}

}
