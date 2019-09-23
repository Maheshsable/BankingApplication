package com.app.bv.constant;

public class QuerConstant {
	
	public final static String getUserData="select login.userName,login.password,account.accountNo,account.amount,address.address,register.phone from"+" "+
				 "Register as register join register.address address and register.login login "+" "
				+ "register.account account on register.account=account.accountId where register.address=address.aid and register.login=login.lid";
	public final static String getRegisterData="select add.pinCode,register.phone from Register as register join register.address add join register.login login where register.login=login.id";
    public final static String getRegisterData1="from Register";
    public final static String accountCredential="select login.userName,login.password,register.registerId from Register as register join register.login login where login.userName=? and login.password=?";
    public final static String accountCredential2="from Account as acc where acc.accountNo=?";
    public final static String depositAmount="update Account as acc set acc.amount=? where acc.accountNo=?";
    public final static String getAmount="select amount from Account where accountNo=?";
    public final static String withdrawAmount="update Account as acc set acc.amount=? where acc.accountNo=?";
    public final static String totalAmount="from Account where accountNo=?";
    public final static String checkAccountAvailability="select count(*) from Account where accountNo=?";

}
