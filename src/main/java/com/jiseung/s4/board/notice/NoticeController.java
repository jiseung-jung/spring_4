package com.jiseung.s4.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jiseung.s4.board.BoardDTO;
import com.jiseung.s4.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	//@RequestMapping(value = "noticeList")
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("board", "notice");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		System.out.println("Notice List Controller");
		mv.setViewName("board/boardList");
		return mv;
	}
	
	
	//----------------------------------------------------------------------------------------
	
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile files, HttpSession session) throws Exception{
		int result = noticeService.setInsert(boardDTO, files, session);
		
		ModelAndView mv = new ModelAndView();
		String msg = "Write Fail";
		
		if(result>0) {
			msg="Write Success!";
		}
		
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", "./noticeList");
		
		return mv;
	}
	

	//----------------------------------------------------------------------------------------
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception{
		BoardDTO oneList = noticeService.getOne(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("oneList", oneList);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}

}
