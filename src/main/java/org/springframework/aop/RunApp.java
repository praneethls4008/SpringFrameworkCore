package org.springframework.aop;

import org.springframework.aop.business.CheckoutService;
import org.springframework.aop.business.ProductsService;
import org.springframework.aop.config.AopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunApp {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        CheckoutService cs = (CheckoutService) context.getBean(CheckoutService.class);
        ProductsService ps = (ProductsService) context.getBean(ProductsService.class);

        ps.viewProduct();
        System.out.println(cs.payment(true, "Regular Customer 1"));
        System.out.println(cs.payment(false, "Guest user 2"));
    }
}
