<!DOCTYPE html>
<html lang="en">
<head>
<title>VMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"  content="Teach For India , PrismVMS " />
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
<link rel="shortcut icon" href="images/logo2_.ico" />
</head>
<body>
<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %>   
<%@ page import="java.util.Date"  %> 
 
<%! 
	 ResultSet faqDetails=null;
	Control ct = new Control(); 
%>
<div class="outercontainer">
	<div class="header-bottom-w3ls">  
		<div class="row">
			<div class="col-md-3 logo-w3">
				<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div> 
			<div class="col-md-7 navigation-agileits">
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
							<li ><a href="index.jsp" class="hyper "><span>Home</span></a></li>	
							<li ><a href="about.html" class="hyper"><span>About</span></a></li>
							<li><a href="contact.jsp" class="hyper"><span>Contact Us</span></a></li>
							<li class=" active"><a href="faq.jsp" class="hyper"><span>FAQ</span></a></li>
						 </ul>
					</div>
				</nav>
			</div>  
			<div class="col-md-2 cart-wthree "  style="display:inline-flex;">
			<a href="https://christuniversity.in" target="_blank"><img src="images/logo.jpg" class="christLogo" align="right" ></a>
			</div>
			
			  
			  	    
			<div class="clearfix"></div>
		</div>
	</div>
</div>	  											
 
<div class="sub-banner">
</div>
<!-- faq-banner -->
	<div class="faq">
		<h3>FAQ</h3>
		<% try{ 
			faqDetails = ct.viewFaq();  %>
				<%! int j=1; %>
				
					<% while(faqDetails.next()){
						 %> 
						
		<div class="container"> 
			<div class="panel-group w3l_panel_group_faq" id="accordion" role="tablist" aria-multiselectable="true">
			  <div class="panel panel-default">
				<div class="panel-heading" role="tab" id="heading<%=j%>">
				  <h4 class="panel-title asd">
					<a class="pa_italic collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse<%=j%>" aria-expanded="false" aria-controls="collapseOne">
					  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span><i class="glyphicon glyphicon-minus" aria-hidden="true"></i><%=faqDetails.getString("question")%>
					</a>
				  </h4>
				</div>
				<div id="collapse<%=j%>" class="panel-collapse collapse " role="tabpanel" aria-labelledby="heading<%=j%>">
				  <div class="panel-body panel_text">
					<%=faqDetails.getString("answer")%>
					</div>
				</div>
			  </div>
			</div>
		</div><%j++; 
					}}catch (Exception e) {
					}finally{
						faqDetails.close();} %> 	
		}
			
	</div>
<!--team-->
 <hr style="color:#eee; height:15px;">
<div class="footer">
	<div class="container">
		<div class="col-md-3 footer-grids fgd1">
		<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
		<ul>
			<li>Christ University</li>
			<li>Bangalore-560029</li>
			<li><a href="mailto:caps@christuniversity.in">caps@christuniversity.in</a></li>
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
	 <p class="copy-right">© 2018 CAPS . All rights reserved | Web Development by <a target="_blank" style="color:" href="https://www.linkedin.com/in/kapil-thakur/">Kapil Thakur </a></p>
</div> 
</body>
</html>