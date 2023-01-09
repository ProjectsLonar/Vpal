package com.lonar.vendor.vendorportal.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.model.FileStorageProperties;

@Service
public class FileStorageService 
{

	 private final Path fileStorageLocation;
	 

	    @Autowired
	    public FileStorageService(FileStorageProperties fileStorageProperties) {
	        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
	                .toAbsolutePath().normalize();

	        try {
	            Files.createDirectories(this.fileStorageLocation);
	        } catch (Exception ex) {
	            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
	        }
	    }
	    
	 public Resource loadFileAsResource(String fileName) {
	        try {
	            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
	            Resource resource = new UrlResource(filePath.toUri());
	            if(resource.exists()) {
	                return resource;
	            } 
	        } catch (MalformedURLException ex) {
	            ex.printStackTrace();
	        }
			return null;
	 }

	public List<Resource> loadAllFileAsResource() throws MalformedURLException 
	{
		List<Resource> list = new ArrayList<Resource>();
		File file = new File("C:/LexaApplication/Upload/Images/");
		    File[] files = file.listFiles();
		
		
		for(int i =0 ; i<files.length;i++) {
			String fileName = files[i].getName();
			  Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			 
				Resource resource = new UrlResource(filePath.toUri());

				if(resource.exists()) {
				    list.add(resource);
				    
				} 
		}
         
	
	
	 /*URL url = new URL("C:/LexaApplication/Upload/");
	    InputStream is = null;
	    try {
	        is = url.openStream();
	        byte[] buffer = new byte[1024];
	        int bytesRead = -1;
	        StringBuilder page = new StringBuilder(1024);
	        while ((bytesRead = is.read(buffer)) != -1) {
	            page.append(new String(buffer, 0, bytesRead));
	        }
	        // Spend the rest of your life using String methods
	        // to parse the result...
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (Exception e) {
	        }
	    }*/
		return list;
	}
}
