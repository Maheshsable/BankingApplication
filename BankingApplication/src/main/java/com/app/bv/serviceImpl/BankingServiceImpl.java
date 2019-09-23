package com.app.bv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.bv.daoI.BankingDaoI;
import com.app.bv.entity.Account;
import com.app.bv.entity.City;
import com.app.bv.entity.Country;
import com.app.bv.entity.Register;
import com.app.bv.entity.State;
import com.app.bv.serviceI.BankingServiceI;

@Service
public class BankingServiceImpl implements BankingServiceI {
	
	@Autowired
	private BankingDaoI bankingdoi;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public boolean loginUser(String username, String password) {
		boolean result;
		int result1=0;
		result1=bankingdoi.loginUser(username,password);
		if(result1!=0){
			result=true;
		}else{
			result= false;
		}
		return result;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
 public List<Country> getCountry() {
		return bankingdoi.getCountry();
	}

	@Override
	public List<State> getState(String cid) {
		return bankingdoi.getState(cid);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<City> getCity(String sid) {

		return bankingdoi.getCity(sid);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,rollbackFor=Exception.class)
	public boolean saveAccountDetails(Register register) {
		
		int registerCredential=bankingdoi.saveAccountDetails(register);
		if(registerCredential!=0){
			return true;
		}else{
			return false;
		}
		
	}//end of method

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,rollbackFor=Exception.class)
	public List getUserInfo() {
		
		return bankingdoi.getUserInfo();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,rollbackFor=Exception.class)
	public List<Account> getAccountInfo(int accNo, String username,
			String password) {
		return bankingdoi.getAccountInfo(accNo,username,password);
	}

    @Transactional(propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
	public List<Account> depositAmount(String username, String password,
			String accountno, String amount) {
    	
		return bankingdoi.depositAmount(username,password,accountno,amount);
	}

    @Transactional(propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
    public boolean withdrawAmount(String username, String password,
			String amount, String accountno) {
		return bankingdoi.withdrawAmount(username,password,amount,accountno);
	}

    @Transactional(propagation=Propagation.REQUIRED,readOnly=true,rollbackFor=Exception.class)
    public List<Account> getAmount(String accountno) {
		return bankingdoi.getAmount(accountno);
	}

    @Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,rollbackFor=Exception.class)
    public boolean checkAccountAvailability(String sourceAccountNo) {
		return bankingdoi.checkAccountAvailability(sourceAccountNo);
	}

    @Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,rollbackFor=Exception.class)
    public boolean amountTransfer(String sourceAccountNo,
			String destinationAccountNo) {
		return bankingdoi.amountTransfer(sourceAccountNo,destinationAccountNo);
	}

}
