package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.vo.MemberVO;

public class MemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberVO loginM = (MemberVO) session.getAttribute("loginM");	// 로그인 멤버 세션 정보 저장
		
		if(loginM == null) {	// 로그인 멤버 세션 값이 null일 경우 메인 페이지로 이동
			response.sendRedirect("/");	
			return false;
		}
		
		// 로그인 멤버 세션 값 존재 시 요청받은 페이지로 이동
		return true;
	}

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("afterrrrrrrrr");
	}
}
