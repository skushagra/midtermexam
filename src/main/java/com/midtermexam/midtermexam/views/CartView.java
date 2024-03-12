package com.midtermexam.midtermexam.views;

import com.midtermexam.midtermexam.dto.CreateCartDTO;
import com.midtermexam.midtermexam.dto.UpdateCartDTO;
import com.midtermexam.midtermexam.models.Cart;

import java.util.List;
public interface CartView {

    List<Cart> getCarts(String startDate, String endDate);
    Cart getCartById(Long id);

    List<Cart> getUserCart(Long id);

    Cart deleteCart(Long id);

    Cart createCart(CreateCartDTO cart);

    Cart updateCart(Long id, UpdateCartDTO cart);
}
