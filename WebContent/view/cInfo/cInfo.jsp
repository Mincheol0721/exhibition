<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />  

<!DOCTYPE html>
<html>
<head>
	<title>취업 박람회 기업 정보</title>
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
								<h1><a href="#" id="logo">참여 기업 정보</a></h1>
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
							<header>
								<h2><a href="#">참여 기업</a></h2>							
							</header>			
							<section>		
								<div class="card-container">									
								    <c:forEach items="${cInfoList}" var="cInfo">
								        <div>
								            <p><h3>${cInfo.cname}</h3></p>
								            <p><strong>회사전화번호:</strong> ${cInfo.ctel}</p>
								            <p><strong>대표자명:</strong> ${cInfo.name}</p>
								            <p><strong>기업 사업체 구분:</strong> ${cInfo.divcomp}</p>
								            <p><strong>모집 직종:</strong> ${cInfo.jobtype}</p>	
								        </div>	           
								    </c:forEach>
								</div>						  	
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