package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtInvoiceHeadersDao;
import com.lonar.vendor.vendorportal.dao.LtInvoiceLinesDao;
import com.lonar.vendor.vendorportal.dao.LtPoLinesDao;
import com.lonar.vendor.vendorportal.dao.LtPoShipmentDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.LtInvoiceLines;
import com.lonar.vendor.vendorportal.model.LtPoLines;
import com.lonar.vendor.vendorportal.model.LtPoShipment;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtInvoiceHeadersRepository;
import com.lonar.vendor.vendorportal.repository.LtInvoiceLinesRepository;

@Service
public class LtInvoiceLineServiceImpl implements LtInvoiceLineService, CodeMaster{

	@Autowired
	LtInvoiceLinesDao ltInvoiceLinesDao;
	
	@Autowired
	LtInvoiceLinesRepository ltInvoiceLinesRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtInvoiceHeadersDao ltInvoiceHeadersDao;
	
	@Autowired
	LtPoLinesDao ltPoLinesDao;
	
	@Autowired
	LtPoShipmentDao ltPoShipmentDao;
	
	@Autowired
	LtInvoiceHeadersRepository ltInvoiceHeadersRepository;
	
	@Override
	public Long getLtInvoiceLinesCount(LtInvoiceLines input) throws ServiceException {
		return ltInvoiceLinesDao.getLtInvoiceLinesCount(input);
	}

	@Override
	public List<LtInvoiceLines> getLtInvoiceLinesDataTable(LtInvoiceLines input) throws ServiceException {
		return ltInvoiceLinesDao.getLtInvoiceLinesDataTable(input);
	}

	@Override
	public LtInvoiceLines getInvoiceLineById(Long id) throws ServiceException {
		return ltInvoiceLinesDao.getInvoiceLineById(id);
	}

	@Override
	public List<LtInvoiceLines> getAllInvoiceLinesByHeaderId(Long id) throws ServiceException {
		return ltInvoiceLinesDao.getAllInvoiceLinesByHeaderId(id);
	}

	@Override
	public Status save(LtInvoiceLines ltInvoiceLines) throws ServiceException {
		Status status=new Status();
		String chknull=checkNull(ltInvoiceLines);
		if(chknull.equals("null"))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		else
		{
				Long invoiceLineId=ltInvoiceLinesDao.save(ltInvoiceLines);
				if(invoiceLineId!=null)
				{
					if(ltInvoiceLinesDao.updateAmount(ltInvoiceLines)) {
						status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
						if( status.getMessage()==null)
						{
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action is completed successfully.");
						}
						status.setData(invoiceLineId);
					}
				}
				else
				{
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					if(status.getMessage()==null)
					{
						status.setCode(EXCEPTION);
						status.setMessage("Error in finding message! The action was unsuccessful");
					}
				}
		}
		return status;
	}
	

	private String checkNull(LtInvoiceLines ltInvoiceLines) {
		if(ltInvoiceLines.getCreatedBy()==null || ltInvoiceLines.getCreationDate()==null || 
				ltInvoiceLines.getLastUpdateLogin()==null)
		{
			return "null";
		}
		else
			return "notnull";
	}

	@Override
	public Status update(LtInvoiceLines ltInvoiceLines) throws ServiceException {
		Status status=new Status();
		String chknull=checkNull(ltInvoiceLines);
		if(chknull.equals("null") || ltInvoiceLines.getInvoiceHeaderId()==null || ltInvoiceLines.getInvoiceLineId() == null)
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		else
		{
			ltInvoiceLines = ltInvoiceLinesRepository.save(ltInvoiceLines);
				
				if(ltInvoiceLines.getInvoiceLineId()!=null)
				{
					if(ltInvoiceLinesDao.updateAmount(ltInvoiceLines)) {
						status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
						if( status.getMessage()==null)
						{
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action is completed successfully.");
						}
						status.setData(ltInvoiceLines.getInvoiceLineId());
					}
				}
				else
				{
					status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
					if(status.getMessage()==null)
					{
						status.setCode(EXCEPTION);
						status.setMessage("Error in finding message! The action was unsuccessful");
					}
				}
		}
		return status;
	}

	@Transactional
	@Override
	public Status delete(Long id) {
		Status status = new Status();
		try {
		LtInvoiceLines ltInvoiceLines = ltInvoiceLinesRepository.findOne(id);
		if(ltInvoiceLinesRepository.exists(id)) {
			if(ltInvoiceLines.getPoHeaderId()!=null && ltInvoiceLines.getPoLineId()!=null) {
				if(ltInvoiceLinesDao.updateFlag(ltInvoiceLines)) {
					ltInvoiceLinesRepository.delete(id);
				}else {
					ltInvoiceLinesRepository.delete(id);
				}
			}else {
				ltInvoiceLinesRepository.delete(id);
			}
		}
		if(!ltInvoiceLinesRepository.exists(id)) {
			if(ltInvoiceLinesDao.updateAmount(ltInvoiceLines)) {
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				status.setData(ltInvoiceLines.getInvoiceLineId());
			}else {
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return status;
	}

	@Override
	public Long getLtInvoiceLinesCountByHeader(LtInvoiceLines input, Long id) throws ServiceException {
		return ltInvoiceLinesDao.getLtInvoiceLinesCountByHeader(input,id);
	}

	@Override
	public List<LtInvoiceLines> getLtInvoiceLinesDataTableByHeader(LtInvoiceLines input, Long id)
			throws ServiceException {
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{ input.setColumnNo(11); }
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(14); }
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{ input.setColumnNo(15); }
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{ input.setColumnNo(16); }
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{ input.setColumnNo(17); }
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{ input.setColumnNo(18); }
		return ltInvoiceLinesDao.getLtInvoiceLinesDataTableByHeader(input,id);
	}

	@Override
	public Status loadLines(List<Long> poShipmentlist, Long invoiceHeaderId) throws ServiceException {
		Status status = new Status();
		LtInvoiceHeaders ltInvoiceHeaders = ltInvoiceHeadersRepository.findOne(invoiceHeaderId);
		for(Long ltPoShipmentId : poShipmentlist) {
			//LtPoLines ltPoLine = ltPoLinesDao.getPoLinesByPolineId(ltPoLineId);
			LtPoShipment ltPoShipment = ltPoShipmentDao.getByPoShipmentId(ltPoShipmentId);
			
			
			LtInvoiceLines ltInvoiceLines = new LtInvoiceLines();
			ltInvoiceLines.setInvoiceHeaderId(invoiceHeaderId);
			ltInvoiceLines.setPoHeaderId(ltPoShipment.getPoHeaderId());
			ltInvoiceLines.setPoLineId(ltPoShipment.getPoLineId());
			ltInvoiceLines.setPoShipmentLineId(ltPoShipmentId);
			ltInvoiceLines.setLineType(ltPoShipment.getLineType());
			ltInvoiceLines.setCategoryId(ltPoShipment.getCategoryId());
			ltInvoiceLines.setSubCategoryId(ltPoShipment.getSubCategoryId());
			ltInvoiceLines.setProductId(ltPoShipment.getProductId());
			ltInvoiceLines.setInvoiceQuantity(ltPoShipment.getQuantityOrdered());
			ltInvoiceLines.setDescription(ltPoShipment.getProductDescription());
			ltInvoiceLines.setDeliveryDate(ltPoShipment.getDueDate());
			ltInvoiceLines.setInvoiceRate(ltPoShipment.getUnitPrice());
			
			ltInvoiceLines.setHsnSacNo(ltPoShipment.getHsnSacCode());
			ltInvoiceLines.setUom(ltPoShipment.getUom());
			ltInvoiceLines.setCreationDate(new Date());
			ltInvoiceLines.setLastUpdateDate(new Date());
			ltInvoiceLines.setCreatedBy(ltInvoiceHeaders.getLastUpdateLogin());
			ltInvoiceLines.setLastUpdatedBy(ltInvoiceHeaders.getLastUpdateLogin());
			ltInvoiceLines.setLastUpdatedBy(ltInvoiceHeaders.getLastUpdateLogin());
			ltInvoiceLines.setLastUpdateLogin(ltInvoiceHeaders.getLastUpdateLogin());
			
			Long invoiceLineId = ltInvoiceLinesDao.save(ltInvoiceLines);
			if(invoiceLineId==null) {
				status.setCode(FAIL);
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				return status;
			}
			ltPoShipmentDao.updateFlag(ltPoShipmentId);
			//ltPoLinesDao.updateFlage(ltPoLineId);
		}
		status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
		return status;
		
	}

}
