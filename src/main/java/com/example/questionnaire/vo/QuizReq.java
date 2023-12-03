package com.example.questionnaire.vo;

import java.util.ArrayList;
import java.util.List;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuizReq extends QuizVo{
	
	private Questionnaire questionnaire;
	
//	private Question question;
	
	
	private List<Question> QuestionList = new ArrayList<>();

	private List<Question>deleteList= new ArrayList<>();
	
	
	
	public QuizReq(Questionnaire questionnaire, List<Question> questionList) {
		super();
		this.questionnaire = questionnaire;
		QuestionList = questionList;
	}

	public QuizReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	


	public List<Question> getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(List<Question> deleteList) {
		this.deleteList = deleteList;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public List<Question> getQuestionList() {
		return QuestionList;
	}

	public void setQuestionList(List<Question> questionList) {
		QuestionList = questionList;
	}
	

	
	
	
	
	
	
}
