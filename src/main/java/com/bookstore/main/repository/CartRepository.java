package com.bookstore.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.main.model.CartModel;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Integer>{

}
