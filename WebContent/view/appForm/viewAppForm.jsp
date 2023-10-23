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
		<title>입사지원서</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<style type="text/css">
		table td {
		 	width: 20%;
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
								<h2>입사지원서 상세보기</h2>
								<hr>
									<table border="none">
										
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">이름</th>
											<td>${vo.name}</td>
											<th style="border:1px solid gray;" >주민등록번호</th>
											<td>${vo.ssn}</td>
											<td rowspan="4" id="photo" height="300px">
												<img alt="증명사진란" src="${path}/upload/${ivo.fileName}" style="height: 300px; vertical-align: middle; object-fit: scale-down;"> 
											</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">전화번호</th>
											<td>${vo.tel}</td>
											<th style="border:1px solid gray;">병역이행여부</th>
											<td>${vo.milServ}</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">주소</th>
											<td colspan="4">${vo.addr}</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">최종학력</th>
											<td colspan="4">${vo.edu}&nbsp;(${vo.eduStat})</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">경력사항</th>
											<th style="border:1px solid gray;">회사명</th>
											<th style="border:1px solid gray;">근무기간</th>
											<th style="border:1px solid gray;" colspan="2">담당업무</th>
										</tr>
										<tr style="border:1px solid gray;">
											<c:set var="carExpSize" value="${fn:length(carExp)}" />
												<td rowspan="${carExpSize}" style="text-align: center; padding: 0;">경력사항</td>
											<c:forEach var="carExp" items="${carExp}">
											<c:set var="cstartDate" value="${carExp.cstartDate}" />
											<c:set var="cendDate" value="${carExp.cendDate}" />
											<c:set var="start" value='${fn:substring(cstartDate, 0, 10)}' />
											<c:set var="end" value='${fn:substring(cendDate, 0, 10)}' />
												<td style="border:1px solid gray; text-align: center; padding: 0;">${carExp.cname}</td>
												<td style="border:1px solid gray; text-align: center; padding: 0;">${start} ~ ${end}</td>
												<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2">${carExp.damdang}</td>
											</c:forEach>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">자격(면허)증 사항</th>
											<th style="border:1px solid gray;">자격(면허)증 종목</th>
											<th style="border:1px solid gray;">자격(면허)증 등록번호</th>
											<th style="border:1px solid gray;">자격(면허)증 취득일</th>
											<th style="border:1px solid gray;">자격(면허)증 발행처</th>
										</tr>
										<tr style="border:1px solid gray;">
											<c:set var="licenseSize" value="${fn:length(license)}" />
												<td rowspan="${licenseSize}" style="text-align: center; padding: 0;">자격(면허)증</td>
											<c:forEach var="license" items="${license}">
											<c:set var="getDate" value="${license.getDate}" />
											<c:set var="date" value='${fn:substring(getDate, 0, 10)}' />
												<td style="border:1px solid gray; text-align: center; padding: 0;">${license.lname}</td>
												<td style="border:1px solid gray; text-align: center; padding: 0;">${license.lnum}</td>
												<td style="border:1px solid gray; text-align: center; padding: 0;">${date}</td>
												<td style="border:1px solid gray; text-align: center; padding: 0;">${license.pub}</td>
											</c:forEach>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">교육·훈련 사항</th>
											<th style="border:1px solid gray;">교육·훈련명</th>
											<th style="border:1px solid gray;">교육·훈련 기간</th>
											<th style="border:1px solid gray;" colspan="2">교육·훈련 내용</th>
										</tr>
										<tr style="border:1px solid gray;">
											<c:set var="trainingSize" value="${fn:length(training)}" />
												<td rowspan="${trainingSize}" style="text-align: center; padding: 0;">교육·훈련 사항</td>
											<c:forEach var="training" items="${training}">
											<c:set var="tstartDate" value="${training.tstartDate}" /> 
											<c:set var="tendDate" value="${training.tendDate}" />
											<c:set var="tstart" value='${fn:substring(tstartDate, 0, 10)}' />
											<c:set var="tend" value='${fn:substring(tendDate, 0, 10)}' />
												<td style="border:1px solid gray; text-align: center; padding: 0;">${training.eduName}</td>
												<td style="border:1px solid gray; text-align: center; padding: 0;">${tstart} ~ ${tend}</td>
												<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2">${training.content}</td>
											</c:forEach>
										</tr>
									</table>
									<input type="button" value="글목록" onclick="javascript: history.go(-1);">
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