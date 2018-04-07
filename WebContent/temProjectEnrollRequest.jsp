<%@ page import="java.sql.*" %> 
<%@ page import ="javax.sql.*" %>
<%@page import="com.daniel.util.DbUtil"%>
<%@ page import="com.daniel.util.DbUtil.*" %>
<%
Connection connection=DbUtil.getConnection();

%>
  <%! 
  PreparedStatement ps=null; 
 %>   
         <%try{%> 
<%


String volunteerId=(String)session.getAttribute("volunteerId"); 
if(volunteerId==null){ 
	response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
}
String projectId=request.getParameter("projectId");
 
  String query ="INSERT INTO team_project_enrollment (volunteer_registrationg_id,team_project_id) values (?,?)";
 ps = connection.prepareStatement(query);

ps.setString(1,volunteerId );
ps.setString(2, projectId); 


int i = ps.executeUpdate();
if (i > 0)
{
response.sendRedirect("viewTeamProject.jsp");
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
        	if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	 
        	} 
        %>


