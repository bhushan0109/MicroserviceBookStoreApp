package com.cart.CartMicroservice.dto;


import lombok.Data;

import java.util.UUID;

@Data
public class CartDTO
{
    public UUID cartId;
    public Integer orderQuantity;
    public boolean isInWishList;
    public String bookName;
}
