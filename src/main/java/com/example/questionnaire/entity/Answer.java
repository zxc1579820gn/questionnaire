package com.example.questionnaire.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "answer_id")
	    private int answerId;

	    @Column(name = "qn_id")
	    private int qnId;

	    @Column(name = "qu_id")
	    private int quId;

	    @Column(name = "q_title")
	    private String qTitle;

	    @Column(name = "answer")
	    private String answer;

	    @Column(name = "question_type")
	    private String questionType;
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    



		public Answer(int qnId, int quId, String qTitle, String answer, String questionType) {
			super();
			this.qnId = qnId;
			this.quId = quId;
			this.qTitle = qTitle;
			this.answer = answer;
			this.questionType = questionType;
		}

		public Answer(int answerId, int qnId, int quId, String qTitle, String answer, String questionType) {
			super();
			this.answerId = answerId;
			this.qnId = qnId;
			this.quId = quId;
			this.qTitle = qTitle;
			this.answer = answer;
			this.questionType = questionType;
		}

		public Answer() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getAnswerId() {
			return answerId;
		}

		public void setAnswerId(int answerId) {
			this.answerId = answerId;
		}

		public int getQnId() {
			return qnId;
		}

		public void setQnId(int qnId) {
			this.qnId = qnId;
		}

		public int getQuId() {
			return quId;
		}

		public void setQuId(int quId) {
			this.quId = quId;
		}

		public String getqTitle() {
			return qTitle;
		}

		public void setqTitle(String qTitle) {
			this.qTitle = qTitle;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public String getQuestionType() {
			return questionType;
		}

		public void setQuestionType(String questionType) {
			this.questionType = questionType;
		}




	    
	    
	    
	    
}
