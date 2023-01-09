package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "lt_mast_emailtoken")
@XmlRootElement

public class LtMastEmailtoken implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_seq")
	@SequenceGenerator(name = "email_seq", sequenceName = "lt_expense_emailtoken_s", allocationSize = 1)
	@NotNull
	@Column(name = "EMAIL_TOKEN_ID")
	private Long emailTokenId;

	@Size(max = 50)
	@Column(name = "TOKEN_ID")
	private String tokenId;

	@Basic(optional = false)
	@NotNull
	@Column(name = "SEND_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sendDate;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EXPIRED_WITHIN")
	private Long expiredWithin;

	@NotNull
	@Size(max = 100)
	@Column(name = "EMAIL_TEMPLATE")
	private String emailTemplate;

	@NotNull
	@Size(max = 20)
	@Column(name = "EMAIL_STATUS")
	private String emailStatus;

	@NotNull
	//@Size(max = 4000)
	@Column(name = "EMAIL_OBJECT")
	private String emailObject;

	@NotNull
	@Size(max = 4000)
	@Column(name = "EMAIL_TITLE")
	private String emailTitle;

	// @NotNull
	@Column(name = "EMAIL_USER_ID")
	private Long emailUserId;

	@Size(max = 2000)
	@Column(name = "SEND_TO")
	private String sendTo;

	@Size(max = 4000)
	@Column(name = "MESSAGE")
	private String message;

	@Size(max = 2000)
	@Column(name = "SEND_CC")
	private String sendCc;

	@Size(max = 250)
	@Column(name = "ATTACHMENT_PATH")
	private String attachmentPath;

	@Column(name = "FAILURECOUNT")
	private Long failureCount;

	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;

	@Transient
	private String snDate;
	@Transient
	private String enDate;
	@Transient
	private int columnNo;
	@Transient
	private String sort;
	public Long getEmailTokenId() {
		return emailTokenId;
	}
	public void setEmailTokenId(Long emailTokenId) {
		this.emailTokenId = emailTokenId;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Long getExpiredWithin() {
		return expiredWithin;
	}
	public void setExpiredWithin(Long expiredWithin) {
		this.expiredWithin = expiredWithin;
	}
	public String getEmailTemplate() {
		return emailTemplate;
	}
	public void setEmailTemplate(String emailTemplate) {
		this.emailTemplate = emailTemplate;
	}
	public String getEmailStatus() {
		return emailStatus;
	}
	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}
	public String getEmailObject() {
		return emailObject;
	}
	public void setEmailObject(String emailObject) {
		this.emailObject = emailObject;
	}
	public String getEmailTitle() {
		return emailTitle;
	}
	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}
	public Long getEmailUserId() {
		return emailUserId;
	}
	public void setEmailUserId(Long emailUserId) {
		this.emailUserId = emailUserId;
	}
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSendCc() {
		return sendCc;
	}
	public void setSendCc(String sendCc) {
		this.sendCc = sendCc;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public Long getFailureCount() {
		return failureCount;
	}
	public void setFailureCount(Long failureCount) {
		this.failureCount = failureCount;
	}
	public Long getDraw() {
		return draw;
	}
	public void setDraw(Long draw) {
		this.draw = draw;
	}
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	public String getSnDate() {
		return snDate;
	}
	public void setSnDate(String snDate) {
		this.snDate = snDate;
	}
	public String getEnDate() {
		return enDate;
	}
	public void setEnDate(String enDate) {
		this.enDate = enDate;
	}
	public int getColumnNo() {
		return columnNo;
	}
	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "LtMastEmailtoken [emailTokenId=" + emailTokenId + ", tokenId=" + tokenId + ", sendDate=" + sendDate
				+ ", expiredWithin=" + expiredWithin + ", emailTemplate=" + emailTemplate + ", emailStatus="
				+ emailStatus + ", emailObject=" + emailObject + ", emailTitle=" + emailTitle + ", emailUserId="
				+ emailUserId + ", sendTo=" + sendTo + ", message=" + message + ", sendCc=" + sendCc
				+ ", attachmentPath=" + attachmentPath + ", failureCount=" + failureCount + ", draw=" + draw
				+ ", start=" + start + ", length=" + length + ", snDate=" + snDate + ", enDate=" + enDate
				+ ", columnNo=" + columnNo + ", sort=" + sort + "]";
	}

	
}
