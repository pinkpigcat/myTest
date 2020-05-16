<%@page import="member2.BoardDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="member2.BoardBean"%>
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
request.setCharacterEncoding("utf-8");

request.getAttribute("id");

String name=request.getParameter("name");
String pass=request.getParameter("pass");
String subject =request.getParameter("subject");
String content=request.getParameter("content");
int readcount=0;
Timestamp date=new Timestamp(System.currentTimeMillis());

BoardBean bean = new BoardBean();

bean.setName(name);
bean.setPass(pass);
bean.setSubject(subject);
bean.setContent(content);
bean.setDate(date);
bean.setReadcount(readcount);

BoardDAO dao = new BoardDAO();
dao.insertBoard(bean);




response.sendRedirect("notice.jsp");


%>

</body>
</html>