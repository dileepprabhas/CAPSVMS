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
  background-color: #66bdd7;
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
  background-color: #66bdd7;
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
  background-color: #66bdd7;
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
			<div class="col-md-7 navigation-agileits" style=" text-align: center;">
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
							<li><a href="contact.html" class="hyper"><span>Services</span></a></li>	
							<li><a href="about.html" class="hyper"><span>About</span></a></li>						
							<li><a href="contact.html" class="hyper"><span>Contact Us</span></a></li>
						</ul>
					</div>
				</nav>
			</div>
		  	<script>
				$(document).ready(function(){
					$(".dropdown").hover(            
						function() {
							$('.dropdown-menu', this).stop( true, true ).slideDown("fast");
							$(this).toggleClass('open');        
						},
						function() {
							$('.dropdown-menu', this).stop( true, true ).slideUp("fast");
							$(this).toggleClass('open');       
						}
					);
				});
			</script>  
			<div class="col-md-1 cart-wthree">  
				<form action="login.html" method="post"  style="float: right; display: inline-block; margin-right:40px;    "  > 
					<input type="hidden" name="cmd" value="_cart" />
					<input type="hidden" name="display" value="1" />
					<button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-user" aria-hidden="true"></i></button>
				</form>   	 
			</div>
			<div class="col-md-2 cart-wthree">  
				<form action="ngoPreLogout.jsp" method="post"  style="float: right; margin-top:10px; display: inline-block; margin-right:40px;    "  > 
				 
					<button class="w3view-cart"  style="color:#66bdd7;" type="submit" name="submit"  > Sign Out </button>
				</form>   	 
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
 
<% 
	String ngoId= request.getParameter("ngoId"); 
	  %>
	<div class="main-agileits" style="width: 45%; margin-top: 63px; margin-bottom: 12px; padding: 30px 28px;">
	<h3>Add Logo</h3>
	<br>
	 <form id="uploadPicture" enctype="multipart/form-data" action="NgoUpdateLogo?id=<%=ngoId%>" method="post">
		  	<input style="width:125px;"  type="file" name="file" id="imgInp1" > 
		   	<img id="productimage1" src="#"  style="width:100px; margin-left:20px; height:100px;" />  
		  <br>
		  <br>
		  	<input type="submit" value="Submit" >
		</form> 
	 </div>
	 
	 <%
} catch (Exception e){ 	 
	
}
%>  
	 <div class="tab"> 
		<ul class="tabs col-lg-12">
			<li><a href="#">Tab01</a></li>
			<li><a href="#">Tab02</a></li>
			<li><a href="#">Tab03</a></li>
			<li><a href="#">Tab04</a></li>
			<li><a href="#">Tab05</a></li>
			<li><a href="#">Tab06</a></li>
			<li><a href="#">Tab07</a></li>
		</ul> <!-- / tabs --> 
		<div class="tab_content col-lg-12">
		
			<div class="tabs_item">
				<img src="https://cdn.dribbble.com/users/545884/screenshots/3695553/news.png">
				<h4>Tab 01 Neque ipsum dolor.</h4>
				<p>Consectetur adipisicing elit. Neque, repellat facilis totam ab eos distinctio sint atque maiores! Dignissimos, molestiae, rem accusantium iure vitae voluptatum voluptas repudiandae deserunt dolore quis! Quisquam mollitia eius sed.</p>
			</div> <!-- / tabs_item -->
	
			<div class="tabs_item">
				<img src="https://cdn.dribbble.com/users/545884/screenshots/3576036/liberosis_--_10.png">
				<h4>Tab02 Maiores, suscipit</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maiores, suscipit, eaque asperiores neque numquam nam possimus dolorem ipsa aspernatur reiciendis?</p>
			</div> <!-- / tabs_item -->
	
			<div class="tabs_item">
				<img src="https://cdn.dribbble.com/users/545884/screenshots/3557299/mo-t.png">
				<h4>Tab03</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quaerat, excepturi, minima, corporis deserunt quia quae sit officiis labore inventore autem a delectus consequuntur voluptatem modi eligendi similique sed nam vitae.</p>
			</div> <!-- / tabs_item -->
			
		</div> <!-- / tab_content -->
	</div> <!-- / tab -->
<br><br><br> 
<div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">© 2018 PrismVMS. All rights reserved | Design by <a href="#">Kapil Thakur & Anurag Goel</a></p>
</div> 
	  
<script type="text/javascript">
 
 function readURL(input,id) {

	  if (input.files && input.files[0]) {
	    var reader = new FileReader();

	    reader.onload = function(e) {
	      $(id).attr('src', e.target.result);
	    } 
	    reader.readAsDataURL(input.files[0]);
	  }
	}

	$("#imgInp1").change(function() {
	  readURL(this,productimage1);
	});
	$("#imgInp2").change(function() {
		  readURL(this,productimage2);
		});
	$("#imgInp3").change(function() {
		  readURL(this,productimage3);
		});
	$("#imgInp4").change(function() {
		  readURL(this,productimage4);
		});
	$("#imgInp5").change(function() {
		  readURL(this,productimage5);
		});
 </script>
</body>
</html>