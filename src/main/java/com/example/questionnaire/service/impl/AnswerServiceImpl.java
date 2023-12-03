package com.example.questionnaire.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.repository.AnswerDao;
import com.example.questionnaire.service.ifs.AnswerService;


@Service
@Transactional
public class AnswerServiceImpl implements AnswerService{
	
    @Autowired
    private AnswerDao answerRepository;

	@Transactional
	@Override
    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }
	
	@Transactional
	@Override
	public List<Answer> getAnswersByQnIdAndQuId(int qnId, int quId) {
	    return answerRepository.findAllByQnIdAndQuId(qnId, quId);
	}

	@Override
	public List<Answer> getAnswersByQnId(int qnId) {
		 return answerRepository.findAllByQnId(qnId);
	}



}
