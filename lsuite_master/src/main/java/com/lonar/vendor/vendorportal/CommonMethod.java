package com.lonar.vendor.vendorportal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.model.LtMastAudit;
import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastAuditRecordsRepository;
import com.lonar.vendor.vendorportal.repository.LtMastAuditRepository;
import com.lonar.vendor.vendorportal.service.LtMastAuditRecordsService;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.danielbechler.diff.node.Visit;

@Service
public class CommonMethod {
	
	@Autowired
	LtMastAuditRepository ltMastAuditRepository;
	
	@Autowired
	LtMastAuditRecordsRepository ltMastAuditRecordsRepository;
	
	@Autowired
	LtMastAuditRecordsService ltMastAuditRecordsService;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public  float saveAudit( Object base,Object work) throws IOException {
		return downcast(base,work);
	}
	
	public  <newClass> float downcast(Object obj1,Object obj2) {
		
		newClass base = (newClass) obj1;
		
		newClass work = (newClass) obj2;
			
			LtMastAudit ltMastAudit = new LtMastAudit();
			ltMastAudit.setCreationDate(new Date());
			ltMastAudit.setCreatedBy(1L);
			ltMastAudit.setMasterName(work.getClass().getName());
			if(base!=null) {
			ltMastAudit.setOldEntity(base+"");
			}
			ltMastAudit.setNewEntity(work+"");
			
			ltMastAudit = ltMastAuditRepository.save(ltMastAudit);
			final float auditId = ltMastAudit.getAuditId();
			
			
		DiffNode diff = ObjectDifferBuilder.buildDefault().compare(work, base);
	//	List<String> list  = new ArrayList<String>();
		diff.visit(new DiffNode.Visitor()
		{
		    public void node(DiffNode node, Visit visit)
		    {
		    	
		        final Object baseValue = node.canonicalGet(base);
		        final Object workingValue = node.canonicalGet(work);
		        final String message = node.getPath() + " changed from " + 
		                               baseValue + " to " + workingValue;
		        //ltMastAudit.setDifference(list.subList(1, list.size()).toString());
				//if(ltMastBranchesBase!=null) {
				//ltMastAudit.setOldEntity(ltMastBranchesBase.toString());
			//	}
				//ltMastAudit.setNewEntity(ltMastBranchesWork.toString());
		        LtMastAuditRecords ltMastAuditRecords = new LtMastAuditRecords();
		        ltMastAuditRecords.setCreationDate(new Date());
		       // ltMastAuditRecords.setCreatedBy(work.getLastUpdatedBy());
		        ltMastAuditRecords.setCreatedBy(1L);
		        ltMastAuditRecords.setValueName(node.getPath().toString().replace("/", ""));
		        ltMastAuditRecords.setOldValue(baseValue+"");
		        ltMastAuditRecords.setNewValue(workingValue+"");
		        ltMastAuditRecords.setAuditId(auditId);
				
				ltMastAuditRecordsRepository.save(ltMastAuditRecords);
		       // list.add(message);
		        //ltMastAudit.setDifference(ltMastAudit.getDifference()+message);
		    }
		});
		return auditId;
		
		//}
		
		
	}
	
	public  List<LtMastAuditRecords> getDifference( Object base,Object work) throws IOException, ServiceException {
		return getDifferenceRec(base,work);
	}
	
	

	public  <newClass> List<LtMastAuditRecords> getDifferenceRec(Object obj1,Object obj2) throws ServiceException {
		
		List<LtMastAuditRecords> diffList = new ArrayList<LtMastAuditRecords>();
		newClass base = (newClass) obj1;
		
		newClass work = (newClass) obj2;
			
			LtMastAudit ltMastAudit = new LtMastAudit();
			ltMastAudit.setCreationDate(new Date());
			ltMastAudit.setCreatedBy(1L);
			ltMastAudit.setMasterName(work.getClass().getName());
			if(base!=null) {
			ltMastAudit.setOldEntity(base+"");
			}
			ltMastAudit.setNewEntity(work+"");
			
			ltMastAudit = ltMastAuditRepository.save(ltMastAudit);
			final float auditId = ltMastAudit.getAuditId();
			
			
		DiffNode diff = ObjectDifferBuilder.buildDefault().compare(work, base);
		List<String> list  = new ArrayList<String>();
		diff.visit(new DiffNode.Visitor()
		{
		    public void node(DiffNode node, Visit visit)
		    {
		    	
		        final Object baseValue = node.canonicalGet(base);
		        final Object workingValue = node.canonicalGet(work);
		        final String message = node.getPath() + " changed from " + 
		                               baseValue + " to " + workingValue;
		        //ltMastAudit.setDifference(list.subList(1, list.size()).toString());
				//if(ltMastBranchesBase!=null) {
				//ltMastAudit.setOldEntity(ltMastBranchesBase.toString());
			//	}
				//ltMastAudit.setNewEntity(ltMastBranchesWork.toString());
		        LtMastAuditRecords ltMastAuditRecords = new LtMastAuditRecords();
		        ltMastAuditRecords.setCreationDate(new Date());
		       // ltMastAuditRecords.setCreatedBy(work.getLastUpdatedBy());
		        ltMastAuditRecords.setCreatedBy(1L);
		        ltMastAuditRecords.setValueName(node.getPath().toString().replace("/", ""));
		        ltMastAuditRecords.setOldValue(baseValue+"");
		        ltMastAuditRecords.setNewValue(workingValue+"");
		        ltMastAuditRecords.setAuditId(auditId);
				
				ltMastAuditRecordsRepository.save(ltMastAuditRecords);
		       // list.add(message);
		        //ltMastAudit.setDifference(ltMastAudit.getDifference()+message);
		    }
		});
		
		return ltMastAuditRecordsService.getByAuditId(auditId);
		
		//}
		
		
	}
	
	

}
