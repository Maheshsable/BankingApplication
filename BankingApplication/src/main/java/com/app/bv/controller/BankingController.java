package com.app.bv.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bv.entity.Account;
import com.app.bv.entity.Address;
import com.app.bv.entity.City;
import com.app.bv.entity.Country;
import com.app.bv.entity.Login;
import com.app.bv.entity.Register;
import com.app.bv.entity.State;
import com.app.bv.serviceI.BankingServiceI;
import com.google.gson.Gson;

@RestController
@Controller
public class BankingController {

	Logger logger = Logger.getLogger("BankingController");

	@Autowired
	private BankingServiceI loginserviceI;

	@RequestMapping("/")
	public String homePage() {
		System.out.println("BankingController.homePage()");
		return "login";
	}

	@RequestMapping(value = "/home")
	public @ResponseBody String home() {
		String result = "home";
		Gson gson = new Gson();
		result = gson.toJson(result);
		return result;
	}

	@RequestMapping(value = "create")
	public @ResponseBody String create() {
		String result = "create";
		Gson gson = new Gson();
		result = gson.toJson(result);
		return result;
	}

	@RequestMapping(value = "balance")
	public @ResponseBody String balance1() {
		String result = "balance1";
		Gson gson = new Gson();
		result = gson.toJson(result);
		return result;
	}

	@RequestMapping(value = "deposit1")
	public @ResponseBody String deposit1() {
		Gson gson = new Gson();
		String result = "deposit1";
		result = gson.toJson(result);
		return result;
	}

	@RequestMapping(value = "withdraw1")
	public @ResponseBody String withdraw1() {
		String result = "withdraw1";
		Gson gson = new Gson();
		result = gson.toJson(result);
		return result;
	}

	@RequestMapping(value = "transfer1")
	public @ResponseBody String transfer1() {
		String result = "transfer1";
		Gson gson = new Gson();
		result = gson.toJson(result);
		return result;
	}

	@RequestMapping(value = "closeac1")
	public @ResponseBody String closeac1() {
		String result = "closeac1";
		Gson gson = new Gson();
		result = gson.toJson(result);
		return result;
	}

	@RequestMapping(value = "about")
	public @ResponseBody String about() {
		String result = "about";
		Gson gson = new Gson();
		result = gson.toJson(result);
		return result;
	}

	@RequestMapping(value = "balanceInquiry")
	public @ResponseBody String balanceInquiry(
			@RequestParam("accountNo") String accountNo,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session) {
		int accNo = Integer.parseInt(accountNo);
		Gson gson = new Gson();
		String result = null;
		List<Account> userList = null;
		if (accNo != 0 && username != null && password != null) {
			userList = loginserviceI.getAccountInfo(accNo, username, password);
			System.out.println("Account Info details is" + userList);
		}
		if (userList != null) {
			session.setAttribute("userList", userList);
			result = "balance";
			result = gson.toJson(userList);
			return result;
		} else {
			result = "balance1";
			result = gson.toJson(result);
			return result;
		}

	}

	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(
			@PathVariable("username") String username,
			@PathVariable("password") String password, HttpSession session,
			HttpServletRequest request) {
		Gson gson = new Gson();
		String result = null;

		try {
			boolean status = false;
			if (username.isEmpty() && password.isEmpty()) {
				logger.warning("username is" + username + " " + "password is"
						+ password);
				request.setAttribute("loginfail",
						"UserName and Password should not be null");
				result = "login";
				result = gson.toJson(result);
				return result;
			} else {
				status = loginserviceI.loginUser(username, password);
				List allData = new ArrayList();
				if (status) {
					logger.info("Login success" + username);
					session.setAttribute("username", username);
					List<Register> userData = loginserviceI.getUserInfo();
					System.out.println("data from the register" + userData);
					session.setAttribute("userData", userData);
					result = "index";
					result = gson.toJson(result);
					return result;
				} else {
					session.setAttribute("loginfail1",
							"Invalid login Credential");
					result = "create";
					result = gson.toJson(result);
					return result;
				}// else
			}// else

		} catch (Exception e) {
			logger.warning("exception caught" + e);
			System.out.println(e);
		}
		result = "index";
		result = gson.toJson(result);
		return result;
	}

*/	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody Login login, HttpSession session,
			HttpServletRequest request) {
		Gson gson = new Gson();
		String result = null;

		try {
			boolean status = false;
			if (login.getUserName().isEmpty() && login.getPassword().isEmpty()) {
				logger.warning("username is" + login.getUserName() + " " + "password is"
						+ login.getPassword());
				request.setAttribute("loginfail",
						"UserName and Password should not be null");
				result = "login";
				result = gson.toJson(result);
				return result;
			} else {
				status = loginserviceI.loginUser(login.getUserName(), login.getPassword());
				List allData = new ArrayList();
				if (status) {
					logger.info("Login success" + login.getUserName());
					session.setAttribute("username", login.getPassword());
					List<Register> userData = loginserviceI.getUserInfo();
					System.out.println("data from the register" + userData);
					session.setAttribute("userData", userData);
					result = "index";
					result = gson.toJson(userData);
					return result;
				} else {
					session.setAttribute("loginfail1",
							"Invalid login Credential");
					result = "create";
					result = gson.toJson(result);
					return result;
				}// else
			}// else

		} catch (Exception e) {
			logger.warning("exception caught" + e);
			System.out.println(e);
		}
		result = "index";
		result = gson.toJson(result);
		return result;
	}


	@RequestMapping(value = "getCountry")
	public @ResponseBody String getCountry() {

		List<Country> country = null;
		List<Country> usingjava8 = null;
		try {
			country = loginserviceI.getCountry();
			usingjava8 = country.stream().collect(Collectors.toList());
			System.out.println("from java8 country data is" + usingjava8);
		} catch (Exception e) {
			System.out.println(e);
		}
		Gson gson = new Gson();
		String result = null;
		result = gson.toJson(usingjava8);
		return result;
	}

	@RequestMapping(value = "getCountry1")
	public @ResponseBody String getCountry1(@RequestParam("cid") String cid) {

		System.out.println("Country data is" + cid);
		List<State> stateList = null;
		Map<Integer, String> state1 = null;
		// String cid=null;
		try {
			stateList = loginserviceI.getState(cid);

		} catch (Exception e) {
			System.out.println(e);
		}
		Gson gson = new Gson();
		String result = null;
		result = gson.toJson(stateList);
		return result;
	}

	@RequestMapping(value = "/getState")
	public @ResponseBody String getState(@RequestParam("cid") String cid) {

		List<State> stateList = null;
		try {
			stateList = loginserviceI.getState(cid);
			System.out.println(stateList);

		} catch (Exception e) {
			System.out.println(e);
		}
		Gson gson = new Gson();
		String result = null;
		result = gson.toJson(stateList);
		return result;
	}

	@RequestMapping(value = "/getCity")
	public @ResponseBody String getCity(@RequestParam("sid") String sid) {

		List<City> cityList = null;
		try {
			cityList = loginserviceI.getCity(sid);
			System.out.println("City list is" + cityList);
		} catch (Exception e) {
			logger.warning("exception caught");
			System.out.println(e);
		}
		Gson gson = new Gson();
		String result = null;
		result = gson.toJson(cityList);
		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody String accountOpen(
			@RequestParam("username") String username,
			@RequestParam("password") String pass,
			@RequestParam("email") String email,
			@RequestParam("gender") String gender,
			@RequestParam("city") String city,
			@RequestParam("pincode") String pincode,
			@RequestParam("country") String country,
			@RequestParam("state") String state,
			@RequestParam("address") String address,
			@RequestParam("bdate") String bdate,
			@RequestParam("phone") String phone, HttpServletRequest request,
			HttpSession session) {
		Gson gson = new Gson();
		String result1 = null;

		// convert the String value into the integer value
		int countryId = Integer.valueOf(country);
		int stateId = Integer.valueOf(state);
		int cityId = Integer.valueOf(state);
		int phoneNo = Integer.valueOf(phone);
		// convert the date into proper sql format
	//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSX");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);

	    //OffsetDateTime odt = OffsetDateTime.parse ( bdate , formatter );

		// convert the date into java understandable format
	   //	LocalDateTime ldt = LocalDateTime.parse(bdate, formatter);
		LocalDate ldt=LocalDate.parse(bdate,formatter);
		//String udate = formatter.format(ldt);
		// convert the date into the oracle date format
		java.sql.Date sqdate = java.sql.Date.valueOf(ldt);

		// get the country object
		Country c = new Country();
		c.setId(countryId);

		// get the state object
		State state1 = new State();
		state1.setId(stateId);
		state1.setCountry(c);

		// get the city class object
		City cit = new City();
		cit.setId(stateId);
		cit.setState(state1);

		// Get the address object
		Address add = new Address();
		add.setPinCode(Integer.valueOf(pincode));
		add.setAddress(address);
		add.setCountry(c);

		// get the login class object
		Login login = new Login();
		login.setUserName(username);
		login.setPassword(pass);

		Set s = new HashSet();
		s.add(login);

		// get the register class object
		Register register = new Register();
		register.setGender(gender);
		register.setEmail(email);
		register.setDate(sqdate);
		register.setLogin(s);
		register.setAddress(add);
		register.setPhone(phoneNo);
		boolean result = loginserviceI.saveAccountDetails(register);
		if (result) {
			result1 = "login";
			result1 = gson.toJson(result1);
			return result1;
		} else {
			result1 = "create";
			result1 = gson.toJson(result1);
			return result1;
		}

	}

	@RequestMapping(value = "/depositAmmount")
	public @ResponseBody String depositAmmount(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("accountno") String accountno,
			@RequestParam("amount") String amount,
			HttpSession session) {
		Gson gson = new Gson();
		String result = null;
		if (username.isEmpty()) {
			session.setAttribute("username", "UserName Cant be empty");
		}
		if (password.isEmpty()) {
			session.setAttribute("password", "password cant be empty");
		}
		if (accountno.isEmpty()) {
			session.setAttribute("accno", "Account no Cant be empty");
		}
		if (amount.isEmpty()) {
			session.setAttribute("amount", "Amount cant be empty");
		} else {
			List<Account> status = new ArrayList<Account>();
			try {
				status = loginserviceI.depositAmount(username, password,
						accountno, amount);
				if (status.size() > 0) {
					session.setAttribute("amountAdded", status);
					session.setAttribute("depositAmount",
							"Amount Added Successfully");
					result="deposit";
					result=gson.toJson(result);
					return result;
				} else {
					session.setAttribute("amountFailure",
							"Unable to Add The Amount");
					result="deposit1";
					result=gson.toJson(result);
					return result;

				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		return "deposit1";

	}

	@RequestMapping(value = "/withdrawAmount")
	public @ResponseBody String withdrawAmount(
			@RequestParam("accountno") String accountno,
			@RequestParam("amount") String amount,
			@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session,
			HttpServletRequest request) {
		Gson gson=new Gson();
		String result=null;
		if (accountno.isEmpty()) {
			request.setAttribute("accountNo", "Account No Should Not be Null");
		}
		if (amount.isEmpty()) {
			request.setAttribute("amount", "Amount Should Not Be Null");
		}
		if (username.isEmpty()) {
			request.setAttribute("username", "UserName Should not be null");
		}
		if (password.isEmpty()) {
			request.setAttribute("password", "Password Should Not Be Null");
		}
		if (accountno != null && username != null && password != null
				&& amount != null) {
			boolean status = false;
			try {
				status = loginserviceI.withdrawAmount(username, password,
						amount, accountno);
				if (status) {
					List<Account> accountData = loginserviceI
							.getAmount(accountno);
					session.setAttribute("AccountData", accountData);
					//result="withdraw";
					result=gson.toJson(accountData);
					return result;
				} else {
					session.setAttribute("invalidWithdraw",
							"Unable to withdraw Money");
					result="withdraw1";
					result=gson.toJson(result);
					return result;
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		result="withdraw";
		result=gson.toJson(result);
		return result;
	}

	@RequestMapping(value = "/transferAmount")
	public @ResponseBody String transferAmount(
			@RequestParam("amount") String amount,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("sourceAccountNo") String sourceAccountNo,
			@RequestParam("destinationAccountNo") String destinationAccountNo,
			HttpSession session) {
		//return the response as gson
		Gson gson=new Gson();
		String result=null;
		if (username != null && password != null) {
			boolean userCredential = false;
			boolean checkSourceAccountAvailability = false;
			boolean checkDestinationAccountAvailability = false;
			boolean amountTransfer = false;
			try {
				userCredential = loginserviceI.loginUser(username, password);
				if (userCredential) {
					checkSourceAccountAvailability = loginserviceI
							.checkAccountAvailability(sourceAccountNo);
					if (checkSourceAccountAvailability) {
						checkDestinationAccountAvailability = loginserviceI
								.checkAccountAvailability(destinationAccountNo);
						if (checkDestinationAccountAvailability) {
							amountTransfer = loginserviceI.amountTransfer(
									sourceAccountNo, destinationAccountNo,
									amount);
							if (amountTransfer) {
								List<Account> account = loginserviceI
										.getAccountData(sourceAccountNo);
								session.setAttribute("accountData", account);
								session.setAttribute("accountData",
										"Amount Transfer Successfully");
								result="withdraw";
								result=gson.toJson(result);
								return result;
							}
						}
					} else {
						session.setAttribute("destinationAccount",
								"Destination Account Does Not Exist");
						result="withdraw1";
						result=gson.toJson(result);
						return result;
					}
				} else {
					session.setAttribute("sourceAccount",
							"Source Account Does not Exist");
					result="withdraw1";
					result=gson.toJson(result);
					return result;
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			session.setAttribute("invalidCredential",
					"UserName and Password is Wrong");
			result="transfer1";
			result=gson.toJson(result);
			return result;
		}
		result="withdraw1";
		result=gson.toJson(result);
		return result;
	}

	@RequestMapping("/closeac2")
	public @ResponseBody String closeAccount(HttpSession session) {
		//convert the response into gson format
		Gson gson=new Gson();
		String result=null;
		result="index";
		result=gson.toJson(result);
		session.invalidate();
		return result;
	}
}