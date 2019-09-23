package com.app.bv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="login")
public class Login {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="lid",length=3)
	private Integer id;
	@NotEmpty
	@Column(name="userName",length=20,unique=true)
	private String userName;
	@Column(name="password",length=20,unique=true)
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", userName=" + userName + ", password="
				+ password + "]";
	}
	
	
	
	
}
