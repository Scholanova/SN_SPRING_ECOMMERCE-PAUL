package com.scholanova.ecommerce.order.entity;

import com.scholanova.ecommerce.cart.entity.Cart;
import com.scholanova.ecommerce.order.exception.IllegalArgException;
import com.scholanova.ecommerce.order.exception.NotAllowedException;
import com.scholanova.ecommerce.product.entity.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class OrdersTest {

    @Test
    public void checkout_ShouldSetTheDateAndTimeOfTodayInTheOrder() throws NotAllowedException, IllegalArgException {
        // given
        Orders order = Orders.createOrder("666",new Cart());
        order.getCart().addProduct(Product.create("vamo","pouquoi faire?",15.0f,1.0f,"EUR"),2);
        //when
        order.checkout();
        //then
        assertThat(order.getIssueDate().equals(Calendar.getInstance().getTime().getTime()));
    }

    @Test
    public void checkout_ShouldSetOrderStatusToPending() throws NotAllowedException, IllegalArgException {
        // given
        Orders order = Orders.createOrder("666",new Cart());
        order.getCart().addProduct(Product.create("vamo","pouquoi faire?",15.0f,1.0f,"EUR"),2);
        //when
        order.checkout();
        //then
        assertThat(order.getStatus().equals(OrderStatus.PENDING));
    }

    @Test
    public void checkout_ShouldThrowNotAllowedExceptionIfStatusIsClosed(){
        // given
        Orders order = Orders.createOrder("666",new Cart());
        order.getCart().addProduct(Product.create("vamo","pouquoi faire?",15.0f,1.0f,"EUR"),5);
        //when
        order.setStatus(OrderStatus.CLOSED);
        //then
        assertThrows(NotAllowedException.class,() -> order.checkout());
    }

    @Test
    public void checkout_ShouldThrowIllegalArgExceptionIfCartTotalItemsQuantityIsZERO(){
        //given
        Orders order = Orders.createOrder("666",new Cart());
        //when
        //then
        assertThrows(IllegalArgException.class,() -> order.checkout());
    }

    @Test
    public void setCart_ShouldThrowNotAllowedExceptionIfStatusIsClosed(){
        //given
        Orders order = Orders.createOrder("666",new Cart());
        order.getCart().addProduct(Product.create("vamo","pouquoi faire?",15.0f,1.0f,"EUR"),1);
        //when
        order.setStatus(OrderStatus.CLOSED);
        //then
        assertThrows(NotAllowedException.class,() -> order.setCart(new Cart()));
    }

    @Test
    public void createOrder_ShouldSetTheCartInTheOrder(){
        //given
        Cart cart = new Cart();
        //when
        Orders order = Orders.createOrder("666",cart);
        //then
        assertThat(cart).isEqualTo(order.getCart());
    }

    @Test
    public void createOrder_ShouldSetStatusToCreated(){
        //given
        Cart cart = new Cart();
        //then
        Orders order = Orders.createOrder("666",cart);
        assertThat(order.getStatus()).isEqualTo(OrderStatus.CREATED);
    }

    @Test
    public void getDiscount_shouldReturnZEROIFCartTotalPriceIsLessThan100(){
        //given
        Cart cart = new Cart();
        Orders order = Orders.createOrder("666",cart);
        //when
        order.getCart().addProduct(Product.create("vamo","pouquoi faire?",15.0f,1.0f,"EUR"),1);
        //then
        assertThat(order.getDiscount()).isEqualTo(new BigDecimal(0));
    }

    @Test
    public void getDiscount_shouldReturn5percentIfCartTotalPriceIsMoreOrEqual100(){
        //given
        Cart cart = new Cart();
        Orders order = Orders.createOrder("666",cart);
        //when
        order.getCart().addProduct(Product.create("vamo","pouquoi faire?",100.0f,1.0f,"EUR"),1);
        //then
        assertThat(order.getDiscount()).isEqualTo(new BigDecimal(5));
    }

    @Test
    public void getOrderPrice_shouldReturnTotalPriceWithDiscount(){
        Cart cart = new Cart();
        Cart cart2 = new Cart();
        Orders order = Orders.createOrder("666",cart);
        Orders order1 = Orders.createOrder("777",cart2);
        //when
        order.getCart().addProduct(Product.create("vamo","pouquoi faire?",1050.0f,1.0f,"EUR"),1);
        order1.getCart().addProduct(Product.create("vamos","pouquoi faire?",10.0f,1.0f,"EUR"),1);
        //then
        assertThat(order.getOrderPrice()).isEqualTo(order.getCart().getTotalPrice().multiply(BigDecimal.valueOf(0.95)));
        assertThat(order1.getOrderPrice()).isEqualTo(order1.getCart().getTotalPrice().multiply(BigDecimal.valueOf(1)));
    }

    @Test
    public void close_ShouldSetStatusToClose(){
        //given
        Cart cart = new Cart();
        Orders order = Orders.createOrder("666",cart);
        //when
        order.close();
        //then
        assertThat(order.getStatus()).isEqualTo(OrderStatus.CLOSED);
    }

}