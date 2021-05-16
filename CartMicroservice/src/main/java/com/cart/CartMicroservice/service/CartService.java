package com.cart.CartMicroservice.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cart.CartMicroservice.model.Book;
import com.cart.CartMicroservice.model.Cart;
import com.cart.CartMicroservice.repository.CartRepository;
import com.cart.CartMicroservice.vo.ResponseTemplateVO;

@Service
@Transactional
public class CartService implements ICartService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> listCartItems() {
		return cartRepository.findAll();
	}

	public ResponseTemplateVO addBookToCart(UUID cartId) {

		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("someArgument"));

		Book[] book = restTemplate.getForObject("http://localhost:8888/book/books/", Book[].class);

		for (Book e : book) {
			System.out.println(e);
			responseTemplateVO.setBook(book);

		}

		responseTemplateVO.setCart(cart);
		cartRepository.save(cart);
		return responseTemplateVO;
	}
	public ResponseTemplateVO addBookToCartSeperate(UUID cartId,UUID bookId) {

		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("someArgument"));

		Book[] book = restTemplate.getForObject("http://localhost:8888/book/books/", Book[].class);

		for (Book e : book) {
			System.out.println(e);
			responseTemplateVO.setBook(book);

		}

		responseTemplateVO.setCart(cart);
		cartRepository.save(cart);
		return responseTemplateVO;
	}
	

	@Override
	public void deleteCart(UUID cartId) {
		cartRepository.deleteById(cartId);
	}

	@Override
	public Cart createCart() {
		Cart cart = new Cart();
		return cartRepository.save(cart);
	}

}