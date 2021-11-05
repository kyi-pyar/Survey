package com.Entity;

import java.sql.Date;

public class Reply {
	
	int reply_id;
	Date reply_date;
	String reply_ans;
	int question_id;
	int reply_user_id;
	public Reply(){}
	public Reply(int reply_id, Date reply_date, String reply_ans, int question_id, int reply_user_id) {
		super();
		this.reply_id = reply_id;
		this.reply_date = reply_date;
		this.reply_ans = reply_ans;
		this.question_id = question_id;
		this.reply_user_id = reply_user_id;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public String getReply_ans() {
		return reply_ans;
	}
	public void setReply_ans(String reply_ans) {
		this.reply_ans = reply_ans;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getReply_user_id() {
		return reply_user_id;
	}
	public void setReply_user_id(int reply_user_id) {
		this.reply_user_id = reply_user_id;
	}
	@Override
	public String toString() {
		return "Reply [reply_id=" + reply_id + ", reply_date=" + reply_date + ", reply_ans=" + reply_ans
				+ ", question_id=" + question_id + ", reply_user_id=" + reply_user_id + "]";
	}
	
			
	

}
