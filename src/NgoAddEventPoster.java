

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daniel.util.DbUtil;
import com.daniel.util.DbUtil.*; 

import java.io.*;
import java.sql.*; 
import java.util.zip.*;

/**
 * Servlet implementation class UploadProductPicture
 */
@WebServlet("/NgoAddEventPoster")
public class NgoAddEventPoster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection connection;
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public NgoAddEventPoster() {
        super();
        connection = DbUtil.getConnection();
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

		
		String dId = request.getParameter("id");
		 
		String saveFile="";
	    String contentType = request.getContentType();
	    if((contentType != null)&&(contentType.indexOf("multipart/form-data") >= 0)){
	    DataInputStream in = new DataInputStream(request.getInputStream());
	    int formDataLength = request.getContentLength();
	    byte dataBytes[] = new byte[formDataLength];
	    int byteRead = 0;
	    int totalBytesRead = 0;
	    while(totalBytesRead < formDataLength){
	    byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
	    totalBytesRead += byteRead;
	    }
	    String file = new String(dataBytes);
	    saveFile = file.substring(file.indexOf("filename=\"") + 10);
	    saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
	    saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
	    int lastIndex = contentType.lastIndexOf("=");
	    String boundary = contentType.substring(lastIndex + 1,contentType.length());
	    
	    int pos; 
	    pos = file.indexOf("filename=\"");
	    pos = file.indexOf("\n", pos) + 1; 
	    pos = file.indexOf("\n", pos) + 1;
	    pos = file.indexOf("\n", pos) + 1; 
	    String fileName = "";
	    int boundaryLocation = file.indexOf(boundary, pos) - 4;
	    int startPos = ((file.substring(0, pos)).getBytes()).length;
	    int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
	     
	    		   for(int i=saveFile.length()-1; i>=0; i--) { 	    			 
	    			 if(saveFile.charAt(i) == '.' ) {
	    				 fileName = "event_"+dId+saveFile.substring(i, saveFile.length()).toString();
	    				  
	    				break; 
		    		 }
	    		 }  
	    File ff = new File("D:/6BCA/project/Git Repository/sarv_hitkari/WebContent/images/"+saveFile);
	     if(ff.exists())
	    {
	    	File filename= new File("D:/6BCA/project/Git Repository/sarv_hitkari/WebContent/images/"+fileName);
	    	ff.renameTo(filename);
	    	FileOutputStream fileOut = new FileOutputStream(ff); 
		    fileOut.write(dataBytes, startPos, (endPos - startPos));
		    fileOut.flush();
		    fileOut.close(); 
	    }
	    if(!ff.exists())
	    { 
	    	FileOutputStream fileOut = new FileOutputStream(ff); 
		    fileOut.write(dataBytes, startPos, (endPos - startPos));
		    fileOut.flush();
		    fileOut.close(); 
	    } 
	    /*FileOutputStream fileOut = new FileOutputStream(ff); 
	    fileOut.write(dataBytes, startPos, (endPos - startPos));
	    fileOut.flush();
	    fileOut.close(); */
	    
	    try{
	        PreparedStatement updatePicturePs = null;
	        updatePicturePs = connection.prepareStatement("update event_details set poster =? where id="+dId);
	        updatePicturePs.setString(1, fileName);
	       int s = updatePicturePs.executeUpdate();
	       
	       if(s>0){
		    	   response.sendRedirect("index.jsp");
	       	} 
	    }  catch (Exception e){
	    
	    }
	    }
		
		

		
	}

}
