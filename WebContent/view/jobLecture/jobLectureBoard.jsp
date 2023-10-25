<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE HTML>
<html>
	<head>
		<title>부산 취업박람회 취업특강</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		
		.plan4_list {
		position: relative;
    	margin: 0;
    	padding: 34px 24px;
    	width: calc(50% - 15px);
    	box-shadow: 2px 9px 20px rgba(0,0,0,0.1);}
    	
    	.plan4_list > div {
    	margin: 0;
    	padding: 24px;
    	width: 100%;
    	background: rgb(230,230,230);
    	border: 0;
    	border-radius: 6px;}
}
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
								<h1><a href="index.html" id="logo">취업특강</a></h1>
							</header>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<jsp:include page="/inc/menu.jsp" />
						</nav>

				</div>

			<!-- Main -->
				<div class="plan4_list" style=" float: left">
				<h1>${jobLecturelist[0].no }</h1>
				<p>${jobLecturelist[0].title }</p>
					<div>
					<p>특강시간:${jobLecturelist[0].startTime }~${jobLecturelist[0].endTime}</p>
					<p>특강강사:${jobLecturelist[0].teacher }</p>
					</div>
				</div>
				
				<div class="plan4_list" style=" float: left">
				<h1>${jobLecturelist[1].no }</h1>
				<p>${jobLecturelist[1].title }</p>
				<div>
					<p>특강시간:${jobLecturelist[1].startTime }~${jobLecturelist[0].endTime}</p>
					<p>특강강사:${jobLecturelist[1].teacher }</p>
					</div>
				</div>
				
				<div class="plan4_list">
				<h1>${jobLecturelist[2].no }</h1>
				<p>${jobLecturelist[2].title }</p>
					<div>
					<p>특강시간:${jobLecturelist[2].startTime }~${jobLecturelist[0].endTime}</p>
					<p>특강강사:${jobLecturelist[2].teacher }</p>
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