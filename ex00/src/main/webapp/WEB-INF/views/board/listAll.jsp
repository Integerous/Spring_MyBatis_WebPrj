<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<table class="table table-bordered">
		<tr>
			<th style="width: 10px">BNO</th>
			<th> TITLE </th>
			<th> WRITER </th>
			<th> REGDATE </th>
			<th style="width: 40px">VIEWCNT</th>
		</tr>
	</table>
</body>
</html>

<script>
	var result = '${msg}';
	
	if(result == 'SUCCESS'){
		alert("처리가 완료되었습니다.");
	}

</script>