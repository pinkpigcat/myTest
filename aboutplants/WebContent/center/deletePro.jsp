<%@page import="member2.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

int num=Integer.parseInt(request.getParameter("num"));

String pass=request.getParameter("pass");


BoardDAO dao = new BoardDAO();
int check=dao.deleteboard(num, pass);


if(check==1){
%><script type="text/javascript">
alert("글을 삭제하였습니다");
location.href="fnotice.jsp"
</script>
<%}else{ %>

<script type="text/javascript">
alert("비밀번호를 확인하세요");
history.back();
<%}%>
</script> 
</body>
</html>