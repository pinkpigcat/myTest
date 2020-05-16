<%@page import="java.text.SimpleDateFormat"%>
<%@page import="member2.BoardBean"%>
<%@page import="java.util.List"%>
<%@page import="member2.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->
</head>
<body>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp"/>
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 메인이미지 -->
<div id="sub_img_center"></div>
<!-- 메인이미지 -->

<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<ul>
<li><a href="../center/notice.jsp">Notice</a></li>
<li><a href="#">Public News</a></li>
<li><a href="../center/fnotice.jsp">Driver Download</a></li>
<li><a href="#">Service Policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->

<!-- 게시판 -->
<%
BoardDAO dao = new BoardDAO();

int count=0;
count=dao.getBoardCount();

int pageSize=15;

String pageNum=request.getParameter("pageNum");
if(pageNum==null){//처음 페이지를 들어갔을때는 가져올 pagenum이 없기때문에 null 이고 이때 페이지목록 1 이 보일수있도록 설정
	pageNum="1";
}

int currentPage=Integer.parseInt(pageNum); //현재페이지 번호
int startRow=(currentPage-1)*pageSize+1;
int endRow=currentPage*pageSize;

List list = null;

if(count!=0){
	list=dao.getboardlist(startRow,pageSize);
}


//날짜모양설정 => 문자열로 출력해줌 
SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");



%>
<article>
 <div>
        <form action="sendMail.jsp" method="post">
            <table>
                <tr><th colspan="2">메일 보내기</th></tr>
                <tr><td>보내는 사람</td><td><input type="text" name="from" /></td></tr>
                <tr><td>받는 사람</td><td><input type="text" name="to" /></td></tr>
                <tr><td>제목</td><td><input type="text" name="subject" /></td></tr>
                <tr><td>내용</td><td><textarea name="content" style="width:170px; height:200px;"></textarea></td></tr>
                <tr><td colspan="2" style="text-align:right;"><input type="submit" value="Transmission"/></td></tr>
            </table>
        </form>
    </div>







<!-- 검색창 -->

<!-- 검색창 -->



</article>
<!-- 게시판 -->
<!-- 본문들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"/>
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>