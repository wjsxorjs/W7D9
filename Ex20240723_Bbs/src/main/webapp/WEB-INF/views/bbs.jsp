<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
	#t1{
		border-collapse: collapse;
		width: 400px;
	}
	#t1 caption{
		text-indent: -9999px;
		height: 0;
	}
	#t1 th, #t1 td{
		border: 1px solid black;
	}
	#t1 thead tr{
		background-color: #cdcdcd;
	}
</style>

</head>
<body>
	<h1>게시판 목록</h1>
	<button type="button" onclick="javascript:location.href='memo'">메모</button>
	<hr/>
	<br/>
		<table id="t1">
			<caption>게시판목록테이블</caption>
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="bvo" items="${b_ar }">
			<tr>
				<td>${bvo.subject }</td>
				<td>${bvo.writer}</td>
				<td>${bvo.write_date }</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>

</body>
</html>