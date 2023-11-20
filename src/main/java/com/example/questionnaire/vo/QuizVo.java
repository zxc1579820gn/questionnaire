package com.example.questionnaire.vo;

import java.util.List;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;

public class QuizVo {
	private Questionnaire questionnaire;
	
	private List<Question> questionList;

	
	
	
	
	
	
	
	public QuizVo(Questionnaire questionnaire, List<Question> questionList) {
		super();
		this.questionnaire = questionnaire;
		this.questionList = questionList;
	}

	public QuizVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	
	
	
	
	
}
