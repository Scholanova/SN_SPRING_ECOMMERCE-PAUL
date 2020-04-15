package com.scholanova.ecommerce.cart.service;

import com.scholanova.ecommerce.cart.entity.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartServiceImpl implements CartService{

    @Override
    public Cart addProductToCart(Cart cart, Long productId, int quantity) {
        //TODO
        return null;
    }

    @Override
    public Cart changeProductQuantity(Cart cart, Long productId, int quantity) {
        //TODO
        return null;
    }
}
