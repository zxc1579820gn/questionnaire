package com.example.questionnaire.vo;

import java.util.List;

import com.example.questionnaire.constants.RtnCode;
import com.example.questionnaire.entity.Question;

public class QuizRes {
	
	private  List<QuizVo> questionQuizVoList;
	
	
	public QuizRes(List<QuizVo> questionQuizVoList) {
		super();
		this.questionQuizVoList = questionQuizVoList;
	}

	public QuizRes(List<QuizVo> questionQuizVoList, RtnCode rtnCode) {
		super();
		this.questionQuizVoList = questionQuizVoList;
		this.rtnCode = rtnCode;
	}

	public List<QuizVo> getQuestionQuizVoList() {
		return questionQuizVoList;
	}

	public void setQuestionQuizVoList(List<QuizVo> questionQuizVoList) {
		this.questionQuizVoList = questionQuizVoList;
	}

	
	
	
	
	public QuizRes() {
		super();
		// TODO Auto-generated constructor stub
	}





	private RtnCode rtnCode ;
	
	

	public QuizRes(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}



	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
	
}
