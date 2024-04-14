package com.mvcdb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth == null) {
//			new SecurityContextLogoutHandler().logout(request, response, auth);

//			System.out.println("\nSESS from LOGOUT : "+request.getSession().getAttribute("user"));
			request.getSession().invalidate();
//			System.out.println("\nSESS from LOGOUT : "+request.getSession().getAttribute("user"));
		}
		
		return "Secondary";
	}
}
