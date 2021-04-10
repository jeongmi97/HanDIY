package com.spring.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.MemberDAO;
import com.spring.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired private MemberDAO dao;
	
	//암호화 기능 사용
	@Autowired BCryptPasswordEncoder pwEncoder;
	
	// bcryptPasswordEncoder 빈 생성 오류 현상으로 빈 생성 해준 후 암호화 실행해주기로 했다.
	@Bean
	BCryptPasswordEncoder pwEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 로그인 기능
	public ModelAndView login(MemberVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/index");	// 로그인 성공 시 인덱스 페이지로 이동
		
		session.getAttribute("loginM");	// 세션 생성
		MemberVO loginM = dao.pwChkM(vo);	// 암호화된 비밀번호 비교하기 위해 입력한 이메일에 맞는 멤버 정보 가져옴
		boolean pwChk = pwEncoder.matches(vo.getPw_m(), loginM.getPw_m()); // db의 비밀번호와 입력 비밀번호 비교 후 맞으면 true, 틀리면 false 반환
		
		if(loginM != null && pwChk == true) {	// 입력 이메일에 일치하는 멤버가 있고, 비밀번호 체크가 true일 경우
			session.setAttribute("loginM", loginM);	// 멤버 로그인 세션에 멤버 정보 저장		
		}else {
			System.out.println("======로그인 실패=======");
			session.setAttribute("loginM", null);	// 멤버 로그인 세션에 null 저장
			mav.setViewName("redirect:/");	// 로그인 실패로 다시 로그인 페이지로 돌아감
		}
		
		return mav;
	}
	
	// 회원가입 기능
	public ModelAndView join(MemberVO vo) {
		ModelAndView mav = new ModelAndView("redirect:/login");	// 회원가입 성공 시 로그인 페이지로 이동
		
		// 입력받은 memberVO의 pw값을 이용해 암호화 인코딩한 후 memberVO의 pw값에 다시 셋팅
		String enPw = pwEncoder.encode(vo.getPw_m());
		vo.setPw_m(enPw);
		
		if(dao.joinM(vo) != 1) {
			System.out.println("======회원가입 실패======");
			mav.setViewName("redirect:/");	// 회원가입 실패 시 다시 회원가입 페이지로 돌아감
		}
		
		return mav;
	}
}
