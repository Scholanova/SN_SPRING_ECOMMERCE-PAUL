package com.scholanova.ecommerce.cart.entity;

import com.scholanova.ecommerce.product.entity.Product;

import javax.persistence.*;

@Entity(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int quantity;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    public CartItem() {
    }

    public static CartItem create(Product product, int quantity){
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        return cartItem;
    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {return product;}

    public void setProduct(Product product) {
        this.product = product;
    }
}
