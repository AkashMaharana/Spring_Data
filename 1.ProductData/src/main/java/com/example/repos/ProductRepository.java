package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
