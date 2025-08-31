package org.springframeworkcore.jdbc.service.define;

import java.util.List;

import org.springframeworkcore.jdbc.model.Product;

public interface ProductService {
	void addProduct(Product product);
    List<Product> listProducts();
    void deleteProduct(int productId);
}
