<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header>
<%
String id =(String)session.getAttribute("id");  
if(id==null){
%>
<div id="login"><a href="../member/login.jsp">login</a> | <a href="../member/join.jsp">join</a></div>
<%}else{%>
<div id="login"><%=id%>님 로그인 하셨습니다 | <a href="../member/updateForm.jsp">정보수정  |</a>
<a href="../member/logout.jsp">logout</a></div>
<%}%>





<div class="clear"></div>
<!-- 로고들어가는 곳 -->
<div id="logo"><img src="../images/funwed2로고_about_plants.png" width="230" height="42" alt="Fun Web"></div>
<!-- 로고들어가는 곳 -->
<nav id="top_menu">
<ul>
	<li><a href="../main/main.jsp">HOME</a></li>
	<li><a href="../company/welcome.jsp">DIRECTION </a></li>
	<li><a href="../center/plant.jsp">PLANT</a></li>
	<li><a href="../center/fnoticeImage.jsp">GALLERY</a></li>
	<li><a href="../center/notice.jsp">BOARD</a></li>
	<li><a href="../mail/mail.jsp">CONTACT US</a></li>
</ul>
</nav>
</header>