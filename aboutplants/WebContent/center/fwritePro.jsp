<%@page import="member2.BoardDAO"%>
<%@page import="member2.BoardBean"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
//center/fwritePro.jsp
//webContent upload폴더ㅓ만들기 

//MultpartRequest 객체생성
String uploadPath=request.getRealPath("/upload");//폴더의 물리적인 경로
int maxSize=5*1024*1024;//최대올릴수있는크기
MultipartRequest multi=new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());

//BoardBean bean 객체생성
//bean 멤버변수 <- 업로드 파라미터 값 저장
String name=multi.getParameter("name");
String pass=multi.getParameter("pass");
String subject=multi.getParameter("subject");
String content=multi.getParameter("content");
int readcount=0;
Timestamp date=new Timestamp(System.currentTimeMillis());

String file=multi.getFilesystemName("file");



//BoardDAO  dao 객체 생성
//insertBoard(bean) 메서드 호출
BoardBean bean = new BoardBean();
bean.setName(name);
bean.setPass(pass);
bean.setSubject(subject);
bean.setContent(content);
bean.setDate(date);
bean.setReadcount(readcount);
bean.setFile(file);

BoardDAO dao = new BoardDAO();
dao.insertBoardWrite(bean);


response.sendRedirect("fnotice.jsp");

%>
<%=file %>
</body>
</html>