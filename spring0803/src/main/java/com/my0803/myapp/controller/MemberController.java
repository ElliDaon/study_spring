package com.my0803.myapp.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my0803.myapp.domain.MemberVo;
import com.my0803.myapp.service.MemberService;

@Controller // ��Ʈ�ѷ� �뵵�� ��ü���� ��û
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	MemberService ms;
	// �������̽��� �����ϰ� �����Ѵ�.
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@RequestMapping(value = "/memberJoin.do")
	public String memberJoin() {

		return "/member/memberJoin";
	}

	@RequestMapping(value = "/memberJoinAction.do")
	public String memberJoinAction(MemberVo mv) { // input ��ü���� ���� ���ε��Ѵ�.

		String birth = mv.getMemberYear() + mv.getMemberMonth() + mv.getMemberDay();
		mv.setMemberBirth(birth);
		
		String memberPwd2 = bcryptPasswordEncoder.encode(mv.getMemberPwd());
		mv.setMemberPwd(memberPwd2); 
		

		// ó���ϴ� �Է� ����
		int value = ms.memberInsert(mv);

		return "redirect:/"; // ���������� �ƴ� sendRedirect���
	}

	@RequestMapping(value = "/memberLogin.do")
	public String memberLogin() {

		return "/member/memberLogin";
	}

	@RequestMapping(value = "/memberLoginAction.do")
	public String memberLoginAction(
			@RequestParam("memberId") String memberId, 
			@RequestParam("memberPwd") String memberPwd,
			//HttpSession session,
			HttpServletRequest request,
			RedirectAttributes rttr) {
		

		MemberVo mv = ms.memberLogin2(memberId);
		String path="";
		
		if(mv!=null&&bcryptPasswordEncoder.matches(memberPwd, mv.getMemberPwd())) {
			//session.setAttribute("midx",mv.getMidx());
			//session.setAttribute("memberName", mv.getMemberName());
			
			//1ȸ�� ��Ŭ���� RedirectAttribute
			rttr.addAttribute("midx", mv.getMidx());
			rttr.addAttribute("memberName", mv.getMemberName());
			
			if(request.getSession().getAttribute("saveUrl")!= null) {
				path=(String)request.getSession().getAttribute("saveUrl").toString().substring(request.getContextPath().length()+1);
			}else {
				path="index.jsp";
			}
		}else {
			rttr.addFlashAttribute("msg", "�α������ּ���");
			path="member/memberLogin.do";
		}
		return "redirect:/"+path;
	}
	
	@RequestMapping(value = "/memberLogout.do")
	public String memberLogout(HttpSession session) {
		session.removeAttribute("midx");
		session.removeAttribute("memberName");
		session.invalidate();
		return "redirect:/";
	}
	
	@ResponseBody  //������ �� ��ü�� ������
	@RequestMapping(value = "/memberIdCheck.do")
	public String memberIdCheck(String memberId) {
		
		String str = null;
		int value = ms.memberIdCheck(memberId);
		str = "{\"value\":\""+ value +"\"}";
		
		return str;
	}
	
	@RequestMapping(value = "/memberList.do")
	public String memberList(Model model) {
		ArrayList<MemberVo> list = ms.memberList();
		model.addAttribute("list",list);
		return "/member/memberList";
	}

}
