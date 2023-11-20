package com.example.questionnaire;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.service.ifs.QuizService;
import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;
import com.example.questionnaire.vo.QuizVo;

@SpringBootTest
public class TeacherQuizTest {

	@Autowired
	private QuizService quizSerice;
	
	
	@Test  
	public void teachercreateTest() {
	    System.out.println("================================");
		LocalDate startDate = LocalDate.parse("2023-11-16");
		LocalDate endDate  = LocalDate.parse("2023-12-31");
	    Questionnaire questionnaire = new Questionnaire("老師的測試", "yeee",true, startDate, endDate);
	    
	    
	    List<Question> questionList = new ArrayList<>();
	    Question q1=new Question(1,"問題標題1", "單選", false, "一個選項");
	    Question q2=new Question(2,"問題標題2", "多選", false, "兩個選項");
	    Question q3=new Question(3,"問題標題3", "單選", true, "三個選項");
	    questionList.addAll(Arrays.asList(q1,q2,q3));
	    
	    QuizReq req = new QuizReq(questionnaire, questionList);
	    
	    QuizRes result = quizSerice.create(req);
	    
	    System.out.println("================================");
	}

}
