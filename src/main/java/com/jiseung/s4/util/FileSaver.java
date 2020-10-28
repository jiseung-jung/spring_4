package com.jiseung.s4.util;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	//save 메서드명
	
	//FilecopyUtil.copy
//	public void saveCopy(File dest, MultipartFile multipartFile)throws Exception{
//		
//		if(!dest.exists()) {
//			dest.mkdirs();
//		}
//		
//		String fileName = UUID.randomUUID().toString();
//		fileName = fileName+"_"+ multipartFile.getOriginalFilename();
//		
//		dest = new File(dest, fileName);
//		
//		FileCopyUtils.copy(multipartFile.getBytes(), dest);
//		
//	}

	
	
	//MutipartFile transferTo
	public String save(MultipartFile photo, HttpSession session, String path) throws Exception {
		System.out.println(path);
		File file2 = new File(path);
		if(!file2.exists()) {
			file2.mkdirs();
		}
		
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		String name = photo.getOriginalFilename();
		name = time+"_"+name;
		System.out.println(name);
		
		File file = new File(path, name);
		
		photo.transferTo(file);
		
		return name;
	}
	
	

}
