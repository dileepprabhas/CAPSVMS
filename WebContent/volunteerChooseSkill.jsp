<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
<title>VMS</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
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
  
  width: 70%;
  min-width: 300px;
}

h1 {
  text-align: center;  
}
 .key img
 {
	margin-left: 14px;
	margin-bottom: 14px;
	
 }
 
 
</style>


    <style type="text/css">
        
        
   
     
    </style>
</head>
<body>

<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %> 
   
  
  
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
<%!  
	ResultSet professionalSkillRs=null,academicSkillRs=null,lifeSkillRs=null,softSkillRs=null;
	Control ct = new Control();
%>
 <div class="text-center">
	<h3>CHoose Your skills</h3>
 </div>
	  
<form action="Control?action=volunteerChooseSkills" method="post">
	<div class="container" style="paddin:0px; margin-left:150px;  ">
	    <div class="row" style="height:400px;"><br>
	        <div class="col-md-3 col-lg-3" style="text-algin:center; ">
				<h4 style="text-align:left; margin-bottom:15px;" >Academic Skills</h4>
				<% academicSkillRs = ct.getAcademicSkill(); %>
		        <% while(academicSkillRs.next() ){ %>
		           <label class="container"> <%=academicSkillRs.getString("skill_name") %> 
						  <input type="checkbox" value="<%=academicSkillRs.getString("skill_name") %>" name="skills" >
						  <span class="checkmark"></span>
					</label>
		       <%} %>  
	        </div>
	         <div class="col-md-3 col-lg-3" >
				
	           <h4 style="text-align:left; margin-bottom:15px;">Life Skills</h4>   
				 
				 
				 <% lifeSkillRs = ct.getLifeSkill(); %>
	            	<% while(lifeSkillRs.next() ){ %>
	             	<label class="container"> <%=lifeSkillRs.getString("skill_name") %> 
						  <input type="checkbox" value="<%=lifeSkillRs.getString("skill_name") %>" name="skills"  >
						  <span class="checkmark"></span>
					</label>
		       <%} %>   
	        </div>
	         <div class="col-md-3 col-lg-3" >
				<h4 style="text-align:left; margin-bottom:15px;">Professional Skills</h4> 
				 <% softSkillRs = ct.getSoftSkill(); %>
	             <% while(softSkillRs.next() ){ %>
	              	<label class="container"> <%=softSkillRs.getString("skill_name") %> 
						  <input type="checkbox"  value="<%=softSkillRs.getString("skill_name") %>" name="skills" >
						  <span class="checkmark"></span>
					</label>
		       <%} %> 
	              					 
	        </div>
	        <div class="col-md-3 col-lg-3" >
				<h4 style="text-align:left; margin-bottom:15px;">Soft Skills</h4> 
				<% professionalSkillRs = ct.getProfessionalSkill(); %>
	            <% while(professionalSkillRs.next() ){ %>
	            	<label class="container"> <%=professionalSkillRs.getString("skill_name") %> 
						  <input type="checkbox" value="<%=professionalSkillRs.getString("skill_name") %>" name="skills" >
						  <span class="checkmark"></span>
					</label>
		       <%} %> 			
	           
	        </div>
	        
	 	</div>
	 	<div class="key">
			<i class="fa fa-paragraph" aria-hidden="true"></i>
			<textarea name="additionalSkills" style="width:94%;" placeholder="Write Addtional Skills"></textarea>
			<div class="clearfix"></div>
		</div> 
		<div class="key">
			<i class="fa fa-paragraph" aria-hidden="true"></i>
			<textarea required name="background" style="width:94%;" placeholder="Write Backgorund and Achievements"></textarea>
			<div class="clearfix"></div>
		</div> 
		 <div class="row" style="margin-top:-10px;"> 
		 	<div class="col-md-9 col-lg-9" style="text-algin:right;  ">
		 	</div>
		 <div class="col-md-3 col-lg-3" >
		<input type="submit" class="form-control" style="opacity:1; width:50%;" value="Next" >
	   </div>
	       </div>
	 	
	</div>
</form>
 
 
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
				<li><a href="adminLogin.jsp">Menor Login</a></li>
				<li><a href="volunteerPreLogin.jsp">Volunteer Application Status</a></li>
		
			</ul>
		</div>
		<div class="clearfix"></div>
		 </div>
</div>
<% 
 String action =request.getParameter("action");
 if(action==null){
 
 }else if(action!=null)
 {
	 
  
  %><%if(action.equals("volunteerChooseSkills")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="At least Select One Skill";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}%>
<%}%>
	 <div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">© 2018 CAPS . All rights reserved | Web Development by <a target="_blank" style="color:" href="https://www.linkedin.com/in/kapil-thakur/">Kapil Thakur </a></p>
</div> 
	     <div id="snackbar"></div>
	  
	  volunteerChooseSkills
</body>
</html>