package com.scholanova.ecommerce.cart.service;

import com.scholanova.ecommerce.cart.entity.Cart;

public interface CartService {

    public Cart addProductToCart(Cart cart, Long productId, int quantity);

    public Cart changeProductQuantity(Cart cart, Long productId, int quantity);
}
