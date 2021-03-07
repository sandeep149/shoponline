package net.sandy.shopewithme.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.sandy.shopebackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product product =(Product) target;
		
		// check where file has been selected or not
		if(product.getFile()== null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "please select an image file to upload ! ");
			 return;
		}
		
		if(! (product.getFile().getContentType().equals("image/jpeg") ||
			  product.getFile().getContentType().equals("image/png") ||
			 product.getFile().getContentType().equals("image/gif")
						)) {
			
			errors.rejectValue("file", null, "please use image file to upload !");
			return;
		}
		
	}

}
