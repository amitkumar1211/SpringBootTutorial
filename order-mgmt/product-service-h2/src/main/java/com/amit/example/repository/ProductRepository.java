package com.amit.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.example.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
