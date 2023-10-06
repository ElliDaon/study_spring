package com.my0803.myapp.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my0803.myapp.domain.MemberVo;
import com.my0803.myapp.persistance.MemberService_Mapper;

//멤버 서비스를 구현할 클래스
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int memberInsert(MemberVo mv) {
		
		//mybatis에서 사용하는 메소드를 정의해놓은 인터페이스를 부른다.
		MemberService_Mapper msm = sqlSession.getMapper(MemberService_Mapper.class);
		int value = msm.memberInsert(mv);
		
		return value;
	}
	
	
}
