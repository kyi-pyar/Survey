package com.surveyDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Entity.Reply;
import com.Entity.ReplyDetail;
import com.Exception.SurveyException;
import com.surveyDao.ReplyDao;

public class ReplyDaoImpl implements ReplyDao{
	
	JdbcTemplate template;
	
	
	
	

	public JdbcTemplate getTemplate() {
		return template;
	}





	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}





	public void saveReply(Reply reply) {
		String sql="insert into reply ( `reply_date`, `reply_ans`, `question_id`, `reply_user_id`) values(?,?,?,?)";
		try{
		template.update(sql,  reply.getReply_date(), reply.getReply_ans(), reply.getQuestion_id(), reply.getReply_user_id());
		}catch(RuntimeException e){
			e.printStackTrace();
			throw new SurveyException("reply can not save");
		}
		}





	public List<ReplyDetail> getreplies(int q_id) {
		String sql="select reply_ans, reply_date, customer.name from reply, customer where question_id=?  and reply.reply_user_id=customer.id order by reply_date desc";
		return template.query(sql,new Object[]{q_id}, new RowMapper<ReplyDetail>(){

			public ReplyDetail mapRow(ResultSet rs, int arg1) throws SQLException {
				ReplyDetail reply=new ReplyDetail();
				reply.setReply_ans(rs.getString(1));
				reply.setReply_date(rs.getDate(2));
				reply.setName(rs.getString(3));				
				return reply;
			}
			
		});
			
	}

}

