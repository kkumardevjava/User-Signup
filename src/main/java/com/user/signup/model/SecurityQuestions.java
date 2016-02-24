package com.user.signup.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component 
public class SecurityQuestions {
	
	private List<String> securityQuestionsList_01;
	private List<String> securityQuestionsList_02;
	private List<String> securityQuestionsList_03;
	
	private String securityQuestion_01;
	private String securityQuestion_02;
	private String securityQuestion_03;
	private String randomQuestion;
	
	private String securityAnswer_01;
	private String securityAnswer_02;
	private String securityAnswer_03;
	private String randomAnswer;
	
	public SecurityQuestions() {
		this.securityQuestionsList_01 = new ArrayList<String>();
		this.securityQuestionsList_01.add("whats your pet's Name ?");
		this.securityQuestionsList_01.add("whats your Mother Madien Name ?");
		this.securityQuestionsList_01.add("whats your favourite sport ?");
		
		
		this.securityQuestionsList_02 = new ArrayList<String>();
		this.securityQuestionsList_02.add("whats your boss Name ?");
		this.securityQuestionsList_02.add("whats your favourite sport ?");
		this.securityQuestionsList_02.add("whats your first mobile brand ?");
		
		this.securityQuestionsList_03 = new ArrayList<String>();
		this.securityQuestionsList_03.add("whats your year of Graduation ?");
		this.securityQuestionsList_03.add("whats your Mother Madien Name ?");
		this.securityQuestionsList_03.add("whats your Laptop brand ?");
		
	}

	public List<String> getSecurityQuestionsList_01() {
		return securityQuestionsList_01;
	}

	public void setSecurityQuestionsList_01(List<String> securityQuestionsList_01) {
		this.securityQuestionsList_01 = securityQuestionsList_01;
	}

	public List<String> getSecurityQuestionsList_02() {
		return securityQuestionsList_02;
	}

	public void setSecurityQuestionsList_02(List<String> securityQuestionsList_02) {
		this.securityQuestionsList_02 = securityQuestionsList_02;
	}

	public List<String> getSecurityQuestionsList_03() {
		return securityQuestionsList_03;
	}

	public void setSecurityQuestionsList_03(List<String> securityQuestionsList_03) {
		this.securityQuestionsList_03 = securityQuestionsList_03;
	}

	public String getSecurityAnswer_01() {
		return securityAnswer_01;
	}

	public void setSecurityAnswer_01(String securityAnswer_01) {
		this.securityAnswer_01 = securityAnswer_01;
	}

	public String getSecurityAnswer_02() {
		return securityAnswer_02;
	}

	public void setSecurityAnswer_02(String securityAnswer_02) {
		this.securityAnswer_02 = securityAnswer_02;
	}

	public String getSecurityAnswer_03() {
		return securityAnswer_03;
	}

	public void setSecurityAnswer_03(String securityAnswer_03) {
		this.securityAnswer_03 = securityAnswer_03;
	}

	public String getSecurityQuestion_01() {
		return securityQuestion_01;
	}

	public void setSecurityQuestion_01(String securityQuestion_01) {
		this.securityQuestion_01 = securityQuestion_01;
	}

	public String getSecurityQuestion_02() {
		return securityQuestion_02;
	}

	public void setSecurityQuestion_02(String securityQuestion_02) {
		this.securityQuestion_02 = securityQuestion_02;
	}

	public String getSecurityQuestion_03() {
		return securityQuestion_03;
	}

	public void setSecurityQuestion_03(String securityQuestion_03) {
		this.securityQuestion_03 = securityQuestion_03;
	}

	public String getRandomQuestion() {
		return randomQuestion;
	}

	public void setRandomQuestion(String randomQuestion) {
		this.randomQuestion = randomQuestion;
	}

	public String getRandomAnswer() {
		return randomAnswer;
	}

	public void setRandomAnswer(String randomAnswer) {
		this.randomAnswer = randomAnswer;
	}

}
