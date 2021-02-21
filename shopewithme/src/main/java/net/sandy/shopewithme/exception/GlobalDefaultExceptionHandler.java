package net.sandy.shopewithme.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		System.out.println("1");
		ModelAndView mv = new ModelAndView("error");
		System.out.println("2");
		mv.addObject("errorTitle","page is not construced !");
		
		mv.addObject("errorDescription","page is not available now !");
		
		mv.addObject("title", "404 page error");
		System.out.println("3");
		return mv;
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		System.out.println("1");
		ModelAndView mv = new ModelAndView("error");
		System.out.println("2");
		mv.addObject("errorTitle","product is not available !");
		
		mv.addObject("errorDescription","product is not available now !");
		
		mv.addObject("title", "Product unavailable");
		System.out.println("3");
		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		System.out.println("1");
		ModelAndView mv = new ModelAndView("error");
		System.out.println("2");
		mv.addObject("errorTitle","Eroor !");
		
		mv.addObject("title", "contect your admin");
		
		
		mv.addObject("errorDescription", ex.toString());
		
		
		System.out.println("3");
		return mv;
	}


}
