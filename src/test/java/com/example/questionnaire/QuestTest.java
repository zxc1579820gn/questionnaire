package com.example.questionnaire;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.repository.AnswerDao;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.service.ifs.AnswerService;
import com.example.questionnaire.service.ifs.QuizService;
import com.example.questionnaire.vo.QuestionRes;
import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;
import com.example.questionnaire.vo.QuizVo;

@SpringBootTest
public class QuestTest {
	@Autowired
	private QuizService quizSerice;
		
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuestionnaireDao questionnaireDao;
	
	@Autowired
	private AnswerDao answerRepository;
	
	
	public void findWithLimitAndStartIndexTest(){
		System.out.println("================================");
        List<Questionnaire> result = questionnaireDao.findWithLimitAndStartIndex(3,5);
        System.out.println("Result: " + result);
		System.out.println("================================");
	}
	
	
    public void getAnswersByQnIdTest() {
		System.out.println("================================");
        int qnid = 90;
        List<Answer> result = answerService.getAnswersByQnId(qnid);
        System.out.println("Result: " + result);
		System.out.println("================================");
    }
	
    public void getAnswersByQnIdAndQuIdTest() {
		System.out.println("================================");
        int qnid = 87;
        int quid = 1;
        List<Answer> result = answerService.getAnswersByQnIdAndQuId(qnid, quid);
        System.out.println("Result: " + result);
		System.out.println("================================");
    }
	
	
	
	





	public void saveAnswerTest() {
		System.out.println("================================");
        Answer answer = new Answer(87,1,"zxc","zxc","zxc");
        answerService.saveAnswer(answer);
		System.out.println("================================");
    }
	
	
	public void searchQuestionnaireById() {
		System.out.println("================================");
		quizSerice.searchQuestionnaireById(80);
		System.out.println("================================");
	}
	
	
	
	public void findByStartDateTest3() {
		System.out.println("================================");
		List<Questionnaire> res =questionnaireDao.findByStartDate3(LocalDate.parse("2023-11-30"), false,3);
	    for (Questionnaire questionnaire : res) {
	        System.out.println("ID: " + questionnaire.getId()+" Title: " + questionnaire.getTitle());
	    } 
		System.out.println("================================");
	}
	
	public void findByStartDateTest2() {
		System.out.println("================================");
		List<Questionnaire> res =questionnaireDao.findByStartDate2(LocalDate.parse("2023-11-30"), false);
		System.out.println(res.size());
		System.out.println("================================");
	}
	
	public void findByStartDateTest1() {
		System.out.println("================================");
		List<Questionnaire> res =questionnaireDao.findByStartDate1(LocalDate.parse("2023-11-30"));
		System.out.println(res.size());
		System.out.println("================================");
	}
	
	public void findByStartDateTest() {
		System.out.println("================================");
		List<Questionnaire> res =questionnaireDao.findByStartDate(LocalDate.parse("2023-11-30"));
		System.out.println(res.size());
		System.out.println("================================");
	}
	
	
	
	public void QueryupdateTest() {
		System.out.println("================================");
		int res=questionnaireDao.update(71, "測試文字","測試文字");
		System.out.println(res);
		System.out.println("================================");
	}
	
	public void QueryinsertDataTest() {
		System.out.println("================================");
		int res=questionnaireDao.insertData("insert2", " insert2", false, LocalDate.parse("2023-11-30"), LocalDate.parse("2023-12-07"));
		System.out.println(res);
		System.out.println("================================");
	}
	public void QueryinsertTest() {
		System.out.println("================================");
		int res=questionnaireDao.insert("insert", " insert", false, LocalDate.parse("2023-11-30"), LocalDate.parse("2023-12-07"));
		System.out.println(res);
		System.out.println("================================");
	}
	 
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
		List<Integer> deleteList = new ArrayList<>(Arrays.asList(50));
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
		id=qnid=131;//用於模擬
        Questionnaire questionnaire = new Questionnaire(id,"已發布已過期", "描述文字",true, localDate1, localDate2);
        // 將 Arrays.asList 返回的列表轉換為可修改的 ArrayList
        List<Question> question = new ArrayList<>(Arrays.asList(new Question(1,qnid, "標題1", "radio", true, "a,b,c,d")));

        // 添加額外的元素
        question.add(new Question(2,qnid, "標題2", "checkbox", false, "a1,b1,c1,d1"));
        question.add(new Question(3,qnid, "標題3", "text", false, "文字問題"));

        QuizReq quizReq = new QuizReq(questionnaire, question);

        System.out.println("id: "+questionnaire.getId());
        System.out.println("qnid: "+qnid);
        // 步驟 2: 執行被測試的方法
        QuizRes result = quizSerice.update(quizReq);
        
		System.out.println("================================");
	}
	
	
	@Test
	public void createTest() {
		System.out.println("================================");
        // 步驟 1: 建立合理的測試數據
		LocalDate localDate1 = LocalDate.parse("2023-11-30");
		LocalDate localDate2 = LocalDate.parse("2023-12-02");
        Questionnaire questionnaire = new Questionnaire("測試問卷", "測試描述文字",false, localDate1, localDate2);
        
        int qnid=1;
     // 將 Arrays.asList 返回的列表轉換為可修改的 ArrayList
        List<Question> question = new ArrayList<>(Arrays.asList(new Question(1,qnid, "標題1", "radio", true, "答案1,答案2,答案3,答案4")));

        // 添加額外的元素
        question.add(new Question(2,qnid, "標題2", "checkbox", false, "答案a,答案b,答案c,答案d"));
        question.add(new Question(3,qnid, "標題3", "text", false, "文字問題"));

        QuizReq quizReq = new QuizReq(questionnaire, question);

        // 步驟 2: 執行被測試的方法
        QuizRes result = quizSerice.create(quizReq);
       // System.out.println(result);
		System.out.println("================================");
	}
	

}
