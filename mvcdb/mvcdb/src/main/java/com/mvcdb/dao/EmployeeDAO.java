package com.mvcdb.dao;

import java.util.List;

import com.mvcdb.model.Employee;

public interface EmployeeDAO {
	
	public void saveOrUpdate(Employee employee);
	
	public void delete(int contactId);
	
	public Employee getFormMain(int contactId);
	
	public List<Employee> list();

	public String generateTokenTest();

	public List<Employee> getAuditList();
}
