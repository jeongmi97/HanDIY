package com.spring.dao;

import com.spring.vo.MemberVO;

public interface MemberDAO {

	// 멤버 로그인 
	MemberVO pwChkM(MemberVO vo);

	int joinM(MemberVO vo);

	
}
