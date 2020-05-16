<%@page import="member2.MemberDAO"%>
<%@page import="member2.MemberBean"%>
<%@page import="java.sql.Timestamp"%>
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

String id =request.getParameter("id");
String pass=request.getParameter("pass");
String name=request.getParameter("name");
Timestamp reg_date=new Timestamp(System.currentTimeMillis());
String email=request.getParameter("email");
// String address=request.getParameter("address");
String phone=request.getParameter("phone");
String mobile=request.getParameter("mobile");
String sample4_postcode=request.getParameter("sample4_postcode");
String sample4_roadAddress=request.getParameter("sample4_roadAddress");
String sample4_jibunAddress=request.getParameter("sample4_jibunAddress");
String sample4_detail=request.getParameter("sample4_detail");


MemberBean bean = new MemberBean();
bean.setId(id);
bean.setPass(pass);
bean.setName(name);
bean.setReg_date(reg_date);
bean.setEmail(email);
// bean.setAddress(address);
bean.setPhone(phone);
bean.setMobile(mobile);
bean.setSample4_detail(sample4_detail);
bean.setSample4_jibunAddress(sample4_jibunAddress);
bean.setSample4_postcode(sample4_postcode);
bean.setSample4_roadAddress(sample4_roadAddress);






MemberDAO dao = new MemberDAO();
dao.insertMember(bean);


%>

<%-- <%=sample4_postcode %> --%>
<%-- <%=sample4_roadAddress %> --%>
<%-- <%=sample4_jibunAddress %> --%>
<%-- <%=sample4_detail %> --%>


<script type="text/javascript">
	alert("회원가입성공");
	location.href="login.jsp"; 
 </script> 
 

</body>
</html>