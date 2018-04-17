package com.daniel.util.control;
import java.sql.ResultSet;
import java.sql.Array;
import java.sql.Connection; 
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;   
import java.text.DateFormat; 
import java.text.SimpleDateFormat;
import java.awt.List;
import java.util.Date;

import com.daniel.util.DbUtil;
import com.sun.mail.iap.Response;
import com.sun.xml.internal.ws.wsdl.parser.MexEntityResolver;

import encryption.encrypt;

import java.sql.*;
import encryption.*;
/*import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
import java.io.*;
import java.util.*;
import  javax.mail.*;
  import javax.mail.internet.*;
  import javax.activation.*;
 import javax.servlet.http.*;  

import javax.servlet.*;
  import java.sql.*;
  import com.daniel.util.DbUtil;
  import com.daniel.util.DbUtil.*; 

 
/**
 * Servlet implementation class Control
// */ 
@WebServlet(name = "Control", urlPatterns = {"/Control"}) 
@MultipartConfig

public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection connection;
	public static final int MYSQL_DUPLICATE_PK = 1062;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        connection = DbUtil.getConnection();
        // TODO Auto-generated constructor stub
    } 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
		HttpSession session = request.getSession();
		String action= request.getParameter("action");
		 
		  if(action.equals("addTeam"))
		{   
			addTeam(request,response); 
		}
		else if(action.equals("addBranch"))
		{   
			addBranch(request,response); 
		}
		else if(action.equals("addMeeting"))
		{   
			addMeeting(request,response); 
		}
		else if(action.equals("addTraining"))
		{   
			addTrainingType(request,response); 
		}
		else if(action.equals("addAcademicSkills"))
		{   
			addAcademicSkills(request,response); 
		}
		else if(action.equals("addLifeSkills"))
		{   
			addLifeSkills(request,response); 
		}
		else if(action.equals("addSoftSkills"))
		{   
			addSoftSkills(request,response); 
		}
		else if(action.equals("addProfessionalSkills"))
		{   
			addProfessionalSkills(request,response); 
		}
		else if(action.equals("addInterViewSlot"))
		{   
			addInterViewSlot(request,response); 
		}
		else if(action.equals("addVolunteerRegistration"))
		{   
			volunteerRegistration(request,response); 
		}
		else if(action.equals("volunteerChooseSkills"))
		{   
			volunteerChooseSkills(request,response); 
		}
		else if(action.equals("volunteerApproval"))
		{   
			volunteerApproval(request,response);
		}
		else if(action.equals("assignTeam"))
		{   
			assignTeam(request,response);
		}
		else if(action.equals("createMentor"))
		{   
			createMentor(request,response);
		}
		else if(action.equals("mentorVarification"))
		{   
			mentorVarification(request,response);
		}
		else if(action.equals("otpVerification"))
		{   
			otpVerification(request,response);
		}
		else if(action.equals("assignIndividualProject"))
		{   
			assignIndividualProject(request,response);
		}
		else if(action.equals("createTeamProject"))
		{   
			createTeamProject(request, response); 
		}
		else if(action.equals("assignTeamProject"))
		{   
			assignTeamProject(request, response);
		}
		else if(action.equals("createBranchProject"))
		{   
			createBranchProject(request, response);
		}
		else if(action.equals("assignBranchProject"))
		{   
			assignBranchProject(request, response);
		}
		else if(action.equals("submitWorkDiary"))
		{   
			submitWorkDiary(request, response);
		}
		else if(action.equals("submitWorkDiaryForProjects"))
		{   
			submitWorkDiaryForProject(request, response);
		}
		else if(action.equals("submitMeeting"))
		{   
			submitMeeting(request, response);
		} 
		else if(action.equals("submitTraining"))
		{   
			submitTraining(request, response);
		}
		else if(action.equals("monthWorkDiray"))
		{   
			monthWorkDiray(request, response);
		}
		else if(action.equals("addGrievance"))
		{   
			addGrievance(request, response);
		}
		else if(action.equals("submitGrievance"))
		{   
			submitGrievance(request, response);
		}
		else if(action.equals("addVmsExperienceCategory"))
		{   
			addVmsExperienceCategory(request, response);
		}
		else if(action.equals("submitVmsExperience"))
		{   
			submitVmsExperience(request, response);
		}
		else if(action.equals("addVmsExperienceComment"))
		{   
			addVmsExperienceComment(request, response);
		}
		else if(action.equals("addWorkDiaryComment"))
		{   
			addWorkDiaryComment(request, response);
		}
		else if(action.equals("addWorkMeetingComment"))
		{   
			addWorkMeetingComment(request, response);
		}
		else if(action.equals("addWorkTrainingComment"))
		{   
			addWorkTrainingComment(request, response);
		}
		else if(action.equals("branchProjectApproval"))
		{   
			branchProjectApproval(request, response);
		}
		else if(action.equals("teamProjectApproval"))
		{   
			teamProjectApproval(request, response);
		}
		else if(action.equals("mentorVmsExperience"))
		{   
			mentorVmsExperience(request, response);
		}
		else if(action.equals("addMentorVmsExperienceComment"))
		{   
			addMentorVmsExperienceComment(request, response);
		}
		else if(action.equals("gradeMonthlyReport"))
		{   
			gradeMonthlyReport(request, response);
		}
		else if(action.equals("adminForgotPassword"))
		{   
			adminForgotPassword(request,response);
		}
		else if(action.equals("mentorForgotPassword"))
		{   
			mentorForgotPassword(request,response);
		}
		else if(action.equals("adminforgotOtpVerification"))
		{   
			adminforgotOtpVerification(request,response);
		}
		else if(action.equals("forgotOtpVerification"))
		{   
			forgotOtpVerification(request,response);
		}
		else if(action.equals("volunteerForgotPassword"))
		{   
			volunteerForgotPassword(request,response);
		}
		else if(action.equals("volunteerForgotOtpVerification"))
		{   
			volunteerForgotOtpVerification(request,response);
		}
		else if(action.equals("preVolunteerForgotPassword"))
		{   
			preVolunteerForgotPassword(request,response);
		}
		else if(action.equals("preVolunteerForgotOtpVerification"))
		{   
			preVolunteerForgotOtpVerification(request,response);
		}
		else if(action.equals("addFaqDetails"))
		{   
			addFaqDetails(request,response); 
		}
		else if(action.equals("addContactDetails"))
		{   
			addContactDetails(request,response); 
		}
		else if(action.equals("commonNotification"))
		{   
			commonNotification(request,response); 
		}
		else if(action.equals("TeamNewsNotification"))
		{   
			teamNewsNotification(request,response); 
		}
		else if(action.equals("updateMentorTeams"))
		{   
			updateMentorTeams(request,response); 
		}
		else if(action.equals("addDesignations"))
		{   
			addDesignations(request,response); 
		}
		else if(action.equals("assignDesignation"))
		{   
			assignDesignation(request,response); 
		}
		else if(action.equals("updateMentorDesignation"))
		{   
			updateMentorDesignation(request,response); 
		}
		else if(action.equals("submitCoreMeeting"))
		{   
			submitCoreMeeting(request,response); 
		}
		else if(action.equals("submitStudentHeadMeeting"))
		{   
			submitStudentHeadMeeting(request,response); 
		}
		  
		  
	}
	private void addTeam( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		String team = request.getParameter("teamName");
		Statement checkTeamSt = null;
		ResultSet checkTeamRs = null;
		 
		try {
			 	checkTeamSt = connection.createStatement();
			 	String checkQ = "select team_name from teams where team_name ='"+team+"'";
			 	checkTeamRs = checkTeamSt.executeQuery(checkQ);
				
				 if (checkTeamRs.next())	{
					 response.sendRedirect("admin/index.jsp?action=TeamExist");
				 }
				 else   {  
					PreparedStatement addCategoryPs =null;
					String query = "insert into teams (team_name) values(?)" ;
					addCategoryPs  =  connection.prepareStatement(query);
					addCategoryPs.setString(1, team); 
					addCategoryPs.executeUpdate();	
					response.sendRedirect("admin/index.jsp?action=TeamAdded");
	  
	 				  } 
			}  
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			 
		 }
		}
		else{
			response.sendRedirect("../adminLogin?action=LoginAgain");
		}
		 out.close(); 
		 
	}

private void addMeeting( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		String meetingType = request.getParameter("meetingType");
		Statement meetingTypeSt = null;
		ResultSet meetingTypeRs = null;
		 
		try {
				meetingTypeSt = connection.createStatement();
				String checkQ ="select meeting_type from meeting_type where meeting_type ='"+meetingType+"'";
				meetingTypeRs = meetingTypeSt.executeQuery(checkQ);
				
				 if (meetingTypeRs.next())	{
					 response.sendRedirect("admin/index.jsp?action=MeetingTypeExist");
				 }
				 else   {  
					PreparedStatement addCategoryPs =null;
					String query = "insert into meeting_type (meeting_type) values(?)";
					addCategoryPs  =  connection.prepareStatement(query);
					addCategoryPs.setString(1, meetingType); 
					addCategoryPs.executeUpdate();	
					response.sendRedirect("admin/index.jsp?action=MeetingTypeAdded");
	  
	 				  } 
			}  
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace(); 
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			 
		 }
		}
		else{
			response.sendRedirect("../adminLogin.jsp?action=LoginAgain");
		}
		 out.close(); 
		 
	}
public void addFaqDetails( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String faqQuestion = request.getParameter("question");
	String faqAnswer = request.getParameter("answer");
	Statement faqSt = null;
	ResultSet faqRs = null;
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
	 
	try {
		faqSt = connection.createStatement();
		String checkFaqQ = "select question from faq_details where question = '"+faqQuestion+"'";
		faqRs = faqSt.executeQuery(checkFaqQ);
			
		 		if (faqRs.next())	{
		 			response.sendRedirect("admin/index.jsp?action=faqExists");
				 }
				 else   { 
					 PreparedStatement addfaqPs =null;
					 try {
						 String addfaqQ ="insert into faq_details (question,answer) values(?,?)";
						
						 addfaqPs  =  connection.prepareStatement(addfaqQ);
						 addfaqPs.setString(1, faqQuestion); 
						 addfaqPs.setString(2, faqAnswer); 
						 addfaqPs.executeUpdate();	
 						  
						response.sendRedirect("admin/index.jsp?action=FaqAdded");
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ }   
				 catch (SQLException e) {
						// TODO: handle exception
					e.printStackTrace();
					}
				 catch (Exception e) {
						// TODO: handle exception
						 e.printStackTrace();
					} finally {
						if(addfaqPs!=null)  
						  try {
							  addfaqPs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
					 }  
				 }  
	}
			 
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			  if(faqSt!=null)
					try {
						faqSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	        	 if(faqSt!=null)
					try {
						faqSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		 		}
		}
		else
		{
			response.sendRedirect("../adminLogin.jsp?action=LoginAgain");
		}
	 	out.close();  
	}
public void addDesignations( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String designation = request.getParameter("designation"); 
	Statement faqSt = null;
	ResultSet faqRs = null;
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
	 
	try {
		faqSt = connection.createStatement();
		String checkFaqQ = "select designation_name from designations where designation_name = '"+designation+"'";
		faqRs = faqSt.executeQuery(checkFaqQ);
			
		 		if (faqRs.next())	{
		 			response.sendRedirect("admin/index.jsp?action=DesignationExists");
				 }
				 else   { 
					 PreparedStatement addfaqPs =null;
					 try {
						 String addfaqQ ="insert into designations (designation_name) values(?)";
						
						 addfaqPs  =  connection.prepareStatement(addfaqQ);
						 addfaqPs.setString(1, designation); 
						 addfaqPs.executeUpdate();	
 						  
						response.sendRedirect("admin/index.jsp?action=DesignationAdded");
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ }   
				 catch (SQLException e) {
						// TODO: handle exception
					e.printStackTrace();
					}
				 catch (Exception e) {
						// TODO: handle exception
						 e.printStackTrace();
					} finally {
						if(addfaqPs!=null)  
						  try {
							  addfaqPs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
					 }  
				 }  
	}
			 
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			  if(faqSt!=null)
					try {
						faqSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	        	 if(faqSt!=null)
					try {
						faqSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		 		}
		}
		else
		{
			response.sendRedirect("../adminLogin.jsp?action=LoginAgain");
		}
	 	out.close();  
	}
private void addBranch( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		String branchName = request.getParameter("branchName");
		Statement branchNameSt = null;
		ResultSet branchNameRs = null;
		 
		try {
				branchNameSt = connection.createStatement();
				String checkQ ="select name from branch where name ='"+branchName+"'";
				branchNameRs = branchNameSt.executeQuery(checkQ);
				
				 if (branchNameRs.next())	{
					 response.sendRedirect("admin/index.jsp?action=BranchExist");
				 }
				 else   {  
					PreparedStatement addCategoryPs =null;
					String query = "insert into branch (name) values(?)";
					addCategoryPs  =  connection.prepareStatement(query);
					addCategoryPs.setString(1, branchName); 
					addCategoryPs.executeUpdate();	
					response.sendRedirect("admin/index.jsp?action=BranchAdded");
	  
	 				  } 
			}  
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			 
		 }
		}
		else{
			response.sendRedirect("../adminLogin.jsp?action=LoginAgain");
		}
		 out.close(); 
		 
	}
public  ResultSet viewFaq()throws ServletException, IOException { 
	Statement faqSt =null;
	ResultSet faqRs = null;

	try {  				
		faqSt = connection.createStatement();
		String faqQ ="select * from faq_details";
		faqRs = faqSt.executeQuery(faqQ);
	  
		} 
	catch (SQLException e) {
	// TODO: handle exception
		e.printStackTrace();
		}
	catch (Exception e) {
	// TODO: handle exception
		e.printStackTrace();
		}
finally {
	
	/*if(NgoDetailSt!=null)
		try {
			NgoDetailSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	 
}
return faqRs;

}
public  ResultSet viewNews()throws ServletException, IOException { 
	Statement faqSt =null;
	ResultSet faqRs = null;

	try {  				
		faqSt = connection.createStatement();
		String faqQ ="select * from common_notification";
		faqRs = faqSt.executeQuery(faqQ);
	  
		} 
	catch (SQLException e) {
	// TODO: handle exception
		e.printStackTrace();
		}
	catch (Exception e) {
	// TODO: handle exception
		e.printStackTrace();
		}
finally {
	
	/*if(NgoDetailSt!=null)
		try {
			NgoDetailSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	 
}
return faqRs;

}
private void addTrainingType( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String training_type = request.getParameter("trainingType");
	String teamId = request.getParameter("teamId");
	Statement trainingTypeSt = null;
	ResultSet trainingTypeRs = null;
	 
	try {
			trainingTypeSt = connection.createStatement();
			String checkQ ="select training_type from training_type where training_type ='"+training_type+"' and team_id='"+teamId+"'";
			trainingTypeRs = trainingTypeSt.executeQuery(checkQ);
			
			 if (trainingTypeRs.next())	{
				 response.sendRedirect("admin/index.jsp?action=TrainingTypeAlradyExist");
			 }
			 else   {  
				PreparedStatement addCategoryPs =null;
				String query = "insert into training_type (training_type,team_id) values(?,?)";
				addCategoryPs  =  connection.prepareStatement(query);
				addCategoryPs.setString(1, training_type); 
				addCategoryPs.setString(2, teamId); 
				addCategoryPs.executeUpdate();	
				response.sendRedirect("admin/index.jsp?action=TrainingAdded");
  
 				  } 
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
	public   ResultSet getTeams() throws ServletException, IOException { 
		Statement getTeamsSt =null;
		ResultSet getTeamsRs = null;
		  
		try {  				
			getTeamsSt = connection.createStatement();
				String query = "select *   from teams";
				getTeamsRs = getTeamsSt.executeQuery(query);
				 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			/*if(NgoDetailSt!=null)
				try {
					NgoDetailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	    	 
		}
		return getTeamsRs;

	}
	public   ResultSet getBranch() throws ServletException, IOException { 
		Statement getTeamsSt =null;
		ResultSet getTeamsRs = null;
		  
		try {  				
			getTeamsSt = connection.createStatement();
				String query = "select *   from branch";
				getTeamsRs = getTeamsSt.executeQuery(query);
				 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			/*if(NgoDetailSt!=null)
				try {
					NgoDetailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	    	 
		}
		return getTeamsRs;

	}
	public   String getMenorBranch(String id ) throws ServletException, IOException { 
		Statement getTeamsSt =null;
		ResultSet getTeamsRs = null;
		  String branchId = null;
		try {  				
			getTeamsSt = connection.createStatement();
				String query = "select branch_id  from admin where id="+id;
				getTeamsRs = getTeamsSt.executeQuery(query);
				 if(getTeamsRs.next())
				 {
					 branchId = getTeamsRs.getString("branch_id");
				 }
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 if(getTeamsRs!=null)
					try {
						getTeamsRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
		return branchId;

	}
	public   ResultSet getMeetingType() throws ServletException, IOException { 
		Statement meetingTypeSt =null;
		ResultSet meetingTypeRs = null;
		  
		try {  				
			meetingTypeSt = connection.createStatement();
				String query = "select *   from meeting_type";
				meetingTypeRs = meetingTypeSt.executeQuery(query);
				 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			/*if(NgoDetailSt!=null)
				try {
					NgoDetailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	    	 
		}
		return meetingTypeRs;

	}
private void addAcademicSkills( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		String academicSkill = request.getParameter("academicSkill");
		Statement checkAcademicSkillSt = null;
		ResultSet checkAcademicSkillRs = null;
		 
		try {
			checkAcademicSkillSt = connection.createStatement();
			 	String checkQ = "select skill_name from academic_skills where skill_name ='"+academicSkill+"'";
			 	checkAcademicSkillRs = checkAcademicSkillSt.executeQuery(checkQ);
				
			 	if (checkAcademicSkillRs.next()) {
					 response.sendRedirect("admin/index.jsp?action=AcademicSkillExist");
				 }
				 else   {  
							PreparedStatement addCategoryPs =null;
							String query = "insert into academic_skills (skill_name) values(?)";
							addCategoryPs  =  connection.prepareStatement(query);
							addCategoryPs.setString(1, academicSkill); 
							addCategoryPs.executeUpdate();	
							response.sendRedirect("admin/index.jsp?action=NewAcademicSkillAdded"); 
	 				  }  
			}  
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			 
		 }
		}
		else{
			response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
		 out.close(); 
		 
	}
public   ResultSet getApplications(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
			getTeamsSt = connection.createStatement();
				String query = "select *   from volunteer_registration where id ='"+id+"'";
				getTeamsRs = getTeamsSt.executeQuery(query);
				 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			/*if(NgoDetailSt!=null)
				try {
					NgoDetailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	    	 
		}
		}
		else
		{
			 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
	return getTeamsRs;

	}
public   ResultSet getAcademicSkill() throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select *   from academic_skills";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getTeamsRs;

	}
public   ResultSet getDesignations() throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select * from designations";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getTeamsRs;

	}
private void addLifeSkills( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String lifeSkill = request.getParameter("lifeSkill");
	Statement checkLifeSkillSt = null;
	ResultSet checkLifeSkillRs = null;
	 
	try {
		checkLifeSkillSt = connection.createStatement();
		 	String checkQ = "select skill_name from life_skills where skill_name ='"+lifeSkill+"'";
		 	checkLifeSkillRs = checkLifeSkillSt.executeQuery(checkQ);
			
		 	if (checkLifeSkillRs.next()) {
				 response.sendRedirect("admin/index.jsp?action=LifeSkillsExist");
			 }
			 else   {  
						PreparedStatement addCategoryPs =null;
						String query = "insert into life_skills (skill_name) values(?)";
						addCategoryPs  =  connection.prepareStatement(query);
						addCategoryPs.setString(1, lifeSkill); 
						addCategoryPs.executeUpdate();	
						response.sendRedirect("admin/index.jsp?action=NewLifeSkillsAdded"); 
 				  }  
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
public   ResultSet getLifeSkill() throws ServletException, IOException { 
	Statement getLifeSkillSt =null;
	ResultSet getLifeSkillRs = null;
	  
	try {  				
			getLifeSkillSt = connection.createStatement();
			String query = "select *   from life_skills";
			getLifeSkillRs = getLifeSkillSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getLifeSkillRs;

	}
private void addSoftSkills( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String softSkill = request.getParameter("softSkill");
	Statement checkSoftSkillSt = null;
	ResultSet checkSoftSkillRs = null;
	 
	try {
			checkSoftSkillSt = connection.createStatement();
		 	String checkQ = "select skill_name from soft_skills where skill_name ='"+softSkill+"'";
		 	checkSoftSkillRs = checkSoftSkillSt.executeQuery(checkQ);
			
		 	if (checkSoftSkillRs.next()) {
				 response.sendRedirect("admin/index.jsp?action=SoftSkillExist");
			 }
			 else   {  
						PreparedStatement addCategoryPs =null;
						String query = "insert into soft_skills (skill_name) values(?)";
						addCategoryPs  =  connection.prepareStatement(query);
						addCategoryPs.setString(1, softSkill); 
						addCategoryPs.executeUpdate();	
						response.sendRedirect("admin/index.jsp?action=NewSoftSkillAdded"); 
 				  }  
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
public   ResultSet getSoftSkill() throws ServletException, IOException { 
	Statement getSoftSkillSt =null;
	ResultSet getSoftSkilRs = null;
	  
	try {  				
			getSoftSkillSt = connection.createStatement();
			String query = "select *   from soft_skills";
			getSoftSkilRs = getSoftSkillSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getSoftSkilRs;

	}
private void addProfessionalSkills( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String professionalSkill = request.getParameter("professionalSkill");
	Statement checkprofessionalSkillSt = null;
	ResultSet checkprofessionalSkillRs = null;
	 
	try {
			checkprofessionalSkillSt = connection.createStatement();
		 	String checkQ = "select skill_name from professional_skills where skill_name ='"+professionalSkill+"'";
		 	checkprofessionalSkillRs = checkprofessionalSkillSt.executeQuery(checkQ);
			
		 	if (checkprofessionalSkillRs.next()) {
				 response.sendRedirect("admin/index.jsp?action=professionalSkillExist");
			 }
			 else   {  
						PreparedStatement addCategoryPs =null;
						String query = "insert into professional_skills (skill_name) values(?)";
						addCategoryPs  =  connection.prepareStatement(query);
						addCategoryPs.setString(1, professionalSkill); 
						addCategoryPs.executeUpdate();	
						response.sendRedirect("admin/index.jsp?action=newProfessionalSkillAdded"); 
 				  }  
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
public   ResultSet getProfessionalSkill() throws ServletException, IOException { 
	Statement getSoftSkillSt =null;
	ResultSet getSoftSkilRs = null;
	  
	try {  				
			getSoftSkillSt = connection.createStatement();
			String query = "select *   from professional_skills";
			getSoftSkilRs = getSoftSkillSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getSoftSkilRs;

	}
private void addInterViewSlot( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		   String interViewDate = request.getParameter("interViewDate"); 
        String availableSeats = request.getParameter("availableSeats");  
        String slotTime = request.getParameter("slotTime");  
       
        String venue=request.getParameter("venue");
        
		Statement checkinterViewSt = null;
		ResultSet checkinterViewRs = null;
		 
	try {
		checkinterViewSt = connection.createStatement();
		 	String checkQ = "select slotdate from interviewslot where slotdate ='"+interViewDate+"' and inttimefrom='"+slotTime+"'    venue='"+venue+"'";
		 	checkinterViewRs = checkinterViewSt.executeQuery(checkQ);
			
		 	if (checkinterViewRs.next()) {
				 response.sendRedirect("admin/index.jsp?action=InterViewSlotsExist");
			 }
			 else   {   
						PreparedStatement addInterViewSlotPs =null;
						addInterViewSlotPs = connection.prepareStatement("insert into interviewslot (slotdate,availableseats,inttimefrom,venue) values (?,?,?,?)");
						addInterViewSlotPs.setString(1, interViewDate);
						addInterViewSlotPs.setString(2, availableSeats);
						addInterViewSlotPs.setString(3, slotTime);  
			            addInterViewSlotPs.setString(4, venue ); 
			            addInterViewSlotPs.executeUpdate(); 
			             
						response.sendRedirect("admin/index.jsp?action=NewInterViewSlotAdded"); 
 				  }  
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
@SuppressWarnings("resource")
private void volunteerRegistration( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	  
    String email=request.getParameter("email");  
	Statement checkVolunteerSt = null;
	Statement volunteerIdSt = null;
	ResultSet volunteerIdRs = null;
	PreparedStatement addVolunteerps =null;
	try {
			
			volunteerIdSt = connection.createStatement();
			String volunteerId=null;
		 	String checkQ = "select email_id   from volunteer_registration  where email_id ='"+email+"' ";
		 	volunteerIdRs = volunteerIdSt.executeQuery(checkQ);
			
		 	if (volunteerIdRs.next()) {
				 response.sendRedirect("volunteerRegistration.jsp?action=AlreadyRegistered");
			 }
			 else   {    
					 String fullName=request.getParameter("fullName");
					 String phone=request.getParameter("phone");
					 String password=request.getParameter("password"); 
					 String gender=request.getParameter("gender");
					 String whyVolunteer=request.getParameter("whyVolunteer");					 
					 String volunteerIdQ = "select max(id)+1 as maxId from volunteer_registration"; 
					 volunteerIdRs = volunteerIdSt.executeQuery(volunteerIdQ);
			 		if (volunteerIdRs.next())	{
			 			
			 			volunteerId = volunteerIdRs.getString("maxId");			 			  
			 			if(volunteerId == null)
			 			{
			 				volunteerId ="1";
			 			}
			 			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 			Date date = new Date(); 
					
						String 	query = "insert into volunteer_registration (id,volunteer_name,password,contact_num,email_id,why_volunteer,gender,registration_date) values (?,?,?,?,?,?,?,?)";
						addVolunteerps = connection.prepareStatement(query);
						addVolunteerps.setString(1, volunteerId);
						addVolunteerps.setString(2, fullName);
						addVolunteerps.setString(3, password); 
						addVolunteerps.setString(4, phone);  
						addVolunteerps.setString(5, email);
						addVolunteerps.setString(6, whyVolunteer);  
						addVolunteerps.setString(7, gender);
						addVolunteerps.setString(8,  dateFormat.format(date));
						addVolunteerps.executeUpdate();  
						session.setAttribute("volunteerId", volunteerId);
						request.setAttribute("volunteerId",volunteerId);
						response.sendRedirect("volunteerChooseSkill.jsp"); 
				  }
			 }
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		  if(volunteerIdSt!=null)
			try {
				volunteerIdSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  if(volunteerIdRs!=null)
				try {
					volunteerIdRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		  if(checkVolunteerSt!=null)
				try {
					checkVolunteerSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		  if(addVolunteerps!=null)
				try {
					addVolunteerps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
 	 
	 }
	 
	 out.close(); 
	 
}
public   ResultSet getInterViewSlot() throws ServletException, IOException { 
	Statement interViewSt =null;
	ResultSet interViewRs = null;
	  
	try {  				
			interViewSt = connection.createStatement();
			String query = "select *   from interviewslot";
			interViewRs = interViewSt.executeQuery(query);  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return interViewRs;

	}
private void volunteerChooseSkills( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		String skills="";
		String lang[]=request.getParameterValues("skills");
		if(lang.length == 0)
		{
			response.sendRedirect("volunteerChooseSkill.jsp?action=volunteerChooseSkills"); 
 			
		}
		else if(lang.length!=0) {
			for(int i=0;i<lang.length;i++){
				skills+=lang[i]+" , ";
			}
		}
		/*
		String lang1[]=request.getParameterValues("lifeSkill");
		if(lang1.length!=0) {
			for(int i=0;i<lang1.length;i++){
				skills+=lang1[i]+" , ";
			}
		}*/
		/*String lang2[]=request.getParameterValues("skills");
		if(lang2.length!=0) {
			for(int i=0;i<lang2.length;i++){
				skills+=lang2[i]+" , ";
			}
		}*/
		/*String lang3[]=request.getParameterValues("professinalSkill");
		if(lang3.length!=0) {
			for(int i=0;i<lang3.length;i++){
				skills+=lang3[i]+" , ";
			}
		}*/
		skills = skills.substring(0,skills.length()-2);
		String addi_skill = request.getParameter("additionalSkills");
		String background = request.getParameter("background");
  
		try {   
				PreparedStatement addCategoryPs =null;
				String query = "update volunteer_registration set skills = ?, addi_skills=?,backgrounds_achivements=? where id = "+volunteerId;
				addCategoryPs  =  connection.prepareStatement(query);
				addCategoryPs.setString(1, skills); 
				addCategoryPs.setString(2, addi_skill); 
				addCategoryPs.setString(3, background); 
				addCategoryPs.executeUpdate();	
				response.sendRedirect("volunteerPreIndex.jsp?action=SuccessfullyRegistered"); 
	 				    
			}  
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			 
		 }
	}
	else{
		response.sendRedirect("volunteerRegistration.jsp.jsp?action=SessionExpires");//send redirect to Volunteer Registration
	}
	 out.close(); 
	 
}


public   String getVolunteerApplicationStatus(String id) throws ServletException, IOException { 
	Statement getStatusSt =null;
	ResultSet getStatusRs = null;
	  String status =null;
	try {  				
		getStatusSt = connection.createStatement();
			String query = "select approve_status   from volunteer_registration where id = "+id;
			getStatusRs = getStatusSt.executeQuery(query);
			 if(getStatusRs.next())
			 {
				 status = getStatusRs.getString("approve_status");
			 }
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return status; 
}
public   String getVolunteerName(String id) throws ServletException, IOException { 
	Statement getStatusSt =null;
	ResultSet getStatusRs = null;
	  String name =null;
	try {  				
		getStatusSt = connection.createStatement();
			String query = "select volunteer_name   from volunteer_registration where id = "+id;
			getStatusRs = getStatusSt.executeQuery(query);
			 if(getStatusRs.next())
			 {
				 name = getStatusRs.getString("volunteer_name");
			 }
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		  if(getStatusSt!=null)
			try {
				getStatusSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  if(getStatusRs!=null)
				try {
					getStatusRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
    	 
	}
	return name;

}
public   String getMentorName(String id) throws ServletException, IOException { 
	Statement getStatusSt =null;
	ResultSet getStatusRs = null;
	  String name =null;
	try {  				
		getStatusSt = connection.createStatement();
			String query = "select name   from admin where id = "+id;
			getStatusRs = getStatusSt.executeQuery(query);
			 if(getStatusRs.next())
			 {
				 name = getStatusRs.getString("name");
			 }
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		  if(getStatusSt!=null)
			try {
				getStatusSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  if(getStatusRs!=null)
				try {
					getStatusRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
    	 
	}
	return name;

}

public   int getWorkDiaryCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId!= null) {
		try {  				
				volunteerCountSt = connection.createStatement();
				 
				volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from workdiary where volunteer_registration_id ='"+volunteerId+"' ");
			
				if(volunteerCountRs.next())
				{
					totalCount = Integer.parseInt(volunteerCountRs.getString(1));
				}
			  
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
			}
	}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
return totalCount; 
}

public   int getVolunteerProjectCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId!= null) {
		try {  				
				volunteerCountSt = connection.createStatement();
				 
				volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from assign_projects where bproject_id is null and team_project_id is null and  volunteer_registration_id ='"+volunteerId+"' ");
			
				if(volunteerCountRs.next())
				{
					totalCount = Integer.parseInt(volunteerCountRs.getString(1));
				}
			  
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
			}
	}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
return totalCount; 
}

public   int getVolunteerTeamProjectCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId!= null) {
		try {  				
				volunteerCountSt = connection.createStatement();
				 
				volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from assign_projects where bproject_id is null and team_project_id is not null and  volunteer_registration_id ='"+volunteerId+"' ");
			
				if(volunteerCountRs.next())
				{
					totalCount = Integer.parseInt(volunteerCountRs.getString(1));
				}
			  
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
			}
	}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
return totalCount; 
}
public   ResultSet getCoreMeeting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 

	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId!= null) {
		
		try {
			Control ct= new Control();
	
  		 	if(ct.getAdminType( adminId).equals("Branch Co-ordinator")) { 
  		 		String branchId = ct.getMentorBranch(adminId);
  		 		volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select * from sub_admin_minutes_meeting inner join admin on sub_admin_minutes_meeting.admin_id = admin.id   where admin.branch_id = '"+branchId+"' order by sub_admin_minutes_meeting.id desc ");
  		 	 
  		 	}else if(ct.getAdminType( adminId).equals("Co-ordinator")) {  
  		 		volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select * from sub_admin_minutes_meeting inner join admin on sub_admin_minutes_meeting.admin_id = admin.id   order by sub_admin_minutes_meeting.id desc ");
  		 	 
  		 	}
  		 	else if(ct.getAdminType( adminId).equals("Branch Meeting Reviewer")) {  
  		 		
  	  			String team = ct.getMentorTeams(adminId);
	  		 	String s = "";
	  		 	String[] charArray = team.split(" , ");
	  		 	for(int i=0;i<charArray.length ;i++)
		  	     {
		  	    	 s=s+"'"+charArray[i]+"'";
		  	    	 if(i<(charArray.length)-1)
		  	    	 {
		  	    		s=s+" , " ;
		  	    	 }
		  	     }
	  			volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select * from sub_admin_minutes_meeting inner join admin on sub_admin_minutes_meeting.admin_id =  admin.id  order by sub_admin_minutes_meeting.id desc ");
  		 	 
  		 	}else if(ct.getAdminType( adminId).equals("Mentor")) {
  		 	
  		 	String team = ct.getMentorTeams(adminId);
  		 	String s = "";
  		 	String[] charArray = team.split(" , ");
  		 	for(int i=0;i<charArray.length ;i++)
	  	     {
	  	    	 s=s+"'"+charArray[i]+"'";
	  	    	 if(i<(charArray.length)-1)
	  	    	 {
	  	    		s=s+" , " ;
	  	    	 }
	  	     }
  		 	volunteerCountSt = connection.createStatement();
			volunteerCountRs = volunteerCountSt.executeQuery("select * from sub_admin_minutes_meeting inner join admin on sub_admin_minutes_meeting.admin_id = admin.id     order by sub_admin_minutes_meeting.id desc ");
		 	}   
  		 		
				
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				/* if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
	}
	else
	{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
	}
return volunteerCountRs; 
}
public   int getVolunteerBranchProjectCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId!= null) {
		try {  				
				volunteerCountSt = connection.createStatement();
				 
				volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from assign_projects where bproject_id is not null and team_project_id is null and  volunteer_registration_id ='"+volunteerId+"' ");
			
				if(volunteerCountRs.next())
				{
					totalCount = Integer.parseInt(volunteerCountRs.getString(1));
				}
			  
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
			}
	}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
return totalCount; 
}
public   ResultSet getNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId!= null) {
		try {  				
				volunteerCountSt = connection.createStatement();
				 
				volunteerCountRs = volunteerCountSt.executeQuery("select * from common_notification  order by id desc ");
			
				 
			  
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 /*if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
	}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
return volunteerCountRs; 
}
public   ResultSet getMentorNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("adminId");
	if(volunteerId!= null) {
		try {  				
				volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select * from common_notification  order by id desc ");
			
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 /*if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
	}
	else
	{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
	}
return volunteerCountRs; 
}
public   ResultSet getUsersNotication(HttpServletRequest request, HttpServletResponse response, String team) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId!= null) {
		try {  				
				volunteerCountSt = connection.createStatement();
				 
				volunteerCountRs = volunteerCountSt.executeQuery("select * from users_notification where receiver='"+team+"' order by id desc");
			
				 
			  
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 /*if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
	}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
return volunteerCountRs; 
}
public   ResultSet getMentorUsersNotication(HttpServletRequest request, HttpServletResponse response, String team) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("adminId");
	if(volunteerId!= null) {
		try {  				
				volunteerCountSt = connection.createStatement();				 
				volunteerCountRs = volunteerCountSt.executeQuery("select * from users_notification where receiver='"+team+"' order by id desc");			 
			  
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 /*if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
	}
	else
	{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
	}
return volunteerCountRs; 
}

public   int getWorkMeetingCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId!= null) {
		try {  				
				volunteerCountSt = connection.createStatement();
				 
				volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from work_meeting where volunteer_registration_id ='"+volunteerId+"' ");
			
				if(volunteerCountRs.next())
				{
					totalCount = Integer.parseInt(volunteerCountRs.getString(1));
				}
			  
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
			}
	}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
return totalCount; 
}
public   int getWorkTrainingCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId!= null) {
		try {  				
				volunteerCountSt = connection.createStatement();
				 
				volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from work_training where volunteer_registration_id ='"+volunteerId+"' ");
			
				if(volunteerCountRs.next())
				{
					totalCount = Integer.parseInt(volunteerCountRs.getString(1));
				}
			  
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
			}
	}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
return totalCount; 
}
public   int AdminVolunteerCount() throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from volunteer_registration where approve_status ='Approved' ");
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}
public   int adminProfileCount() throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from admin where approve_status ='Approved' ");
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}
public   int volunteerApplicationCount() throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from volunteer_registration where approve_status !='Approved' ");
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}
public   int volunteerTeamCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  		
		Control ct= new Control();
		String branchId = ct.getMenorBranch(id);
		 	if(ct.getAdminType( id).equals("Branch Co-ordinator")) {  
		 		volunteerCountSt = connection.createStatement();
		 		volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from volunteer_registration where approve_status='Approved' and branch_id ='"+branchId+"' ");
				
				if(volunteerCountRs.next())
				{
					totalCount = Integer.parseInt(volunteerCountRs.getString(1));
				}
			 
		 	}else if(ct.getAdminType( id).equals("Co-ordinator")) { 
		 		volunteerCountSt = connection.createStatement();
	 			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from volunteer_registration where approve_status='Approved'  ");
				
				if(volunteerCountRs.next())
				{
					totalCount = Integer.parseInt(volunteerCountRs.getString(1));
				}	
		 	}
		 	else if(ct.getAdminType(id).equals("Branch Meeting Reviewer")) {  
		 		
		  		String team = ct.getMentorTeams(id);
	  		 	String s = "";
	  		 	String[] charArray = team.split(" , ");
	  		 	for(int i=0;i<charArray.length ;i++)
		  	     {
		  	    	 s=s+"'"+charArray[i]+"'";
		  	    	 if(i<(charArray.length)-1)
		  	    	 {
		  	    		s=s+" , " ;
		  	    	 }
		  	     }
	  		 	volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from volunteer_registration where team in("+s+") and branch_id ='"+branchId+"' ");
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));					
			}	
  			 
		 	}else if(ct.getAdminType(id).equals("Mentor")) {
					volunteerCountSt = connection.createStatement();
					String team = ct.getMentorTeams(id);
		  		 	String s = "";
		  		 	String[] charArray = team.split(" , ");
		  		 	for(int i=0;i<charArray.length ;i++)
			  	     {
			  	    	 s=s+"'"+charArray[i]+"'";
			  	    	 if(i<(charArray.length)-1)
			  	    	 {
			  	    		s=s+" , " ;
			  	    	 }
			  	     }
		  		 	volunteerCountSt = connection.createStatement();
					volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from volunteer_registration where team in("+s+") and branch_id ='"+branchId+"' ");
			
				if(volunteerCountRs.next())
				{
					totalCount = Integer.parseInt(volunteerCountRs.getString(1));					
				}	
		 	}
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}
public   int volunteerTeamProjectCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from team_project where admin_id= '"+id+"' ");
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}
public   int volunteerBranchProjectCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from branch_project where admin_id= '"+id+"' ");
		
			if(volunteerCountRs.next())
			{ 
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}
public   int volunteerProjectCount(String volunteerId) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	try {  				
			volunteerCountSt = connection.createStatement();
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from assign_projects where volunteer_registration_id= '"+volunteerId+"' ");
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}
public   ResultSet applicationDetails(  int pageNumber, int nextRecordCount)throws ServletException, IOException { 
  	Statement volunteerDetailsSt =null;
  	ResultSet volunteerDetailsRs = null;
  	 
  	try {  				
  			volunteerDetailsSt = connection.createStatement();
  			volunteerDetailsRs = volunteerDetailsSt.executeQuery("select * from volunteer_registration limit "+(pageNumber*10)+","+nextRecordCount);
		  
  		} 
  	catch (SQLException e) {
		// TODO: handle exception
  		e.printStackTrace();
			}
  	catch (Exception e) {
		// TODO: handle exception
  		e.printStackTrace();
  		}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
		}
	 
  	 
return volunteerDetailsRs;

}
public void addContactDetails( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String contactName = request.getParameter("name");
	String contactEmail = request.getParameter("email");
	String contactPhone = request.getParameter("phone");
	String contactSubject = request.getParameter("subject");
	String contactMessage = request.getParameter("message");
	
 
	 
	try { 
		
		 PreparedStatement addcontactPs =null;
					 try {
						 String addContactQ ="insert into contact_details (name,email,phone,subject,message) values(?,?,?,?,?)";
						
						 addcontactPs  =  connection.prepareStatement(addContactQ);
						 addcontactPs.setString(1, contactName); 
						 addcontactPs.setString(2, contactEmail); 
						 addcontactPs.setString(3, contactPhone); 
						 addcontactPs.setString(4, contactSubject); 
						 addcontactPs.setString(5, contactMessage); 
						 addcontactPs.executeUpdate();	
 						  
						response.sendRedirect("contact.jsp?action=SuccessfullySubmitted");
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ }   
				 catch (SQLException e) {
						// TODO: handle exception
					e.printStackTrace();
					}
				 catch (Exception e) {
						// TODO: handle exception
						 e.printStackTrace();
					} finally {
						if(addcontactPs!=null)  
						  try {
							  addcontactPs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
					 }  
				  
			}
		  
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 
	 	out.close();  
	}

public void commonNotification( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String newsTitle = request.getParameter("newsTitle");
	String newsDate = request.getParameter("newsDate");
	String desc = request.getParameter("desc"); 
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date(); 
 
	
	try { 
		
		 PreparedStatement addcontactPs =null;
					 try {
						 String addContactQ ="insert into common_notification (title,content,news_date,post_date) values(?,?,?,?)";
						
						 addcontactPs  =  connection.prepareStatement(addContactQ);
						 addcontactPs.setString(1, newsTitle); 
						 addcontactPs.setString(2, desc); 
						 addcontactPs.setString(3, newsDate); 
						 addcontactPs.setString(4, dateFormat.format(date)); 
						 
						 addcontactPs.executeUpdate();	
 						  
						response.sendRedirect("admin/index.jsp?action=CommonNewsUpdated");
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ }   
				 catch (SQLException e) {
						// TODO: handle exception
					e.printStackTrace();
					}
				 catch (Exception e) {
						// TODO: handle exception
						 e.printStackTrace();
					} finally {
						if(addcontactPs!=null)  
						  try {
							  addcontactPs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
					 }  
				  
			}
		  
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 
	 	out.close();  
	}
public void teamNewsNotification( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String newsTitle = request.getParameter("newsTitle");
	String newsDate = request.getParameter("newsDate");
	String desc = request.getParameter("desc"); 
	String team[] = request.getParameterValues("team");
	if(team[0].equals("0"))
	{
		response.sendRedirect("admin/index.jsp?action=SelectTypeoFUser");
	}else {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date(); 
 
	
	try { 
		
		 PreparedStatement addcontactPs =null;
		 for(int i=0; i<team.length;i++)
		 {
			 
		 
					 try {
						 String addContactQ ="insert into users_notification (title,content,news_date,post_date,receiver) values(?,?,?,?,?)";
						
						 addcontactPs  =  connection.prepareStatement(addContactQ);
						 addcontactPs.setString(1, newsTitle); 
						 addcontactPs.setString(2, desc); 
						 addcontactPs.setString(3, newsDate); 
						 addcontactPs.setString(4, dateFormat.format(date)); 
						 addcontactPs.setString(5, team[i] );  
						 addcontactPs.executeUpdate();	
 						   
						 }   
				 catch (SQLException e) {
						// TODO: handle exception
					e.printStackTrace();
					}
				 catch (Exception e) {
						// TODO: handle exception
						 e.printStackTrace();
					} finally {
						if(addcontactPs!=null)  
						  try {
							  addcontactPs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
					 } 
		 		}
			response.sendRedirect("admin/index.jsp?action=usersNewsUpdated");		  
			}
		  
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
	}
	 	out.close();  
	}
public  ResultSet viewContact()throws ServletException, IOException { 
	Statement contactSt =null;
	ResultSet contactRs = null;

	try {  				
		contactSt = connection.createStatement();
		String faqQ ="select * from contact_details";
		contactRs = contactSt.executeQuery(faqQ);
	  
		} 
	catch (SQLException e) {
	// TODO: handle exception
		e.printStackTrace();
		}
	catch (Exception e) {
	// TODO: handle exception
		e.printStackTrace();
		}
finally {
	
	/*if(NgoDetailSt!=null)
		try {
			NgoDetailSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	 
}
return contactRs;

}
public void volunteerApproval( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter(); 
	
	Statement ngoEmailSt = null;
	ResultSet ngoEmailRs = null;
	PreparedStatement updateStatusPs = null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	int emailSentCount =0,updateCount=0;
	try {
	   	String from = "prismhack@gmail.com";
	   	String to = null;
	   	String volunteerIds[] = request.getParameterValues("volunteerId"); 
	   	String status = request.getParameter("status"); 
	   	

	   	String pageNumber = request.getParameter("pageNumber"); 
	   	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(); 
	   	if(volunteerIds != null)
	   	{
	   		for ( int i=0; i<volunteerIds.length;i++ ) {  
		   		updateStatusPs = connection.prepareStatement("update  volunteer_registration set  approve_status = ?, approval_date =? where id ="+volunteerIds[i]);  
		   		updateStatusPs.setString(1, status); 
		   		updateStatusPs.setString(2, dateFormat.format(date));  
		   		updateStatusPs.executeUpdate(); 
		   		updateCount++;
			 } 
	   	
		   	for(int j=0; j<volunteerIds.length;j++)
		   		{  
		   		 ngoEmailSt = connection.createStatement();
		   		 ngoEmailRs = ngoEmailSt.executeQuery("select email_id from volunteer_registration where id = '"+volunteerIds[j]+ "' and approve_status = '"+status+"'");	   		  
		   		 if(ngoEmailRs.next())
		   		 {
		   			 to = ngoEmailRs.getString(1);
		   		 }
		   		  try {  
			   			Properties props = System.getProperties();
			   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			   			props.setProperty("mail.smtp.port", "465");
			   			props.setProperty("mail.smtp.socketFactory.port", "465");
			   			props.put("mail.smtp.auth", "true");
			   			props.put("mail.debug", "true");
			   			props.put("mail.store.protocol", "pop3");
			   			props.put("mail.transport.protocol", "smtp");
			   			final String username = "prismhack@gmail.com";
			   			final String password = "code2win";
		   		       
		   			   try{
	   				   		Session mySession = Session.getInstance(props, new Authenticator(){
	   				   			
	   				   			protected PasswordAuthentication getPasswordAuthentication() {
	   				   				return new PasswordAuthentication(username, password);
		   						}
	   				   			
		   					});
	 
		   			      MimeMessage message = new MimeMessage(mySession); 
		   			      message.setFrom(new InternetAddress(from)); 
		   			      message.addRecipient(Message.RecipientType.TO,
		   			                               new InternetAddress(to)); 
		   			      message.setSubject("Volunteer Application Status"); 
		   			      message.setText("Dear Sir/Ma'am\n\n"
		   			    		  +"\n\nYour status has been "+status 
		   			    		 
		   			    		  +"\n\nThank You"
		   			    		  
		   			    		  
		   			    		  +"\nWarm Regards"
		   			    		  +"\n\nPrismVMS"
		   			    		   );
		   			      
		   			      Transport.send(message);
		   			     // result = "Sent message successfully...."; 
		   			      emailSentCount++;
				   						  
	   				  } 
	   			    catch (MessagingException mex) {
	   			      mex.printStackTrace();
	   			      //result = "Error: unable to send message....";
	   			   }
			   		 	 
			   		 }
			   		catch (Exception e) {
			   			// TODO: handle exception
			   		}
		   		}
   
   	
	   	
   	} 
	   	if(emailSentCount ==   updateCount) {
	   		response.sendRedirect("admin/manageUsers.jsp?action=StatusUpdated&pageNumber="+pageNumber);
	   		/*dispatcher.forward(request, response); */
	   	}
}  
	 catch (SQLException e) {
		// TODO: handle exception
		 e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		  if(ngoEmailSt!=null)
				try {
					ngoEmailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	 if(ngoEmailRs!=null)
				try {
					ngoEmailRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	 }
	}
	else
	{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain");
	}
	  out.close(); 
	 
}  
public   int checkVolunteerStatus(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement checkStatusSt =null;
	ResultSet checkStatusRs = null; 
	if(id!=null) {	
		try {  				
				checkStatusSt = connection.createStatement();
				String query = "select id from volunteer_registration where approve_status = 'Approved' and id="+id;
				checkStatusRs = checkStatusSt.executeQuery(query);
				if(checkStatusRs.next())
				{
					return 1;
				}
				else
				{
					response.sendRedirect("volunteerLogin.jsp?action=NotVolunteer"); 
				}
				 
			} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				if(checkStatusSt!=null)
					try {
						checkStatusSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				if(checkStatusRs!=null)
					try {
						checkStatusRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
	return 0; 
}
public   ResultSet volunteerDetails( int pageNumber, int nextRecordCount)throws ServletException, IOException { 
  	Statement volunteerDetailsSt =null;
  	ResultSet volunteerDetailsRs = null;
  
  	try {  				
  			volunteerDetailsSt = connection.createStatement();
  			volunteerDetailsRs = volunteerDetailsSt.executeQuery("select * from volunteer_registration where approve_status='Approved' order by volunteer_name limit "+(pageNumber*10)+","+nextRecordCount);
		  } 
  	catch (SQLException e) {
		// TODO: handle exception
  		e.printStackTrace();
			}
  	catch (Exception e) {
		// TODO: handle exception
  		e.printStackTrace();
  		}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
return volunteerDetailsRs;

}
public   ResultSet mentorDetails(HttpServletRequest request, HttpServletResponse response, int pageNumber, int nextRecordCount)throws ServletException, IOException { 
  	Statement volunteerDetailsSt =null;
  	ResultSet volunteerDetailsRs = null;
  	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
  	try {  				
  			volunteerDetailsSt = connection.createStatement();
  			volunteerDetailsRs = volunteerDetailsSt.executeQuery("select * from admin where approve_status='Approved' and admin_type='Mentor' limit "+(pageNumber*10)+","+nextRecordCount);
		  } 
  	catch (SQLException e) {
		// TODO: handle exception
  		e.printStackTrace();
			}
  	catch (Exception e) {
		// TODO: handle exception
  		e.printStackTrace();
  		}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	}
	else 
	{ 
		response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
	}
return volunteerDetailsRs;

}
public   ResultSet adminsUsersProfile(HttpServletRequest request, HttpServletResponse response, int pageNumber, int nextRecordCount)throws ServletException, IOException { 
  	Statement volunteerDetailsSt =null;
  	ResultSet volunteerDetailsRs = null;
  	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
  	try {  				
  			volunteerDetailsSt = connection.createStatement();
  			volunteerDetailsRs = volunteerDetailsSt.executeQuery("select * from admin where approve_status='Approved'   limit "+(pageNumber*10)+","+nextRecordCount);
		  } 
  	catch (SQLException e) {
		// TODO: handle exception
  		e.printStackTrace();
			}
  	catch (Exception e) {
		// TODO: handle exception
  		e.printStackTrace();
  		}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
		}
	}
	else 
	{ 
		response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
	}
return volunteerDetailsRs;

}
public   ResultSet teamVolunteerDetails( int pageNumber, int nextRecordCount, String adminId,String branchId)throws ServletException, IOException { 
  	Statement volunteerDetailsSt =null;
  	ResultSet volunteerDetailsRs = null;
  
  	try {  				
  		 	Control ct= new Control();
  		 	if(ct.getAdminType( adminId).equals("Branch Co-ordinator")) {  
  		 		
  		 		volunteerDetailsSt = connection.createStatement();
  	  			String query ="select * from volunteer_registration where approve_status='Approved'  and branch_id = '"+branchId+"' order by volunteer_name   limit "+(pageNumber*10)+","+nextRecordCount;
  	  			volunteerDetailsRs = volunteerDetailsSt.executeQuery(query);
  			 
  		 	}else if(ct.getAdminType( adminId).equals("Co-ordinator")) {  
  		 		
  		 		volunteerDetailsSt = connection.createStatement();
  	  			String query ="select * from volunteer_registration where approve_status='Approved'   order by volunteer_name   limit "+(pageNumber*10)+","+nextRecordCount;
  	  			volunteerDetailsRs = volunteerDetailsSt.executeQuery(query);
  			 
  		 	}
  		 	else if(ct.getAdminType( adminId).equals("Branch Meeting Reviewer")) {  
  		 		
  	  			String team = ct.getMentorTeams(adminId);
	  		 	String s = "";
	  		 	String[] charArray = team.split(" , ");
	  		 	for(int i=0;i<charArray.length ;i++)
		  	     {
		  	    	 s=s+"'"+charArray[i]+"'";
		  	    	 if(i<(charArray.length)-1)
		  	    	 {
		  	    		s=s+" , " ;
		  	    	 }
		  	     }
	  			volunteerDetailsSt = connection.createStatement();
	  			String query ="select * from volunteer_registration where approve_status='Approved' and team in("+s+") and branch_id = '"+branchId+"' order by volunteer_name   limit "+(pageNumber*10)+","+nextRecordCount;
	  			volunteerDetailsRs = volunteerDetailsSt.executeQuery(query); 
	  			
  		 	}else if(ct.getAdminType( adminId).equals("Mentor")) {
  		 	
  		 	String team = ct.getMentorTeams(adminId);
  		 	String s = "";
  		 	String[] charArray = team.split(" , ");
  		 	for(int i=0;i<charArray.length ;i++)
	  	     {
	  	    	 s=s+"'"+charArray[i]+"'";
	  	    	 if(i<(charArray.length)-1)
	  	    	 {
	  	    		s=s+" , " ;
	  	    	 }
	  	     }
  			volunteerDetailsSt = connection.createStatement();
  			String query ="select * from volunteer_registration where approve_status='Approved' and team in("+s+") and branch_id = '"+branchId+"' order by volunteer_name   limit "+(pageNumber*10)+","+nextRecordCount;
  			volunteerDetailsRs = volunteerDetailsSt.executeQuery(query);
		 
  		 	}
  		} 
  	catch (SQLException e) {
		// TODO: handle exception
  		e.printStackTrace();
			}
  	catch (Exception e) {
		// TODO: handle exception
  		e.printStackTrace();
  		}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
return volunteerDetailsRs;

}
public void assignTeam( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
    PreparedStatement updateTeamPs = null;
	
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	 
	try { 
	   		String volunteerIds[] = request.getParameterValues("volunteerIds"); 
		   	String team = request.getParameter("team10");  
		   	
			String branch = request.getParameter("branch");  
		   	
		   	String pageNumber = request.getParameter("pageNumber"); 
		    
		   	if(volunteerIds != null)
		   	{
		   		 for ( int i=0; i<volunteerIds.length;i++ )
				 {  
		   			updateTeamPs = connection.prepareStatement("update  volunteer_registration set  team = ?,branch_id=? where id ="+volunteerIds[i]);  
		   			updateTeamPs.setString(1, team);  
		   			updateTeamPs.setString(2, branch);  
		   			updateTeamPs.executeUpdate(); 
				 }  
		   	}  
	   		response.sendRedirect("admin/manageUsers.jsp?action=TeamBranchAssigned&pageNumber="+pageNumber);
	   	 
		}  
	 catch (SQLException e) {
		// TODO: handle exception
		 e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		  if(updateTeamPs!=null)
				try {
					updateTeamPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	 		}
		}
	else {
	response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
	}
	out.close(); 
	 
	}
public void assignDesignation( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
    PreparedStatement updateTeamPs = null;
	
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	 
	try { 
	   		String volunteerIds[] = request.getParameterValues("volunteerIds"); 
		   	String designation = request.getParameter("designation");  
		   	
		  
		   	
		   	String pageNumber = request.getParameter("pageNumber"); 
		   	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date();  
		   	if(volunteerIds != null)
		   	{
		   		 for ( int i=0; i<volunteerIds.length;i++ )
				 {  
		   			updateTeamPs = connection.prepareStatement("insert into volunteer_designation (designation_id,volunteer_registration_id,date_given,admin_id) values(?,?,?,?)  ");  
		   			updateTeamPs.setString(1, designation);  
		   			updateTeamPs.setString(2, volunteerIds[i]);  
		   			updateTeamPs.setString(3, dateFormat.format(date));  
		   			updateTeamPs.setString(4, adminId);  
		   			
		   			updateTeamPs.executeUpdate(); 
				 }  
		   	}  
	   		response.sendRedirect("admin/usersDesignation.jsp?action=DesignationAssigned&pageNumber="+pageNumber);
	   	 
		}  
	 catch (SQLException e) {
		// TODO: handle exception
		 e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		  if(updateTeamPs!=null)
				try {
					updateTeamPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	 		}
		}
	else {
	response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
	}
	out.close(); 
	 
	}
public void updateMentorTeams( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
    PreparedStatement updateTeamPs = null;
	
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	 
	try { 
	   		String volunteerIds[] = request.getParameterValues("mentorIds"); 
		   	  
		   	String team[] = request.getParameterValues("team1"); 
	 		String team1= "";
	 		for( int j=0; j<team.length;j++)
	 		{
	 			team1 = team1+team[j]+" , ";
	 		} 
	 		team1 = team1.substring(0,team1.length()-3);
			String branch = request.getParameter("branch");  
		   	
		   	String pageNumber = request.getParameter("pageNumber"); 
		    
		   	if(volunteerIds != null)
		   	{
		   		 for ( int i=0; i<volunteerIds.length;i++ )
				 {  
		   			updateTeamPs = connection.prepareStatement("update  admin set  team = ?,branch_id=? where id ="+volunteerIds[i]);  
		   			updateTeamPs.setString(1, team1);  
		   			updateTeamPs.setString(2, branch);  
		   			updateTeamPs.executeUpdate(); 
				 }  
		   	}  
	   		response.sendRedirect("admin/manageUsers.jsp?action=mentorTeamBranchAssigned&pageNumber="+pageNumber);
	   	 
		}  
	 catch (SQLException e) {
		// TODO: handle exception
		 e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		  if(updateTeamPs!=null)
				try {
					updateTeamPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	 		}
		}
	else {
	response.sendRedirect("admin/adminLogin.jsp?action=LoginAgain"); 
	}
	out.close(); 
	 
	}
public void updateMentorDesignation( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
    PreparedStatement updateTeamPs = null;
	
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	 
	try { 
	   		String volunteerIds[] = request.getParameterValues("mentorIds");		   	  
		   	String designation = request.getParameter("designation"); 		  
			String branch = request.getParameter("branch");  		   	
		   	String pageNumber = request.getParameter("pageNumber"); 
		    
		   	if(volunteerIds != null)
		   	{
		   		 for ( int i=0; i<volunteerIds.length;i++ )
				 {  
		   			updateTeamPs = connection.prepareStatement("update  admin set  admin_type = ?,branch_id=? where id ="+volunteerIds[i]);  
		   			updateTeamPs.setString(1, designation);  
		   			updateTeamPs.setString(2, branch);  
		   			updateTeamPs.executeUpdate(); 
				 }  
		   	}  
	   		response.sendRedirect("admin/usersDesignation.jsp?action=mentorDesignationAssigned&pageNumber="+pageNumber);
	   	 
		}  
	 catch (SQLException e) {
		// TODO: handle exception
		 e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		  if(updateTeamPs!=null)
				try {
					updateTeamPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	 		}
		}
	else {
	response.sendRedirect("admin/adminLogin.jsp?action=LoginAgain"); 
	}
	out.close(); 
	 
	}
public void createMentor( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    String email=request.getParameter("email");  
	Statement checkMentorSt = null;
	ResultSet checkMentorRs = null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	 
	Statement mentorIdSt=null;
	ResultSet mentorIdRs=null;	 
	PreparedStatement addVolunteerps =null;
	try {  
			checkMentorSt = connection.createStatement();
			String mentorId=null;
		 	String checkQ = "select email   from admin  where email ='"+email+"' ";
		 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
			
		 	if (checkMentorRs.next()) {
				 response.sendRedirect("admin/index.jsp?action=MentorRegistered");
			 }
			 else{     
		 			
			 		String fullName=request.getParameter("fullName");
			 		String userType=request.getParameter("userType");   
			 		String team[] = request.getParameterValues("team"); 
			 		String team1= "";
			 		for( int j=0; j<team.length;j++)
			 		{
			 			team1 = team1+team[j]+" , ";
			 		}
			 		team1 = team1.substring(0,team1.length()-3);
			 		 
			 		String branch=request.getParameter("branch");  
			 		String status = "Approved";
			 		
					String mentorIdQ = "select max(id)+1 as maxId from admin"; 
					mentorIdSt = connection.createStatement();
					mentorIdRs = mentorIdSt.executeQuery(mentorIdQ);
			 		if (mentorIdRs.next())	{ 
			 			mentorId = mentorIdRs.getString("maxId");			 			  
			 			if(mentorId == null)
			 			{
			 				mentorId ="1";
			 			}
			 			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 			Date date = new Date();  
						String 	query = "insert into admin (id,name,email,team,admin_type,approve_status,branch_id,approval_date) values (?,?,?,?,?,?,?,?)";
						addVolunteerps = connection.prepareStatement(query);
						addVolunteerps.setString(1, mentorId);
						addVolunteerps.setString(2, fullName);
						addVolunteerps.setString(3, email); 
						addVolunteerps.setString(4, team1); 						
						addVolunteerps.setString(5, userType);  
						addVolunteerps.setString(6, status);
						addVolunteerps.setString(7, branch);  
						addVolunteerps.setString(8,  dateFormat.format(date));
						addVolunteerps.executeUpdate();   
						
				   		  try {  
				   			  	String to = email;
				   			  	String from = "kapil.thakur1496@gmail.com";
					   			Properties props = System.getProperties();
					   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
					   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
					   			props.setProperty("mail.smtp.port", "465");
					   			props.setProperty("mail.smtp.socketFactory.port", "465");
					   			props.put("mail.smtp.auth", "true");
					   			props.put("mail.debug", "true");
					   			props.put("mail.store.protocol", "pop3");
					   			props.put("mail.transport.protocol", "smtp");
					   			final String username = "prismhack@gmail.com";
					   			final String password = "code2win";
				   		       
				   			   try{
			   				   		Session mySession = Session.getInstance(props, new Authenticator(){
			   				   			 
			   				   			protected PasswordAuthentication getPasswordAuthentication() {
			   				   				return new PasswordAuthentication(username, password);
				   						} 
			   				   			
				   					});
			 
				   			      MimeMessage message = new MimeMessage(mySession); 
				   			      message.setFrom(new InternetAddress(from)); 
				   			      message.addRecipient(Message.RecipientType.TO,
				   			                               new InternetAddress(to)); 
				   			      message.setSubject("PrismVMS Account Details"); 
				   			      message.setText("Dear Sir/Ma'am\n "
				   			    		  +"\n\n You have been as a mentor"
				   			    		  +"\n\n Please go to   http://localhost:8081/NGOVMS/updatePassword.jsp    to set your Password"
				   			    		  +"\n\nThank You" 
				   			    		  +"\nWarm Regards"
				   			    		  +"\n\nPrismVMS"
				   			    		   );
				   			      
				   			      Transport.send(message);
				   			     // result = "Sent message successfully...."; 
				   			   response.sendRedirect("admin/index.jsp?action=MentorCreated"); 
								 
						   						  
			   				  } 
			   			    catch (MessagingException mex) {
			   			      mex.printStackTrace();
			   			      //result = "Error: unable to send message....";
			   			   }
					   		 	 
					   		 }
					   		catch (Exception e) {
					   			// TODO: handle exception
					   		}
				  }
			 }
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 if(checkMentorSt!=null) {
				try {
					checkMentorSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	 		}
		 if(checkMentorRs!=null) {
				try {
					checkMentorRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			if(mentorIdSt!=null) {
				try {
					mentorIdSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			if(mentorIdSt!=null) {
				try {
					mentorIdSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			if(addVolunteerps!=null) {
				try {
					addVolunteerps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
	 }
	
	 }
	else {
		response.sendRedirect("admin/adminLogin.jsp?action=LoginAgain"); 
	}
	out.close();
}
	 
public void mentorVarification( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();   
		    String email=request.getParameter("email");  
			Statement checkMentorSt = null;
			ResultSet checkMentorRs = null; 
			PreparedStatement updatePassDatePs =null;
	try {  
			checkMentorSt = connection.createStatement();
			String mentorId=null;
		 	String checkQ = "select id as mentorId from admin  where email ='"+email+"' and approve_status= 'Approved' and password  is null ";
		 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
			
		 	if (checkMentorRs.next()) { 
		 	 mentorId = checkMentorRs.getString("mentorId");
		 	 Random rnd = new Random();
			 int rand = 100000 + rnd.nextInt(90000); 
			 
			 String otp = Integer.toString(rand);
			 
			 
	   			  
	   			     // result = "Sent message successfully....";  
					String to = email;
	   			  	String from = "kapil.thakur1496@gmail.com";
		   			Properties props = System.getProperties();
		   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
		   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
		   			props.setProperty("mail.smtp.port", "465");
		   			props.setProperty("mail.smtp.socketFactory.port", "465");
		   			props.put("mail.smtp.auth", "true");
		   			props.put("mail.debug", "true");
		   			props.put("mail.store.protocol", "pop3");
		   			props.put("mail.transport.protocol", "smtp");
		   			final String username = "prismhack@gmail.com";
		   			final String password = "code2win";
	   		       
	   			   try{
   				   		Session mySession = Session.getInstance(props, new Authenticator(){
   				   			 
   				   			protected PasswordAuthentication getPasswordAuthentication() {
   				   				return new PasswordAuthentication(username, password);
	   						} 
   				   			
	   					});
 
	   			      MimeMessage message = new MimeMessage(mySession); 
	   			      message.setFrom(new InternetAddress(from)); 
	   			      message.addRecipient(Message.RecipientType.TO,
	   			                               new InternetAddress(to)); 
	   			      message.setSubject("PrismVMS Account Details"); 
	   			      message.setText("Dear Sir/Ma'am\n "
	   			    		  +"\n\n Your otp is "+otp
	   			    		    +"\n\nThank You" 
	   			    		  +"\nWarm Regards"
	   			    		  +"\n\nPrismVMS"
	   			    		   );
	   			      
	   			      Transport.send(message);
	   			     // result = "Sent message successfully....";  
	   			      
	   			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 			Date date = new Date(); 
		 			 HttpSession session = request.getSession(); 
					 session.setAttribute("otp", otp); 
					String query = "update admin set password_set=? where id = "+mentorId;
					updatePassDatePs  =  connection.prepareStatement(query);
					updatePassDatePs.setString(1,  dateFormat.format(date));  
					updatePassDatePs.executeUpdate(); 
	   			      
	   			   response.sendRedirect("updatePassword.jsp?action=otpVarification&email="+email);
	  			  
			   						  
   				  } 
   			    catch (MessagingException mex) {
   			      mex.printStackTrace();
   			      //result = "Error: unable to send message....";
   			   }
		   		 
					
		 	}
		 else{     
			 response.sendRedirect("adminLogin.jsp?action=PasswordAlreadySetUseForgotOption");
		 }
			 
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 if(checkMentorSt!=null) {
				try {
					checkMentorSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	 		}
		 if(checkMentorRs!=null) {
				try {
					checkMentorRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			 
			 
			if(updatePassDatePs!=null) {
				try {
					updatePassDatePs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			
	 }
	out.close();
}
public   void otpVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 try {  				
			String otp = request.getParameter("otp");
			String email = request.getParameter("email");
			
			HttpSession session = request.getSession();   
	        String checkOtp = (String)session.getAttribute("otp");
	        if(checkOtp==null) {
	        	response.sendRedirect("updatePassword.jsp?action=OtpExpired");
	        }
	        if(checkOtp.equals(otp)) {
	        
				volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select id  from admin where email ='"+email+"' ");
				PreparedStatement updatePassDatePs =null;
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
		 			
				if(password.equals(confirmPassword) ) { 
					if(volunteerCountRs.next()) {
					
						String query = "update admin  set password=?,password_set=? where id = "+volunteerCountRs.getString("id");
						updatePassDatePs  =  connection.prepareStatement(query);
						updatePassDatePs.setString(1, password);  
						updatePassDatePs.setString(2, dateFormat.format(date));  
						
						updatePassDatePs.executeUpdate();	
						response.sendRedirect("adminLogin.jsp?action=useNewPassword");
					
					}
		        }else
		        {
		        	response.sendRedirect("updatePassword.jsp?action=PasswordAndConfirmPasswordNotMactched");
		        } 
	        }else
	        {
				 response.sendRedirect("updatePassword.jsp?action=otpIsNotCorrect&email="+email);
	        }
	         
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}  
		
}
public   int getAdminType(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement checkStatusSt =null;
	ResultSet checkStatusRs = null;
		HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
	if(id!=null) {	
		try {  				
				checkStatusSt = connection.createStatement();
				String query = "select admin_type from admin where id ="+id;
				checkStatusRs = checkStatusSt.executeQuery(query);
				if(checkStatusRs.next())
				{
					
				}
				else
				{
					return 0;
				}
				 
			} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				if(checkStatusSt!=null)
					try {
						checkStatusSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				if(checkStatusRs!=null)
					try {
						checkStatusRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
	else
	{
		response.sendRedirect("adminLogin.jsp?action=notAdmin"); 
	}
		}else
		{
			response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
		}
	return 0; 
}
public  String getAdminType(String id) throws ServletException, IOException { 
	Statement checkStatusSt =null;
	ResultSet checkStatusRs = null;
		 String type="";
		if(id !=null) {
	 	
		try {  				
				checkStatusSt = connection.createStatement();
				String query = "select admin_type from admin where id ="+id;
				checkStatusRs = checkStatusSt.executeQuery(query);
				if(checkStatusRs.next())
				{
				type = checkStatusRs.getString("admin_type");
				}
				else
				{
					 return type;
				}
				 
			} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				if(checkStatusSt!=null)
					try {
						checkStatusSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				if(checkStatusRs!=null)
					try {
						checkStatusRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		} 
	return type; 
}
public   String getMentorType(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement checkStatusSt =null;
	ResultSet checkStatusRs = null;  
	  String type=null;
		HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
	if(id!=null) {	
		try {  				
				checkStatusSt = connection.createStatement();
				String query = "select admin_type from admin where id ="+id;
				checkStatusRs = checkStatusSt.executeQuery(query);
				if(checkStatusRs.next())
				{
					type = checkStatusRs.getString("admin_type");
				}
			 
				 
			} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				if(checkStatusSt!=null)
					try {
						checkStatusSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				if(checkStatusRs!=null)
					try {
						checkStatusRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
	else
	{
		response.sendRedirect("adminLogin.jsp?action=notAdmin"); 
	}
		}else
		{
			response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
		}
	return type; 
}

public   int checkMentorStatus(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement checkStatusSt =null;
	ResultSet checkStatusRs = null; 
	if(id!=null) {	
		try {  				
				checkStatusSt = connection.createStatement();
				String query = "select id from admin where approve_status = 'Approved' and id= "+id;
				checkStatusRs = checkStatusSt.executeQuery(query);
				if(checkStatusRs.next())
				{
					return 1;
				}
				else
				{
					response.sendRedirect("adminLogin.jsp?action=NotMentor"); 
				}
				 
			} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				if(checkStatusSt!=null)
					try {
						checkStatusSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				if(checkStatusRs!=null)
					try {
						checkStatusRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
	else
	{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
	}
	return 0; 
}
 
public   String  getMentorTeams(String id ) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  String team = "";
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select team   from admin where id ="+id;
			getTeamsRs = getTeamsSt.executeQuery(query);
			if(getTeamsRs.next())
			{
				team = getTeamsRs.getString("team");
				
			}
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		 if(getTeamsSt!=null)
			try {
				getTeamsSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(getTeamsRs!=null)
				try {
					getTeamsRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	 
	}
	return team;

}
public void assignIndividualProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String projectTitle = request.getParameter("projectTitle");
			String projectStartDate = request.getParameter("projectStartDate");
			String projectEndDate = request.getParameter("projectEndDate");
			String projectDesc = request.getParameter("projectDesc");
			String vId = request.getParameter("vId");
			Control ct = new Control();
			String to = ct.getEmail(vId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into assign_projects  (volunteer_registration_id,project_title, project_desc, project_start_date,project_end_date,admin_id,assign_date) values(?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, vId); 
			assingProjectPs.setString(2, projectTitle); 
			assingProjectPs.setString(3, projectDesc); 
			assingProjectPs.setString(4, projectStartDate); 
			assingProjectPs.setString(5, projectEndDate); 
			assingProjectPs.setString(6, adminId);  
			assingProjectPs.setString(7, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("New Project"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n One New Project is assigned to you "+projectTitle 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("individualProject.jsp?action=ProjectAssigned&pN=1");
			      
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
 
 
public   String getEmail(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  String email = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select email_id from volunteer_registration where id ='"+id+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			if(getTeamsRs.next())
			{
				email = getTeamsRs.getString("email_id");
			}
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		 if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	return email;

	}
public   String getMentorEmail(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  String email = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select email from admin where id ='"+id+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			if(getTeamsRs.next())
			{
				email = getTeamsRs.getString("email");
			}
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		 if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	return email;

	}
public   ResultSet getMentorDesignationEmails(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  
	try {  		
			Control ct = new Control();
			
			getTeamsSt = connection.createStatement();
			String query = "select email from admin where admin_type in ('Branch Co-ordinator','Branch Meeting Reviewer') or admin_type='Co-ordinator' and  branch_id ='"+ct.getMenorBranch(id)+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getTeamsRs;

	}
public   ResultSet getMentorDesignationEmailsForStudentHeadMeeting(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  
	try {  		
			Control ct = new Control();
			getTeamsSt = connection.createStatement();
			String query = "select email from admin where admin_type = 'Branch Co-ordinator' or admin_type='Co-ordinator' and  branch_id ='"+ct.getVolunteerBranch(id)+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getTeamsRs;

	}
public   String getPhone(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  String email = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select contact_num from volunteer_registration where id ='"+id+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			if(getTeamsRs.next())
			{
				email = getTeamsRs.getString("contact_num");
			}
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		 if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	return email;

	}
public   String getMentorPhone(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  String email = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select phone from admin where id ='"+id+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			if(getTeamsRs.next())
			{
				email = getTeamsRs.getString("phone");
			} 
			  
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		 if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	return email;

	}
public   ResultSet getEmails(String  team) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	 
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select email_id from volunteer_registration where team  ='"+team+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getTeamsRs;

	}
 
public void createTeamProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	ResultSet maxIdRs=null;
	Statement maxISt=null;
	
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {
			maxISt = connection.createStatement();
			String queryMaxId = "select max(id)+1 as maxId from team_project";
			maxIdRs = maxISt.executeQuery(queryMaxId);
			if(maxIdRs.next()) {
				String maxId = maxIdRs.getString("maxId");
				ResultSet emailRs =null; 
				String projectTitle = request.getParameter("projectTitle");
				String projectStartDate = request.getParameter("projectStartDate");
				String projectEndDate = request.getParameter("projectEndDate");
				String projectDesc = request.getParameter("projectDesc");
				 
				String team = request.getParameter("team"); 
				Control ct = new Control();
			
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
	 			String branchId = ct.getMenorBranch(adminId);
		       // result = "Sent message successfully....";  
				
				String query = "insert into team_project(id,tproject_title,tproject_desc,tpro_start_date,tpro_end_date,team,project_creation_date,admin_id,branch_id) values(?,?,?,?,?,?,?,?,?)" ;
				assingProjectPs = connection.prepareStatement(query);
				assingProjectPs.setString(1, maxId); 
				assingProjectPs.setString(2, projectTitle); 
				assingProjectPs.setString(3, projectDesc); 
				assingProjectPs.setString(4, projectStartDate); 
				assingProjectPs.setString(5, projectEndDate); 
				assingProjectPs.setString(6, team); 			
				assingProjectPs.setString(7, dateFormat.format(date)); 
				assingProjectPs.setString(8, adminId);  
				assingProjectPs.setString(9, branchId);  
				assingProjectPs.executeUpdate();	
				emailRs = ct.getEmails(team);
				 
				while(emailRs.next()) {
					
				  	String from = "kapil.thakur1496@gmail.com";
		   			Properties props = System.getProperties();
		   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
		   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
		   			props.setProperty("mail.smtp.port", "465");
		   			props.setProperty("mail.smtp.socketFactory.port", "465");
		   			props.put("mail.smtp.auth", "true");
		   			props.put("mail.debug", "true");
		   			props.put("mail.store.protocol", "pop3");
		   			props.put("mail.transport.protocol", "smtp");
		   			final String username = "prismhack@gmail.com";
		   			final String password = "code2win";
				       
					   try{
					   		Session mySession = Session.getInstance(props, new Authenticator(){
					   			 
					   			protected PasswordAuthentication getPasswordAuthentication() {
					   				return new PasswordAuthentication(username, password);
								} 
					   			
							});
		
					      MimeMessage message = new MimeMessage(mySession); 
					     
					      
					      message.addRecipient(Message.RecipientType.BCC,
					              new InternetAddress(emailRs.getString("email_id")));
					      message.setFrom(new InternetAddress(from)); 
	 
					 	 
					      /*message.addRecipient(Message.RecipientType.TO,
					                               new InternetAddress(to)); */
					      message.setSubject("New Team Project"); 
					      message.setText("Dear Volunteer\n "
					    		  +"\n\n One New Project is Created fot your Team "+projectTitle 
					    		  +"\n\n You can enroll yourself by sending enroll request" 
					    		  
					    		  +"\n\nThank You" 
					    		  +"\nWarm Regards"
					    		  +"\n\nPrismVMS"
					    		   );
					      
					      Transport.send(message);
					     // result = "Sent message successfully....";  
					       
					      response.sendRedirect("assignTeamProjects.jsp?action=projectCreated&projectId="+maxId);
					   			  
					   } 
					    catch (MessagingException mex) {
					      mex.printStackTrace();
					      //result = "Error: unable to send message....";
					   } 
				} 

			}
			
		}
	 
	catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
	catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
	 if(assingProjectPs!=null) {
			try {
				assingProjectPs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
}	 
 else{     
	 response.sendRedirect("adminLogin?action=LoginAgain");
 	}  
	out.close();
	}
 
public   ResultSet getVolunteerForTeamProject( String  id) throws ServletException, IOException { 
	Statement getVolunteerSt = null;
	ResultSet getVolunteerRs = null;
	 
	try {  	
		Control ct = new Control();
		String branchId = ct.getTeamProjectBranch(id);
		String team = ct.getTeamProjectTeam(id);
		 
		getVolunteerSt = connection.createStatement();
		 String query = "select id, volunteer_name  from volunteer_registration where team = '"+team+"'  and branch_id='"+branchId+"' and id not in(select volunteer_registration_id from assign_projects where team_project_id ='"+id+"' ) ";
		 getVolunteerRs = getVolunteerSt.executeQuery(query);
			 
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getVolunteerRs;

	}

public   String getTeamProjectBranch(String  id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null;
	ResultSet getTeamProjectRs = null;
	 String branchId = null;
	try {  				
		getTeamProjectSt = connection.createStatement();
	 
			String query = "select branch_id  from team_project where id = '"+id+"'";
			getTeamProjectRs = getTeamProjectSt.executeQuery(query);
			if(getTeamProjectRs.next())
			{
			branchId = getTeamProjectRs.getString("branch_id");
			}
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		  if(getTeamProjectSt!=null)
			try {
				getTeamProjectSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamProjectRs!=null)
				try {
					getTeamProjectRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
	return branchId;

	}
public   String getTeamProjectTeam(String  id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null;
	ResultSet getTeamProjectRs = null;
	 String team = null;
	try {  				
		getTeamProjectSt = connection.createStatement();
	 
			String query = "select team  from team_project where id = '"+id+"'";
			getTeamProjectRs = getTeamProjectSt.executeQuery(query);
			if(getTeamProjectRs.next())
			{
			team = getTeamProjectRs.getString("team");
			}
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		  if(getTeamProjectSt!=null)
			try {
				getTeamProjectSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamProjectRs!=null)
				try {
					getTeamProjectRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
	return team;

	}
public void assignTeamProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			Control ct = new Control();
			String projectId = request.getParameter("projectId");
			ResultSet teamProjectRs = ct.getTeamProject(projectId);
			String projectTitle=null,projectStartDate=null,projectEndDate=null,projectDesc=null;
			while(teamProjectRs.next())
			{
			  projectTitle = teamProjectRs.getString("tproject_title") ;
			  projectStartDate = teamProjectRs.getString("tpro_start_date") ;
			  projectEndDate = teamProjectRs.getString("tpro_end_date") ;
			  projectDesc = teamProjectRs.getString("tproject_desc") ;
			}
			String vId[] = request.getParameterValues("vIds");
			for(int i=0; i<vId.length;i++) {
			
			 
			String to = ct.getEmail(vId[i]);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into assign_projects  (volunteer_registration_id,project_title, project_desc, project_start_date,project_end_date,team_project_id,admin_id,assign_date) values(?,?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, vId[i]); 
			assingProjectPs.setString(2, projectTitle); 
			assingProjectPs.setString(3, projectDesc); 
			assingProjectPs.setString(4, projectStartDate); 
			assingProjectPs.setString(5, projectEndDate); 
			assingProjectPs.setString(6, projectId); 
			assingProjectPs.setString(7, adminId);  
			assingProjectPs.setString(8, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("New Team Project"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n you are assigned to a new Team Project "+projectTitle 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
			}
			response.sendRedirect("teamProjectView.jsp?action=TeamProjectAssigned&pN=1");
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

public   ResultSet getTeamProject(String  id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null;
	ResultSet getTeamProjectRs = null;
	 String team = null;
	try {  				
		getTeamProjectSt = connection.createStatement();
	 
			String query = "select *  from team_project where id = '"+id+"'";
			getTeamProjectRs = getTeamProjectSt.executeQuery(query);
			 
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		 /* if(getTeamProjectSt!=null)
			try {
				getTeamProjectSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamProjectRs!=null)
				try {
					getTeamProjectRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
		}
	return getTeamProjectRs;

	}
public   ResultSet getTeamProject(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from team_project where admin_id = '"+adminId+"' order by tproject_title  limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("MentorIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public void createBranchProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	ResultSet maxIdRs=null;
	Statement maxISt=null;
	
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {
			maxISt = connection.createStatement();
			String queryMaxId = "select max(id)+1 as maxId from branch_project";
			maxIdRs = maxISt.executeQuery(queryMaxId);
			if(maxIdRs.next()) {
				String maxId = maxIdRs.getString("maxId");
				ResultSet emailRs =null; 
				String projectTitle = request.getParameter("projectTitle");
				String projectStartDate = request.getParameter("projectStartDate");
				String projectEndDate = request.getParameter("projectEndDate");
				String projectDesc = request.getParameter("projectDesc");
				 
				Control ct = new Control();
			
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
	 			String branchId = ct.getMenorBranch(adminId);
		       // result = "Sent message successfully....";  
				
				String query = "insert into branch_project(id,bproject_title,bproject_desc,bpro_start_date,bpro_end_date, bpro_creation_date,admin_id,branch_id) values(?,?,?,?,?,?,?,?)" ;
				assingProjectPs = connection.prepareStatement(query);
				assingProjectPs.setString(1, maxId); 
				assingProjectPs.setString(2, projectTitle); 
				assingProjectPs.setString(3, projectDesc); 
				assingProjectPs.setString(4, projectStartDate); 
				assingProjectPs.setString(5, projectEndDate);  			
				assingProjectPs.setString(6, dateFormat.format(date)); 
				assingProjectPs.setString(7, adminId);  
				assingProjectPs.setString(8, branchId);  
				assingProjectPs.executeUpdate();	
				emailRs = ct.getBranchEmails(branchId);
				while(emailRs.next()) {
					
				  	String from = "kapil.thakur1496@gmail.com";
		   			Properties props = System.getProperties();
		   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
		   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
		   			props.setProperty("mail.smtp.port", "465");
		   			props.setProperty("mail.smtp.socketFactory.port", "465");
		   			props.put("mail.smtp.auth", "true");
		   			props.put("mail.debug", "true");
		   			props.put("mail.store.protocol", "pop3");
		   			props.put("mail.transport.protocol", "smtp");
		   			final String username = "prismhack@gmail.com";
		   			final String password = "code2win";
				       
					   try{
					   		Session mySession = Session.getInstance(props, new Authenticator(){
					   			 
					   			protected PasswordAuthentication getPasswordAuthentication() {
					   				return new PasswordAuthentication(username, password);
								} 
					   			
							});
		
					      MimeMessage message = new MimeMessage(mySession); 
					     
					      
					      message.addRecipient(Message.RecipientType.BCC,
					              new InternetAddress(emailRs.getString("email_id")));
					      message.setFrom(new InternetAddress(from)); 
	 
					 	 
					      /*message.addRecipient(Message.RecipientType.TO,
					                               new InternetAddress(to)); */
					      message.setSubject("New Branch Project"); 
					      message.setText("Dear Volunteer\n "
					    		  +"\n\n One New Branch Project is Created fot your Team "+projectTitle 
					    		  +"\n\n You can enroll yourself by sending enroll request" 
					    		  
					    		  +"\n\nThank You" 
					    		  +"\nWarm Regards"
					    		  +"\n\nPrismVMS"
					    		   );
					      
					      Transport.send(message);
					     // result = "Sent message successfully....";  
					       
					      response.sendRedirect("assignBranchProjects.jsp?action=BranchProjectCreated&projectId="+maxId);
					   			  
					   } 
					    catch (MessagingException mex) {
					      mex.printStackTrace();
					      //result = "Error: unable to send message....";
					   } 
				}

			}
			
		}
	 
	catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
	catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
	 if(assingProjectPs!=null) {
			try {
				assingProjectPs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
	}
public   ResultSet getVolunteerForBranchProject( String  id,String adminId) throws ServletException, IOException { 
	Statement getVolunteerSt = null;
	ResultSet getVolunteerRs = null;
	 
	try {  	
		Control ct = new Control();
		String branchId = ct.getMentorBranch(adminId);
		  
		getVolunteerSt = connection.createStatement();
		 String query = "select id, volunteer_name  from volunteer_registration where branch_id='"+branchId+"' and id not in(select volunteer_registration_id from assign_projects where bproject_id ='"+id+"' ) ";
		 getVolunteerRs = getVolunteerSt.executeQuery(query);
			 
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getVolunteerRs;

	}
public   String getMentorBranch(String id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null;
	ResultSet getTeamProjectRs = null;
	 String branchId = null; 
	 
		try {  				
				getTeamProjectSt = connection.createStatement(); 
				String query = "select branch_id  from admin where id = '"+id+"'";
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				if(getTeamProjectRs.next())
				{
				branchId = getTeamProjectRs.getString("branch_id");
				} 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			  if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
	 
	return branchId;

	}
public   String getVolunteerBranch(String id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null;
	ResultSet getTeamProjectRs = null;
	 String branchId = null; 
	 
		try {  				
				getTeamProjectSt = connection.createStatement(); 
				String query = "select branch_id  from volunteer_registration where id = '"+id+"'";
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				if(getTeamProjectRs.next())
				{
				branchId = getTeamProjectRs.getString("branch_id");
				} 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			  if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
	 
	return branchId;

	}
public   ResultSet getBranchEmails(String  id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	 
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select email_id from volunteer_registration where branch_id  ='"+id+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getTeamsRs;

	}
public void assignBranchProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			Control ct = new Control();
			String projectId = request.getParameter("projectId");
			ResultSet teamProjectRs = ct.getBranchProject(projectId);
			String projectTitle=null,projectStartDate=null,projectEndDate=null,projectDesc=null;
			while(teamProjectRs.next())
			{
			  projectTitle = teamProjectRs.getString("bproject_title") ;
			  projectStartDate = teamProjectRs.getString("bpro_start_date") ;
			  projectEndDate = teamProjectRs.getString("bpro_end_date") ;
			  projectDesc = teamProjectRs.getString("bproject_desc") ;
			}
			String vId[] = request.getParameterValues("vIds");
			for(int i=0; i<vId.length;i++) {
			
			 
			String to = ct.getEmail(vId[i]);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into assign_projects  (volunteer_registration_id,project_title, project_desc, project_start_date,project_end_date,bproject_id,admin_id,assign_date) values(?,?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, vId[i]); 
			assingProjectPs.setString(2, projectTitle); 
			assingProjectPs.setString(3, projectDesc); 
			assingProjectPs.setString(4, projectStartDate); 
			assingProjectPs.setString(5, projectEndDate); 
			assingProjectPs.setString(6, projectId); 
			assingProjectPs.setString(7, adminId);  
			assingProjectPs.setString(8, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("New Branch Project "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n You are assigned to a new Branch Project  "+projectTitle 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
			}
			response.sendRedirect("branchProjectView.jsp?action=BranchProjectAssigned&pN=1");
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public   ResultSet getBranchProject(String  id) throws ServletException, IOException { 
	Statement getBranchProjectSt = null;
	ResultSet getBranchProjectRs = null;
	try {  				
			getBranchProjectSt = connection.createStatement();
			String query = "select *  from branch_project where id = '"+id+"'";
			getBranchProjectRs = getBranchProjectSt.executeQuery(query);
			 
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		 /* if(getTeamProjectSt!=null)
			try {
				getTeamProjectSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamProjectRs!=null)
				try {
					getTeamProjectRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
		}
	return getBranchProjectRs;

	}
public   String getBranchName(String  id) throws ServletException, IOException { 
		Statement getBranchSt = null;
		ResultSet getBranchRs = null;
		String branchName=null;
		try {  				
			getBranchSt = connection.createStatement();
				String query = "select  name  from branch where id = '"+id+"'";
				getBranchRs = getBranchSt.executeQuery(query);
				if(getBranchRs.next())
				{
					branchName = getBranchRs.getString("name");
				}
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(getBranchSt!=null)
				try {
					getBranchSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getBranchRs!=null)
					try {
						getBranchRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
			}
		return branchName;

		}
public   ResultSet getBranchProject(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from branch_project where admin_id = '"+adminId+"' order by bproject_title  limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public   ResultSet getVolunteerProject(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from assign_projects where volunteer_registration_id = '"+volunteerId+"' limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public void submitWorkDiary( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {
			String projectId = request.getParameter("projectId");
			String wdate = request.getParameter("wdate");
			String wtime = request.getParameter("wtime");
			String taskDesc = request.getParameter("taskDesc");

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into workdiary  ( project_id,volunteer_registration_id,wdate,work_desc,whours,submit_date) values(?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, projectId); 
			assingProjectPs.setString(2, volunteerId); 
			assingProjectPs.setString(3, wdate); 
			assingProjectPs.setString(4, taskDesc); 
			assingProjectPs.setString(5, wtime); 
			assingProjectPs.setString(6, dateFormat.format(date));   
			assingProjectPs.executeUpdate();	
	 
		 
			response.sendRedirect("projectAssigned.jsp?action=WorkDiarySubmitted&pN=1");
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

 public   String getVolunteerTeam(String id ) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  String team = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select team   from volunteer_registration where id="+id;
			getTeamsRs = getTeamsSt.executeQuery(query);
			 if(getTeamsRs.next())
			 {
				 team = getTeamsRs.getString("team");
			 }
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		 if(getTeamsSt!=null)
			try {
				getTeamsSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(getTeamsRs!=null)
				try {
					getTeamsRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	}
	return team;

}
 
public   ResultSet getWorkDiaryProject( HttpServletRequest request, HttpServletResponse response,String projectId) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select *   from workdiary where project_id= '"+projectId+"' and volunteer_registration_id='"+volunteerId+"'";
					getTeamsRs = getTeamsSt.executeQuery(query);
					 
				} 
			catch (SQLException e) {
					// TODO: handle exception
				e.printStackTrace();
				}
			 catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
				}
			finally {
				
				/*if(NgoDetailSt!=null)
					try {
						NgoDetailSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		    	 
			}
		}
	return getTeamsRs;

}

public   String getProjectName(String id) throws ServletException, IOException { 
	Statement getStatusSt =null;
	ResultSet getStatusRs = null;
	  String project_titile =null;
	try {  				
		getStatusSt = connection.createStatement();
			String query = "select project_title from assign_projects where id = "+id;
			getStatusRs = getStatusSt.executeQuery(query);
			 if(getStatusRs.next())
			 {
				 project_titile = getStatusRs.getString("project_title");
			 }
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return project_titile; 
}
public   ResultSet getVoluntterProjects(String id) throws ServletException, IOException { 
	Statement getProjectSt =null;
	ResultSet getProjectRs = null;

	try {  				
			getProjectSt = connection.createStatement();
			String query = "select project_title,id from assign_projects where  volunteer_registration_id = "+id;
			getProjectRs = getProjectSt.executeQuery(query);
			 
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getProjectRs; 
}


public void submitWorkDiaryForProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {
			String projectId = request.getParameter("projectId");
			String wdate = request.getParameter("wdate");
			String wtime = request.getParameter("wtime");
			String taskDesc = request.getParameter("taskDesc");
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into workdiary  ( project_id,volunteer_registration_id,wdate,work_desc,whours,submit_date) values(?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, projectId); 
			assingProjectPs.setString(2, volunteerId); 
			assingProjectPs.setString(3, wdate); 
			assingProjectPs.setString(4, taskDesc); 
			assingProjectPs.setString(5, wtime); 
			assingProjectPs.setString(6, dateFormat.format(date));   
			assingProjectPs.executeUpdate();	
	 
		 
			response.sendRedirect("workDiary.jsp?action=workDiarySubmitted");
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

public   ResultSet getVoluntterMeetings() throws ServletException, IOException { 
	Statement getMeetingSt =null;
	ResultSet getMeetingRs = null;

	try {  				
			getMeetingSt = connection.createStatement();
			String query = "select meeting_type  from meeting_type  ";
			getMeetingRs = getMeetingSt.executeQuery(query); 
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getMeetingRs; 
}
public void submitMeeting( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {
			String meeting = request.getParameter("meeting");
			String mdate = request.getParameter("mdate");
			String mtime = request.getParameter("mtime");
			String meetingDesc = request.getParameter("meetingDesc");
			 
			 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into work_meeting  (meeting_date,meeting_type,total_hours,meeting_discuss,volunteer_registration_id, submit_date) values(?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, mdate); 
			assingProjectPs.setString(2, meeting); 
			assingProjectPs.setString(3, mtime); 
			assingProjectPs.setString(4, meetingDesc); 
			assingProjectPs.setString(5, volunteerId); 
			assingProjectPs.setString(6, dateFormat.format(date));   
			assingProjectPs.executeUpdate();	 
			response.sendRedirect("workMeeting.jsp?action=meetingSubmitted");
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
} 
public   ResultSet getWorkMeeting( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select *   from work_meeting where   volunteer_registration_id='"+volunteerId+"'";
					getTeamsRs = getTeamsSt.executeQuery(query);
					 
				} 
			catch (SQLException e) {
					// TODO: handle exception
				e.printStackTrace();
				}
			 catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
				}
			finally {
				
				/*if(NgoDetailSt!=null)
					try {
						NgoDetailSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		    	 
			}
		}
	return getTeamsRs;

}
public   ResultSet getVolunteerWorkMeeting( HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select *   from work_meeting where   volunteer_registration_id='"+id+"'";
					getTeamsRs = getTeamsSt.executeQuery(query);
					 
				} 
			catch (SQLException e) {
					// TODO: handle exception
				e.printStackTrace();
				}
			 catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
				}
			finally {
				
				/*if(NgoDetailSt!=null)
					try {
						NgoDetailSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		    	 
			}
		}
		else
		{
			 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
	return getTeamsRs;

}
public   ResultSet getVolunteerWorkTraining( HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select * from work_training where volunteer_registration_id='"+id+"'";
					getTeamsRs = getTeamsSt.executeQuery(query);
					 
				} 
			catch (SQLException e) {
					// TODO: handle exception
				e.printStackTrace();
				}
			 catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
				}
			finally {
				
				/*if(NgoDetailSt!=null)
					try {
						NgoDetailSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		    	 
			}
		}
		else
		{
			 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
	return getTeamsRs; 
}

public   ResultSet getWorkTraining( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select * from work_training where volunteer_registration_id='"+volunteerId+"'";
					getTeamsRs = getTeamsSt.executeQuery(query);
					 
				} 
			catch (SQLException e) {
					// TODO: handle exception
				e.printStackTrace();
				}
			 catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
				}
			finally {
				
				/*if(NgoDetailSt!=null)
					try {
						NgoDetailSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		    	 
			}
		}
	return getTeamsRs; 
}

public   String getTeamId(String name ) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  String teamId = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select id from teams where team_name='"+name+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 if(getTeamsRs.next())
			 {
				 teamId = getTeamsRs.getString("id");
			 }
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		 if(getTeamsSt!=null)
			try {
				getTeamsSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(getTeamsRs!=null)
				try {
					getTeamsRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	}
	return teamId;

}
public   ResultSet getTrainging(String teamId ) throws ServletException, IOException { 
	Statement getTraningSt =null;
	ResultSet getTraningRs = null;
	  
	try {  				
		getTraningSt = connection.createStatement();
			String query = "select *  from training_type where team_id="+teamId;
			getTraningRs = getTraningSt.executeQuery(query);
			  
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		 /*if(getTeamsSt!=null)
			try {
				getTeamsSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(getTeamsRs!=null)
				try {
					getTeamsRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
	}
	return getTraningRs;

}
public void submitTraining( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
		 
			String training = request.getParameter("training");
			String tdate = request.getParameter("tdate");
			String ttime = request.getParameter("ttime");
			String meetingDesc = request.getParameter("trainingDesc");
			 
			 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into work_training  (train_date,train_type,train_time,train_topic,volunteer_registration_id ,submit_date) values(?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, tdate); 
			assingProjectPs.setString(2, training); 
			assingProjectPs.setString(3, ttime); 
			assingProjectPs.setString(4, meetingDesc); 
			assingProjectPs.setString(5, volunteerId); 
			assingProjectPs.setString(6, dateFormat.format(date));   
			assingProjectPs.executeUpdate();	 
			response.sendRedirect("workTraining.jsp?action=trainingSubmitted");
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void monthWorkDiray( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
		 
			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			String skills = request.getParameter("skills");
			String progress = request.getParameter("progress");
			String futureProspects = request.getParameter("futureProspects");
			String challenges = request.getParameter("challenges"); 
			 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			String  status = "Submitted";
	       // result = "Sent message successfully....";  
			
			String query = "insert into month_workdairy  (submit_date,to_date,from_date,skillaacquired,progress,challenges,future_prospects, volunteer_registration_id,report_submission) values(?,?,?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, dateFormat.format(date)); 
			assingProjectPs.setString(2, toDate); 
			assingProjectPs.setString(3, fromDate); 
			assingProjectPs.setString(4, skills); 
			assingProjectPs.setString(5, progress); 
			assingProjectPs.setString(6, challenges); 
			assingProjectPs.setString(7, futureProspects);  
			assingProjectPs.setString(8, volunteerId);			
			assingProjectPs.setString(9, status);
			assingProjectPs.executeUpdate();	 
			response.sendRedirect("monthlyReport.jsp?action=monthlyReportSubmitted");
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}


public   ResultSet getWorkDiary(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException { 
	Statement getTraningSt =null;
	ResultSet getTraningRs = null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
	  
	try {  				
			getTraningSt = connection.createStatement();
			String query = "select *  from workdiary where volunteer_registration_id="+volunteerId;
			getTraningRs = getTraningSt.executeQuery(query);
			  
			 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /*if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 if(getTeamsRs!=null)
					try {
						getTeamsRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
		}
	} 
	else{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
	}
	return getTraningRs;

}
public   ResultSet getBranchProfiles(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException { 
	Statement getTraningSt =null;
	ResultSet getTraningRs = null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("adminId");
	if(volunteerId !=null) {
	  Control ct = new Control();
	  
	try {  				
		
			getTraningSt = connection.createStatement();
			String query = "select id, name  from admin where branch_id='"+ct.getMentorBranch(volunteerId)+"'";
			getTraningRs = getTraningSt.executeQuery(query);
			 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /*if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 if(getTeamsRs!=null)
					try {
						getTeamsRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
		}
	} 
	else{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain");
	}
	return getTraningRs;

}
public   ResultSet getTeamMates(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException { 
	Statement getTraningSt =null;
	ResultSet getTraningRs = null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
	  Control ct = new Control();
	 String team = ct.getVolunteerTeam(volunteerId);
	try {  				
		
			getTraningSt = connection.createStatement();
			String query = "select id, volunteer_name  from volunteer_registration where approve_status='Approved' and team='"+team+"' and branch_id='"+ct.getVolunteerBranch(volunteerId)+"'";
			getTraningRs = getTraningSt.executeQuery(query);
			 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /*if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 if(getTeamsRs!=null)
					try {
						getTeamsRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
		}
	} 
	else{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
	}
	return getTraningRs;

}
public   ResultSet getStudentHeads(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException { 
	Statement getTraningSt =null;
	ResultSet getTraningRs = null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
	  Control ct = new Control(); 
	try {  		
			getTraningSt = connection.createStatement();
			String query = "select id, volunteer_name  from volunteer_registration where approve_status='Approved' and volunteer_type='Student Head' and branch_id='"+ct.getVolunteerBranch(volunteerId)+"'";
			getTraningRs = getTraningSt.executeQuery(query);
			 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /*if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 if(getTeamsRs!=null)
					try {
						getTeamsRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
		}
	} 
	else{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
	}
	return getTraningRs;

}
public   ResultSet getMonthlyReport(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException { 
	Statement getMonthReportSt =null;
	ResultSet getMonthReportRs = null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
	  
		try {  				
				getMonthReportSt = connection.createStatement();
				String query = "select *  from month_workdairy where volunteer_registration_id="+volunteerId;
				getMonthReportRs = getMonthReportSt.executeQuery(query);
				  
			} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 /*if(getTeamsSt!=null)
					try {
						getTeamsSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 if(getTeamsRs!=null)
						try {
							getTeamsRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
		}
	else{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
	}
	return getMonthReportRs;

}
public   ResultSet getMonthlyReportGrades(HttpServletRequest request, HttpServletResponse response,String id)   throws ServletException, IOException { 
	Statement getMonthReportSt =null;
	ResultSet getMonthReportRs = null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	  
		try {  				
				getMonthReportSt = connection.createStatement();
				String query = "select *  from month_workdairy where month_work_id="+id;
				getMonthReportRs = getMonthReportSt.executeQuery(query);
				  
			} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 /*if(getTeamsSt!=null)
					try {
						getTeamsSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 if(getTeamsRs!=null)
						try {
							getTeamsRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
		}
	else{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain");
	}
	return getMonthReportRs;

}

public   ResultSet getVolunteerMonthlyReportGrades(HttpServletRequest request, HttpServletResponse response,String id)   throws ServletException, IOException { 
	Statement getMonthReportSt =null;
	ResultSet getMonthReportRs = null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
	  
		try {  				
				getMonthReportSt = connection.createStatement();
				String query = "select *  from month_workdairy where month_work_id="+id;
				getMonthReportRs = getMonthReportSt.executeQuery(query);
				  
			} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 /*if(getTeamsSt!=null)
					try {
						getTeamsSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 if(getTeamsRs!=null)
						try {
							getTeamsRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
		}
	else{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
	}
	return getMonthReportRs;

}
public   ResultSet getVolunteerMonthlyReport(HttpServletRequest request, HttpServletResponse response,String id)   throws ServletException, IOException { 
	Statement getMonthReportSt =null;
	ResultSet getMonthReportRs = null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	  
		try {  				
				getMonthReportSt = connection.createStatement();
				String query = "select *  from month_workdairy where volunteer_registration_id="+id;
				getMonthReportRs = getMonthReportSt.executeQuery(query);
				  
			} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				 /*if(getTeamsSt!=null)
					try {
						getTeamsSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 if(getTeamsRs!=null)
						try {
							getTeamsRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
		}
	else{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
	}
	return getMonthReportRs;

}
public   ResultSet getVolunteerBranchProject(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				Control ct = new Control(); 
				String branchId  = ct.getVolunteerBranch(volunteerId); 
				
				String query = "select *  from branch_project where    branch_id ='"+branchId+"' order by id desc   ";
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public  String getTeamProjectStatus(HttpServletRequest request, HttpServletResponse response, String id  ) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
	Statement getAssignProjectSt = null; 
	ResultSet getAssignProjectRs = null;
	String status =null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				
				getAssignProjectSt = connection.createStatement();
			  	String query = "select enroll_status  from team_project_enrollment where  volunteer_registration_id = '"+volunteerId+"' and team_project_id ='"+id+"'";
				String query1 = "select id  from assign_projects where team_project_id='"+id+"' and volunteer_registration_id='"+volunteerId+"'  ";
				getAssignProjectRs = getAssignProjectSt.executeQuery(query1);
				 if(!getAssignProjectRs.next())
				 {
					  getTeamProjectSt = connection.createStatement();
					  getTeamProjectRs = getTeamProjectSt.executeQuery(query);
					  if(getTeamProjectRs.next()) {
						  status = getTeamProjectRs.getString("enroll_status");
					  }
				 }
				 else 
				 {
					 status="Project Assigned";
				 }
				
				
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 if(getAssignProjectSt!=null)
					try {
						getAssignProjectSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			 if(getAssignProjectRs!=null)
					try {
						getAssignProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
		else
		{
			response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
		}
	return status;

	}
public   ResultSet getVolunteerTeamProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				Control ct = new Control();
				String team = ct.getVolunteerTeam(volunteerId);
				String branchId  = ct.getVolunteerBranch(volunteerId);
				String query = "select *  from team_project where team='"+team+"' and branch_id ='"+branchId+"' order by id desc   ";
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public  String getBranchProjectStatus(HttpServletRequest request, HttpServletResponse response, String id  ) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
	Statement getAssignProjectSt = null; 
	ResultSet getAssignProjectRs = null;
	String status =null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				
				getAssignProjectSt = connection.createStatement();
			  	String query = "select enroll_status  from branch_project_enrollment where  volunteer_registration_id = '"+volunteerId+"' and branch_project_id ='"+id+"'";
				String query1 = "select id  from assign_projects where bproject_id='"+id+"' and volunteer_registration_id='"+volunteerId+"'  ";
				getAssignProjectRs = getAssignProjectSt.executeQuery(query1);
				 if(!getAssignProjectRs.next())
				 {
					  getTeamProjectSt = connection.createStatement();
					  getTeamProjectRs = getTeamProjectSt.executeQuery(query);
					  if(getTeamProjectRs.next()) {
						  status = getTeamProjectRs.getString("enroll_status");
					  }
				 }
				 else 
				 {
					 status="Project Assigned";
				 }
				
				
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 if(getAssignProjectSt!=null)
					try {
						getAssignProjectSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			 if(getAssignProjectRs!=null)
					try {
						getAssignProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
		else
		{
			response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
		}
	return status;

	}

private void addGrievance( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String grievance = request.getParameter("grievance");
	Statement meetingTypeSt = null;
	ResultSet meetingTypeRs = null;
	 
	try {
			meetingTypeSt = connection.createStatement();
			String checkQ ="select grievance from grievance_type where grievance ='"+grievance+"'";
			meetingTypeRs = meetingTypeSt.executeQuery(checkQ);
			
			 if (meetingTypeRs.next())	{
				 response.sendRedirect("admin/index.jsp?action=GrievanceTypeExist");
			 }
			 else   {  
				PreparedStatement addCategoryPs =null;
				String query = "insert into grievance_type (grievance) values(?)";
				addCategoryPs  =  connection.prepareStatement(query);
				addCategoryPs.setString(1, grievance); 
				addCategoryPs.executeUpdate();	
				response.sendRedirect("admin/index.jsp?action=NewGrievanceTypeAdded");
  
 				  } 
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace(); 
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
public   ResultSet getGrievanceType() throws ServletException, IOException { 
	Statement meetingTypeSt =null;
	ResultSet meetingTypeRs = null;
	  
	try {  				
		meetingTypeSt = connection.createStatement();
			String query = "select grievance   from grievance_type";
			meetingTypeRs = meetingTypeSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return meetingTypeRs;

}
public   ResultSet getVmsCategory() throws ServletException, IOException { 
	Statement meetingTypeSt =null;
	ResultSet meetingTypeRs = null;
	  
	try {  				
		meetingTypeSt = connection.createStatement();
			String query = "select category   from vms_experience_category";
			meetingTypeRs = meetingTypeSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return meetingTypeRs;

}
public void submitGrievance( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
			String grievanceType = request.getParameter("grievanceType");
			String grievanceDesc = request.getParameter("grievanceDesc");
			 
			Control ct = new Control();
			String to = ct.getEmail(volunteerId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into grievance  (grievance,grievance_type, volunteer_registration_id, submit_date)values(?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, grievanceDesc); 
			assingProjectPs.setString(2, grievanceType); 
			assingProjectPs.setString(3, volunteerId); 
			assingProjectPs.setString(4,  dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Regarding Grievance  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Thank you for informing for this issue  "+grievanceDesc 
			    		  +"\n Our Team Will look forward to resolve this issue." 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("grievance.jsp?action=SubmittedGrievance");
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public   ResultSet getGrievance( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select *   from grievance where   volunteer_registration_id='"+volunteerId+"'";
					getTeamsRs = getTeamsSt.executeQuery(query);
					 
				} 
			catch (SQLException e) {
					// TODO: handle exception
				e.printStackTrace();
				}
			 catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
				}
			finally {
				
				/*if(NgoDetailSt!=null)
					try {
						NgoDetailSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		    	 
			}
		}
	return getTeamsRs;

}
private void addVmsExperienceCategory( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String category = request.getParameter("category");
	Statement meetingTypeSt = null;
	ResultSet meetingTypeRs = null;
	 
	try {
			meetingTypeSt = connection.createStatement();
			String checkQ ="select category from vms_experience_category where category ='"+category+"'";
			meetingTypeRs = meetingTypeSt.executeQuery(checkQ);
			
			 if (meetingTypeRs.next())	{
				 response.sendRedirect("admin/index.jsp?action=VmsExperienceCategoryExist");
			 }
			 else   {  
				PreparedStatement addCategoryPs =null;
				String query = "insert into vms_experience_category (category) values(?)";
				addCategoryPs  =  connection.prepareStatement(query);
				addCategoryPs.setString(1, category); 
				addCategoryPs.executeUpdate();	
				response.sendRedirect("admin/index.jsp?action=NewVMSCategorAdded");
  
 				  } 
		}  
	 catch (SQLException e) {
			// TODO: handle exceptions
		e.printStackTrace(); 
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
public void submitVmsExperience( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
			String category = request.getParameter("category");
			String experienceDesc = request.getParameter("experienceDesc");
			 
			Control ct = new Control();
			String to = ct.getEmail(volunteerId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 String status = "Unseen";
	       // result = "Sent message successfully....";  
			
			String query = "insert into vms_experience  (category,description,request_status, volunteer_registration_id, submit_date)values(?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, category); 
			assingProjectPs.setString(2, experienceDesc); 
			assingProjectPs.setString(3, status); 
			assingProjectPs.setString(4, volunteerId); 
			assingProjectPs.setString(5, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Regarding VMS Experience  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Thank you for your feedback We look forward to work on your ideas  "+experienceDesc 
			    		  +"\n We will stay in touch with you regarding the same" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("vmsExperience.jsp?action=SubmittedVMSExperience");
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public   ResultSet getVmsExperience(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from vms_experience where volunteer_registration_id = '"+volunteerId+"' limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public   ResultSet getVmsExperienceComment(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from vms_experience_comment where vms_experince_id = '"+id+"' ";
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public   ResultSet getVolunteerVmsExperienceComment(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from vms_experience_comment where vms_experince_id = '"+id+"' ";
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public void addVmsExperienceComment( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
			String comment = request.getParameter("comment"); 
			String id = request.getParameter("id"); 
			String pN = request.getParameter("pN"); 
			 
			Control ct = new Control();
			String to = "prismhack@gmail.com";
			String name = ct.getVolunteerName(volunteerId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date();  
	       // result = "Sent message successfully....";  
			
			String query = " insert into vms_experience_comment (comment,volunteer_registration_id,vms_experince_id,comment_time)  values(?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, comment); 
			assingProjectPs.setString(2, volunteerId); 
			assingProjectPs.setString(3, id);  
			assingProjectPs.setString(4, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Regarding VMS Experience Comment by "+name); 
			      message.setText("Dear Admin\n "
			    		  +"\n\n Volunteer has Send you new Comment on your VMS Experience feedback  "
			    		  +"\n  Kindly look into it!" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("viewVmsExperience.jsp?action=CommentAdded&pN="+pN);
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
 

public   ResultSet getVolunteerWorkDiary( HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		 
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select *   from workdiary where  volunteer_registration_id='"+id+"'";
					getTeamsRs = getTeamsSt.executeQuery(query);
					 
				} 
			catch (SQLException e) {
					// TODO: handle exception
				e.printStackTrace();
				}
			 catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
				}
			finally {
				
				/*if(NgoDetailSt!=null)
					try {
						NgoDetailSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		    	 
			}
		}
	return getTeamsRs;

}
public void addWorkDiaryComment( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
    ResultSet Rs=null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String comment = request.getParameter("comment"); 
			String id = request.getParameter("wId"); 
			String to=null,project=null,volunteerId=null;
			Control ct = new Control();
			  Rs = ct.getWorkDiaryVolunteerDetails(id);
			  if(Rs.next())
			  {
				  to= ct.getEmail(Rs.getString("volunteer_registration_id"));
				  project = ct.getProjectName(Rs.getString("project_id"));
				  volunteerId = Rs.getString("volunteer_registration_id");
			  }
			 
			 
	       // result = "Sent message successfully....";  
			
			String query = " update workdiary set comment = ? where id='"+id+"' ";
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, comment);   
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Regarding Your Work Diary  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your Mentor  has Commented on your Work Diary for the  project "+project 
			    		  +"\n" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("mentorVolunteerWorkDiaryView.jsp?action=CommentedOnWorkDiat&vId="+volunteerId);
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		 if(Rs!=null) {
				try {
					Rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

public   ResultSet getWorkDiaryVolunteerDetails(String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select project_id, volunteer_registration_id   from workdiary where id='"+id+"' ";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getTeamsRs;

}

public void addWorkMeetingComment( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
    ResultSet Rs=null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String comment = request.getParameter("comment"); 
			String id = request.getParameter("wId"); 
			String to=null,volunteerId=null;
			Control ct = new Control();
			String meetingType =request.getParameter("meetingType"); 
			  Rs = ct.getWorkMeetingVolunteerDetails(id);
			  if(Rs.next())
			  {
				  to= ct.getEmail(Rs.getString("volunteer_registration_id")); 
				  volunteerId = Rs.getString("volunteer_registration_id");
			  }
			 
			 
	       // result = "Sent message successfully....";  
			
			String query = " update work_meeting set comment = ? where id='"+id+"' ";
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, comment);   
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Regarding Your Work Meeting  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your Mentor  has commented on your Work Meeting for the  Meeting Type "+meetingType 
			    		  +"\n    " 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("mentorVolunteerMeetingView.jsp?action=CommentedOnMeeting&vId="+volunteerId);
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		 if(assingProjectPs!=null) {
				try {
					Rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

public   ResultSet getWorkMeetingVolunteerDetails(String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select  volunteer_registration_id   from work_meeting where id='"+id+"' ";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getTeamsRs;

}
public void addWorkTrainingComment( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
    ResultSet Rs=null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String comment = request.getParameter("comment"); 
			String id = request.getParameter("wId"); 
			String to=null,  volunteerId=null;
			Control ct = new Control();
			String trainingType =request.getParameter("trainingType"); 
			  Rs = ct.getWorkTrainingVolunteerDetails(id);
			  if(Rs.next())
			  {
				  to= ct.getEmail(Rs.getString("volunteer_registration_id")); 
				  volunteerId = Rs.getString("volunteer_registration_id");
			  }
			 
			 
	       // result = "Sent message successfully....";  
			
			String query = " update work_training set comment = ? where id='"+id+"' ";
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, comment);   
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Regarding Your Training  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your Mentor  has commented on your Training for  "+trainingType 
			    		  +"\n    " 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("mentorVolunteerTrainingView.jsp?action=CommentedOnTraining&vId="+volunteerId);
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		 if(assingProjectPs!=null) {
				try {
					Rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

public   ResultSet getWorkTrainingVolunteerDetails(String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select  volunteer_registration_id   from work_training where id='"+id+"' ";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getTeamsRs;

}
public   int getTeamProjectEnrollRequestCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null; 
	int totalCount = 0;  
	try {  				
			volunteerCountSt = connection.createStatement();
			String query ="select count(te.id) from team_project_enrollment te,  team_project t, volunteer_registration v  where te.volunteer_registration_id=v.id and t.id= te.team_project_id and te.enroll_status ='Not Approved'  and t.admin_id ='"+id+"'";
			volunteerCountRs = volunteerCountSt.executeQuery(query);
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}
public   ResultSet getTeamProjectEnrollment(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select * from team_project_enrollment te,  team_project t, volunteer_registration v  where te.volunteer_registration_id=v.id and t.id= te.team_project_id and te.enroll_status ='Not Approved'  and t.admin_id ='"+adminId+"' order by t.tproject_title limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
		 } 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public   ResultSet getBranchProjectEnrollment(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select * from branch_project_enrollment be,  branch_project b, volunteer_registration v  where v.id=be.volunteer_registration_id and b.id= be.branch_project_id and be.enroll_status ='Not Approved'  and b.admin_id ='"+adminId+"' order by  b.bproject_title  limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
		 } 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public   int getBranchProjectEnrollRequestCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null; 
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			String query ="SELECT count(branch_project_enrollment.id)  FROM branch_project_enrollment INNER JOIN branch_project ON branch_project.id = branch_project_enrollment.branch_project_id  and branch_project.admin_id='"+id+"'";
			volunteerCountRs = volunteerCountSt.executeQuery(query);
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}
public void branchProjectApproval ( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			Control ct = new Control();
			String projectId = request.getParameter("projectId");
			ResultSet teamProjectRs = ct.getBranchProject(projectId);
			String projectTitle=null,projectStartDate=null,projectEndDate=null,projectDesc=null;
			while(teamProjectRs.next())
			{
			  projectTitle = teamProjectRs.getString("bproject_title") ;
			  projectStartDate = teamProjectRs.getString("bpro_start_date") ;
			  projectEndDate = teamProjectRs.getString("bpro_end_date") ;
			  projectDesc = teamProjectRs.getString("bproject_desc") ;
			}
			String enrollId = request.getParameter("enrollId");
			PreparedStatement ps = null;
		 
			
			String query1 = "update branch_project_enrollment set enroll_status = ? where id ="+enrollId ;
			String status = "Approved";
			ps = connection.prepareStatement(query1);
			ps.setString(1, status ); 
			ps.executeUpdate();
			ps.close();
			
			String vId[] = request.getParameterValues("vIds");
			for(int i=0; i<vId.length;i++) {
			 
			String to = ct.getEmail(vId[i]);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";   
			
			String query = "insert into assign_projects  (volunteer_registration_id,project_title, project_desc, project_start_date,project_end_date,bproject_id,admin_id,assign_date) values(?,?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, vId[i]); 
			assingProjectPs.setString(2, projectTitle); 
			assingProjectPs.setString(3, projectDesc); 
			assingProjectPs.setString(4, projectStartDate); 
			assingProjectPs.setString(5, projectEndDate); 
			assingProjectPs.setString(6, projectId); 
			assingProjectPs.setString(7, adminId);  
			assingProjectPs.setString(8, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Branch Project Enroll Request "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your request for the Branch Project is Approved and Project  "+projectTitle+"Also Assigned to you" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
			}
			response.sendRedirect("branchProjectEnrollRequestView.jsp?action=RequestApproved&pN=1");
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void teamProjectApproval( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			Control ct = new Control();
			String projectId = request.getParameter("projectId");
			ResultSet teamProjectRs = ct.getTeamProject(projectId);
			String projectTitle=null,projectStartDate=null,projectEndDate=null,projectDesc=null;
			while(teamProjectRs.next())
			{
			  projectTitle = teamProjectRs.getString("tproject_title") ;
			  projectStartDate = teamProjectRs.getString("tpro_start_date") ;
			  projectEndDate = teamProjectRs.getString("tpro_end_date") ;
			  projectDesc = teamProjectRs.getString("tproject_desc") ;
			}
			String enrollId = request.getParameter("enrollId");
			PreparedStatement ps = null;
		  
			String query1 = "update team_project_enrollment set enroll_status = ? where id ="+enrollId ;
			String status = "Approved";
			ps = connection.prepareStatement(query1);
			ps.setString(1, status ); 
			ps.executeUpdate();
			ps.close();
		 
			String vId[] = request.getParameterValues("vIds");
			for(int i=0; i<vId.length;i++) {
			
			 
			String to = ct.getEmail(vId[i]);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into assign_projects  (volunteer_registration_id,project_title, project_desc, project_start_date,project_end_date,team_project_id,admin_id,assign_date) values(?,?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, vId[i]); 
			assingProjectPs.setString(2, projectTitle); 
			assingProjectPs.setString(3, projectDesc); 
			assingProjectPs.setString(4, projectStartDate); 
			assingProjectPs.setString(5, projectEndDate); 
			assingProjectPs.setString(6, projectId); 
			assingProjectPs.setString(7, adminId);  
			assingProjectPs.setString(8, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Team Project Enroll Request"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your Team Project Enroll Request has been Approved and project "+projectTitle+" is also assigned to you." 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
			}
			response.sendRedirect("teamProjectEnrollRequestView.jsp?action=TeamProjectApproved&pN=1");
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void mentorVmsExperience( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String category = request.getParameter("category");
			String experienceDesc = request.getParameter("experienceDesc");
			 
			Control ct = new Control();
			String to = ct.getMentorEmail(adminId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 String status = "Unseen";
	       // result = "Sent message successfully....";  
			
			String query = "insert into vms_experience  (category,description,request_status, admin_id, submit_date)values(?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, category); 
			assingProjectPs.setString(2, experienceDesc); 
			assingProjectPs.setString(3, status); 
			assingProjectPs.setString(4, adminId); 
			assingProjectPs.setString(5, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Regarding VMS Experience  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Thank you for your feedback We look forward to work on your ideas  "+experienceDesc 
			    		  +"\n We will stay in touch with you regarding the same" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("mentorVmsExperience.jsp?action=SubmitExperienced");
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}



public   int volunteerVmsExperienceCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from vms_experience where volunteer_registration_id='"+id+"' ");
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}

public   int mentorVmsExperienceCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from vms_experience where admin_id='"+id+"' ");
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}

public   ResultSet getMentorVmsExperience(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from vms_experience where admin_id = '"+adminId+"' order by id desc limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
 
public void addMentorVmsExperienceComment( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String comment = request.getParameter("comment"); 
			String id = request.getParameter("id"); 
			 
			  
			String to = "prismhack@gmail.com";
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date();  
	       // result = "Sent message successfully....";  
			Control ct = new Control();
			String name = ct.getMentorName(adminId);
			String query = " insert into vms_experience_comment (comment,admin_id,vms_experince_id,comment_time)  values(?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, comment); 
			assingProjectPs.setString(2, adminId); 
			assingProjectPs.setString(3, id);  
			assingProjectPs.setString(4, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Regarding VMS Experience Comment by "+name); 
			      message.setText("Dear Sir/Ma'am\n "
			    		  +"\n\n Mentor has Send you new Comment on your VMS Experience feedback  "
			    		  +"\n We will keep you inform about your VMS Experience" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("mentorVmsExperienceView.jsp?action=SubmitExperienceComment&pN=1");
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void gradeMonthlyReport( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			Control ct = new Control();
			 
			Statement st=null;
			String id=request.getParameter("monthrpt_id");
			String s1=request.getParameter("creativity");
			String s2=request.getParameter("punctuality");
			String s3=request.getParameter("work_ethic");
			String s4=request.getParameter("qual_of_work");
			String s5=request.getParameter("reliability");
			String s6=request.getParameter("decision_making");
			String s7= request.getParameter("promtness");
			String s8= request.getParameter("involvement");
			String s9= request.getParameter("up_of_skill");
			String s10= request.getParameter("overall_growth");
			String s11= request.getParameter("comment");
			String s12 = request.getParameter("total");
			String status ="Graded";
			  st= connection.createStatement(); 
			 
			 int n =st.executeUpdate("update month_workdairy set report_status='"+status+"', creativity ='"+s1+"',Punctuality='"+s2+"',work_ethics='"+s3+"',quality_work='"+s4+"',reliability='"+s5+"',decision_making='"+s6+"',promptness='"+s7+"',involvement='"+s8+"',upgradation_of_skills='"+s9+"',overall_growth='"+s10+"', comment='"+s11+"',total='"+s12+"' where month_work_id='"+id+"'"); 
			 
		 
			String vId[] = request.getParameterValues("vIds");
			for(int i=0; i<vId.length;i++) {
			
			 
			String to = ct.getEmail(vId[i]);
			
 			
	       // result = "Sent message successfully....";  
			
			 	
	
		  	String from = "kapil.thakur1496@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("Monthly Report Grading"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n  Your monthly report  has been graded. Please login to check your grades." 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
			 
			response.sendRedirect("viewVolunteerMonyhlyReport.jsp?vId="+vId[i]);
			}
			}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void mentorForgotPassword( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    String email=request.getParameter("email");  
	Statement checkMentorSt = null;
	ResultSet checkMentorRs = null; 
	PreparedStatement updatePassDatePs =null;
try {  
	checkMentorSt = connection.createStatement();
	String mentorId=null;
 	String checkQ = "select id as mentorId from admin  where email ='"+email+"' and approve_status= 'Approved'  ";
 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
	
 	if (checkMentorRs.next()) { 
 	 mentorId = checkMentorRs.getString("mentorId");
 	 Random rnd = new Random();
	 int rand = 100000 + rnd.nextInt(90000); 
	 
	 String otp = Integer.toString(rand);
	 
	 
			  
			     // result = "Sent message successfully....";  
			String to = email;
			  	String from = "prismhack@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("PrismVMS Update Password"); 
			      message.setText("Dear Sir/Ma'am\n "
			    		  +"\n\n Your otp is "+otp
			    		    +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			      
			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 HttpSession session = request.getSession(); 
			 session.setAttribute("otp", otp); 
			String query = "update admin set password_set=? where id = "+mentorId;
			updatePassDatePs  =  connection.prepareStatement(query);
			updatePassDatePs.setString(1,  dateFormat.format(date));  
			updatePassDatePs.executeUpdate(); 
			      
			   response.sendRedirect("mentorForgotPassword.jsp?action=otpVarification&email="+email);
			  
	   						  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   }
   		 
			
 	}
 else{     
	 response.sendRedirect("adminLogin.jsp?action=AccountDoesNotExist");
 }
	 
}  
catch (SQLException e) {
	// TODO: handle exception
e.printStackTrace();
}
catch (Exception e) {
	// TODO: handle exception
	 e.printStackTrace();
}
finally {
 if(checkMentorSt!=null) {
		try {
			checkMentorSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		}
 if(checkMentorRs!=null) {
		try {
			checkMentorRs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	 
	 
	if(updatePassDatePs!=null) {
		try {
			updatePassDatePs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
out.close();
}
public void adminForgotPassword( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    String email=request.getParameter("email");  
	Statement checkMentorSt = null;
	ResultSet checkMentorRs = null; 
	PreparedStatement updatePassDatePs =null;
try {  
	checkMentorSt = connection.createStatement();
	String mentorId=null;
 	String checkQ = "select id as mentorId from admin  where email ='"+email+"' and approve_status= 'Approved'  ";
 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
	
 	if (checkMentorRs.next()) { 
 	 mentorId = checkMentorRs.getString("mentorId");
 	 Random rnd = new Random();
	 int rand = 100000 + rnd.nextInt(90000); 
	 
	 String otp = Integer.toString(rand);
	 
	 
			  
			     // result = "Sent message successfully....";  
			String to = email;
			  	String from = "prismhack@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("PrismVMS Update Password"); 
			      message.setText("Dear Sir/Ma'am\n "
			    		  +"\n\n Your otp is "+otp
			    		    +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			      
			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 HttpSession session = request.getSession(); 
			 session.setAttribute("otp", otp); 
			String query = "update admin set password_set=? where id = "+mentorId;
			updatePassDatePs  =  connection.prepareStatement(query);
			updatePassDatePs.setString(1,  dateFormat.format(date));  
			updatePassDatePs.executeUpdate(); 
			      
			   response.sendRedirect("admin/mentorForgotPassword.jsp?action=otpVarification&email="+email);
			  
	   						  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   }
   		 
			
 	}
 else{     
	 response.sendRedirect("admin/adminLogin.jsp?action=AccountDoesNotExist");
 }
	 
}  
catch (SQLException e) {
	// TODO: handle exception
e.printStackTrace();
}
catch (Exception e) {
	// TODO: handle exception
	 e.printStackTrace();
}
finally {
 if(checkMentorSt!=null) {
		try {
			checkMentorSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		}
 if(checkMentorRs!=null) {
		try {
			checkMentorRs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	 
	 
	if(updatePassDatePs!=null) {
		try {
			updatePassDatePs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
out.close();
}
public   void forgotOtpVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 try {  				
			String otp = request.getParameter("otp");
			String email = request.getParameter("email");
			
			HttpSession session = request.getSession();   
	        String checkOtp = (String)session.getAttribute("otp");
	        if(checkOtp==null) {
	        	response.sendRedirect("mentorForgotPassword.jsp?action=OtpExpired");
	        }
	        if(checkOtp.equals(otp)) {
	        
				volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select id  from admin where email ='"+email+"' ");
				PreparedStatement updatePassDatePs =null;
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
		 			
				if(password.equals(confirmPassword) ) { 
					if(volunteerCountRs.next()) {
					
						String query = "update admin  set password=?,password_set=? where id = "+volunteerCountRs.getString("id");
						updatePassDatePs  =  connection.prepareStatement(query);
						updatePassDatePs.setString(1, password);  
						updatePassDatePs.setString(2, dateFormat.format(date));  
						
						updatePassDatePs.executeUpdate();	
						response.sendRedirect("adminLogin.jsp?action=useNewPassword");
					
					}
		        }else
		        {
		        	response.sendRedirect("mentorForgotPassword.jsp?action=PasswordAndConfirmPasswordNotMactched");
		        } 
	        }else
	        {
				 response.sendRedirect("mentorForgotPassword.jsp?action=otpIsNotCorrect");
	        }
	         
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}  
		
}
public   void adminforgotOtpVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 try {  				
			String otp = request.getParameter("otp");
			String email = request.getParameter("email");
			
			HttpSession session = request.getSession();   
	        String checkOtp = (String)session.getAttribute("otp");
	        if(checkOtp==null) {
	        	response.sendRedirect("admin/mentorForgotPassword.jsp?action=OtpExpired");
	        }
	        if(checkOtp.equals(otp)) {
	        
				volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select id  from admin where email ='"+email+"' ");
				PreparedStatement updatePassDatePs =null;
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
		 			
				if(password.equals(confirmPassword) ) { 
					if(volunteerCountRs.next()) {
					
						String query = "update admin  set password=?,password_set=? where id = "+volunteerCountRs.getString("id");
						updatePassDatePs  =  connection.prepareStatement(query);
						updatePassDatePs.setString(1, password);  
						updatePassDatePs.setString(2, dateFormat.format(date));  
						
						updatePassDatePs.executeUpdate();	
						response.sendRedirect("admin/adminLogin.jsp?action=useNewPassword");
					
					}
		        }else
		        {
		        	response.sendRedirect("admin/mentorForgotPassword.jsp?action=PasswordAndConfirmPasswordNotMactched");
		        } 
	        }else
	        {
				 response.sendRedirect("admin/mentorForgotPassword.jsp?action=otpIsNotCorrect");
	        }
	         
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}  
		
}
public void volunteerForgotPassword( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    String email=request.getParameter("email");  
	Statement checkMentorSt = null;
	ResultSet checkMentorRs = null; 
	PreparedStatement updatePassDatePs =null;
try {  
	checkMentorSt = connection.createStatement();
	String mentorId=null;
 	String checkQ = "select id as volunteerId from volunteer_registration  where email_id ='"+email+"' and approve_status= 'Approved'  ";
 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
	
 	if (checkMentorRs.next()) { 
 	 mentorId = checkMentorRs.getString("volunteerId");
 	 Random rnd = new Random();
	 int rand = 100000 + rnd.nextInt(90000); 
	 
	 String otp = Integer.toString(rand);
	 
	 
			  
			     // result = "Sent message successfully....";  
			String to = email;
			  	String from = "prismhack@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("PrismVMS Update Password"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your otp is "+otp
			    		    +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			      
			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 HttpSession session = request.getSession(); 
			 session.setAttribute("otp", otp); 
			String query = "update volunteer_registration set pasword_set=? where id = "+mentorId;
			updatePassDatePs  =  connection.prepareStatement(query);
			updatePassDatePs.setString(1,  dateFormat.format(date));  
			updatePassDatePs.executeUpdate(); 
			      
		   response.sendRedirect("volunteerForgotPassword.jsp?action=otpVarification&email="+email);
			   		  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   }
   		 
			
 	}
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=AccountDoesNotExist");
 }
	 
}  
catch (SQLException e) {
	// TODO: handle exception
e.printStackTrace();
}
catch (Exception e) {
	// TODO: handle exception
	 e.printStackTrace();
}
finally {
 if(checkMentorSt!=null) {
		try {
			checkMentorSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		}
 if(checkMentorRs!=null) {
		try {
			checkMentorRs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	 
	 
	if(updatePassDatePs!=null) {
		try {
			updatePassDatePs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
out.close();
}

public   void volunteerForgotOtpVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 try {  				
			String otp = request.getParameter("otp");
			String email = request.getParameter("email");
			
			HttpSession session = request.getSession();   
	        String checkOtp = (String)session.getAttribute("otp");
	        if(checkOtp==null) {
	        	response.sendRedirect("volunteerForgotPassword.jsp?action=OtpExpired");
	        }
	        
	        if(checkOtp.equals(otp)) {
	        
				volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select id  from volunteer_registration where email_id ='"+email+"' ");
				PreparedStatement updatePassDatePs =null;
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
		 			
				if(password.equals(confirmPassword) ) { 
					if(volunteerCountRs.next()) {
					
						String query = "update volunteer_registration  set password=?,pasword_set=? where id = "+volunteerCountRs.getString("id");
						updatePassDatePs  =  connection.prepareStatement(query);
						updatePassDatePs.setString(1, password);  
						updatePassDatePs.setString(2, dateFormat.format(date));  
						
						updatePassDatePs.executeUpdate();	
						response.sendRedirect("volunteerLogin.jsp?action=useNewPassword");
					
					}
		        }else
		        {
		        	response.sendRedirect("volunteerForgotPassword.jsp?action=PasswordAndConfirmPasswordNotMactched");
		        } 
	        }else
	        {
				 response.sendRedirect("volunteerForgotPassword.jsp?action=otpIsNotCorrect&email="+email);
	        }
	         
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}  
		
}

public void preVolunteerForgotPassword( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    String email=request.getParameter("email");  
	Statement checkMentorSt = null;
	ResultSet checkMentorRs = null; 
	PreparedStatement updatePassDatePs =null;
try {  
	checkMentorSt = connection.createStatement();
	String mentorId=null;
 	String checkQ = "select id as volunteerId from volunteer_registration  where email_id ='"+email+"'    ";
 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
	
 	if (checkMentorRs.next()) { 
 	 mentorId = checkMentorRs.getString("volunteerId");
 	 Random rnd = new Random();
	 int rand = 100000 + rnd.nextInt(90000); 
	 
	 String otp = Integer.toString(rand);
	 
	 
			  
			     // result = "Sent message successfully....";  
			String to = email;
			  	String from = "prismhack@gmail.com";
   			Properties props = System.getProperties();
   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
   			props.setProperty("mail.smtp.port", "465");
   			props.setProperty("mail.smtp.socketFactory.port", "465");
   			props.put("mail.smtp.auth", "true");
   			props.put("mail.debug", "true");
   			props.put("mail.store.protocol", "pop3");
   			props.put("mail.transport.protocol", "smtp");
   			final String username = "prismhack@gmail.com";
   			final String password = "code2win";
		       
			   try{
			   		Session mySession = Session.getInstance(props, new Authenticator(){
			   			 
			   			protected PasswordAuthentication getPasswordAuthentication() {
			   				return new PasswordAuthentication(username, password);
						} 
			   			
					});

			      MimeMessage message = new MimeMessage(mySession); 
			      message.setFrom(new InternetAddress(from)); 
			      message.addRecipient(Message.RecipientType.TO,
			                               new InternetAddress(to)); 
			      message.setSubject("PrismVMS Update Password"); 
			      message.setText("Dear Applicant\n "
			    		  +"\n\n Your otp is "+otp
			    		    +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			      
			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 HttpSession session = request.getSession(); 
			 session.setAttribute("otp", otp); 
			String query = "update volunteer_registration set pasword_set=? where id = "+mentorId;
			updatePassDatePs  =  connection.prepareStatement(query);
			updatePassDatePs.setString(1,  dateFormat.format(date));  
			updatePassDatePs.executeUpdate(); 
			      
		   response.sendRedirect("volunteerPreForgotPassword.jsp?action=otpVarification&email="+email);
			   		  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   }
   		 
			
 	}
 else{     
	 response.sendRedirect("volunteerPreLogin.jsp?action=AccountDoesNotExist");
 }
	 
}  
catch (SQLException e) {
	// TODO: handle exception
e.printStackTrace();
}
catch (Exception e) {
	// TODO: handle exception
	 e.printStackTrace();
}
finally {
 if(checkMentorSt!=null) {
		try {
			checkMentorSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		}
 if(checkMentorRs!=null) {
		try {
			checkMentorRs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	 
	 
	if(updatePassDatePs!=null) {
		try {
			updatePassDatePs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
out.close();
}
public   void preVolunteerForgotOtpVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 try {  				
			String otp = request.getParameter("otp");
			String email = request.getParameter("email");
			
			HttpSession session = request.getSession();   
	        String checkOtp = (String)session.getAttribute("otp");
	        if(checkOtp==null) {
	        	response.sendRedirect("volunteerPreForgotPassword.jsp?action=OtpExpired");
	        }
	        
	        if(checkOtp.equals(otp)) {
	        
				volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select id  from volunteer_registration where email_id ='"+email+"' ");
				PreparedStatement updatePassDatePs =null;
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
		 			
				if(password.equals(confirmPassword) ) { 
					if(volunteerCountRs.next()) {
					
						String query = "update volunteer_registration  set password=?,pasword_set=? where id = "+volunteerCountRs.getString("id");
						updatePassDatePs  =  connection.prepareStatement(query);
						updatePassDatePs.setString(1, password);  
						updatePassDatePs.setString(2, dateFormat.format(date));  
						
						updatePassDatePs.executeUpdate();	
						response.sendRedirect("volunteerPreLogin.jsp?action=useNewPassword");
					
					}
		        }else
		        {
		        	response.sendRedirect("volunteerPreForgotPassword.jsp?action=PasswordAndConfirmPasswordNotMactched");
		        } 
	        }else
	        {
				 response.sendRedirect("volunteerPreForgotPassword.jsp?action=otpIsNotCorrect&email="+email);
	        }
	         
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}  
		
}
public void submitCoreMeeting( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("adminId");
	if(volunteerId !=null) {
		try {  
			Control ct = new Control();
			String branchId = ct.getMenorBranch(volunteerId);
			String meetDate = request.getParameter("date");
			String duration = request.getParameter("duration");
			String meet_called_by = request.getParameter("meet_called_by");
			String faci = request.getParameter("faci");
			String discussion = request.getParameter("discussion");
			String venue = request.getParameter("venue");
			String meetType = request.getParameter("meet_type");
			String note = request.getParameter("note");
			String topic = request.getParameter("topic");
			String action = request.getParameter("action"); 
			String mentorIds[] = request.getParameterValues("mentorIds"); 
			String absentees = "";
			String absenteesIds = "";
			for(int i =0; i<mentorIds.length;i++)
			{
				absentees = absentees+ct.getMentorName(mentorIds[i])+" , ";
				absenteesIds = absenteesIds+","+mentorIds[i];
			}
			absenteesIds = absenteesIds.substring(1,absenteesIds.length());
			Statement mentorNSt = connection.createStatement();
			String query = "select  name from admin where approve_status='Approved' and id not in("+absenteesIds+") and branch_id='"+branchId+"'";
			ResultSet  mentorNRs = mentorNSt.executeQuery(query);
			absentees = absentees.substring(0, absentees.length()-3);
			String attendees = "";
			while(mentorNRs.next())
			{
				attendees = attendees+mentorNRs.getString("name")+" , "; 
			}
			attendees = attendees.substring(0, attendees.length()-3);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";
			
			String query1 = "insert into sub_admin_minutes_meeting(meeting_date,venue,duration,meeting_type,meeting_called_by,facilitator,note_taken,attendees,absentees,topics,discussion,submit_date,action,admin_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			assingProjectPs = connection.prepareStatement(query1);
			assingProjectPs.setString(1, meetDate); 
			assingProjectPs.setString(2, venue); 
			assingProjectPs.setString(3, duration); 
			assingProjectPs.setString(4, meetType); 
			assingProjectPs.setString(5, meet_called_by); 
			assingProjectPs.setString(6, faci); 
			assingProjectPs.setString(7, note); 
			assingProjectPs.setString(8, attendees);			
			assingProjectPs.setString(9, absentees);
			assingProjectPs.setString(10, topic);
			assingProjectPs.setString(11, discussion);
			assingProjectPs.setString(12, dateFormat.format(date));
			assingProjectPs.setString(13, action); 
			assingProjectPs.setString(14, volunteerId); 
			assingProjectPs.executeUpdate();	
			ResultSet emailRs= ct.getMentorDesignationEmails(volunteerId);
			 
			 while(emailRs.next()) {
				  
				 String from = "prismhack@gmail.com";
					Properties props = System.getProperties();
					props.setProperty("mail.smtp.host", "smtp.gmail.com");
					props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					props.setProperty("mail.smtp.socketFactory.fallback", "false");
					props.setProperty("mail.smtp.port", "465");
					props.setProperty("mail.smtp.socketFactory.port", "465");
					props.put("mail.smtp.auth", "true");
					props.put("mail.debug", "true");
					props.put("mail.store.protocol", "pop3");
					props.put("mail.transport.protocol", "smtp");
					final String username = "prismhack@gmail.com";
					final String password = "code2win";
			       
				   try{
				   		Session mySession = Session.getInstance(props, new Authenticator(){
				   			 
				   			protected PasswordAuthentication getPasswordAuthentication() {
				   				return new PasswordAuthentication(username, password);
							} 
				   			
						});
				   	 MimeMessage message = new MimeMessage(mySession); 
				     
				      
				      message.addRecipient(Message.RecipientType.BCC,
				              new InternetAddress(emailRs.getString("email")));
				      message.setFrom(new InternetAddress(from)); 

				      /*MimeMessage message = new MimeMessage(mySession); 
				      message.setFrom(new InternetAddress(from)); 
				      message.addRecipient(Message.RecipientType.TO,
				                               new InternetAddress(to)); */
				      message.setSubject("Minutes of Meeting for Core Minutes on "+meetDate); 
				      message.setText("Dear Mentors \n\n "
				    		  +ct.getMentorName(volunteerId)+" has submitted the minutes of meeting for the  Core meeting on "+meetDate
				    		  
				    		  +"\n\nWarm Regards"
				    		  +"\n\n\nPrismVMS"
				    		   );
				      
				      Transport.send(message);
				     
				   }
				// result = "Sent message successfully....";  
				      catch (MessagingException mex) {
					      mex.printStackTrace();
					      //result = "Error: unable to send message....";
					   }
			  
			 }
			 response.sendRedirect("coreMeeting.jsp?action=coreMeetingSubmitted");
		
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void submitStudentHeadMeeting( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
			Control ct = new Control();
			String branchId = ct.getVolunteerBranch(volunteerId);
			String meetDate = request.getParameter("date");
			String duration = request.getParameter("duration");
			String meet_called_by = request.getParameter("meet_called_by");
			String faci = request.getParameter("faci");
			String discussion = request.getParameter("discussion");
			String venue = request.getParameter("vanue");
			String meetType = request.getParameter("meet_type");
			String note = request.getParameter("note");
			String topic = request.getParameter("topic");
			String action = request.getParameter("action"); 
			String mentorIds[] = request.getParameterValues("volunteerIds"); 
			String absentees = "";
			String attendees = "";
			String teamName="";
			ResultSet emailRs = null;
			if(meetType.equals("Team Meeting")) {
			String team = ct.getVolunteerTeam(volunteerId);
			teamName =team;
			String absenteesIds = "";
			for(int i =0; i<mentorIds.length;i++)
			{
				absentees = absentees+ct.getVolunteerName(mentorIds[i])+" , ";
				absenteesIds = absenteesIds+","+mentorIds[i];				
			}
			absenteesIds = absenteesIds.substring(1,absenteesIds.length());
			Statement mentorNSt = connection.createStatement();
			String query = "select  volunteer_name from volunteer_registration where approve_status='Approved' and team='"+team+"' and id not in("+absenteesIds+") and branch_id='"+branchId+"'";
			ResultSet  mentorNRs = mentorNSt.executeQuery(query);
			absentees = absentees.substring(0, absentees.length()-3);
			
			while(mentorNRs.next())
			{
				attendees = attendees+mentorNRs.getString("volunteer_name")+" , "; 
			}
			attendees = attendees.substring(0, attendees.length()-3);
			 emailRs= ct.getMentorDesignationEmailsForStudentHeadMeeting(volunteerId);
			}
			else if(meetType.equals("Student Head Meeting"))
			{			 
				String absenteesIds = "";
				for(int i =0; i<mentorIds.length;i++)
				{
					absentees = absentees+ct.getVolunteerName(mentorIds[i])+" , ";
					absenteesIds = absenteesIds+","+mentorIds[i];				
				}
				absenteesIds = absenteesIds.substring(1,absenteesIds.length());
				Statement mentorNSt = connection.createStatement();
				String query = "select  volunteer_name from volunteer_registration where approve_status='Approved' and volunteer_type='Student Head' and id not in("+absenteesIds+") and branch_id='"+branchId+"'";
				ResultSet  mentorNRs = mentorNSt.executeQuery(query);
				absentees = absentees.substring(0, absentees.length()-3);
				while(mentorNRs.next())
				{
					attendees = attendees+mentorNRs.getString("volunteer_name")+" , "; 
				}
				attendees = attendees.substring(0, attendees.length()-3);
				emailRs= ct.getBranchCordinatorEmail(volunteerId);
			}
			
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query1 = "insert into student_head_meeting (meeting_date,venue,duration,meeting_type,"
					+ "meeting_called_by,facilitator,note_taken,attendees,absentees,topics,discussion,"
					+ "submit_date,action,volunteer_registration_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			assingProjectPs = connection.prepareStatement(query1);
			assingProjectPs.setString(1, meetDate); 
			assingProjectPs.setString(2, venue); 
			assingProjectPs.setString(3, duration); 
			assingProjectPs.setString(4, meetType); 
			assingProjectPs.setString(5, meet_called_by); 
			assingProjectPs.setString(6, faci); 
			assingProjectPs.setString(7, note); 
			assingProjectPs.setString(8, attendees);			
			assingProjectPs.setString(9, absentees);
			assingProjectPs.setString(10, topic);
			assingProjectPs.setString(11, discussion);
			assingProjectPs.setString(12, dateFormat.format(date));
			assingProjectPs.setString(13, action); 
			assingProjectPs.setString(14, volunteerId); 
			assingProjectPs.executeUpdate();	
			   
			
			 
			 while(emailRs.next()) {
				  
				 String from = "prismhack@gmail.com";
					Properties props = System.getProperties();
					props.setProperty("mail.smtp.host", "smtp.gmail.com");
					props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					props.setProperty("mail.smtp.socketFactory.fallback", "false");
					props.setProperty("mail.smtp.port", "465");
					props.setProperty("mail.smtp.socketFactory.port", "465");
					props.put("mail.smtp.auth", "true");
					props.put("mail.debug", "true");
					props.put("mail.store.protocol", "pop3");
					props.put("mail.transport.protocol", "smtp");
					final String username = "prismhack@gmail.com";
					final String password = "code2win";
			       
				   try{
				   		Session mySession = Session.getInstance(props, new Authenticator(){
				   			 
				   			protected PasswordAuthentication getPasswordAuthentication() {
				   				return new PasswordAuthentication(username, password);
							} 
				   			
						});
				   	 MimeMessage message = new MimeMessage(mySession); 
				     
				      
				      message.addRecipient(Message.RecipientType.BCC,
				              new InternetAddress(emailRs.getString("email")));
				      message.setFrom(new InternetAddress(from)); 

				      /*MimeMessage message = new MimeMessage(mySession); 
				      message.setFrom(new InternetAddress(from)); 
				      message.addRecipient(Message.RecipientType.TO,
				                               new InternetAddress(to)); */
				      if(meetType.equals("Team Meeting")) {
				      message.setSubject("Minutes of meeting "+teamName+" "+meetType); 
				      message.setText("Dear Mentor\n \n"
				    		  +ct.getVolunteerName(volunteerId)+" has submitted the minutes of meeting  for the "+meetType+" on "+meetDate
				    		  
				    		  +"\n\nWarm Regards"
				    		  +"\n\nPrismVMS"
				    		   );
				      }
				      else if(meetType.equals("Student Head Meeting"))
				      {

					      message.setSubject("Minutes of meeting for Student Head Meeting"); 
					      message.setText("Dear Mentor\n \n"
					    		  +ct.getVolunteerName(volunteerId)+" has submitted the minutes of meeting  for the "+meetType+" on "+meetDate
					    		  
					    		  +"\n\nWarm Regards"
					    		  +"\n\nPrismVMS"
					    		   );
				    	  
				      }
				      Transport.send(message);
				     
				   }
				// result = "Sent message successfully....";  
				      catch (MessagingException mex) {
					      mex.printStackTrace();
					      //result = "Error: unable to send message....";
					   }
			 }
			 response.sendRedirect("teamMeeting.jsp?action=minutesOfMeetingSubmitted");
		
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
} 
public   ResultSet getBranchCordinatorEmail(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  
	try {  		
			Control ct = new Control();
			getTeamsSt = connection.createStatement();
			String query = "select email from admin where admin_type = 'Branch Co-ordinator'   and  branch_id ='"+ct.getVolunteerBranch(id)+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getTeamsRs;

	}
public   ResultSet getStudentHeadMeeting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 

	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId!= null) {
		
		try {
			Control ct= new Control();
  		 	volunteerCountSt = connection.createStatement();
			volunteerCountRs = volunteerCountSt.executeQuery("select * from student_head_meeting s inner join volunteer_registration v on s.volunteer_registration_id = v.id  and v.branch_id='"+ct.getVolunteerBranch(volunteerId)+"'   order by s.id desc ");
		 		
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				/* if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
	}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
return volunteerCountRs; 
}

public   ResultSet getTeamMateAttend(String names,String team, String branchId) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
			
		try {
  		 	volunteerCountSt = connection.createStatement();
			volunteerCountRs = volunteerCountSt.executeQuery("select volunteer_name from volunteer_registration where  volunteer_name not in("+names+") and approve_status='Approved' and team ='"+team+"' and branch_id='"+branchId+"'      ");
		 		
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				/* if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
	
		return volunteerCountRs; 
	}
public   ResultSet getStudentHeadAttend(String names,String team, String branchId) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
			
		try {
  		 	volunteerCountSt = connection.createStatement();
			volunteerCountRs = volunteerCountSt.executeQuery("select volunteer_name from volunteer_registration where volunteer_name not in("+names+") and approve_status='Approved' and volunteer_type='Student Head'  and branch_id='"+branchId+"'      ");
		 		
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			finally {
				
				/* if(volunteerCountSt!=null)
					try {
						volunteerCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(volunteerCountRs!=null)
						try {
							volunteerCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
	
		return volunteerCountRs; 
	}
}
 
 