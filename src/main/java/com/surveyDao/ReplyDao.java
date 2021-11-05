package com.surveyDao;

import java.util.List;

import com.Entity.Reply;
import com.Entity.ReplyDetail;

public interface ReplyDao {
	
	public void saveReply(Reply reply);
	public List<ReplyDetail> getreplies(int q_id);

}
