package com.lonar.vendor.vendorportal.csvupload;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LtMastSysRequestsServiceImpl implements LtMastSysRequestsService
{
	@Autowired
	LtMastSysRequestsDao ltMastSysRequestsDao;
	
	@Override
	public Long getCount(LtMastSysRequests input) throws Exception 
	{
		// TODO Auto-generated method stub
		return ltMastSysRequestsDao.getCount(input);
	}

	@Override
	public List<LtMastSysRequests> getLtMastSysRequestsDataTableRecords(LtMastSysRequests input) throws Exception 
	{
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
		if(input.getColumnNo()==8 && input.getSort().equals("desc"))
		{ input.setColumnNo(18); }
		if(input.getColumnNo()==9 && input.getSort().equals("asc"))
		{ input.setColumnNo(19); }
		return ltMastSysRequestsDao.getLtMastSysRequestsDataTableRecords(input);
	}

	@Override
	public Long getLtMastSysRequestReportCount(LtMastSysRequestReport input, Long reqId) throws Exception {
		// TODO Auto-generated method stub
		return ltMastSysRequestsDao.getLtMastSysRequestReportCount(input,reqId);
	}

	@Override
	public List<LtMastSysRequestReport> getLtMastSysRequestReportDataTableRecords(LtMastSysRequestReport input,Long reqId)
			throws Exception {
	/*	if(input.getColumnNo()==0 && input.getSort().equals("desc"))
		{ input.setColumnNo(11); }*/
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(14); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(15); }
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{ input.setColumnNo(16); }
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{ input.setColumnNo(17); }
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{ input.setColumnNo(18); }
		
		return ltMastSysRequestsDao.getLtMastSysRequestReportDataTableRecords(input,reqId);
	}

}
