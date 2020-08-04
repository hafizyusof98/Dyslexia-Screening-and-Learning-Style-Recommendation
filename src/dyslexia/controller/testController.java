package dyslexia.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dyslexia.dao.questionDAO;
import dyslexia.dao.studentDAO;
import dyslexia.dao.testDAO;
import dyslexia.model.questionBean;
import dyslexia.model.studentBean;
import dyslexia.model.testBean;


@WebServlet("/testController")
public class testController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String action;
	testBean testB = new testBean();
	testDAO testD = new testDAO();
	questionBean questionB = new questionBean();
	questionDAO questionD = new questionDAO();

    public testController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("viewISDStudent")) {
			testDAO testD = new testDAO();
			List<testBean> testB = testD.getAllISDStudent();
			request.setAttribute("testB", testB);
			RequestDispatcher view = request.getRequestDispatcher("takeTest1.jsp");
			view.forward(request, response);
		}
		else if(action.equalsIgnoreCase("viewLearningStyleStudent")) {
			testDAO testD = new testDAO();
			List<testBean> testB = testD.getAllLearningStyleStudent();
			request.setAttribute("testB", testB);
			RequestDispatcher view = request.getRequestDispatcher("takeTest2.jsp");
			view.forward(request, response);
		}
		else if(action.equalsIgnoreCase("takeISDTest")) {
			String studentID = request.getParameter("studentID");
			String studentName = request.getParameter("studentName");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime now = LocalDateTime.now();
			String dateToday = dtf.format(now);
			request.setAttribute("dateToday", dateToday);
			request.setAttribute("studentID", studentID);
			request.setAttribute("studentName", studentName);
			List<questionBean> questionB = questionD.getAllISDQuestion();
			request.setAttribute("questionB", questionB);
			RequestDispatcher view = request.getRequestDispatcher("isdTest.jsp");
			view.forward(request, response);
		
		}
		else if(action.equalsIgnoreCase("takeLearningStyleTest")) {
			String studentID = request.getParameter("studentID");
			String studentName = request.getParameter("studentName");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime now = LocalDateTime.now();
			String dateToday = dtf.format(now);
			request.setAttribute("dateToday", dateToday);
			request.setAttribute("studentID", studentID);
			request.setAttribute("studentName", studentName);
			List<questionBean> questionB = questionD.getAllLearningStyleQuestion();
			request.setAttribute("questionB", questionB);
			RequestDispatcher view = request.getRequestDispatcher("learningStyle.jsp");
			view.forward(request, response);
		
		}
		else if(action.equalsIgnoreCase("viewResult")||action.equalsIgnoreCase("printResult")) {
			int studentID = Integer.parseInt(request.getParameter("studentID"));
			testBean testISDBean = new testBean();
			testBean testLSBean = new testBean();
			studentBean studentB = new studentBean();
			studentDAO studentD = new studentDAO();
			
			testISDBean.setStudentID(studentID);
			testLSBean.setStudentID(studentID);
			studentB.setStudentId(studentID);
			
			testISDBean = testD.getISDResultByID(studentID);
			testLSBean = testD.getLSResultByID(studentID);
			studentB = studentD.getStudentByID(studentID);
			
			String resultISD = testISDBean.getResultTest();
			String resultLS = testLSBean.getResultTest();
			
			if(resultISD != null) {
				String[] arrResult = resultISD.split("/");
				
				String yes1 = arrResult[0];
				String no1 = arrResult[1];
				String element1 = arrResult[2];
				String yes2 = arrResult[3];
				String no2 = arrResult[4];
				String element2 = arrResult[5];
				String yes3 = arrResult[6];
				String no3 = arrResult[7];
				String element3 = arrResult[8];
				String dyslexia = arrResult[9];
				
				request.setAttribute("yes1", yes1);
				request.setAttribute("no1", no1);
				request.setAttribute("element1", element1);
				request.setAttribute("yes2", yes2);
				request.setAttribute("no2", no2);
				request.setAttribute("element2", element2);
				request.setAttribute("yes3", yes3);
				request.setAttribute("no3", no3);
				request.setAttribute("element3", element3);
				request.setAttribute("dyslexia", dyslexia);
			}
			
			if (resultLS != null) {
				String arr2[] = resultLS.split(",");
				
				String v = arr2[0];
				String a = arr2[1];
				String r = arr2[2];
				String k = arr2[3];
				String result = arr2[4];
				
				request.setAttribute("v", v);
				request.setAttribute("a", a);
				request.setAttribute("r", r);
				request.setAttribute("k", k);
				request.setAttribute("result", result);
			}
			
			request.setAttribute("testISDBean", testISDBean);
			request.setAttribute("testLSBean", testLSBean);
			request.setAttribute("studentB", studentB);
			
			if(action.equalsIgnoreCase("viewResult")) {
			RequestDispatcher view = request.getRequestDispatcher("printResult.jsp");
			view.forward(request, response);
			}
			else {
			RequestDispatcher view = request.getRequestDispatcher("printResult2.jsp");
			view.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("resultISD")) {
			String q1 = request.getParameter("q1");
			String q2 = request.getParameter("q2");
			String q3 = request.getParameter("q3");
			String q4 = request.getParameter("q4");
			String q5 = request.getParameter("q5");
			String q6 = request.getParameter("q6");
			String q7 = request.getParameter("q7");
			String q8 = request.getParameter("q8");
			String q9 = request.getParameter("q9");
			String q10 = request.getParameter("q10");
			String q11 = request.getParameter("q11");
			String q12 = request.getParameter("q12");
			String q13 = request.getParameter("q13");
			String q14 = request.getParameter("q14");
			String q15 = request.getParameter("q15");
			String q16 = request.getParameter("q16");
			String q17 = request.getParameter("q17");
			String q18 = request.getParameter("q18");
			String q19 = request.getParameter("q19");
			String q20 = request.getParameter("q20");
			
			
			String q21 = request.getParameter("q21");
			String q22 = request.getParameter("q22");
			String q23 = request.getParameter("q23");
			String q24 = request.getParameter("q24");
			String q25 = request.getParameter("q25");
			String q26 = request.getParameter("q26");
			String q27 = request.getParameter("q27");
			String q28 = request.getParameter("q28");
			String q29 = request.getParameter("q29");
			String q30 = request.getParameter("q30");
			String q31 = request.getParameter("q31");
			String q32 = request.getParameter("q32");
			String q33 = request.getParameter("q33");
			String q34 = request.getParameter("q34");
			String q35 = request.getParameter("q35");
			String q36 = request.getParameter("q36");
			String q37 = request.getParameter("q37");
			String q38 = request.getParameter("q38");
			String q39 = request.getParameter("q39");
			String q40 = request.getParameter("q40");

			
			String q41 = request.getParameter("q41");
			String q42 = request.getParameter("q42");
			String q43 = request.getParameter("q43");
			String q44 = request.getParameter("q44");
			String q45 = request.getParameter("q45");
			String q46 = request.getParameter("q46");
			String q47 = request.getParameter("q47");
			String q48 = request.getParameter("q48");
			String q49 = request.getParameter("q49");
			String q50 = request.getParameter("q50");
			
			
			
			String[] element1 = {q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20};
			String[] element2 = {q21,q22,q23,q24,q25,q26,q27,q28,q29,q30,q31,q32,q33,q34,q35,q36,q37,q38,q39,q40};
			String[] element3 = {q41,q42,q43,q44,q45,q46,q47,q48,q49,q50};
			
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			
			for(int i=0;i<20;i++) {
				if(element1[i].equalsIgnoreCase("Ya")) {
					count1 = count1 + 1;
				}
			}
			for(int j=0;j<20;j++) {
				if(element2[j].equalsIgnoreCase("Ya")) {
					count2 = count2 + 1;
				}
			}
			for(int k=0;k<10;k++) {
				if(element3[k].equalsIgnoreCase("Ya")) {
					count3 = count3 + 1;
				}
			}
			
			String yes1, yes2, yes3;
			String no1, no2, no3;
			int countNot1, countNot2, countNot3;
			int pYes1, pYes2, pYes3;
			
			countNot1 = 20 - count1;
			countNot2 = 20 - count2;
			countNot3 = 10 - count3;
			
			yes1 = Integer.toString(count1);
			yes2 = Integer.toString(count2);
			yes3 = Integer.toString(count3);
			
			no1 = Integer.toString(countNot1);
			no2 = Integer.toString(countNot2);
			no3 = Integer.toString(countNot3);
				
			String score1,score2,score3;
			
			if(count1 >= 8) {
				score1 = "1";
			}
			else {
				score1 = "0";
			}
			
			if(count2 >= 8) {
				score2 = "1";
			}
			else {
				score2 = "0";
			}
			
			if(count3 >= 4) {
				score3 = "1";
			}
			else {
				score3 = "0";
			}
			
			String dyslexia;
			if(score1.equalsIgnoreCase("1")&&score2.equalsIgnoreCase("1")&&score3.equalsIgnoreCase("1")) {
				dyslexia = "High";
			}
			else {
				dyslexia = "Low";
			}
			
			String result = yes1 + "/" + no1 + "/" + score1 + "/" + yes2 + "/" + no2 + "/" + score2 + "/" + yes3 + "/" + no3 + "/" + score3 + "/" + dyslexia + "/";
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime now = LocalDateTime.now();
			String dateToday = dtf.format(now);
			
			String teacherIC = request.getParameter("teacherIC");
			int studentID = Integer.parseInt(request.getParameter("studentID"));
			String testID = request.getParameter("testID");
			
			testBean testB = new testBean();
			
			testB.setTestID(testID);
			testB.setStudentID(studentID);
			testB.setTeacherICNumber(teacherIC);
			testB.setResultTest(result);
			testB.setResultDate(dateToday);
			testB.setStudent_isd(dyslexia);
			
			try {
				testD.resultISD(testB);
				testD.updateStudentISD(testB);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("testController?action=viewResult&studentID="+studentID);
		}
		else if(action.equalsIgnoreCase("resultLearningStyle")) {
			String q1 = request.getParameter("q1");
			String q2 = request.getParameter("q2");
			String q3 = request.getParameter("q3");
			String q4 = request.getParameter("q4");
			String q5 = request.getParameter("q5");
			String q6 = request.getParameter("q6");
			String q7 = request.getParameter("q7");
			String q8 = request.getParameter("q8");
			String q9 = request.getParameter("q9");
			String q10 = request.getParameter("q10");
			String q11 = request.getParameter("q11");
			String q12 = request.getParameter("q12");
			String q13 = request.getParameter("q13");
			String q14 = request.getParameter("q14");
			String q15 = request.getParameter("q15");
			String q16 = request.getParameter("q16");
			
			String[] arrQ = {q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16};
			
			for(int i=0;i<arrQ.length;i++) {
				System.out.print(arrQ[i]);
				System.out.print(" ");
			}
			
			int countV = 0;
			int countA = 0;
			int countR = 0;
			int countK = 0;
			
			for(int i=0;i<arrQ.length;i++) {
				if(arrQ[i].equalsIgnoreCase("V")) {
					countV = countV + 1;
				}
				else if(arrQ[i].equalsIgnoreCase("A")) {
					countA = countA + 1;
				}
				else if(arrQ[i].equalsIgnoreCase("R")) {
					countR = countR + 1;
				}
				else if(arrQ[i].equalsIgnoreCase("K")) {
					countK = countK + 1;
				}
			}
			
			System.out.println(countV + " " + countA + " "  + countR + " " + countK);
			
			String result;
			
			if(countV>countA && countV>countR && countV>countK ) {
				result = "Visual";
			}
			else if(countV>countA && countV>countR && countV>countK ) {
				result = "Auditory";
			}
			else if(countV>countA && countV>countR && countV>countK ) {
				result = "Kinesthetic";
			}
			else if(countV>countA && countV>countR && countV>countK ) {
				result = "Read/Write";
			}
			else if((countV=countA)>countR && (countV=countA)>countK) {
				result = "Visual and Auditory";
			}
			else if((countV=countR)>countA && (countV=countR)>countK) {
				result = "Visual and Read/Write";
			}
			else if((countV=countK)>countA && (countV=countK)>countR) {
				result = "Visual and Kinesthetic";
			}
			else if((countA=countR)>countV && (countA=countR)>countK) {
				result = "Auditory and Read/Write";
			}
			else if((countA=countK)>countR && (countA=countK)>countV) {
				result = "Auditory and Kinesthetic";
			}
			else if((countR=countK)>countV && (countR=countK)>countA) {
				result = "Read/Write and Kinesthetic";
			}
			else if((countV=countA=countR)>countK) {
				result = "Visual, Auditory and Read/Write";
			}
			else if((countV=countA=countK)>countR) {
				result = "Visual, Auditory and Kinesthetic";
			}
			else if((countV=countR=countK)>countA) {
				result = "Visual, Read/Write and Kinesthetic";
			}
			else if((countA=countR=countK)>countV) {
				result = "Auditory, Read/Write and Kinesthetic";
			}
			else {
				result = "Visual, Auditory , Read/Write and Kinesthetic";
			}
			
			String resultLS;
			String v, a, r, k;
			
			v = Integer.toString(countV);
			a = Integer.toString(countA);
			r = Integer.toString(countR);
			k = Integer.toString(countK);
			
			resultLS = v + "," + a + "," + r + "," + k + "," + result;
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime now = LocalDateTime.now();
			String dateToday = dtf.format(now);
			
			String teacherIC = request.getParameter("teacherIC");
			int studentID = Integer.parseInt(request.getParameter("studentID"));
			String testID = request.getParameter("testID");
			
			testBean testB = new testBean();
			
			testB.setTestID(testID);
			testB.setStudentID(studentID);
			testB.setTeacherICNumber(teacherIC);
			testB.setResultTest(resultLS);
			testB.setResultDate(dateToday);
			testB.setStudent_ls(result);
			
			try {
				testD.resultLearningStyle(testB);
				testD.updateStudentLS(testB);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("testController?action=viewResult&studentID="+studentID);
		}
	}
}
