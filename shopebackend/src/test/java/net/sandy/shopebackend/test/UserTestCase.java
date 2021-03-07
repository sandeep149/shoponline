package net.sandy.shopebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sandy.shopebackend.dao.UserDAO;
import net.sandy.shopebackend.dto.Address;
import net.sandy.shopebackend.dto.Cart;
import net.sandy.shopebackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user  = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.sandy.shopebackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	/*
	 * @Test public void testAdd() {
	 * 
	 * user = new User();
	 * 
	 * user.setFirstName("sandeep"); user.setLastName("sharma");
	 * user.setContactNumber("34235345"); user.setEmail("sandeep@gmail.com");
	 * user.setRole("USER"); user.setPassword("12345");
	 * 
	 * // add the user 
	 * assertEquals("Faild to add user!", true,	 * userDAO.addUser(user));
	 * 
	 * 
	 * 
	 * address = new Address();
	 * 
	 * address.setAddressLineOne("m-14"); address.setAddressLineTwo("nanda nager");
	 * address.setCity("indore"); address.setState("MP");
	 * address.setCountry("India"); address.setPostalCode("45001");
	 * address.setBilling(true);
	 * 
	 * // link the user with address using user id
	 * 
	 * address.setUserId(user.getId());
	 * 
	 * // add the address assertEquals("Faild to add Address !", true,
	 * userDAO.addAddress(address));
	 * 
	 * if (user.getRole().equals("USER")) { // create a cart for user cart = new
	 * Cart(); cart.setUser(user);
	 * 
	 * // add the cart assertEquals("Faild to add Cart !", true,
	 * userDAO.addCart(cart));
	 * 
	 * 
	 * // add s shipping address for this user address = new Address();
	 * 
	 * address.setAddressLineOne("123"); address.setAddressLineTwo("BhawerKunwa");
	 * address.setCity("indore"); address.setState("MP");
	 * address.setCountry("India"); address.setPostalCode("45001");
	 * address.setShipping(true);
	 * 
	 * // link it with user address.setUserId(user.getId());
	 * 
	 * // add the shipping addres assertEquals("Faild to add shipping address!",
	 * true, userDAO.addAddress(address));
	 * 
	 * }
	 * 
	 * }
	 */
		
	/*
	 * @Test public void testAdd() {
	 * 
	 * user = new User();
	 * 
	 * user.setFirstName("sandeep"); user.setLastName("sharma");
	 * user.setContactNumber("34235345"); user.setEmail("sandeep@gmail.com");
	 * user.setRole("USER"); user.setPassword("12345");
	 * 
	 * 
	 * if (user.getRole().equals("USER")) { // create a cart for user cart = new
	 * Cart(); cart.setUser(user);
	 * 
	 * // attached card with user user.setCart(cart); } // add the user
	 * assertEquals("Faild to add user!", true, userDAO.addUser(user));
	 * 
	 * }
	 */
	

	/*
	 * @Test public void testUpdateCart() { //fetch the user by its email user =
	 * userDAO.getByEmail("");
	 * 
	 * // get the cart of the user cart = user.getCart();
	 * 
	 * cart.setGrandTotal(5555); cart.setCartLines(2);
	 * assertEquals("Faild to update the cart", true , userDAO.updateCart(cart)); }
	 */
	
	
//	@Test
//	public void testAddAddress() {
//			
//		// add a user
//		user = new User();
//		 
//		  user.setFirstName("sandeep"); 
//		  user.setLastName("sharma");
//		  user.setContactNumber("34235345"); 
//		  user.setEmail("sandeep@gmail.com");
//		  user.setRole("USER");
//		  user.setPassword("12345");
//		  
//		  // add the user 
//		  assertEquals("Faild to add user!", true, userDAO.addUser(user));
//		  
//		  
//		  
//		  address = new Address();
//		  
//		  address.setAddressLineOne("m-14"); 
//		  address.setAddressLineTwo("nanda nager");
//		  address.setCity("indore");
//		  address.setState("MP");
//		  address.setCountry("India");
//		  address.setPostalCode("45001");
//		  address.setBilling(true);
//		  
//		  address.setUser(user);
//		  
//		  assertEquals("Failed to add address !", true, userDAO.addAddress(address));
//
//		  //we are going to add the user
//		
//		
//		 // add shipping address
//		  		address.setAddressLineOne("123"); 
//		  		address.setAddressLineTwo("BhawerKunwa");
//			  address.setCity("indore"); 
//			 address.setState("MP");
//			  address.setCountry("India"); 
//			 address.setPostalCode("45001");
//			  address.setShipping(true);
//			  
//		  address.setUser(user);
//			  
//		  assertEquals("Failed to add  shipping address !", true, userDAO.addAddress(address));
//
//		
//		
//	}
	
}
