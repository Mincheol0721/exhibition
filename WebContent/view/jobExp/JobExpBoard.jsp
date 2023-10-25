<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE HTML>
<html>
	<head>
		<title>부산 취업박람회 직업체험</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	</head>
	<body class="no-sidebar is-preload">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="index.html" id="logo">직업체험</a></h1>
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
							
							
							<c:forEach var="cjobExpVO" items="${requestScope.expolist }">
							<header>
								<h2>${cjobExpVO.title}</a></h2>
								<p>                            
									${cjobExpVO.content}
								</p>
							
							</header>
							<a href="#" class="image featured"><img src="${path}/upload/${cjobExpVO.fileRealName}" alt="" /></a>
							<p>대상:  ${cjobExpVO.iPart}</p> 
							<p>장소: ${cjobExpVO.locate}</p> 
							<p>날짜:  ${cjobExpVO.startDate}</p>
							<p>이용시간:  ${cjobExpVO.startTime}~${cjobExpVO.endTime}</p>
							
							
							<button type="button"  onClick="location.href='${path}/jobExp/IJobExpReg.do?title=${cjobExpVO.title}'">신청하러 가기</button>
							</c:forEach>
							
						</article>
						<hr />
						<div style="text-align: center;">
						<button type="button"    onClick="location.href='${path}/jobExp/CJobExpReg.do'">직업체험 등록하기</button>
						</div>
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