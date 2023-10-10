package com.my0803.myapp.persistance;

import java.util.HashMap;

import com.my0803.myapp.domain.MemberVo;

//마이바티스에서 사용할 메소드를 정의해놓은 곳
public interface MemberService_Mapper {
	
	public int memberInsert(MemberVo mv);
	public MemberVo memberLogin(HashMap hm);
	
}
