package com.akash.maharana;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.akash.maharana.model.Product;
import com.akash.maharana.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSave1() {
		Product product = new Product();
		product.setName("Microwave");
		product.setPrice(986.089f);
		Product save = productRepository.save(product);
		assertNotNull(save);
	}
	
	@Test
	public void testSave2() {
		Product product = new Product();
		product.setName("Television");
		product.setPrice(4237.089f);
		Product save = productRepository.save(product);
		assertNotNull(save);
	}

	/*
	 * @Test public void testAll() { List<Product> allProducts =
	 * productRepository.findAll(); assertTrue(allProducts.size() == 2); }
	 */

	/*
	 * @Test public void testDelete() {
	 * productRepository.deleteById("5eadb11e75d62a072e3254a8"); List<Product>
	 * allProducts = productRepository.findAll(); assertTrue(allProducts.size() ==
	 * 1); }
	 */

}
