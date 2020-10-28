package com.jiseung.s4.member.memberUser;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiseung.s4.MyTestCase;
import com.jiseung.s4.member.MemberDTO;

public class MemberUserDAOTest extends MyTestCase{
	
	//@Autowired
	private MemberUserDAO memberUserDAO;

	//@Test
	public void getMemberLoginTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id3");
		memberDTO.setPw("pw3");
		memberDTO = memberUserDAO.getMemberLogin(memberDTO);
		
		assertNotNull(memberDTO);
	}
	
	//@Test
	public void getMemberIdCheckTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("dsfdsfsdf");
		memberDTO = memberUserDAO.getMemberIdCheck(memberDTO);
		
		assertNull(memberDTO);
	}
	
	
	
}
