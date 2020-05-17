package com.act4new.backend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class UserDTO {
	  @NotBlank
	    @Size(min = 3, max = 20)
	    private String username;
	 
	    @NotBlank
	    @Size(max = 50)
	    @Email
	    private String email;
	    
	    @NotBlank
	    @Size(min = 6, max = 40)
	    private String password;

	    private Integer cin;

	    private Integer phone;
	  
	    public String getUsername() {
	        return username;
	    }
	 
	    public void setUsername(String username) {
	        this.username = username;
	    }
	 
	    public String getEmail() {
	        return email;
	    }
	 
	    public void setEmail(String email) {
	        this.email = email;
	    }
	 
	    public String getPassword() {
	        return password;
	    }
	 
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public Integer getCin() {
		return cin;
	}
	    public void setCin(Integer cin) {
		this.cin = cin;
	}


	    public Integer getPhone() {
		return phone;
	}
	    public void setPhone(Integer phone) {
		this.phone = phone;
	}

	    
	    
}
