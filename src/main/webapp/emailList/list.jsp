<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="emailList.*, java.util.ArrayList"%>

<%-- 
<jsp:useBean id="regBean" class="emailList.EmailListDao"/>
<jsp:setProperty name="regBean" property="*"  />
--%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<!-- 메일정보 리스트 -->
	<%-- list에서 하나씩 빼서 테이블를 채운다--%>
	<%
	EmailListDao dao = new EmailListDao();
	ArrayList<EmailListVo> list = dao.viewEmailList();
	for(int i=0; i<list.size(); i++){
		String last_name = list.get(i).getLast_name();
		String first_name = list.get(i).getFirst_name();
		String email = list.get(i).getEmail();
	%>
	<table border="1" cellpadding="5" cellspacing="2">
	<tr>
		<td align=right width="110">Last name: </td>
		<td width="170"><%= last_name %></td>
		<td rowspan="3" >수정</td>
		<td rowspan="3" >삭제</td>
	</tr>
	<tr>
		<td align=right >First name: </td>
		<td><%= first_name %></td>
	</tr>
	<tr>
		<td align=right>Email address: </td>
		<td><%= email %></td>
	</tr>
	</table>
	<br>
	<%
	}
	%>
	
	
	
	
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<td align=right width="110">Last name: </td>
			<td width="170">정</td>
		</tr>
		<tr>
			<td align=right >First name: </td>
			<td>종욱</td>
		</tr>
		<tr>
			<td align=right>Email address: </td>
			<td>jongukjeong@gmail.com</td>
		</tr>
	</table>
	<br>
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<td align=right width="110">Last name: </td>
			<td width="170">정</td>
		</tr>
		<tr>
			<td align=right >First name: </td>
			<td>종욱</td>
		</tr>
		<tr>
			<td align=right>Email address: </td>
			<td>jongukjeong@gmail.com</td>
		</tr>
	</table>
	<br>
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<td align=right width="110">Last name: </td>
			<td width="170">정</td>
		</tr>
		<tr>
			<td align=right >First name: </td>
			<td>종욱</td>
		</tr>
		<tr>
			<td align=right>Email address: </td>
			<td>jongukjeong@gmail.com</td>
		</tr>
	</table>
	<br>
	<p>
		<a href="form.jsp">추가메일 등록</a>
	</p>
	<br>
</body>
</html>