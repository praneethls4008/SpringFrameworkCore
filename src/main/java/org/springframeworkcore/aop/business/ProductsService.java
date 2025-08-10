package org.springframeworkcore.aop.business;

import org.springframework.stereotype.Component;

@Component
public class ProductsService {
    public void viewProduct(){
        System.out.println("seeing product");
    }
}
