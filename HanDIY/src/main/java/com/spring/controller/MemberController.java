package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.MemberService;
import com.spring.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired MemberService ms;
	
	@RequestMapping("login")
	public void login() {
		System.out.println("login 페이지 이동");
	}
	
	@PostMapping("login")
	public ModelAndView login(MemberVO vo) {
		return ms.login(vo);
	}
	
	@RequestMapping("join")
	public void join() {
		System.out.println("join 페이지 이동");
	}
}
