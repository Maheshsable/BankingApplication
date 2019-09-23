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
@Table(name="state")
public class State {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sid",length=10)
	private Integer id;
	@Column(name="stateName",length=10,unique=true)
	private String stateName;
	@ManyToOne(targetEntity=Country.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="cid")
	private Country country;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "State [id=" + id + ", stateName=" + stateName + ", country="
				+ country + "]";
	}

	

	
}
