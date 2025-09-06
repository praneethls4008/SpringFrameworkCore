package org.springframeworkcore.hibernate.dao.repo;

import java.util.List;

import org.springframeworkcore.jdbc.model.Product;

public interface ProductDao {
	void save(Product product);
	List<Product> findById(int id);
	List<Product> findAll();
	void delete(int id);
	void updateStock(int id, int newStock);
}
