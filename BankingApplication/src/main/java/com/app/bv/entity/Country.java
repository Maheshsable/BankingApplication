package com.app.bv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="country")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cid",length=3)
	private Integer id;
	@Column(name="cname",length=15, unique=true)
	private String coutnryName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCoutnryName() {
		return coutnryName;
	}
	public void setCoutnryName(String coutnryName) {
		this.coutnryName = coutnryName;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", coutnryName=" + coutnryName + "]";
	}
	
	
}
