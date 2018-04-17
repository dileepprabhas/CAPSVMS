<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@page import="com.daniel.util.DbUtil"%>
<%@ page import="com.daniel.util.DbUtil.*" %>
<%
Connection connection=DbUtil.getConnection();

%>
  <%! 
     PreparedStatement st =null;
     
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
 String status = "Updated";

String id=request.getParameter("id");

    
  int n=0;
// int n =st.executeUpdate("insert into question1 select subjectid from subject where subjectName='"+subjectid+" && insert into question1 values ('"+questionid+"','"+content+"')");

 st = connection.prepareStatement("update  student_head_meeting set      venue=?, meeting_called_by= ?,facilitator = ?,note_taken =?, topics=?,action= ? , discussion=?, status = ? where id='"+id+"'"); 
 st.setString(1, vanue);
 st.setString(2, meet_called_by);
 
 st.setString(3, faci);
 st.setString(4,  note);
 st.setString(5, topic);
 st.setString(6, act);
 st.setString(7, dis_con);
 st.setString(8, status);
 
 
 n= 	st.executeUpdate();
 
 if(n!=0)
{
	response.sendRedirect("viewTeamMeeting.jsp");
}
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