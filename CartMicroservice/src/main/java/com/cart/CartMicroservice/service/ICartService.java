package com.cart.CartMicroservice.service;


import com.cart.CartMicroservice.dto.CartDTO;
import com.cart.CartMicroservice.dto.Response;
import com.cart.CartMicroservice.model.Cart;
import com.cart.CartMicroservice.vo.ResponseTemplateVO;

import java.util.List;
import java.util.UUID;

public interface ICartService
{
    public ResponseTemplateVO addBookToCart( UUID cartId);

    Cart createCart();


//    Cart addBookToCart(UUID bookId, Integer order_quantity);
//
//    String updateOrderQuantity(UUID bookId, Integer orderQuantity);
//
//    List<Cart> listCartItems();
//
//    void removeProduct(UUID cartId,UUID bookID);
//
//    List<Cart> getAllBooksFromWishList();
//
//    Response addBookToWishList(UUID bookId);
//
//    List<Cart> deleteBookFromWishlist(UUID bookId);
//
//    Response addBookFromWishlistToCart(UUID bookId);

}