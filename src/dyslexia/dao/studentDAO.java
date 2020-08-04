package dyslexia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyslexia.connection.*;
import dyslexia.model.studentBean;

public class studentDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	String name,classS,gender,race,religion,teacherIC;
	int parentId;
	
	public studentDAO(){}
	
	public void addStudent(studentBean studentB) {
		name = studentB.getName();
		classS = studentB.getClassS();
		gender = studentB.getGender();
		race = studentB.getRace();
		religion = studentB.getReligion();
		teacherIC = studentB.getRegisteredBy();
		
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("INSERT INTO student (student_id,student_name,student_class,student_gender,student_race,student_religion,parent_id,teacher_icnumber) "
									+ "VALUES (student_id_sequence.nextval,?,?,?,?,?,parent1_id_sequence.nextval,?)");
			ps.setString(1, name);
			ps.setString(2, classS);
			ps.setString(3, gender);
			ps.setString(4, race);
			ps.setString(5, religion);
			ps.setString(6, teacherIC);
			ps.executeUpdate();
		}
		catch(Exception ex) {
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
		public void addStudentSameParent(studentBean studentB) {
			name = studentB.getName();
			classS = studentB.getClassS();
			gender = studentB.getGender();
			race = studentB.getRace();
			religion = studentB.getReligion();
			teacherIC = studentB.getRegisteredBy();
			parentId = studentB.getParentId();
			
			
			try {
				con = ConnectionManager.getConnection();
				ps = con.prepareStatement("INSERT INTO student (student_id,student_name,student_class,student_gender,student_race,student_religion,parent_id,teacher_icnumber) "
										+ "VALUES (student_id_sequence.nextval,?,?,?,?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, classS);
				ps.setString(3, gender);
				ps.setString(4, race);
				ps.setString(5, religion);
				ps.setInt(6, parentId);
				ps.setString(7, teacherIC);
				ps.executeUpdate();
			}
			catch(Exception ex) {
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
	public void updateStudent(studentBean studentB) {

		int id = studentB.getStudentId();
		String classS = studentB.getClassS();
		
		String sql = "UPDATE student set student_class = '" + classS + "' where student_id = '" + id + "'";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			st.executeQuery(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public studentBean getStudentByID(int Id) {
		studentBean studentB = new studentBean();
		String sql = "select * from student where student_id = ?";
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				studentB.setStudentId(rs.getInt("student_id"));
				studentB.setName(rs.getString("student_name"));
				studentB.setClassS(rs.getString("student_class"));
				studentB.setGender(rs.getString("student_gender"));
				studentB.setRace(rs.getString("student_race"));
				studentB.setReligion(rs.getString("student_religion"));
				studentB.setRegisteredBy(rs.getString("teacher_icnumber"));
			}
		}catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return studentB;
	}
	public List<studentBean> getAllStudents(){
		List<studentBean> studentB = new ArrayList<studentBean>();
		String sql = "select * from student";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				studentBean studentB2 = new studentBean();
				studentB2.setStudentId(rs.getInt("student_id"));
				studentB2.setName(rs.getString("student_name"));
				studentB2.setClassS(rs.getString("student_class"));
				studentB2.setGender(rs.getString("student_gender"));
				studentB2.setIsd(rs.getString("student_isd"));
				studentB2.setLs(rs.getString("student_ls"));
				
				studentB.add(studentB2);
			}
			
		}catch (SQLException e) {
            e.printStackTrace();
	}
		return studentB;
	}
	
	public void deleteStudent(int id) {
		String sql = "delete from student where student_id = ?";
		try {
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
