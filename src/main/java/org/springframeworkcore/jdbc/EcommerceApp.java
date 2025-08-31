package org.springframeworkcore.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframeworkcore.jdbc.config.BaseConfig;
import org.springframeworkcore.jdbc.model.Product;
import org.springframeworkcore.jdbc.service.define.OrderService;
import org.springframeworkcore.jdbc.service.define.ProductService;

public class EcommerceApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BaseConfig.class);

        ProductService productService = ctx.getBean(ProductService.class);
        OrderService orderService = ctx.getBean(OrderService.class);

        Product p = new Product();
        p.setName("Laptop");
        p.setPrice(1200.0);
        p.setStock(10);
        productService.addProduct(p);

        System.out.println("Products:");
        productService.listProducts().forEach(prod -> 
            System.out.println(prod.getId() + " - " + prod.getName() + " $" + prod.getPrice()));

        orderService.placeOrder(1, 1, 2); // customerId=1, productId=1, qty=2
        System.out.println("Order placed!");

        ctx.close();
    }
}

