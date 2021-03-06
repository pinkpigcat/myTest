<%@page import="member2.CommentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member2.CommentDAO"%>
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
String id =(String)session.getAttribute("id");
int num=Integer.parseInt(request.getParameter("num"));


BoardDAO dao = new BoardDAO();
BoardBean bean = new BoardBean();
bean=dao.getborad(num);
dao.getReadcount(num);




//날짜모양설정 => 문자열로 출력해줌 
SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");



%>
<article>
<h1>Notice</h1>
<form action="coment.jsp" method="post">
<table id="notice">
<!-- <tr><td class="tno">No.</th> -->
<!--     <th class="ttitle">Title</th> -->
<!--     <th class="twrite">Writer</th> -->
<!--     <th class="tdate">Date</th> -->
<!--     <th class="tread">Read</th></tr> -->
    <tr><td>글번호</td><td><%=bean.getNum() %></td><td></td><td></td>
	    <td>조회수</td><td><%=bean.getReadcount() %></td><td></td><td></td><td></td></tr>
	<tr><td>작성자</td><td><%=bean.getName() %></td><td></td><td></td><td></td><td></td>
	    <td>작성일</td><td><%=sdf.format(bean.getDate())%></td><td></td><td></td></tr>
	<tr><td>글제목</td><td colspan="4"><%=bean.getSubject() %></td><td></td><td></td><td></td><td></td></tr>
	<tr><td>글내용</td><td colspan="4" style="height: 90px;"><%=bean.getContent() %></td><td></td><td></td><td></td></tr>
	<%if(id==null){ %>
	<tr><td>댓글</td><td><input type="text" value="로그인이 필요합니다" name="coment">
	<%}else{%>
	<tr><td rowspan="2" colspan="13">   </td><td><td></td>
	<tr><td rowspan="" colspan="7">   </td><td><td></td><td></td>
	<tr><td rowspan="" colspan="7" style="height: 60px;"></td><td></td><td></td><td></td><td></td>
	<tr><td>댓글작성</td><td><input type="text" value="댓글을 입력하세요" name="coment">
	<input type="hidden" name="num" value="<%=num%>">
	<input type="hidden" name="id" value="<%=id%>">
	<input type="submit" value="등록">
	</td></tr>
	<%}%>

	<%
	
	List list = new ArrayList();
	CommentDAO daoC = new CommentDAO();
	list=daoC.getComment(num);
	int comment_num=0;
	for(int i = 0; i<list.size(); i++){
		CommentBean beanC = (CommentBean)list.get(i);
	%>
	<tr><td style="background-color: gray;">댓글내용</td><td ><%=beanC.getComment_content() %></td>
	<td>작성자</td><td><%=beanC.getComment_id() %></td>
	<td>작성일</td><td><%=sdf.format(beanC.getComment_date())%></td><td></td>
	<%if(bean.getName().equals(id)){ %><td><input type="button" onclick="location.href='deleteCommentPro.jsp?num=<%=num%>&comment_num=<%=beanC.getComment_num() %>'" value="댓글삭제"></td>
	
	<td><input type="button" onclick="fun1(<%=num %>,<%=comment_num=beanC.getComment_num() %>)" value="댓글수정"></td>
	<tr><%}%>
<%-- 	<tr><td style="background-color: gray;">댓글내용</td><td ><%=beanC.getComment_content() %></td> --%>
<%-- 	<td>작성자</td><td><%=beanC.getComment_id() %></td> --%>
<%-- 	<td>작성일</td><td><%=sdf.format(beanC.getComment_date())%></td><td></td> <%}%> --%>



	
	
<%}%>

</table>
</form>


 <script type="text/javascript">


function fun1() {
	window.open("updateCommentForm.jsp?num=<%=num%>&comment_num=<%=comment_num%>","댓글 수정창","width=600,height=200,left=200,top=200,scrollbars=yes,resizable=yes"); 

}


</script>





 
<div id="table_search">
<%

// MemberBean mbean = new MemberBean();
// MemberDAO mdao = new MemberDAO();
// int result=mdao.idcheck(id);
// 세션값 가져오기
// 세션값 있으면 
// 세션값과 글쓴이가 일치하면  글수정 글삭제 보이기
if(id!=null){
	if(id.equals(bean.getName())){
%>
<input type="button" value="글수정" class="btn" onclick="location.href='updateForm.jsp?num=<%=bean.getNum()%>'">
<input type="button" value="글삭제" class="btn" onclick="location.href='deleteForm.jsp?num=<%=bean.getNum()%>'">
<%}

}%>



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