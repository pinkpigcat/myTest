<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="member2.BoardDAO"%>
<%@page import="member2.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>



<% 

int comment_board_num=Integer.parseInt(request.getParameter("num"));

int comment_num=Integer.parseInt(request.getParameter("comment_num"));

%>

<%-- <%=comment_board_num %> --%>
<%-- <%=comment_num%> --%>
<div id="wrap">
<article>
<form action="updateCommentPro.jsp" >
<table id="notice">

<tr>
	<td>수정할 댓글</td><td></td>
	<td style="background-color: gray;">댓글내용</td><td ><input type="text" name="comment"></td>
	<td> </td><td></td>
	<td> </td><td></td><td></td>
	<td><input type="hidden" value="<%=comment_board_num%>" name="comment_board_num"> </td><td><input type="hidden" value="<%=comment_num%>" name="comment_num"></td><td></td>
	<td><input type="submit" value="댓글수정"></td></tr>
	</table>
</form>
</article>


<%-- <jsp:forward page="updateComment2.jsp"></jsp:forward> --%>
<!-- 예예 -->
<%-- <tr><td style="background-color: gray;">댓글내용</td><td ><%=beanC.getComment_content() %></td> --%>
<%-- 	<td>작성자</td><td><%=beanC.getComment_id() %></td> --%>
<%-- 	<td>작성일</td><td><%=sdf.format(beanC.getComment_date())%></td><td></td> --%>
<%-- 	<td><input type="button" onclick="location.href='deleteCommentPro.jsp?num=<%=num%>&comment_num=<%=beanC.getComment_num() %>'" value="댓글삭제"></td> --%>
<%-- 	<td><input type="button" onclick='<jsp:forward page="updateCommentPro.jsp"></jsp:forward>p>location.href='updateCommentForm.jsp?num=<%=num%>&comment_num=<%=beanC.getComment_num() %>'" value="댓글수정"></td> --%>
<!-- 	<tr> -->
</div>
</body>
</html>