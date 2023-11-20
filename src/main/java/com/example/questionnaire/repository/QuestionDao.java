package com.example.questionnaire.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.QuestionId;

@Repository
public interface QuestionDao extends JpaRepository<Question, QuestionId>{

	public void deleteAllByQnIdIn(List<Integer> idList);

	public void deleteAllByQnIdAndQuidIn(int qnid, List<Integer> quidList);

	public List<Question> findAllByQnIdIn(List<Integer> qnIds);

	public List<Question> findAllByQnId(int qnId);
	

	

	
	

	

}
