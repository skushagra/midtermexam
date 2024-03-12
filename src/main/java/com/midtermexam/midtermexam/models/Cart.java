package com.midtermexam.midtermexam.models;

import com.midtermexam.midtermexam.dto.UpdateCartDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart {
    private Long id;
    private Long userId;
    private String Date;
    private List<Product> products;

    public Cart DTOtoCart(UpdateCartDTO updatedCart) {
        this.setUserId(updatedCart.getUserId());
        this.setDate(updatedCart.getDate());
        this.setProducts(updatedCart.getProducts());
        return this;
    }
}
