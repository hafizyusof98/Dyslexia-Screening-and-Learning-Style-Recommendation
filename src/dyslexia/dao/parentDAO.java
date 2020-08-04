package dyslexia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyslexia.connection.ConnectionManager;
import dyslexia.model.parentBean;
import dyslexia.model.studentBean;

public class parentDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	String fatherName,motherName,parentHP,address,city,state,zipCode;
	
	public parentDAO(){}
	
	public void addParent(parentBean parentB) {
		fatherName = parentB.getFatherName();
		motherName = parentB.getMotherName();
		parentHP = parentB.getParentHp();
		address = parentB.getAddress();
		city = parentB.getCity();
		state = parentB.getState();
		zipCode = parentB.getZipCode();
		
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("INSERT INTO parent (parent_id,parent_fathername,parent_mothername,parent_hpnumber,parent_homeaddress,parent_city,parent_state,parent_zipCode) "
									+ "VALUES (parent2_id_sequence.nextval,?,?,?,?,?,?,?)");
			ps.setString(1, fatherName);
			ps.setString(2, motherName);
			ps.setString(3, parentHP);
			ps.setString(4, address);
			ps.setString(5, city);
			ps.setString(6, state);
			ps.setString(7, zipCode);
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
	public void updateParent(parentBean parentB) {

		int id = parentB.getParentId();
		String parentHp = parentB.getParentHp();
		String address = parentB.getAddress();
		String city = parentB.getCity();
		String state = parentB.getState();
		String zipCode = parentB.getZipCode();
		
		String sql = "UPDATE parent set parent_hpnumber = '" + parentHp + "', parent_homeaddress = '" + address + "', parent_city = '"+ city +"' "
				+ ", parent_state = '"+ state +"', parent_zipcode = '"+ zipCode +"'where parent_id = '" + id + "'";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			st.executeQuery(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public parentBean getParentByID(int Id) {
		parentBean parentB = new parentBean();
		String sql = "select * from parent where parent_id = ?";
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				parentB.setParentId(rs.getInt("parent_id"));
				parentB.setFatherName(rs.getString("parent_fathername"));
				parentB.setMotherName(rs.getString("parent_mothername"));
				parentB.setParentHp(rs.getString("parent_hpnumber"));
				parentB.setAddress(rs.getString("parent_homeaddress"));
				parentB.setCity(rs.getString("parent_city"));
				parentB.setState(rs.getString("parent_state"));
				parentB.setZipCode(rs.getString("parent_zipcode"));
				System.out.println(rs.getString("parent_city"));
				
			}
		}catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return parentB;
	}
	
	public parentBean parentExistance(parentBean parentB) {
		
		String motherName = parentB.getMotherName();
		String fatherName = parentB.getFatherName();
		parentBean parentB2 = new parentBean();
		String sql = "select * from parent where parent_fathername = '" + fatherName + "' and parent_mothername = '" + motherName +"' ";
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				parentB2.setValid(true);
				parentB2.setParentId(rs.getInt("parent_id"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return parentB2;
	}
	
}
