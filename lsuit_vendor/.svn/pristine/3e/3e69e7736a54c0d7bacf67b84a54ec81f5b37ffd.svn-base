package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtPoShipmentDao;
import com.lonar.vendor.vendorportal.model.LtPoShipment;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Service
public class LtPoShipmentServiceImpl implements LtPoShipmentService{

	@Autowired
	LtPoShipmentDao LtPoShipmentDao;
	
	
	@Override
	public Long getLtPoShipmentCount(Long headerId, Long branchId, LtPoShipment input) throws ServiceException {
		return LtPoShipmentDao.getLtPoShipmentCount(headerId,branchId,input);
	}

	@Override
	public List<LtPoShipment> getLtPoShipmentDataTable(Long headerId, Long branchId, LtPoShipment input)
			throws ServiceException {
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{
			input.setColumnNo(11);
		}
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{
			input.setColumnNo(16);
		}
		
		if(input.getColumnNo()==7 && input.getSort().equals("asc"))
		{
			input.setColumnNo(17);
		}
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{
			input.setColumnNo(18);
		}
		if(input.getColumnNo()==9 && input.getSort().equals("asc"))
		{
			input.setColumnNo(19);
		}
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(1);
		}
		return LtPoShipmentDao.getLtPoShipmentDataTable(headerId,branchId,input);
	}

}
