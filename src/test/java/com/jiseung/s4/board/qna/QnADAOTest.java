package com.jiseung.s4.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiseung.s4.MyTestCase;
import com.jiseung.s4.board.BoardDAO;
import com.jiseung.s4.board.BoardDTO;
import com.jiseung.s4.util.Pager;

public class QnADAOTest extends MyTestCase{

	@Autowired
	private QnADAO qnADAO;
	
	//@Test
	public void setInsertTest() throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("Title Test");
		boardDTO.setWriter("Writer Test");
		boardDTO.setContents("Contents Test");
		int result = qnADAO.setInsert(boardDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = qnADAO.getList(pager);
		
		assertNotEquals(0, ar.size());
	}

}
