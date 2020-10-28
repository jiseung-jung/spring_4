package com.jiseung.s4.member.memberUser;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jiseung.s4.member.MemberDTO;

@Controller
@RequestMapping(value = "/member/**")
public class MemberUserController {
	
	@Autowired
	private MemberUserService memberUserService;
	
	//getMemberLogin
	
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/memberLogin");
		return mv;
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpSession httpSession) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		memberDTO = memberUserService.getMemberLogin(memberDTO);
		String msg = "Login Fail";
		
		if(memberDTO != null) {
			httpSession.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
			
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", msg);
			mv.addObject("path", "./memberLogin");
		}
		
		return mv;
	}
	
	//-----------------------------------------------------------------------------------------
	
	@GetMapping("memberLogout")
	public ModelAndView getMemberLogout(HttpSession httpSession) throws Exception{
		//웹브라우저를 종료시키거나,
		//memberDTO를 null로 대체
		//일정시간 경과(로그인 후 요청이 발생하면 시간이 연장)
		//유지시간을 강제로 0으로 변경
		ModelAndView mv = new ModelAndView();
		httpSession.invalidate();
		mv.setViewName("redirect:../");
		
		return mv;
		
	}
	
	
	//-----------------------------------------------------------------------------------------
	
	@GetMapping("memberPage")
	public ModelAndView getMemberPage() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/memberPage");
		return mv;
		
	}
	
	//-----------------------------------------------------------------------------------------
	
	@GetMapping("memberUpdate")
	public ModelAndView setMemberUpdate() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession httpSession) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO s = (MemberDTO)httpSession.getAttribute("member");
		memberDTO.setId(s.getId());
		int result = memberUserService.setMemberUpdate(memberDTO);
		
		String msg = "Update Fail";
		
		if(result>0) {
			s.setName(memberDTO.getName());
			s.setEmail(memberDTO.getEmail());
			httpSession.setAttribute("member", s);
			msg = "Update Success";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./memberPage");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	
	//-----------------------------------------------------------------------------------------
	
	@GetMapping("memberDelete")
	public ModelAndView setMemberDelete(HttpSession httpSession) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
		int result = memberUserService.setMemberDelete(memberDTO);
		httpSession.invalidate();
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	
	//-----------------------------------------------------------------------------------------
	
	@GetMapping("memberJoin")
	public ModelAndView setMemberJoin()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberJoin");
		return mv;
	}
	
	
	@PostMapping("memberJoin")
	public ModelAndView setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getName());
		System.out.println(photo.getSize());
		System.out.println(photo.getContentType());
		System.out.println("=====================================");
		
		int result = memberUserService.setMemberJoin(memberDTO, photo, session);
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	
	//-----------------------------------------------------------------------------------------
	//idCheck
	
	@GetMapping("memberIdCheck")
	public ModelAndView gerMemberIdCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberUserService.getMemberIdCheck(memberDTO);
		
		int result = 1; //중복
		if(memberDTO == null) {
			result=0;
		}
		
		mv.addObject("msg", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
