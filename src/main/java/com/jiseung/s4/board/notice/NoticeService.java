package com.jiseung.s4.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jiseung.s4.board.BoardDTO;
import com.jiseung.s4.board.BoardService;
import com.jiseung.s4.util.FileSaver;
import com.jiseung.s4.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver filesaver;

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile files, HttpSession session) throws Exception {
		
		String path = session.getServletContext().getRealPath("/resources/upload/notice");
		System.out.println(path);
		
		filesaver.save(files, session, path);
		
//		Calendar ca = Calendar.getInstance();
//		long time = ca.getTimeInMillis();
//		String name = files.getOriginalFilename();
//		name = time+"_"+name;
//		System.out.println(name);
//		
//		File file = new File(path, name);
//		
//		files.transferTo(file);
		
		return 0;
		//return noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(noticeDAO.getCount(pager));
		pager.makePage();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getOne(boardDTO);
	}
	
	

}
