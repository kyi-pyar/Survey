package com.Entity;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Customer {
	int id;	
	@NotEmpty(message="user name should not be empty.")
	String name;	
	@Size(min=3,max=15,message="password length should be beteeen 3 and 15.")
	String password;
	@Email(message="email format is wrong.")
	String email;
	String role;	
	
	String profile_pic;
	
	public Customer() {
		super();
	}
	
	public Customer(int id, String name, String password, String email, String role, String profile_pic) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
		this.profile_pic = profile_pic;
	}
	

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
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
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", role="
				+ role + ", profile_pic=" + profile_pic + "]";
=======
		return "Customer [Id=" + id + ", Name=" + name + ", password=" + password + ", email=" + email + ", Role="
				+ role + "]";
>>>>>>> 5053e258919c9e50df12b930593ce0ef72e91d33
	}
	

}
