<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="emailList.*, java.util.ArrayList" %>
<%
request.setCharacterEncoding("UTF-8");
String last_name = request.getParameter("last_name");
String first_name = request.getParameter("first_name");
String email = request.getParameter("email");

System.out.println("등록한 last_name: "+last_name);
System.out.println("등록한 first_name: "+first_name);
System.out.println("등록한 email: "+email);


EmailListVo vo = new EmailListVo();
vo.setLast_name(last_name);
vo.setFirst_name(first_name);
vo.setEmail(email);

EmailListDao dao = new EmailListDao();
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