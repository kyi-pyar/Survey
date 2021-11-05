package com.surveyController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Entity.Customer;
import com.Entity.QuestionJoinCName;
import com.Entity.Reply;
import com.Entity.ReplyDetail;
import com.Exception.SurveyException;
import com.surveyDao.QuestionDao;
import com.surveyDao.ReplyDao;

@Controller
public class ReplyController {
	
	@Autowired
	QuestionDao questiondao;
	
	
	@Autowired
	ReplyDao replydao;
	
	
	@RequestMapping("/reply")
	public ModelAndView reply(@RequestParam("q_id") int q_id){
		ModelAndView mv=new ModelAndView();	
		System.out.println(q_id);
		QuestionJoinCName que_cname=questiondao.getQueCNamebyId(q_id);
		System.out.println(que_cname);
		mv.addObject("que", que_cname.getQue().getUpload_Question());
		mv.addObject("uploader", que_cname.getCname());
		mv.addObject("que_id", que_cname.getQue().getQuestion_id());
		mv.setViewName("reply");	
		return mv;
	}
	
	@RequestMapping("/submitreply")
	public ModelAndView submitReply(@RequestParam("q_id") int q_id, @RequestParam("reply") String reply, HttpSession session){
		//to save
		Reply replyobj=new Reply();		
		replyobj.setQuestion_id(q_id);
		replyobj.setReply_date(Date.valueOf(LocalDate.now()));
		replyobj.setReply_ans(reply);
		Customer user=(Customer) session.getAttribute("user");
		replyobj.setReply_user_id(user.getId());		
		replydao.saveReply(replyobj);	
		
		//to show
		List<ReplyDetail> replies=replydao.getreplies(q_id);
		QuestionJoinCName question=questiondao.getQueCNamebyId(q_id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("quewithreplies");
		mv.addObject("que", question);
		mv.addObject("replies",replies);
		return mv;		
	}
	@RequestMapping("/showreply")
	public ModelAndView showReplies(@RequestParam("q_id") int q_id){		
		List<ReplyDetail> replies=replydao.getreplies(q_id);
		if(replies.size()<1){
			throw new SurveyException("There is no reply for this quesiton");
		}
		
		QuestionJoinCName question=questiondao.getQueCNamebyId(q_id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("quewithreplies");
		mv.addObject("que", question);
		mv.addObject("replies",replies);
		return mv;	
		
	}

}
