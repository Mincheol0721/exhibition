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
								<h1><a href="#" id="logo">뉴스레터 게시글 수정</a></h1>
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
					    <form action="${path}/Articles/UpdateNewsLetter.do" method="post">
						    <input type="hidden" name="no" value="${vo.no}" />
						    
						    <label for="title"> 제목:</label>
						    <input type="text" name="title" value="${vo.title}" />  <br>
						        
						    <label for="content"> 내용: </label>
						    <textarea name="content" >${vo.content}</textarea>  <br>
						    
						    <input type="submit" value="수정 완료" />
					    </form>
					    
					    <a href="${path}/Articles/NewsLetters_forAdmin.do">뉴스레터 목록</a>			    
				

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