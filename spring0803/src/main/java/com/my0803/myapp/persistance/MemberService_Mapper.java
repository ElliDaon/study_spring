package com.my0803.myapp.persistance;

import java.util.HashMap;

import com.my0803.myapp.domain.MemberVo;

//���̹�Ƽ������ ����� �޼ҵ带 �����س��� ��
public interface MemberService_Mapper {
	
	public int memberInsert(MemberVo mv);
	public MemberVo memberLogin(HashMap hm);
	
}
