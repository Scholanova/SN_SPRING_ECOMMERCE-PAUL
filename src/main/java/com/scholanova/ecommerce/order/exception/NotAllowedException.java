package com.scholanova.ecommerce.order.exception;

public class NotAllowedException extends Exception{
    public NotAllowedException (String error){
        super(error);
    }
}
