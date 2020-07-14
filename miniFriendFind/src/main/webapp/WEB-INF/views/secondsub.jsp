<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select id='selectaddr2'>
<option value="nono">선택</option>
<c:forEach items="${list4}" var="dto4">
<option value="${dto4.addr2num }">${dto4.addr2 }</option>
</c:forEach>
</select>