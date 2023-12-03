package com.example.questionnaire.constants;

public enum RtnCode {
	SUCCESSFUL(200,"OK!"),//
	PARAM_ERROR(400,"Param Error!"),//
	QUESTION_PARAM_ERROR(400,"Question Param Error!"),//
	QUESTIONNAIRE_PARAM_ERROR(400,"Questionnaire Param Error!"),//
	QUESTION_ID_PARAM_ERROR(400,"Question ID Param Error!"),//
	QUESTIONNAIRE_ID_PARAM_ERROR(400,"Questionnaire ID Param Error!"),//
	QUESTIONNAIRE_ID_NOT_FOUND(404,"Questionnaire ID Not Found!"),//
	UPDATE_ERROR(400,"Update Error!"),//
	DELETE_ERROR(400,"DELETE_ERROR!"),//
	QUESTIONNAIRE_NOT_FOUND(400,"QUESTIONNAIRE_NOT_FOUND"),//
	
	

	;
	
	private int code;
	
	private String message;

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	

}
