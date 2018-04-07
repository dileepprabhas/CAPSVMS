<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
 <%@ page import="java.sql.*" %>
<%@page import="com.daniel.util.DbUtil"%>
<%@ page import="com.daniel.util.DbUtil.*" %> <%
	Connection connection = DbUtil.getConnection();
%>

 <%
 String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			com.daniel.util.control.Control ct;
			PreparedStatement ps = null;
		  	Statement st = null;
		  	String to = request.getParameter("email");
			String id=request.getParameter("monthrpt_id");
			String s1=request.getParameter("creativity");
			String s2=request.getParameter("punctuality");
			String s3=request.getParameter("work_ethic");
			String s4=request.getParameter("qual_of_work");
			String s5=request.getParameter("reliability");
			String s6=request.getParameter("decision_making");
			String s7= request.getParameter("promtness");
			String s8= request.getParameter("involvement");
			String s9= request.getParameter("up_of_skill");
			String s10= request.getParameter("overall_growth");
			String s11= request.getParameter("comment");
			String s12 = request.getParameter("total");
			String status ="Graded";
			st = connection.createStatement(); 
			  
			int n =st.executeUpdate("update month_workdairy set report_status='"+status+"', creativity ='"+s1+"',Punctuality='"+s2+"',work_ethics='"+s3+"',quality_work='"+s4+"',reliability='"+s5+"',decision_making='"+s6+"',promptness='"+s7+"',involvement='"+s8+"',upgradation_of_skills='"+s9+"',overall_growth='"+s10+"', comment='"+s11+"',total='"+s12+"' where month_work_id='"+id+"'"); 
			 
		  	String vId = request.getParameter("vIds");
	 
		  	String from = "kapil.thakur1496@gmail.com";
			Properties props = System.getProperties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");
			props.put("mail.store.protocol", "pop3");
			props.put("mail.transport.protocol", "smtp");
			final String username = "prismhack@gmail.com";
			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Monthly Report Grading"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n  Your monthly report  has been graded. Please login to check your grades." 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   		} 
		 
			response.sendRedirect("viewVolunteerMonthlyReport.jsp?vId="+vId);
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		  
		} 	 
	}	 
else{     
	 response.sendRedirect("mentorIndex.jsp?msg=LoginAgain");
	}  
%>