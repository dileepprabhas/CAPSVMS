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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/responsive.css">
<link rel="shortcut icon" href="images/logo2_.ico" />
</head>
<script type="text/javascript">
	$(document).ready(function()
	{
		var i=0,j=0,k=0,count=0;
		j=i;
		$(".pince:last-child").attr("id","top-news");	
		 do
		{
			count++;
			k++;
			}while($(".pince:eq("+k+")").attr("id")!="top-news"); 
		$("#login-btn").click(function(){
			$("#login-box").animate({marginLeft:"-60%",opacity:"0.1"},"slow","swing");
			$(".loader").show();
			$(".loader").delay("800").fadeOut(300,"linear");
			setTimeout(function(){
			$("#login-type").animate({marginLeft:"50%",opacity:"1"},"slow","swing");
			},800);
		});
		$("#close").click(function(){
			$("#login-type").animate({marginLeft:"120%",opacity:"0"},"slow","swing");
			$(".loader").show();
			$(".loader").delay("800").fadeOut(300,"linear");
			setTimeout(function(){
			$("#login-box").animate({marginLeft:"50%",opacity:"1"},"slow","swing");
			},800);
		});
		$(".scroll-up").click(function(){
			if(count!=i)
			{
			$("h5:eq("+i+")").css("text-decoration","line-through");
			$(".pince:eq("+i+")").fadeOut("slow","linear");
			i++;
			}
			else
			{			 
			    var x = document.getElementById("snackbar")
			    x.className = "show";
			    x.innerHTML="No More Notifications Left! All Caught Up!";
			    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
			}
		});
		$(".scroll-down").click(function(){
			if(j<i)
			{
			i--;
			$("h5:eq("+i+")").css("text-decoration","none");
			$(".pince:eq("+i+")").fadeIn("slow","linear");
			}
		});
	});
</script> 
<style>
	.team
	{
		height:650px;
		width:auto;
		overflow:hidden;
		background:#b3c1c7;
	}
	.container-login
	{
	height: 100%;
    width: 50%;
    background-size: contain;
    transform: translate(50%,0%);
    margin-top: 6%;
    display: inline-flex;
    border-radius: 4px;
    overflow: hidden;
	}
	#myVideo
	{
		max-width:100%;
		max-height:100%;
		box-shadow: 1px 10px 30px -10px rgba(0,0,0,0.5);
		position: fixed;
		z-index: -1;
	}
	#login
	{
    	height: 69%;
    	min-width: 52.4%;
		margin-left:-1px;
		cursor: pointer;
		transition: 0.5s all;
	}
	#login:hover
	{
	background-color: rgba(243, 241, 234,0.22);
	}
	#signup
	{
    	height: 69%;
    	min-width: 52.4%;
    	cursor: pointer;
    	transition: 0.5s all;
    	position: fixed;
    	margin-left:48%;
	}
	#signup:hover
	{
	background-color:rgba(255, 255, 255,0.39);
	}
	#login-box
	{
    height: 50%;
    width: 70%;
    background-color: rgba(169, 181, 183,0.7);
    border-radius: 4px;
    margin-top: 50%;
    margin-left: 50%;
    transform: translate(-50%,-46%);
    text-align: center;
    box-shadow: 1px 10px 30px -10px rgba(0,0,0,0.5);
    overflow: hidden;
	}
	#signup-box
	{
    height: 50%;
    width: 70%;
    background-color: rgba(169, 181, 183,0.7);
    border-radius: 4px;
    margin-top: 50%;
    margin-left: 50%;
    transform: translate(-50%,-50%);
    text-align: center;
    padding-top:3px;
   	box-shadow: 1px 10px 30px -10px rgba(0,0,0,0.5);
	}
	#login-box>h2,#signup-box>h2
	{
		font-family:'Open Sans', sans-serif;
		text-transform: uppercase;
		color: linen;
		font-size: 29px;
    	margin-top: 11px;
    	margin-bottom:10px;
	}
	#login-box>h3,#signup-box>h3
	{
		font-family:'Open Sans', sans-serif;
		color: linen;
		font-size:18px;
		line-height:25px;
	}
	#login-btn
	{
		height:20%;
		width:70%;
		outline: none;
		font-family:'Open Sans', sans-serif;
		background-color: #26C6DA;
		box-shadow: 1px 5px 20px -5px rgba(0,0,0,0.4);
    	color: #fff;
    	margin-top: -12px;
    	cursor: pointer;
    	border:none;
    	border-radius: 4px;
	}
	#signup-btn
	{
		height:20%;
		width:70%;
		outline: none;
		font-family:'Open Sans', sans-serif;
		background-color: #ef5350;
		box-shadow: 1px 5px 20px -5px rgba(0,0,0,0.4);
    	color: #fff;
    	margin-top: -12px;
    	cursor: pointer;
    	border:none;
    	border-radius: 4px;
	}
	#login-type
	{
    height: 50%;
    width: 93%;
    background-color: rgba(169, 181, 183,0.7);
    border-radius: 4px;
    margin-top: -62%;
    margin-left: 160%;
    transform: translate(-50%,-35%);
    text-align: center;
    padding-top:10%;
    box-shadow: 1px 10px 30px -10px rgba(0,0,0,0.5);
    opacity: 0;
	}
	#login-type>a>#login-btn
	{
		height:28%;
		width:70%;
		outline: none;
		font-family:'Open Sans', sans-serif;
		background-color: linen;
		box-shadow: 1px 5px 20px -5px rgba(0,0,0,0.4);
    	color: black;
    	margin-top: 10px;
    	cursor: pointer;
    	font-weight: bolder;
    	border:none;
    	border-radius: 4px;
	}
	#close
	{
	height: 25px;
    width: 25px;
    font-family: showcard gothic;
    border-radius: 50%;
    background-color: linen;
    text-align: center;
    position: fixed;
    font-size: 20px;
	margin-left: 81%;
    margin-top: -8%;
    transition:0.5s all;
	}
	#close:hover,#close:focus
	{
	color:linen;
	background:black;
	}
	.loader
	{
    height: 40px;
    width: 40px;
    border-radius: 50%;
    position: absolute;
    z-index: 999999999;
    border: 5px solid black;
    border-top: 5px solid beige;
    animation: spin 2s linear infinite;
 	top: 33%;
    left: 22%;
    transform:translate(0%,0%);
    display:none;
	}
	@keyframes spin {
 	0% { transform: rotate(0deg); }
 	100% { transform: rotate(360deg); }
	}
	.scroll-up
	{
	font-size:40px;
	text-align:center;
	}
	.scroll-down
	{
	font-size:40px;
	text-align:center;
	}
	.news
	{
	overflow-y:hidden !important;
	height:450px;
	padding:0px;
	}
</style>
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
<div class="outercontainer" >
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
							<li class=" active"><a href="index.jsp" class="hyper "><span>Home</span></a></li>	
							<li ><a href="about.html" class="hyper"><span>About</span></a></li>
							<li><a href="contact.jsp" class="hyper"><span>Contact Us</span></a></li>
							<li class=" "><a href="faq.jsp" class="hyper"><span>FAQ</span></a></li>
						 </ul>
					</div>
				</nav>
			</div>  
			  
			  	    
			<div class="clearfix"></div>
		</div>
	</div>
</div>	  											
 
 <div class="outercontainer team" id="team">
	<div class="container-login" >
	 <video autoplay muted loop id="myVideo">
 	<source src="images/back.mp4" type="video/mp4">
	</video> 
	<div id="login">
		<div id="login-box">
			<h2>Login</h2>
			<h3>Already A Member? Log In Below.</h3>
		<input type="button" id="login-btn" value="LOG IN">
		</div>
		<div class="loader"></div>
		<div id="login-type" class="col-md-6 col-sm-6 col-xs-6">
			<div id="close">X</div>
			<a href="volunteerLogin.jsp" target="_blank"><input type="button" id="login-btn" value="VOLUNTEER LOG IN"></a> 
			<a href="adminLogin.jsp" target="_blank"><input type="button" id="login-btn" value="MENTOR LOG IN"></a>
		</div>
	</div>
	<div id="signup">
		<div id="signup-box">
			<h2>Sign Up</h2>
			<h3>Not A Member? Sign Up Below.</h3>
			<a href="volunteerRegistration.jsp" target="_blank" ><input type="button" id="signup-btn" value="SIGN UP"></a>
		</div>
	</div>
	</div>
</div>
</div>
<div class="about" style="z-index:50; ">
	<div class="container"> 
		<h3>About Us</h3>
		<div class="about-info">
 
		<div class="col-md-8 about-grids">
				<h4>Our Advantages:</h4>
				<p>We aim to connect volunteers and mentors for India's education</p>		
					<div class="about-w3ls-row">
						<script type="text/javascript">
								 $(window).load(function() {
									$("#flexiselDemo3").flexisel({
										visibleItems:2,
										animationSpeed: 1000,
										autoPlay: false,
										autoPlaySpeed: 3000,    		
										pauseOnHover: true,
										enableResponsiveBreakpoints: true,
										responsiveBreakpoints: { 
											portrait: { 
												changePoint:480,
												visibleItems:2
											}, 
											landscape: { 
												changePoint:640,
												visibleItems:2
											},
											tablet: { 
												changePoint:768,
												visibleItems:2
											}
										}
									});
									
								});
						</script>
						<script type="text/javascript" src="js/jquery.flexisel.js"></script> 
						<ul id="flexiselDemo3">
							<li>
								<img src="images/a1.jpg" class="img-responsive" alt="" />
							</li>
							<li> 
								<img src="images/a2.jpg" class="img-responsive" alt="" />
							</li>
							<li> 
								<img src="images/a3.jpg" class="img-responsive" alt="" />
							</li>
							<li> 
								<img src="images/a4.jpg" class="img-responsive" alt="" />
							</li>
						</ul> 
						<div class="clearfix"> </div>
					</div>
			</div>
			
			
			<div class="col-md-4 about-grids">
			
					<h3>News and Events</h3>
					<div class="scroll-up">
					<i class="fa fa fa-chevron-circle-up"></i>
					</div>
					<div class="news">
					<%  
			faqDetails = ct.viewNews();  %>
				<%! int j=01; %>
				
					<% while(faqDetails.next()){
						 %> 
						
					<div class="pince">
						<div class="pince-left">
							<h5><% if (j<10){%>0<%=j%><%}else{%>
								<%=j %>
								 <%} %>
							</h5>
							
						</div>
						<div class="pince-right">
						<p><b><%=faqDetails.getString("title")%></b></p>
							<p><%=faqDetails.getString("content") %></p>
						</div>
						<div class="clearfix"> </div>
					</div>
					
					<% j++;}j=1; %>
				 
					  
							 
					</div>
					<div class="scroll-down">
					<i class="fa fa fa-chevron-circle-down"></i>
					<div id="snackbar"></div>
					</div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- //about -->
<!-- about-bottom -->
	<div class="about-bottom">
		<div class="container">
			<h3>Do your part <span>for</span> the Nation</h3>
			<h4>Register as a volunteer</h4>
			<a href="volunteerRegistration.jsp" target="_bkank"> Register</a>
		</div>
	</div>
<!-- //about-bottom -->
<!--team--> 
<div class="team" id="team">
	<div class="container">
		<h3> Our Team</h3>
		<div class="team-grids">
			<div class="col-md-3 team-grid">
				<div class="team-img">
					<img src="images/t1.jpg" class="img-responsive" alt=" " style="border:2px solid black;" />
					<figcaption class="overlay">
						<div class="social-icon">
							
							<a href="https://www.facebook.com/rebecca.john.98837"><i class="fa fa-facebook" aria-hidden="true"></i></a>
							<a href="https://www.linkedin.com/in/rebecca-john-b3532980/"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
						</div>
					</figcaption>
				</div>
				<h4>Rebecca John</h4>
				<h5>Partner</h5>
				<a href="partnerProfile/indexreb.html">View Profile</a>
			</div>
			<div class="col-md-3 team-grid">
				<div class="team-img">
					<img src="images/kapil.jpg" class="img-responsive" alt=" " style="width:400px; border:2px solid black;" />
					<figcaption class="overlay">
						<div class="social-icon">
							
							<a href="https://m.facebook.com/profile.php?id=100008311602293&ref=content_filter"><i class="fa fa-facebook" aria-hidden="true"></i></a>
							<a href="https://www.linkedin.com/in/kapil-thakur/"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
						</div>
					</figcaption>
				</div> 
				<h4>Kapil Thakur</h4>
				<h5>Partner</h5>
				<a href="partnerProfile/index(1).html">View Profile</a>
			</div>
			<div class="col-md-3 team-grid">
				<div class="team-img">
					<img src="images/bhargaviMaam.jpg" class="img-responsive" alt=" " />
					<figcaption class="overlay">
						<div class="social-icon">
							
							<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
						</div>
					</figcaption>
				</div>
				<h4>Dr. Bhargavi Goswami</h4>
				<h5>Guide</h5>
				<a href="https://christuniversity.in/computer-science/faculty-details/MjQ1NQ==/NjI="> View Profile</a>
		
			</div>
			<div class="col-md-3 team-grid">
				<div class="team-img">
					<img src="images/vaidhehiMaam.jpg" style="border:2px solid black;" class="img-responsive" alt=" " />
					<figcaption class="overlay">
						<div class="social-icon">
							
							<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
						</div>
					</figcaption>
				</div>
				<h4>Prof. Vaidhehi V</h4>
				<h5>Guide</h5>
			<a href="https://christuniversity.in/computer-science/faculty-details/MzA0/NjI=">View Profile	</a>
			</div>
			
			<div class="clearfix"></div>
		</div>
	</div>
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
	<!-- //cart-js -->   
	
	
</body>
</html>