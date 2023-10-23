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
	
	<style>

		.card {
		  box-sizing: border-box;
		  width: 320px;
		  height: 350px;
		  background: rgba(217, 217, 217, 0.58);
		  border: 1px solid white;
		  box-shadow: 12px 17px 51px rgba(0, 0, 0, 0.22);
		  backdrop-filter: blur(6px);
		  border-radius: 17px;
		  text-align: center;
		  cursor: pointer;
		  transition: all 0.5s;
		  display: inline-block; /* 인라인 블록 요소로 변경 */
	      margin: 30px 30px; /* 각 카드 사이의 간격 설정 */
		  align-items: center;
		  justify-content: center;
		  user-select: none;
		  font-weight: bolder;
		  color: black;
		}
		
		.card:hover {
		  border: 1px solid black;
		  transform: scale(1.05);
		}
		
		.card:active {
		  transform: scale(0.95) rotateZ(1.7deg);
		}
		
	</style>   
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
								<div class="card-containner">									
								    <c:forEach items="${cInfoList}" var="cInfo">
								        <div class="card">
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