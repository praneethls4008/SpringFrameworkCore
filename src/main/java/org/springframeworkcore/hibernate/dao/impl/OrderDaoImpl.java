package org.springframeworkcore.hibernate.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframeworkcore.jdbc.dao.repo.OrderDao;
import org.springframeworkcore.jdbc.model.Order;
import org.springframeworkcore.jdbc.model.OrderItem;

@Repository
public class OrderDaoImpl implements OrderDao{

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public OrderDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int saveOrder(Order order) {
		jdbcTemplate.update("INSERT INTO orders (customer_id, order_date, total_amount) VALUES (?, ?, ?)",
                order.getCustomerId(), order.getOrderDate(), order.getTotalAmount());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    }

	@Override
	public void saveOrderItem(OrderItem item) {
		jdbcTemplate.update("INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)",
                item.getOrderId(), item.getProductId(), item.getQuantity(), item.getPrice());
		}

	@Override
	public List<Order> findByCustomerId(int customerId) {
		return (List<Order>) jdbcTemplate.query("SELECT * FROM orders WHERE customer_id = ?",
                (rs, rowNum) -> mapRowToOrder(rs), customerId);
    }


	@Override
	public List<Order> findByOrderId(int orderId) {
		return (List<Order>) jdbcTemplate.query("SELECT * FROM orders WHERE id = ?",
                (rs, rowNum) -> mapRowToOrder(rs), orderId);
	}
	
	private Order mapRowToOrder(ResultSet rs) throws SQLException{
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setCustomerId(rs.getInt("customer_id"));
        order.setOrderDate(rs.getDate("order_date"));
        order.setTotalAmount(rs.getDouble("total_amount"));
        return order;
    }

}
