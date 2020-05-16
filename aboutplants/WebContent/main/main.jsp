<%@page import="member2.BoardBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="member2.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/front.css" rel="stylesheet" type="text/css">
<link href="../css/codepen-result.css" rel="stylesheet" type="text/css">
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

.img2{width: 299px; height: 300px;}

figure{    margin-right: 0px;}
.snip1384{margin-right: 0px;}

</style>
  
</head>
<body>
<div id="wrap">
<!-- 헤더파일들어가는 곳 -->
<header>
<jsp:include page="../inc/top.jsp"/>
</header>
<!-- 헤더파일들어가는 곳 -->
<!-- 메인이미지 들어가는곳 -->
<!-- <div class="clear"></div> -->
<!-- <div id="main_img"><img src="../images/배너3.jpg" -->
<!--  width="971" height="282px"></div> -->
<!-- 메인이미지 들어가는곳 -->
<!-- 메인 콘텐츠 들어가는 곳 -->
<article id="front">
<div id="solution">
<!-- <div id="hosting"> -->
<!-- <p><img src="../images/2관음죽확대.jpg" width="100px" height="100px"></p> -->
<!-- </div> -->
<!-- <div id="security"> -->
<!-- <!-- <h3>Web Security Solution</h3> --> 
<!-- <p><img src="../images/2관음죽확대.jpg" width="100px" height="100px"></p> -->
<!-- </div> -->
<!-- <div id="payment"> --
<!-- <!-- <h3>Web Payment Solution</h3> --> 
<!-- <p><img src="../images/2관음죽확대.jpg" width="100px" height="100px"></p> -->
<!-- </div> -->
<!-- </div> -->
<!-- <div class="clear"></div> -->
<!-- <div id="sec_news"> -->
<!-- <h3><span class="orange">Security</span> News</h3> -->
<!-- <dl> -->
<!-- <dt></dt> -->
<!-- <dd>.....</dd> -->
<!-- </dl> -->


<!-- <dl> -->
<!-- <dt>Vivamus id ligula....</dt> -->
<!-- <dd>.....</dd> -->
<!-- </dl> -->

  <div class="slider">
    <div><img src="../images/Untitled.jpg" style="float: left;" class="img2"><img src="../images/세로그라피카리사이징.jpg" class="img2" style="float: left;" class="img2"><img src="../images/필리아페페리사이징.jpg" class="img2" style="float: left;">
    <img src="../images/포트넘리사이징.jpg" class="img2"style="float: right;"><img src="../images/스파티필름확대.jpg" class="img2"style="float: right;"><img src="../images/보스톤고사리리사이징.jpg" class="img2"style="float: right;">
    <img src="../images/메인용2.jpg" class="img2"style="float: right;"><img src="../images/2관음죽확대.jpg" class="img2"style="float: right;">
    <img src="../images/6아이비.jpg" class="img2"style="float: right;"><figure class="snip1384">
  <img class="img2" src="../images/1야래카.PNG" alt="sample83" width="630px" height="380px" /> <figcaption>
    <h3> 야레카 야자 </h3>
    <p>Chrysalidocarpus lutescens</p><i class="ion-ios-arrow-right"></i>
  </figcaption>
  <a href="introduce.jsp"></a>
</figure><figure class="snip1384">
  <img class="img2" src="../images/1야래카.PNG" alt="sample83" width="630px" height="380px" /> <figcaption>
    <h3> 야레카 야자 </h3>
    <p>Chrysalidocarpus lutescens</p><i class="ion-ios-arrow-right"></i>
  </figcaption>
  <a href="introduce.jsp"></a>
</figure>
    </div>
    
    <div><img src="../images/포트넘리사이징.jpg" style="float: left;" class="img2"><img src="../images/스파티필름확대.jpg"class="img2" style="float: left;"><img src="../images/보스톤고사리리사이징.jpg" class="img2"></div>
 <div class="cut">

<!-- <div style="clear: both;"></div> -->
<!-- <div class="clear"></div> -->
  </div>



<!--   <div class="slider"> -->
<!--     <div><img src="../images/Untitled.jpg" style="float: left;" class="img2"><img src="../images/세로그라피카리사이징.jpg" class="img2" style="float: left;"><img src="../images/필리아페페리사이징.jpg" class="img2"></div> -->
<!--     <div><img src="../images/포트넘리사이징.jpg" style="float: left;" class="img2"><img src="../images/스파티필름확대.jpg"class="img2" style="float: left;"><img src="../images/보스톤고사리리사이징.jpg" class="img2"></div> -->
<!--   </div> -->


  <script>
    $(document).ready(function(){
      $('.slider').bxSlider();
    });
  </script>






</div>






<div id="news_notice">
<h3 class="brown">News &amp; Notice</h3>
<table>
<%

BoardDAO dao = new BoardDAO();
int count=dao.getBoardCount();
int count2=dao.getBoardCountFile();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");

List list = null;
if(count!=0){
	list=dao.getboardlist(1,5);	
}


for(int i = 0; i<list.size(); i++){
	 BoardBean bean = (BoardBean)list.get(i);


%>
<tr><td class="contxt">
<a href="../center/content.jsp?num=<%=bean.getNum()%>"><%=bean.getSubject()%></a></td>
    <td><%=sdf.format(bean.getDate())%></td></tr>
<%}%>



</table>
</div>


</article>



<!-- 메인 콘텐츠 들어가는 곳 -->
<div class="clear"></div>







<!-- The dots/circles -->

<!-- 푸터 들어가는 곳 -->
<footer>
<jsp:include page="../inc/bottom.jsp"/>
</footer>
<!-- 푸터 들어가는 곳 -->
</div>
</body>
</html>