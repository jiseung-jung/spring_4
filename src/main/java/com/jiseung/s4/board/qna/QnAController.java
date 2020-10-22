package com.jiseung.s4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jiseung.s4.board.BoardDTO;
import com.jiseung.s4.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnAController {
	
	@Autowired
	private QnAService qnaService;
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		
		mv.addObject("board", "qna");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	
	//----------------------------------------------------------------------------------------
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception{
		int result = qnaService.setInsert(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		String msg = "Write Fail";
		
		if(result>0) {
			msg="Write Success!";
		}
		
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaList");
		
		return mv;
	}

}
