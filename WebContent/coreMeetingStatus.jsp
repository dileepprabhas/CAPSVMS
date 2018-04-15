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

String status=request.getParameter("status");

String id=request.getParameter("id");
 
  
// int n =st.executeUpdate("insert into question1 select subjectid from subject where subjectName='"+subjectid+" && insert into question1 values ('"+questionid+"','"+content+"')");
int n=0;
st = connection.prepareStatement("update  sub_admin_minutes_meeting set  status = ?  where id='"+id+"'");
st.setString(1, status);
n=st.executeUpdate(); 


 
  if(n!=0  )
{

response.sendRedirect("viewCoreMeeting.jsp");
 
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