package com.scholanova.ecommerce.order.entity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class OrdersTest {

    @Test
    public void checkout_ShouldSetTheDateAndTimeOfTodayInTheOrder(){

    }

    @Test
    public void checkout_ShouldSetOrderStatusToPending(){

    }

    @Test
    public void checkout_ShouldThrowNotAllowedExceptionIfStatusIsClosed(){

    }

    @Test
    public void checkout_ShouldThrowIllegalArgExceptionIfCartTotalItemsQuantityIsZERO(){

    }

    @Test
    public void setCart_ShouldThrowNotAllowedExceptionIfStatusIsClosed(){

    }

    @Test
    public void createOrder_ShouldSetTheCartInTheOrder(){

    }

    @Test
    public void createOrder_ShouldSetStatusToCreated(){

    }

    @Test
    public void getDiscount_shouldReturnZEROIFCartTotalPriceIsLessThan100(){

    }

    @Test
    public void getDiscount_shouldReturn5percentIfCartTotalPriceIsMoreOrEqual100(){

    }

    @Test
    public void getOrderPrice_shouldReturnTotalPriceWithDiscount(){

    }

    @Test
    public void close_ShouldSetStatusToClose(){

    }

}