<%@ page import="java.sql.*" %>
        <%@page import="java.lang.reflect.Array"%>
        <%@ page import ="javax.sql.*" %>
        <%@page import="com.daniel.util.DbUtil"%>
        <%@ page import="com.daniel.util.DbUtil.*" %>

        <%@ page import ="java.text.SimpleDateFormat "  %>
        <%@page import ="java.util.Date"  %>
        <%
            Connection connection=DbUtil.getConnection();

        %>
        <%!
            java.sql.Statement st = null;
        %>
        <%try{%>
        <%
            String comment =request.getParameter("comment");
            String id =request.getParameter("id");
            String reg_no=(String)session.getAttribute("regid");
            String admin_id=(String)session.getAttribute("admin_id");
            if(reg_no!=null) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                st = connection.createStatement();

// int n =st.executeUpdate("insert into question1 select subjectid from subject where subjectName='"+subjectid+" && insert into question1 values ('"+questionid+"','"+content+"')");
                int n = st.executeUpdate("insert into vms_experience_comment (comment,reg_id,vms_experince_id,comment_time) values ('" + comment + "','" + reg_no + "','" + id + "',  '" + formatter.format(date) + "' )");
                response.sendRedirect("admin_vms_experience_feedback.jsp");
            }


            else if(admin_id!=null) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                st = connection.createStatement();

// int n =st.executeUpdate("insert into question1 select subjectid from subject where subjectName='"+subjectid+" && insert into question1 values ('"+questionid+"','"+content+"')");
                int n = st.executeUpdate("insert into vms_experience_comment (comment,admin_id,vms_experince_id,comment_time) values ('" + comment + "','" + admin_id + "','" + id + "',  '" + formatter.format(date) + "' )");



                String admin_type = (String)session.getAttribute("admin_type");

                if (admin_type.equals("Admin")) {
                    response.sendRedirect("admin_vms_experience_feedback.jsp");
                }
                else if (admin_type.equals("Sub-Admin"))
                {
                    response.sendRedirect("vms_experience_request_view.jsp");
                }
            }
        %>

   <%
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
            if(st!=null)
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

        }


        %></title>
</head>
<body>
