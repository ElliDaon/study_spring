package com.my0803.myapp.service;

import java.util.ArrayList;

import com.my0803.myapp.domain.BoardVo;
import com.my0803.myapp.domain.SearchCriteria;

public interface BoardService {
	public int boardInsert(BoardVo bv);
	public ArrayList<BoardVo> boardList(SearchCriteria scri);
	public int boardTotalCount(SearchCriteria scri);
	public BoardVo boardContents(int bidx);
	public int boardModify(BoardVo bv);
	public int boardDelete(BoardVo bv);
	public int boardReply(BoardVo bv);
	public int boardCommentCnt(int bidx);
}
