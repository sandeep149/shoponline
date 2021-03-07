package net.sandy.shopewithme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.sandy.shopebackend.dao.CategoryDAO;
import net.sandy.shopebackend.dao.ProductDAO;
import net.sandy.shopebackend.dto.Category;
import net.sandy.shopebackend.dto.Product;
import net.sandy.shopewithme.exception.ProductNotFoundException;

@Controller
public class PageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		LOGGER.info("inside pagecontroller index mathod - INFO");
		LOGGER.debug("inside pagecontroller index mathod - DEBUGE");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "about us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "contact us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	// methods to load all the product based on category
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categorydao to fetch single category
		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		// passing the single of category
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	// viewing a single product

	@RequestMapping("/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");

		Product product = productDAO.get(id);

		if (product == null)
			throw new ProductNotFoundException();

		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);

		mv.addObject("title", product.getName());
		mv.addObject("product", product);

		mv.addObject("userClickShowProduct", true);
		return mv;

	}

	// having similar mapping to our flow id
	@RequestMapping(value = "/register")
	public ModelAndView register() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "about us");
		return mv;
	}

	// login
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error) {

		ModelAndView mv = new ModelAndView("login");
		if (error != null) {
			mv.addObject("message", "invalid user name and password");
		}
		mv.addObject("title", "Login");
		return mv;
	}

	// access denied mapping
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Aha ! Caught You");
		mv.addObject("errorDescription", "You are not authorized to view this page");
		return mv;
	}
}

/*
 * @RequestMapping(value = "/test") public ModelAndView test(@RequestParam(value
 * = "greeting", required = false) String greeting) {
 * 
 * if (greeting == null) { greeting = "hello there"; } ModelAndView mv = new
 * ModelAndView("page"); mv.addObject("greeting", greeting); return mv; }
 * 
 * 
 * @RequestMapping(value = "/test/{greeting}") public ModelAndView
 * test(@PathVariable("greeting") String greeting) {
 * 
 * if (greeting == null) { greeting = "hello there"; } ModelAndView mv = new
 * ModelAndView("page"); mv.addObject("greeting", greeting); return mv; }
 */