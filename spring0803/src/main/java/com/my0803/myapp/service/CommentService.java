package com.my0803.myapp.service;

import java.util.ArrayList;

import com.my0803.myapp.domain.CommentVo;

public interface CommentService {
	public ArrayList<CommentVo> commentList();
	public int commentDelete(int cidx);
	public int commentWrite(CommentVo cv);
}
