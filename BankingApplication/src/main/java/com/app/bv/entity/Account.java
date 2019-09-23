package com.app.bv.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="accountId",length=8)
	private Integer accountId;
    @Column(name="accountNo",length=16)
	private Integer accountNo;
    @Column(name="amount",length=10)
	private Integer amount;
    
	public Integer getId() {
		return accountId;
	}

	public void setId(Integer id) {
		this.accountId = id;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNo=" + accountNo
				+ ", amount=" + amount + "]";
	}

    
	
}
