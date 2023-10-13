<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("midx")==null){
		out.println("<script>alert('로그인하셔야합니다!');location.href='"+
	request.getContextPath()+"/member/memberLogin.do'</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시물 작성</title>
<style>
body {
	background: #f6f4f3;
	margin:0;
	text-align: center;
}
nav {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: #5b5b5b;
	padding: 8px 12px;
}

#menubar ul{
	margin: 0;
	padding: 0;
	width: 100%;
}
#menubar ul li{
	display: inline-block;
	list-style-type: none;
	padding: 0px 15px;
}
#menubar ul li a {
	color: white;
	text-decoration: none;
}
#menubar ul li a:hover {
	color: yellow;
	text-decoration: none;
}

#content_page {
	display: block;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

</style>
<script>
function check(){
	
	var fm = document.frm;
	
	if(fm.subject.value ==""){
		alert("제목을 입력하세요");
		fm.subject.focus();
		return;
	} else if(fm.contents.value ==""){
		alert("내용을 입력하세요");
		fm.contents.focus();
		return;
	} else if(fm.writer.value ==""){
		alert("닉네임을 입력하세요");
		fm.writer.focus();
		return;
	} else if(fm.pwd.value ==""){
		alert("비밀번호를 입력하세요");
		fm.pwd.focus();
		return;
	}
	
	fm.action = "<%=request.getContextPath()%>/board/boardWriteAction.do"; 
	fm.method = "post"; 
	fm.enctype= "multipart/form-data";
	fm.submit();
	
}
</script>
</head>
<body>
	<nav id="menubar">
		<ul>
			<li><a href="../member/memberList.do">회원목록</a></li>
			<li><a href="boardList.do">게시글 목록</a></li>
			<li><a href="boardWrite.do">게시글 쓰기</a></li>
			<li><a href="../member/memberLogin.do">로그인</a></li>
			<li><a href="../member/memberJoin.do">회원가입</a></li>
		</ul>
	</nav>
	<h3>게시판 작성</h3>
	<hr>
	<form name="frm" id="frm">
	<div id="content_page">
		<div id="in_title">
			<textarea name="subject" id="subject" rows="1" cols="50"
				placeholder="제목" maxlength="100" value=""></textarea>
		</div>

		<div id="in_content">
			<textarea name="contents" id="contents" placeholder="내용" rows="20"
				cols="50"></textarea>
		</div>
		<div class="filebox">
			<label for="filename">
			<input type="file" id="filename" name = "filename" value=""  ></label>
		</div>
		<div>
			닉네임: <input type="text" name = "writer" id="writer" placeholder="닉네임" value="" >
		</div>
		<div>
			비밀번호: <input type="password" name = "pwd" id="pwd" placeholder="비밀번호" value="" >
		</div>
		<br><br>
		<div>
			<input type="button" name="btn" value="등록하기" onclick="check();">
		</div>
	</div>
	</form>
</body>
</html>