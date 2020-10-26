package com.jiseung.s4.board.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jiseung.s4.util.Pager;

@Controller
@RequestMapping(value = "/memo/**")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@GetMapping("memoList")
	public ModelAndView getList(Pager pager) throws Exception{
		System.out.println("===Memo List===");
		List<MemoDTO> ar = memoService.getList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("memo/memoTest");
		return mv;
		
	}
	
	//------------------------------------------------------------------------
	
	@PostMapping("memoWrite")
	public ModelAndView setInsert(MemoDTO memoDTO) throws Exception{
		int result = memoService.setInsert(memoDTO);
		ModelAndView mv = new ModelAndView();
		
		String msg = "Write Fail";
		
		if(result>0) {
			msg = "Write Success";
		}
		
		mv.addObject("msg", msg);
		mv.setViewName("/common/ajaxResult");
		
		return mv;
		
	}
	
	//------------------------------------------------------------------------
	
	@GetMapping("memoTest")
	public ModelAndView memoTest(MemoDTO memoDTO, Pager pager) throws Exception{
//		System.out.println("===Memo Test===");
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("memo/memoTest");
//		System.out.println("Num: "+num);
//		System.out.println("Name: "+name);
		
		memoDTO = memoService.getOne(memoDTO);
		mv.addObject("dto", memoDTO);
		mv.setViewName("memo/memoTest");
		return mv;
	}
	
	@GetMapping("memoPage")
	public void memoPage() throws Exception{
		
	}
	
	//------------------------------------------------------------------------
	
	@GetMapping("memoSelect")
	public ModelAndView getOne(MemoDTO memoDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		return mv;
	}
	
	//------------------------------------------------------------------------
	
	@PostMapping("memoDelete")
	public ModelAndView setDelete(MemoDTO memoDTO) throws Exception{
		int result = memoService.setDelete(memoDTO);
		ModelAndView mv = new ModelAndView();
		
		String msg = "Delete Fail";
		
		if(result>0) {
			msg = "Delete Success";
		}
		
		
		mv.addObject("msg",msg);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}

}
