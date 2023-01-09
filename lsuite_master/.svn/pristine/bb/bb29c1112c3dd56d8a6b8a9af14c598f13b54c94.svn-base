
package com.lonar.vendor.vendorportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="LT_MAST_PROD_SUBCAT_PAYTERMS")
/*@XmlRootElement
@NamedQueries({
	
	@NamedQuery(name = "LtP2pProdSubcatPayterms.findByCategoryId", query = "SELECT l FROM LtP2pProdSubcatPayterms l WHERE l.subCategoryId = :subCategoryId"),
	@NamedQuery(name = "LtP2pProdSubcatPayterms.findByfindByPaytermId", query = "SELECT l FROM LtP2pProdSubcatPayterms l WHERE l.payTermId = :payTermId"),
	@NamedQuery(name = "LtP2pProdSubcatPayterms .findAll", query = "SELECT l FROM LtP2pProdSubcatPayterms  l")
		
		 })*/
public class LtMastProdSubcatPayterms extends BaseClass
{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_subcat_payterms_s")
	@SequenceGenerator(name = "prod_subcat_payterms_s", sequenceName = "LT_MAST_PROD_SUBCAT_PAYTERMS_S", allocationSize = 1)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "PAY_TERM_ID")
	private Long payTermId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "SUB_CATEGORY_ID")
	private Long subCategoryId;
	
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "PERCENTAGE")
	private Float percentage;
	
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "Term_Name")
	private String termName;
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "Term_Category")
	private String termCategory;
	
	
	
	@Transient
	private String updateFlag;
	
	
	
	public Long getPayTermId() {
		return payTermId;
	}

	public void setPayTermId(Long payTermId) {
		this.payTermId = payTermId;
	}

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getTermCategory() {
		return termCategory;
	}

	public void setTermCategory(String termCategory) {
		this.termCategory = termCategory;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	@Override
	public String toString() {
		return "LtP2pProdSubcatPayterms [payTermId=" + payTermId + ", subCategoryId=" + subCategoryId + ", percentage="
				+ percentage + ", termName=" + termName + ", termCategory=" + termCategory + ", updateFlag="
				+ updateFlag + "]";
	}

	
	
	
	
	
	
	
}
