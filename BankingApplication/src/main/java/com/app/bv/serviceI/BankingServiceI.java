package com.app.bv.serviceI;

import java.util.List;

import com.app.bv.entity.Account;
import com.app.bv.entity.City;
import com.app.bv.entity.Country;
import com.app.bv.entity.Login;
import com.app.bv.entity.Register;
import com.app.bv.entity.State;

public interface BankingServiceI {

	boolean loginUser(String username, String password);

	List<Country> getCountry();

	List<State> getState(String cid);

	List<City> getCity(String sid);

	boolean saveAccountDetails(Register register);

	List getUserInfo();

	List<Account> getAccountInfo(int accNo, String username, String password);

	List<Account> depositAmount(String username, String password, String accountno,
			String amount);

	boolean withdrawAmount(String username, String password, String amount,
			String accountno);

	List<Account> getAmount(String accountno);

	boolean checkAccountAvailability(String sourceAccountNo);

	boolean amountTransfer(String sourceAccountNo, String destinationAccountNo,String amount);

	List<Account> getAccountData(String sourceAccountNo);

}
