package com.lonar.vendor.vendorportal.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LT_MAST_COMMON_MESSAGES")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastCommonMessage extends BaseClass {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_seq")
	@SequenceGenerator(name = "message_seq", sequenceName = "lt_mast_common_messages_s", allocationSize = 1)
	@Column(name = "MESSAGE_ID")
	private Long messageId;

	@Basic(optional = false)
	// @NotNull(message="notnull")
	@Column(name = "MESSAGE_CODE")
	private String messageCode;

	// @Size(max = 150)
	@Column(name = "MESSAGE_NAME")
	private String messageName;

	// @Size(max = 4000)
	@Column(name = "MESSAGE_DESC")
	private String messageDesc;

	// @Size(max = 30)
	@Column(name = "STATUS")
	private String status;

	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;

	@Transient
	private String stDate;
	@Transient
	private String enDate;
	@Transient
	private int columnNo;

	@Transient
	private String sort;

	public LtMastCommonMessage() {
		super();
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public String getMessageDesc() {
		return messageDesc;
	}

	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getStDate() {
		return stDate;
	}

	public void setStDate(String stDate) {
		this.stDate = stDate;
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
		return "LtMastCommonMessage [messageId=" + messageId + ", messageCode=" + messageCode + ", messageName="
				+ messageName + ", messageDesc=" + messageDesc + ", status=" + status + ", draw=" + draw + ", start="
				+ start + ", length=" + length + ", stDate=" + stDate + ", enDate=" + enDate + ", columnNo=" + columnNo
				+ ", sort=" + sort + "]";
	}

	
}
