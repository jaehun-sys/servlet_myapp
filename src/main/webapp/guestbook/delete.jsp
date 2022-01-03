<%@
page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="guestbook.*, java.util.ArrayList"
%>

<%
request.setCharacterEncoding("UTF-8");
//String name = request.getParameter("name");
String password = request.getParameter("password");
//String content = request.getParameter("content");
int bookno = Integer.parseInt(request.getParameter("bookno"));

//System.out.println("등록한 name: "+name);
System.out.println("삭제할 password: "+password);
//System.out.println("등록한 content: "+content);
System.out.println("삭제할 bookno: "+bookno);




GuestBookDao dao = new GuestBookImpl();
if(dao.delete(bookno, password)){
	response.sendRedirect("list.jsp");
}else{
%>
<script type="text/javascript">
alert("데이터 삭제 실패");
history.go(-1);
</script>
<%
}
%>
