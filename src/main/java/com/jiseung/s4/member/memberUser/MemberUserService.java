package com.jiseung.s4.member.memberUser;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jiseung.s4.member.MemberDTO;
import com.jiseung.s4.member.MemberService;
import com.jiseung.s4.member.memberFile.MemberFileDAO;
import com.jiseung.s4.member.memberFile.MemberFileDTO;
import com.jiseung.s4.util.FileSaver;

import oracle.net.aso.f;

@Service
public class MemberUserService implements MemberService {
	
	@Autowired
	private MemberUserDAO memberUserDAO;
	
	@Autowired
	private MemberFileDAO memberFileDAO;
	@Autowired
	private FileSaver filesaver;

	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberLogin(memberDTO);
	}

	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberUpdate(memberDTO);
	}

	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberDelete(memberDTO);
	}

	@Override
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		
		// HDD 어느 폴더에 어떤 이름으로 저장할거냐
		// 저장할 폴더 경로
		String filename ="";
		String path = session.getServletContext().getRealPath("/resources/upload/member");

		//memberFile Insert
		
		int result = memberUserDAO.setMemberJoin(memberDTO);
		
		if(photo.getSize() != 0) {
		filename = filesaver.save(photo, session, path);
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFilename(filename);
		memberFileDTO.setOriname(photo.getOriginalFilename());
		result = memberFileDAO.setInsert(memberFileDTO);
		}
		
		return  result; 
		
//		File file2 = new File(path);
//		if(!file2.exists()) {
//			file2.mkdirs();
//		}
		
		//System.out.println(path);
		
		
		// 이름
		// 1. 시간
//		Calendar ca = Calendar.getInstance();
//		long time=ca.getTimeInMillis();
//		String name =photo.getOriginalFilename();
//		name=time+"_"+name;
//		System.out.println(name);
//		
//		// 2. Unique한 이름 생성하는 객체
//		name = UUID.randomUUID().toString();
//		name = name+"_"+photo.getOriginalFilename();
//		System.out.println(name);
//		
//		
//		File file = new File(path, name);
		
		//HDD 저장
		//1. FilecopyUtils 라는 객체의 메서드 활용
		//byte [] ar = photo.getBytes();
		//FileCopyUtils.copy(ar, file);
		
		//2. MultipartFile 객체의 메서드 활용
//		photo.transferTo(file);
		
		//return memberUserDAO.setMemberJoin(memberDTO);
	}

	@Override
	public MemberDTO getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberIdCheck(memberDTO);
	}
	
	
	public MemberFileDTO getOne(MemberDTO memberDTO) throws Exception{
		return memberFileDAO.getOne(memberDTO);
	} 
	
	
	
	
	
	
	
	
	
	

}
