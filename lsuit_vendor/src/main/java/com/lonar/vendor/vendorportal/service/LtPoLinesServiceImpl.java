package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtPoLinesDao;
import com.lonar.vendor.vendorportal.model.LtPoLines;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Service
public class LtPoLinesServiceImpl implements LtPoLinesService {

	@Autowired
	LtPoLinesDao ltPoLinesDao;
	
	@Override
	public Long getLtPoLinesCount(Long headerId, LtPoLines input) throws ServiceException {
		return ltPoLinesDao.getLtPoLinesCount(headerId,input);
	}

	@Override
	public List<LtPoLines> getLtPoLinesDataTable(Long headerId, LtPoLines input) throws ServiceException {
		if(input.getSort()==null) {
			input.setSort("desc");
		}
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
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{
			input.setColumnNo(17);
		}
		if(input.getColumnNo()==8 && input.getSort().equals("desc"))
		{
			input.setColumnNo(18);
		}
		if(input.getColumnNo()==9 && input.getSort().equals("asc"))
		{
			input.setColumnNo(19);
		}
		return ltPoLinesDao.getLtPoLinesDataTable(headerId,input);
	}

	@Override
	public List<LtPoLines> getAllPoLinesByHeaderId(Long headerId) throws ServiceException {
		return ltPoLinesDao.getAllPoLinesByHeaderId(headerId);
	}

	@Override
	public LtPoLines getPoLinesByPolineId(Long poLineId) throws ServiceException {
		return ltPoLinesDao.getPoLinesByPolineId(poLineId);
	}

}
