package com.my0803.myapp.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my0803.myapp.domain.MemberVo;
import com.my0803.myapp.persistance.MemberService_Mapper;

//멤버 서비스를 구현할 클래스
@Service
public class MemberServiceImpl implements MemberService{

	private MemberService_Mapper msm;
	
	@Autowired
	public MemberServiceImpl(SqlSession sqlSession) {
		this.msm = sqlSession.getMapper(MemberService_Mapper.class);
	}
	
	@Override
	public int memberInsert(MemberVo mv) {
		
		//mybatis에서 사용하는 메소드를 정의해놓은 인터페이스를 부른다.
		
		int value = msm.memberInsert(mv);
		
		return value;
	}

	@Override
	public MemberVo memberLogin(String memberId, String memberPwd) {
		
		MemberVo mv = null;
		
		//HashMap
		HashMap<String,String> hm = new HashMap<>();
		hm.put("memberId", memberId);
		hm.put("memberPwd", memberPwd);
		
		//마이바티스와 연동할 준비
		mv = msm.memberLogin(hm);
		
		return mv ;
	}

	@Override
	public MemberVo memberLogin2(String memberId) {
		
		MemberVo mv = null;
		mv = msm.memberLogin2(memberId);
		
		return mv;
	}
	
}
