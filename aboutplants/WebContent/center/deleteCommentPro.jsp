<%@page import="member2.CommentDAO"%>
<%@page import="member2.CommentBean"%>
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
int comment_num=Integer.parseInt(request.getParameter("comment_num"));



CommentBean beanC = new CommentBean();
CommentDAO daoC = new CommentDAO();
daoC.deleteComment(num,comment_num);

response.sendRedirect("notice.jsp");
%>
<%=num %>
<%=comment_num%>
</body>
</html>