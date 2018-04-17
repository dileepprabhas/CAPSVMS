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
				<a href="volunteerIndex.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div>  
			<div class="col-md-8 cart-wthree">  
			</div>
			<div class="col-md-2 cart-wthree">  
				 
					<a href="volunteerLogout.jsp" class="w3view-cart"  style="color:#053256;" ><i class="fa fa-sign-out" style="margin-left:15px;"></i><br>Sign Out </a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div> 
<% try{ %>
  
<%!  
	ResultSet teamProjectsRs=null,branchRs=null;
	int volunteerStatus=0; 
	String volunteerId =null,  status=null;
	ResultSet teamsRs=null; 
	int volunteerCount =0, pageCount = 0;
	int pageNumber=0, nextRecordCount=10;	
	Control ct = new Control();
%>
<% 
	volunteerId = (String)session.getAttribute("volunteerId"); 
	if(volunteerId == null)
	{	
		volunteerId = (String)session.getAttribute("volunteerId"); 
		if(volunteerId==null){ 
			response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
		}
	} 
	volunteerStatus  = ct.checkVolunteerStatus(request, response,volunteerId);  
} catch (Exception e){ 	 	
}
finally
{

}
if(volunteerStatus == 1){

	teamProjectsRs = ct.getVolunteerTeamProject(request, response);
%>
 
 	
 
<div class="outercontainer" style="padding-top:0px;  padding-right:10px; margin-left:10px; margin-top:10px; margin-right:15px;">
    <div class="row">
        <div class="col-md-2 col-lg-3 col-sm-3 col-xs-12" >

            <div class="bootstrap-vertical-nav" >
	 
 
                <div   id="collapseExample"style="margin-top:3px;" >
                     <ul class="nav flex-column" id="exCollapsingNavbar">
             			<li   class="nav-item" style="text-algin:center">
		                    <div class="text-center">
		                     <img src="DisplayVolunteerPic?name=<%=volunteerId %>" align="middle" style="  width: 80px;text-aling: center;margin-top: 11px; height: 80px;border-radius: 50%;">
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
                         	<a class="nav-link  " href="volunteerIndex.jsp">Home</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link" href="workDiary.jsp">Work Diary</a>
                        </li> 
                         <li  class="nav-item">
                            <a class="nav-link" href="workDiaryView.jsp">View Work Diary</a>
                        </li> 
                        <li  class="nav-item">
                            <a class="nav-link" href="workMeeting.jsp">Work Meeting</a>
                        </li>
                         <li  class="nav-item">
                            <a class="nav-link" href="meetingView.jsp">View Work Meeting</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="workTraining.jsp">Work Training</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="trainingView.jsp">View Work Training</a>
                        </li>
                         <li   class="nav-item">
                            <a class="nav-link" href="projectAssigned.jsp?pN=1">Project Assigned</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="monthlyReport.jsp">Monthly Report</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="monthlyReportView.jsp">View Monthly Report </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="viewTeamProject.jsp">View Team Project</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="viewBranchProject.jsp">Branch Project</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="grievance.jsp">Grievance</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="grievanceView.jsp">View Grievance  </a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="vmsExperience.jsp">VMS Feedback</a>
                        </li>
                         <li   class="nav-item">
                            <a class="nav-link" href="viewVmsExperience.jsp?pN=1">View VMS Feedback</a>
                        </li> 
                    </ul>
                </div> 
            </div> 
        </div>
        <div class="col-md-10 col-lg-9 col-sm-9 col-xs-12" style="padding:3px 0px;">
	 	   <ul class="collapsible" data-collapsible="accordion" style="list-style:none; margin-left:auto; margin-right:auto;">
			 
				 <%while(teamProjectsRs.next()){ %>
				 <%  status = ct.getTeamProjectStatus(request,response, teamProjectsRs.getString("id")); %>
							 
					<li>
						<div class="collapsible-header active"><p style="padding:10px; background-color:#053256; font-size:14px;">
							
							 
								<span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
							 
							<!-- <span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
							 --><%=teamProjectsRs.getString("tproject_title") %>
							 
					  		<span style="float: right; margin-right: 39px;" >
						  		<i class="fa fa-users"  style="text-align: right; color:#fff; font-size:22px; font-style: bold;"> </i> &nbsp;&nbsp; 
							 	<%=teamProjectsRs.getString("team") %>  
							</span> 		
				 	 	</div> 
						<div class="collapsible-body" style="background-color: #fff;">
							<div class="col-lg-12" style="margin-left:90px;">
								<div class="row"  >
									<div class="col-lg-6" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-calendar-o" style="font-size:20px;  "></i>  &nbsp;  &nbsp;  Start Date</strong> &nbsp; <%=teamProjectsRs.getString("tpro_start_date") %>      </p>
										</div>
									</div>
									<div class="col-lg-6" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-calendar-o" style="font-size:20px;  "></i> &nbsp;  &nbsp; End Date</strong> &nbsp; <%=teamProjectsRs.getString("tpro_end_date") %>   </p>
										</div>
									</div>
								</div>
								<br>
								<p style="  font-size:16px;"><%=teamProjectsRs.getString("tproject_desc") %>  </p> 
							<%if(status ==null){
							%>
								<br><a  class="btn btn-primary" href="temProjectEnrollRequest.jsp?projectId=<%=teamProjectsRs.getString("id")%>"><i class="fa fa-plus" style="color:#fff; font-size:22px;  "></i> Enroll  Request </a>
							<%}
							else if(status.equals("Project Assigned")){ %>
							<%}else if(status.equals("Not Approved")){ %>
								<br><a  class="btn btn-primary" href="teamProjectEnrollCancelRequest.jsp?projectId=<%=teamProjectsRs.getString("id")%>"><i class="fa fa-cross" style="color:#fff; font-size:22px;  "></i> Cancel  Request </a>
							<%}else if(status.equals("Approved")){ %>
							<i class="fa fa-circle-right" style="color:green;"></i>
							 <%} %>
							</div> 
					</div>
				</li>
				<%} %> 
				   
	  		</ul>
	  		<div class="col-lg-12 text-center" style="margin-left:auto; margin-right:auto;">
					<ul class="pagination " >
						<% for( int k=1; k<=pageCount; k++){ %>
					    	<li><a href="viewTeamProject.jsp?pN=<%=k%>"><%=k%></a></li>
					    <% } %> 
				 	</ul>
		 		</div>
    	</div>
 	</div>
</div>
  
<%} %>
<br><br><br> 
<div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">© 2018 Sarvahitkari . All rights reserved | Design by <a href="#">Kapil Thakur & Rebecca John</a></p>
</div> 
	  

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