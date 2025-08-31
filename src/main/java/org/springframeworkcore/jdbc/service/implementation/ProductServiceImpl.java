package org.springframeworkcore.jdbc.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframeworkcore.jdbc.dao.repo.ProductDao;
import org.springframeworkcore.jdbc.model.Product;
import org.springframeworkcore.jdbc.service.define.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public void addProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public List<Product> listProducts() {
		return productDao.findAll();
	}

	@Override
	public void deleteProduct(int productId) {
		productDao.delete(productId);
		
	}

	
}
