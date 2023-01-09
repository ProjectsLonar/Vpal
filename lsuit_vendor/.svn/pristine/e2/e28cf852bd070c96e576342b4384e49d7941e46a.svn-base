package com.lonar.vendor.vendorportal.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_MAST_VENDOR_MISC_QUESTIONS")
@JsonInclude(Include.NON_NULL)
public class LtMastVendorMiscQuestions 
{

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorMiscQuestion_seq")
	@SequenceGenerator(name = "vendorMiscQuestion_seq", sequenceName = "LT_MAST_VEND_MISC_QUESTIONS_S", allocationSize = 1)
	@Column(name = "QUESTION_ID")
	private Long questionId;
	
	@Column(name = "MISC_QUESTION_ID")
	private Long miscQuestionId;
	
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@Column(name = "ANSWER")
	private String answer;

	@Basic(optional = false)
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Basic(optional = false)
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	@Transient
	private String question;
	
	@Transient
	private String mandQuestionId;
	
	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getMiscQuestionId() {
		return miscQuestionId;
	}

	public void setMiscQuestionId(Long miscQuestionId) {
		this.miscQuestionId = miscQuestionId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
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
		return "LtMastVendorMiscQuestions [questionId=" + questionId + ", miscQuestionId=" + miscQuestionId
				+ ", vendorId=" + vendorId + ", answer=" + answer + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", question=" + question + ", mandQuestionId=" + mandQuestionId
				+ "]";
	}

	
	
}
