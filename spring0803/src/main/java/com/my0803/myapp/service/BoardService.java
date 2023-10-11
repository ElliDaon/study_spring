package com.my0803.myapp.service;

import java.util.ArrayList;

import com.my0803.myapp.domain.BoardVo;

public interface BoardService {
	public int boardInsert(BoardVo bv);
	public ArrayList<BoardVo> boardList();
	public BoardVo boardContents(int bidx);
}
