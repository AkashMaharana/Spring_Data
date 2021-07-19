package com.akash.maharana.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.akash.maharana.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
