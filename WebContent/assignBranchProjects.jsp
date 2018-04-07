<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
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
   
  
<div class="outercontainer" style="margin-top:0px; height:100px; background-color: #f8f8f8;">
	<div class="header-bottom-w3ls" style="padding:22px;">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="mentorIndex.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div>  
			<div class="col-md-8 cart-wthree">  
			</div>
			<div class="col-md-2 cart-wthree" ">  
				 
					<a href="mentorLogout.jsp" class="w3view-cart"  style="color:#66bdd7;" ><i class="fa fa-sign-out" style="margin-left:15px;"></i><br>Sign Out </a> 
				  	 
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>   
<% try{ %>
  
<%!  
	ResultSet volunteerDetails=null;
	int mentorStatus=0; 
	String adminId =null;
	ResultSet teamsRs=null; 
	Control ct = new Control();
%>
<% 
	adminId = (String)session.getAttribute("adminId"); 
	if(adminId == null)
	{	
		adminId = (String)session.getAttribute("adminId"); 
		if(adminId==null){ 
			response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
		}
	} 
	mentorStatus  = ct.checkMentorStatus(request, response,adminId);  
} catch (Exception e){ 	 	
}
if(mentorStatus == 1){
 
 %>
 
 	
<div class="outercontainer" style="padding-top:0px;  padding-right:10px; margin-left:10px; margin-top:10px; margin-right:15px;">
    <div class="row">
        <div class="col-md-2 col-lg-3 col-sm-4 col-xs-12" >

            <div class="bootstrap-vertical-nav" >
 
                <div   id="collapseExample" style="margin-top:3px;" >
                    <ul class="nav flex-column" id="exCollapsingNavbar">
             			<li   class="nav-item" style="text-algin:center">
		                    <div class="text-center">
		                     <img src="DisplayMentorPic?name=<%=adminId %>" align="middle" style="  width: 80px;text-aling: center;margin-top: 11px; height: 80px;border-radius: 50%;">
		                 	</div>
                 		</li>
                		<li class="nav-item" >
                       		<form action="#" method="post">
								<div   >
								 	<input    id="myInput" onkeyup="search()" type="text" style="opacity:1; padding: 12px 20px 12px 40px; background-image: url('images/searchicon.png'); background-position: 10px 10px; background-repeat: no-repeat; cursor:text; height:40px;"  name="productPrice" required="" placeholder="Search Feature">
									 <div class="clearfix"></div>
								</div> 
							</form>
                    	</li >
                   	</ul>
                    <ul class="nav flex-column" id="exCollapsingNavbar3">
	                     
                       	<li   class="nav-item">
                         	<a class="nav-link " href="mentorIndex.jsp">Home</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link 	" href="mentorVolunteerWorkDiary.jsp?pN=1">Work Diary</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link" href="mentorVolunteerMeeting.jsp?pN=1">Work Meeting</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link " href="mentorVolunteerTraining.jsp?pN=1">Work Training</a>
                        </li>                       	 
                        <li  class="nav-item">
                            <a class="nav-link " href="individualProject.jsp?pN=1">Individual Projects</a>
                        </li> 
                        <li  class="nav-item">
                            <a class="nav-link" href="teamProject.jsp">Team Projects</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link" href="teamProjectView.jsp?pN=1">View Team Projects</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link " href="teamProjectEnrollRequestView.jsp?pN=1"> Team Project Enroll Request</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="branchProject.jsp">Branch Projects</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link active" href="branchProjectView.jsp?pN=1">View Branch Projects</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link" href="branchProjectEnrollRequestView.jsp?pN=1"> Branch Project Enroll Request</a>
                        </li>   
                        <li   class="nav-item">
                            <a class="nav-link" href="viewMonthlyReport.jsp?pN=1">View Monthly Report</a>
                        </li>  
                        <li   class="nav-item">
                            <a class="nav-link" href="mentorVmsExperience.jsp">VMS Feedback</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="mentorVmsExperienceView.jsp?pN=1">View VMS Feedback</a>
                        </li> 
                    </ul>
                </div> 
            </div> 
        </div>
         
        <div  class="col-md-10 col-lg-9 col-sm-9 col-xs-12" style="padding:3px 0px;">
 			<% String projectId = request.getParameter("projectId"); 
		 		
		 		volunteerDetails = ct.getVolunteerForBranchProject(projectId,adminId);
		 		String action = request.getParameter("action"); 
		 		if(action == null)
		 		{
		 			
		 		}
		 		else if(action.equals("BranchProjectCreated"))
		 		{%>
		 			<a style="margin:30px;" class="btn btn-primary" href="branchProject.jsp">Skip  &nbsp;&nbsp;&nbsp;<i class="fa fa-angle-right" style="color:#fff;"></i></a>
		 			<div id="snackbar"></div>
		 			<script>
 
					    var x = document.getElementById("snackbar")
					    x.className = "show";
					    x.innerHTML="Project Has Been Created, Branch Volunteers Has Been Notified To Send Enroll Request";
					    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
					 
					</script>
		 		<%}
		 		else if(action.equals("assignProject"))
		 		{%>
		 			<a style="margin:30px;" class="btn btn-primary" href="branchProjectView.jsp">Skip  &nbsp;&nbsp;&nbsp;<i class="fa fa-angle-right" style="color:#fff;"></i></a>
		 			 
		 		<%}
		 		
		 		 %>
		 		 
 			<form action="Control?action=assignBranchProject" method="post" onSubmit="return validateChecks()" >
 			<div style="height:400px; overflow-x:hidden;">
		 		
		 		<%while(volunteerDetails.next()){ %>
			   	<div class="col-md-3 col-lg-3" >
					 <label class="container">  
					 <input type="hidden" name="projectId" value="<%=projectId%>"> 
						  <input type="checkbox" name="vIds"  value="<%=volunteerDetails.getString("id")%>" > <%=volunteerDetails.getString("volunteer_name")%>
						  <span class="checkmark"></span>
					</label> 
	        	</div>
	        	<%}%>
		 			 </div>
		 		<input type="submit" style="opacity:1;" value="Assign">
 			</form>
 			 
          
    	</div>
 	</div>
</div>
  
<%} %>
 <br><br><br>  
<div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">© 2018 Sarvahitkari . All rights reserved | Design by <a href="#">Kapil Thakur & Rebecca John</a></p>
</div> 
<div id="snackbar"></div>
	 <script type="text/javascript">
	  
	 function validateChecks() {
     	
  		var chks =  document.getElementsByName('vIds');
  		var checkCount = 0;
  		for (var i = 0; i < chks.length; i++) {
  			if (chks[i].checked) {
  				checkCount++;
  			}
  		}
  		if (checkCount < 1) {
  			
  			var x = document.getElementById("snackbar")
  		    x.className = "show";
  		    x.innerHTML="Select at least one volunteer";
  		    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
  		 
  			return false;
  		}
  		return true;
  	}
	 </script>
	 
</body>
</html>