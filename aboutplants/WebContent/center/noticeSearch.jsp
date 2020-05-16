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
<li><a href="#">Notice</a></li>
<li><a href="#">Public News</a></li>
<li><a href="#">Driver Download</a></li>
<li><a href="#">Service Policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->

<!-- 게시판 -->
<%
request.setCharacterEncoding("utf-8");

String search=request.getParameter("search");

BoardDAO dao = new BoardDAO();

int count=0;
count=dao.getBoardCount(search);

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
	list=dao.getboardlist(startRow,pageSize,search);
}


//날짜모양설정 => 문자열로 출력해줌 
SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
%>

<article>
<h1>Notice Search</h1>
<table id="notice">
<tr><th class="tno">No.</th>
    <th class="ttitle">Title</th>
    <th class="twrite">Writer</th>
    <th class="tdate">Date</th>
    <th class="tread">Read</th></tr>
    <%for(int i = 0; i<list.size(); i++){
		 BoardBean bean = (BoardBean)list.get(i);//오브젝트->빈 타입으로 다운캐스팅
	%>
<tr onclick="location.href='content.jsp?num=<%=bean.getNum()%>'"><td><%=bean.getNum()%></td><td class="left"><%=bean.getSubject()%></td>
    <td><%=bean.getName() %></td><td><%=sdf.format(bean.getDate()) %></td><td><%=bean.getReadcount() %></td></tr>
<%}%>

</table>



<%
//전체 페이지 50,  한 화면에 보여줄 글 개수 10 => 페이지 수 5개
//전체 페이지 59,  한 화면에 보여줄 글 개수 10 => 페이지 수 6개   

int pageCount=count/pageSize+(count%pageSize == 0? 0:1);

int pageBlock=3;


int startpage=((currentPage-1)/pageBlock)*pageBlock+1;
System.out.print(startpage);

int endpage=startpage+pageBlock-1;

if(pageCount<endpage){
	
	endpage=pageCount;
}

%>


<!-- 검색창 -->
<div id="table_search">
<form action="noticeSearch.jsp" method="post">
<input type="text" name="search" class="input_box">
<input type="submit" value="search" class="btn">
</form>
</div>
<!-- 검색창 -->


<%
String id =(String)session.getAttribute("id");



if(id!=null){
%>
<div id="table_search">
<input type="button" value="글쓰기" class="btn" onclick="location.href='writeForm.jsp'" >
</div><%}%>

<div class="clear"></div>
<div id="page_control">
<%if(startpage>pageBlock){%>
<a href="noticeSearch.jsp?pageNum=<%=startpage-pageBlock%>&search=<%=search%>">Prev</a>
<%}%>
<!-- <a href="#">1</a><a href="#">2</a><a href="#">3</a> -->
<!-- <a href="#">4</a><a href="#">5</a><a href="#">6</a> -->
<!-- <a href="#">7</a><a href="#">8</a><a href="#">9</a> -->
<!-- <a href="#">10</a> -->
<%for(int i=startpage;i<=endpage;i++){%>
	<a href="noticeSearch.jsp?pageNum=<%=i%>&search=<%=search%>"><%=i%></a> <%


}
%>

<%
if(pageCount>endpage){%>
<a href="noticeSearch.jsp?pageNum=<%=startpage+pageBlock%>&search=<%=search%>">Next</a>
<%}%>
</div>
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