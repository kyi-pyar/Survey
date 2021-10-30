package com.Entity;

import java.sql.Date;

public class Question {
	
	int question_id;
	Date upload_date;
	String upload_title;
	String upload_Question;
	int uploader;
	
	
	public Question() {
		super();
	}


	public Question(int question_id, Date upload_date, String upload_title, String upload_Question, int uploader) {
		super();
		this.question_id = question_id;
		this.upload_date = upload_date;
		this.upload_title = upload_title;
		this.upload_Question = upload_Question;
		this.uploader = uploader;
	}


	public int getQuestion_id() {
		return question_id;
	}


	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}


	public Date getUpload_date() {
		return upload_date;
	}


	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}


	public String getUpload_title() {
		return upload_title;
	}


	public void setUpload_title(String upload_title) {
		this.upload_title = upload_title;
	}


	public String getUpload_Question() {
		return upload_Question;
	}


	public void setUpload_Question(String upload_Question) {
		this.upload_Question = upload_Question;
	}


	public int getUploader() {
		return uploader;
	}


	public void setUploader(int uploader) {
		this.uploader = uploader;
	}


	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", upload_date=" + upload_date + ", upload_title="
				+ upload_title + ", upload_Question=" + upload_Question + ", uploader=" + uploader + "]";
	}
	
	

}
