package com.surveyDaoImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Entity.Question;
import com.Entity.QuestionJoinCName;
import com.Exception.SurveyException;
import com.surveyDao.QuestionDao;

public class QuestionDaoImpl implements QuestionDao {

	JdbcTemplate template;
	
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int saveQuestion(Question que) {
		String sql="insert into question values(?,?,?,?,?)";
		int id=getMaxIdQue();
		try{
		template.update(sql, new Object[]{++id, que.getUpload_date(), que.getUpload_title(), que.getUpload_Question(), que.getUploader()});
		}catch(Exception e){
			throw new SurveyException("Question can not be saved");
		}
		return id;
	}

	public Integer getMaxIdQue() {
		return template.queryForObject("select count(question_id) from question", Integer.class);
	}

	public List<Question> getQuestionsByEach(int uploader) {
		String sql="select * from question where uploader=? order by question_id desc";
		return template.query(sql, new Object[]{uploader}, new RowMapper<Question>(){

			public Question mapRow(ResultSet rs, int arg1) throws SQLException {
				Question q=new Question();
				q.setQuestion_id(rs.getInt(1));
				q.setUpload_date(rs.getDate(2));
				q.setUpload_title(rs.getString(3));
				q.setUpload_Question(rs.getString(4));
				return q;
			}			
		});
		
	}

	public Question getQuebyId(int id) {
		String sql="select * from question where question_id=?";
		return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Question>(Question.class));
		
	}

	public int updateQuestion(Question que) {
		String sql="UPDATE `question` SET `upload_date`=?,`upload_title`=?,`upload_question`=? WHERE `question_id`=?";
		try{
		return template.update(sql, new Object[]{Date.valueOf(LocalDate.now()), que.getUpload_title(), que.getUpload_Question(), que.getQuestion_id()});
		}catch(RuntimeException e){
			e.printStackTrace();
			throw new SurveyException("Sorry, can not Edit question data");
		}
		}

	public List<QuestionJoinCName> getQuestions(int start, int end) {
		String sql="SELECT question.*, customer.name FROM question, customer WHERE question.uploader=customer.id  limit ?,?";
		return template.query(sql,new Object[]{start,end},  new RowMapper<QuestionJoinCName>(){
			public QuestionJoinCName mapRow(ResultSet rs, int arg1) throws SQLException {
				QuestionJoinCName qn=new QuestionJoinCName();
				Question q=new Question();
				q.setQuestion_id(rs.getInt(1));
				q.setUpload_date(rs.getDate(2));
				q.setUpload_title(rs.getString(3));
				q.setUpload_Question(rs.getString(4));
				q.setUploader(rs.getInt(5));
				qn.setQue(q);
				qn.setCname(rs.getString(6));
				return qn;
			}			
		});
		
	}

	public int questionCount() {
		String sql="select count(question_id) from Question";
		return template.queryForObject(sql, Integer.class);
		
	}

}
