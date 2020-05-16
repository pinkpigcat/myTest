<%@page import="member2.BoardDAO"%>
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
int num=Integer.parseInt(request.getParameter("num"));
String name=request.getParameter("name");
String pass=request.getParameter("pass");
String subject=request.getParameter("subject");
String content=request.getParameter("content");


BoardBean bean = new BoardBean();
bean.setNum(num);
bean.setName(name);
bean.setPass(pass);
bean.setSubject(subject);
bean.setContent(content);

BoardDAO dao = new BoardDAO();
int check = dao.updateboard(bean);




if(check==1){%>
<script type="text/javascript">
alert("수정성공");
location.href="notice.jsp";
</script>
	
	
	<%}else{%>
		<script type="text/javascript">
			alert("비밀번호틀림");
			history.back();
		</script>
		
	<%}%>

</body>
</html>