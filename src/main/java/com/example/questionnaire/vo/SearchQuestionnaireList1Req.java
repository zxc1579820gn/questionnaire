package com.example.questionnaire.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchQuestionnaireList1Req {
	
	private String title ;
	
	@JsonProperty("start_date")
	private LocalDate startDate;
	
	@JsonProperty("end_date")
	private LocalDate endDate;
	
	private  boolean isAll;

	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isAll() {
		return isAll;
	}

	public void setAll(boolean isAll) {
		this.isAll = isAll;
	}
	
	
	
	
	
	

}
