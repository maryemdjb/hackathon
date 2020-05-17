package com.act4new.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class Users {
    @Id @GeneratedValue
    Long id ;


    String password;


    private String email;

    private Integer cin;

    private Integer phone;

    private String username;

    @Column(name = "enabled")
    private boolean enabled;

    String time;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_proprietaire")
	private List<Article> articles = new ArrayList<>();



    public Users() {
        super();
        this.enabled=false;
    }

    public Users(String username, String email,Integer cin , Integer phone, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.cin = cin;
        this.phone = phone;
    }

    public Users( String password,  String username,
                boolean enabled) {
        super();
        this.password = password;
        this.username = username;
        this.enabled = enabled;

    }

    public Users(String name) {
        this.username = name;

    }


    public Users(String name, String time) {
        this.username = name;
        this.time = time;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String name) {
        this.username = name;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getUsername() {
        return username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getTime() {
		return time;
	}







}