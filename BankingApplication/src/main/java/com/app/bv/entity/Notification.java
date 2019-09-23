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
@Table(name="notification")
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nid",length=10)
	private Integer id;
	@ManyToOne(targetEntity=Login.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="lid")
	private Login login;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
}
