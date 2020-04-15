package com.scholanova.ecommerce.cart.entity;

import com.scholanova.ecommerce.product.entity.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartTest {

    @Test
    void getCartItemByProductName_ShouldReturnCorrectCartItem() {
        //given
        Cart cart = new Cart();
        Product target = Product.create("target", "target", 10.0f, 0.2f, "EUR");
        Product decoy = Product.create("decoy", "decoy", 10.0f, 0.2f, "EUR");
        cart.getCartItems().add(CartItem.create(target, 1));
        cart.getCartItems().add(CartItem.create(decoy, 2));
        //when
        CartItem tested = cart.getCartItemByProductName("target");
        //then
        assertThat(tested.getProduct().getName()).isEqualTo("target");
    }

    @Test
    void getCartItemByProductId_ShouldThrowNoSuchElementIfNotFound() {
        //given
        Cart cart = new Cart();
        Product target = Product.create("target", "target", 10.0f, 0.2f, "EUR");
        cart.getCartItems().add(CartItem.create(target, 1));

        //then
        assertThrows(NoSuchElementException.class, () -> {
            cart.getCartItemByProductName("something");
        });
    }

    @Test
    void addProduct_ShouldCreateANewCartItem() {
        //given
        Product fakeProduct = Product.create("target", "a fake product", 10.0f, 0.2f, "EUR");
        Cart tested = new Cart();
        //when
        tested.addProduct(fakeProduct, 2);
        //then
        assertThat(tested.getCartItemByProductName("target")).isInstanceOf(CartItem.class);
    }

    @Test
    void addProduct_ShouldAddProduct() {
        //given
        Cart cart = new Cart();
        Product testedProduct = Product.create("testedProduct", "testedProduct", 10.0f, 0.2f, "EUR");
        //when
        cart.addProduct(testedProduct, 3);
        //then
        assertThat(cart.getCartItemByProductName("testedProduct").getQuantity()).isEqualTo(3);
    }

    @Test
    void addProduct_ShouldThrowIllegalArgExcIfQuantityUnderOne() {
        //given
        Cart tested = new Cart();
        Product testProduct = Product.create("testProduct", "testProduct", 10.0f, 0.2f, "EUR");
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            tested.addProduct(testProduct, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            tested.addProduct(testProduct, -3);
        });
    }

    @Test
    void addProduct_ShouldAddquantityIfProductAlreadyExists() {
        //given
        Cart cart = new Cart();
        Product testedProduct = Product.create("testedProduct", "testedProduct", 10.0f, 0.2f, "EUR");
        cart.getCartItems().add(CartItem.create(testedProduct, 2));
        //when
        cart.addProduct(testedProduct, 3);
        //then
        assertThat(cart.getCartItemByProductName("testedProduct").getQuantity()).isEqualTo(5);
    }

    @Test
    void removeProduct_ShouldRemoveCartItem() {
        //given
        Cart cart = new Cart();
        Product testedProduct = Product.create("testedProduct", "testedProduct", 10.0f, 0.2f, "EUR");
        cart.getCartItems().add(CartItem.create(testedProduct, 2));
        //when
        cart.removeProduct(testedProduct);
        //then
        assertThrows(NoSuchElementException.class, () -> {
            cart.getCartItemByProductName("testedProduct");
        });
    }

    @Test
    void removeProduct_ShouldThrowNoSuchElemExcIfProductNotFound() {
        //given
        Cart cart = new Cart();
        Product testedProduct = Product.create("testedProduct", "testedProduct", 10.0f, 0.2f, "EUR");
        //then
        assertThrows(NoSuchElementException.class, () -> {
            cart.getCartItemByProductName("testedProduct");
        });
    }

    @Test
    void changeProduct_QuantityShouldChangeQuantity() {
        //given
        Cart cart = new Cart();
        Product target = Product.create("target", "target", 10.0f, 0.2f, "EUR");
        cart.getCartItems().add(CartItem.create(target, 2));
        //when
        cart.changeProductQuantity(target, 3);
        //then
        assertThat(cart.getCartItemByProductName("target").getQuantity()).isEqualTo(3);
    }

    @Test
    void changeProduct_QuantityShouldThrowIllegalArgExcIfQuantityUnderOne() {
        //given
        Cart tested = new Cart();
        Product target = Product.create("target", "target", 10.0f, 0.2f, "EUR");
        tested.addProduct(target, 2);
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            tested.changeProductQuantity(target, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            tested.changeProductQuantity(target, -3);
        });
    }

    @Test
    void getTotalPrice_ShouldReturnTotalPriceWithVATPerProduct() {
        //given
        Cart cart = new Cart();
        Product target = Product.create("target", "target", 10.0f, 0.2f, "EUR");
        target.setId((long) 12);
        Product decoy = Product.create("decoy", "decoy", 12.0f, 0.05f, "EUR");
        decoy.setId((long) 14);
        cart.getCartItems().add(CartItem.create(target, 3));
        cart.getCartItems().add(CartItem.create(decoy, 5));
        //when
        BigDecimal tested = cart.getTotalPrice();
        //then
        assertThat(tested).isEqualTo(BigDecimal.valueOf((10.0 * 1.2 * 3) + (12.0 * 1.05 * 5)).setScale(2, RoundingMode.HALF_EVEN));
    }
}