package com.my0803.myapp.service;

import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my0803.myapp.domain.CommentVo;
import com.my0803.myapp.persistance.CommentService_Mapper;

@Service
public class CommentServiceImpl implements CommentService{

private CommentService_Mapper csm;
	
	@Autowired
	public CommentServiceImpl(SqlSession sqlSession) {
		this.csm = sqlSession.getMapper(CommentService_Mapper.class);
	}
	
	@Override
	public ArrayList<CommentVo> commentList(int bidx) {
		ArrayList<CommentVo> cv = csm.commentList(bidx);
		return cv;
	}

	@Override
	public int commentDelete(int cidx) {
		int value = csm.commentDelete(cidx);
		return value;
	}

	@Override
	public int commentWrite(CommentVo cv) {
		int value = csm.commentWrite(cv);
		return value;
	}

}
