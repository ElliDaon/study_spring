package com.my0803.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//�α��� üũ ���� ���ͼ��� Ŭ����
public class Authinterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception{
		
		HttpSession session = request.getSession();
		boolean tf = false;
		
		//session�� midx���� ���� �� (Login���� �ʾ��� ���)
		if(session.getAttribute("midx")==null) {
			
			//���ǿ� �̵��Ϸ��� �ϴ� �ּҸ� ��´�.
			saveUrl(request);
			
			String location = request.getContextPath()+"/member/memberLogin.do";
			response.sendRedirect(location);
			tf = false;
		}else {
			tf = true;
		}
		return tf;
	}
	
	//�̵��Ϸ��� �ϴ� �ּҸ� ���ǿ� ��� �޼ҵ�
	public void saveUrl(HttpServletRequest req) {
		String uri = req.getRequestURI(); //��ü��� �ּ�
		String query = req.getQueryString(); //�Ķ����
		
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
