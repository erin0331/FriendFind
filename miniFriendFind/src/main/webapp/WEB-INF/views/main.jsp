<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Friend Find "후파"</title>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">  
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script></head>

</head>
<body>
<jsp:include page="../../header.jsp"/>
<jsp:include page="searcher.jsp"></jsp:include>
나는 메인이에요
<%-- 로그인 정보가 필요한 경우 사용 가능. 
${pwcheck.id}<br>
${pwcheck.pw}<br>
${pwcheck.name}<br>
${pwcheck.nickName}<br>
${pwcheck.profil}<br>
${pwcheck.addr1}<br>
${pwcheck.addr2}<br>
${pwcheck.gender}<br>
${pwcheck.birth}<br>
${pwcheck.hobby}<br>
${pwcheck.job}<br>
${pwcheck.subjob}<br>
${pwcheck.message}<br> --%>
</body>
</html>