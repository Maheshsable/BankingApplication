package com.app.bv.daoImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.bv.constant.QuerConstant;
import com.app.bv.daoI.BankingDaoI;
import com.app.bv.entity.Account;
import com.app.bv.entity.City;
import com.app.bv.entity.Country;
import com.app.bv.entity.Login;
import com.app.bv.entity.Register;
import com.app.bv.entity.State;

@Repository
public class BankingDaoImpl implements BankingDaoI {
	Logger logger = Logger.getLogger("BankingDaoI");

	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public int loginUser(String username, String password) {
		final String query = "select count(*) from Login where username=? and password=?";
		Session session = null;
		Transaction tx = null;
		int loginCredential = 0;
		Long result = 0l;
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		try {
			// open the sessio
			session = factory.openSession();

			Query q = session.createQuery(query);
			q.setParameter(0, username);
			q.setParameter(1, password);
			tx = session.beginTransaction();
			result = (Long) q.uniqueResult();
			System.out.println(result);

			if (result == 1) {
				loginCredential = 1;
			} else {
				loginCredential = 0;
			}

		} catch (Exception e) {
			logger.warning("Exception caught" + e);
			System.out.println(e);
		}
		return loginCredential;
	}

	@Override
	public List<Country> getCountry() {
		final String getCountry = "from Country";
		Session session = null;
		Transaction tx = null;
		List<Country> country = null;
		Query query = null;
		try {
			// open the session
			session = factory.openSession();
			logger.info("create a query");
			query = session.createQuery(getCountry);

			// begin the transactio
			tx = session.beginTransaction();
			// get the list
			country = query.list();
			logger.info("List of country from the dao class is" + country);
		} catch (Exception e) {
			tx.rollback();
			logger.warning("Exception is" + e);
			System.out.println(e);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					logger.warning("Unable to close the session");
					System.out.println(e);
				}// end of try

			}// end of if
		}// end of finally

		return country;
	}// end of method

	@Override
	public List<State> getState(String cid) {

		final String stateList = "select s.id,s.stateName from State as s join s.country c where s.country=c.id and c.id=?";
		final String query1 = "select model.id,model.stateName from State as model join model.country c where model.country=c.id and model.country.id=?";
		Session session = null;
		Transaction tx = null;
		ArrayList<State> state = null;
		Query query = null;
		Integer sid = new Integer(cid);
		ArrayList al = new ArrayList();
		try {
			// open the session
			session = factory.openSession();
			tx = session.beginTransaction();
			query = (Query) session.createQuery(stateList);
			// set the parameter to the query
			query.setParameter(0, sid);
			// open the transaction
			state = (ArrayList) query.list();
			Iterator it = state.iterator();
			while (it.hasNext()) {
				State s = new State();
				Object obj[] = (Object[]) it.next();
				s.setId(Integer.parseInt(String.valueOf(obj[0])));
				s.setStateName(String.valueOf(obj[1]));
				System.out.println(s);
				al.add(s);

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return al;
	}

	@Override
	public List<City> getCity(String sid) {
		final String cityList = "select model.id,model.cityName from City as model join model.state s where model.state=s.id and s.id=?";
		Session session = null;
		Transaction tx = null;
		List<City> city = null;
		Integer stateId = new Integer(sid);
		Query query = null;
		ArrayList al = new ArrayList();
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			query = session.createQuery(cityList);
			// set the parameter to the query
			query.setParameter(0, stateId);
			city = query.list();
			Iterator it = city.iterator();
			while (it.hasNext()) {
				Object[] ob = (Object[]) it.next();
				City city1 = new City();
				city1.setId(Integer.parseInt(String.valueOf(ob[0])));
				city1.setCityName(String.valueOf(ob[1]));
				al.add(city1);
			}

		} catch (Exception e) {
			logger.warning("Exception caught" + e);
			System.out.println(e);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					logger.warning("unable to close the session");
					System.out.println(e);
				}// end of catch
			}// end of if
		}// end of finally

		return al;
	}// end of method

	@SuppressWarnings("finally")
	@Override
	public int saveAccountDetails(Register register) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		int result = 0;
		try {
			// get the session object
			session = factory.openSession();
			// open the transaction
			tx = session.beginTransaction();
			result = (Integer) session.save(register);
			// commit the transaction
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
			tx.rollback();

		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			return result;
		}

	}

	@Override
	public List getUserInfo() {
		Session session = null;
		Transaction tx = null;
		List list = null;
		Query query = null;
		try {
			session = factory.openSession();
			// create the query
			query = session.createQuery(QuerConstant.getRegisterData1);
			list = query.list();
		} catch (Exception e) {
			logger.warning("exception caught");
			System.out.println(e);
		} finally {
			if (session != null)
				try {
					session.close();
				} catch (Exception e) {
					System.out.println();
				}
		}
		return list;
	}

	@Override
	public List<Account> getAccountInfo(int accNo, String username,
			String password) {

		Session session = null;
		Session session1 = null;
		Transaction tx = null;
		Query q = null;
		Query q1 = null;
		List<Login> reg = new ArrayList<Login>();
		List<Account> acc = new ArrayList<Account>();
		List<Account> accountData = new ArrayList<Account>();
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			q = session.createQuery(QuerConstant.accountCredential);
			q.setParameter(0, username);
			q.setParameter(1, password);
			reg = q.list();

			if (reg != null) {
				session1 = factory.openSession();
				q1 = session1.createQuery(QuerConstant.accountCredential2);
				q1.setParameter(0, accNo);
				acc = q1.list();

			}
		} catch (Exception e) {
			System.out.println(e);
			tx.rollback();
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if (session1 != null) {
				try {
					session1.close();
				} catch (Exception e3) {
					System.out.println(e3);
				}
			}
		}
		return acc;
	}

	@Override
	public List<Account> depositAmount(String username, String password,
			String accountno, String amount) {
		Session session = null;
		Transaction tx = null;
		Session session1 = null;
		Session session3 = null;
		List<Account> accountList = new ArrayList<Account>();
		List loginData = new ArrayList();
		List amountData = new ArrayList();
		List finalAmountData = new ArrayList();
		Query q = null;
		Query q2 = null;
		Query q3 = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			q = session.createQuery(QuerConstant.accountCredential);
			q.setParameter(0, username);
			q.setParameter(1, password);
			loginData = q.list();
			if (loginData.size() >= 1) {
				session1 = factory.openSession();
				q2 = session1.createQuery(QuerConstant.getAmount);
				q2.setParameter(0, Integer.parseInt(accountno));
				amountData = q2.list();
				Iterator it = amountData.iterator();
				if (amountData.size() > 0) {
					while (it.hasNext()) {
						int amount1 = (int) it.next();
						int result = 0;
						int finalAmount = amount1 + Integer.valueOf(amount);
						session3 = factory.openSession();
						q3 = session3.createQuery(QuerConstant.depositAmount);
						q3.setInteger(0, finalAmount);
						q3.setInteger(1, Integer.parseInt(accountno));
						result = q3.executeUpdate();
						if (result != 0) {
							Account acc = new Account();
							acc.setAccountNo(Integer.parseInt(accountno));
							acc.setAmount(finalAmount);
							amountData.add(acc);
						}
					}

				}
				System.out.println("Amount Data is" + amountData);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return amountData;
	}

	@Override
	public boolean withdrawAmount(String username, String password,
			String amount, String accountno) {
		Session session = null;
		Session session1 = null;
		Session session2 = null;
		Transaction tx = null;
		List logindata = new ArrayList();
		List getAmount = new ArrayList();
		List withdrawAmount = new ArrayList();
		Query q1 = null;
		Query q2 = null;
		Query q3 = null;
		int result4 = 0;
		session = factory.openSession();
		q1 = session.createQuery(QuerConstant.accountCredential);
		q1.setParameter(0, username);
		q1.setParameter(1, password);
		logindata = q1.list();
		if (logindata.size() > 0) {
			session1 = factory.openSession();
			q2 = session1.createQuery(QuerConstant.getAmount);
			// set the amount to the query param
			q2.setParameter(0, Integer.parseInt(accountno));
			getAmount = q2.list();
			Iterator it = q2.iterate();
			while (it.hasNext()) {
				int result = (int) it.next();
				int amount1 = Integer.parseInt(amount);
				int finalAmount = result - amount1;
				logger.info("Total amount after deduct is" + finalAmount);
				session2 = factory.openSession();
				q3 = session2.createQuery(QuerConstant.withdrawAmount);
				q3.setParameter(0, finalAmount);
				q3.setParameter(1, Integer.parseInt(accountno));
				result4 = q3.executeUpdate();
				if (result4 != 0) {
					Account acc = new Account();
					acc.setAccountNo(Integer.parseInt(accountno));
					acc.setAmount(finalAmount);
					withdrawAmount.add(acc);
				}
			}
		}
		if (withdrawAmount.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Account> getAmount(String accountno) {

		Session session = null;
		Transaction tx = null;
		Query q1 = null;
		List<Account> accountData = new ArrayList<Account>();
		session = factory.openSession();
		tx = session.beginTransaction();
		q1 = session.createQuery(QuerConstant.totalAmount);
		// set the parameter to the query param
		q1.setParameter(0, Integer.parseInt(accountno));
		accountData = q1.list();
		return accountData;
	}

	@Override
	public boolean checkAccountAvailability(String sourceAccountNo) {
		Session session = null;
		Transaction tx = null;
		Query q1 = null;
		Long uniqueResult = 0l;
		int accountAvailability = Integer.parseInt(sourceAccountNo);
		List checkAccount = null;
		session = factory.openSession();
		tx = session.beginTransaction();
		q1 = session.createQuery(QuerConstant.query);
		q1.setParameter(0, accountAvailability);
		uniqueResult = (Long) q1.uniqueResult();
		if (uniqueResult==1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean amountTransfer(String sourceAccountNo,
			String destinationAccountNo,String Amount) {

		//convert amount into the int
		Integer amount=Integer.parseInt(Amount);
		Session session = null;
		Session session1 = null;
		Session session3 = null;
		Transaction tx = null;
		Integer sourceAmount=null;
		Integer sourceAmount1=0;
		int destinationamount=0;
		int destinationAmountUpdated=0;
		Query q1 = null;
		Query q2 = null;
		Query q3 = null;
		Query q4 = null;
		int souceAmountDeducted=0;
		List<Account> firstAccountAmount = new ArrayList<Account>();
		try{
		// get the amount from the first account
		session = factory.openSession();
		tx = session.beginTransaction();
		q1 = session.createQuery(QuerConstant.getAmount);
		q1.setParameter(0, Integer.parseInt(sourceAccountNo));
		sourceAmount = (Integer)q1.uniqueResult();
		sourceAmount1=sourceAmount;
		if (sourceAmount1!=0) {
			session1=factory.openSession();
			q2=session1.createQuery(QuerConstant.getDestinationAmount);
			q2.setParameter(0, Integer.parseInt(destinationAccountNo));
			//set the parameter to the query
			destinationamount=(int)q2.uniqueResult();
			
			//update the destination account with amount 
			session3= factory.openSession();
			q3=session3.createQuery(QuerConstant.updateDestinationAmount);
			q3.setParameter(0, sourceAmount1+destinationamount);
			q3.setParameter(1, Integer.parseInt(destinationAccountNo));
			destinationAmountUpdated=(int)q3.executeUpdate();
			if(destinationAmountUpdated==1){
				//deduct the source account amount
				Session session4=factory.openSession();
				Query q5=session4.createQuery(QuerConstant.updateSourceAccount);
				q5.setParameter(0, (sourceAmount-amount));
				q5.setParameter(1, Integer.parseInt(sourceAccountNo));
				souceAmountDeducted=(int)q5.executeUpdate();
				if(souceAmountDeducted==1){
					//commit the transaction
					tx.commit();
					
				}
			}

		}
		}
		catch(Exception e){
			tx.rollback();
			System.out.println(e);
		}
		
		if(souceAmountDeducted!=0){
			return  true;
		}else{
			return false;
		}
	}

	@Override
	public List<Account> getAccountData(String sourceAccountNo) {
		//get the session object
		
		Session session=null;
		Transaction tx=null;
		List<Account> account=new ArrayList<Account>();
		Query q=null;
		//get the factory object
	    session=factory.openSession();
	    q=session.createQuery(QuerConstant.getAccountData);
	    q.setParameter(0, Integer.parseInt(sourceAccountNo));
	    account=q.list();
		return account;
	}
}
