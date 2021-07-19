package com.example.springdata;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	void contextLoads() {
	}

	@Autowired
	ProductRepository productRepository;

	@Test
	public void createProduct() {
		Product product = new Product();
		product.setId(1);
		product.setName("Amazon Alexa");
		product.setDescription("Alexa say hello!!!!!!");
		product.setPrice(700.00);
		productRepository.save(product);
	}

	@Test
	public void readProduct() {
		Optional<Product> product = productRepository.findById(1);
		assertEquals(1, product.get().getId());
	}

	@Test
	public void updateProduct() {
		Optional<Product> product = productRepository.findById(1);
		Product product1 = product.get();
		product1.setPrice(1000.00);
		productRepository.save(product1);
		Optional<Product> updatedProduct = productRepository.findById(1);
		assertEquals(1000.00, updatedProduct.get().getPrice());
	}

	@Test
	public void deleteProduct() {
		if (productRepository.existsById(1)) {
			productRepository.deleteById(1);
		}
		assertEquals(Optional.ofNullable(null), productRepository.findById(1));
	}

	@Test
	public void countProduct() {
		assertEquals(0, productRepository.count());

	}

}
