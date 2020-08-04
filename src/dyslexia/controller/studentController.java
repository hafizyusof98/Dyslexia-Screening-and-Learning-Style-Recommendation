package dyslexia.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dyslexia.dao.parentDAO;
import dyslexia.dao.studentDAO;
import dyslexia.model.parentBean;
import dyslexia.model.studentBean;

@WebServlet("/studentController")
public class studentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String action;
	studentBean studentB = new studentBean();
	parentBean parentB = new parentBean();
	studentDAO studentD = new studentDAO();
	parentDAO parentD = new parentDAO();
       

    public studentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		if(action.equalsIgnoreCase("viewListStudent")) {
			studentDAO studentD = new studentDAO();
			List<studentBean> studentB = studentD.getAllStudents();
			request.setAttribute("studentB", studentB);
			RequestDispatcher view = request.getRequestDispatcher("listStudent.jsp");
			view.forward(request,response);
			
		}
		else if(action.equalsIgnoreCase("deleteStudent")) {
			int id = Integer.parseInt(request.getParameter("studentID"));
			int id2 = Integer.parseInt(request.getParameter("parentID"));
			studentBean studentB = new studentBean();
			studentB.setStudentId(id);
			studentD.deleteStudent(id);
			response.sendRedirect("home.jsp");
		}
		else if(action.equalsIgnoreCase("viewStudent")) {
			studentBean studentB = new studentBean();
			parentBean parentB = new parentBean();
    		int id = Integer.parseInt(request.getParameter("studentID"));
    		int id2 = Integer.parseInt(request.getParameter("parentID"));
    		studentB.setStudentId(id);
    		parentB.setParentId(id2);
    		studentB = studentD.getStudentByID(id);
    		parentB = parentD.getParentByID(id2);
    		request.setAttribute("studentB",studentB);
    		request.setAttribute("parentB", parentB);
    		RequestDispatcher view = request.getRequestDispatcher("viewStudent.jsp");
    		view.forward(request, response);
		}
		else if(action.equalsIgnoreCase("updateStudentRead")){
			studentBean studentB = new studentBean();
			parentBean parentB = new parentBean();
			int id = Integer.parseInt(request.getParameter("studentID"));
			int id2 = Integer.parseInt(request.getParameter("parentID"));
			studentB.setStudentId(id);
			parentB.setParentId(id2);
			studentB = studentD.getStudentByID(id);
    		parentB = parentD.getParentByID(id2);
    		System.out.println(parentB.getCity());
    		request.setAttribute("studentB",studentB);
    		request.setAttribute("parentB", parentB);
    		RequestDispatcher view = request.getRequestDispatcher("updateStudent.jsp");
    		view.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		HttpSession session = request.getSession();
		System.out.println("test2");
		if(action.equalsIgnoreCase("register")) {
			
			System.out.println("test3");
			
			String name = request.getParameter("name");
			String standard = request.getParameter("standard");
			String classS = request.getParameter("class");
			String formalClass = standard +" "+ classS;
			String gender = request.getParameter("gender");
			String race = request.getParameter("race");
			String religion = request.getParameter("religion");
			String fatherName = request.getParameter("fatherName");
			String motherName = request.getParameter("motherName");
			String parentHP = request.getParameter("parentHP");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zipCode = request.getParameter("zipCode");
			String teacherIC = String.valueOf(session.getAttribute("teacherIC"));
			
			System.out.println(name);
			System.out.println(race);
			System.out.println(teacherIC);
			
			studentB.setName(name);
			studentB.setClassS(formalClass);
			studentB.setGender(gender);
			studentB.setRace(race);
			studentB.setReligion(religion);
			studentB.setRegisteredBy(teacherIC);
			
			parentB.setFatherName(fatherName);
			parentB.setMotherName(motherName);
			parentB.setParentHp(parentHP);
			parentB.setAddress(address);
			parentB.setCity(city);
			parentB.setState(state);
			parentB.setZipCode(zipCode);
			
			parentBean parentB2 = new parentBean();
			
			parentB2  = parentD.parentExistance(parentB);
			
			try {
				if(parentB2.isValid()) {
					studentB.setParentId(parentB2.getParentId());
					studentD.addStudentSameParent(studentB);
				}
				else {
				studentD.addStudent(studentB);
				parentD.addParent(parentB);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("studentController?action=viewListStudent");
		}
		else if(action.equalsIgnoreCase("update")) {
			System.out.println("test44");
			
			int id = Integer.parseInt(request.getParameter("studentID"));
			int id2 = Integer.parseInt(request.getParameter("parentID"));
			String standard = request.getParameter("standard");
			String classS = request.getParameter("class");
			String formalClass = standard + " " + classS;
			String parentHp = request.getParameter("parentHP");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zipCode = request.getParameter("zipCode");
			
			System.out.println(id);
			
			studentBean studentB = new studentBean();
			parentBean parentB = new parentBean();
			
			studentB.setStudentId(id);
			studentB.setClassS(formalClass);
			parentB.setParentId(id2);
			parentB.setParentHp(parentHp);
			parentB.setAddress(address);
			parentB.setCity(city);
			parentB.setState(state);
			parentB.setZipCode(zipCode);
			
			try {
				studentD.updateStudent(studentB);
				parentD.updateParent(parentB);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("home.jsp");
			
		}
		
	}

}
