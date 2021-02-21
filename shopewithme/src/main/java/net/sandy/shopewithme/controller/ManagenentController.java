package net.sandy.shopewithme.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.sandy.shopebackend.dao.CategoryDAO;
import net.sandy.shopebackend.dao.ProductDAO;
import net.sandy.shopebackend.dto.Category;
import net.sandy.shopebackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagenentController {
			
	@Autowired
	private CategoryDAO categoryDAO; 
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET )
	public ModelAndView showManageProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title" , "Manage Products");
		
		Product nProduct = new Product();
		//set few properties for new products
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product" , nProduct);
		
		return mv;
	}
	
	
	//handle product submission form
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission (@Valid @ModelAttribute("product") Product mProduct, 
												BindingResult results, Model model) {
		// check for any result
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
						
			return "page";
		}
		
		
		//Logger.info(mProduct.toString());
		
		//create a new product record
		productDAO.add(mProduct);
				
		return "redirect:/manage/products?operation=product";
		
	}
	
	//returning category for all the request 
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
	}
		
}
