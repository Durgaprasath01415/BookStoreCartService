package com.bookstore.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Cart")
@Data
public class CartModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int user;
	private int book;
	private long quantity;

}
