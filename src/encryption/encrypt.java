package encryption;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.ServletContext;
import java.util.Random;
/**
 * Servlet implementation class encrypt
 */
@WebServlet("/encrypt")
public class encrypt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public encrypt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	public String service( HttpServletRequest request, HttpServletResponse response, String Id,String value,String letter,String length) throws ServletException, IOException {
	 
	 
		int encryptM=0,encryptR=0,actualValue=0;
		String enId=null;
		try
		{ 
			  encryptM=	Integer.parseInt(Id) % Integer.parseInt(value);
			  encryptR=	Integer.parseInt(Id) / Integer.parseInt(value);
			  actualValue =  (Integer.parseInt(value) * encryptR) +encryptM ;
			   
			    Random r = new Random();
			    String str ="";
			   
			    for (int i = 0; i < Integer.parseInt(length); i++) {
			    	  str = str+(letter.charAt(r.nextInt(letter.length())));
			     }
			    int idLenght = Id.length();
			    
			    for(int i=0; i<6;i++) {
			      	  enId = encryptM+str+encryptR;
			    }
		}catch(Exception e)	{
		 
		}
		return  enId;
		 
	
		
	}
 	
 	public   int decryption(HttpServletRequest request, HttpServletResponse response, String Id,String value   )throws ServletException, IOException { 
		
 		 char character1,character2;
		  int l=0,j=0,num1=0;
		  String a ="",b="";
		  for( int i=0;i<Id.length();i++)
		  {
			   character1 = Id.charAt(i);
			  if(Character.isDigit(character1)) {
				  a = a+character1;
				   
			    }
			  else
			  {
				  j=i;
				  break; 
			  }
		  }
		 
		   for( int k =j;k<Id.length();k++)
		  {
			  character2 = Id.charAt(k);
			  if(Character.isDigit(character2)) {
				 b= b+character2;
			    }
			  
		  }
		  int id = Integer.parseInt(value)*Integer.parseInt(b)  +Integer.parseInt(a);	 
	 
 	return id;
	
 	}
}
