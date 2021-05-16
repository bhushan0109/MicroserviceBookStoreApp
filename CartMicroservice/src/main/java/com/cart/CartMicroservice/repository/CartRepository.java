package com.cart.CartMicroservice.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.CartMicroservice.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {

}
