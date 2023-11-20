package com.example.questionnaire.service.impl;

import java.lang.StackWalker.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire.constants.RtnCode;
import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.repository.QuestionDao;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.service.ifs.QuizService;
import com.example.questionnaire.vo.QuestionRes;
import com.example.questionnaire.vo.QuestionnaireRes;
import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;
import com.example.questionnaire.vo.QuizVo;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuestionnaireDao qnDao;
	
	@Autowired
	private QuestionDao quDao;
	

	//Transactional:�n�����s�n�������s
	@Transactional
	@Override
	public QuizRes create(QuizReq req) {
		QuizRes checkResult =checkParam(req);
		if (checkResult!=null) {
			return checkResult;
		}
		int quid=qnDao.save(req.getQuestionnaire()).getId();
		List<Question> quList = req.getQuestionList();
		if (quList.isEmpty()) {//��List
			System.out.println("��List"+"SUCCESSFUL");
			return new QuizRes(RtnCode.SUCCESSFUL);
		}
		//int quid=qnDao.findTopByOrderByIdDesc().getId();
		for(Question qu:quList){
			qu.setqnId(quid);
		}
		quDao.saveAll(quList);
		System.out.println("SUCCESSFUL");
		return new QuizRes(RtnCode.SUCCESSFUL);
	}
	private QuizRes checkParam(QuizReq req) {
		 Questionnaire qn =req.getQuestionnaire();
		 if (!StringUtils.hasText(qn.getTitle())||!StringUtils.hasText(qn.getDescription())
				 ||qn.getStartDate()==null||qn.getEndDate()==null||qn.getStartDate().isAfter(qn.getEndDate())) {
			 System.out.println("QUESTIONNAIRE_PARAM_ERROR");
			return new QuizRes(RtnCode.QUESTIONNAIRE_PARAM_ERROR);
		}
		 List<Question> quList=req.getQuestionList();
		 for(Question qu:quList) {
			 if (qu.getQuid()<=0||!StringUtils.hasText(qu.getqTitle())||!StringUtils.hasText(qu.getOptionType())
					 ||!StringUtils.hasText(qu.getOption())) {
				 System.out.println("QUESTION_PARAM_ERROR");
				 return new QuizRes(RtnCode.QUESTION_PARAM_ERROR);
			}
		 }
		 return null;
	}
	
	
	@Transactional
	@Override
	public QuizRes update(QuizReq req) {
		QuizRes checkResult =checkParam(req);
		if (checkResult!=null) {
			return checkResult;
		}
		checkResult=checkQuestionnaireId(req);
		if (checkResult!=null) {
			return checkResult;
		}
//		if (!qnDao.existsById(req.getQuestionnaire().getId())) {
//			return new QuizRes(RtnCode.QUESTIONNAIRE_ID_NOT_FOUND);
//		}
		Optional<Questionnaire> qnOp=qnDao.findById(req.getQuestionnaire().getId());
		if (qnOp.isEmpty()) {
			System.out.println("QUESTIONNAIRE_ID_NOT_FOUND");
			return new QuizRes(RtnCode.QUESTIONNAIRE_ID_NOT_FOUND);
		}
		Questionnaire qn=qnOp.get();
		//�i�ק����:
		//1.�|���o��: is_publish==false
		//2.�w�o�����|���i��:is_publish==true+��e�ɶ��p��start_date
		if ( !qn.isPublished()||( qn.isPublished()&&LocalDate.now().isBefore( qn.getStartDate() ) ) ) {
			qnDao.save(req.getQuestionnaire());
			quDao.saveAll(req.getQuestionList());
			System.out.println("SUCCESSFUL");
			 return new QuizRes(RtnCode.SUCCESSFUL);
		}
		System.out.println("UPDATE_ERROR");
		return new QuizRes(RtnCode.UPDATE_ERROR);
	}
	private QuizRes checkQuestionnaireId(QuizReq req) {
		if (req.getQuestionnaire().getId()<=0) {
			System.out.println("QUESTIONNAIRE_ID_PARAM_ERROR");
			return new QuizRes(RtnCode.QUESTIONNAIRE_ID_PARAM_ERROR);
		}
		List<Question> quList=req.getQuestionList();
		 for(Question qu:quList) {
			 if (qu.getqnId()!=req.getQuestionnaire().getId()) {
				 System.out.println("QUESTIONNAIRE_ID_PARAM_ERROR");
				 return new QuizRes(RtnCode.QUESTIONNAIRE_ID_PARAM_ERROR);
			}
		 }
		 return null;
	}
	
	
	
	@Transactional
	@Override
	public QuizRes deletQuestionnaire(List<Integer> qnIdList) {
		List<Questionnaire> qnList =qnDao.findByIdIn(qnIdList);
		List<Integer> idList = new ArrayList<>();
		for (Questionnaire qn:qnList) {
			if (!qn.isPublished()||( qn.isPublished()&&LocalDate.now().isBefore( qn.getStartDate() ) ) ) {
				//qnDao.deleteById(qn.getId());
				idList.add(qn.getId());
			}
		}
		if (!idList.isEmpty()) {
			qnDao.deleteAllById(idList);//�R���ݨ�
			quDao.deleteAllByQnIdIn(idList);//�R���D��
		}
		System.out.println("SUCCESSFUL");
		return new QuizRes(RtnCode.SUCCESSFUL);
	}
		
	@Transactional
	@Override
	public QuizRes deletQuestion(int qnId, List<Integer> quIdList) {
		Optional<Questionnaire> qnOp =qnDao.findById(qnId);
		if(qnOp.isEmpty()) {
			System.out.println("SUCCESSFUL");
			return new QuizRes(RtnCode.SUCCESSFUL);
		}
		Questionnaire qn =qnOp.get();
		if(!qn.isPublished()||(qn.isPublished()&&LocalDate.now().isBefore( qn.getStartDate() ) )) {
			System.out.println("�n�R�������D:" + quIdList);
			quDao.deleteAllByQnIdAndQuidIn( qnId,quIdList);
			
		}
		
		System.out.println("SUCCESSFUL");
		return new QuizRes(RtnCode.SUCCESSFUL);
	}
	
	@Transactional
	@Override
	public QuizRes search(String title, LocalDate startDate, LocalDate endDate) {
		//�T���B��l:�ܼ�=�P�_�� ?true:false;
		
		title=StringUtils.hasText(title) ? title : "" ;
		System.out.println("title: "+title);
//		 if (!StringUtils.hasText(title)){title="";}
		startDate= startDate==null  ?  LocalDate.of(1971,1,1):startDate ;
		System.out.println("startDate: "+startDate);
//		 if (startDate==null){startDate=LocalDate.of(1971,1,1);}
		endDate= endDate==null ? LocalDate.of(2099,12,31):endDate ;
		System.out.println("endDate: "+endDate);
//		 if (endDate==null){endDate=LocalDate.of(2099,12,31);}
		
		List<Questionnaire> qnList=qnDao.findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(title,startDate, endDate);
		List<Integer> qnIds= new ArrayList<>();
		
		for (Questionnaire qu :qnList) {
			qnIds.add(qu.getId());
		}
		
		List<Question>quList=quDao.findAllByQnIdIn(qnIds);
		List<QuizVo>quizVoList= new ArrayList<>();
		
		for (Questionnaire qn :qnList) {
			QuizVo vo =  new QuizVo();
			vo.setQuestionnaire(qn);
			List<Question>questionList=new ArrayList<>();
				for (Question qu :quList) {
					if (qu.getqnId()==qn.getId()) {
						questionList.add(qu);
					}
				}
			vo.setQuestionList(questionList);
			quizVoList.add(vo);
		}
		//��ܵ��G
        for (QuizVo quizVo : quizVoList) {
            System.out.println("�ݨ����D: " + quizVo.getQuestionnaire().getTitle()+" �ݨ��y�z: "+ quizVo.getQuestionnaire().getDescription());
        }
		//��ܵ��G
        for (Question quizVo : quList) {
            System.out.println("���D���D: " + quizVo.getqTitle()+" �ﶵ����: "+ quizVo.getOptionType());
        }
        
        

		System.out.println("SUCCESSFUL");
		return new QuizRes(quizVoList,RtnCode.SUCCESSFUL);
	}
	
	
	
	@Transactional
	@Override
	public QuestionnaireRes searchQuestionnaireList(String title, LocalDate startDate, LocalDate endDate) {
		title=StringUtils.hasText(title) ? title : "" ;
		System.out.println("title: "+title);
		startDate= startDate==null  ?  LocalDate.of(1971,1,1):startDate ;
		System.out.println("startDate: "+startDate);
		endDate= endDate==null ? LocalDate.of(2099,12,31):endDate ;
		System.out.println("endDate: "+endDate);
		List<Questionnaire> qnList=qnDao.findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(title,startDate, endDate);
		
		//��ܵ��G
        for (Questionnaire quizVo : qnList) {
            System.out.println("�ݨ����D: " + quizVo.getTitle()+" �ݨ��y�z: "+ quizVo.getDescription());
        }
		
		return new QuestionnaireRes(qnList,RtnCode.SUCCESSFUL);
	}
	
	
	
	@Transactional
	@Override
	public QuestionRes searchQuestionList(int qnId) {
		if (qnId<=0) {
			return new QuestionRes(null,RtnCode.QUESTIONNAIRE_ID_PARAM_ERROR);
		}
		//List<Question> quList=quDao.findAllByQnIdIn( Arrays.asList(qnId) );
		List<Question> quList=quDao.findAllByQnId(qnId);
		
		//��ܵ��G
        for (Question quizVo : quList) {
            System.out.println("���D���D: " + quizVo.getqTitle()+" �ﶵ����: "+ quizVo.getOptionType());
        }
		
		
		return new QuestionRes(quList,RtnCode.SUCCESSFUL);
	}
	
	@Transactional
	@Override
	public QuestionnaireRes searchQuestionnaireList1(String title, LocalDate startDate, LocalDate endDate,
			boolean isAll) {
		//�i�j�M�O�_���}���ݨ�
		title=StringUtils.hasText(title) ? title : "" ;
		System.out.println("title: "+title);
		startDate= startDate==null  ?  LocalDate.of(1971,1,1):startDate ;
		System.out.println("startDate: "+startDate);
		endDate= endDate==null ? LocalDate.of(2099,12,31):endDate ;
		System.out.println("endDate: "+endDate);
		//List<Questionnaire> qnList=qnDao.findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(title,startDate, endDate);
		List<Questionnaire> qnList= new ArrayList<>();
		if(!isAll) {
			qnList=qnDao.findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqualAndPublished(title,startDate, endDate,true);
		}else {
			qnList=qnDao.findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(title,startDate, endDate);
		}
		//��ܵ��G
        for (Questionnaire quizVo : qnList) {
            System.out.println("�ݨ����D: " + quizVo.getTitle()+" �ݨ��y�z: "+ quizVo.getDescription()+" �O�_����: "+ quizVo.isPublished());
        }
		return new QuestionnaireRes(qnList,RtnCode.SUCCESSFUL);
	}


	
	

	
	
	
}
