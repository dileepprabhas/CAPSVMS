<!DOCTYPE html> 
<html lang="en">
<head>
<title>Sarv Hitkari VMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Teach For India , PrismVMS " />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" media="all" />
<!--// css -->
<!-- font -->
<link href="//fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- //font -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/kj.js"></script>
<link rel="shortcut icon" href="images/logo2_.ico" />
<style type="text/css">
 body
 {
 overflow-x:hidden; 
 }
#regForm {
  background-color: #ffffff;
  margin: 0px auto;
  font-family: Raleway;
  padding: 40px;
  width: 70%;
  min-width: 300px;
}

h1 {
  text-align: center;  
}

input {
    padding: 10px;
  width: 90%;
  font-size: 17px;
  font-family: Raleway;
  border: none;
}
select
{
  padding: 10px;
  width: 95.2%;
  font-size: 17px;
  font-family: Raleway;
  border: none; 
}

input [type='date'] {
  padding: 10px;
  width: 40%;
  font-size: 17px;
  font-family: Raleway;
  border: none;
}


/* Mark input boxes that gets an error on validation: */
input.invalid,select.invalid {
  background-color: #ffdddd;
}
 
button {
  background-color: #053256;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  font-size: 17px;
  font-family: Raleway;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}

#prevBtn {
  background-color: #053256;
}

/* Make circles that indicate the steps of the form: */
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbbbbb;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 1;
}

.step.active {
  opacity: 1;   
}
.step.finish {
  opacity: 1;
  background-color: #053256;
}

</style>
</head>
<body>

<div class="outercontainer">
	<div class="header-bottom-w3ls">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div> 
			<div class="col-md-8 navigation-agileits">
				<nav class="navbar navbar-default">
					<div class="navbar-header nav_2">
						<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div> 
					<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
						<ul class="nav navbar-nav ">
							<li><a href="index.jsp" class="hyper "><span>Home</span></a></li>	
							<li><a href="about.html" class="hyper"><span>About</span></a></li>
							<li ><a href="contact.jsp" class="hyper"><span>Contact Us</span></a></li>
							<li class=" "><a href="faq.jsp" class="hyper"><span>FAQ</span></a></li>
						 </ul>
					</div>
				</nav>
			</div>  
			<div class="col-md-2 cart-wthree">  
				 
					<a href="volunteerPreLogout.jsp" class="w3view-cart"  style="color:#053256;" ><i class="fa fa-sign-out" style="margin-left:15px;"></i><br>Sign Out </a>
			</div>
			  	    
			<div class="clearfix"></div>
		</div>
	</div>
</div>	  											
 
 
	  			 
 
<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %>  
  
<% try{ %>
 
<% Control ct = new Control(); 
String volunteerId=(String)session.getAttribute("volunteerId");
if(volunteerId==null){ 
	response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
}
String status = ct.getVolunteerApplicationStatus(volunteerId);
String name = ct.getVolunteerName(volunteerId);


	  %>
	<div class="main-agileits" style="width: 45%; margin-top: 63px; margin-bottom: 12px; padding: 30px 28px;">
	
	 <%if(status.equals("Approved")){ %>
	 <h3>Welcome <%=name %>! </h3>
	<br>
	   <h4>Congratulations  your Application is  <%=status %></h4>
	  <br>
	
	<h4> <a href="volunteerLogin.jsp">click here</a> to View Your Profile.</h4>
	 <%} else {%>
	 <h3>Welcome <%=name %>! </h3>
	 <h4>  Your Application is  <%=status %></h4>
	  <h4>You can check you application status <a href="volunteerPreLogin.jsp">here.</a>   </h4>
	 
	 <%} %>
	 </div>
	 
	 <%
} catch (Exception e){ 	 
	
}
%>  
<!--team--><br><br> 
 <hr style="color:#eee; height:15px;">
<div class="footer">
	<div class="container">
		<div class="col-md-3 footer-grids fgd1">
		<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
		<ul>
			<li>Christ University</li>
			<li>Bangalore-560029</li>
			<li><a href="mailto:info@example.com">prismhack@gmail.com</a></li>
			<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
		</ul>
		</div>
		<div class="col-md-3 footer-grids fgd2">
			<h4>Information</h4> 
			<ul>
				<li><a href="contact.jsp">Contact Us</a></li>
				<li><a href="about.html">About</a></li>
				<li><a href="faq.jsp">FAQ's</a></li>
			</ul>
		</div>
		<div class="col-md-3 footer-grids fgd4">
			<h4>My Account</h4> 
			<ul>
				<li><a href="volunteerRegistration.jsp">Volunteer Registration</a></li>
				<li><a href="volunteerLogin.jsp">Volunteer Login</a></li>
				<li><a href="adminLogin.jsp">Mentor Login</a></li>
				<li><a href="volunteerPreLogin.jsp">Volunteer Application Status</a></li>
		
			</ul>
		</div>
		<div class="clearfix"></div>
		 </div>
</div>

	 <div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">© 2018 Sarvahitkari . All rights reserved | Design by <a href="#">Kapil Thakur & Rebecca John</a></p>
</div> 

<div id="snackbar"></div>
 <% 
 String action =request.getParameter("action");
 if(action==null){
 
 }else if(action!=null)
 {
	 
  
  %><%if(action.equals("SuccessfullyRegistered")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Your Registration Is Completed, Application Status Is Mentioned Above";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%} else if(action.equals("SessionExpires")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Your Session Expired Please Registered With Other Email";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}%>


<%}%>
	
 
</body>
</html>