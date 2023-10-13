package com.my0803.myapp.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my0803.myapp.domain.BoardVo;
import com.my0803.myapp.domain.SearchCriteria;
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
	public ArrayList<BoardVo> boardList(SearchCriteria scri) {
	
		int value = (scri.getPage()-1)*10;
		scri.setPage(value);
		ArrayList<BoardVo> list = bsm.boardList(scri);
		return list;
	}

	@Override
	public BoardVo boardContents(int bidx) {
		BoardVo bv = null;
		bsm.boardViewCnt(bidx);		
		bv = bsm.boardContents(bidx);
		return bv;
	}

	@Override
	public int boardTotalCount(SearchCriteria scri) {
		int value = bsm.boardTotalCount(scri);
		return value;
	}

	@Override
	public int boardModify(BoardVo bv) {
		int value = bsm.boardModify(bv);
		return value;
	}

	@Override
	public int boardDelete(BoardVo bv) {
		int value = bsm.boardDelete(bv);
		
		return value;
	}

	
}
