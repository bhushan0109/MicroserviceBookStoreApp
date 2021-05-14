package com.cart.CartMicroservice.vo;

import com.cart.CartMicroservice.model.Book;
import com.cart.CartMicroservice.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {

    private Cart cart;
    private List<Book> book;

}
