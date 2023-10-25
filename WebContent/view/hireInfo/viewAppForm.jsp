<%@page import="VO.appFormVO.AppFormVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<% 
	request.setCharacterEncoding("UTF-8"); 
	String cname = request.getParameter("cname");
%>

<!DOCTYPE html>
<html>
	<head>
		<title>입사지원서</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
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
		table input:not([type:radio]) {
			margin: 10px auto;
			border: 1px solid rgba(0,0,0,0.2);
			width: 100%;
		}
		table input[type=date] {
			width: 40%;
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
								<form action="<%=request.getContextPath()%>/appForm/applicateComp.do" method="post">
								<input type="hidden" name="ssn" value="${vo.ssn}">
								<input type="hidden" name="cname" value="<%=cname%>">
									<table border="none">
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">이름</th>
											<td><input type="text" name="name" value="${vo.name}"></td>
											<th style="border:1px solid gray;" >주민등록번호</th>
											<td><input type="text" name="ssn" value="${vo.ssn}"></td>
											<td rowspan="4" id="photo" height="300px">
												<img alt="증명사진란" src="${path}/upload/${ivo.fileName}" style="height: 300px; vertical-align: middle; object-fit: scale-down;"> 
											</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">전화번호</th>
											<td><input type="text" name="tel" value="${vo.tel}"></td>
											<th style="border:1px solid gray;">병역이행여부</th>
											<td>
												<input type="radio" name="milServ" value="군필" <c:if test="${vo.milServ eq '군필'}">checked</c:if>> 군필
												<input type="radio" name="milServ" value="미필" <c:if test="${vo.milServ eq '미필'}">checked</c:if>> 미필
												<input type="radio" name="milServ" value="면제" <c:if test="${vo.milServ eq '군면제' || vo.milServ eq '면제'}">checked</c:if>> 면제
												<input type="radio" name="milServ" value="해당사항없음" <c:if test="${vo.milServ eq '해당사항없음'}">checked</c:if>> 해당사항없음
											</td>
											</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">주소</th>
											<td colspan="4"><input type="text" name="addr" value="${vo.addr}"></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">최종학력</th>
											<td colspan="4">
												<input type="text" name="edu" value="${vo.edu}"> 학교 <br>
												<input type="radio" name="eduStat" value="재학" <c:if test="${vo.eduStat eq '재학'}">checked</c:if>> 재학
												<input type="radio" name="eduStat" value="졸업" <c:if test="${vo.eduStat eq '졸업'}">checked</c:if>> 졸업
												<input type="radio" name="eduStat" value="휴학" <c:if test="${vo.eduStat eq '휴학'}">checked</c:if>> 휴학
												<input type="radio" name="eduStat" value="중퇴" <c:if test="${vo.eduStat eq '중퇴'}">checked</c:if>> 중퇴
											</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">경력사항</th>
											<th style="border:1px solid gray;">회사명</th>
											<th style="border:1px solid gray;">근무기간</th>
											<th style="border:1px solid gray;" colspan="2">담당업무</th>
										</tr>
							<c:set var="carExpSize" value="${fn:length(carExp)}" />
							<c:forEach var="carExp" items="${carExp}" varStatus="loop">
							<c:set var="cstartDate" value="${carExp.cstartDate}" />
							<c:set var="cendDate" value="${carExp.cendDate}" />
							<c:set var="start" value='${fn:substring(cstartDate, 0, 10)}' />
							<c:set var="end" value='${fn:substring(cendDate, 0, 10)}' />
								<c:choose>
									<c:when test="${loop.index == 0}">
										<tr style="border:1px solid gray;">
										<c:if test="${carExpSize >= 3}">
											<td rowspan="3" style="text-align: center; padding: 0;">경력사항</td>
										</c:if>
										<c:if test="${carExpSize < 3}">
											<td rowspan="${carExpSize}" style="text-align: center; padding: 0;">경력사항</td>
										</c:if>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="calCname" value="${carExp.cname}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="cstartDate" value="${start}"> ~ <input type="date" name="cendDate" value="${end}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2"><input type="text" name="damdang" value="${carExp.damdang}"></td>
										</tr>
									</c:when>
									<c:when test="${loop.index < 3}">
										<tr style="border:1px solid gray;">
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="calCname" value="${carExp.cname}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="cstartDate" value="${start}"> ~ <input type="date" name="cendDate" value="${end}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2"><input type="text" name="damdang" value="${carExp.damdang}"></td>
										</tr>
									</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
							</c:forEach>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">자격(면허)증 사항</th>
											<th style="border:1px solid gray;">자격(면허)증 종목</th>
											<th style="border:1px solid gray;">자격(면허)증 등록번호</th>
											<th style="border:1px solid gray;">자격(면허)증 취득일</th>
											<th style="border:1px solid gray;">자격(면허)증 발행처</th>
										</tr>
							<c:set var="licenseSize" value="${fn:length(license)}" />
							<c:forEach var="license" items="${requestScope.license}" varStatus="loop">
							<c:set var="getDate" value="${license.getDate}" />
							<c:set var="date" value='${fn:substring(getDate, 0, 10)}' />
								<c:choose>
									<c:when test="${loop.index == 0}">
										<tr style="border:1px solid gray;">
										<c:if test="${licenseSize >= 3}">
											<td rowspan="3" style="text-align: center; padding: 0;">자격(면허)증</td>
										</c:if>
										<c:if test="${licenseSize < 3}">
											<td rowspan="${licenseSize}" style="text-align: center; padding: 0;">자격(면허)증</td>
										</c:if>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="lname" value="${license.lname}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="lnum" value="${license.lnum}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="getDate" value="${date}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="pub" value="${license.pub}"></td>
										</tr>
									</c:when>
										<c:when test="${loop.index < 3}">
											<tr style="border:1px solid gray;">
												<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="lname" value="${license.lname}"></td>
												<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="lnum" value="${license.lnum}"></td>
												<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="getDate" value="${date}"></td>
												<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="pub" value="${license.pub}"></td>
											</tr>
										</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
							</c:forEach>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">교육·훈련 사항</th>
											<th style="border:1px solid gray;">교육·훈련명</th>
											<th style="border:1px solid gray;">교육·훈련 기간</th>
											<th style="border:1px solid gray;" colspan="2">교육·훈련 내용</th>
										</tr>
											<c:set var="trainingSize" value="${fn:length(training)}" />
						 	<c:forEach var="training" items="${training}" varStatus="loop">
											<c:set var="tstartDate" value="${training.tstartDate}" /> 
											<c:set var="tendDate" value="${training.tendDate}" />
											<c:set var="tstart" value='${fn:substring(tstartDate, 0, 10)}' />
											<c:set var="tend" value='${fn:substring(tendDate, 0, 10)}' />
						 		<c:choose>
						 			<c:when test="${loop.index == 0}">
										<tr style="border:1px solid gray;">
										<c:if test="${trainingSize >= 3 }">
											<td rowspan="3" style="text-align: center; padding: 0;">교육·훈련 사항</td>
										</c:if>
										<c:if test="${trainingSize < 3 }">
											<td rowspan="${trainingSize}" style="text-align: center; padding: 0;">교육·훈련 사항</td>
										</c:if>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="eduName" value="${training.eduName}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="tstartDate" value="${tstart}"> ~ <input type="date" name="tendDate" value="${tstart}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2"><input type="text" name="content" value="${training.content}"></td>
										</tr>
						 			</c:when>
						 			<c:when test="${loop.index < 3}">
										<tr style="border:1px solid gray;">
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="eduName" value="${training.eduName}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="tstartDate" value="${tstart}"> ~ <input type="date" name="tendDate" value="${tstart}"></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2"><input type="text" name="content" value="${training.content}"></td>
										</tr>
						 			</c:when>
						 			<c:otherwise></c:otherwise>
						 		</c:choose>
							</c:forEach> 
									</table>
									<input type="button" value="글목록" onclick="javascript: history.go(-1);">
									<input type="submit" value="지원하기">
									<input type="reset" value="다시작성">
								</form>
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