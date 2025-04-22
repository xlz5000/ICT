<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{

width: 800px;
margin: 50px auto;
border-collapse: collapse;


}


table, th, td{
border: 1px solid green;
text-align: center;
padding: 10px;

}


h2{
text-align: center;


}
a{text-decoration: none;}

button{
	padding: 5px 30px;
	margin-right: 30px;

}

a:link, a:active, a:visited{
 color: black;
}

</style>
</head>
<body>

	
	<h2>BookList</h2>
	<form action="/bookupdate_ok" method="post">
	<table>
		<thead>
			<tr>
				<th>BOOKNAME</th><th>BOOKNAME</th>
				<th>BOOKNAME</th><th>PUBLISHER</th><th>PRICE</th>
			</tr>


		</thead>
		<tbody>
			<tr>
				<td><input type="text" name="bookid" value="${bvo.bookid}" disabled="disabled"></td>
				<td><input type="text" name="bookname" value="${bvo.bookname}"></td>
				<td><input type="text" name="publisher" value="${bvo.publisher}"></td>
				<td><input type="number" name="price" value="${bvo.price}"></td>
				<!-- disabled 파라미터가 넘어가지 않아서 hidden 처리하자 -->
				<input type="hidden" name="bookid" value="${bvo.bookid}" >
				
			
			</tr>

		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<input type="submit" value="수정하기">
				</td>
			
			
			
			</tr>
		
		
		
		</tfoot>
	</table> 
	</form>



</body>
</html>