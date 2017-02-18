package com.rest.bean;

import java.io.Serializable;  

import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement
public class User implements Serializable {  
	private static final long serialVersionUID = 1L; 
	
	private String fName = "";
	private String lName = "";
	private String email = "";
	private String pass = "";
	
	public User(){}
	
	public User(String fName, String lName, String email, String pass){
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pass = pass;
		
	}

	public String getfName() {
		return fName;
	}

	@XmlElement
	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	@XmlElement
	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	@XmlElement
	public void setPass(String pass) {
		this.pass = pass;
	}
} 