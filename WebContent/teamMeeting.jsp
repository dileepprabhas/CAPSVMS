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
.modal-footer {
    padding: 15px;
    text-align: right;
    border-top:none;
} 
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
				<a href="volunteerIndex.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div>  
			<div class="col-md-7 cart-wthree">  
			</div>
			<div class="col-md-3 cart-wthree" style="display:inline-flex;">  
				 
					<a href="volunteerLogout.jsp" class="w3view-cart"  style="color:#053256;" ><i class="fa fa-sign-out" style="margin-left:15px;"></i><br>Sign Out </a>
					<a href="https://christuniversity.in" target="_blank"><img src="images/logo.jpg" class="christLogo" align="right" ></a>
				  	 
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div> 


<% try{ %>
  
<%!  
	ResultSet ngoDetail=null,notificationRs=null,userNotificationRs=null;
	int volunteerStatus=0; 
	String volunteerId=null; 
	ResultSet usersRs=null,usersRs1=null; 
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
if(volunteerStatus == 1){	 
%>  	
 
<div class="outercontainer" style="padding-top:0px;  padding-right:10px; margin-left:10px; margin-top:10px; margin-right:15px;">
    <div class="row">
        <div class="col-md-2 col-lg-3 col-sm-3 col-xs-12" >

            <div class="bootstrap-vertical-nav" >
	 
 
                <div   id="collapseExample"style="margin-top:3px;" >
                     <ul class="nav flex-column" id="exCollapsingNavbar">
             			<li   class="nav-item" style="text-algin:center">
		                    <div class="text-center">
		                     <img src="DisplayVolunteerPic?name=<%=volunteerId %>"  style="width: 80px;text-aling: center;margin-top: 11px;height: 80px;border-radius: 50%;">
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
                         	<a class="nav-link" href="volunteerIndex.jsp">Home</a>
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
                            <a class="nav-link  " href="viewTeamProject.jsp">View Team Project</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="viewBranchProject.jsp">Branch Project</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link active" href="teamMeeting.jsp">Team Meeting</a>
                        </li>
                         <li   class="nav-item">
                            <a class="nav-link " href="viewTeamMeeting.jsp">View Team Meeting</a>
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
        	<br> 
     		<form name="f1" action="Control?action=submitStudentHeadMeeting" method="post" onsubmit="return validate() ">
				<div class="col-lg-6">
			 		<div class="form-group">
			 	 		<label>Date</label>
					 	<input required type="date" name="date" placeholder="select the date of meeting" style="opacity:1;" class="form-control">
				 	</div> 
					<div class="form-group">
				 	 	<label>Duration</label>
				 	 	<select name="duration"  required id="dur" class="form-control" >
					 		  <option value="">Meeting Duration</option>
					 		  <option>30 Minutes</option>
							  <option>60 Minutes</option>
					 	</select>
				  	</div>
					<div class="form-group">
				 	 	<label>Meeting Called By</label>
				 	 	<input name="meet_called_by"  required type="text"  placeholder="Meeting called by" class="form-control">
				  	</div> 
					<div class="form-group">
				 	 	<label>Facilitator</label>
				 	 	<input name="faci" type="text"  required  placeholder="Facilitator" class="form-control">
				  	</div>	<br>
				  	<div class="form-group">
				 	 	<label>Decisions Taken</label>
				 	 	<textarea name="discussion"  placeholder="Decisions Taken in Meeting" class="form-control" ></textarea>
				  	</div>  
		 		</div>
 				<div class="col-lg-6">  
			     	<div class="form-group">
				 	 	<label>Venue</label>
				 	 	<input name="vanue"  required class="form-control" placeholder="Meeting Venue" type="text" >
			  		</div>
				  	<div class="form-group">
					 	<label>Meeting Type</label>
					 	<select   onchange="yesnoCheck(this);" name="meet_type" required class="form-control"  >
							<option value="">Meeting Type</option>
							<option value="Team Meeting">Team Meeting</option>
							<option value="Student Head Meeting">Student Head Meeting</option>
						</select>
			 		</div>  
				 	<div class="form-group">
				 	 	<label>Note Taker</label>
				 	 	<input name="note" type="text" required  placeholder="Facilitator" class="form-control">
				  	</div> 
				  
				 	<div class="form-group">
				 	 	<label>Topics / Agenda</label>
				 	 	<textarea name="topic"  required  name="comment" class="form-control" placeholder="Topic / Agenda of Meeting" ></textarea>
				  	</div> 
			  		<div class="form-group">
				 	 	<label>Action to be taken (Person & Date)</label>
				 	 	<textarea  required  name="action" placeholder="Decisions Taken in Meeting" class="form-control" ></textarea>
				  	</div>
    			</div>
		     	<div class="text-center">    
			         <button id="ifYes" style="display:block; margin-left:auto;margin-right:auto;" type="button" class="  btn-lg-6" class="form-control" style="width:80%;" data-toggle="modal" data-target="#myModal">Next</button>
		    	</div>
		    	<div class="text-center">    
			         <button id="studentHead"  style="display:none; margin-left:auto;margin-right:auto;"   type="button" class=" btn-lg-6" class="form-control" style="width:80%;" data-toggle="modal" data-target="#myModal1">Next</button>
				</div>
<script>
    function yesnoCheck(that) {
        if (that.value == "Team Meeting") {
             
            document.getElementById("ifYes").style.display = "block"; 
            
        
            document.getElementById("studentHead").style.display = "none"; 
        }
        else if (that.value == "Student Head Meeting") {
            
            document.getElementById("studentHead").style.display = "block"; 
            document.getElementById("ifYes").style.display = "none"; 
        }
         
        	
    }
</script>	    	
		    	<%usersRs = ct.getTeamMates(request,response); %>
		    	<%usersRs1 = ct.getStudentHeads(request,response); %>
		    	<!-- Modal -->
				<div id="myModal" class="modal fade" role="dialog">
				  <div class="modal-dialog modal-lg modal-sm modal-md modal-xs">
				
				    <!-- Modal content-->

			    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <h4 class="modal-title">Attendees</h4>
				      </div>
				      <div class="modal-body">
				      <%while(usersRs.next()){ %>
				      	<div class="col-lg-4 col-md-4 col-xs-12 col-sm-6">
				        	<label class="container"><%=usersRs.getString("volunteer_name") %>
						  	<input type="checkbox"  name="volunteerIds" value="<%=usersRs.getString("id") %>">
						  	<span class="checkmark"></span>
							</label>
						</div>
						<%} %>
						 
				      </div>
				      <div class="modal-footer">
				      <hr>
				      	<button type="submit" class="btn " value="submit" >Submit</button>
				      	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				      </div>
				    </div>
				
				  </div>
				</div>
				<!-- Modal -->
				<div id="myModal1" class="modal fade" role="dialog">
				  <div class="modal-dialog modal-lg modal-sm modal-md modal-xs">
				
				    <!-- Modal content-->
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <h4 class="modal-title">Attendees</h4>
				      </div>
				      <div class="modal-body">
				      <%while(usersRs1.next()){ %>
				      	<div class="col-lg-4 col-md-4 col-xs-12 col-sm-6">
				        	<label class="container"><%=usersRs1.getString("volunteer_name") %>
						  	<input type="checkbox"  name="volunteerIds" value="<%=usersRs1.getString("id") %>">
						  	<span class="checkmark"></span>
							</label>
						</div>
						<%} %>
						 
				      </div>
				      <div class="modal-footer">
				      <hr>
				      	<button type="submit" class="btn " value="submit" >Submit</button>
				      	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				      </div>
				    </div>
				
				  </div>
				</div>
			</form>
		</div>
		<%}%> 
	</div>
</div>
<br><br><br> 
<div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">© 2018 CAPS . All rights reserved | Web Development by <a target="_blank" style="color:" href="https://www.linkedin.com/in/kapil-thakur/">Kapil Thakur </a></p>
</div>   

<%
	String action = request.getParameter("action"); 
		 		if(action == null)
		 		{
		 			
		 		}
		 		else if(action.equals("minutesOfMeetingSubmitted"))
		 		{%>
		 			<div id="snackbar"></div>
		 			<script>
		 			
				    var x = document.getElementById("snackbar")
				    x.className = "show";
				    x.innerHTML="Minutes of Meeting Submitted Successfully";
				    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
				 
				</script>
		 		<%}
		 		
		 	%>
</body>
</html>