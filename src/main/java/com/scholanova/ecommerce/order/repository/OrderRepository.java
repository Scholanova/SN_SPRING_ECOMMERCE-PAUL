package com.scholanova.ecommerce.order.repository;

import com.scholanova.ecommerce.order.entity.Orders;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Orders, Long>{

}
