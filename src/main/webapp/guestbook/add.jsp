<%@
page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="guestbook.*, java.util.ArrayList"
%>

<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String password = request.getParameter("password");
String content = request.getParameter("content");

System.out.println("등록한 name: "+name);
System.out.println("등록한 password: "+password);
System.out.println("등록한 content: "+content);


GuestBookVo vo = new GuestBookVo();
vo.setName(name);
vo.setPassword(password);
vo.setContent(content);

GuestBookDao dao = new GuestBookImpl();
if(dao.insert(vo)){
	response.sendRedirect("list.jsp");
}else{
%>
<script type="text/javascript">
alert("데이터 입력 실패");
history.go(-1);
</script>
<%
}
%>
