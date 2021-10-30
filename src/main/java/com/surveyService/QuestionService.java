package com.surveyService;

public interface QuestionService {
	int NUM_QUE_PER_PAGE=3;//static final
	int page_no_all_que(int totalQue);
	int get_Que_start(int page, int total);
	int get_Que_end(int page, int total);
	
	
}
