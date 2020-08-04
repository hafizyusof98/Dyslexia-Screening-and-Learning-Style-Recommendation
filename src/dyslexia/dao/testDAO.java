package dyslexia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyslexia.connection.ConnectionManager;
import dyslexia.model.studentBean;
import dyslexia.model.testBean;

public class testDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	
	public List<testBean> getAllISDStudent(){
		List<testBean> testB = new ArrayList<testBean>();
		String sql = "select student_id,student_name,student_class from student where student_id in (select student_id from student minus select student_id from results where test_id = 'T01')";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				testBean testB2 = new testBean();
				testB2.setStudentID(rs.getInt("student_id"));
				testB2.setStudentName(rs.getString("student_name"));
				testB2.setStudentClass(rs.getString("student_class"));
				
				testB.add(testB2);
			}
			
		}catch (SQLException e) {
            e.printStackTrace();
	}
		return testB;
	}
	public List<testBean> getAllLearningStyleStudent(){
		List<testBean> testB = new ArrayList<testBean>();
		String sql = "select student_id,student_name,student_class from student where student_id in (select student_id from student minus select student_id from results where test_id = 'T02')";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				testBean testB2 = new testBean();
				testB2.setStudentID(rs.getInt("student_id"));
				testB2.setStudentName(rs.getString("student_name"));
				testB2.setStudentClass(rs.getString("student_class"));
				
				testB.add(testB2);
			}
			
		}catch (SQLException e) {
            e.printStackTrace();
	}
		return testB;
	}
	
	public void resultISD(testBean testB) {
		String testID = testB.getTestID();
		int studentID = testB.getStudentID();
		String teacherIC = testB.getTeacherICNumber();
		String result = testB.getResultTest();
		String dateTaken = testB.getResultDate();
		
		String sql = "insert into results (test_id,student_id,teacher_icnumber,result_resultstudent,result_datetaken)"
				+ "values (?,?,?,?,?)";
		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, testID);
			ps.setInt(2, studentID);
			ps.setString(3, teacherIC);
			ps.setString(4, result);
			ps.setString(5, dateTaken);
			ps.executeUpdate();
		}catch(Exception ex) {
			System.out.println("failed:An exception occured!" + ex);
		}
		finally {
			if (ps != null){
				try {
					ps.close();
				} catch (Exception e) {
					ps = null;
				}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e_) {
					con = null;
				}

		}
	}
}
		
	}
	public void resultLearningStyle(testBean testB) {
		String testID = testB.getTestID();
		int studentID = testB.getStudentID();
		String teacherIC = testB.getTeacherICNumber();
		String result = testB.getResultTest();
		String dateTaken = testB.getResultDate();
		
		String sql = "insert into results (test_id,student_id,teacher_icnumber,result_resultstudent,result_datetaken)"
				+ "values (?,?,?,?,?)";
		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, testID);
			ps.setInt(2, studentID);
			ps.setString(3, teacherIC);
			ps.setString(4, result);
			ps.setString(5, dateTaken);
			ps.executeUpdate();
		}catch(Exception ex) {
			System.out.println("failed:An exception occured!" + ex);
		}
		finally {
			if (ps != null){
				try {
					ps.close();
				} catch (Exception e) {
					ps = null;
				}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e_) {
					con = null;
				}

		}
	}
}
		
	}
	public void updateStudentISD(testBean testB) {

		int id = testB.getStudentID();
		String isd = testB.getStudent_isd();
		
		String sql = "UPDATE student set student_isd = '" + isd + "' where student_id = '" + id + "'";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			st.executeQuery(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateStudentLS(testBean testB) {

		int id = testB.getStudentID();
		String ls = testB.getStudent_ls();
		
		String sql = "UPDATE student set student_ls = '" + ls + "' where student_id = '" + id + "'";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			st.executeQuery(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public testBean getISDResultByID(int Id) {
		testBean testB = new testBean();
		String sql = "select t.teacher_name,s.student_name,s.student_class,r.result_resultstudent,r.result_datetaken from teacher t join results r on t.teacher_icnumber = r.teacher_icnumber join student s on s.student_id = r.student_id where r.test_id = 'T01' and s.student_id = ?";
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				testB.setTeacherName(rs.getString("teacher_name"));
				testB.setStudentName(rs.getString("student_name"));
				testB.setStudentClass(rs.getString("student_class"));
				testB.setResultTest(rs.getString("result_resultstudent"));
				testB.setResultDate(rs.getString("result_datetaken"));
			}
		}catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return testB;
	}
	public testBean getLSResultByID(int Id) {
		testBean testB = new testBean();
		String sql = "select t.teacher_name,s.student_name,s.student_class,r.result_resultstudent,r.result_datetaken from teacher t join results r on t.teacher_icnumber = r.teacher_icnumber join student s on s.student_id = r.student_id where r.test_id = 'T02' and s.student_id = ?";
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				testB.setTeacherName(rs.getString("teacher_name"));
				testB.setStudentName(rs.getString("student_name"));
				testB.setStudentClass(rs.getString("student_class"));
				testB.setResultTest(rs.getString("result_resultstudent"));
				testB.setResultDate(rs.getString("result_datetaken"));
			}
		}catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return testB;
	}
}
