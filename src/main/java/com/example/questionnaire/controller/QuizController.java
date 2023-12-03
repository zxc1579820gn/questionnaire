package com.example.questionnaire.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.repository.AnswerDao;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.service.ifs.AnswerService;
import com.example.questionnaire.service.ifs.QuizService;
import com.example.questionnaire.vo.QuestionRes;
import com.example.questionnaire.vo.QuestionnaireRes;
import com.example.questionnaire.vo.QuizDeletQuestionReq;
import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;
import com.example.questionnaire.vo.QuizSearchReq;
import com.example.questionnaire.vo.SearchQuestionnaireList1Req;
import com.example.questionnaire.vo.SearchQuestionnaireListReq;
import com.fasterxml.jackson.annotation.JsonProperty;



@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class QuizController {

	@Autowired
	private QuizService service;
    @Autowired
    private AnswerService answerService;
	
	
	@PostMapping(value="api/quiz/create")
	public QuizRes create(@RequestBody QuizReq req) {
		return service.create(req);
	}
	
	@PostMapping(value="api/quiz/update")
	public QuizRes update(@RequestBody QuizReq req) {
		return service.update(req);
	}
	
	@PostMapping(value = "api/quiz/deletQuestionnaire")
	public QuizRes deletQuestionnaire(@RequestBody List<Integer> qnIdList) {
	    return service.deletQuestionnaire(qnIdList);
	}
	
	
	//localhost:8081/api/quiz/deletQuestion?qnId=51&quIdList=2&quIdList=3
    @PostMapping(value = "api/quiz/deletQuestion")
    public QuizRes deletQuestion(@RequestBody QuizDeletQuestionReq request) {
        return service.deletQuestion(request.getQnId(), request.getQuIdList());
    }
	
     
	@GetMapping(value = "api/quiz/search")
	 public QuizRes search(@RequestParam(value = "title", required = false) String title,
	                       @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate startDate,
	                       @RequestParam(value = "endDate", required = false,defaultValue = "2099-12-31")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
	     return service.search(title, startDate, endDate);
	 }
//	@GetMapping(value="api/quiz/search")
//	public QuizRes search(@RequestBody QuizSearchReq req) {
//		return service.search(req.getTitle(),req.getStartDate(),req.getEndDate());
//	}
	
	
	@CrossOrigin
	@GetMapping(value = "api/quiz/search_questionnaire_list")
	public QuestionnaireRes searchQuestionnaireList(@RequestBody SearchQuestionnaireListReq req) {
		return service.searchQuestionnaireList(req.getTitle(),req.getStartDate(),req.getEndDate());
	}
	
	@GetMapping(value = "api/quiz/search_question_list/{qnId}")
	public QuestionRes searchQuestionList(@PathVariable int qnId) {
		return service.searchQuestionList(qnId);
	}
	
//	@GetMapping(value = "api/quiz/search_all_questionnaire_list")
//	public QuestionnaireRes searchQuestionnaireList1(@RequestBody SearchQuestionnaireList1Req req) {
//		return service.searchQuestionnaireList1(req.getTitle(),req.getStartDate(),req.getEndDate(),req.isAll());
//	}
	@GetMapping(value = "api/quiz/search_all_questionnaire_list")
	public QuestionnaireRes searchQuestionnaireList1(@RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate startDate,
            @RequestParam(value = "endDate", required = false,defaultValue = "2099-12-31")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
		return service.searchQuestionnaireList1(title, startDate, endDate, true);
	}
	@GetMapping(value = "api/quiz/not_search_all_questionnaire_list")
	public QuestionnaireRes searchQuestionnaireList2(@RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate startDate,
            @RequestParam(value = "endDate", required = false,defaultValue = "2099-12-31")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
		return service.searchQuestionnaireList1(title, startDate, endDate, false);
	}
	
	
	@GetMapping(value = "api/quiz/search_questionnaire_by_id/{qnid}")
	public QuestionnaireRes searchQuestionnaireById(@PathVariable int qnid) {
		return service.searchQuestionnaireById(qnid);
	}
	
	
    @PostMapping(value="api/quiz/save_answer")
    public ResponseEntity<String> saveAnswer(@RequestBody Answer answer) {
        try {
            answerService.saveAnswer(answer);
            return new ResponseEntity<>("Answer saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save answer: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value="api/quiz/get_answer/qnid/{qnid}/quid/{quid}")
    public List<Answer> getAnswersByQnIdAndQuId(@PathVariable int qnid, @PathVariable int quid) {
        return answerService.getAnswersByQnIdAndQuId(qnid, quid);
    }
    
    @GetMapping(value="api/quiz/get_answer/qnid/{qnid}")
    public List<Answer> getAnswersByQnId(@PathVariable int qnid) {
        return answerService.getAnswersByQnId(qnid);
    }

	
	
	
	
	
}
