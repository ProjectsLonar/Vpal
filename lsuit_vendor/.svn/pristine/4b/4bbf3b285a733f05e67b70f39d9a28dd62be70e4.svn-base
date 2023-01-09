package com.lonar.vendor.vendorportal.service;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.dao.LtMastSysVariablesDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorAgreementAttachmentDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorAgreementsDao;
import com.lonar.vendor.vendorportal.model.LtMastVendorAgreements;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;

@Service
public class LtMastVendorAgreementsServiceImpl implements LtMastVendorAgreementsService
{
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@Autowired
	LtMastVendorAgreementsDao ltMastVendorAgreementsDao;
	
	@Autowired
	LtMastVendorAgreementAttachmentService vendorAgreementAttachmentService;
	
	@Autowired
	LtMastVendorAgreementAttachmentDao ltMastVendorAgreementAttachmentDao;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtMastSysVariablesDao ltMastSysVariablesDao;
	
	private String saveDirectory;
	
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Transactional
	@Override
	public List<LtMastVendorAgreements> getAllVendorAgrrement() throws ServiceException 
	{
		 List<LtMastVendorAgreements> vendorAgreementList=new ArrayList<LtMastVendorAgreements>();
			
				vendorAgreementList=ltMastVendorAgreementsDao.getAllVendorAgrrement();
			
			return vendorAgreementList;
	}

	@Transactional
	@Override
	public LtMastVendorAgreements getVendorAgreementById(Long vendorAggId) throws ServiceException
	{
		LtMastVendorAgreements vendorAgreement=new LtMastVendorAgreements();
		
		vendorAgreement=ltMastVendorAgreementsDao.getVendorAgreementById(vendorAggId);
		if(vendorAgreement.getAttachment()!=null)
		{
				List<SysVariableWithValues> sysVariableWithValuesList=
						ltMastSysVariablesDao.getBySysVariableName("FILE_OPEN_PATH",vendorAgreement.getCompanyId());
				
					if(sysVariableWithValuesList!=null)
					{
						if(sysVariableWithValuesList.get(0).getLtMastSysVariableValues().get(0)!=null)
						{
							saveDirectory=sysVariableWithValuesList.get(0).getLtMastSysVariableValues().get(0).getUserValue();
						}
						else
						{
							saveDirectory=sysVariableWithValuesList.get(0).getLtMastSysVariables().getSystemValue();
						}
					}
				vendorAgreement.setAttachment(saveDirectory+vendorAgreement.getImageName());
			}
		return vendorAgreement;
	}
	
	@Transactional
	@Override
	public List<LtMastVendorAgreements> getAllVendorAgrrementByVendorId(Long vendorId) throws ServiceException 
	{
		 List<LtMastVendorAgreements> vendorAgreementList=new ArrayList<LtMastVendorAgreements>();
			
		vendorAgreementList=ltMastVendorAgreementsDao.getAllVendorAgrrementByVendorId(vendorId);
		
		/*for (Iterator iterator = vendorAgreementList.iterator(); iterator.hasNext();) 
		{
			LtMastVendorAgreements ltMastVendorAgreements = (LtMastVendorAgreements) iterator.next();
			
			if(  ltMastVendorAgreements.getAttachment()!=null)
			{
				String attachpath=ltMastVendorAgreements.getAttachment();
				if(attachpath.contains("/"))
				{
					int ind=attachpath.indexOf("/");
					attachpath=attachpath.substring(ind, attachpath.length());
					if(attachpath.contains("/"))
					{
						int i=attachpath.indexOf("/");
						attachpath=attachpath.substring(i, attachpath.length());
					}
					ltMastVendorAgreements.setAttachment(attachpath);
				}
				
			}
			else
			{
				ltMastVendorAgreements.setAttachment(null);
			}
			
		}*/
		
		return vendorAgreementList;
	}

	@Transactional
	@Override
	public Status save(LtMastVendorAgreements vendorAggreement) throws ServiceException
	{
			Status status=new Status();
			String chknull=checkNull(vendorAggreement);
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
				String msg=null;
				Long venAgreementId=ltMastVendorAgreementsDao.save(vendorAggreement);
				if(venAgreementId!=null)
				{
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
					if( status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
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

	@Transactional
	@Override
	public Status saveWithAttachment(LtMastVendorAgreements vendorAggreement, MultipartFile[] files) throws ServiceException 
	{
		Status status=new Status();
		String fileName = null;
		String chknull=checkNull(vendorAggreement);
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
			Long venAgreementId=ltMastVendorAgreementsDao.save(vendorAggreement);
			if(venAgreementId!=null)
			{
				if (files != null && files.length >0) 
	    		{
	    			SysVariableWithValues sysVariableWithValues=
	    					ltMastSysVariablesService.getBySysVariableName("VENDOR_ATTACHMENT_FOLDER_PATH",vendorAggreement.getCompanyId());
	    			if(sysVariableWithValues!=null)
	    			{
	    				if(sysVariableWithValues.getLtMastSysVariableValues().get(0)!=null){
	    					saveDirectory=sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();
	    				}
	    				else{
	    					saveDirectory=sysVariableWithValues.getLtMastSysVariables().getSystemValue();
	    				}
	    			}
					
	    			File dir = new File(saveDirectory);
	    			if (!dir.exists())
					{
						dir.mkdirs();
						if(!dir.isDirectory())
						{
							status=ltMastCommonMessageService.getCodeAndMessage(NO_DIRECTIVE_EXISTS);
							if(status.getMessage()==null)
							{
								status.setCode(EXCEPTION);
								status.setMessage("Error in finding message! The action was unsuccessful");
							}
							
							return status;
						}
					}	
				
	    			for(int i =0 ;i< files.length; i++)
	    			{
		            try 
		            {
		                fileName = files[i].getOriginalFilename();
		                byte[] bytes = files[i].getBytes();
		                BufferedOutputStream buffStream = 
		                        new BufferedOutputStream(new FileOutputStream(new File(saveDirectory + fileName)));
		                buffStream.write(bytes);
		                 
		               if( ltMastVendorAgreementAttachmentDao.multipleSave(vendorAggreement.getVendorId(),venAgreementId,
		                		fileName, saveDirectory))
		               {
		            	   vendorAggreement.setAgreementId(venAgreementId.longValue());
		            	   vendorAggreement.setAttachment(saveDirectory+fileName);
		            	  if( ltMastVendorAgreementsDao.update(vendorAggreement))
		            	  {
		            		  buffStream.close();
			            	   status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			            	   if( status.getMessage()==null)
			            	   {
			            		   status.setCode(SUCCESS);
			            		   status.setMessage("Error in finding message! The action is completed successfully.");
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
		            catch (Exception e)
		            {
		            	e.printStackTrace();
		            	 status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
						if(status.getMessage()==null)
						{
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}
		            }
	    		}
	    		
	    		}
			   status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
          	   if( status.getMessage()==null)
          	   {
          		   status.setCode(SUCCESS);
          		   status.setMessage("Error in finding message! The action is completed successfully.");
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
	
	@Transactional
	@Override
	public Status update(LtMastVendorAgreements vendorAggreement, MultipartFile[] files) throws Exception 
	{
		Status status=new Status();
		String fileName = null;
		if(vendorAggreement.getAgreementId()!=null)
		{
			String chknull=checkNull(vendorAggreement);
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
				if(ltMastVendorAgreementsDao.update(vendorAggreement))
				{
					if (files != null && files.length >0) 
			    	{
						SysVariableWithValues sysVariableWithValues=
			    				ltMastSysVariablesService.getBySysVariableName("VENDOR_ATTACHMENT_FOLDER_PATH",vendorAggreement.getCompanyId());
						
			    		if(sysVariableWithValues!=null)
			    		{
			    			if(sysVariableWithValues.getLtMastSysVariableValues().get(0)!=null)
			    			{
			    				saveDirectory=sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();
			    			}
			    			else
			    			{
			    				saveDirectory=sysVariableWithValues.getLtMastSysVariables().getSystemValue();
			    			}
			    		}
					
			    		File dir = new File(saveDirectory);
			    		if (!dir.exists())
						{
							dir.mkdirs();
							if(!dir.isDirectory())
							{
								status=ltMastCommonMessageService.getCodeAndMessage(NO_DIRECTIVE_EXISTS);
								if(status.getMessage()==null)
								{
									status.setCode(EXCEPTION);
									status.setMessage("Error in finding message! The action was unsuccessful");
								}
								return status;
							}
						}	
						for(int i =0 ;i< files.length; i++)
			    		{
				            try 
				            {
				                fileName = files[i].getOriginalFilename();
				                byte[] bytes = files[i].getBytes();
				                BufferedOutputStream buffStream = 
				                        new BufferedOutputStream(new FileOutputStream(new File(saveDirectory + fileName)));
				                buffStream.write(bytes);
				                 
				               if( ltMastVendorAgreementAttachmentDao.multipleUpdate(vendorAggreement.getVendorId(),vendorAggreement.getAgreementId().longValue(),
				                		fileName, saveDirectory))
				               {
				            	   vendorAggreement.setAgreementId(vendorAggreement.getAgreementId());
				            	   vendorAggreement.setAttachment(saveDirectory+fileName);
				            	  if( ltMastVendorAgreementsDao.update(vendorAggreement))
				            	  {
				            		  buffStream.close();
				            		   
					            	   status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
					            	   if( status.getMessage()==null)
					            	   {
					            		   status.setCode(SUCCESS);
					            		   status.setMessage("Error in finding message! The action is completed successfully.");
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
				            catch (Exception e)
				            {
				            	e.printStackTrace();
				            	 status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
								if(status.getMessage()==null)
								{
									status.setCode(EXCEPTION);
									status.setMessage("Error in finding message! The action was unsuccessful");
								}
				            }
			    		}
			    		
			        	
			    	}
					else
					{
						 if(vendorAggreement.getAttachment()==null)
	            		  {
	            			  ltMastVendorAgreementAttachmentDao.deleteFile(vendorAggreement.getAgreementId().longValue());
	            			  status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
	            			  if( status.getMessage()==null)
	            			  {
	            				  status.setCode(SUCCESS);
	            				  status.setMessage("Error in finding message! The action is completed successfully.");
	            			  }
	            		  }	
					}
						status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
						if( status.getMessage()==null)
						{
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action is completed successfully.");
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
			
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
		return status;
	}

	@Transactional
	@Override
	public Status delete(Long vendorAgreementId) throws ServiceException
	{
		Status status=new Status();
		
			if(ltMastVendorAgreementsDao.delete(vendorAgreementId))
			{
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
		
		
		return status;
	}
	
	
	public static String checkNull(LtMastVendorAgreements vendorAggreement)
	{
		if(vendorAggreement.getAgreementCode()==null || vendorAggreement.getStartDate()==null  
			 || vendorAggreement.getLastUpdateLogin()==null)
		{
			return "null";
		}
		else
			return "notnull";
		
	}


	@Override
	public Long getLtMastVendorAgreementsCount(LtMastVendorAgreements input,Long companyId) throws ServiceException {
		return ltMastVendorAgreementsDao.getLtMastVendorAgreementsCount(input,companyId);
	}


	@Override
	public List<LtMastVendorAgreements> getLtMastVendorAgreementsDataTable(LtMastVendorAgreements input,Long companyId)
			throws ServiceException {
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
		return ltMastVendorAgreementsDao.getAgreementsDataTable(input,companyId);
	}


	@Override
	public Long getLtMastVendorAgreementsCountByVenId(LtMastVendorAgreements input, Long vendorId)
			throws ServiceException {
		return ltMastVendorAgreementsDao.getLtMastVendorAgreementsCountByVenId(input,vendorId);
	}


	@Override
	public List<LtMastVendorAgreements> getLtMastVendorAgreementsDataTableByVenId(LtMastVendorAgreements input,
			Long vendorId) throws ServiceException {
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
		return ltMastVendorAgreementsDao.getLtMastVendorAgreementsDataTable(input,vendorId);
	}


	@Override
	public Status deleteAttachment(Long vendorAgreementId) throws ServiceException 
	{
		Status status = new Status();
		if(ltMastVendorAgreementsDao.deleteAttachment(vendorAgreementId))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ATTACHEMENT_DELETED_SUCCESS);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ATTACHEMENT_DELETED_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
	
	
		return status;
		
	}

	

	

}
