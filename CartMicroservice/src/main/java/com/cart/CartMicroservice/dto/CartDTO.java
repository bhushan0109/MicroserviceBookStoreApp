package com.cart.CartMicroservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CartDTO {
	
	public UUID cartId;

	public boolean isInWishList;

}
