<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Sarv Hitkari VMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Teach For India , PrismVMS " />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css -->
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="../css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css" media="all" />
<!--// css -->
<!-- font -->
<link href="../fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
<link href='../fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- //font -->
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/bootstrap.js"></script>
<link rel="shortcut icon" href="../images/logo2_.ico" />
<style type="text/css"> 
body {
	overflow-x:hidden;
}
</style>
<body>
   <div class="outercontainer">
	<div class="header-bottom-w3ls">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="adminLogin.jsp"><img src="../images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div> 
			<div class="col-md-8 navigation-agileits">
				<nav class="navbar navbar-default">
					<div class="navbar-header nav_2">
						 
					</div> 
					 
				</nav>
			</div>  
			  
			  	    
			<div class="clearfix"></div>
		</div>
	</div>
</div>
	<div class="login"> 
		<div class="main-agileits">
				<div class="form-w3agile">
				<% String action = request.getParameter("action");%>
						<%if(action == null){ %>
					<h3>Verify Email</h3>
					<form action="${pageContext.request.contextPath}/Control?action=adminForgotPassword" method="post">
					
						<div class="key input-group">
							<span class="input-group-addon"><i class="fa fa-envelope" aria-hidden="true"></i></span>
							<input  type="text" name="email" required="true" placeholder="Email" class="form-control">
							<div class="clearfix"></div>
						</div>
						<input type="submit" value="Get OTP" class="btn btn-primary">
						 </form>
						<%}else if(action.equals("otpVarification") || action.equals("otpIsNotCorrect")){
							String email = request.getParameter("email");
							
						%>
						<h3>Set Password</h3>
						<form action="${pageContext.request.contextPath}/Control?action=adminforgotOtpVerification" method="post">
							<div class="key input-group">
								<span class="input-group-addon"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								<input  type="text" readonly name="email" value="<%=email%>" required placeholder="Email" class="form-control">
								<div class="clearfix"></div>
							</div>
							<div class="key input-group">
								<span class="input-group-addon"><i class="fa fa-mobile-phone" aria-hidden="true"></i></span>
								<input  type="text" name="otp" required placeholder="OTP" class="form-control">
								<div class="clearfix"></div>
							</div>
							<div class="key input-group">
								<span class="input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
								<input  type="password" name="password" required placeholder="New Password" class="form-control">
								<div class="clearfix"></div>
							</div>
							<div class="key input-group">
								<span class="input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
								<input  type="password" name="confirmPassword" required placeholder="Confirm Password" class="form-control">
								<div class="clearfix"></div>
							</div>
							
						
						<input type="submit" value="Set Password" class="btn btn-primary">
					  <%} %>
					</form>
				</div>
				<div class="forg">
					<a href="adminLogin.jsp" class="forg-left">Login</a>
					 
				<div class="clearfix"></div>
				</div>
			</div>
		</div>
 
	 <div class="footer" style="background-color:#2A3F54;   height:50px;">
	<p class="copy-right">© 2018 Sarvahitkari . All rights reserved | Design by <a href="#">Kapil Thakur & Rebecca John</a></p>
</div> 
	
	  
<div id="snackbar"></div>
 <%  
 if(action==null){
 
 }else if(action!=null)
 { 
  
  if(action.equals("PasswordAndConfirmPasswordNotMactched")){ 
 %>
<script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Password and Confrim Password Does Not Match";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}else if(action.equals("otpVarification")){ 
	 %>
	 <script>
	  
	     var x = document.getElementById("snackbar")
	     x.className = "show";
	     x.innerHTML="Please check OTP on Your Registered Email Id";
	     setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
	  
	 </script>
	 <%}else if(action.equals("otpIsNotCorrect")){ 
 %>
<script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="OTP is Wrong";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%} else if(action.equals("OtpExpired")){ 
 %>
<script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Your OTP is Expired";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}%>
  
<% } %>
   
	 
</body>
</html>