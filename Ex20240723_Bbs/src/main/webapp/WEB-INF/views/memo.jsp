<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모</title>
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
	<h1>메모 목록</h1>
	<button type="button" onclick="javascript:location.href='bbs'">게시판</button>
	<hr/>
	<br/>
		<table id="t1">
			<caption>메모목록테이블</caption>
			<thead>
				<tr>
					<th>내용</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="mvo" items="${m_ar }">
			<tr>
				<td>${mvo.content }</td>
				<td>${mvo.writer}</td>
				<td>${mvo.write_date }</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>

</body>
</html>