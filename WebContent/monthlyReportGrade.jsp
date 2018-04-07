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
			<div class="col-md-2 cart-wthree">  
				 
					<a href="mentorLogout.jsp" class="w3view-cart"  style="color:#66bdd7;" ><i class="fa fa-sign-out" style="margin-left:15px;"></i><br>Sign Out </a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<% try{ %>
  
<%!  
	ResultSet monthlyReportRs=null,branchRs=null;
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
finally
{

}
if(mentorStatus == 1){
String id = request.getParameter("id");
String vIds = request.getParameter("vIds");
String email = request.getParameter("email");


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
                            <a class="nav-link active" href="viewMonthlyReport.jsp?pN=1">View Monthly Report</a>
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
	 	 
			<form name="f1"  action="monthlyReportGradingStore.jsp" method="post"  onSubmit="return validate(this)"  >
				<input type="hidden" name=monthrpt_id value="<%=id%>" >
				<input type="hidden" name="vIds" value="<%=vIds%>">
				<input type="hidden" name="email" value="<%=email%>">
				<div class="data">
					<table id="table1">
					
						<tbody>
							<tr>
							<td><p>Creativity </p></td>
							<td>
							<select required  name="creativity" id="creativity" onchange="total1()" >
								<option value="" >Marks</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
							</select>
							</td>
							<td><p>Punctuality </p></td>
							<td>
							<select  name="punctuality"  required id="punctuality" onchange="total1()" >
								<option value="" >Marks</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
							</select>
							</td>
							
							<td><p>Work Ethics</p></td>
							<td>
							<select name="work_ethic" required id="work_ethic" onchange="total1()" >
								<option value="" >Marks</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
							</select>
							</td>
						</tr>
							<tr>
							<td><p>Quality of Work</p></td>
							<td>
							<select name="qual_of_work" required id="qual_of_work" onchange="total1()"  >
								<option value="" >Marks</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
							</select>
							</td>
							
							<td><p>Reliability</p></td>
							<td>
							<select name="reliability" required  id="reliability" onchange="total1()" >
								<option value="" >Marks</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
							</select>
							</td>
							
							<td><p>Decision Making</p></td>
							<td>
							<select name="decision_making" required  id="decision_making" onchange="total1()" >
								<option value="" >Marks</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
							</select>
							</td>
						</tr>
						<tr>
						<td><p>Promptness</p></td>
						<td><select name="promtness" required id="promtness" onchange="total1()"  >
							<option value="" >Marks</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
						</select></td>
						
						<td><p>Involvement </p></td>
						<td>
						<select name="involvement" required id="involvement" onchange="total1()" >
							<option value="" >Marks</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
						</select>
						</td>
						
						<td><p>Upgradation of skills</p></td>
						<td>
						<select name="up_of_skill" required id="up_of_skill" onchange="total1()"  >
							<option value="" >Marks</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
						</select>
						</td>
						</tr>
						<tr>
						<td><p>Overall Growth</p></td>
						<td>
						<select name="overall_growth" required id="overall_growth" onchange="total1()"  >
							<option value="" >Marks</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
						</select>
						</td>
						
							<td><p>Total</p></td>
							<td><input  readonly id="total" style="opacity:1; margin-top:-10px; width:80px; height:30px;" value="0" type="text" name="total"></td>
							<td><p>Comment</p>
							<td><textarea  required placeholder="Write your Views or Suggestions" name=comment  ></textarea></td>
						</tr>
						
						</tbody>
					</table>
					
					<table id="table2">
						<tbody>
							<tr>
							
						</tbody>
					</table>
					
					<input type="submit"  id="btn" style="opacity:1;  " class="btn-info btn-md" value="Submit" >
				</div>
			</form>
	 	 
	 	   
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



<script>
function validate()
{
	
	
	 var e2 = document.getElementById("creativity");
	   var strUser = e2.options[e2.selectedIndex].value;
	   //if you need text to be compared then use
	   var strUser1 = e2.options[e2.selectedIndex].text;
	   if(strUser==0) //for text use if(strUser1=="Select")
	   {
		  document.getElementById("creativity").focus();
			return false;
	   }    
	   
	   var e3 = document.getElementById("punctuality");
	   var strUser2 = e3.options[e3.selectedIndex].value;
	   //if you need text to be compared then use
	   /* var strUser2 = e3.options[e3.selectedIndex].text;
	   */ if(strUser2==0) //for text use if(strUser1=="Select")
	   {
		   document.getElementById("punctuality").focus();
			return false;
	   }    
	   
	   var e4 = document.getElementById("work_ethic");
	   var strUser3 = e4.options[e4.selectedIndex].value;
	   //if you need text to be compared then use
	   /* var strUser1 = e4.options[e4.selectedIndex].text; */
	   if(strUser3==0) //for text use if(strUser1=="Select")
	   {
	   
		   
		   
		   
			          document.getElementById("work_ethic").focus();
			      return false;
	   	}   
	   
	   var e5 = document.getElementById("qual_of_work");
	   var strUser4 = e5.options[e5.selectedIndex].value;
	   //if you need text to be compared then use
	  /*  var strUser1 = e2.options[e2.selectedIndex].text; */
	   if(strUser4==0) //for text use if(strUser1=="Select")
	   { 
			document.getElementById("qual_of_work").focus();
			return false;
	   }   
	   
	 
	   
	   
	   var e7 = document.getElementById("reliability");
	   var strUser6 = e7.options[e7.selectedIndex].value;
	   //if you need text to be compared then use
	   /* var strUser1 = e2.options[e2.selectedIndex].text;
	    */if(strUser6==0) //for text use if(strUser1=="Select")
	   {
	     	document.getElementById("reliability").focus();
		 	return false;
	   }   
	   
	   
	   
	   var e8 = document.getElementById("decision_making");
	   var strUser7 = e8.options[e8.selectedIndex].value;
	   //if you need text to be compared then use
	   /* var strUser1 = e2.options[e2.selectedIndex].text;
	    */if(strUser7==0) //for text use if(strUser1=="Select")
	   {
		    document.getElementById("decision_making").focus();
		 	return false;
	   }   
	   
	   
	   var e9 = document.getElementById("promtness");
	   var strUser8 = e9.options[e9.selectedIndex].value;
	   //if you need text to be compared then use
	 /*   var strUser1 = e2.options[e2.selectedIndex].text;
	   */ if(strUser8==0) //for text use if(strUser1=="Select")
	   {

			document.getElementById("promtness").focus();
			return false;
	   } 
	   
	   
	   var e10 = document.getElementById("involvement");
	   var strUser9 = e10.options[e10.selectedIndex].value;
	   //if you need text to be compared then use
	   /* var strUser1 = e10.options[e10.selectedIndex].text;
	    */if(strUser9==0) //for text use if(strUser1=="Select")
	   {
	    	document.getElementById("involvement").focus();
	   		return false;
	   }
	   
	   var e11 = document.getElementById("up_of_skill");
	   var strUser10 = e11.options[e11.selectedIndex].value;
	   //if you need text to be compared then use
	   /* var strUser1 = e2.options[e2.selectedIndex].text;
	    */if(strUser10==0) //for text use if(strUser1=="Select")
	   {
	    	document.getElementById("up_of_skill").focus();
		    return false;
	   
	   }
	   
	   var e12 = document.getElementById("overall_growth");
	   var strUser11 = e12.options[e12.selectedIndex].value;
	   //if you need text to be compared then use
	   /* var strUser1 = e2.options[e2.selectedIndex].text;
	    */if(strUser11==0) //for text use if(strUser1=="Select")
   		{ 	document.getElementById("overall_growth").focus();
	   		return false; 
	   	}
	    var x1=document.f1.comment.value;
		if (x1==null || x1=="")
			{
				document.f1.comment.focus();
	   		    return false;
			} 
		
	
	
 
}
 function total1()
 {
	 var num1=document.getElementById("creativity").value;
	 var num2=document.getElementById("punctuality").value;
	 var num3=document.getElementById("work_ethic").value;
	 var num4=document.getElementById("qual_of_work").value;
	 var num5=document.getElementById("reliability").value;
	 var num6=document.getElementById("decision_making").value;
	 var num7=document.getElementById("promtness").value;
	 var num8=document.getElementById("involvement").value;
	 var num9=document.getElementById("up_of_skill").value;
	 var num10=document.getElementById("overall_growth").value;
	 document.getElementById("total").value=parseInt(num1)+parseInt(num2)+parseInt(num3)+parseInt(num4)+parseInt(num5)+parseInt(num6)+parseInt(num7)+parseInt(num8)+parseInt(num9)+parseInt(num10);
 }
 </script>
</body>
</html>