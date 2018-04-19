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
textarea.form-control {
    height: 80px;
}
</style>

</head>
<body>

<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %> 
<%@page import="com.daniel.util.DbUtil"%>
<%@ page import="com.daniel.util.DbUtil.*" %>
<%
Connection connection=DbUtil.getConnection();
%>    
  
  
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
	ResultSet meetingRs=null, resultset1=null; 
	Statement statement1=null;
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
                            <a class="nav-link " href="teamMeeting.jsp">Team Meeting</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link active" href="viewTeamMeeting.jsp">View Team Meeting</a>
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
				<%meetingRs= ct.getStudentHeadMeeting(request,response); %>
					<%while(meetingRs.next()){ %>
					   <% int i= 0; %>
					   <%String meeetingStatus = meetingRs.getString("s.status");
					   if(meeetingStatus == null){
						   meeetingStatus = "Not-Approved";
					   }	
					   %>
					    <%if(meetingRs.getString("v.id").equals(volunteerId)) { %>
						<li>
							<div class="collapsible-header active"><p style="padding:10px; background-color:#053256; font-size:14px;">
								<span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
								 <%=meetingRs.getString("v.volunteer_name") %> 
								 
						  		<span class="text-center" style="  margin-left:250px;	" >
							  		<i class="fa fa-calendar-o"  style="text-align: right; color:#fff; font-size:22px; font-style: bold;"> </i> &nbsp;&nbsp; 
								 	<% String da = meetingRs.getString("s.meeting_date");String	A[]	=da.split("/");if(A[1].equals("01")){%><%=A[0]%> Jan<%}else if(A[1].equals("02")){%><%=A[0]%>Feb<% }else if(A[1].equals("03")){%><%=A[0]%>Mar<%}else if(A[1].equals("04")){%><%=A[0]%> Apr<%}else if(A[1].equals("05")){%><%=A[0]%>May<% }else if(A[1].equals("06")){%><%=A[0]%> Jun<%}else if(A[1].equals("07")){%><%=A[0]%> Jul<%}else if(A[1].equals("08")){%><%=A[0]%> Aug<%}else if(A[1].equals("09")){%><%=A[0]%> Sep<%}else if(A[1].equals("10")){%><%=A[0]%> Oct<%}else if(A[1].equals("11")){%><%=A[0]%> Nov<%}else if(A[1].equals("12")){%><%=A[0]%> Dec<%}%>
						 			
								</span>
								<span  class="right" style="display:inline-block; float:right; font-size:14px;  margin-right: 13px;" >
							<i class="fa fa-dot-circle-o" style="color:#fff;font-size:22px; "></i>
								 <% if(meetingRs.getString("s.status")==null  ){%>	 
				     				Not-Approved 
								<%} %>
								<% if(meetingRs.getString("s.status")!= null ){%>	 
				     				<%=meetingRs.getString("s.status") %> 
								<%} %>
										</span> 		
					 	 	</div> 
							<div class="collapsible-body" style="background-color: #fff;">
								<div class="col-lg-6">
									<span style="font-size:12px;  color:red;"> &nbsp;&nbsp;&nbsp; * Fields are editable,  double click to edit</span>
								</div>
								<div class="col-lg-6">
									<span style="font-size:12px;  color:red;"> &nbsp;&nbsp;&nbsp; To  save changes,  click on 'Update Changes'</span>
								</div>
								<form name="fn<%=meetingRs.getString("s.id")%>" id="f<%=meetingRs.getString("s.id")%>" action="teamMeetingEdit.jsp" method="post">
								 	<input type="hidden" name="id" value="<%=meetingRs.getString("s.id")%>">
									<div class="col-lg-6" >
										<div class="form-group">
								 	 		<label>Submission Date</label>
								 	 		<input id="date" type="text" class="form-control"  readonly value=" <%= meetingRs.getString("s.submit_date") %>" >
										</div>
										<div class="form-group">
									 	 		<label>Submitted By</label>
												<input type="text"  class="form-control"  name="meet_type" readonly value=" <%= meetingRs.getString("v.volunteer_name") %>" readonly>
									  	</div>
									  	<div class="form-group">
								 	 		<label>Date</label>
								 	 		<input id="date"  class="form-control"  type="text" readonly  value="<%= meetingRs.getString("s.meeting_date") %>"  name="date"></input>
						 	 		 	</div>
									 	<div class="form-group">
								 	 		<label>Duration</label>
								 	 		<input id="date"  class="form-control"  name="duration" type="text" readonly value="<%= meetingRs.getString("s.duration")%>">
										</div>
										<div class="form-group">
								 	 		<label>Type of Meeting </label>
										 	<input  name="meet_type" type="text"  class="form-control"    readonly value=" <%= meetingRs.getString("s.meeting_type") %>"></td>		
									 	</div>
										<div class="form-group">
									 	 	<label>Venue <span style="color:red; font-size:14px;"> * </span> </label>
											<input name="vanue"  class="form-control"  ondblclick="this.readOnly='';"  type="text"  readonly value=" <%= meetingRs.getString("s.venue") %>"  > 
										</div> 
										<div class="form-group">
								 	 		<label>Meeting Called By <span style="color:red; font-size:14px;"> * </span> </label>
											<input name="meet_called_by"  class="form-control"   ondblclick="this.readOnly='';"    readonly value=" <%= meetingRs.getString("s.meeting_called_by") %>" type="text" value="">
										</div>
										<div class="form-group">
								 	 		<label>Facilitator <span style="color:red; font-size:14px;"> * </span> </label>
											<input name="faci"  class="form-control"      readonly  value=" <%= meetingRs.getString("s.facilitator") %>" type="text" value="">
										</div>
									</div>
									<div class="col-lg-6">
										 
										<% if(meetingRs.getString("s.attendees")==null){ 
											
											 int len = meetingRs.getString("s.absentees").length();
											String absen = meetingRs.getString("s.absentees");
									 		absen = absen.substring(0,len-2);
									 		
								  		 	String s = "";
								  		 	String[] charArray = absen.split(" , ");
								  		 	for(int k=0;k<charArray.length ;k++)
									  	     {
									  	    	 s=s+"'"+charArray[i]+"'";
									  	    	 if(k<(charArray.length)-1)
									  	    	 {
									  	    		s=s+" , " ;
									  	    	 }
									  	     }  
											ResultSet rs = ct.getTeamMateAttend(s,ct.getVolunteerTeam( meetingRs.getString("v.id")), ct.getVolunteerBranch( meetingRs.getString("v.id")) );
										 	String attendees = "";
											while(rs.next())
										 	{
												attendees = attendees+rs.getString("volunteer_name")+" , ";
										 	}
											attendees = attendees.substring(0, attendees.length()-2);
										%>
										<div class="form-group">
								 	 		<label>Attendees <span style="color:red; font-size:14px;"> * </span> </label>
											<input name="fdg" readonly class="form-control"      value="<%=attendees %>" type="text">
										</div>
										
										<%
										
										}
										else{%>
										<div class="form-group">
								 	 		<label>Attendees <span style="color:red; font-size:14px;"> * </span> </label>
											<input name="fdg" readonly class="form-control"      value="<%=meetingRs.getString("s.attendees") %>" type="text">
										</div>
										<%} %>
										<div class="form-group">
								 	 		<label>Absentees <span style="color:red; font-size:14px;"> * </span> </label>
											<input name="nsdfgfote" readonly class="form-control"   ondblclick="this.readOnly='';"   value=" <%= meetingRs.getString("s.absentees") %>" type="text">
										</div>
										<div class="form-group">
								 	 		<label>Note Taker <span style="color:red; font-size:14px;"> * </span> </label>
											<input name="note" readonly class="form-control"   ondblclick="this.readOnly='';"   value=" <%= meetingRs.getString("s.note_taken") %>" type="text">
										</div>
										<div class="form-group">
								 	 		<label>Topics / Agenda<span style="color:red; font-size:14px;"> * </span> </label>
											<textarea  readonly  class="form-control"   ondblclick="this.readOnly='';"      name="topic" > <%= meetingRs.getString("s.topics") %></textarea>
										</div> 
										 <div class="form-group">
								 	 		<label>Decisions Taken<span style="color:red; font-size:14px;"> * </span> </label>
											<textarea name="dis_con"  class="form-control"   ondblclick="this.readOnly='';" readonly  > <%= meetingRs.getString("s.discussion") %></textarea>
										</div>	 
									 	<div class="form-group">
								 	 		<label> Action to be taken(Person & Date)<span style="color:red; font-size:14px;"> * </span> </label>
											<textarea name="act"  class="form-control"  readonly    ondblclick="this.readOnly='';"    ><%= meetingRs.getString("s.action") %></textarea>
										</div>
									 </div>
									 <span><p id="msg<%=i%>" style="color: red; font-size:17px; display: inline-block;" > </p></span>
									 <%if(meetingRs.getString("v.id").equals(volunteerId)) {%>
									 <div class="text-center col-lg-12"  style=" text-align:center; margin:20px auto;  z-index:10;">
										<a  class="btn btn-primary" href="teamMeetingStatus.jsp?id=<%=meetingRs.getString("s.id") %>&status=Updated"   ><span style="font-size:18px; padding:3px;"  class="fa fa-check-square-o"  ><span style="font-size:18px; padding:3px;" > Update Status</span></span> </a>  
									    <a   class="btn btn-primary" href="#"      data-toggle="modal" data-target="#myModal<%=i %>"    ><span   style="font-size:18px;"   class="fa fa-commenting-o"><span style="font-size:18px; padding:3px;"> Comment</span></span></a>
									 	<a  class="btn btn-primary" href="#" id="a<%=meetingRs.getString("s.id")%>" type="submit"  ><span style="font-size:18px;"  class="fa fa-edit"><span style="font-size:18px; padding:3px;"> Update Changes</span></span> </a>
									</div>
									<%} %>
									</form>
								<br><br>
						 		
					 		<%if(meetingRs.getString("v.id").equals(volunteerId)) {%>
							<script type="text/javascript">
	 
							 	 document.getElementById("a<%=meetingRs.getString("s.id")%>").onclick = function() {
							     var venue = document.fn<%=meetingRs.getString("s.id")%>.vanue.value;
							     var meet_called_by = document.fn<%=meetingRs.getString("s.id")%>.meet_called_by.value;
							     var faci = document.fn<%=meetingRs.getString("s.id")%>.faci.value;
							     var note = document.fn<%=meetingRs.getString("s.id")%>.note.value;
							     var topic = document.fn<%=meetingRs.getString("s.id")%>.topic.value;
							     var act = document.fn<%=meetingRs.getString("s.id")%>.act.value;
							     var dis_con = document.fn<%=meetingRs.getString("s.id")%>.dis_con.value;
							     
								 if(venue==null || venue==""){
									   document.getElementById('msg<%=i%>').innerHTML = "Please enter the Venue";
									 return false 
									 }
								 else if(meet_called_by==null || meet_called_by==""){
									 
									 document.getElementById('msg<%=i%>').innerHTML = "Please enter the Fired Meeting Called By";
									 return false 
								 }
								else if(faci==null || faci==""){
										 
									 document.getElementById('msg<%=i%>').innerHTML = "Please enter the Field	Facilitator";
										 return false 
									 }
								else if(note==null || note==""){
									 
									 document.getElementById('msg<%=i%>').innerHTML = "Please enter the Field	 Note Taker";
									 return false 
								 }
								 
								else if(topic==null || topic==""){
									 
									 document.getElementById('msg<%=i%>').innerHTML = "Please enter the Field	Topics / Agenda ";
									 return false 
								 }
								else if(act==null || act==""){
									 
									 document.getElementById('msg<%=i%>').innerHTML = " Please enter the Field	 Action to be taken(Person & Date)";
									 return false 
								 }
								else if(dis_con==null || dis_con==""){
									 
									 document.getElementById('msg<%=i%>').innerHTML = " Please enter the Field Decisions Taken";
									 return false 
								 }
								else{
								 
								    document.getElementById("f<%=meetingRs.getString("s.id")%>").submit();
								    
								}
								} 
	 						</script>
							 <!-- Modal -->
							<div id="myModal<%=i%>" style="border:none; top:0; padding:none; background: transparent; width:100%; " class="modal fade" role="dialog">
							  <div class="modal-dialog">
							
							    <!-- Modal content-->
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal">&times;</button>
							        <h4 class="modal-title">Comment Box for   <%= meetingRs.getString("v.volunteer_name") %>  Report</h4>
							      </div>
							      <div class="modal-body" style="max-hieght:350px;">
							      
							      <%
							     String comment_id= meetingRs.getString("s.id");
							      statement1 = connection.createStatement() ;
							      resultset1 = 
							      statement1.executeQuery("select * from student_head_meeting_comment where student_head_meeting_id='"+comment_id+"'");
							
							      
							      %>
							      <%while(resultset1.next()){  
							        
							      if(resultset1.getString("admin_id")!=null){
							      %>
							         <div style="width:100%;margin:2px; background: #e5e5e5; padding:5px; border-radius:2px; border: 1px solid #cccccc;
							    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
							    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
							    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
							    -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;
							    -moz-transition: border linear 0.2s, box-shadow linear 0.2s;
							    -o-transition: border linear 0.2s, box-shadow linear 0.2s;
							    transition: border linear 0.2s, box-shadow linear 0.2s;  float:left; text-align:left;">
								       <span><img src="DisplayMentorPic?name=<%=resultset1.getString("admin_id")%>" style="width:40px; height:40px; border-radius: 50%;"> &nbsp; &nbsp; 
								       
								       
								     <%=resultset1.getString("comment")  %> <span></span>
								         <p style="text-align: right; padding:0px;" >
								         	<span> <%=resultset1.getString("time") %></span>
								         	<br>  <span style="margin-right:5px;"> Sent </span>
								         </p>
							         </div>
							         <%} else if(resultset1.getString("volunteer_registration_id")!=null){ %>
							           <div style="width:100%;margin:2px; background: #e5e5e5; padding:5px; border-radius:2px; border: 1px solid #cccccc;
							    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
							    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
							    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
							    -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;
							    -moz-transition: border linear 0.2s, box-shadow linear 0.2s;
							    -o-transition: border linear 0.2s, box-shadow linear 0.2s;
							    transition: border linear 0.2s, box-shadow linear 0.2s;  float:left; text-align:left;">
								       <span><img src="DisplayVolunteerPic?name=<%=resultset1.getString("volunteer_registration_id")%>" style="width:40px; height:40px; border-radius: 50%;"> &nbsp; &nbsp; 
								       
								       
								     <%=resultset1.getString("comment")  %> <span></span>
								         <p style="text-align: right; padding:0px;" >
								         	<span> <%=resultset1.getString("time") %></span>
								         	<br>  <span style="margin-right:5px;"> Sent </span>
								         </p>
							         </div>
							      <%} %>
							    <%} %>
							        <br>
							         <br>
							           <div class="row" style=" float:left; text-align:center; bottom:0px;width:100%;">
							         <form style="width:100%" action="teamMeetingVolunteerComment.jsp">
							         <input type="hidden" name="id" value="<%=comment_id%>">
							         
								         <textarea class="text-area"  placeholder='Comment Box'  style="background: #ddd; padding:5x; color:#333; width:85%;" required name="comment" rows="3" cols="100"></textarea>
								         <input type="submit"   style="background:transparent; color:#337ab7; display: inine-block; font-size: 36px; width:36px; margin-bottom:30px; height:56px;"   class=" glyphicon"  value="&#xe171;"> </input>
							       
							         </form>
							         </div>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							      </div>
							    </div>
							  </div>
							</div>  
							<%} %>
						</div>
					</li>
					<%} else {  if(meetingRs.getString("s.meeting_type").equals("Student Head Meeting") && meeetingStatus.equals("Approved")  ){ %>
						<li>
							<div class="collapsible-header active"><p style="padding:10px; background-color:#053256; font-size:14px;">
								<span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
								 <%=meetingRs.getString("v.volunteer_name") %> 
								 
						  		<span class="text-center" style="  margin-left:250px;	" >
							  		<i class="fa fa-calendar-o"  style="text-align: right; color:#fff; font-size:22px; font-style: bold;"> </i> &nbsp;&nbsp; 
								 	<% String da = meetingRs.getString("s.meeting_date");String	A[]	=da.split("/");if(A[1].equals("01")){%><%=A[0]%> Jan<%}else if(A[1].equals("02")){%><%=A[0]%>Feb<% }else if(A[1].equals("03")){%><%=A[0]%>Mar<%}else if(A[1].equals("04")){%><%=A[0]%> Apr<%}else if(A[1].equals("05")){%><%=A[0]%>May<% }else if(A[1].equals("06")){%><%=A[0]%> Jun<%}else if(A[1].equals("07")){%><%=A[0]%> Jul<%}else if(A[1].equals("08")){%><%=A[0]%> Aug<%}else if(A[1].equals("09")){%><%=A[0]%> Sep<%}else if(A[1].equals("10")){%><%=A[0]%> Oct<%}else if(A[1].equals("11")){%><%=A[0]%> Nov<%}else if(A[1].equals("12")){%><%=A[0]%> Dec<%}%>
						 			
								</span>
								<span  class="right" style="display:inline-block; float:right; font-size:14px;  margin-right: 13px;" >
							<i class="fa fa-dot-circle-o" style="color:#fff;font-size:22px; "></i>
								 <% if(meetingRs.getString("s.status")==null ){%>	 
				     				Not-Approved 
								<%} %>
								<% if(meetingRs.getString("s.status")!= null ){%>	 
				     				<%=meetingRs.getString("s.status") %> 
								<%} %>
										</span> 		
					 	 	</div> 
							<div class="collapsible-body" style="background-color: #fff;">
								<form name="fn<%=meetingRs.getString("s.id")%>" id="f<%=meetingRs.getString("s.id")%>" action="coreMeetingEdit.jsp" method="post">
								 	<input type="hidden" name="id" value="<%=meetingRs.getString("s.id")%>">
									<div class="col-lg-6" >
										<div class="form-group">
								 	 		<label>Submission Date</label>
								 	 		<input id="date" type="text" class="form-control"  readonly value=" <%= meetingRs.getString("s.submit_date") %>" >
										</div>
										<div class="form-group">
									 	 		<label>Submitted By</label>
												<input type="text"  class="form-control"  name="meet_type" readonly value=" <%= meetingRs.getString("v.volunteer_name") %>" readonly>
									  	</div>
									  	<div class="form-group">
								 	 		<label>Date</label>
								 	 		<input id="date"  class="form-control"  type="text" readonly  value="<%= meetingRs.getString("s.meeting_date") %>"  name="date"></input>
						 	 		 	</div>
									 	<div class="form-group">
								 	 		<label>Duration</label>
								 	 		<input id="date"  class="form-control"  name="duration" type="text" readonly value="<%= meetingRs.getString("s.duration")%>">
										</div>
										<div class="form-group">
								 	 		<label>Type of Meeting </label>
										 	<input  name="meet_type" type="text"  class="form-control"    readonly value=" <%= meetingRs.getString("s.meeting_type") %>"></td>		
									 	</div>
										<div class="form-group">
									 	 	<label>Venue </label>
											<input name="vanue"  class="form-control"  ondblclick="this.readOnly='';"  type="text"  readonly value=" <%= meetingRs.getString("s.venue") %>"  > 
										</div> 
										<div class="form-group">
								 	 		<label>Meeting Called By </label>
											<input name="meet_called_by"  class="form-control"   ondblclick="this.readOnly='';"    readonly value=" <%= meetingRs.getString("s.meeting_called_by") %>" type="text" value="">
										</div>
										<div class="form-group">
								 	 		<label>Facilitator  </label>
											<input name="faci"  class="form-control"   ondblclick="this.readOnly='';"    readonly  value=" <%= meetingRs.getString("s.facilitator") %>" type="text" value="">
										</div> 
									</div>
									<div class="col-lg-6">
										
											<% if(meetingRs.getString("s.attendees")==null){ 
											
											 int len = meetingRs.getString("s.absentees").length();
											String absen = meetingRs.getString("s.absentees");
									 		absen = absen.substring(0,len-2);
									 										 		 
								  		 	String s = "";
								  		 	String[] charArray = absen.split(" , ");
								  		 	for(int k=0;k<charArray.length ;k++)
									  	     {
									  	    	 s=s+"'"+charArray[i]+"'";
									  	    	 if(k<(charArray.length)-1)
									  	    	 {
									  	    		s=s+" , " ;
									  	    	 }
									  	     }
								  		 	ResultSet rs = ct.getStudentHeadAttend(s,ct.getVolunteerTeam(meetingRs.getString("s.volunteer_registration_id")), ct.getVolunteerBranch( meetingRs.getString("s.volunteer_registration_id")) );
										 	String attendees = "";
											while(rs.next())
										 	{
												attendees = attendees+rs.getString("volunteer_name")+" , ";
										 	}
											attendees = attendees.substring(0, attendees.length()-2);
										%>
										<div class="form-group">
								 	 		<label>Attendees <span style="color:red; font-size:14px;"> * </span> </label>
											<input name="fdg" readonly class="form-control"      value="<%=attendees %>" type="text">
										</div>
										
										<%
										
										}
										else{%>
										<div class="form-group">
								 	 		<label>Attendees <span style="color:red; font-size:14px;"> * </span> </label>
											<input name="fdg" readonly class="form-control"      value="<%=meetingRs.getString("s.attendees") %>" type="text">
										</div>
										<%} %>
										<div class="form-group">
								 	 		<label>Absentees <span style="color:red; font-size:14px;"> * </span> </label>
											<input name="nsdfgfote" readonly class="form-control"   ondblclick="this.readOnly='';"   value=" <%= meetingRs.getString("s.absentees") %>" type="text">
										</div>
										<div class="form-group">
								 	 		<label>Note Taker </label>
											<input name="note" readonly class="form-control"   ondblclick="this.readOnly='';"   value=" <%= meetingRs.getString("s.note_taken") %>" type="text">
										</div>
										<div class="form-group">
								 	 		<label>Topics / Agenda </label>
											<textarea  readonly  class="form-control"   ondblclick="this.readOnly='';"      name="topic" > <%= meetingRs.getString("s.topics") %></textarea>
										</div> 
										 <div class="form-group">
								 	 		<label>Decisions Taken<span style="color:red; font-size:14px;"> * </span> </label>
											<textarea name="dis_con"  class="form-control"   ondblclick="this.readOnly='';" readonly  > <%= meetingRs.getString("s.discussion") %></textarea>
										</div>	 
									 	<div class="form-group">
								 	 		<label> Action to be taken(Person & Date)  </label>
											<textarea name="act"  class="form-control"  readonly    ondblclick="this.readOnly='';"    ><%= meetingRs.getString("s.action") %></textarea>
										</div>
									 </div>
								</form>
							<br><br> 
						</div>
					</li>
					<%}}  %>
					 				 
				<%++i;}%>
			</ul>
		</div>
		<%}%> 
	</div>
</div>
<br><br><br> 
<div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">© 2018 CAPS . All rights reserved | Web Development by <a target="_blank" style="color:" href="https://www.linkedin.com/in/kapil-thakur/">Kapil Thakur </a></p>
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