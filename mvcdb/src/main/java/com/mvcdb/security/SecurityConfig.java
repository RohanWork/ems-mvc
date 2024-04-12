//package com.mvcdb.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import com.mvcdb.service.CustomUserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	UserDetailsService detailsService;
//	
//	@Autowired
//	CustomUserDetailsService customUserDetailsService;
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(customUserDetailsService);
//	}
//	
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity
//				.authorizeRequests()
//					.antMatchers("/welcome").permitAll()
//					.anyRequest().authenticated()
//					.and()
//				.formLogin()
//					.loginPage("/login")
//					.permitAll()
//					.and()
//				.logout()
//					.logoutUrl("/logout")
//					.logoutSuccessUrl("/welcome")
//					.permitAll();
//	}
//
//	
//}
