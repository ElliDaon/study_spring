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

	private MemberService_Mapper msm;
	
	@Autowired
	public MemberServiceImpl(SqlSession sqlSession) {
		this.msm = sqlSession.getMapper(MemberService_Mapper.class);
	}
	
	@Override
	public int memberInsert(MemberVo mv) {
		
		//mybatis���� ����ϴ� �޼ҵ带 �����س��� �������̽��� �θ���.
		
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
