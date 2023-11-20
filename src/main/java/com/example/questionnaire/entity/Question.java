package com.example.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@Table(name="question")
@IdClass(value=QuestionId.class)
public class Question {
	
	@Id
	@Column(name="id")
	private int quid;
	
	@Id
	@Column(name="qn_id")
	private int qnId;
	
	@Column(name="q_title")
	private String qTitle;
	
	@Column(name="option_type")
	private String optionType;
	
	@Column(name="is_necessary")
	private boolean necessary;
	
	@Column(name="q_option")
	private String option;

	
	
	
	public Question(int id, int qnId, String qTitle, String optionType, boolean necessary, String option) {
		super();
		this.quid = id;
		this.qnId = qnId;
		this.qTitle = qTitle;
		this.optionType = optionType;
		this.necessary = necessary;
		this.option = option;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}









	public Question(int quid, String qTitle, String optionType, boolean necessary, String option) {
		super();
		this.quid = quid;
		this.qTitle = qTitle;
		this.optionType = optionType;
		this.necessary = necessary;
		this.option = option;
	}

	public int getQuid() {
		return quid;
	}

	public void setQuid(int quid) {
		this.quid = quid;
	}

	public int getqnId() {
		return qnId;
	}

	public void setqnId(int qnId) {
		this.qnId = qnId;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public boolean isNecessary() {
		return necessary;
	}

	public void setNecessary(boolean necessary) {
		this.necessary = necessary;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
	
}
