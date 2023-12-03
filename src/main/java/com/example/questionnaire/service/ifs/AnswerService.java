package com.example.questionnaire.service.ifs;

import java.util.List;

import com.example.questionnaire.entity.Answer;

public interface AnswerService {

	public void saveAnswer(Answer answer);

	public List<Answer> getAnswersByQnIdAndQuId(int qnId, int quId);

	public List<Answer> getAnswersByQnId(int qnId);
	
}
