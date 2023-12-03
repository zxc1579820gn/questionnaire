package com.example.questionnaire.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.vo.QuizRes;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire, Integer>{

	/**
	 * ���̷s���@�����,����������ƫ�˧�,�̷s����Ʒ|�b�̤W��
	 **/
	//public Questionnaire findTopByOrderByIdDesc();
	
	public List<Questionnaire> findByIdIn(List<Integer> IdList) ;
	
	public List<Questionnaire> findByTitleAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String title,LocalDate starDate, LocalDate endDate) ;

	public List<Questionnaire> findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String title,
			LocalDate startDate, LocalDate endDate);

	public List<Questionnaire> findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqualAndPublished(
			String title, LocalDate startDate, LocalDate endDate,boolean published);
	
	@Modifying
	@Transactional
	@Query(value = "insert into questionnaire(title, description, is_published, start_date, end_date) " +
	        "values (:title, :description, :isPublished, :startDate, :endDate)", nativeQuery = true)
	public int insert(
	        @Param("title") String title,
	        @Param("description") String description,
	        @Param("isPublished") boolean isPublished,
	        @Param("startDate") LocalDate startDate,
	        @Param("endDate") LocalDate endDate);
	
	
	@Modifying
	@Transactional
	@Query(value = "insert into questionnaire(title, description, is_published, start_date, end_date) " +
	        "values (?1, ?2,?3,?4,?5)", nativeQuery = true)
	public int insertData(
	        String title,
	        String description,
	        boolean isPublished,
	        LocalDate startDate,
	        LocalDate endDate);
	
	@Modifying
	@Transactional
	@Query(value = "update questionnaire set title=:title, description=:description where id =:id", nativeQuery = true)
	public int update(
	    @Param("id") int id,
	    @Param("title") String title,
	    @Param("description") String description);
	
	

	@Query(value = "select * from questionnaire where start_date > :start_date", nativeQuery = true)
	public List<Questionnaire> findByStartDate(@Param("start_date") LocalDate start_date);

	//nativeQuery = false,select���n�ϥΫغc��k���覡,�Bentity���]�n���������غc��k
	@Query(value = "select new Questionnaire(id, title, description, published, startDate, endDate) from Questionnaire where start_date > :start_date")
	public List<Questionnaire> findByStartDate1(@Param("start_date") LocalDate start_date);
	
	//�ϥΧO�W,�y�kas�O�W
	@Query(value = "select qu from Questionnaire as qu where start_date > :start_date or published = :is_published")
	public List<Questionnaire> findByStartDate2(
			@Param("start_date") LocalDate start_date,
			@Param("is_published") boolean is_published);
	
	//orderby & limit
	//1. limit�u��Φb nativeQuery = true
	//2. ������b�y�k���̫�
	@Query(value = "select * from Questionnaire as qu where start_date > :start_date or is_published = :is_published order by id desc limit :num", nativeQuery = true)
	public List<Questionnaire> findByStartDate3(
			@Param("start_date") LocalDate start_date,
			@Param("is_published") boolean is_published,
			@Param("num") int limitNum);
	
	
	
	@Query(value = "SELECT * FROM Questionnaire LIMIT :startIndex, :limitNum", nativeQuery = true)
	public List<Questionnaire> findWithLimitAndStartIndex(
	        @Param("startIndex") int startIndex,
	        @Param("limitNum") int limitNum
	);


	
	
	
	
	

	
}
