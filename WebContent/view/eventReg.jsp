<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<!DOCTYPE html>
<html>
	<head>
		<title>부대행사 등록</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="no-sidebar is-preload">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="index.jsp" id="logo">부산 취업 박람회</a></h1>
							</header>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<jsp:include page="../inc/menu.jsp" />
						</nav>

				</div>

			<!-- Main -->
				<div class="wrapper style1">

					<div class="container">
						<article id="main" class="special">
							<header>
								<h2>부대행사 등록</h2>
								<hr>
								<form action="${path}/event/reg.do" method="post">
									<table border="none">
										<tr>
											<th>행사명</th>
											<td><input type="text" name="title"></td>
										</tr>
										<tr>
											<th style="vertical-align: middle;">내용</th>
											<td><textarea cols="20" name="content"></textarea></td>
										</tr>
										<tr>
											<th>대상</th>
											<td><input type="text" name="ipart"></td>
										</tr>
										<tr>
											<th>소요시간</th>
											<td><input type="text" name="reqTime"></td>
										</tr>
										<tr>
											<th>이용시간</th>
											<td><input type="text" name="startTime" style="width: 29%"> ~ <input type="text" name="endTime" style="width: 29%"></td>
										</tr>
										<tr>
											<th>제공서비스</th>
											<td><input type="text" name="service"></td>
										</tr>
										<tr>
											<th>장소</th>
											<td><input type="text" name="locate"></td>
										</tr>
										
									</table>
									<input type="submit" value="행사등록">
									<input type="reset" value="다시작성">
								</form>
							</header>
					</div>

				</div>

			<!-- Footer -->
			<div id="footer">
				<jsp:include page="../inc/footer.jsp" />
			</div>
		</div>

	</body>
</html>