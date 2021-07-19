package com.example.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

	public Optional<Product> findById(Integer id);

	public List<Product> findAll();

	public List<Product> findByIdAndDescription(Integer id, String description);

	public List<Product> findByPriceGreaterThan(Double price);

	public List<Product> findByDescriptionContains(String description);

	public List<Product> findByPriceBetween(Double price1, Double price2);
	
	public List<Product> findByDescriptionLike(String description);
	
	public List<Product> findByIdIn(List<Integer> inputList);
	
	public List<Product> findByIdIn(List<Integer> idList,Pageable pageable);
	
	public List<Product> findByDescriptionLike(String description,Pageable pageable);
}
