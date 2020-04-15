package com.scholanova.ecommerce.product.repository;

import com.scholanova.ecommerce.product.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
