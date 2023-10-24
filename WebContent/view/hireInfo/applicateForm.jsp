<%@page import="DAO.hireInfoDAO.HireInfoDAO"%>
<%@page import="VO.IMemberVO.IMemberVO"%>
<%@page import="VO.appFormVO.AppFormVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<% 
	request.setCharacterEncoding("UTF-8"); 
	String id = (String)session.getAttribute("ssn");
	String cname = request.getParameter("cname");
	System.out.println("cname: " + cname);
	IMemberVO vo = new HireInfoDAO().getImember(id);
	
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
								<input type="hidden" name="id" value="${vo.id}">
								<input type="hidden" name="cname" value="<%=cname%>">
									<table border="none">
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">이름</th>
											<td><input type="text" name="name" value="${vo.name}"></td>
											<th style="border:1px solid gray;" >주민등록번호</th>
											<td><input type="text" value="${fn:substring(vo.ssn,0,6)} - ${fn:substring(vo.ssn,7,8)}******"></td>
											<td rowspan="4" id="photo" height="300px"> <img alt="증명사진란" src="${path}/upload/${vo.fileName}" style="height: 300px; vertical-align: middle; object-fit: scale-down;"> </td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">전화번호</th>
											<td><input type="tel" name="tel" value="${vo.itel}"></td>
											<th style="border:1px solid gray;">병역이행여부</th>
											<td>
												<input type="radio" name="milServ" value="군필" > 군필
												<input type="radio" name="milServ" value="미필"> 미필
												<input type="radio" name="milServ" value="군면제"> 군면제
												<input type="radio" name="milServ" value="해당사항없음" checked> 해당사항없음
											</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">주소</th>
											<td colspan="4"><input type="text" name="addr" value="${vo.addr1}) ${vo.addr2} ${vo.addr4} (${vo.addr3})" style="width: 70%"></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">최종학력</th>
											<td colspan="4">
												<input type="text" name="edu" value=""> 학교 <br>
												<input type="radio" name="eduStat" value="재학" checked> 재학
												<input type="radio" name="eduStat" value="졸업"> 졸업
												<input type="radio" name="eduStat" value="휴학"> 휴학
												<input type="radio" name="eduStat" value="중퇴"> 중퇴
											</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">경력사항</th>
											<th style="border:1px solid gray;">회사명</th>
											<th style="border:1px solid gray;">근무기간</th>
											<th style="border:1px solid gray;" colspan="2">담당업무</th>
										</tr>
										<tr style="border:1px solid gray;">
												<td rowspan="3" style="text-align: center; padding: 0;">경력사항</td>
												<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="carCname" value=""></td>
												<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="cstartDate" value=""> ~ <input type="date" name="cendDate" value=""></td>
												<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2"><input type="text" name="damdang" value=""></td>
										</tr>
										<tr style="border:1px solid gray;">
												<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="carCname" value=""></td>
												<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="cstartDate" value=""> ~ <input type="date" name="cendDate" value=""></td>
												<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2"><input type="text" name="damdang" value=""></td>
										</tr>
										<tr style="border:1px solid gray;">
												<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="carCname" value=""></td>
												<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="cStartDate" value=""> ~ <input type="date" name="cendDate" value=""></td>
												<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2"><input type="text" name="damdang" value=""></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">자격(면허)증 사항</th>
											<th style="border:1px solid gray;">자격(면허)증 종목</th>
											<th style="border:1px solid gray;">자격(면허)증 등록번호</th>
											<th style="border:1px solid gray;">자격(면허)증 취득일</th>
											<th style="border:1px solid gray;">자격(면허)증 발행처</th>
										</tr>
										<tr style="border:1px solid gray;">
											<td rowspan="3" style="text-align: center; padding: 0;">자격(면허)증</td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="lname" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="lnum" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="getDate" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="pub" value=""></td>
										</tr>
										<tr style="border:1px solid gray;">
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="lname" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="lnum" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="getDate" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="pub" value=""></td>
										</tr>
										<tr style="border:1px solid gray;">
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="lname" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="lnum" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="getDate" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="pub" value=""></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">교육·훈련 사항</th>
											<th style="border:1px solid gray;">교육·훈련명</th>
											<th style="border:1px solid gray;">교육·훈련 기간</th>
											<th style="border:1px solid gray;" colspan="2">교육·훈련 내용</th>
										</tr>
										<tr style="border:1px solid gray;">
											<td rowspan="3" style="text-align: center; padding: 0;">교육·훈련 사항</td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="eduName" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="tstartDate" value=""> ~ <input type="date" name="tendDate" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2"><input type="text" name="content" value=""></td>
										</tr>
										<tr style="border:1px solid gray;">
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="eduName" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="tstartDate" value=""> ~ <input type="date" name="tendDate" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2"><input type="text" name="content" value=""></td>
										</tr>
										<tr style="border:1px solid gray;">
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="text" name="eduName" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;"><input type="date" name="tstartDate" value=""> ~ <input type="date" name="tendDate" value=""></td>
											<td style="border:1px solid gray; text-align: center; padding: 0;" colspan="2"><input type="text" name="content" value=""></td>
										</tr>
									</table>
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