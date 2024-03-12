package com.midtermexam.midtermexam.views;

import com.midtermexam.midtermexam.dto.CreateCartDTO;
import com.midtermexam.midtermexam.dto.UpdateCartDTO;
import com.midtermexam.midtermexam.models.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CartViewImpl implements CartView{

    private final RestTemplate restTemplate;
    private final String url = "https://fakestoreapi.com/carts";

    CartViewImpl() {
        restTemplate = new RestTemplate();
    }
    @Override
    public List<Cart> getCarts(String startDate, String endDate) {
        String caller = url;
        if(startDate != "-1" && endDate == "-1") {
            caller += "?startdate="+startDate;
        }
        else if(startDate == "-1" && endDate != "-1"){
            caller += "?enddate="+endDate;
        }
        else if(startDate != "-1" && endDate != "-1") {
            caller += "?startdate="+startDate+"&enddate="+endDate;
        }
        Cart[] carts = restTemplate.getForObject(caller, Cart[].class);
        assert carts != null;
        return Arrays.stream(carts).toList();
    }

    @Override
    public Cart getCartById(Long id) {
        return restTemplate.getForObject(url+"/"+id , Cart.class);
    }

    @Override
    public List<Cart> getUserCart(Long id) {
        Cart[] userCarts = restTemplate.getForObject(url+"/user/"+id, Cart[].class);
        assert userCarts != null;
        return Arrays.stream(userCarts).toList();
    }

    @Override
    public Cart deleteCart(Long id) {
        Cart deletedCart = getCartById(id);
        if(deletedCart != null) restTemplate.delete(url+"/"+id);
        return deletedCart;
    }

    @Override
    public Cart createCart(CreateCartDTO cart) {
        return restTemplate.postForObject(url, cart, Cart.class);
    }

    @Override
    public Cart updateCart(Long id, UpdateCartDTO cart) {
        Cart cartToUpdate = getCartById(id);
        if(cartToUpdate != null) restTemplate.put(url+"/"+id, cart);
        assert cartToUpdate != null;
        return cartToUpdate.DTOtoCart(cart);
    }
}
