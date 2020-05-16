<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.*"%>
<%@ page import="com.oreilly.servlet.ServletUtils"%>


<%
	request.setCharacterEncoding("utf-8");

    String fileName = request.getParameter( "file_name" ); //파일이름 가져오기
 System.out.println(fileName);//파일이름 찍기 콘솔창에
 
 //물리적인경로
//      String savePath = "/upload";
//      ServletContext context = getServletContext();
//      String sDownloadPath = context.getRealPath(savePath);
//      String sFilePath = sDownloadPath + "\\" + fileName;
     
  // 파일 물리적인 경로 위랑 이거랑 같은말
     String uploadPath=request.getRealPath("/upload"); //파일 업로드 시 그대로 쓰는데 
 // 물리적인 경로 + 파일 이름
     String sFilePath = uploadPath + "\\" + fileName;
     System.out.println(sFilePath);

     
   byte b[] = new byte[4096]; //이미지가 byte형이므로 배열공간 선언
   //파일을 가져와서 ->자바에서 제어하기위해 file 객체 생성
   File oFile = new File(sFilePath); 
  

//자바제공 FileInputStream API 파일입력관련
   FileInputStream in = new FileInputStream(oFile);

//물리적경로 + 파일이름 => 타입확인 
   String sMimeType = getServletContext().getMimeType(sFilePath);
System.out.println("sMimeType>>>"+sMimeType );//콘솔에 타입찍힌다 

   // octet-stream은  8비트로 된 일련의 데이터를 뜻합니다. 지정되지 않은 파일 형식을 의미합니다.
 
   //파일 타입이 없을 경우에 설정
   if(sMimeType == null) sMimeType = "application/octet-stream";


//서버에서 클라이언트로 응답할때 확인한 타입으로 설정
   response.setContentType(sMimeType);

   //브라우저별 한글처리,브라우저 확인
   String userAgent = request.getHeader("User-Agent");
   //익스플로러 브라우저면 true/아니면 false
   boolean ie = (userAgent.indexOf("MSIE") > -1)|| (userAgent.indexOf("Trident") > -1);
   String sEncoding=null;
   if(ie) {
	   //익스플로러 브라우저 일때 ->한글처리해서 sEncoding 변수에 저장
	  sEncoding = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");
	  System.out.println(sEncoding);
   }else{
	   //익스플로러 외 다른 브라우저들
	  sEncoding = new String(fileName.getBytes("utf-8"),"8859_1");
	  System.out.println(sEncoding);
  }
   
  
   //한글 업로드 (이 부분이 한글 파일명이 깨지는 것을 방지해 줍니다.)
//    String sEncoding = new String(fileName.getBytes("utf-8"),"8859_1");
 //  System.out.println(sEncoding);

 //서버에서 클라이언트에 보낼때 파일을 브라우저에서 바로 실행하지않고 첨부파일로 다운되게 설정
   response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
   
 // 자바 API 이다 :  ServletOutputStream  응답 출력 하기위한 객채생성
   ServletOutputStream out2 = response.getOutputStream();
   int numRead;

   // 바이트 배열b의 0번 부터 numRead번 까지 브라우저로 출력
   //FileInputStream로 입력받은 파일을 ->  ServletOutputStream 이용하여 출력
   while((numRead = in.read(b, 0, b.length)) != -1) {
    out2.write(b, 0, numRead);
   }
   out2.flush(); 
   out2.close();
   in.close();

   out.clear();
	out = pageContext.pushBody();
 //  ServletUtils.returnFile( PdsMisc.UPLOAD_DIRECTORY + File.separator + StringMisc.uniToEuc( fileName ), response.getOutputStream() );
%>
