<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="member2.BoardDAO"%>
<%@page import="member2.BoardBean"%>
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
String uploadPath=request.getRealPath("/upload");//폴더의 물리적인 경로
int maxSize=5*1024*1024;//최대올릴수있는크기
MultipartRequest multi=new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());

request.setCharacterEncoding("utf-8");
int num=Integer.parseInt(multi.getParameter("num"));
String name=multi.getParameter("name");
String pass=multi.getParameter("pass");
String subject=multi.getParameter("subject");
String content=multi.getParameter("content");
String file=multi.getFilesystemName("file");
String old_file=multi.getParameter("old_file");


BoardBean bean = new BoardBean();
bean.setNum(num);
bean.setName(name);
bean.setPass(pass);
bean.setSubject(subject);
bean.setContent(content);
// bean.setFile(file);

if(file!=null){
bean.setFile(file);

}else{
	bean.setFile(old_file);
}


BoardDAO dao = new BoardDAO();
int check = dao.updateboardFile(bean);


	
if(check==1){%>
<script type="text/javascript">
alert("수정성공");
location.href="fnotice.jsp";
</script>
	
	
	<%}else{%>
		<script type="text/javascript">
			alert("비밀번호틀림");
			history.back();
		</script>
		
	<%}%>


<!-- response.sendRedirect("fnotice.jsp"); -->











<%-- <%=old_file %> --%>
</body>
</html>