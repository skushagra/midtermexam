/*
Controller layer for Cart API using Fake Store API
Author: Kushagra S
 */

package com.midtermexam.midtermexam.controllers;

import com.midtermexam.midtermexam.dto.CreateCartDTO;
import com.midtermexam.midtermexam.dto.UpdateCartDTO;
import com.midtermexam.midtermexam.models.Cart;
import com.midtermexam.midtermexam.views.CartView;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartView cartView;

    CartController(CartView cartView) {
        this.cartView = cartView;
    }

    @GetMapping("")
    public List<Cart> getCarts(@RequestParam HashMap<String, String> params) {
        String startDate = "-1";
        String endDate = "-1";
        if(params.containsKey("startdate")) {
            startDate = params.get("startdate");
        }
        if(params.containsKey("enddate")) {
            endDate = params.get("enddate");
        }
        // TODO: Error handling in startDate and endDate
        return cartView.getCarts(startDate, endDate);
    }

    @GetMapping("/{id}")
    public Cart getCartsById(@PathVariable Long id) {
        return cartView.getCartById(id);
    }

    @GetMapping("/user/{id}")
    public List<Cart> getUserCart(@PathVariable Long id) {
        return cartView.getUserCart(id);
    }

    @PostMapping("")
    public Cart createCart(@RequestBody CreateCartDTO cart) {
        return cartView.createCart(cart);
    }

    @DeleteMapping("/{id}")
    public Cart deleteCart(@PathVariable Long id) {
        return cartView.deleteCart(id);
    }

    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody UpdateCartDTO cart) {
        return cartView.updateCart(id, cart);
    }

}
