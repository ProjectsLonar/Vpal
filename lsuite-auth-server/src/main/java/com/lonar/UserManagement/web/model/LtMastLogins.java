
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lonar.UserManagement.web.model;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LT_MAST_LOGINS")
@XmlRootElement
public class LtMastLogins implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logins_seq")
	@SequenceGenerator(name = "logins_seq", sequenceName = "LT_MAST_LOGINS_S", allocationSize = 1)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LOGIN_ID")
	private Long loginId;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "USER_ID")
	private long userId;

	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "IP_ADDRESS")
	private String ipAddress;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "OLD_PASSWORD")
	private String oldPassword;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "TEMP_END_DATE")
	private Date tmpEndDate;

	public LtMastLogins() {
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Date getTmpEndDate() {
		return tmpEndDate;
	}

	public void setTmpEndDate(Date tmpEndDate) {
		this.tmpEndDate = tmpEndDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LtMastLogins other = (LtMastLogins) obj;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LtMastLogins [loginId=" + loginId + ", userId=" + userId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", ipAddress=" + ipAddress + "]";
	}

}
