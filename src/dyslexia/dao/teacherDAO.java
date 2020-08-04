package dyslexia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyslexia.connection.ConnectionManager;
import dyslexia.model.teacherBean;

public class teacherDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	String teacher_icNumber,teacher_name,teacher_password,teacher_gender,teacher_specialization,teacher_type;
	teacherBean teacherB;
	
	public teacherDAO() {}
	
	public teacherBean teacherLogin(teacherBean teacherB) {
		String ic = teacherB.getTeacherICNumber();
		String password = teacherB.getTeacherPassword();
		
		String sql = "select * from teacher where teacher_icnumber = '" + ic + "' and teacher_password = '" + password + "' ";
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			boolean more = rs.next();
			
			if(more) {
				String ic1 = rs.getString("teacher_icnumber");
				String name = rs.getString("teacher_name");
				String role = rs.getString("teacher_role");
				teacherB.setTeacherICNumber(ic1);
				teacherB.setTeacherName(name);
				teacherB.setTeacherRole(role);
				teacherB.setValid(true);
			}
			else {
				teacherB.setValid(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null) 
				try{
					rs.close();
				}catch (Exception e) {}
				rs = null;
			if(st != null)
				try {
					st.close();
				}catch(Exception e) {}
				st = null;
			if(con != null)
				try {
					con.close();
				}catch(Exception e) {}
			con = null;
		}
		return teacherB;
	}
	
	public void addTeacher(teacherBean teacherB) {
		
		String name = teacherB.getTeacherName();
		String ic = teacherB.getTeacherICNumber();
		String pass = teacherB.getTeacherPassword();
		String gender = teacherB.getTeacherGender();
		String specialization = teacherB.getTeacherSpecialization();
		String role = teacherB.getTeacherRole();
		String gpk = teacherB.getTeacherGPKICNum();
		String sql;
		if(role.equalsIgnoreCase("Teacher")) {
			sql = "insert into teacher (teacher_icnumber,teacher_name,teacher_password,teacher_gender,teacher_specialization,teacher_role,teacher_gpkicnum)"
					+ "values (?,?,?,?,?,?,?)";
		}
		else {
			sql = "insert into teacher (teacher_icnumber,teacher_name,teacher_password,teacher_gender,teacher_specialization,teacher_role,teacher_gpkicnum)"
					+ "values (?,?,?,?,?,?,null)";
		}
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, ic);
			ps.setString(2, name);
			ps.setString(3, pass);
			ps.setString(4, gender);
			ps.setString(5, specialization);
			ps.setString(6, role);
			if(role.equalsIgnoreCase("Teacher")) {
			ps.setString(7, gpk);
			}
			System.out.println(ic+name+pass+gender+specialization+role+gpk);
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
	public List<teacherBean> getAllTeachers(){
		List<teacherBean> teacherB = new ArrayList<teacherBean>();
		String sql = "select * from teacher order by teacher_name asc";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				teacherBean teacherB2 = new teacherBean();
				teacherB2.setTeacherICNumber(rs.getString("teacher_icnumber"));
				teacherB2.setTeacherName(rs.getString("teacher_name"));
				
				teacherB.add(teacherB2);
			}
			
		}catch (SQLException e) {
            e.printStackTrace();
	}
		return teacherB;
	}
	
	public void updateTeacher(teacherBean teacherB) {

		String ic = teacherB.getTeacherICNumber();
		String name = teacherB.getTeacherName();
		String specialization = teacherB.getTeacherSpecialization();
		
		String sql = "UPDATE teacher set teacher_icnumber = '" + ic + "' , teacher_name = '"+ name +"' , teacher_specialization = '"+ specialization +"'where teacher_icnumber = '" + ic + "'";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			st.executeQuery(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteTeacher(String ic) {
		String sql = "delete from teacher where teacher_icnumber = ?";
		try {
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, ic);
		ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public teacherBean getTeacherByIC(String IC) {
		teacherBean teacherB = new teacherBean();
		
		String sql = "select * from teacher where teacher_icnumber = ?";
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, IC);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				teacherB.setTeacherICNumber(rs.getString("teacher_icnumber"));
				teacherB.setTeacherName(rs.getString("teacher_name"));
				teacherB.setTeacherGender(rs.getString("teacher_gender"));
				teacherB.setTeacherSpecialization(rs.getString("teacher_specialization"));
				teacherB.setTeacherRole(rs.getString("teacher_role"));
				teacherB.setTeacherGPKICNum(rs.getString("teacher_gpkicnum"));
			}
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
		return teacherB;
}
	public teacherBean getTeacherByIC2(String IC) {
		teacherBean teacherB = new teacherBean();
		
		String sql = "select a.teacher_icnumber,a.teacher_name ,a.teacher_gender,a.teacher_specialization,a.teacher_role,b.teacher_name" + 
				" from teacher a" + 
				" left outer join teacher b" + 
				" on b.teacher_icnumber = a.teacher_gpkicnum" + 
				" where a.teacher_icnumber= ?"+
				" or a.teacher_gpkicnum is null";
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, IC);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				teacherB.setTeacherICNumber(rs.getString(1));
				teacherB.setTeacherName(rs.getString(2));
				teacherB.setTeacherGender(rs.getString(3));
				teacherB.setTeacherSpecialization(rs.getString(4));
				teacherB.setTeacherRole(rs.getString(5));
				teacherB.setTeacherGPKName(rs.getString(6));
			}
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
		return teacherB;
}
}
