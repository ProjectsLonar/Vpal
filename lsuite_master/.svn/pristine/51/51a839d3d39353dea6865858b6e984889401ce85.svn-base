package com.lonar.vendor.vendorportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LT_COMPANY_VEN_MGMT_MISC_QUES")
public class LtCompanyVenMgmtMiscQues extends BaseClass{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	@SequenceGenerator(name = "company_seq", sequenceName = "LT_VEND_MISC_QUESTIONS_S", allocationSize = 1)
	@Column(name = "COMP_VEN_MGMT_MISC_QUES_ID")
	private Long compVenMgmtMiscQuesId;
	
	@Column(name = "COMP_VEN_MGMT_MISC_ID")
	private Long compVenMgmtMiscId;
	
	@Column(name = "MISC_QUESTION_ID")
	private Long miscQuestionId;
	
	@Column(name = "COMP_MISCELLANEOUS_ID")
	private Long compMiscellaneousId;
	
	@Column(name = "QUESTION")
	private String question;
	
	@Column(name = "MAND_QUESTION_ID")
	private String mandQuestionId;

	public Long getCompVenMgmtMiscQuesId() {
		return compVenMgmtMiscQuesId;
	}

	public void setCompVenMgmtMiscQuesId(Long compVenMgmtMiscQuesId) {
		this.compVenMgmtMiscQuesId = compVenMgmtMiscQuesId;
	}

	public Long getCompVenMgmtMiscId() {
		return compVenMgmtMiscId;
	}

	public void setCompVenMgmtMiscId(Long compVenMgmtMiscId) {
		this.compVenMgmtMiscId = compVenMgmtMiscId;
	}

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
		return "LtCompanyVenMgmtMiscQues [compVenMgmtMiscQuesId=" + compVenMgmtMiscQuesId + ", compVenMgmtMiscId="
				+ compVenMgmtMiscId + ", miscQuestionId=" + miscQuestionId + ", compMiscellaneousId="
				+ compMiscellaneousId + ", question=" + question + ", mandQuestionId=" + mandQuestionId + "]";
	}

	

}
