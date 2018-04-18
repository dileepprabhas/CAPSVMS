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
    
<%
    Connection connection=DbUtil.getConnection();
%>
  
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
	ResultSet vmsExperinceRs=null,vmsExperinceCommentRs=null;
	int volunteerStatus=0; 
	String adminId = null,name=null,comment=null;
	ResultSet SubCategoryRs=null; 
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
	volunteerStatus  = ct.checkMentorStatus(request, response,adminId);  

if(volunteerStatus == 1){
	 
	pageNumber = Integer.parseInt(request.getParameter("pN")); 
	volunteerCount = ct.mentorVmsExperienceCount(adminId);
	pageCount= volunteerCount/10 +1;
	vmsExperinceRs = ct.getMentorVmsExperience(request, response,pageNumber-1, nextRecordCount);  
	/* ct.teamVolunteerDetails(pageNumber-1, nextRecordCount,adminId,branchId); */
	
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
                            <a class="nav-link active" href="mentorVmsExperienceView.jsp?pN=1">View VMS Feedback</a>
                        </li> 
                    </ul>
                </div> 
            </div> 
        </div>
         
        <div  class="col-md-10 col-lg-9 col-sm-9 col-xs-12" style="padding:3px 0px;">
              <ul class="collapsible" data-collapsible="accordion" style="list-style:none; margin-left:auto; margin-right:auto;">
			 <%!int j=1; %>
			  <% while(vmsExperinceRs.next()){%>
					<li>
						<div class="collapsible-header active"><p style="padding:10px; background-color:#053256; font-size:14px;">
							<span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
							 <%=ct.getMentorName(vmsExperinceRs.getString("admin_id"))%>
							 
					  		<span style="float: right; margin-right: 39px;" >
						  		<span class="glyphicon glyphicon-record" style="color:#fff; font-size:18px;"></span> &nbsp;&nbsp; 
							<%= vmsExperinceRs.getString("request_status") %>
							</span> 		
				 	 	</div> 
						<div class="collapsible-body" style="background-color: #fff;">
							<div class="col-lg-12" style="margin-left:8px;">
							<br><%= vmsExperinceRs.getString("category") %>
								<br><br>
								<p style="font-size:16px;"><%=vmsExperinceRs.getString("description") %>  </p> 
								<br>
								<div style="text-align:center;">
									<a href="#" data-toggle="modal" data-target="#myModal<%=j%>" style="margin-left:auto; margin-right:auto;"><i class="	fa fa-comments-o" style="color:#053256; font-size:22px;  "></i> Comments</a>
								</div>
							</div> 
					</div>
					<%comment = vmsExperinceRs.getString("id");%> 
					<%vmsExperinceCommentRs = ct.getVolunteerVmsExperienceComment(request,response,vmsExperinceRs.getString("id"));%>
					<div class="modal fade" id="myModal<%=j%>" role="dialog">
					    <div class="modal-dialog">
					    
					      <!-- Modal content-->
					      <div class="modal-content">
					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h4 class="modal-title">VMS Experience Chat Box</h4>
					        </div>
					        <div class="modal-body">
					        	<%
					        	if(!vmsExperinceCommentRs.next()){
					        	
					        	}
					        	else{while(vmsExperinceCommentRs.next()){%>
					         
                               <% if(vmsExperinceCommentRs.getString("admin_id")!=null){ %>  
                                <div style="width:100%;margin:2px; background: #e5e5e5; padding:5px; border-radius:2px; border: 1px solid #cccccc;-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075); -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);    -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;    -moz-transition: border linear 0.2s, box-shadow linear 0.2s;    -o-transition: border linear 0.2s, box-shadow linear 0.2s;    transition: border linear 0.2s, box-shadow linear 0.2s;  float:right; text-align:left;">
	                                
	                                <span>
                                        <img src="DisplayMentorPic?name=<%=vmsExperinceCommentRs.getString("admin_id")%>" align="left" style="width:40px; height:40px; border-radius: 50%;"> &nbsp; &nbsp;
                                        <%=vmsExperinceCommentRs.getString("comment")%> <span></span>
                                        <p style="text-align: right; padding:0px;" >
                                            <span>
                                              <%=vmsExperinceCommentRs.getString("comment_time")%>
                                              
                                               
                                            </span>
                                        </p>
                                </div>
                                <%  }  
                                } }%>
                                
                                 <div class="row" style=" float:left; text-align:center; bottom:0px;width:100%;">
                                    <form style="width:100%" method="post" action="Control?action=addMentorVmsExperienceComment">
                                        <input type="hidden" name="id" value="<%=comment%>">
                                        <textarea  placeholder='Comment Box'     style="  background: #ddd;  padding:5x; color:#333; border-radius: 2px;
border: 1px solid #cccccc;" required name="comment" rows="3" cols="80"></textarea>
                                        <input type="submit"  style="background:transparent;width: 38px;
    margin-top: 88px; opacity:1; color:#337ab7; display: inine-block; font-size: 36px; height:48px; border: none;"   class=" glyphicon"  value="&#xe171;"> </input>
                                    </form>
                                </div>
					        </div>
					        <div class="modal-footer">
					          
					        </div>
					      </div>
					      
					    </div>
  </div>
				</li>
				<%j++;} %> 
				 <div class="col-lg-12 text-center" style="margin-left:auto; margin-right:auto;">
					<ul class="pagination " >
						<% for( int k=1; k<=pageCount; k++){ %>
					    	<li><a href="teamProjectView.jsp?pN=<%=k%>"><%=k%></a></li>
					    <% } %> 
				 	</ul>
		 		</div>  
	  		</ul>
		 
	 
               
               
               
    	</div>
 	</div>
</div>
   <% } } catch (Exception e){ 	 	
}%> 

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
  <%if(action.equals("SubmitExperienceComment")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="You Have Send Your Comment Successfully";
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