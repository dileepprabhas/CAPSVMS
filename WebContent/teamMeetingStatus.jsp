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

String status=request.getParameter("status");

String id=request.getParameter("id");

   st= connection.createStatement(); 
  
// int n =st.executeUpdate("insert into question1 select subjectid from subject where subjectName='"+subjectid+" && insert into question1 values ('"+questionid+"','"+content+"')");
int n =st.executeUpdate("update  student_head_meeting set  status = '"+status+"'  where id='"+id+"'"); 

response.sendRedirect("viewTeamMeeting.jsp");
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