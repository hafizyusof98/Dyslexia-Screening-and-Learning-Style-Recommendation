package dyslexia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyslexia.connection.ConnectionManager;
import dyslexia.model.questionBean;
import dyslexia.model.testBean;

public class questionDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	
	public List<questionBean> getAllISDQuestion(){
		List<questionBean> questionB = new ArrayList<questionBean>();
		String sql = "select * from question where test_id='T01'";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				questionBean questionB2 = new questionBean();
				questionB2.setQuestionNumber(rs.getString("question_number"));
				questionB2.setQuestionDescription(rs.getString("question_description"));
				questionB2.setQuestionChoice1(rs.getString("question_choice1"));
				questionB2.setQuestionChoice2(rs.getString("question_choice2"));
				questionB2.setTestID(rs.getString("test_id"));
				
				questionB.add(questionB2);
			}
			
		}catch (SQLException e) {
            e.printStackTrace();
	}
		return questionB;
}
	public List<questionBean> getAllLearningStyleQuestion(){
		List<questionBean> questionB = new ArrayList<questionBean>();
		String sql = "select * from question where test_id='T02' order by 1";
		
		try {
			con = ConnectionManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				questionBean questionB2 = new questionBean();
				questionB2.setQuestionNumber(rs.getString("question_number"));
				questionB2.setQuestionDescription(rs.getString("question_description"));
				questionB2.setQuestionChoice1(rs.getString("question_choice1"));
				questionB2.setQuestionChoice2(rs.getString("question_choice2"));
				questionB2.setQuestionChoice3(rs.getString("question_choice3"));
				questionB2.setQuestionChoice4(rs.getString("question_choice4"));
				questionB2.setTestID(rs.getString("test_id"));
				
				questionB.add(questionB2);
			}
			
		}catch (SQLException e) {
            e.printStackTrace();
	}
		return questionB;
}
}
