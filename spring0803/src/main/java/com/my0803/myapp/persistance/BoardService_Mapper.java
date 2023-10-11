package com.my0803.myapp.persistance;

import java.util.ArrayList;

import com.my0803.myapp.domain.BoardVo;

public interface BoardService_Mapper {
	public int boardInsert(BoardVo bv);
	public int boardOriginBidxUpdate(int bidx);
	public ArrayList<BoardVo> boardList();
	public BoardVo boardContents(int bidx);
	public int boardViewCnt(int bidx);
}
