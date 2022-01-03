<%@
page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>

<%
request.setCharacterEncoding("UTF-8");
int bookno = Integer.parseInt(request.getParameter("bookno"));
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제</title>
</head>
<body>
	<form method="post" action="delete.jsp">
	<input type='hidden' name="bookno" value="<%=bookno%>">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="list.jsp">메인으로 돌아가기ㄱㄱ</a></td>
		</tr>
	</table>
	</form>
</body>
</html>