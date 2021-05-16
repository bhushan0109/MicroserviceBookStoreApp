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
@RequestMapping("/carts")
public class CartController {
	@Autowired
	private ICartService iCartService;

//    @GetMapping("/get")
//    public ResponseEntity<Response> showCart() {
//        List<Cart> userCart = iCartService.listCartItems();
//        return new ResponseEntity<>(new Response( "Got all books from cart successfully", userCart), HttpStatus.OK);
//    }
//
//    @GetMapping("/getCount")
//    public int showCartCount() {
//        List<Cart> userCart = iCartService.listCartItems();
//        return userCart.size();
//    }
//
//    @PostMapping("/add/{bookId}")
//    public ResponseEntity<Response> addToCart(@PathVariable("bookId") UUID bookId) {
//        Cart cartItem = iCartService.addBookToCart( bookId, 1);
//        if(cartItem != null)
//            return new ResponseEntity<>(new Response( "Book added to cart successfully", cartItem), HttpStatus.OK);
//        return new ResponseEntity<>(new Response("Book do not exist!!"), HttpStatus.NOT_ACCEPTABLE);
//    }
//
//    @PostMapping("/update/{bookId}/{orderQuantity}")
//    public ResponseEntity<Response> updateBookOrderQuantity(@PathVariable("bookId") UUID bookId, @PathVariable("orderQuantity") Integer orderQuantity) {
//        String value = iCartService.updateOrderQuantity(bookId, orderQuantity);
//        if(value != null)
//            return new ResponseEntity<>(new Response( value), HttpStatus.OK);
//        return new ResponseEntity<>(new Response("Book do not exist!!"), HttpStatus.NOT_ACCEPTABLE);
//    }
//
//    @DeleteMapping("/remove/{cartId}/{bookId}")
//    public ResponseEntity<Response> removeFromCart(@PathVariable("cartId") UUID cartId, @PathVariable("bookId") UUID bookId) {
//        iCartService.removeProduct(cartId,bookId);
//        return new ResponseEntity<>(new Response( "Book removed from cart successfully"), HttpStatus.OK);
//    }
//
//    @GetMapping("/wishlist/all")
//    public List<Cart> getWishListBooks() {
//        return iCartService.getAllBooksFromWishList();
//    }
//
//    @PostMapping("/wishlist/add/{bookId}")
//    public Response addToWishList(@PathVariable("bookId") UUID bookId) {
//        return iCartService.addBookToWishList(bookId);
//    }
//
//    @DeleteMapping("/wishlist/delete/{bookId}")
//    public ResponseEntity<Response> deleteBookFromWishlist(@PathVariable("bookId") UUID bookId) {
//        List<Cart> cart = iCartService.deleteBookFromWishlist(bookId);
//        return new ResponseEntity<>(new Response("Book removed from wishlist", cart), HttpStatus.OK);
//    }
//
//    @PutMapping("/wishlist/addTocart/{bookId}")
//    public Response addBookFromWishlistToCart(@PathVariable("bookId") UUID bookId) {
//        return iCartService.addBookFromWishlistToCart(bookId);
//    }

	@GetMapping
	public ResponseTemplateVO addBookToCart(@RequestParam("cartId") UUID cartId) {
		return iCartService.addBookToCart(cartId);
	}

	@PostMapping("/create")
	public ResponseEntity<Response> createBookData() {
		Cart cart = iCartService.createCart();
		return new ResponseEntity<>(new Response("Inserted book data successfully!!", cart), HttpStatus.OK);
	}
}