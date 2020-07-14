<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(function() {
	
	$('#selectaddr1').change(function() {
		
		//alert( $('#selectaddr1').val())
		$.ajax({
			url : "secondsub.do" ,
			data : {
				addr1Num : $('#selectaddr1').val()
			},success: function(result) {
				$('#addr1').empty()
				$('#addr1').append("주소(구)"+result)
			}
		})
	})
	
	$('#selectjob').change(function() {
		
		//alert("누름")
		
		$.ajax({
			url : "thridsub.do" ,
			data: {
				jobNum : $('#selectjob').val()
			},success: function(result) {
				$('#subjob').empty()
				$('#subjob').append("직업상세"+result)
			}
			
		})
	})
	
	$('#btn').click(function() {
		
		myhobby = ""
    		
    	$("input[name=chk]:checked").each(function() { 
    	   myhobby = myhobby + $(this).val() +", "
    	   		});
		
		$.ajax({
			url : "insert.do",
			data : {
				id : $('#id').val(),
				pw : $('#pw').val(),
				name : $('#name').val(),
				nickName : $('#nickname').val(),
				profil : $('#profil').val(),
				addr1 : $('#selectaddr1').val() ,
				addr2 : $('#selectaddr2').val(),
				gender : $('#gender').val(),
				birth : $('#birth').val(),
				hobby : myhobby,
				job : $('#selectjob').val(),
				subjob : $('#selectsubjob').val(),
				message : "0"
			}, success: function() {
				location.href="start.jsp"
			}
		})
		
	})
	
	$('#btnid').click(function() {
		$.ajax({
			url : "selectid.do" ,
			data : {
				id : $('#id').val()
			}, success: function(result) {
				console.log("what")
				alert(result)
			}
		})
		
	})
	
	$('#btn2').click(function() {
		location.href="start.jsp"
	})
})
</script>
</head>
<body>
<hr>
<br>
<h2>회원가입</h2>
<br>
<hr>
아이디 : <input type="text" id="id"><input type="button" id="btnid" value="중복확인"><br>
비밀번호: <input type="text" id="pw"><br>
이름: <input type="text" id="name"><br>
닉네임 : <input type="text" id="nickname"><br>
한마디:<input type="text" id="profil"><br>
주소(시)
<select id='selectaddr1'>
<option value="noon" seleted>선택</option>
<c:forEach items="${list1}" var="dto1">
<option value="${dto1.addr1num }">${dto1.addr1 }</option>
</c:forEach>
</select><br>
<div id="addr1">
주소(구)
<select>
	<option value="미정">선택</option>
</select>
</div>
성별 :
<input type="radio" id="gender" value="M">남자
<input type="radio" id="gender" value="F">여자
<br>
생년월일: <input type="text" id="birth"><br>
취미<br>
<table border="1">
<tr>
<c:forEach items="${list2}" var="dto2" begin="0" end="3" >
<td><label><input type="checkbox" name="chk" value="${dto2.hobbynum }" />${dto2.hobby }</label></td>
</c:forEach>
</tr>
<tr>
<c:forEach items="${list2}" var="dto2" begin="4" end="7" >
<td><label><input type="checkbox" name="chk" value="${dto2.hobbynum }" />${dto2.hobby }</label></td>
</c:forEach>
</tr>
<tr>
<c:forEach items="${list2}" var="dto2" begin="8" end="11" >
<td><label><input type="checkbox" name="chk" value="${dto2.hobbynum }" />${dto2.hobby }</label></td>
</c:forEach>
</tr>
<tr>
<c:forEach items="${list2}" var="dto2" begin="12" end="15" >
<td><label><input type="checkbox" name="chk" value="${dto2.hobbynum }" />${dto2.hobby }</label></td>
</c:forEach>
</tr>
</table>
<br>
직업
<select id='selectjob'>
<option value="noon" selected>선택</option>
<c:forEach items="${list3}" var="dto3">
<option value="${dto3.jobnum }">${dto3.job }</option>
</c:forEach>
</select><br>
<div id="subjob">
직업상세
<select>
	<option value="미정">선택</option>
</select>
</div>
<hr>
<input type="button" id="btn" value="회원가입">
<input type="button" id="btn2" value="돌아가기">
</body>
</html>