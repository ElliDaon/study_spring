package com.my0803.myapp.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my0803.myapp.domain.BoardVo;
import com.my0803.myapp.persistance.BoardService_Mapper;

@Service
public class BoardServiceImpl implements BoardService{

	private BoardService_Mapper bsm;
	
	@Autowired
	public BoardServiceImpl(SqlSession sqlSession) {
		this.bsm = sqlSession.getMapper(BoardService_Mapper.class);
	}
	
	@Override
	public int boardInsert(BoardVo bv) {
		int value = bsm.boardInsert(bv);
		int bidx = bv.getBidx();
		bsm.boardOriginBidxUpdate(bidx);
		return value;
	}

	@Override
	public ArrayList<BoardVo> boardList() {
		
		return null;
	}
	
}
