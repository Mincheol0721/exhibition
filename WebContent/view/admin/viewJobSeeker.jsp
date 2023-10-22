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
		<title>구직자 관리</title>
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
								<h2>구직자 정보 상세보기</h2>
								<hr>
									<table border="none">
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;" width="20%">구직자 ID</th>
											<td width="30%">${vo.id} </td>
											<th style="border:1px solid gray; width: 20%">구직자명</th>
											<td width="30%">${vo.name}</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">구직자 연락처</th>
											<td>${vo.itel}</td>
											<th style="border:1px solid gray;">구직자 주민등록번호</th>
											<td>${fn:substring(vo.ssn,0,8)}******</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">이메일 주소</th>
											<td colspan="3">${vo.email}</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">주소</th>
											<td colspan="3">
											${vo.addr1})&nbsp; ${vo.addr2}&nbsp; ${vo.addr4}
										 	<c:if test="${vo.addr3 != '-'}">
										 	&nbsp;(${vo.addr3})
										 	</c:if>
											</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">회원가입일</th>
											<td>${vo.regDate}</td>
											<th style="border:1px solid gray;">구직상태</th> 
											<td>
											<c:choose>
										 	<c:when test="${vo.isSeek == 0}">
											 	구직중
										 	</c:when>
										 	<c:when test="${vo.isSeek == 1}">
											 	재직중
										 	</c:when>
										 	<c:when test="${vo.isSeek == 2}">
											 	휴직중
										 	</c:when>
										 	</c:choose>
											</td>
										</tr>
									</table>
									<input type="button" value="글목록" onclick="location.href='${path}/applicant/getImember.do'">
									<input type="button" class="adminBtn" value="수정하기" onclick="location.href='${path}/applicant/modJSPage.do?id=${vo.id}'">
									<input type="button" class="adminBtn" value="삭제하기" onclick="location.href='${path}/applicant/delJobSeeker.do?id=${vo.id}'">
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