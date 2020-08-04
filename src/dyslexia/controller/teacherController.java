package dyslexia.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dyslexia.dao.teacherDAO;
import dyslexia.model.teacherBean;

@WebServlet("/teacherController")
public class teacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String action;
	teacherBean teacherB = new teacherBean();
	teacherDAO teacherD = new teacherDAO();
       

    public teacherController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action.equalsIgnoreCase("logout")) {
			session.setAttribute("teacherIC", null);
    		session.setAttribute("teacherName", null);
    		session.setAttribute("teacherRole", null);
    		session.invalidate();
    		response.sendRedirect("index.jsp");
		}
		else if(action.equalsIgnoreCase("viewOwnAccount")) {
			String icNum = (String) session.getAttribute("teacherIC");
			teacherBean teacherB = new teacherBean();
			teacherB.setTeacherICNumber(icNum);
			teacherB = teacherD.getTeacherByIC(icNum);
			request.setAttribute("teacherB", teacherB);
			RequestDispatcher view = request.getRequestDispatcher("viewOwnProfileTeacher.jsp");
			view.forward(request, response);
		}
		else if(action.equalsIgnoreCase("viewUpdateOwnAccount")) {
			String icNum = (String) session.getAttribute("teacherIC");
			teacherBean teacherB = new teacherBean();
			teacherB.setTeacherICNumber(icNum);
			teacherB = teacherD.getTeacherByIC(icNum);
			request.setAttribute("teacherB", teacherB);
			RequestDispatcher view = request.getRequestDispatcher("updateOwnProfile.jsp");
			view.forward(request, response);
		}
		else if(action.equalsIgnoreCase("viewUpdateTeacher")) {
			String icNum = request.getParameter("ic");
			teacherBean teacherB = new teacherBean();
			teacherB.setTeacherICNumber(icNum);
			teacherB = teacherD.getTeacherByIC(icNum);
			request.setAttribute("teacherB", teacherB);
			RequestDispatcher view = request.getRequestDispatcher("updateOwnProfile.jsp");
			view.forward(request, response);
		}
		else if(action.equalsIgnoreCase("listViewTeacher")) {
			teacherDAO teacherD = new teacherDAO();
			List<teacherBean> teacherB = teacherD.getAllTeachers();
			request.setAttribute("teacherB", teacherB);
			RequestDispatcher view = request.getRequestDispatcher("listTeacher.jsp");
			view.forward(request, response);
		}
		else if(action.equalsIgnoreCase("viewTeacher")) {
			String icNum = request.getParameter("ic");
			teacherBean teacherB = new teacherBean();
			teacherB.setTeacherICNumber(icNum);
			teacherB = teacherD.getTeacherByIC2(icNum);
			request.setAttribute("teacherB", teacherB);
			RequestDispatcher view = request.getRequestDispatcher("viewTeacher.jsp");
			view.forward(request, response);
		}
		else if(action.equalsIgnoreCase("deleteTeacher")) {
			String ic = request.getParameter("ic");
			teacherBean teacherB = new teacherBean();
			teacherB.setTeacherICNumber(ic);
			teacherD.deleteTeacher(ic);
			response.sendRedirect("home.jsp");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action.equalsIgnoreCase("login")) {
			String ic = request.getParameter("ic");
			String password = request.getParameter("password");
		
			teacherB.setTeacherICNumber(ic);
			teacherB.setTeacherPassword(password);
			
			teacherB = teacherD.teacherLogin(teacherB);
			
			if(teacherB.isValid()) {
				session.setAttribute("teacherIC", teacherB.getTeacherICNumber());
				session.setAttribute("teacherName",teacherB.getTeacherName());
				session.setAttribute("teacherRole", teacherB.getTeacherRole());
				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);
			}
			else {
				RequestDispatcher view = request.getRequestDispatcher("index.jsp");
				view.forward(request, response);
			}
	}
		else if(action.equalsIgnoreCase("updateOwn")) {
			String ic = request.getParameter("teacherIC");
			String name = request.getParameter("name");
			String specialization = request.getParameter("specialization");
			
			System.out.println(specialization);
			
			teacherBean teacherB = new teacherBean();
			
			teacherB.setTeacherICNumber(ic);
			teacherB.setTeacherName(name);
			teacherB.setTeacherSpecialization(specialization);
			
			try {
				teacherD.updateTeacher(teacherB);
			}catch(Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("home.jsp");
		}
		else if(action.equalsIgnoreCase("updaeTeacher")) {
			String ic = request.getParameter("teacherIC");
			String name = request.getParameter("name");
			String specialization = request.getParameter("specialization");
			
			System.out.println(specialization);
			
			teacherBean teacherB = new teacherBean();
			
			teacherB.setTeacherICNumber(ic);
			teacherB.setTeacherName(name);
			teacherB.setTeacherSpecialization(specialization);
			
			try {
				teacherD.updateTeacher(teacherB);
			}catch(Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("home.jsp");
		}
		else if(action.equalsIgnoreCase("register")) {
			String name = request.getParameter("name");
			String ic = request.getParameter("icNum");
			String pass = request.getParameter("password");
			String gender = request.getParameter("gender");
			String specialization = request.getParameter("specialization");
			String role = request.getParameter("role");
			String GPKICNum = String.valueOf(session.getAttribute("teacherIC"));
			
			teacherBean teacherB = new teacherBean();
			
			teacherB.setTeacherName(name);
			teacherB.setTeacherICNumber(ic);
			teacherB.setTeacherPassword(pass);
			teacherB.setTeacherGender(gender);
			teacherB.setTeacherSpecialization(specialization);
			teacherB.setTeacherRole(role);
			teacherB.setTeacherGPKICNum(GPKICNum);
			
			try {
				teacherD.addTeacher(teacherB);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("home.jsp");
			
		}

}
}
