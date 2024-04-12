//package com.mvcdb.service;
//
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import com.mvcdb.dao.EmployeeDAO;
//import com.mvcdb.model.Employee;
//import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
//
//@Service
//public class AuthService {
////	implements UserDetailsService {
//
////	
////	@Autowired
////	EmployeeDAO employeeDAO;
////
////    @Override
////    public UserDetails loadUserByUsername(String email){
////        Employee user = employeeDAO.getUserByEmail(email);
////
////        if (user != null) {
////            return new org.springframework.security.core.userdetails.User(
////            		 user.getEmail()
////            		,user.getPassword()
////                    ,null
//////                    ,
//////                    mapRolesToAuthorities(user.getRole())
////                  );
////        }
////        return null;
//////        else{
//////            throw new UsernameNotFoundException("Invalid username or password.");
//////        }
////    }
////
//////    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
//////        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
//////                .map(role -> new SimpleGrantedAuthority(role.getName()))
//////                .collect(Collectors.toList());
//////        return mapRoles;
//////    }
//}
