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
   
  
  
<div class="outercontainer" style="margin-top:0px; height:90px; background-color: #f8f8f8;">
	<div class="header-bottom-w3ls" >  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="mentorIndex.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div>  
			<div class="col-md-7 cart-wthree">  
			</div>
			<div class="col-md-3 cart-wthree">  
				 
					<a href="mentorLogout.jsp" class="w3view-cart"  style="color:#053256;" ><i class="fa fa-sign-out" style="margin-left:15px;"></i><br>Sign Out </a>
				  	<a href="https://christuniversity.in" target="_blank"><img src="images/logo.jpg" class="christLogo" align="right" ></a> 
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>  
<% try{ %>
  
<%!  
	ResultSet teamProjectsRs=null;
	int mentorStatus=0; 
	String adminId =null;
	ResultSet teamsRs=null; 
	int volunteerCount =0, pageCount = 0;
	int pageNumber=0, nextRecordCount=10;	
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
	pageNumber = Integer.parseInt(request.getParameter("pN")); 
	volunteerCount = ct.getTeamProjectEnrollRequestCount(adminId);
	pageCount= volunteerCount/10 +1;
	teamProjectsRs = ct.getTeamProjectEnrollment(request, response,pageNumber-1, nextRecordCount);  
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
                            <a class="nav-link active" href="teamProjectEnrollRequestView.jsp?pN=1"> Team Project Enroll Request</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="branchProject.jsp">Branch Projects</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="branchProjectView.jsp?pN=1">View Branch Projects</a>
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
        <div class="text-right"  ><a href="#" style="paading-right:10px;">Pending <span class="badge"><%=volunteerCount%></span></a><br></div>
		
        		<ul class="collapsible" data-collapsible="accordion" style="list-style:none; margin-left:auto; margin-right:auto;">
			 
				 <%while(teamProjectsRs.next()){ %>
					<li style="margin:5px;">
					
						<div class="collapsible-header active">
						 <p style="padding:10px; background-color:#053256; font-size:14px;">
							<span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
							<%=teamProjectsRs.getString("t.tproject_title") %>
							 
					  		<span style="float: right; margin-right: 39px;" >
						  		<i class="fa fa-users"  style="text-align: right; color:#fff; font-size:22px; font-style: bold;"> </i> &nbsp;&nbsp; 
							 	<%=teamProjectsRs.getString("v.team") %>  
							</span> 		
				 	 	</div> 
						<div class="collapsible-body" style="background-color: #fff;">
							<div class="col-lg-12"  >
							<div class="row"  >
									<div class="col-lg-4" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-user" style="font-size:20px;  "></i>  &nbsp;  &nbsp; Name</strong> &nbsp; <%=teamProjectsRs.getString("v.volunteer_name") %>      </p>
										</div>
									</div>
									<div class="col-lg-4" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-registered" style="font-size:20px;  "></i> &nbsp;  &nbsp; Register No.</strong> &nbsp; <%=teamProjectsRs.getString("v.username") %>   </p>
										</div>
									</div>
									
									<div class="col-lg-4" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-envelope" style="font-size:20px;  "></i> &nbsp;  &nbsp; Email</strong> &nbsp; <%=teamProjectsRs.getString("v.email_id") %>   </p>
										</div>
									</div>
									<div class="col-lg-4" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-users" style="font-size:20px;  "></i> &nbsp;  &nbsp; Wing</strong> &nbsp; <%=teamProjectsRs.getString("v.team") %>   </p>
										</div>
									</div>
									<div class="col-lg-4" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><span style="font-size:20px;" class="glyphicon glyphicon-education"></span> &nbsp;  &nbsp; Course</strong> &nbsp; <%=teamProjectsRs.getString("v.course") %>   </p>
										</div>
									</div>
									<div class="col-lg-4" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-phone" style="font-size:20px;  "></i> &nbsp;  &nbsp; Phone</strong> &nbsp; <%=teamProjectsRs.getString("v.contact_num") %>   </p>
										</div>
									</div>	
								</div>
								<div class="row"  >
									<div class="col-lg-8" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-calendar-o" style="font-size:20px;  "></i>  &nbsp;  &nbsp;  Start Date</strong> &nbsp; <%=teamProjectsRs.getString("t.tpro_start_date") %>      </p>
										</div>
									</div>
									<div class="col-lg-4" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-calendar-o" style="font-size:20px; "></i> &nbsp;  &nbsp; End Date</strong> &nbsp; <%=teamProjectsRs.getString("t.tpro_end_date") %>   </p>
										</div>
									</div>
								</div>
								<br>
								<p style="font-size:16px;"><%=teamProjectsRs.getString("t.tproject_desc") %>  </p> 
								<br>
								<div style="text-align:center;  margin-left: 400px; display: inline-flex; margin-bottom:20px;"   >
								 	
								 	<form action="Control?action=teamProjectApproval" method="post">
								 		<input type="hidden" name="projectId" value="<%=teamProjectsRs.getString("t.id")%>">
								 		<input type="hidden" name="enrollId" value="<%=teamProjectsRs.getString("te.id")%>">
								  		<input type="hidden" name="vIds" value="<%=teamProjectsRs.getString("v.id")%>">
								  		
									  	<!-- <input type="submit"   class="btn btn-primary" class="fa fa-check" style="width:80px;     display: inline-block; " value="Approve" ><i class="fa fa-check" style="color:#fff; font-size:22px;  "></i>  
										 --><button type="submit" class="btn btn-warning" style="  display: inline-block; ">
  <i class="fa fa-check" style="color:#fff; font-size:20px;"></i>Approve
</button>
										
										&nbsp;&nbsp;&nbsp;&nbsp; 
								 	</form>
								 	
								 	<br>
									<a  class="btn btn-danger" href="teamProjectEnrollRequestStatus.jsp?projectId=<%=teamProjectsRs.getString("te.id")%>&project=<%=teamProjectsRs.getString("t.tproject_title") %>&email=<%=teamProjectsRs.getString("v.email_id")%>&status=Rejected"  ><i class="fa fa-close"   style="color:#fff; font-size:22px;  "></i> Reject </a>
								   
								</div>
							</div> 
					</div>
				</li>
				<%} %> 
				 <div class="col-lg-12 text-center" >
					<ul class="pagination " >
						<% for( int k=1; k<=pageCount; k++){ %>
					    	<li><a href="teamProjectEnrollRequestView.jsp?pN=<%=k%>"><%=k%></a></li>
					    <% } %> 
				 	</ul>
		 		</div>  
	  		</ul>
		 
	 
	 	 
	 
  
 			 
    	</div>
 	</div>
</div>
  
<%} %>

<br><br><br>  
<div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">© 2018 CAPS . All rights reserved | Web Development by <a target="_blank" style="color:" href="https://www.linkedin.com/in/kapil-thakur/">Kapil Thakur </a></p>
</div> 
	  
  <div id="snackbar"></div>
 <% 
 String action =request.getParameter("action");
 if(action==null){
 
 }else if(action!=null)
 {
	 
  
  %>
  <%if(action.equals("TeamProjectApproved")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="You Have Approved Enroll Request For The Project";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}%>


<%}%> 
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"></script>

<script type="text/javascript">

(function($) {
	
	$(window).scroll(function() {
		
		$(window).scroll(function() {
			space = $(window).innerHeight() - $('.fab').offsetTop + $('.fab').offsetHeight;
			if(space < 200){
				$('.fab').css('margin-bottom', '150px');
			}
		})
		
	});
	
})(jQuery);

</script>
</body>
</html>