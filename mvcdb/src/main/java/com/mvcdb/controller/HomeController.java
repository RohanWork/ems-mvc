package com.mvcdb.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mvcdb.dao.EmployeeDAO;
import com.mvcdb.exception.CustomMessage;
import com.mvcdb.model.Employee;

@Controller
@SessionAttributes("user")
public class HomeController {

	@Autowired
	private EmployeeDAO employeeDAO;
		
	private static String modifier="";
//	private static String session="";
	
	private String generateToken() {
		return RandomStringUtils.randomAlphanumeric(6);
	}	
	
	@RequestMapping(value="/")
	public ModelAndView welcome(@ModelAttribute("user") String userName, ModelAndView model) {
		System.out.println("Session from the Welcome : "+userName);

		if(userName.equals("")) {
			model.setViewName("redirect:/loginP");
		}else {
			model.addObject("name", userName);
			model.setViewName("Welcome");
		}
		return model;
	}
	
	@RequestMapping(value="/login")
	@ModelAttribute("user")
    public ModelAndView login(@ModelAttribute Employee employee, ModelAndView model) throws Exception{
		Employee exists = employeeDAO.getUserByEmail(employee.getEmail());

		if (validateEmployee(exists, employee)) {
			model.addObject("user", exists.getName());
			
			String name = exists.getName();
			exists.setModifier(name);
			modifier=exists.getModifier();
			model.addObject("name", name);
			model.setViewName("Welcome");
		}
		else {
			model.addObject("error", "Employee not found with id "+"<h6 style=\"color: white;\">"+employee.getEmail()+"</h6>"+"Please check your Id and Password");
			model.setViewName("Login");
		}
		
        return model;
    }	
	
	@RequestMapping(value="/loginP")
    public ModelAndView loginP(ModelAndView model){
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("Login");
        
		return model;
    }	
	
	@RequestMapping(value="/data")
	public ModelAndView listEmployee(ModelAndView model) {
		List<Employee>listEmployee = employeeDAO.list();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("Data");
		
		return model;
	}
	
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employee newEmployee = new Employee();
		model.addObject("employee", newEmployee);
		model.setViewName("ContactForm");
		
		return model;
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Employee employee, Model model) {
		employee.setToken(generateToken());
		List<Employee> checkIds = employeeDAO.getAuditList();
		
		boolean exists = checkIds.stream().anyMatch(response ->  response.getToken().equals(employee.getToken()));
		if(exists) {
			model.addAttribute("error", "Please refresh the page");
			return new ModelAndView("ContactForm");
		}
		if (employee.getAge()<19 || employee.getAge()>80) {
			model.addAttribute("errorAge", "Please ensure that provided age meet requirements");
			return new ModelAndView("ContactForm");
		}
		if (!validateMail(employee.getEmail())) {
			model.addAttribute("errorEmail", "Please ensure that the provided mail id is valid");
			return new ModelAndView("ContactForm");
		}
		if (!validateNumber(employee.getTelephone())) {
			model.addAttribute("errorTelephone", "Please ensure that the provided number is valid");
			return new ModelAndView("ContactForm");
		}
		if (!validatePassword(employee.getPassword())) {
			model.addAttribute("errorPassword", "Please ensure that provided password meet requirements");
			return new ModelAndView("ContactForm");
		}
		if (!validateSalary(employee.getSalary())) {
			model.addAttribute("errorSalary", "Please ensure that provided salary meet requirements");
			return new ModelAndView("ContactForm");
		}

		if (!validateSalary(employee.getSalary())) {
			model.addAttribute("errorSalary", "Please ensure that provided salary meet requirements");
			return new ModelAndView("ContactForm");
		}
		
		try {
			System.out.println("Modifier from the Save : "+modifier);
			employee.setModifier(modifier);
			employeeDAO.saveOrUpdate(employee);	
		}catch(Exception ex) {
			model.addAttribute("error", ex.getMessage());
			return new ModelAndView("ContactForm");
		}
		
		return new ModelAndView("redirect:/data");
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeDAO.delete(employeeId);
		
		return new ModelAndView("redirect:/data");
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeDAO.getFormMain(employeeId);
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("employee", employee);
		
		return model;
	}
	
	@RequestMapping(value="/auditList", method = RequestMethod.GET)
	public ModelAndView auditList(ModelAndView model) {
		List<Employee> auditList = employeeDAO.getAuditList();
		model.addObject("auditList", auditList);
		model.setViewName("Audit");
		
		return model;
	}
	
	private boolean validateMail(String mail) {
		Pattern pattern = Pattern.compile("^([A-Za-z0-9._]{8,54})+@([A-Za-z0-9]{2,})+\\.[A-Za-z]{2,}$");
        Matcher matcher = pattern.matcher(mail);
		
        return matcher.matches();
	}
	
	private boolean validateNumber(String number) {
		Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(number);
		
        return matcher.matches();
	}
	
	private boolean validatePassword(String password) {
		Pattern pattern = Pattern.compile("^[A-Za-z0-9._!@#$%^&*?]{8,15}$");//need to change the limit to 8-15 : done
        Matcher matcher = pattern.matcher(password);
		
        return matcher.matches();
	}
	
	private boolean validateSalary(double d) {
		String salaryString = Double.toString(d);
	    Pattern pattern = Pattern.compile("^([0-9]{4,10})+(\\.[0-9]{1,2})?$");
	    Matcher matcher = pattern.matcher(salaryString);
	    
	    return matcher.matches();
	}
	
//	private boolean validateEmployee(Employee empExists, Employee empLogin) {
//		if(empExists.getEmail().equals(empLogin.getEmail())) {
//			if (empExists.getPassword().equals(empLogin.getPassword())) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
	private boolean validateEmployee(Employee empExists, Employee empLogin) {
	    if(empExists==null) {
	    	return false;
	    }
		if (empExists.getEmail().equals(empLogin.getEmail())) {
	        return empExists.getPassword().equals(empLogin.getPassword());
	    }
	    return false;
	}
}
