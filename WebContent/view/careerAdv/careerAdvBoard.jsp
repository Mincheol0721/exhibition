<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE HTML>
<html>
	<head>
		<title>부산 취업박람회 진로상담</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style type="text/css">
		
		.box{
		display: inline-block;
		width: 100px;
		height: 30px;
		background-color:rgb(190,190,190);
		border-radius: 20%;
		text-align: center;
		margin-right: 20px;
		margin-left: 150px;
		
		}
		
		.content{
		
		/*display:inline;*/
		}
		</style>
	</head>
	<body class="no-sidebar is-preload">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="index.html" id="logo">진로상담</a></h1>
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
						<p>
							<div class="box">대상</div><span class="content">${requestScope.careerAdvlist[0].iPart}</span>
							<div class="box">장소</div><span class="content">${requestScope.careerAdvlist[0].locate}</span>
							<div class="box">이용시간</div><span class="content">${requestScope.careerAdvlist[0].startTime}~${requestScope.careerAdvlist[0].endTime}</span>
						</p>	
						
							<c:forEach var="careerAdv" items="${requestScope.careerAdvlist }">
							<header>
							
								<p><img style="float:left;" src="${path}/upload/career.jpg" alt="" /></p>
								<p>
								<h2>${careerAdv.title}</h2>
								<p>                            
									${careerAdv.content}
								</p>
								
							
							<p> <img src="${path}/images/plan1_tel_icon.png" style="vertical-align: middle;">&nbsp;&nbsp;&nbsp;${careerAdv.catel}&nbsp;&nbsp;&nbsp;&nbsp;   
							<img src="${path}/images/plan1_home_icon.png" style="vertical-align: middle;">&nbsp;&nbsp;&nbsp;${careerAdv.homepage}</p>
							</header>
							
							
							
							
							</c:forEach>
							
						</article>
						<hr />
						
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

	</body>
</html>