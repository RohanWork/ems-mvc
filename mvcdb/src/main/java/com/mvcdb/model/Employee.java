package com.mvcdb.model;

import java.sql.Timestamp;

public class Employee {
	private int id;
    private String name;
	private String email;
	private String address;
	private String telephone;
    private String password;
    private String gender;
    private int age;
    private String department;
    private double salary;
    private Timestamp rowInsTime;
    private Timestamp rowDelTime;
    private String status;
    private String role;
    private String modifier;
    private String token;

	public Employee() {
	}

	public Employee(int id, String name, String email, String address, String telephone, String password, String gender,
			int age, String department, double salary, Timestamp rowInsTime, Timestamp rowDelTime, String status,
			String role, String modifier, String token) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.department = department;
		this.salary = salary;
		this.rowInsTime = rowInsTime;
		this.rowDelTime = rowDelTime;
		this.status = status;
		this.role = role;
		this.modifier = modifier;
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address.toLowerCase();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department.toLowerCase();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

    public Timestamp getRowInsTime() {
		return rowInsTime;
	}

	public void setRowInsTime(Timestamp rowInsTime) {
		this.rowInsTime = rowInsTime;
	}

	public Timestamp getRowDelTime() {
		return rowDelTime;
	}

	public void setRowDelTime(Timestamp rowDelTime) {
		this.rowDelTime = rowDelTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", telephone="
				+ telephone + ", password=" + password + ", gender=" + gender + ", age=" + age + ", department="
				+ department + ", salary=" + salary + ", rowInsTime=" + rowInsTime + ", rowDelTime=" + rowDelTime
				+ ", status=" + status + ", role=" + role + ", modifier=" + modifier + ", token=" + token + "]";
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

}
