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
 button,button:hover,button:active,button:visited
 {
 color:white;
 }
 
   .modal-footer {
    padding: 15px;
    text-align: right;
    border-top:none;
}

    textarea.form-control
    {
    height:80px;
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
<div class="outercontainer" style="margin-top:0px; height:100px; background-color: #f8f8f8;">
	<div class="header-bottom-w3ls" style="padding:22px;">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="mentorIndex.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div>  
			<div class="col-md-8 cart-wthree">  
			</div>
			<div class="col-md-2 cart-wthree">  
				 
					<a href="mentorLogout.jsp" class="w3view-cart"  style="color:#053256;" ><i class="fa fa-sign-out" style="margin-left:15px;"></i><br>Sign Out </a>
				  	 
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>   
<% try{ %>
  
<%!  
	ResultSet ngoDetail=null;
	int mentorStatus=0; 
	String adminId =null,PhoneNumber=null;
	ResultSet meetingRs=null; 
	Control ct = new Control();
%>  <%!
     java.sql.Statement statement1 =null;
     java.sql.ResultSet resultset1=null;
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
	 
	 meetingRs= ct.getCoreMeeting(request,response);
	
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
                         	<a class="nav-link" href="mentorIndex.jsp">Home</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link" href="mentorVolunteerWorkDiary.jsp?pN=1">Work Diary</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link" href="mentorVolunteerMeeting.jsp?pN=1">Work Meeting</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link" href="mentorVolunteerTraining.jsp?pN=1">Work Training</a>
                        </li>                       	 
                        <li  class="nav-item">
                            <a class="nav-link" href="individualProject.jsp?pN=1">Individual Projects</a>
                        </li> 
                        <li  class="nav-item">
                            <a class="nav-link" href="teamProject.jsp">Team Projects</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link" href="teamProjectView.jsp?pN=1">View Team Projects</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link" href="teamProjectEnrollRequestView.jsp?pN=1"> Team Project Enroll Request</a>
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
                            <a class="nav-link" href="coreMeeting.jsp">Core Meeting</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link active" href="viewCoreMeeting.jsp">View Core Meeting </a>
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
        
      <ul class="collapsible" data-collapsible="accordion" style="list-style:none; margin-left:auto; margin-right:auto;">
			 <%while(meetingRs.next()){ %>
				   <% int i= 0; %>
				   <%if(meetingRs.getString("sub_admin_minutes_meeting.admin_id").equals(adminId)){ %>
					<li>
						<div class="collapsible-header active"><p style="padding:10px; background-color:#053256; font-size:14px;">
							<span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
							 <%=meetingRs.getString("admin.Name") %> 
							 
					  		<span class="text-center" style="  margin-left:250px;	" >
						  		<i class="fa fa-calendar-o"  style="text-align: right; color:#fff; font-size:22px; font-style: bold;"> </i> &nbsp;&nbsp; 
							 	<% String da = meetingRs.getString("sub_admin_minutes_meeting.meeting_date");String	A[]	=da.split("/");if(A[1].equals("01")){%><%=A[0]%> Jan<%}else if(A[1].equals("02")){%><%=A[0]%>Feb<% }else if(A[1].equals("03")){%><%=A[0]%>Mar<%}else if(A[1].equals("04")){%><%=A[0]%> Apr<%}else if(A[1].equals("05")){%><%=A[0]%>May<% }else if(A[1].equals("06")){%><%=A[0]%> Jun<%}else if(A[1].equals("07")){%><%=A[0]%> Jul<%}else if(A[1].equals("08")){%><%=A[0]%> Aug<%}else if(A[1].equals("09")){%><%=A[0]%> Sep<%}else if(A[1].equals("10")){%><%=A[0]%> Oct<%}else if(A[1].equals("11")){%><%=A[0]%> Nov<%}else if(A[1].equals("12")){%><%=A[0]%> Dec<%}%>
					 			
							</span>
							<span  class="right" style="display:inline-block; float:right; font-size:14px;  margin-right: 13px;" >
						<i class="fa fa-dot-circle-o" style="color:#fff;font-size:22px; "></i>
							 <% if(meetingRs.getString("sub_admin_minutes_meeting.status")==null ){%>	 
			     				Not-Approved 
							<%} %>
							<% if(meetingRs.getString("sub_admin_minutes_meeting.status")!= null ){%>	 
			     				<%=meetingRs.getString("sub_admin_minutes_meeting.status") %> 
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
							<form name="fn<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>" id="f<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>" action="coreMeetingEdit.jsp" method="post">
							 	<input type="hidden" name="id" value="<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>">
								<div class="col-lg-6" >
									<div class="form-group">
							 	 		<label>Submission Date</label>
							 	 		<input id="date" type="text" class="form-control"  readonly value=" <%= meetingRs.getString("sub_admin_minutes_meeting.submit_date") %>" >
									</div>
									<div class="form-group">
								 	 		<label>Submitted By</label>
											<input type="text"  class="form-control"  name="meet_type" readonly value=" <%= meetingRs.getString("admin.name") %>" readonly>
								  	</div>
								  	<div class="form-group">
							 	 		<label>Date</label>
							 	 		<input id="date"  class="form-control"  type="text" readonly  value="<%= meetingRs.getString("sub_admin_minutes_meeting.meeting_date") %>"  name="date"></input>
					 	 		 	</div>
								 	<div class="form-group">
							 	 		<label>Duration</label>
							 	 		<input id="date"  class="form-control"  name="duration" type="text" readonly value="<%= meetingRs.getString("sub_admin_minutes_meeting.duration")%>">
									</div>
									<div class="form-group">
							 	 		<label>VenueType of Meeting </label>
									 	<input  name="meet_type" type="text"  class="form-control"    readonly value=" <%= meetingRs.getString("sub_admin_minutes_meeting.meeting_type") %>"></td>		
								 	</div>
									<div class="form-group">
								 	 	<label>Venue <span style="color:red; font-size:14px;"> * </span> </label>
										<input name="vanue"  class="form-control"  ondblclick="this.readOnly='';"  type="text"  readonly value=" <%= meetingRs.getString("sub_admin_minutes_meeting.venue") %>"  > 
									</div> 
									<div class="form-group">
							 	 		<label>Meeting Called By <span style="color:red; font-size:14px;"> * </span> </label>
										<input name="meet_called_by"  class="form-control"   ondblclick="this.readOnly='';"    readonly value=" <%= meetingRs.getString("sub_admin_minutes_meeting.meeting_called_by") %>" type="text" value="">
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
							 	 		<label>Facilitator <span style="color:red; font-size:14px;"> * </span> </label>
										<input name="faci"  class="form-control"   ondblclick="this.readOnly='';"    readonly  value=" <%= meetingRs.getString("sub_admin_minutes_meeting.facilitator") %>" type="text" value="">
									</div> 
									<div class="form-group">
							 	 		<label>Note Taker <span style="color:red; font-size:14px;"> * </span> </label>
										<input name="note" readonly class="form-control"   ondblclick="this.readOnly='';"   value=" <%= meetingRs.getString("sub_admin_minutes_meeting.note_taken") %>" type="text">
									</div>
									<div class="form-group">
							 	 		<label>Topics / Agenda<span style="color:red; font-size:14px;"> * </span> </label>
										<textarea  readonly  class="form-control"   ondblclick="this.readOnly='';"      name="topic" > <%= meetingRs.getString("sub_admin_minutes_meeting.topics") %></textarea>
									</div> 
									 <div class="form-group">
							 	 		<label>Decisions Taken<span style="color:red; font-size:14px;"> * </span> </label>
										<textarea name="dis_con"  class="form-control"   ondblclick="this.readOnly='';" readonly  > <%= meetingRs.getString("sub_admin_minutes_meeting.discussion") %></textarea>
									</div>	 
								 	<div class="form-group">
							 	 		<label> Action to be taken(Person & Date)<span style="color:red; font-size:14px;"> * </span> </label>
										<textarea name="act"  class="form-control"  readonly    ondblclick="this.readOnly='';"    ><%= meetingRs.getString("sub_admin_minutes_meeting.action") %></textarea>
									</div>
									 </div>
								 <span><p id="msg<%=i%>" style="color: red; font-size:17px; display: inline-block;" > </p></span>
								 <div class="center"  style=" text-align:center; margin:20px auto;  z-index:10;">
									<a  class="btn btn-primary" href="coreMeetingStatus.jsp?id=<%=meetingRs.getString("sub_admin_minutes_meeting.id") %>&status=Updated"   ><span style="font-size:18px; padding:3px;"  class="fa fa-check-square-o"  ><span style="font-size:18px; padding:3px;" > Update Status</span></span> </a>  
								    <a   class="btn btn-primary" href="#"      data-toggle="modal" data-target="#myModal<%=i %>"    ><span   style="font-size:18px;"   class="fa fa-commenting-o"><span style="font-size:18px; padding:3px;"> Comment</span></span></a>
								 	<a  class="btn btn-primary" href="#" id="a<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>" type="submit"  ><span style="font-size:18px;"  class="fa fa-edit"><span style="font-size:18px; padding:3px;"> Update Changes</span></span> </a>
								</div>
								</form>
							<br><br>
							</div> 
					</div>
				</li>
				<%}  %>
				   <script type="text/javascript">
 
 document.getElementById("a<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>").onclick = function() {
     var venue = document.fn<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>.vanue.value;
     var meet_called_by = document.fn<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>.meet_called_by.value;
     var faci = document.fn<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>.faci.value;
     var note = document.fn<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>.note.value;
     var topic = document.fn<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>.topic.value;
     var act = document.fn<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>.act.value;
     var dis_con = document.fn<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>.dis_con.value;
     
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
	 
	    document.getElementById("f<%=meetingRs.getString("sub_admin_minutes_meeting.id")%>").submit();
	    
	}
	} 
 </script>
 <!-- Modal -->
<div id="myModal<%=i %>" style="border:none; top:0; padding:none; background: transparent; width:100%; " class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Comment Box for   <%= meetingRs.getString("admin.name") %>  Report</h4>
      </div>
      <div class="modal-body" style="max-hieght:350px;">
      
      <%
     String comment_id= meetingRs.getString("sub_admin_minutes_meeting.id");
      statement1 = connection.createStatement() ;
      resultset1 = 
      statement1.executeQuery("select * from sub_admin_minutes_meeting_comment where sub_admin_minutes_meeting_id='"+comment_id+"'");

      
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
	         	<span> <%=resultset1.getString("comment_time") %></span>
	         	<br>  <span style="margin-right:5px;"> Sent </span>
	         </p>
         </div>
         <%} %>
      
    <%} %>
        <br>
         <br>
           <div class="row" style=" float:left; text-align:center; bottom:0px;width:100%;">
         <form style="width:100%" action="coreMeetingComment.jsp">
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
			<%
			++i; } %>
			 
	  		</ul>
		  
        
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