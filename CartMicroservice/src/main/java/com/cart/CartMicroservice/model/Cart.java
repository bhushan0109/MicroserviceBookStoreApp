package com.cart.CartMicroservice.model;

import java.beans.Transient;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cart.CartMicroservice.dto.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity


@AllArgsConstructor
@Table(name = "cart_items")
public class Cart {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2" , strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID cartId;
    private Integer orderQuantity;
    private boolean isInWishList;
    private String bookName;



    public Cart(CartDTO cartDTO) {
        this.cartId=getCartId();
        this.bookName=cartDTO.getBookName();
    }

    public Cart (){
        this.cartId=getCartId();
    }

}