package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long>{

}
