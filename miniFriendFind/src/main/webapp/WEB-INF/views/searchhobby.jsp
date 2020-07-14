<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<th>닉네임</th>
	<th>한마디</th>
	<th>주소1</th>
	<th>주소2</th>
	<th>성별</th>
	<th>취미</th>
	<th>직업1</th>
	<th>직업2</th>
<tr>
<c:forEach items="${searchlist}" var="dto6">
<tr>
	<td><a href="detailPage.do?id=${dto6.id}">${dto6.nickName }</a></td>
	<td>${dto6.profil }</td>
	<td>${dto6.addr1 }</td>
	<td>${dto6.addr2 }</td>
	<td>${dto6.gender }</td>
	<td>${dto6.hobby }</td>
	<td>${dto6.job }</td>
	<td>${dto6.subJob }</td>
</tr>
</c:forEach>
</table>
</body>
</html>