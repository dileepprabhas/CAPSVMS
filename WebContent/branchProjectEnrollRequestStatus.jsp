 <%@ page import="java.sql.*" %> 
<%@ page import ="javax.sql.*" %>
<%@page import="com.daniel.util.DbUtil"%>
<%@ page import="com.daniel.util.DbUtil.*" %>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
Connection connection = DbUtil.getConnection();

%>

 <%
   	String result;
   
	String to = request.getParameter("email");
   	String projectId = request.getParameter("projectId");

   	String pname = request.getParameter("pname");
     
   	
   	PreparedStatement ps=null;
   	String q = "delete from team_project_enrollment where id ="+projectId;
 
    
    ps = connection.prepareStatement(q);
    
       
  ps.executeUpdate();
    
   	
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
    	      
      message.setSubject("Branch Project Enrollment Status"); 
      message.setText("Dear Volunteer\n "
    		  +"\n\n Your enroll request for the branch project "+pname+"has been Rejected"
    		   +"\n\nThank You" 
    		  +"\nWarm Regards"
    		  +"\n\nPrismVMS"
    		   );
 			 
     Transport.send(message);
      result = "Sent message successfully....";
      response.sendRedirect("teamProjectEnrollRequestView.jsp?pN=1");
		
      
   }catch (MessagingException mex) {
      mex.printStackTrace();
      result = "Error: unable to send message....";
   }  
%>