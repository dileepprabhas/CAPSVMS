
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

public class VolunteerPreLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connection;

	public   VolunteerPreLogin()
	{
	connection = DbUtil.getConnection();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			java.sql.Statement volunteerPreLoginSt = null; 
	        java.sql.ResultSet volunteerPreLoginRs = null;  
	        PrintWriter out  = response.getWriter();
    
		try	{ 
			if(connection == null) {
			      connection = DbUtil.getConnection();
			      } 
				String username = request.getParameter("email");
				String password = request.getParameter("password");
				  
				volunteerPreLoginSt = connection.createStatement();			
				volunteerPreLoginRs = volunteerPreLoginSt.executeQuery("select * from volunteer_registration where email_id='"+username+"' and password='"+password+"'");
				if (volunteerPreLoginRs.next())	
					
				{	
					String volunteerId=volunteerPreLoginRs.getString("id"); 
					
					HttpSession session = request.getSession(); 
					session.setAttribute("volunteerId", volunteerId); 
					response.sendRedirect("volunteerPreIndex.jsp");  
				}
				else
				{
					response.sendRedirect("volunteerPreLogin.jsp?action=UserNotValid"); 
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
			if(volunteerPreLoginSt!=null)
				try {
					volunteerPreLoginSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(volunteerPreLoginRs!=null)
				try {
					volunteerPreLoginRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} 
       	} 
     
    
}

}