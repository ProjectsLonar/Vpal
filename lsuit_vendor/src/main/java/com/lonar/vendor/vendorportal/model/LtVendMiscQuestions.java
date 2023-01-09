package com.lonar.vendor.vendorportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LT_VEND_MISC_QUESTIONS")
public class LtVendMiscQuestions extends BaseClass
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	@SequenceGenerator(name = "company_seq", sequenceName = "LT_VEND_MISC_QUESTIONS_S", allocationSize = 1)
	@Column(name = "Misc_Question_Id")
	private Long miscQuestionId;
	
	@Column(name = "Comp_Miscellaneous_Id")
	private Long compMiscellaneousId;
	
	
	@Column(name = "Question")
	private String question;
	
	@Column(name = "Mand_Question_Id")
	private String mandQuestionId;

	public Long getMiscQuestionId() {
		return miscQuestionId;
	}

	public void setMiscQuestionId(Long miscQuestionId) {
		this.miscQuestionId = miscQuestionId;
	}

	public Long getCompMiscellaneousId() {
		return compMiscellaneousId;
	}

	public void setCompMiscellaneousId(Long compMiscellaneousId) {
		this.compMiscellaneousId = compMiscellaneousId;
	}

	

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getMandQuestionId() {
		return mandQuestionId;
	}

	public void setMandQuestionId(String mandQuestionId) {
		this.mandQuestionId = mandQuestionId;
	}

	@Override
	public String toString() {
		return "LtVendMiscQuestions [miscQuestionId=" + miscQuestionId + ", compMiscellaneousId=" + compMiscellaneousId
				+ ", questionId=" + question + ", mandQuestionId=" + mandQuestionId + "]";
	}

	
	
	
}
