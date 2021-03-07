package net.sandy.shopebackend.dao;

import java.util.List;

import net.sandy.shopebackend.dto.Address;
import net.sandy.shopebackend.dto.Cart;
import net.sandy.shopebackend.dto.User;

public interface UserDAO {
	
	//add a user
	boolean addUser(User user);
	
	User getByEmail(String Email);
	
	//add user address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	

	//update a cart
	boolean updateCart(Cart cart);
}
