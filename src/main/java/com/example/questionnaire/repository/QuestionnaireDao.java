package com.example.questionnaire.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.vo.QuizRes;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire, Integer>{

	/**
	 * 找到最新的一筆資料,撈取全部資料後倒序,最新的資料會在最上面
	 **/
	//public Questionnaire findTopByOrderByIdDesc();
	
	public List<Questionnaire> findByIdIn(List<Integer> IdList) ;
	
	public List<Questionnaire> findByTitleAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String title,LocalDate starDate, LocalDate endDate) ;

	public List<Questionnaire> findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String title,
			LocalDate startDate, LocalDate endDate);

	public List<Questionnaire> findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqualAndPublished(
			String title, LocalDate startDate, LocalDate endDate,boolean published);
	
	
}
