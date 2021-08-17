package com.bookstore.main.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookstore.main.dto.CartDTO;
import com.bookstore.main.dto.ResponseDTO;
import com.bookstore.main.exception.CartException;
import com.bookstore.main.model.CartModel;
import com.bookstore.main.repository.CartRepository;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	CartRepository cartRepository;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public ResponseDTO addToCart(String token,CartDTO cartDto,int bookId) {
	boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
			Boolean.class);
	String userName = restTemplate.getForObject("http://bookstoreuser-client/username/" + token,
			String.class);
	if(verify) {
		String bookName = restTemplate.getForObject("http://bookstore-client/bookname/" + token +"/" +bookId,
				String.class);
		CartModel orderDetails = modelMapper.map(cartDto, CartModel.class);
		orderDetails.setUser(userName);
		orderDetails.setBook(bookName);
		cartRepository.save(orderDetails);
		return new ResponseDTO("added to cart successfully",orderDetails);
	}else {
		throw new CartException(400,"User not logged in");
	}
	}
	
	
//	@Override
//	public ResponseDTO addToCart(String token,CartDTO cartDto) {
//	boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
//			Boolean.class);
//	if(verify) {
//		CartModel orderDetails = modelMapper.map(cartDto, CartModel.class);
//		cartRepository.save(orderDetails);
//		return new ResponseDTO("added to cart successfully",orderDetails);
//	}else {
//		throw new CartException(400,"User not logged in");
//	}
//	}

	@Override
	public ResponseDTO deleteFromCart(String token, int id) {
		boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
				Boolean.class);
		if(verify) {
			cartRepository.deleteById(id);
			return new ResponseDTO("deleted from cart successfully",id);
		}else {
			throw new CartException(400,"User not logged in");
		}
	}

	@Override
	public ResponseDTO updateCart(String token, int id,CartDTO cartDto) {
		boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
				Boolean.class);
		if(verify) {
			Optional<CartModel> isCartPresent = cartRepository.findById(id);
			if(isCartPresent.isPresent()){
				isCartPresent.get().setQuantity(cartDto.getQuantity());
				cartRepository.save(isCartPresent.get());
				return new ResponseDTO("Cart is successfully Updated",isCartPresent);
			}else {
				throw new CartException(400,"Cart id not present");
			}
		}else {
				throw new CartException(400,"User not logged in");
			}
		}
}
