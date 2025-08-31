package org.springframeworkcore.jdbc.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframeworkcore.jdbc.dao.repo.OrderDao;
import org.springframeworkcore.jdbc.dao.repo.ProductDao;
import org.springframeworkcore.jdbc.model.Order;
import org.springframeworkcore.jdbc.model.OrderItem;
import org.springframeworkcore.jdbc.model.Product;
import org.springframeworkcore.jdbc.service.define.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderDao orderDao;
    private ProductDao productDao;

    @Autowired
    public OrderServiceImpl( OrderDao orderDao, ProductDao productDao) {
	    this.orderDao = orderDao;
	    this.productDao = productDao;
    }
    
	@Override
	@Transactional
	public void placeOrder(int customerId, int productId, int quantity) {
		Product product = productDao.findById(productId).get(0);

        if (product.getStock() < quantity) {
            throw new RuntimeException("Not enough stock for product: " + product.getName());
        }

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderDate(new Date());
        order.setTotalAmount(product.getPrice() * quantity);
        int orderId = orderDao.saveOrder(order);

        OrderItem item = new OrderItem();
        item.setOrderId(orderId);
        item.setProductId(productId);
        item.setQuantity(quantity);
        item.setPrice(product.getPrice());
        orderDao.saveOrderItem(item);
        productDao.updateStock(productId, product.getStock() - quantity);
		
	}

	@Override
	public List<Order> getCustomerOrders(int customerId) {
		return orderDao.findByCustomerId(customerId);
	}

}
