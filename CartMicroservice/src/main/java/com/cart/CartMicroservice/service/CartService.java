package com.cart.CartMicroservice.service;

import com.cart.CartMicroservice.dto.CartDTO;
import com.cart.CartMicroservice.dto.Response;
import com.cart.CartMicroservice.model.Book;
import com.cart.CartMicroservice.model.Cart;
import com.cart.CartMicroservice.repository.CartRepository;
import com.cart.CartMicroservice.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CartService implements ICartService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CartRepository cartRepository;

//    @Override
//    public Cart addBookToCart(UUID bookId, Integer order_quantity) {
//        Book book = bookStoreRepository.findById(bookId).orElse(null);
//        if (book == null || book.getQuantity() == 0)
//            return null;
//        else {
//            Cart cartItem = cartRepository.findByBookId(bookId);
//            if (cartItem != null) {
//                cartItem.setOrderQuantity(order_quantity);
//            } else {
//                cartItem = new Cart();
//                cartItem.setOrderQuantity(order_quantity);
//                cartItem.setBook(book);
//                bookStoreRepository.updateQuantityAfterOrder(book.getQuantity() - order_quantity, bookId);
//
//            }
//            cartRepository.save(cartItem);
//            return cartItem;
//        }
//    }

//    @Override
//    public String updateOrderQuantity(UUID bookId, Integer orderQuantity) {
//        Book book = bookStoreRepository.findById(bookId).orElseThrow();
//        if (book == null)
//            return null;
//        else {
//            double subtotal = 0;
//            if (book.getQuantity() >= orderQuantity) {
//                cartRepository.updateOrderQuantity(orderQuantity, bookId);
//                subtotal = book.getPrice() * orderQuantity;
//                bookStoreRepository.updateQuantityAfterOrder(book.getQuantity() - orderQuantity + 1, bookId);
//                return String.valueOf(subtotal);
//            } else {
//                return "Last "+book.getQuantity()+" are left.";
//            }
//        }
//    }
//
//    @Override
//    public List<Cart> listCartItems() {
//        return cartRepository.findAll();
//    }
//
//    @Override
//    public void removeProduct(UUID cartId,UUID bookId) {
//        Book book = bookStoreRepository.findById(bookId).orElseThrow();
//        if (book == null)
//            return ;
//        Cart cartItem = cartRepository.findById(cartId).orElseThrow();
//        bookStoreRepository.updateQuantityAfterOrder(book.getQuantity() + cartItem.getOrderQuantity(), bookId);
//        cartRepository.deleteById(cartId);
//    }

//    @Override
//    public List<Cart> getAllBooksFromWishList() {
//        return null;
//    }
//
//    @Override
//    public Response addBookToWishList(UUID bookId) {
//        return null;
//    }
//
//    @Override
//    public List<Cart> deleteBookFromWishlist(UUID bookId) {
//        return null;
//    }
//
//    @Override
//    public Response addBookFromWishlistToCart(UUID bookId) {
//        return null;
//    }

	public ResponseTemplateVO addBookToCart(UUID cartId) {

		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("someArgument"));

		Book[] book = restTemplate.getForObject("http://localhost:8888/book/books/", Book[].class);

	
		for (Book e : book) {
			System.out.println(e);
			responseTemplateVO.setBook(book);
		}

		responseTemplateVO.setCart(cart);
		return responseTemplateVO;

	}

	@Override
	public Cart createCart() {
		Cart cart = new Cart();
		return cartRepository.save(cart);
	}

}