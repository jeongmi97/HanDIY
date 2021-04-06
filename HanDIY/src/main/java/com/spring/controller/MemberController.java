package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	// 로그인 페이지로 이동
	@RequestMapping("login")
	public void login() {
		System.out.println("login 페이지 이동");
	}
	
	// 로그인 시도 할 때
	@PostMapping("login")
	public ModelAndView login(MemberVO vo,HttpSession session) {
		return ms.login(vo, session);
	}
	
	// 회원가입 페이지로 이동
	@RequestMapping("join")
	public void join() {
		System.out.println("join 페이지 이동");
	}
	
	// 회원가입 시도 할 때
	@PostMapping("join")
	public ModelAndView join(MemberVO vo) {
		return ms.join(vo);
	}
	
	@RequestMapping("index")
	public void index() {
		System.out.println("index 페이지 이동");
	}
}
