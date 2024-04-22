//package com.mvcdb.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import com.mvcdb.dao.EmployeeDAO;
//import com.mvcdb.model.CustomDetails;
//import com.mvcdb.model.Employee;
//
//public class CustomService implements UserDetailsService {
// 
//    @Autowired
//    private EmployeeDAO employeeDAO;
//     
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        Employee employee = employeeDAO.getUserByEmail(username);
//        
//        try {
//	        if (employee == null) {
//	            throw new Exception("User not found");
//	        }
//        }catch(Exception e) {
//        	System.out.println("\n"+e.getMessage()+"\n");
//        }
//        return new CustomDetails(employee);
//    }
//}
