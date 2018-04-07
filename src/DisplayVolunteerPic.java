
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daniel.util.DbUtil;
@WebServlet(name = "DisplayVolunteerPic", urlPatterns = {"/DisplayVolunteerPic"})
public class DisplayVolunteerPic extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connection;

	public   DisplayVolunteerPic()
	{
	connection = DbUtil.getConnection();
	}
	
	@Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		
		 java.sql.PreparedStatement ps;
	        ps=null;
	        
        try {
              ps = connection.prepareStatement("select photo from volunteer_registration where id = ?");
            String name = request.getParameter("name");
            ps.setString(1,name );
            ResultSet rs = ps.executeQuery();
            rs.next();
            Blob b = rs.getBlob("photo");
            response.setContentType("image/jpeg");
            response.setContentLength((int) b.length());
            InputStream is = b.getBinaryStream();
            OutputStream os = response.getOutputStream();
            byte buf[] = new byte[(int) b.length()];
            is.read(buf);
            os.write(buf);
            os.close();
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
        	 
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	
        	
        
        	}

        
    }

}
