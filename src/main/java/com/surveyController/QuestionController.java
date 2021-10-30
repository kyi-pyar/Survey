package com.surveyController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Entity.Customer;
import com.Entity.Question;
import com.Entity.QuestionJoinCName;
import com.Exception.SurveyException;
import com.surveyDao.QuestionDao;
import com.surveyService.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	QuestionDao questiondao;
	
	@Autowired
	QuestionService questionService;
	
	@RequestMapping("/uploadQue")
	public ModelAndView uploadQue(HttpSession session){
		session.removeAttribute("editbyEach");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("uploadquestion");
		mv.addObject("que", new Question());		
		return mv;
	}
	
	@RequestMapping("/saveQue")
	public ModelAndView SaveQue(@ModelAttribute Question que, HttpSession session){		
		Customer cc=(Customer) session.getAttribute("user");		
		que.setUploader(cc.getId());
		que.setUpload_date(Date.valueOf(LocalDate.now()) );	
		que.setQuestion_id(questiondao.saveQuestion(que));		
		List<Question> questions=questiondao.getQuestionsByEach(cc.getId());
		ModelAndView mv=new ModelAndView();
		mv.setViewName("showAllQuebyEach");
		mv.addObject("questions", questions);
		return mv;
	}
	
	
	@RequestMapping("/showQuebyEach")
	public ModelAndView RetrieveQuebyEach( HttpSession session){		
		Customer cc=(Customer) session.getAttribute("user");		
		List<Question> questions=questiondao.getQuestionsByEach(cc.getId());
		ModelAndView mv=new ModelAndView();
		if(questions.size()<=0){
			throw new SurveyException("You didn't upload any question");
		}	
		mv.setViewName("showAllQuebyEach");
		mv.addObject("questions", questions);
		return mv;
	}
	
	@RequestMapping("/editQue")
	public ModelAndView editQuestion(@RequestParam("q_id") int q_id, HttpSession session){
		Question que=questiondao.getQuebyId(q_id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("uploadquestion");
		mv.addObject("que", que);	
		session.setAttribute("editbyEach", "true");
		mv.addObject("edit", "from_edit");
		return mv;
	}
	
	@RequestMapping("/editQueSave")
	public String editQuestionSave(@ModelAttribute("que") Question que, HttpSession session){
		session.removeAttribute("editbyEach");
		int row=questiondao.updateQuestion(que);
		System.out.println(row +"rows affected in update in question");		
		//return RetrieveQuebyEach(session);
		return "redirect:showQuebyEach";
		
	}
	
	@RequestMapping("/showAllQue")
	public ModelAndView showAllQuestion(@RequestParam("p_no") int p_no){
		
		ModelAndView mv=new ModelAndView();
		int questionCount=questiondao.questionCount();
		
		int pages=questionService.page_no_all_que(questionCount);		
		int start=questionService.get_Que_start(p_no, questionCount);	
		int end=questionService.get_Que_end(p_no, questionCount);
		System.out.println(start+":"+end);
		List<QuestionJoinCName> questions=questiondao.getQuestions(start, end);		
		mv.setViewName("showAllQue");
		mv.addObject("questions", questions);
		mv.addObject("pages", pages);
		mv.addObject("q_no", ((p_no*QuestionService.NUM_QUE_PER_PAGE)-(QuestionService.NUM_QUE_PER_PAGE-1)));
		return mv;
		}
	
	

}
