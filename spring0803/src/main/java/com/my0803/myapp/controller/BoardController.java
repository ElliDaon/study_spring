package com.my0803.myapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my0803.myapp.domain.BoardVo;
import com.my0803.myapp.domain.PageMaker;
import com.my0803.myapp.domain.SearchCriteria;
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
	
	@Autowired(required=false)
	private PageMaker pm;

	@RequestMapping(value="/boardWriteAction.do")
	public String boardWriteAction(BoardVo bv, HttpSession session) {
		
		bv.setMidx(((Integer)session.getAttribute("midx")).intValue());

		int value = bs.boardInsert(bv);
		
		return "redirect:/board/boardList.do";
	}
	
	@RequestMapping(value="/boardList.do")
	public String boardList(SearchCriteria scri, Model model) {
		
		int totalCount = bs.boardTotalCount(scri);
		pm.setScri(scri);
		pm.setTotalCount(totalCount);
		
		ArrayList<BoardVo> list = bs.boardList(scri);
		model.addAttribute("list",list);
		model.addAttribute("pm", pm);
		return "/board/boardList";
	}
	
	@RequestMapping(value="/boardContents.do")
	public String boardContent(@RequestParam("bidx") String bidx, Model model) {
		int bidx_n = Integer.parseInt(bidx);
		BoardVo bv = bs.boardContents(bidx_n);
		model.addAttribute("bv",bv);
		return "/board/boardContents";
	}
}
