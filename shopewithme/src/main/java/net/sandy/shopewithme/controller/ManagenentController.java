package net.sandy.shopewithme.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jdk.internal.org.jline.utils.DiffHelper.Operation;
import net.sandy.shopebackend.dao.CategoryDAO;
import net.sandy.shopebackend.dao.ProductDAO;
import net.sandy.shopebackend.dto.Category;
import net.sandy.shopebackend.dto.Product;
import net.sandy.shopewithme.util.FileUploadUtility;
import net.sandy.shopewithme.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagenentController {
			
	@Autowired
	private CategoryDAO categoryDAO; 
	
	@Autowired
	private ProductDAO productDAO;
	

	@RequestMapping(value = "/products", method = RequestMethod.GET )
	public ModelAndView showManageProducts(@RequestParam(name= "operation",required = false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title" , "Manage Products");
		
		Product nProduct = new Product();
		//set few properties for new products
		nProduct.setSupplierId(1); 
		nProduct.setActive(true);
		
		mv.addObject("product" , nProduct);
		if(operation != null) {
			if(operation.equals("product")){
				mv.addObject("message", "Product submitted successfully!");
			}	
			else if (operation.equals("category")) {
				mv.addObject("message", "Category submitted successfully!");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {
		
		System.out.println("1");
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title" , "Manage Products");
		
		// fetch the product from data base
		Product nProduct = productDAO.get(id);
		//set the product fetch from database
		
		mv.addObject("product" , nProduct);
				
		return mv;
	}
	
	
	//handle product submission form
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission (@Valid @ModelAttribute("product") Product mProduct, 
										BindingResult results, Model model, HttpServletRequest request) {
	
		// handle image validation for new products
		if(mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		// check for any error
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation Failed for product submitation ! ");		
			return "page";
		}
		//Logger.info(mProduct.toString());
		
		if (mProduct.getId()==0) {
			//create a new product record
			productDAO.add(mProduct);
		}
		else {
			// update the product if id is not 0
			productDAO.update(mProduct);
		}
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
			
		return "redirect:/manage/products?operation=product";
		
	}
	
	//
	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		
		System.out.println("2");
		//is going to fetch product from data base
		Product product = productDAO.get(id); 
		// activating and deactivating based on the value of activation field
		boolean isActive = product.isActive();
		// activating and deactivating based on the value of activation field
		product.setActive(!product.isActive());
		// update the product
		productDAO.update(product);
				
		System.out.println(1);
		return (isActive)? "You have succesfully deactivated the product with di" +product.getId() 
						:	"You have succesfully activated the product with di" +product.getId() ;
	}
	
	// to handle category submission
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String handleCategorySubmission( @ModelAttribute Category category) {
		
		categoryDAO.add(category);
		return "redirect:/manage/products/?operation=category";
	}
	
	
	//returning category for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		
		
		return new Category();
	}
	
	
		
}
