<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>
<%
	int isAdmin = (Integer)session.getAttribute("isAdmin");
%>
<c:set var="path" value="<%=request.getContextPath()%>" /> 
<c:set var="isAdmin" value="${sessionScope.isAdmin}"></c:set>
<!DOCTYPE html>
<html>
<head>
	<title>NewsLetters[뉴스레터 게시판]</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="${path}/assets/css/main.css" />
	<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">    	
    
</head>

	<div id="page-wrapper">
			
			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="#" id="logo">뉴스 레터</a></h1>
							</header>
						</div>

					<!-- Nav -->
					<nav id="nav">
						<jsp:include page="/inc/menu.jsp" />
					</nav>
				</div>
				
			<!-- Main -->
				<div class="wrapper style1">
					<div class="container">				
						<article id="main" class="special">					
					<section>					
    				<table class="table table-hover">
	    				<tr>
		    				<th>글 번호</th> 
		    				<td> <c:out value="${vo.no}" /> </td>
		    			</tr>
		    			<tr>
		    				<th>제목</th>
		    				<td><c:out value="${vo.title}" /></td>
		    			</tr>
		    			<tr>		
		    				<th>내용</th>  				
							<td><c:out value="${vo.content}" /></td>
						</tr>					    
					</table>
					  	<!-- 뒤로가기 버튼 -->
					    <a href="javascript:history.go(-1);">뒤로가기</a> 
					    
					    <!-- 수정 버튼을 추가, 수정 폼으로 이동 -->
					    <!-- 관리자로 로그인한 경우에만 수정 버튼 표시 -->
					    <c:if test="${isAdmin == 1}">
					        <a href="${path}/Articles/modNewsLetter.do?no=${vo.no}">수정</a>
					    </c:if>	
				</section>
					</article>
				</div>
			</div>

		<!-- Footer -->
			<div id="footer">
				<jsp:include page="/inc/footer.jsp" />
			</div>
		</div>

		<!-- Scripts -->
		<script src="${path}/assets/js/jquery.min.js"></script>
		<script src="${path}/assets/js/jquery.dropotron.min.js"></script>
		<script src="${path}/assets/js/jquery.scrolly.min.js"></script>
		<script src="${path}/assets/js/jquery.scrollex.min.js"></script>
		<script src="${path}/assets/js/browser.min.js"></script>
		<script src="${path}/assets/js/breakpoints.min.js"></script>
		<script src="${path}/assets/js/util.js"></script>
		<script src="${path}/assets/js/main.js"></script>

	
</html>