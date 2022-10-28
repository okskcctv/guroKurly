package com.kurly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.kurly.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>,
QuerydslPredicateExecutor<Product>, ProductRepositoryCustom{
	
}
