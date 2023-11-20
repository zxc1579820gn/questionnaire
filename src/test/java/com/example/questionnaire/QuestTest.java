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
public class QuestTest {
	@Autowired
	private QuizService quizSerice;
	
	@Test  
	public void searchQuestionnaireIsPublishListTest() {
	    System.out.println("================================");
	    quizSerice.searchQuestionnaireList1("ttt", null, null,false);
	    System.out.println("================================");
	}
	
	
	public void searchQuestionListTest() {
	    System.out.println("================================");
	    quizSerice.searchQuestionList(38);
	    System.out.println("================================");
	}
	
	
	public void searchQuestionnaireListTest() {
	    System.out.println("================================");
	    quizSerice.searchQuestionnaireList("a", null, null);
	    System.out.println("================================");
	}
	
	
	public void searchTest() {
	    System.out.println("================================");
	    quizSerice.search("ttt", null, null);
	    System.out.println("================================");
	}
	
	
	public void deletQuestionTest() {
		System.out.println("================================");
		List<Integer> deleteList = new ArrayList<>(Arrays.asList(2,3));
		quizSerice.deletQuestion(35,deleteList);
		System.out.println("================================");
	}
	
	
	public void deletQuestionnaireTest() {
		System.out.println("================================");
		List<Integer> deleteList = new ArrayList<>(Arrays.asList(26,27));
		quizSerice.deletQuestionnaire(deleteList);
		System.out.println("================================");
	}
	
	
	public void updateTest() {
		System.out.println("================================");
        // 步驟 1: 建立合理的測試數據
		LocalDate localDate1 = LocalDate.parse("2022-11-06");
		LocalDate localDate2 = LocalDate.parse("2023-11-07");
		int id;//用於模擬
		int qnid;//用於模擬
		id=qnid=35;//用於模擬
        Questionnaire questionnaire = new Questionnaire(id,"問卷標題ttt", "問卷描述ttt",false, localDate1, localDate2);
     // 將 Arrays.asList 返回的列表轉換為可修改的 ArrayList
        List<Question> question = new ArrayList<>(Arrays.asList(new Question(1,qnid, "問題標題testx", "選項類型1", false, "1選項")));
        // 添加額外的元素
        question.add(new Question(2,qnid, "問題標題test xx", "選項類型2", false, "2選項"));
        question.add(new Question(3,qnid, "問題標題test xxx", "選項類型3", true, "3選項"));
        question.add(new Question(4,qnid, "問題標題test 444", "選項類型4", true, "4選項"));

        QuizReq quizReq = new QuizReq(questionnaire, question);

        System.out.println(" id: "+questionnaire.getId());
        System.out.println(" qnid: "+qnid);
        // 步驟 2: 執行被測試的方法
        QuizRes result = quizSerice.update(quizReq);
        
		System.out.println("================================");
	}
	
	
	public void createTest() {
		System.out.println("================================");
        // 步驟 1: 建立合理的測試數據
		LocalDate localDate1 = LocalDate.parse("2023-11-16");
		LocalDate localDate2 = LocalDate.parse("2023-12-31");
        Questionnaire questionnaire = new Questionnaire("你懂浪漫嗎zxc", "ㄩ嗎",true, localDate1, localDate2);
        
        int qnid=1;
     // 將 Arrays.asList 返回的列表轉換為可修改的 ArrayList
        List<Question> question = new ArrayList<>(Arrays.asList(new Question(1,qnid, "問題標題1", "單選", false, "一個選項")));

        // 添加額外的元素
        question.add(new Question(2,qnid, "問題標題2", "多選", false, "兩個選項"));
        question.add(new Question(3,qnid, "問題標題3", "單選", true, "三個選項"));

        QuizReq quizReq = new QuizReq(questionnaire, question);

        // 步驟 2: 執行被測試的方法
        QuizRes result = quizSerice.create(quizReq);
       // System.out.println(result);
		System.out.println("================================");
	}
	

}
