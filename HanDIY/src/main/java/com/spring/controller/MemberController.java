package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	// 이메일 중복 체크
	@GetMapping("emailCheck")
	public @ResponseBody int emailCheck(@RequestParam("email_m")String email_m) {
		int chk = ms.emailCheck(email_m);
		System.out.println("이메일 중복확인===" + email_m);
		return chk;
	}
}
