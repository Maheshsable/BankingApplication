package com.app.bv.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="aid",length=10,unique = true)
	private Integer aid;
	@Column(name="pincode",length=10)
	private Integer pinCode;
	@Column(name="address",length=30)
	private String address;
	
	@ManyToOne(targetEntity=Country.class)
	@JoinColumn(name="countryId")
	private Country country;

	public Integer getId() {
		return aid;
	}

	public void setId(Integer id) {
		this.aid = id;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Country getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Address [id=" + aid + ", pinCode=" + pinCode + ", address="
				+ address + ", country=" + country + "]";
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	

}
