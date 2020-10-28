package com.jiseung.s4.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiseung.s4.MyTestCase;

public class MemberFileTest extends MyTestCase{

	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Test(expected = RuntimeException.class)
	public void setInsertTest()throws Exception{
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId("id3");
		memberFileDTO.setFilename("fileName");
		memberFileDTO.setOriname("Oriname");
		int result = memberFileDAO.setInsert(memberFileDTO);
		assertEquals(1, result);
	}
}
