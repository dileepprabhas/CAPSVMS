<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@page import="com.daniel.util.DbUtil"%>
<%@ page import="com.daniel.util.DbUtil.*" %>

<%@ page import ="java.text.SimpleDateFormat "  %>
<%@page import ="java.util.Date"  %>
<%
Connection connection=DbUtil.getConnection();

%>
  <%! 
     java.sql.Statement st = null; 
 %>
 <%try{%> 
<%

String comment =request.getParameter("comment");

String id =request.getParameter("id");
String admin_id = (String)session.getAttribute("adminId");
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
Date date = new Date();  
   st= connection.createStatement(); 
  
// int n =st.executeUpdate("insert into question1 select subjectid from subject where subjectName='"+subjectid+" && insert into question1 values ('"+questionid+"','"+content+"')");
int n =st.executeUpdate("insert into sub_admin_minutes_meeting_comment (comment,admin_id,sub_admin_minutes_meeting_id,comment_time) values ('"+comment+"','"+admin_id+"','"+id+"',  '"+formatter.format(date)+"' )"); 

response.sendRedirect("viewCoreMeeting.jsp");
%>
 <%}
        catch(SQLException se){
            se.printStackTrace();
         } 
         catch (NullPointerException e) {
      	   e.printStackTrace();
      	  }
         catch(Exception e){
            e.printStackTrace();
         }
        finally{
        	if(st!=null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	 
        	}
        
         
        %>