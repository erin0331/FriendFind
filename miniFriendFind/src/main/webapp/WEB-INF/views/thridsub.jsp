<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select id='selectsubjob'>
<option value="nono">선택</option>
<c:forEach items="${list5}" var="dto5">
<option value="${dto5.subjobnum }">${dto5.subjob }</option>
</c:forEach>
</select>