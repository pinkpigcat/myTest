<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
 <script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

 
 

 
 

 
 
 
 
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
<!-- <body> -->
<body onload="initialize()">

<div id="wrap">
<!-- 헤더가 들어가는 곳 -->
<header>
<jsp:include page="../inc/top.jsp"/>
</header>
<!-- 헤더가 들어가는 곳 -->

<!-- 본문 들어가는 곳 -->
<!-- 서브페이지 메인이미지 -->
<div id="sub_img"></div>
<!-- 서브페이지 메인이미지 -->
<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<ul>
<li><a href="#">Welcome</a></li>
<li><a href="#">History</a></li>
<li><a href="#">Newsroom</a></li>
<li><a href="#">Public Policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->
<!-- 내용 -->
<article>
<h1>Welcome</h1>
<!-- <figure class="ceo"><img src="../images/company/CEO.jpg" width="196" height="226"  -->
<!-- alt="CEO"><figcaption>Fun Web CEO Michael</figcaption> -->
<!-- </figure> -->
<p>오시는 길</p>





 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=318e5641c9d1c5256fb615aac65ecfed&libraries=services"></script>


 
 
 <script> //////////////////// // 카카오 지도 API S /////////////////// 
 var coordXY = document.getElementById("coordXY"); //검색 지도 경도위도 알아내기
 var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스 
 var options = { center: new kakao.maps.LatLng(35.158758, 129.062093), // 위도경도 level: 3 //지도의 레벨(확대, 축소 정도) }; 
 var map = new kakao.maps.Map(container, options);
var mapTypeControl = new kakao.maps.MapTypeControl();
 map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
 var zoomControl = new kakao.maps.ZoomControl(); map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
 var geocoder = new kakao.maps.services.Geocoder();
 geocoder.addressSearch('부산 부산진구 동천로 109 삼한골든게이트 7층', function(result, status)
{  if (status === kakao.maps.services.Status.OK) { var coords = new kakao.maps.LatLng(result[0].y, result[0].x); yy = result[0].x; xx = result[0].y;
 var marker = new kakao.maps.Marker({ map: map, position: coords });
var iwContent = '<div style="padding:5px;">이피엔스<br>' + '<a href="https://map.kakao.com/link/map/이피엔스,37.51128, 127.04232" style="color:blue" target="_blank">큰지도보기</a>' + '<a href="https://map.kakao.com/link/to/이피엔스,37.51128, 127.04232" style="color:blue" target="_blank">길찾기</a>' +'</div>'
 var infowindow = new kakao.maps.InfoWindow({ content : iwContent }); infowindow.open(map, marker);  이동 map.setCenter(coords); // ★ resize 마커 중심 
 var markerPosition = marker.getPosition(); $(window).on('resize', function(){ map.relayout(); map.setCenter(markerPosition); }); 
 coordXY.innerHTML = "<br>X좌표 : " + xx + "<br><br>Y좌표 : " + yy; } else { console.log('에러'); } }); //////////////////// // 카카오 지도 API E /////////////////// 

 }

 
//  35.158758, 129.062093

 </script>
 
 
 <!-- 이미지 지도를 표시할 div 입니다 -->
<div id="staticMap" style="width:600px;height:350px;"></div>    

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY를 사용하세요"></script>
<script>    
// 이미지 지도에 표시할 마커입니다
// 이미지 지도에 표시할 마커를 아래와 같이 배열로 넣어주면 여러개의 마커를 표시할 수 있습니다 
var markers = [
    {
        position: new kakao.maps.LatLng(35.158758, 129.062093)
    },
    {
        position: new kakao.maps.LatLng(35.158758, 129.062093), 
        text: '부산 아이티윌 여기!' // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다     
    }
];

var staticMapContainer  = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
    staticMapOption = { 
        center: new kakao.maps.LatLng(35.158758, 129.062093), // 이미지 지도의 중심좌표
        level: 3, // 이미지 지도의 확대 레벨
        marker: markers // 이미지 지도에 표시할 마커 
    };    

// 이미지 지도를 생성합니다
var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);
</script>
 



</article>
<!-- 내용 -->
<!-- 본문 들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터 들어가는 곳 -->
<footer>
<hr>
<jsp:include page="../inc/bottom.jsp"/>
</footer>
<!-- 푸터 들어가는 곳 -->
</div>
</body>
</html>



    