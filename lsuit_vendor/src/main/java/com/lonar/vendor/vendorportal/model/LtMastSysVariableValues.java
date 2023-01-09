
package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;


@Entity
@Table(name = "LT_MAST_SYS_VARIABLE_VALUES")

public class LtMastSysVariableValues extends BaseClass implements Serializable 
{

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "variableValues_seq")
	@SequenceGenerator(name = "variableValues_seq", sequenceName = "LT_MAST_SYS_VARIABLE_VALUES_S", allocationSize = 1)
	@Column(name = "VARIABLEVALUESID")
	private Long variableValuesId;
	
	@Column(name = "VARIABLE_ID")
	private Long variableId;
		
	@Column(name = "User_id")
	private String userId;
	
	@Size(max = 240)
	@Column(name = "User_Value")
	private String userValue;
	
	@Transient
	private String userName;

	public LtMastSysVariableValues() {
		super();
		
	}
	public Long getVariableValuesId() {
		return variableValuesId;
	}

	public void setVariableValuesId(Long variableValuesId) {
		this.variableValuesId = variableValuesId;
	}

	public Long getVariableId() {
		return variableId;
	}

	public void setVariableId(Long variableId) {
		this.variableId = variableId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserValue() {
		return userValue;
	}

	public void setUserValue(String userValue) {
		this.userValue = userValue;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "LtMastSysVariableValues [variableValuesId=" + variableValuesId + ", variableId=" + variableId
				+ ", userId=" + userId + ", userValue=" + userValue + ", userName=" + userName + "]";
	}

	

	
}
