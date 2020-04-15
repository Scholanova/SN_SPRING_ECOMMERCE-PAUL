package com.scholanova.ecommerce.cart.repository;

import com.scholanova.ecommerce.cart.entity.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {
}
