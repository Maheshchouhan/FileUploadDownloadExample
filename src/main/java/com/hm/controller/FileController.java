/**
 * 
 */
package com.hm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hm.dao.FileDAO;


/**
 * @author Mahesh Chouhan
 *
 */
@Controller
public class FileController {
	
	@Autowired
	FileDAO fileDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMainPage(ModelMap model) {
		return "main";
	}

	@RequestMapping(value="/savefile",method=RequestMethod.POST)  
	public ModelAndView upload(@RequestParam CommonsMultipartFile file,HttpSession session){
		
		 String path=session.getServletContext().getRealPath("/");  
	        String filename=file.getOriginalFilename();  
	          
	        System.out.println(path+" "+filename);  
	        try{  
	        byte barr[]=file.getBytes();  
	        String newFolder="files";
	        File folder = new File(path+"/"+newFolder);
	        
	        if (!folder.exists()) {
	            if (folder.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
	        }

	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path+"/"+newFolder+"/"+filename));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	        
	        fileDao.SaveFile(newFolder+"/"+filename, filename);
	        
	        }catch(Exception e){System.out.println(e);}  
	        return new ModelAndView("main","msg",filename+" uploaded successfully");  
		
	}

}
