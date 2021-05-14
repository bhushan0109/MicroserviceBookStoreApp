package com.cart.CartMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private UUID bookId;
    private String authorName;
    private String bookName;
    private Integer quantity;
    public Double price;
    private String bookDetails;





}
