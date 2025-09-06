package org.springframeworkcore.hibernate.dao.repo;

import java.util.List;

import org.springframeworkcore.jdbc.model.Order;
import org.springframeworkcore.jdbc.model.OrderItem;

public interface OrderDao {
	int saveOrder(Order order);
	void saveOrderItem(OrderItem item);
	List<Order> findByCustomerId(int customerId);
	List<Order> findByOrderId(int orderId);
}
