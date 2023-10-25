<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE HTML>
<html>
	<head>
		<title>부산 취업박람회 자기소개 컨설팅</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		
		<style type="text/css">
		
		</style>
	</head>
	<body class="no-sidebar is-preload">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="index.html" id="logo">자기소개서 컨설팅</a></h1>
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
							<table >
								<tr align = center>									
									<td>구분</td>
									<td>이용시간</td>
									<td>이용인원</td>
									<td>사전신청</td>
									<td>신청인원</td>
								</tr>
								
								<c:forEach var="consVO" items="${requestScope.conslist }">
								<tr align = center>
									<td>${consVO.ampm}</td>
									<td>${consVO.startTime}~${consVO.endTime}</td>
									<td>${consVO.usePeople}</td>
									<td><input type="submit" value="신청하기" onClick="location.href='${path}/jobExp/consReg.do?'"/><td>
									<td>(<span>0</span>/${consVO.usePeople})</td>
									
									
								</tr>
								</c:forEach>
							
							</table>
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
			<script type="text/javascript">
		
			var user = document.getElementById('user');
		
			user.innerText="0";
		
		</script>

	</body>
</html>