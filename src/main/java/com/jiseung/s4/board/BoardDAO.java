package com.jiseung.s4.board;

import java.util.List;

import com.jiseung.s4.util.Pager;

public interface BoardDAO {
	
	//추상 메서드와 상수만 가질 수 있음
	//abstract , 메서드의 선언부
	//접근지정자는 무조건 public , abstract 무조건 들어가야하지만 안써주면 자동으로 넣어줌.
	
	
	
	
	
	//insert
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//update
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//selectOne
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception;
	
	//count
	public long getCount(Pager pager) throws Exception;

}
