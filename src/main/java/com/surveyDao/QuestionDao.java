package com.surveyDao;

import java.util.List;

import com.Entity.Question;
import com.Entity.QuestionJoinCName;

public interface QuestionDao {
	public int saveQuestion(Question que);
	public Integer getMaxIdQue();
	public List<Question> getQuestionsByEach(int uploader);
	public Question getQuebyId(int id);
	public int updateQuestion(Question que);
	public List<QuestionJoinCName> getQuestions(int start, int end); 
	public int questionCount();

}
