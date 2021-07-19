package com.example.springdata;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
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
	public void findAllPaging() {
		System.out.println("-----------------------findAllPaging-----------------------------");
		Pageable pageable = PageRequest.of(2, 2);
		Page<Product> result = productRepository.findAll(pageable);
		result.forEach(product -> System.out.println(product.getName()));
	}

	@Test
	public void findAllSorting() {
		System.out.println("-----------------------findAllSorting-----------------------------");
		productRepository.findAll(Sort.by("name")).forEach(product -> System.out.println(product.getName()));

	}

	@Test
	public void findAllSortingWithOrder() {
		System.out.println("-----------------------findAllSortingWithOrder-----------------------------");
		productRepository.findAll(Sort.by(Direction.DESC, "name"))
				.forEach(product -> System.out.println(product.getName()));

	}
	
	@Test
	public void findAllSortingWithOrderAndMultipuleProperties() {
		System.out.println("-----------------------findAllSortingWithOrderAndMultipuleProperties-----------------------------");
		productRepository.findAll(Sort.by(Direction.DESC, "name","description"))
				.forEach(product -> System.out.println(product));

	}
	
	@Test
	public void findAllSortingWithMultipleOrder() {
		System.out.println("-----------------------findAllSortingWithMultipleOrder-----------------------------");
		// name - ASC, description - DESC
 		productRepository.findAll(Sort.by(Order.asc("name"),Order.desc("description")))
				.forEach(product -> System.out.println(product));

	}
	
	@Test
	public void findAllPagingAndSorting() {
		System.out.println("-----------------------findAllPagingAndSorting-----------------------------");
		Pageable pageable=PageRequest.of(2, 2,Direction.DESC,"name");
 		productRepository.findAll(pageable).forEach(product -> System.out.println(product));

	}
	
	@Test
	public void pagingWithCustomFinderMethod1() {
		System.out.println("-----------------------pagingWithCustomFinderMethod1-----------------------------");
		List<Integer> idList=new ArrayList<>();
		idList.add(1);
		idList.add(4);
		Pageable pageable=PageRequest.of(0, 2);
 		productRepository.findByIdIn(idList,pageable).forEach(product -> System.out.println(product));
	}
	
	@Test
	public void pagingWithCustomFinderMethod2() {
		System.out.println("-----------------------pagingWithCustomFinderMethod2-----------------------------");
		//Pageable pageable=PageRequest.of(0, 1);
 		productRepository.findByDescriptionLike("hello").forEach(product -> System.out.println(product));
	}
	
	

}
