package org.springframeworkcore.aop;

import org.springframeworkcore.aop.business.CheckoutService;
import org.springframeworkcore.aop.business.ProductsService;
import org.springframeworkcore.aop.config.AopConfig;
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
