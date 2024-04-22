package com.mvcdb.model;

public class User {
	private String name;
	private String mail;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String name, String mail, String password) {
		super();
		this.name = name;
		this.mail = mail;
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", mail=" + mail + ", password=" + password + "]";
	}

}
