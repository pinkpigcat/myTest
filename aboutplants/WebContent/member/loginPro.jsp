<%@page import="member2.MemberDAO"%>
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
String id=request.getParameter("id");
String pass=request.getParameter("pass");

MemberDAO dao = new MemberDAO();
int result=dao.userCheck(id, pass);

%>
<%if(result==1){
	session.setAttribute("id", id);
	response.sendRedirect("../main/main.jsp");
	
	}else if (result==0){%>
	
<script type="text/javascript">
	alert("비밀번호 틀렸음");
	history.back();
</script> 
	<% }else{%>
	<script type="text/javascript">
		alert("아이디 없음");
		history.back();
</script>
	<%}%>

</body>
</html>