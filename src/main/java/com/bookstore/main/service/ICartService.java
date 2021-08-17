package com.bookstore.main.service;

import org.springframework.stereotype.Service;

import com.bookstore.main.dto.CartDTO;
import com.bookstore.main.dto.ResponseDTO;

@Service
public interface ICartService {

	ResponseDTO addToCart(String token,CartDTO cartDto,int bookId);

	ResponseDTO deleteFromCart(String token, int id);

	ResponseDTO updateCart(String token, int id,CartDTO Cartdto);

}
