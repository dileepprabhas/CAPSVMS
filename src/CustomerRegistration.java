

import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.daniel.util.DbUtil;
import java.sql.*;
import javax.sql.*;
import java.util.regex.*;  

@WebServlet("/CustomerRegistration")
@MultipartConfig
public class CustomerRegistration extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	private static Connection connection;
	  
	public  CustomerRegistration()
	{
		connection = DbUtil.getConnection();
	}
	
	public void  doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
  
        PreparedStatement CustomerPs=null;
        ResultSet checkLastUserRs =null;
        Statement checkLastUserSt  =null;
         
   try {      	 
        
        String checkLastUserQ = "select max(id)+1 as maxCustId  from customer";
        checkLastUserSt = connection.createStatement();
	    String customerId=null;
		HttpSession session = request.getSession();
		checkLastUserRs = checkLastUserSt.executeQuery(checkLastUserQ);
	  	if(checkLastUserRs.next())
	  	{	 
	  		customerId = checkLastUserRs.getString("maxCustId");
	  		session.setAttribute("customerId", customerId);
	  		request.setAttribute("customerId",customerId);
	  	}
	  	
	  	else 
	  	{ 
	  		customerId = "1";
	  		session.setAttribute("customerId", customerId);
	  		request.setAttribute("customerId",customerId);
	  	}
	  	if(customerId!=null){    
	  		 
	  		String Username=request.getParameter("username");
	  		String Password=request.getParameter("password");
	  		String Email=request.getParameter("email");
	  		String Name=request.getParameter("username");/*
	  		int Phone= Integer.parseInt(request.getParameter("phone")); */
  		 
	  		CustomerPs = connection.prepareStatement("INSERT INTO customer (id,name,email,password) values (?,?,?,?)");
 
	  		synchronized (CustomerPs) {
	  			
				CustomerPs.setString(1, customerId);
				CustomerPs.setString(2, Username);
				CustomerPs.setString(3, Email); 
				CustomerPs.setString(4, Password ); 
	/*			CustomerPs.setInt(5, Phone);  */
				CustomerPs.executeUpdate();			 
			   /* javax.servlet.RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp?msg=registered");
			    dispatcher.forward(request, response); */
			    response.sendRedirect("index.jsp");
		  }
 
	  	}
	  	else
	  	{
	  		customerId = "1";
	  		session.setAttribute("customerId", customerId);
	  		request.setAttribute("customerId",customerId);
	  		
	  		String Username=request.getParameter("username");
	  		String Password=request.getParameter("password");
	  		String Email=request.getParameter("email");
	  		String Name=request.getParameter("username");
	  		/*int Phone= Integer.parseInt(request.getParameter("phone")); */
  		 
	  		CustomerPs = connection.prepareStatement("INSERT INTO customer (id,name,email,password) values (?,?,?,?)");
 
	  		synchronized (CustomerPs) {
	  			
				CustomerPs.setString(1, customerId);
				CustomerPs.setString(2, Username);
				CustomerPs.setString(3, Email); 
				CustomerPs.setString(4, Password );
				/*CustomerPs.setInt(5, Phone); */  
				CustomerPs.executeUpdate();			 
			    javax.servlet.RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp?msg=registered");
			    dispatcher.forward(request, response); 
			    
		  }
	  	}
   	} catch(SQLException se){  		
            se.printStackTrace();
   			}         
     	catch (NullPointerException e) {
      	   e.printStackTrace();
      	  	}
     	catch(Exception e){
            e.printStackTrace();
         	}
        finally{        	 
			if(CustomerPs!=null)
				try {
					CustomerPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(checkLastUserRs!=null)
				try {
					checkLastUserRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(checkLastUserSt!=null)
				try {
					checkLastUserSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
        	} 
        out.close();
    } 
}
