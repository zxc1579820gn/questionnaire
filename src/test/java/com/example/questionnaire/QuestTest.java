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
        // �B�J 1: �إߦX�z�����ռƾ�
		LocalDate localDate1 = LocalDate.parse("2022-11-06");
		LocalDate localDate2 = LocalDate.parse("2023-11-07");
		int id;//�Ω����
		int qnid;//�Ω����
		id=qnid=35;//�Ω����
        Questionnaire questionnaire = new Questionnaire(id,"�ݨ����Dttt", "�ݨ��y�zttt",false, localDate1, localDate2);
     // �N Arrays.asList ��^���C���ഫ���i�ק諸 ArrayList
        List<Question> question = new ArrayList<>(Arrays.asList(new Question(1,qnid, "���D���Dtestx", "�ﶵ����1", false, "1�ﶵ")));
        // �K�[�B�~������
        question.add(new Question(2,qnid, "���D���Dtest xx", "�ﶵ����2", false, "2�ﶵ"));
        question.add(new Question(3,qnid, "���D���Dtest xxx", "�ﶵ����3", true, "3�ﶵ"));
        question.add(new Question(4,qnid, "���D���Dtest 444", "�ﶵ����4", true, "4�ﶵ"));

        QuizReq quizReq = new QuizReq(questionnaire, question);

        System.out.println(" id: "+questionnaire.getId());
        System.out.println(" qnid: "+qnid);
        // �B�J 2: ����Q���ժ���k
        QuizRes result = quizSerice.update(quizReq);
        
		System.out.println("================================");
	}
	
	
	public void createTest() {
		System.out.println("================================");
        // �B�J 1: �إߦX�z�����ռƾ�
		LocalDate localDate1 = LocalDate.parse("2023-11-16");
		LocalDate localDate2 = LocalDate.parse("2023-12-31");
        Questionnaire questionnaire = new Questionnaire("�A��������zxc", "����",true, localDate1, localDate2);
        
        int qnid=1;
     // �N Arrays.asList ��^���C���ഫ���i�ק諸 ArrayList
        List<Question> question = new ArrayList<>(Arrays.asList(new Question(1,qnid, "���D���D1", "���", false, "�@�ӿﶵ")));

        // �K�[�B�~������
        question.add(new Question(2,qnid, "���D���D2", "�h��", false, "��ӿﶵ"));
        question.add(new Question(3,qnid, "���D���D3", "���", true, "�T�ӿﶵ"));

        QuizReq quizReq = new QuizReq(questionnaire, question);

        // �B�J 2: ����Q���ժ���k
        QuizRes result = quizSerice.create(quizReq);
       // System.out.println(result);
		System.out.println("================================");
	}
	

}
