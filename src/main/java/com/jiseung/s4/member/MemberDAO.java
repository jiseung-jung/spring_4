package com.jiseung.s4.member;


public interface MemberDAO {
	

	
	//Login
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception;
	
	//Update
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception;
	
	//Delete
	public int setMemberDelete(MemberDTO memberDTO) throws Exception;
	
	//Insert (Join)
	public int setMemberJoin(MemberDTO memberDTO) throws Exception;

}
