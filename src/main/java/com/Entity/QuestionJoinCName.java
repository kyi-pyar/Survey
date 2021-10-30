package com.Entity;

public class QuestionJoinCName {
	
	Question que;
	String cname;
	public QuestionJoinCName(){
		
	}
	public QuestionJoinCName(Question que, String cname) {
		super();
		this.que = que;
		this.cname = cname;
	}
	public Question getQue() {
		return que;
	}
	public void setQue(Question que) {
		this.que = que;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "QuestionJoinCName [que=" + que + ", cname=" + cname + "]";
	}
	
	
	

}
