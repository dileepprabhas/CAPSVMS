import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

@WebServlet(name = "MentorEditDetails", urlPatterns = {"/MentorEditDetails"})
@MultipartConfig
public class MentorEditDetails extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static Connection connection;

    public  MentorEditDetails()
    {
        connection = DbUtil.getConnection();
    }

    public void  doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        java.sql.PreparedStatement ps;
        ps=null;

        try {

            HttpSession session = request.getSession();

            String volunteerId=(String)session.getAttribute("adminId");

            
            Part pcurrent_conact = request.getPart("current_conact");

 

            Scanner scanner2  = new Scanner( pcurrent_conact.getInputStream());
            String current_conact = scanner2.nextLine();
            
            scanner2.close();

            Part photo =  request.getPart("playerphoto");

            
            if (current_conact != "" || current_conact != null)
            {
                ps = connection
                        .prepareStatement("update admin set phone=? where id='"+volunteerId+"'");
                synchronized (ps) {

                    ps.setString(1, current_conact);
                    ps.executeUpdate();

                }
            }

            if (photo.getSize() != 0)
            {
                ps = connection.prepareStatement("update admin set photo=? where id='"+volunteerId+"'");
                synchronized (ps) {

                    ps.setBinaryStream(1, photo.getInputStream(), (int)  photo.getSize());
                    ps.executeUpdate();

                }
            }

            response.sendRedirect("mentorIndex.jsp");

           

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

            if(ps!=null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

        }


        out.close();

    }

}
