
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daniel.util.DbUtil;

public class VolunteerLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connection;

	public   VolunteerLogin()
	{
		connection = DbUtil.getConnection();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  
		java.sql.Statement volunteerLoginSt = null; 
        java.sql.ResultSet volunteerLoginRs = null;  
        PrintWriter out  = response.getWriter();

	try	{ 
			String username = request.getParameter("email");
			String password = request.getParameter("password");
			  
			volunteerLoginSt = connection.createStatement();			
			volunteerLoginRs = volunteerLoginSt.executeQuery("select * from volunteer_registration where email_id='"+username+"' and password='"+password+"' and approve_status='Approved'");
			if (volunteerLoginRs.next()) {	
				String volunteerId=volunteerLoginRs.getString("id");  
				HttpSession session = request.getSession(); 
				session.setAttribute("volunteerId", volunteerId); 
				response.sendRedirect("volunteerIndex.jsp");  
			}
			else
			{
				response.sendRedirect("volunteerLogin.jsp?action=UserNotValid"); 
			}
		}
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
		if(volunteerLoginSt!=null)
			try {
				volunteerLoginSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(volunteerLoginRs!=null)
			try {
				volunteerLoginRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
   	} 
}
	 

}