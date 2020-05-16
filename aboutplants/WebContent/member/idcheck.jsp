<%@page import="member2.MemberDAO"%>
<%@page import="member2.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function idselect(){

	opener.document.join.id.value=document.wfr.wid.value;
window.close();
}

</script>



</head>



<body>
<h1>idcheck.jsp 아이디 중복 체크 </h1>
<%
String id =request.getParameter("wid");
out.println(id);

// MemberBean bean = new MemberBean();

// bean.setId(id);
MemberDAO dao = new MemberDAO();

int check=dao.idcheck(id);

if(check==1){
	out.println("중복된 아이디 입니다");


}else{
	out.println("사용가능한 아이디 입니다");
	
	%>
	<input type="button" value="아이디선택" onclick="idselect()">
	<%
	

}%>




<form action="idcheck.jsp" method="get" name="wfr">
아이디 <input type ="text" name="wid" value="<%=id%>"><br>
<input type="submit" value="아이디중복체크">

</form>




</body>
</html>