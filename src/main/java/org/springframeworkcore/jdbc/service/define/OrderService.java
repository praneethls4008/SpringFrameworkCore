package org.springframeworkcore.jdbc.service.define;

import java.util.List;

import org.springframeworkcore.jdbc.model.Order;

public interface OrderService {
	void placeOrder(int customerId, int productId, int quantity);
	List<Order> getCustomerOrders(int customerId);
}
