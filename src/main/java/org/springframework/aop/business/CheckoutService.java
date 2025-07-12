package org.springframework.aop.business;

import org.springframework.stereotype.Component;

@Component()
public class CheckoutService {

    public String payment(boolean isDone, String username){
        return isDone ? "Payment Success" : "Payment Failed";
    }
}
