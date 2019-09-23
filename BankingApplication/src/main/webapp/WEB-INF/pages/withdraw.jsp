<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Global Banking ..</title>
<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function ctck()
{

}
</script>

</head>

<body>

<div id="top_links">
  
  <%
String userName=(String)session.getAttribute("username");
System.out.print(userName);
if(userName.isEmpty()){%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
}
%>

<div id="header">
	<h1>HDFC  BANK<span class="style1"></span></h1>
    <h2>ExtraOrdinary Service</h2>	
</div>

<div id="navigation">
    <ul>
    <li><a href="create">NEW ACCOUNT</a></li>
    <li><a href="balance1">BALANCE</a></li>
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
    <table border="0">
    <tr>
    <th>Account No</th>
    <th>Amount</th>
    </tr>
    <c:forEach items="${AccountData}" var="withdraw">
    <tr>
     <td><c:out value="${withdraw.accountNo}"></c:out></td>
 -    <td><c:out value="${withdraw.amount}"></c:out>
    </tr>
    </c:forEach>
    
    </table>
 
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*"%>


   
