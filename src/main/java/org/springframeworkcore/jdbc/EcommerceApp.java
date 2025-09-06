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

      //::::::::::::::::Add new Product:::::::::::::
//        Product p = new Product();
//        p.setName("Laptop1");
//        p.setPrice(1200.0);
//        p.setStock(0);
//        productService.addProduct(p);

        //::::::::::::::::List all product:::::::::::::
        System.out.println("Products:");
        
        productService.listProducts().forEach(prod -> 
            System.out.println(prod.getId() + " - " + prod.getName() + " $" + prod.getPrice()));

        
      //::::::::::::::::Place Order:::::::::::::
        try {
    		orderService.placeOrder(1, 14, 1); // customerId=1, productId=1, qty=2
    		System.out.println("Order placed!");
    }catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("Order Not placed!");
    }
        try {
        		orderService.placeOrder(1, 14, 2); // customerId=1, productId=1, qty=2
        		System.out.println("Order placed!");
        }catch(Exception e) {
        		e.printStackTrace();
        		System.out.println("Order Not placed!");
        }

      //::::::::::::::::Get all orders of customer:::::::::::::
        System.out.println(orderService.getCustomerOrders(1));
        
        ctx.close();
    }
}

