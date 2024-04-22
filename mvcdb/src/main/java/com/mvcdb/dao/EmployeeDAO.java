package com.mvcdb.dao;

import java.util.List;

import com.mvcdb.model.Employee;

public interface EmployeeDAO {
	
	public void saveOrUpdate(Employee employee);
	
	public void delete(int employeeId);
	
	public Employee getFormMain(int employeeTd);
	
	public List<Employee> list();

	public String generateTokenTest();

	public List<Employee> getAuditList();
	
	public Employee getUserByEmail(String email);
}
