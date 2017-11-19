/**
 * 
 */
package com.hm.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.hm.dao.FileDAO;
import com.hm.entity.FilesUpload;


/**
 * @author Mahesh Chouhan
 *
 */
public class FileDAOImpl implements FileDAO{

	/* (non-Javadoc)
	 * @see com.hm.dao.FileDAO#SaveFile(java.lang.String, java.lang.String)
	 */
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Transactional
	@Override
	public void SaveFile(String filePath, String fileName) {
		System.out.println("Inside File DAO impl");
		if(filePath!=null && filePath.length()!=0){
			try {

				FilesUpload filesEntity=new FilesUpload();
				filesEntity.setFilePath(filePath);
				filesEntity.setFileName(fileName);
				int uploadId=(int) (Math.random()*999999999);
				filesEntity.setUploadId(uploadId);
				hibernateTemplate.save(filesEntity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Invalid file path");
		}
		
	}


}