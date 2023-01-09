package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtInvoiceAccounting;

public interface LtInvoiceAccountingDao 
{

	LtInvoiceAccounting getInvoiceAccountingById(Long id);

	List<LtInvoiceAccounting> getInvoiceAccountingByHeaderId(Long id);

	List<LtInvoiceAccounting> getInvoiceAccountingByLineId(Long id);

}
