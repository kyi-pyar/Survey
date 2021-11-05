package com.Entity;

import java.sql.Date;

public class ReplyDetail {
	
	String reply_ans;
	Date reply_date;
	String name;
	public ReplyDetail(){}
	public String getReply_ans() {
		return reply_ans;
	}
	public void setReply_ans(String reply_ans) {
		this.reply_ans = reply_ans;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ReplyDetail [reply_ans=" + reply_ans + ", reply_date=" + reply_date + ", name=" + name + "]";
	}
	

}
