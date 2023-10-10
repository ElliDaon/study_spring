package com.my0803.myapp.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my0803.myapp.domain.MemberVo;
import com.my0803.myapp.persistance.MemberService_Mapper;

//��� ���񽺸� ������ Ŭ����
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int memberInsert(MemberVo mv) {
		
		//mybatis���� ����ϴ� �޼ҵ带 �����س��� �������̽��� �θ���.
		MemberService_Mapper msm = sqlSession.getMapper(MemberService_Mapper.class);
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
		
		//���̹�Ƽ���� ������ �غ�
		MemberService_Mapper msm = sqlSession.getMapper(MemberService_Mapper.class);
		mv = msm.memberLogin(hm);
		
		return mv ;
	}
	
}
