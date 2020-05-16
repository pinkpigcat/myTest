<%@page import="member2.CommentDAO"%>
<%@page import="java.sql.Timestamp"%>
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


request.setCharacterEncoding("utf-8"); //한글처리
String comment_id =(String)session.getAttribute("id");//댓글 적은사람 아이디
String comment_content=request.getParameter("coment");//댓글내용

int comment_board_num=Integer.parseInt(request.getParameter("num"));//게시판 글 번호
Timestamp comment_date=new Timestamp(System.currentTimeMillis());

CommentBean bean = new CommentBean();
bean.setComment_board_num(comment_board_num);
bean.setComment_content(comment_content);
bean.setComment_id(comment_id);
bean.setComment_date(comment_date);
bean.setComment_num(0);
bean.setComment_p(0);

CommentDAO dao = new CommentDAO();
dao.insertMember(bean);



response.sendRedirect("notice.jsp");
%>
<%=comment_content %>
<%=comment_board_num %>
<%=comment_id%>
<%=comment_date%>
<%=bean.getComment_p()%>
<%=bean.getComment_num()%>

</body>
</html>