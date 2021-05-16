package com.cart.CartMicroservice.controller;

import com.cart.CartMicroservice.dto.CartDTO;
import com.cart.CartMicroservice.dto.Response;
import com.cart.CartMicroservice.model.Cart;
import com.cart.CartMicroservice.service.ICartService;
import com.cart.CartMicroservice.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private ICartService iCartService;

	@GetMapping("/")
	public ResponseEntity<Response> showCarts() {
		List<Cart> userCart = iCartService.listCartItems();
		return new ResponseEntity<>(new Response("Got all cart list  successfully", userCart), HttpStatus.OK);
	}

	@GetMapping("/getCount")
	public int showCartCount() {
		List<Cart> userCart = iCartService.listCartItems();
		return userCart.size();
	}

	@GetMapping("/addbook/to/carts")
	public ResponseTemplateVO addBookToCart(@RequestParam("cartId") UUID cartId) {
		return iCartService.addBookToCart(cartId);
	}

	@PostMapping("/create")
	public ResponseEntity<Response> createBookData() {
		Cart cart = iCartService.createCart();
		return new ResponseEntity<>(new Response(" new cart create successfully!!", cart), HttpStatus.OK);
	}
}