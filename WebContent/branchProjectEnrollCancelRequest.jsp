<%@ page import="java.sql.*" %> 
<%@ page import ="javax.sql.*" %>
<%@page import="com.daniel.util.DbUtil"%>
<%@ page import="com.daniel.util.DbUtil.*" %>
<%
Connection connection=DbUtil.getConnection();

%>
  <%! 
  PreparedStatement ps=null; 
  Statement st= null; 
  ResultSet rs = null; 
  
 %>   
         <%try{%> 
<%


String volunteerId=(String)session.getAttribute("volunteerId"); 
if(volunteerId==null)
{
	if(volunteerId==null){ 
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
}
String projectId=request.getParameter("projectId");
 String q1="";
String query ="select id from branch_project_enrollment where volunteer_registration_id = '"+volunteerId+"' and branch_project_id='"+projectId+"'";
st = connection.createStatement();
rs = st.executeQuery(query);
if(rs.next()){
	q1= "delete from branch_project_enrollment where id='"+rs.getString(1)+"'";
	ps = connection.prepareStatement(q1);

	 
}
 
 ps.executeUpdate();
 
 
response.sendRedirect("viewBranchProject.jsp");
  
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
        	if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	if(st!=null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	} 
        %>
 