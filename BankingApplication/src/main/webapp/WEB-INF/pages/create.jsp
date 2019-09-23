


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
function checkPassword(str)
{
	var re = "[a-zA-Z0-9\s]+";
    return re.test(str);
}

function checkForm(form)
{
	  alert("checkForm function called");
	  var password=document.f1.password.value;
	  var repassword=document.f1.repassword.value;
	  alert(password+" "+repassword);
	  if(password != "" && password== repassword) {
	    if(!checkPassword(password)) {
	      alert("The password you have entered is not valid!");
	      f1.password.focus();
	      return false;
	    }
	  } else {
	    alert("Error: Please check that you've entered and confirmed your password!");
	    f1.repassword.focus();
	    return false;
	  }
	  return true;
}

</script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("function called")
		$.get("getCountry",function(data){
			alert("Country list got"+data);
			var a="<option>--Select Country--</option>";
			$.each(JSON.parse(data),function(k,v){
				alert("from each method"+v)
				a+=("<option value='"+v.id+"'>"+v.coutnryName+"</option>");
			});
			$("#country").append(a);
		});
		
		$("#country").change(function(){
			var sid=$("#country").val();
			$.get("getCountry1?cid="+sid,function(data){
				var a="<option>--Select State--</option>";
				$.each(JSON.parse(data),function(k,v){
					a+=("<option value='"+v.id+"'>"+v.stateName+"</option>");
				});
				$("#state").append(a);
			});
			
		});

		$("#state").change(function(){
			var sid=$("#state").val();
			$.get("getCity?sid="+sid,function(data){
				var a="<option>---Select City-----</option>"
				$.each(JSON.parse(data),function(k,v){
					a+="<option value='"+v.id+"'>"+v.cityName+"</option>";
				});
				$("#city").append(a);
			});
		});
	});
</script>


<SCRIPT LANGUAGE="JavaScript">
	function dil(form) {
		for (var i = 0; i < 3; i++) {
			if (!isNaN(form.elements[i].value)) {
				alert("This Field must be Char's")
				form.elements[i].value = ""
				form.elements[i].focus()
				return false
			}
		}
		if (document.F1.password.value != document.F1.repassword.value) {
		
		return true
	}
</SCRIPT>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Global Banking ..</title>
<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function ctck() {
		var sds = document.getElementById("dum");

	}
</script>

</head>

<body>

	<div id="top_links">


		<div id="header">
			<h1>
				HDFC BANK<span class="style1"></span>
			</h1>
			<h2>ExtraOrdinary Service</h2>
			<A href="index"><img src="../resources/images/home1.gif"></img></A>
		</div>

		<div id="navigation">
			<ul>
				<li><a href="create">NEW ACCOUNT</a></li>
				<li><a href="balance1">BALANCE</a></li>
				<li><a href="deposit1">DEPOSIT</a></li>
				<li><a href="withdraw1">WITHDRAW</a></li>
				<li><a href="transfer1">TRANSFER</a></li>
				<li><a href="closeac1">CLOSE A/C</a></li>
				<li><a href="about">ABOUT US</a></li>
			</ul>
		</div>



		<table style="width: 897px; background: #FFFFFF; margin: 0 auto;">
			<tr>
				<td width="300" valign="top"
					style="border-right: #666666 1px dotted;">
					<div id="services">
						<h1>Services</h1>
						<br>
						<ul>
							<li><a href="#">www.javatpoint.com</a></li>
							<li><a href="#">www.javacstpoint.com </a></li>
							<li><a href="#">www.javatpoint.com/forum.jsp</a></li>
						</ul>

					</div>
				</td>

				<td width="1200" valign="top">
					<div id="welcome" style="border-right: #666666 1px dotted;">
						<h1>OPEN ACCOUNT FORM</h1>
						<br>
						<table align="center" bgcolor="white">
							<tr>

							</tr>
							<tr>
								<td>
									<form name="f1" action="register"  method="post">
										<table cellspacing="5" cellpadding="3">

											<tr>
												<td>USER NAME:</td>
												<td><input type="text" name="username"
													required="required" onfocus="onfocus" /></td>
											</tr>
											<tr>
												<td>PASSWORD:</td>
												<td><input type="password" name="password" id="password"
													required="required" required  /></td>
											</tr>
											<tr>
												<td>RE-PASSWORD:</td>
												<td><input type="password" name="repassword" id="repassword"
													required="required" onchange="checkForm(this)"  /></td>
											</tr>
											<tr>
												<td>Email</td>
												<td><input type=email id="email1" name="email" required> </td>
											</tr>
													<td>Gender:</td>
													 <td>Male<input type="radio" name="gender" value="male" required>
													 Female<input type="radio" name="gender" value="female" required /></td>
											<tr>
												<td>ADDRESS:</td>
												<td><input type="text" name="address" id="address"
													required /></td>
											</tr>
											<tr>
												<td>PHONE:</td>
												<td><input type="number" name="phone" id="phone" required  minlength="0" maxlength="10"/></td>
											</tr>
											<tr>
												<td>BirthDay</td>
												<td><input type="date" id="date1" name="bdate" required></td>
											</tr>
											<tr>
												<td>Country</td>
												<td><select id="country" name="country" required></select></td>
											</tr>
											<tr>
												<td>State</td>
												<td><select id="state" name="state" required></select></td>
											</tr>
											<tr>
												<td>City</td>
												<td><select id="city" name="city" required></td>
											</tr>
											<tr>
												<td>pincode</td>
												<td><input type=number id="pincode" name="pincode" required> </td>
											</tr>
											<tr>
												<td></td>
												<td><input type="submit" value="Submit" /> <INPUT
													TYPE=RESET VALUE="CLEAR"></td>
											</tr>
										</table>
									</form>
								</td>
							</tr>

						</table>
					</div>
				</td>

				<td width="299" valign="top">
					<div id="welcome" style="border-right: #666666 1px dotted;">
						<h1>Welcome</h1>
						<br>
						<center>
							<img src="images/globe_10.gif" alt="business" width="196"
								height="106">
						</center>
						<br>
						<p>Each people plan their site layouts depending upon their
							business type. Here comes a free designer template which provides
							you with a selection of different kinds of webdesign starting
							from business template, fashion template, media template, Science
							template, Arts template and much more.</p>

					</div>
				</td>


			</tr>
		</table>

		<div id="footer_top">
			<div id="footer_navigation"></div>

			<div id="footer_copyright">

				<center>
					<img alt="business" width="196" height="106">
				</center>
				<br>
				<p>Each people plan their site layouts depending upon their
					business type. Here comes a free designer template which provides
					you with a selection of different kinds of webdesign starting from
					business template, fashion template, media template, Science
					template, Arts template and much more.</p>

				Copyright © Your Company Name
			</div>
		</div>


	</div>

</body>
</html>

