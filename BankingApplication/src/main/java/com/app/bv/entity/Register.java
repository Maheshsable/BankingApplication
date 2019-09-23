package com.app.bv.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "register1")
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "registerId", length = 10)
	private int registerId;

	@Column(name = "email", length = 30)
	private String email;
	@Column(name = "gender", length = 10)
	private String gender;
	@Column(name = "bdate", length = 20)
	private Date date;
	@Column(name = "phone", length = 10)
	private Integer phone;

	@ManyToOne(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "aid")
	private Address address;

	@OneToMany(targetEntity = Login.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "registerId")
	private Set<Login> login;

	@OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="registerId")
	private Set<Account> account;
	
	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Login> getLogin() {
		return login;
	}

	public void setLogin(Set<Login> login) {
		this.login = login;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public Register() {
		super();
	}

	public Integer getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}	@Override
	public String toString() {
		return "Register [registerId=" + registerId + ", email=" + email
				+ ", gender=" + gender + ", date=" + date + ", phone=" + phone
				+ ", address=" + address + ", login=" + login + ", account="
				+ account + "]";
	}

	
	

}
