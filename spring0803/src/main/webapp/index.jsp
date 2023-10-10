<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>기본페이지 입니당</h2>
<a href="<%=request.getContextPath()%>/index.do">헬로월드 페이지</a>
<a href="<%=request.getContextPath()%>/introduction.do">자기소개 페이지</a>
<br>
<a href="<%=request.getContextPath()%>/member/memberJoin.do">회원가입 페이지</a>
<br>
<br>
<%if(session.getAttribute("midx")==null){%>
<a href="<%=request.getContextPath()%>/member/memberLogin.do">로그인 페이지</a>
<%} else{ %>
<a href="<%=request.getContextPath()%>/member/memberLogout.do">로그아웃</a>
<%} %>

<br>
<a href="<%=request.getContextPath()%>/board/boardWrite.do">글쓰기 페이지</a>

</body>
</html>