package com.phone.book.model;

public class PhoneBookForm {
	private String fname;
	private String lname;
	private String mobile;
	private String email;
	private String contacts;
	private String serviceProvider;
	private String address;
	private String country;
	private String state;
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "PhoneBookForm [fname=" + fname + ", lname=" + lname + ", mobile=" + mobile + ", email=" + email
				+ ", contacts=" + contacts + ", serviceProvider=" + serviceProvider + ", address=" + address
				+ ", country=" + country + ", state=" + state + "]";
	}
	
	
}
