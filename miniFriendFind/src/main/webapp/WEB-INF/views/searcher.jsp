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
	
	$('#searchhobby').click(function() {
		addr1Value = $('#selectaddr1').val()
		addr2Value = $('#selectaddr2').val()
		hobbyValue = $('#selecthobby').val()+","
		
		$.ajax({
			url : "searchhobby.do"
			,data : {
				addr1 : addr1Value,
				addr2 : addr2Value,
				hobby : hobbyValue
			},
				success: function(result) {
				$('#searchdiv').empty()
				
				$('#searchdiv').append(result)
			}
		})
	})
	
	$('#searchjob').click(function() {
		
		jobValue = $('#selectjob').val()
		subjobValue = $('#selectsubjob').val()
		
		$.ajax({
			url : "searchjob.do" ,
			data : {
				job : jobValue,
				subjob : subjobValue
			} ,success: function(result) {
				$('#searchdiv').empty()
				
				$('#searchdiv').append(result)
			}
		})
	})
	
})
</script>
</head>
<body>
<div style="float:left;">
주소(시)
<select id='selectaddr1'>
<option value="nono" >선택</option>
<c:forEach items="${list1}" var="dto1">
<option value="${dto1.addr1num }">${dto1.addr1 }</option>
</c:forEach>
</select>
</div>
<div id="addr1" style="float:left;">
주소(구)
<select id="selectaddr2">
	<option value="nono">선택</option>
</select>
</div>
<div style="float:left;">
취미
<select id='selecthobby'>
<option value="nono" >선택</option>
<c:forEach items="${list2}" var="dto2">
<option value="${dto2.hobbyNum }">${dto2.hobby }</option>
</c:forEach>
</select>
</div>
<div style="float:left;">
<input type="button" id="searchhobby" value="  검색  ">
</div><br><br>
<div style="float:left;">
직업
<select id='selectjob'>
<option value="nono" selected>선택</option>
<c:forEach items="${list3}" var="dto3">
<option value="${dto3.jobnum }">${dto3.job }</option>
</c:forEach>
</select>
</div>
<div id="subjob" style="float:left;">
직업상세
<select id="selectsubjob">
	<option value="nono">선택</option>
</select>
</div>
<div style="float:left;">
<input type="button" id="searchjob" value="  검색  ">
</div>
<br>
<br>
<div id="searchdiv"></div>
</body>
</html>