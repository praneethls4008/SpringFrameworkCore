package org.springframeworkcore.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframeworkcore.jdbc.dao.repo.ProductDao;
import org.springframeworkcore.jdbc.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void save(Product product) {
		jdbcTemplate.update("INSERT INTO products (name, price, stock) VALUES(?, ?, ?)",
				product.getName(), product.getPrice(), product.getStock());
	}

	@Override
	public List<Product> findById(int productId) {
		return (List<Product>) jdbcTemplate.query("SELECT * FROM products WHERE id = ?",
				(rs, rowNum) -> mapRowToProduct(rs),
				productId);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) jdbcTemplate.query("SELECT * FROM products",
				(rs, rowNum) -> mapRowToProduct(rs));
	}

	@Override
	public void delete(int productId) {
		jdbcTemplate.update("DELETE FROM products WHERE id = ?", productId);
	}

	@Override
	public void updateStock(int productId, int newStock) {
		 jdbcTemplate.update("UPDATE products SET stock = ? WHERE id = ?", newStock, productId);
    }
	
	private Product mapRowToProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        product.setStock(rs.getInt("stock"));
        return product ;
    }


}
