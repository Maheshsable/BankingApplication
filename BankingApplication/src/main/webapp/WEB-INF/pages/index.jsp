<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Global Banking ..</title>
<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
<%
String userName=(String)session.getAttribute("username");
System.out.print(userName);
if(userName.isEmpty()){%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
}
%>
<script type="text/javascript">

function ctck()
{

}
</script>

</head>

<body>

<div id="top_links">
  

<div id="header">
	<h1>HDFC BANK<span class="style1"></span></h1>
    <h2>ExtraOrdinary Service</h2>	
</div>

<div id="navigation">
    <ul>
    <li><a href="create">NEW ACCOUNT</a></li>
    <li><a href="balance">BALANCE</a></li>
    <li><a href="deposit1">DEPOSIT</a></li>
    <li><a href="withdraw1">WITHDRAW</a></li>
    <li><a href="transfer1">TRANSFER</a></li>
    <li><a href="closeac1">CLOSE A/C</a></li>
    <li><a href="about">Contact Us</a></li>
    </ul>
</div>



<table style="width:897px; background:#FFFFFF; margin:0 auto;">
<tr >
	<td width="300" valign="top" style="border-right:#666666 1px dotted;">
    	<div id="services"><h1>Services</h1><br>
		    <ul>
        	<li><a href="#">www.javatpoint.com</a></li>
            <li><a href="#">www.javacstpoint.com </a></li>
            <li><a href="#">www.javatpoint.com/forum.jsp</a></li>
            </ul>
			
       </div>
	</td>
    
    <td width="1200" valign="top">
    	
    	<% 
%>
<table border=0>
<tr>
<th>UserName</th>
<th>Password</th>
<th>Account No</th>
<th>Amount</th>
<th>Address</th>
<th>Phone No</th>
</tr>
<c:forEach items="${userData}" var="userData">
<tr>
<c:forEach items="${userData.login}" var="login">
<td><c:out value="${login.userName}"></c:out></td>
<td><c:out value="${login.password}"></c:out></td>
 </c:forEach>
 <c:forEach items="${userData.account}" var="account">
<td><c:out value="${account.accountNo}"></c:out></td>
 <td><c:out value="${account.amount}"></c:out></td>
 </c:forEach>
<td><c:out value="${userData.address.address}"></c:out></td>
<td><c:out value="${userData.phone}"></c:out></td>

<td></td>
</tr>
</c:forEach>

</table>


<%@ page import="java.sql.*"%>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*"%>
  




   
