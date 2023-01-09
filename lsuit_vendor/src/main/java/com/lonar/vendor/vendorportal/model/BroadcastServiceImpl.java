package com.lonar.vendor.vendorportal.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.BroadcastDao;

@Service
public class BroadcastServiceImpl implements BroadcastService {

	@Autowired
	BroadcastDao broadcastDao;
	
	@Override
	public List<String> getMailIdByStatus(String status) throws ServiceException {
		return broadcastDao.getMailIdByStatus(status);
	}

	@Override
	public List<StatusCodeName> getAllStatus() throws ServiceException {
		return broadcastDao.getAllStatus();
	}
	
}
