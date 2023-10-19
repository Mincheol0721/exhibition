<%@page import="VO.appFormVO.AppFormVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<% 
	request.setCharacterEncoding("UTF-8"); 
%>

<!DOCTYPE html>
<html>
	<head>
		<title>프로그램 및 행사 관리</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script type="text/javascript">
			$(function() {
			});
		</script>
		<style type="text/css">
		table td {
		 	vertical-align: middle;
			text-align: left;
			padding-left: 10px;
			border: 1px solid gray;
			border-collapse: collapse;
		}
		table th {
			background-color: lightgray;
			vertical-align: middle;
			border: 1px solid gray;
			border-collapse: collapse;
		}
		#photo {
			padding: 0;
			text-align: center;
			vertical-align: middle;
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
								<h1><a href="${path}/view/index.jsp" id="logo">부산 취업 박람회</a></h1>
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
								<h2>프로그램 및 행사 내용 상세보기</h2>
								<hr>
									<table border="none">
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;" width="10%">프로그램 종류</th>
											<td width="15%">[${vo.pgtype}] </td>
											<th style="border:1px solid gray; width: 30%">프로그램명</th>
											<td width="45%">${vo.title}</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">제목</th>
											<td colspan="3" style="text-align: left;">${vo.title}</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">대상</th>
											<td>${vo.ipart}</td>
											<th style="border:1px solid gray;">프로그램 기간 및 시간</th>
											<td>
												- 기간: ${fn:substring(vo.startDate, 0, 10)} ~ ${fn:substring(vo.endDate, 0, 10)} <br>
												- 진행시간: ${vo.startTime} ~ ${vo.endTime}
											</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">내용</th>
											<td colspan="3" style="min-height: 100px;"><pre>${vo.content}</pre></td>
										</tr>
									</table>
									<input type="button" value="글목록" onclick="location.href='${path}/admin/getList.do'">
									<input type="button" class="adminBtn" value="수정하기" onclick="location.href='${path}/admin/modPage.do?pno=${vo.pno}'">
									<input type="button" class="adminBtn" value="삭제하기" onclick="location.href='${path}/admin/del.do?pno=${vo.pno}'">
							</header>
					</div>

				</div>

			<!-- Footer -->
			<div id="footer">
				<jsp:include page="/inc/footer.jsp" />
			</div>
		</div>

	</body>
</html>