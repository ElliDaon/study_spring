package com.my0803.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //��Ʈ�ѷ� �뵵�� ��ü���� ��û
@RequestMapping(value="/board")
public class BoardController {
	
	@RequestMapping(value="/boardWrite.do")
	public String boardWrite() {
		
		return "/board/boardWrite";
	}
}
