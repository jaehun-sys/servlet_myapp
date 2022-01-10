<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="guestbook.*, java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>

	<form action="add.jsp" method="POST">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br/>
	
	<%-- list에서 하나씩 빼서 테이블를 채운다--%>
	<%
	GuestBookDao dao = new GuestBookImpl();
	ArrayList<GuestBookVo> list = dao.select();
	for(int i=0; i<list.size(); i++){
		int bookno = list.get(i).getBookno();
		String name = list.get(i).getName();
		String regdate = list.get(i).getRegdate();
		String password = list.get(i).getPassword();
		String content = list.get(i).getContent();
	%>
	
	<script>
	var input = document.getElementById(bno); 
	input.value = <%=bookno%>; 
	</script>
	<table width=510 border=1>	
	<tr>
			<td><%= bookno %></td>
			<td><%= name %></td>
			<td><%= regdate %></td>
			<td><a href="deleteform.jsp?bookno=<%=bookno%>">삭제</a></td>
			<form action="delete.jsp">
			<input type='hidden' name="bookno" value="<%=bookno%>">
			</form>
		<tr>
			<td colspan=4><%= content %></td>
		</tr>
	</table>
	<br>
	<%
	}
	%>

	<table width=510 border=1>
		<tr>
			<td>[1]</td>
			<td>정종욱</td>
			<td>2020-07-09</td>
			<td><a href="">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4>안녕하세요<br/>첫번째글입니다.</td>
		</tr>
	</table>
        <br/>
	<table width=510 border=1>
		<tr>
			<td>[1]</td>
			<td>정종욱</td>
			<td>2020-07-09</td>
			<td><a href="">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4>안녕하세요<br/>두번째글입니다.</td>
		</tr>
	</table>
        <br/>
</body>
</html>