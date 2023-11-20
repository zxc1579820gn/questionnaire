package com.example.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="phone")
	private String phone;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="age")
	private int age;
	
	@Column(name="qn_id")
	private int qnId;
	
	@Column(name="id")
	private int id;
	
	@Column(name="ans")
	private String ans;

	
	
	
	public User(String phone, String name, String email, int age, int qnId, int id, String ans) {
		super();
		this.phone = phone;
		this.name = name;
		this.email = email;
		this.age = age;
		this.qnId = qnId;
		this.id = id;
		this.ans = ans;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getQnId() {
		return qnId;
	}

	public void setQnId(int qnId) {
		this.qnId = qnId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}
	
	

}
