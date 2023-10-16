package com.my0803.myapp.persistance;

import java.util.ArrayList;

import com.my0803.myapp.domain.CommentVo;

public interface CommentService_Mapper {
	public ArrayList<CommentVo> commentList(int bidx);
	public int commentDelete(int cidx);
	public int commentWrite(CommentVo cv);
}
