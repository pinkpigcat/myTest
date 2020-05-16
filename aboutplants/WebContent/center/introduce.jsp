<%@page import="member2.MemberDAO"%>
<%@page import="member2.MemberBean"%>
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
 <style type="text/css">
 
 
 
/*  td{width: 300px;} */
 
 
 td{text-align: left; border-bottom: 0;}
 .asdf{border-bottom: none;
 	height: 5px;
 }
 
 tr{border-bottom: none;}
 
  h2{
  font-size: 20px; }

.ya {color: gray;}
 
 #de{margin: 20px;
line-height: 1.9em;
 
 }
 
 
 </style>
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



%>
<article>
<h1>Notice</h1>
<form action="coment.jsp" method="post">
<table id="notice" style="border: 0;">
<!-- <tr><td class="tno">No.</th> -->
<!--     <th class="ttitle">Title</th> -->
<!--     <th class="twrite">Writer</th> -->
<!--     <th class="tdate">Date</th> -->
<!--     <th class="tread">Read</th></tr> -->
    <tr><td colspan="2"><h2 class="ya">야레카 야자</h2> <br class="ya">Dypsis lutescens</td><td></td><td rowspan="4"><img src="../images/야레카야자2.jpg" style="float: right; width: 310px; height: 650;"></td>
	    <td>   </td><td></td></tr>
	<tr><td class="asdf" style="width: 55px;">습도</td><td><img alt="" src="../images/raindrops.png" style="width: 28px; height: 28px; float: left; border: none;">공중 습도 40~60% <br>높은걸 좋아해요 </td>
	<tr><td class="asdf">온도</td><td><img alt="" src="../images/thermometer.png" style="width: 28px; height: 28px; float: left;">21~25°C</td></tr>
		
			<tr><td class="asdf">광요구도</td><td><img alt="" src="../images/sun.png" style="width: 28px; height: 28px; float: left; border-bottom: none;">중간 이상 높은 광도(800~10,000 Lux)<br>창가쪽 자리가 좋아요</td></tr>
		<tr style="border-bottom: none;"><td class="asdf">햇빛</td><td><img alt="" src="../images/raindrops.png" style="width: 28px; height: 28px; float: left;">얍얍ssddddddddds</td></tr>
<!-- 	    <td>작성일</td><td></td></tr> -->
	<tr><td style="border-bottom: none;">자세히</td><td colspan="3"><p id="de">영문명으로 Areca Palm, Golden Feather Palm, Butterfly Palm, Cane Palm, 한글명 아레카야자라고도 불린다. 마다가스카르 원산이다.

높이 3∼8m 정도 자란다. 포기로 자라고 줄기와 잎자루는 황색이며 잎도 다소 황색을 띤 녹색이므로 황야자라 한다. 잎 줄기는 7∼10개 이상이 어긋나게 끝부분에서 퍼져 자라며 잎대는 유연한 곡선을 이루며 늘어진다. 잎은 깃꼴겹잎으로 광택이 있으며 잎줄기의 길이는 2m 정도이다. 꽃은 단성화이며 흰색이다. 열매는 달걀 모양으로 자흑색이며 2cm이다.

대기중으로 다량의 수분을 내뿜기 때문에 가습효과가 있고, 담배연기와 휘발성 화학물질을 정화시키는데 탁월한 효과가 있어 실내에서 기르면 좋다. 16∼30℃ 정도에서 잘 자라며 7∼10℃ 정도에서 월동한다.</p>
</td><td colspan="3" rowspan="2"></td></tr>
	<tr><td></td><td colspan="3"></td></tr>
	
	<tr><td>댓글</td><td><input type="text" value="댓글을 입력하세요" name="coment">
	<input type="submit" value="등록">
	</td></tr>
	

	   

</table>
</form>
<div id="table_search">
<%
String id =(String)session.getAttribute("id");
// MemberBean mbean = new MemberBean();
// MemberDAO mdao = new MemberDAO();
// int result=mdao.idcheck(id);
// 세션값 가져오기
// 세션값 있으면 
// 세션값과 글쓴이가 일치하면  글수정 글삭제 보이기
// if(id!=null){
// 	if(id.equals(bean.getName())){
%>
<%-- <input type="button" value="글수정" class="btn" onclick="location.href='updateForm.jsp?num=<%=bean.getNum()%>'"> --%>
<%-- <input type="button" value="글삭제" class="btn" onclick="location.href='deleteForm.jsp?num=<%=bean.getNum()%>'"> --%>
<%-- <%} --%>

<!-- }%> -->



<input type="button" value="글목록" class="btn" onclick="location.href='notice.jsp'">
</div>
<div class="clear"></div>
<div id="page_control">
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


