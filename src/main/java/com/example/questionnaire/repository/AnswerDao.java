package com.example.questionnaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnaire.entity.Answer;

public interface AnswerDao extends JpaRepository<Answer, Integer> {
	
	List<Answer> findAllByQnIdAndQuId(int qnId, int quId);

	List<Answer> findAllByQnId(int qnId);
   
	
}
