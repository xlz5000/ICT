<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 방 명 록 </title>

<style type="text/css">
	a { text-decoration: none;}
	table{width: 800px; border-collapse:collapse; text-align: center;}
	table,th,td{border: 1px solid black; padding: 3px}
	div{width: 800px; margin:auto; text-align: center;}
	
	/* summernote toolbar 수정  */
/* 	.note-btn-group{width: auto;} */
/* 	.note-toolbar{width: auto;} */
</style>

</head>
<body>
	<div>
		<h2>방 명 록  : 상세 화 면</h2>
		<hr>
		<p>[<a href="/guestBookList">목록으로 이동]</a></p>
		<form action="" method="post">
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">작성자</td>
					<td>${gvo.gb_name }</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">제  목</td>
					<td>${gvo.gb_subject }</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">email</td>
					<td>${gvo.gb_email }</td>
				</tr>
	
				<tr align="center">
					<td bgcolor="#99ccff">첨부파일</td>
					
					
					
					<c:choose>
					
						<c:when test="${empty gvo.gb_f_name}">
						
							<td><b>첨부파일 없음</b></td>
						
						
						</c:when>
						<c:otherwise>
							<td>
							
							<a href="/guestBookDown?f_name=${gvo.gb_f_name}">
							<img width =" 150px" alt="" src='<c:url value="/resources/upload/${gvo.gb_f_name}" />'>
							</a>
							
							</td>
						
						
						
						</c:otherwise>
					
					</c:choose>
				</tr>
				<tr align="left">
					<td colspan="2">
	<%-- 					<textarea rows="10" cols="60" name="gb_content" id="gb2_content" disabled >
						${gvo.gb_content}
						</textarea> --%>
						
						
						<pre style="padding-left: 20px;">${gvo.gb_content}</pre>
	
					</td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="button" onclick="delete_go()" value="삭제">
							<input type="button" onclick="update_go()" value="수정">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	 function delete_go(){
		 location.href="/guestBookDelete?gb_idx=" + ${gvo.gb_idx}
		
		 
		 
	 }

	 function update_go(){
		 location.href="/guestBookUpdate?gb_idx=" + ${gvo.gb_idx}
		 
		 
	 }
	
	
	
	
	</script>

</body>
</html>









