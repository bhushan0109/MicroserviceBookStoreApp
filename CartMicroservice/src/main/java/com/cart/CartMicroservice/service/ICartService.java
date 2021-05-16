package com.cart.CartMicroservice.service;

import com.cart.CartMicroservice.model.Cart;
import com.cart.CartMicroservice.vo.ResponseTemplateVO;

import java.util.List;
import java.util.UUID;

public interface ICartService {
	public ResponseTemplateVO addBookToCart(UUID cartId);

	Cart createCart();

	List<Cart> listCartItems();

	void deleteCart(UUID cartId);

}