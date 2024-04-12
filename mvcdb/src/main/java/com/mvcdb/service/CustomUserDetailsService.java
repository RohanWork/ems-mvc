package com.mvcdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.mvcdb.dao.EmployeeDAO;
import com.mvcdb.model.Employee;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	EmployeeDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String email) {
		Employee employee = dao.getUserByEmail(email);
		
		return org.springframework.security.core.userdetails.User
				.withUsername(employee.getEmail())
				.password(employee.getPassword())
				.roles("USER")
				.build();
	}
}
