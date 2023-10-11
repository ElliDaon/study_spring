package com.my0803.myapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my0803.myapp.domain.BoardVo;
import com.my0803.myapp.service.BoardService;

@Controller //컨트롤러 용도의 객체생성 요청
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService bs;
	
	@RequestMapping(value="/boardWrite.do")
	public String boardWrite() {
		
		return "/board/boardWrite";
	}
	

	@RequestMapping(value="/boardWriteAction.do")
	public String boardWriteAction(BoardVo bv, HttpSession session) {
		
		bv.setMidx(((Integer)session.getAttribute("midx")).intValue());
		int value = bs.boardInsert(bv);
		
		return "redirect:/board/boardList.do";
	}
	
	@RequestMapping(value="/boardList.do")
	public String boardList(Model model) {
		ArrayList<BoardVo> list = bs.boardList();
		model.addAttribute("list",list);
		return "/board/boardList";
	}
}
