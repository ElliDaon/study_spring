package com.my0803.myapp.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.my0803.myapp.domain.BoardVo;
import com.my0803.myapp.domain.PageMaker;
import com.my0803.myapp.domain.SearchCriteria;
import com.my0803.myapp.service.BoardService;
import com.my0803.myapp.util.UploadFileUtiles;

@Controller //컨트롤러 용도의 객체생성 요청
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService bs;
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value="/boardWrite.do")
	public String boardWrite() {
		
		return "/board/boardWrite";
	}
	
	@Autowired(required=false)
	private PageMaker pm;

	@RequestMapping(value="/boardWriteAction.do")
	public String boardWriteAction(BoardVo bv, HttpSession session) throws Exception {
		
		MultipartFile file = bv.getFilename();
		String uploadedFileName="";
		if(!file.getOriginalFilename().equals("")) {
			//업로드 시작
			uploadedFileName = UploadFileUtiles.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		}
		
		System.out.println("uploadFileName: "+uploadedFileName);
		String ip = InetAddress.getLocalHost().getHostAddress();
		bv.setIp(ip);
		bv.setFilename2(uploadedFileName);
		
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
	@RequestMapping(value="/boardModify.do")
	public String boardModify(@RequestParam("bidx") String bidx, Model model) {
		int bidx_n = Integer.parseInt(bidx);
		BoardVo bv = bs.boardContents(bidx_n);
		model.addAttribute("bv",bv);
		return "/board/boardModify";
	}
	@RequestMapping(value="/boardModifyAction.do")
	public String boardModifyAction(BoardVo bv) {
		int result = bs.boardModify(bv);
		if(result!=0) {
			return "redirect:/board/boardContents.do?bidx="+bv.getBidx();
		}
		else {
			return "redirect:/board/boardModify.do?bidx="+bv.getBidx();
		}
	}
	
	@RequestMapping(value="/boardDelete.do")
	public String boardDelete(@RequestParam("bidx") String bidx, Model model) {
		int bidx_n = Integer.parseInt(bidx);
		BoardVo bv = bs.boardContents(bidx_n);
		model.addAttribute("bv",bv);
		return "/board/boardDelete";
	}
	
	@RequestMapping(value="/boardDeleteAction.do")
	public String boardDeleteAction(BoardVo bv) {
		
		int result = bs.boardDelete(bv);
		if(result!=0) {
			return "redirect:/board/boardList.do";
		}
		else {
			return "redirect:/board/boardDelete.do?bidx="+bv.getBidx();
		}
	}
}
