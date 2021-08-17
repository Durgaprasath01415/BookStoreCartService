package com.bookstore.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.main.dto.CartDTO;
import com.bookstore.main.dto.ResponseDTO;
import com.bookstore.main.service.ICartService;

@RestController
public class CartController {
	
	@Autowired
	ICartService cartService;
	
	@PostMapping("/addtocart/{token}/")
	public ResponseEntity<ResponseDTO> addToCart(@PathVariable String token,@RequestBody CartDTO cartDto,@RequestParam int bookId){
		ResponseDTO respDTO = cartService.addToCart(token,cartDto,bookId);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletefromcart/{token}")
	public ResponseEntity<ResponseDTO> deleteFromCart(@PathVariable String token,int id){
		ResponseDTO respDTO = cartService.deleteFromCart(token,id);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatecart/{token}")
	public ResponseEntity<ResponseDTO> updateCart(@PathVariable String token,@RequestParam int id,@RequestBody CartDTO Cartdto){
		ResponseDTO respDTO = cartService.updateCart(token,id,Cartdto);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
}
