package net.sandy.shopebackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sandy.shopebackend.dao.UserDAO;
import net.sandy.shopebackend.dto.Address;
import net.sandy.shopebackend.dto.Cart;
import net.sandy.shopebackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String Email) {
		
		String selectQuery = "FROM User WHERE Email = :Email";
 		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, User.class)
						.setParameter("Email", Email)
						.getSingleResult();
		} 
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND billing = :billing";
		
		try {			
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
									.setParameter("user", user)
									.setParameter("billing", true).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		
	}

	@Override
	public List<Address> listShippingAddresses(User user) {
			String selectQuery = "FROM Address WHERE user = :user AND shipping = :shipping";
		
		try {			
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
									.setParameter("user", user)
									.setParameter("shipping", true).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
