package com.my0803.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//로그인 체크 인증 인터셉터 클래스
public class Authinterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception{
		
		HttpSession session = request.getSession();
		boolean tf = false;
		
		//session에 midx값이 없을 때 (Login하지 않았을 경우)
		if(session.getAttribute("midx")==null) {
			
			//세션에 이동하려고 하는 주소를 담는다.
			saveUrl(request);
			
			String location = request.getContextPath()+"/member/memberLogin.do";
			response.sendRedirect(location);
			tf = false;
		}else {
			tf = true;
		}
		return tf;
	}
	
	//이동하려고 하는 주소를 세션에 담는 메소드
	public void saveUrl(HttpServletRequest req) {
		String uri = req.getRequestURI(); //전체경로 주소
		String query = req.getQueryString(); //파라미터
		
		if(query == null || query.equals("null")) {
			query="";
		}else {
			query = "?"+query;
		}
		if(req.getMethod().equals("GET")) {
			req.getSession().setAttribute("saveUrl", uri+query);
		}
	}
}
