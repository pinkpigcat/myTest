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
// int num=Integer.parseInt(request.getParameter("num"));
int comment_board_num=Integer.parseInt(request.getParameter("comment_board_num"));
int comment_num=Integer.parseInt(request.getParameter("comment_num"));

String comment=request.getParameter("comment");

CommentBean beanC = new CommentBean();
CommentDAO daoC = new CommentDAO();
daoC.updateComment(comment_board_num,comment_num,comment);

response.sendRedirect("notice.jsp");
%>
<%=comment%>
<%=comment_num %>
<%=comment_board_num%>


</body>
</html>