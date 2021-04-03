package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.MemberDAO;
import com.spring.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired private MemberDAO dao;
	
	public ModelAndView login(MemberVO vo) {
		ModelAndView mav = new ModelAndView("index");
		
		if(dao.login(vo) == null) {
			System.out.println("======로그인 실패=======");
			mav.setViewName("redirect:/");
		}
		
		return mav;
	}
}
