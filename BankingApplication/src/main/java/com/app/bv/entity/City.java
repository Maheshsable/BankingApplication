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
@Table(name="city")
public class City {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cityId",length=10)
	private Integer id;
	@Column(name="cityName",length=10)
	private String cityName;
	@ManyToOne(targetEntity=State.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="sid")
	private State state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + ", state=" + state
				+ "]";
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	
}
