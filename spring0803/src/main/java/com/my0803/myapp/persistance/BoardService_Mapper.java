package com.my0803.myapp.persistance;

import java.util.ArrayList;

import com.my0803.myapp.domain.BoardVo;
import com.my0803.myapp.domain.SearchCriteria;

public interface BoardService_Mapper {
	public int boardInsert(BoardVo bv);
	public int boardOriginBidxUpdate(int bidx);
	public ArrayList<BoardVo> boardList(SearchCriteria scri);
	public int boardTotalCount(SearchCriteria scri);
	public BoardVo boardContents(int bidx);
	public int boardViewCnt(int bidx);
	public int boardModify(BoardVo bv);
	public int boardDelete(BoardVo bv);
	public int boardReply(BoardVo bv);
	public int boardUpdateDepth(BoardVo bv);
	public int boardCommentCnt(int bidx);
}
