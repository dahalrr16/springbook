package com.train.book.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.train.book.model.Address;
//to make a spring bean from a class, we must have @Component annotation 
@Component
public class BookPublisher {
	@Value("${publisher.logo:Hurray}")  //to inject the value of variable or field
	private String logo;
	@Value("${publisher.name:JPT}")
	private String name;
	private Address address;
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
