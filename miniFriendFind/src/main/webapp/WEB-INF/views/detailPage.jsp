<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Friend Find "후파" - ${param.id}님의 페이지</title>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">  
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style type="text/css">
.modal-dialog {z-index: 1050;}
</style>
<script type="text/javascript">
$(function() {
	reId = ''
	//수정 연필 클릭 시, 수정할 수 있는 창 뜨고 내용 세팅
	$(".editB").click(function() {
		$("#edit").modal('show');
		/* 댓글 id도 미리 변수 저장 해둠 */
		reId = $(this).closest('TR').children('input#reId').val();
		//reId = $(this).parent().parent().parent().children('input#reId').val();
		console.log("id:"+reId)
		content = $(this).closest('TR').children('td.con').children('span.nowContent').text();
		console.log("content:"+content)
		$("#editReply").val(content)
	})
	//새글 연필 클릭 시, 새글 남길 수 있는 창 나옴
	$(".writeB").click(function() {
		$("#write").modal('show');
		
	})
	//대댓글 연필 클릭 시, 댓글 남길 수 있는 창 나옴
	$(".replyB").click(function() {
		$("#reply").modal('show');
		reId = $(this).closest('TR').children('input#reId').val();
		//reId = $(this).parent().parent().parent().children('input#reId').val();
		console.log("id:"+reId)
	})
	//휴지통 클릭 시, 댓글 지우는 창
	$(".deleteB").click(function() {
		$("#delete").modal('show');
		reId = $(this).closest('TR').children('input#reId').val();
		console.log("id:"+reId)
	})
	//update 시에, 댓글 내용 변경
	$("#update").click(function() {
		newContent = $("#editReply").val();
		
		$.ajax({
			url : 'replyUpdate.do',
			data : {
				id : reId,
				content : newContent
			},
			success: function() {
				$("#edit").modal('hide');
			}
			
		})
	})
	// 새글 쓰기 insert
	$("#newWrite").click(function() {
		newContent = $("#newReply").val();
		
 		$.ajax({
			url : 'replyInsert.do',
			data : {
				owner : '${dto.id}',
				writer : '${sessionScope.id}',
				content : newContent
			},
			success: function() {
				$("#write").modal('hide');
			}
			
		}) 
	})
	//댓글 삭제
	$('#deleteRe').click(function() {
		$.ajax({
			url : 'replyDelete.do',
			data : {
				id : reId,
				owner : '${dto.id}'
			},
			success: function() {
				$("#delete").modal('hide');
			}
			
		})
	})
	//대댓글 달기
	$('#newRWrite').click(function() {
		newContent = $("#newRReply").val();
 		$.ajax({
			url : 'replyRe.do',
			data : {
				id : reId,
				owner : '${dto.id}',
				writer : '${sessionScope.id}',
				content : newContent
			},
			success: function() {
				$("#reply").modal('hide');
			}
			
		}) 
	})
})

</script>
</head>
<body>
<jsp:include page="../../header.jsp"/>
<br><br>
<div class="container">
<h3><kbd>${dto.nickName}</kbd>님의 페이지입니다. 
	<c:if test="${dto.id eq sessionScope.id}"> 
	<button class="btn btn-success"
		    	onclick="#"><span class="glyphicon glyphicon-user">정보수정</span></button>
	</c:if>
</h3><br>
취미 : 
<c:forEach items="${hobbyList}" var="hobby">
<code>${hobby.hobby}</code>
</c:forEach>
<br>
<h5><b>${dto.profil }</b></h5><br>
<br><br>

	 <div class="col-md-12">
        <h4>한마디를 남겨보아요! <a data-placement="top" data-toggle="tooltip" title="Write"><button class="btn btn-info writeB" ><span class="glyphicon glyphicon-pencil"></span></button></a></h4>
        <!-- 자기 자신이면 개인정보 수정 버튼 뜨도록 -->
   
		    	
        <div class="table-responsive">
          <table id="mytable" class="table table-bordred table-hover">
			<thead>
			<th>Content</th>
			<th>Writer</th>
			<th>Date</th>
			<th>Reply</th>
			<th>Edit</th>
			<th>Delete</th>
			</thead>
   		  <tbody>
   		<c:forEach items="${list}" var="dto2" varStatus="status">
   			<tr id=${dto2.id}>
   			<input type="hidden" value=${dto2.id} id="reId">
		    <td class="con">
		    <c:if test="${dto2.depth ne 1}">
			<c:forEach begin="1" end="${dto2.depth-1}">
				&nbsp;
			</c:forEach>
		   	 	<span class="glyphicon glyphicon-arrow-right"></span>
			</c:if>
		    <span class="nowContent">${dto2.content}</span></td>
		    <td><a href="detailPage.do?id=${dto2.writer}">${dto2.writer}</a></td>
		    <td>${dto2.writeDate}</td>
		    <td><p data-placement="top" data-toggle="tooltip" title="reply"><button class="btn btn-warning btn-xs replyB"><span class="glyphicon glyphicon-pencil"></span></button></p></td>
		<!--     <td><p data-placement="top" data-toggle="tooltip" title="reply"><button class="btn btn-warning btn-xs" data-title="Reply" data-toggle="modal" data-target="#reply" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
		    --> 
		    <td><c:if test="${dto2.writer eq sessionScope.id}"> 
		    	<p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs editB">
		    	<span class="glyphicon glyphicon-pencil"></span></button></p>
		    </c:if>
		    </td>
		    <td><c:if test="${dto2.writer eq sessionScope.id}">
		     <p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs deleteB" ><span class="glyphicon glyphicon-trash"></span></button></p>
   			</c:if></td>
   			</tr>
   		</c:forEach>
</div>
<!-- 새글쓰기모달 -->
<div class="modal fade" id="write" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h4 class="modal-title custom_align" id="Heading">Write New Reply</h4>
      </div>
          <div class="modal-body">
          <div class="form-group">
        Content <input class="form-control " type="text" id="newReply">
        </div>
<!--         <div class="form-group">
        <textarea rows="2" class="form-control" placeholder="CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan"></textarea>
        </div> -->
      </div>
          <div class="modal-footer ">
        <button type="button" class="btn btn-info btn-lg" style="width: 100%;" id="newWrite"><span class="glyphicon glyphicon-ok-sign"></span> Write</button>
      </div>
        </div>
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
    </div>
    
  <!-- 대댓글 달기 모달 -->
<div class="modal fade" id="reply" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h4 class="modal-title custom_align" id="Heading">Write New Reply</h4>
      </div>
          <div class="modal-body">
          <div class="form-group">
        Content <input class="form-control " type="text" id="newRReply">
        </div>
<!--         <div class="form-group">
        <textarea rows="2" class="form-control" placeholder="CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan"></textarea>
        </div> -->
      </div>
          <div class="modal-footer ">
        <button type="button" class="btn btn-warning btn-lg" style="width: 100%;" id="newRWrite"><span class="glyphicon glyphicon-ok-sign"></span> Write</button>
      </div>
        </div>
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
    </div>
 
 <!-- 수정하기 모달 -->
<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h4 class="modal-title custom_align" id="Heading">Edit Your Reply</h4>
      </div>
          <div class="modal-body">
          <div class="form-group">
        Content <input class="form-control " type="text" id="editReply">
        </div>
<!--         <div class="form-group">
        <textarea rows="2" class="form-control" placeholder="CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan"></textarea>
        </div> -->
      </div>
          <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn-lg" style="width: 100%;" id="update"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>
      </div>
        </div>
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
    </div>
 
 <!-- 삭제하기 모달 -->
    <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
      <div class="modal-dialog">
    <div class="modal-content">
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
      </div>
          <div class="modal-body">
       
       <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Record?</div>
       
      </div>
        <div class="modal-footer ">
        <button type="button" class="btn btn-success" id="deleteRe"><span class="glyphicon glyphicon-ok-sign"></span> Yes</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> No</button>
      </div>
        </div>
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
    </div>    
    
</body>
</html>