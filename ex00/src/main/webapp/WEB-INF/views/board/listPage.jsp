<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<%@include file="../include/header.jsp" %>

	
	<div class="text-center">
		<ul class="pagination">
		
		<c:if test="${pageMaker.prev}">
			<li><a href="listPage?page=${pageMaker.startPage - 1}">&laquo;</a></li>
		</c:if>
		
		<c:forEach var="idx" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
			<li
				<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
				<a href="listPage?page=${idx }">${idx }</a>
			</li>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
			<li><a href="listPage?page=${pageMaker.endPage +1 }">&raquo;</a></li>
		</c:if>
		
		</ul>
	</div>
	
	
	
	

<%@include file="../include/footer.jsp" %>

<script>
	var result = '${msg}';
	
	if(result == 'success'){
		alert("처리가 완료되었습니다.");
	}

</script>