package com.cart.CartMicroservice.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.cart.CartMicroservice.dto.CartDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity

@AllArgsConstructor
@Table(name = "cart_items")
public class Cart {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Type(type = "uuid-char")
	private UUID cartId;

	private boolean isInWishList;

	public Cart(CartDTO cartDTO) {
		this.cartId = getCartId();

	}

	public Cart() {
		this.cartId = getCartId();
	}

}