package com.example.questionnaire.service.ifs;

import java.time.LocalDate;
import java.util.List;

import com.example.questionnaire.vo.QuestionRes;
import com.example.questionnaire.vo.QuestionnaireRes;
import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;

public interface QuizService {
	
	public QuizRes create( QuizReq req) ;

	public QuizRes update(QuizReq req);
	
	public QuizRes deletQuestionnaire(List<Integer>qnIdList);
	
	public QuizRes deletQuestion(int qnId,List<Integer> quIdList);
	
	public QuizRes search(String title ,LocalDate startDate,LocalDate endDate);

	public QuestionnaireRes searchQuestionnaireList(String title ,LocalDate startDate,LocalDate endDate);
	
	public QuestionRes  searchQuestionList(int qnId);

	public QuestionnaireRes searchQuestionnaireList1(String title, LocalDate startDate, LocalDate endDate, boolean isAll);

	public QuestionnaireRes searchQuestionnaireById(int qnid);

	
	
}
