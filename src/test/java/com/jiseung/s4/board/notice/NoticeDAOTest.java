package com.jiseung.s4.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiseung.s4.MyTestCase;
import com.jiseung.s4.board.BoardDTO;
import com.jiseung.s4.util.Pager;

public class NoticeDAOTest extends MyTestCase {
	
	//@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void setInsertTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("Title Test");
		boardDTO.setWriter("Writer Test");
		boardDTO.setContents("Contents Test");
		int result = noticeDAO.setInsert(boardDTO);
		
		assertEquals(1,result);
	}
	
	//@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = noticeDAO.getList(pager);
		
		assertNotEquals(0, ar.size());
	}
	


}
