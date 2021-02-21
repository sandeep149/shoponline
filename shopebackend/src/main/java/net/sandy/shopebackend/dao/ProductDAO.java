package net.sandy.shopebackend.dao;

import java.util.List;

import net.sandy.shopebackend.dto.Product;

public interface ProductDAO {
	
	Product get(int productID);
	List<Product> list();
	boolean add (Product product);
	boolean update (Product product);
	boolean delete (Product product);
	
	//business method
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCataegory(int categoryId);
	List<Product> getLatestActiveProduct(int count);
}
