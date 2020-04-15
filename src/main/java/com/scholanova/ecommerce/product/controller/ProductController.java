package com.scholanova.ecommerce.product.controller;

import com.scholanova.ecommerce.product.entity.Product;
import com.scholanova.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableSpringDataWebSupport
@RequestMapping("/products")
public class ProductController {

    private ProductRepository repository;

    public ProductController(@Autowired ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Product> getAllProducts(Pageable pageable) {
        return repository.findAll(pageable).get().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Product product) {
        return product;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        return repository.save(product);
    }

}
