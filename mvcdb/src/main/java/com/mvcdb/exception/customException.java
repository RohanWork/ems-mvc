package com.mvcdb.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@ControllerAdvice
public class customException extends RuntimeException{

	private static final long serialVersionUID = 1L;
//	private Log logger = LogFactory.getLog(customException.class);
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex, HttpServletResponse response) {
//		logger.error("Request "+request.getRequestURI()+" threw an error", ex);
//		model.addAttribute("error", "Request "+request.getRequestURI()+" threw an error\n"+ex.getMessage());
//		System.out.println("Request "+request.getRequestURI()+" threw an error\n"+ex.getMessage());
		String error = "Request "+request.getRequestURI()+" threw an error"+"<br>Exception : "+ex.getMessage();
		System.out.println("\n"+error);
		request.setAttribute("error", error);
		response.addHeader("error", error);
		try {
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
//			request.getRequestDispatcher("/WEB-INF/views/ContactForm.jsp").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		return "error";
//		return "ContactForm";
		
	}
	
//	@ExceptionHandler(CustomMessage.class)
//	public String handleCustom(HttpServletRequest request, CustomMessage ex, HttpServletResponse response) {
//		String error = "Request "+request.getRequestURI()+" threw an error"+"<br>Exception : "+ex.getMessage();
//		System.out.println("\n"+error);
//		request.setAttribute("error", error);
//		response.addHeader("error", error);
//		try {
//			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ServletException e) {
//			e.printStackTrace();
//		}
//		
//		return "error";
//	}
	
	@ExceptionHandler(CustomMessage.class)
	public ModelAndView handleCustom(HttpServletRequest request, CustomMessage ex, HttpServletResponse response) {
	    String error = "Request " + request.getRequestURI() + " threw an error<br>Exception: " + ex.getMessage();
	    System.out.println("\n" + error);

	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("error", error);
	    modelAndView.setViewName("error"); // assuming "error" is the name of the view

	    return modelAndView;
	}

}
