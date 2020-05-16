<%@page import="member2.MemberDAO"%>
<%@page import="member2.MemberBean"%>
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
String id =(String)session.getAttribute("id");
String pass=request.getParameter("pass");
String name=request.getParameter("name");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
String mobile=request.getParameter("mobile");
// String address=request.getParameter("address");
String sample4_detail=request.getParameter("sample4_detail");
String sample4_jibunAddress=request.getParameter("sample4_jibunAddress");
String sample4_postcode=request.getParameter("sample4_postcode");
String sample4_roadAddress=request.getParameter("sample4_roadAddress");

MemberBean bean = new MemberBean();
bean.setId(id);
bean.setPass(pass);
bean.setName(name);
bean.setEmail(email);
bean.setPhone(phone);
bean.setMobile(mobile);
// bean.setAddress(address);
bean.setSample4_detail(sample4_detail);
bean.setSample4_jibunAddress(sample4_jibunAddress);
bean.setSample4_postcode(sample4_postcode);
bean.setSample4_roadAddress(sample4_roadAddress);

MemberDAO dao = new MemberDAO();

int check=dao.userCheck(id, pass);




if(check==1){
	dao.updatemember(bean);
	
%><script type="text/javascript">
	alert("수정성공");
	location.href="../main/main.jsp"
</script>
<%}else{%>
<script type="text/javascript">
	alert("비밀번호를 확인해 주세요");
	history.back(); 
</script>
<%}%>

<%-- <%=sample4_detail %> --%>
<%-- <%=sample4_jibunAddress %> --%>
<%-- <%=sample4_postcode %> --%>
<%-- <%=sample4_roadAddress %> --%>
<%=name %>

<%-- <%=address %> --%>
</body>
</html>