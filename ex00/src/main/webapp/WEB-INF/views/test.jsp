<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Ajax Test Page</h2>
	
	<ul id="replies">
	</ul>
	
	<!-- jQuery 2.1.4 -->
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js">
	
		var bno = 3;
	
		/* @RestController의 경우 객체를 JSON 방식으로 전달하기 때문에 jQuery를 이용해서 호출할 때는
		getJSON()을 이용한다. */
		$.getJSON("/replies/all/" + bno, function(data){
			
			var str ="";
			console.log(data.length);
			
			$(data).each(function(){
				str += "<li data-rno='"+this.rno+"' class='replyLi'>"
					+ this.rno + ":" + this.replytext
					+ "</li>";
			});
			
			$("#replies").html(str);
		});
	
	
	</script>
	
</body>
</html>