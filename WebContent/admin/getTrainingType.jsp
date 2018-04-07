
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@page import="com.daniel.util.DbUtil"%>
<%@ page import="com.daniel.util.DbUtil.*" %>
<%
Connection connection=DbUtil.getConnection();

%>
<%! 
	Statement getTraingingSt = null;
	ResultSet getTraingingRs = null; 
 %>
 <%try{%> 
<%
	String training = request.getParameter("teams");

	getTraingingSt = connection.createStatement(); 

	String query = "select * from training_type where id="+training;
	getTraingingRs = getTraingingSt.executeQuery(query);
 
	if(getTraingingRs.next())
  	{
		out.println("<training>");
		out.println("<trainingId>"+getTraingingRs.getInt(1)+"</trainingId>");
		out.println("<trainingName>"+getTraingingRs.getString(2)+"</trainingName>");
		 
		out.println("</training>");
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
        	if(getTraingingRs!=null)
				try {
					getTraingingRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	if(getTraingingSt!=null)
				try {
					getTraingingSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 
        	}
        
         
        %>
       