<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@page import="com.daniel.util.DbUtil"%>
<%@ page import="com.daniel.util.DbUtil.*" %>
<%
Connection connection=DbUtil.getConnection();

%>
  <%! 
     java.sql.Statement st =null;
     
 %>
 <%try{%> 
<% 
 

String vanue=request.getParameter("vanue");

String meet_called_by=request.getParameter("meet_called_by");

String faci=request.getParameter("faci");

String note=request.getParameter("note");

String topic=request.getParameter("topic");

String act=request.getParameter("act");

String dis_con=request.getParameter("dis_con");
 

String id=request.getParameter("id");

   st= connection.createStatement(); 
   String status ="Updated";
  
// int n =st.executeUpdate("insert into question1 select subjectid from subject where subjectName='"+subjectid+" && insert into question1 values ('"+questionid+"','"+content+"')");
int n =st.executeUpdate("update  student_head_meeting set      venue='"+vanue+"', meeting_called_by= '"+meet_called_by+"',facilitator ='"+faci+"',note_taken ='"+note+"', topics='"+topic+"',action='"+act+"' , discussion='"+dis_con+"', status='"+status+"' where id='"+id+"'"); 

response.sendRedirect("viewVolunteerMeeting.jsp");
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