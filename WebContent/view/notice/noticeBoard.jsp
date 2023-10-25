<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE HTML>
<html>
	<head>
		<title>부산 취업박람회 공지사항</title>
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
								<h1><a href="index.html" id="logo">공지사항</a></h1>
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
						<form id="mainform" action="" method="post" name="mainform">
                   	           <table id="main_tabel" border="1"  style="border-collapse: collapse; border-color: lightgrey;" class="lec"> 
                   	           		<tr bgcolor="lightgrey" align="center">
                   	           			<td width=5%>번호</td>
                   	           			<td width=5%>분류</td>
                   	           			<td width=5%>제목</td>
                   	           			<td width=5%>작성일</td>
                   	           			<td width=5%>조회수</td>
                   	           		</tr>
                   	           		<c:forEach var="NoticeVO" items="${requestScope.noticelist}">
                   	           		<tr align="center">
                   	           			<td>${NoticeVO.no }</td>
                   	           			<td>${NoticeVO.articleType }</td>
                   	           			<td><a href="${path}/notice/viewNotice.do?no=${NoticeVO.no }">${NoticeVO.title }</a></td>
                   	           			<td>${NoticeVO.writeDate }</td>
                   	           			<td>${NoticeVO.readCount }</td>	
                   	           		</tr>
                   	           		</c:forEach>
                   	           	</table>
                   	      </form>
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