<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서목록</title>
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
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.7.1.js" ></script>
  <script src="https://code.jquery.com/ui/1.13.3/jquery-ui.js"></script>
    <script>
	  $( function() {
		$( ".dialog" ).dialog({
	      autoOpen: false,
	    });
		// 새로 생성한 요소에 대해서 접근하기 위해서
		// 부모의 이벤트를 받아 자식으로 구체화 시킨다.
		$( "#t1 tbody" ).on( "click", "tr", function() {
		      $( "#"+$(this).data("idx") ).dialog( "open" );
		    });
		
		
		
	  } );
	  
	  function openDialog(thisP){
		  $( "#"+$(thisP).data("idx") ).dialog( "open" );
	      console.log("ID: #"+$(thisP).data("idx"));
	  }
  </script>
</head>
<body>
	<h1>부서목록</h1>
	<hr/>
	<div>
		<form action="emp/search" method="post">
			<select name="searchType" id="type">
				<option value="1">부서번호</option>
				<option value="2">부서명</option>
				<option value="3">지역명</option>
			</select>
			<input type="text" name="searchValue" id="value" />
			<button type="button" onclick="sendData(this.form)">검색</button>
		</form>
	</div>
	<br/>
		<table id="t1">
			<caption>부서목록테이블</caption>
			<thead>
				<tr>
					<th>부서번호</th>
					<th>부서명</th>
					<th>지역명</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="dvo" items="${d_ar }">
			<tr class='opener' style="cursor: pointer;" data-idx='${dvo.deptno }'>
				<td>${dvo.deptno }</td>
				<td>${dvo.dname }</td>
				<td>${dvo.city}</td>
			</tr>
			
			<div id='${dvo.deptno }' class="dialog" title="부서 정보">
			  <p><strong>부서번호</strong>: ${dvo.deptno }<p>
			  <p><strong>부서명</strong>: ${dvo.dname}<p>
			  <p><strong>지역명</strong>: ${dvo.city } (지역코드: ${dvo.loc_code })<p>
			</div>
			
			</c:forEach>
			</tbody>
		</table>
 
 			

<script>

	function sendData(frm) {
		// 유효성 검사
		let keyword = $("#value").val().trim();
		if(keyword.length < 1 || keyword == ''){
			alert("검색어를 입력하세요")
			$("#value").val('');
			$("#value").focus();
			return;
		}
		
		// FormData는 파일을 보낼 때만 사용하자!
		
		$.ajax({
			url: "dept_search",
			data: {
				"searchType" : $("#type").val(),
				"searchValue" : $("#value").val(),
			},
			type: "post",
			dataType: "json",
		}).done(function(data){
			console.log(data);
			
			let d_ar = data.d_ar;
			let str = "";
			
// 			$("div").remove(".ui-dialog");
// 			$("div").remove(".dialog");
			
			for(let i=0; i<data.len; i++){
				str += "<tr class='opener' style='cursor: pointer;' data-idx='"+d_ar[i].deptno+"'>";
				str +=   "<td>";
				str +=     d_ar[i].deptno;
				str +=   "</td>";
				str +=   "<td>";
				str +=     d_ar[i].dname;
				str +=   "</td>";
				str +=   "<td>";
				str +=     d_ar[i].city;
				str +=   "</td>";
				str += "</tr>";
								
			}
			
			console.log(str);
			
			$("#t1 tbody").html(str);
			
		});
		
		
	}
</script>
</body>
</html>