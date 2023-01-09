
package com.lonar.UserManagement.web.model;

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
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "LT_MAST_SYS_VARIABLES")
@XmlRootElement
public class LtMastSysVariables extends BaseClass implements Serializable 
{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "variables_seq")
	@SequenceGenerator(name = "variables_seq", sequenceName = "LT_MAST_SYS_VARIABLES_S", allocationSize = 1)
	@JsonView(DataTablesOutput.View.class)
	@Basic(optional = false)
	//@NotNull
	@Column(name = "VARIABLE_ID")
	private Long variableId;
	
	@Basic(optional = false)
	//@NotNull
	@Size(min = 1, max = 30)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "VARIABLE_CODE")
	private String variableCode;
	
	@Size(max = 240)
	@SafeHtml
	@Column(name = "VARIABLE_NAME")
	private String variableName;
	
	/*@Size(max = 1)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "USER_VISIBLE")
	private String userVisible;
	
	@Size(max = 1)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "USER_UPDATABLE")
	private String userUpdatable;*/
	
	@Basic(optional = false)
	//@NotNull
	@Size(min = 1, max = 2000)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "SYSTEM_VALUE")
	private String systemValue;
	
	/*@Transient
	private List<LtMastSysVariableValues> ltMastSysVariableValues;*/

	/*@PrePersist
	void preInsert() {
		PrePersistUtil.pre(this);
	}*/

 
	@Transient
	private String stDate;
	@Transient
	private String enDate;
	
	public LtMastSysVariables() {
	}

	public Long getVariableId() {
		return variableId;
	}

	public void setVariableId(Long variableId) {
		this.variableId = variableId;
	}

	public String getVariableCode() {
		return variableCode;
	}

	public void setVariableCode(String variableCode) {
		this.variableCode = variableCode;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	
	
	public String getSystemValue() {
		return systemValue;
	}

	public void setSystemValue(String systemValue) {
		this.systemValue = systemValue;
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

 
}
