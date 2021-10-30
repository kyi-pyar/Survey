package com.surveyService;

public class QuestionServiceImpl implements QuestionService{

	public int page_no_all_que(int totalQue) {
		int pages= (totalQue%NUM_QUE_PER_PAGE==0)? totalQue/NUM_QUE_PER_PAGE : totalQue/NUM_QUE_PER_PAGE+1;
		return pages;
	}

	public int get_Que_start(int page, int total) {
		int start=(total-(page*NUM_QUE_PER_PAGE));
		return (start<=0)?0:start;
		
	}

	public int get_Que_end(int page, int total) {
		
		return (page*NUM_QUE_PER_PAGE>total)? total%NUM_QUE_PER_PAGE:NUM_QUE_PER_PAGE;
	}

	
	
	

}
