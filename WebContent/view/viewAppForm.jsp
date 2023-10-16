<%@page import="DAO.eventDAO.EventDAO"%>
<%@page import="VO.eventVO.EventVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<% 
	request.setCharacterEncoding("UTF-8"); 
	
	int no = Integer.parseInt(request.getParameter("no"));
	EventVO vo = null;
	EventDAO dao = new EventDAO();
	
	vo = dao.getEvent(no);
	
	System.out.println("title: " + vo.getTitle());
%>

<!DOCTYPE html>
<html>
	<head>
		<title>부대행사 등록</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<style type="text/css">
		td {
			text-align: left;
			border: 1px solid gray;
			border-collapse: collapse;
		}
		th {
			background-color: lightgray;
			border: 1px solid gray;
			border-collapse: collapse;
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
							<jsp:include page="../inc/menu.jsp" />
						</nav>

				</div>

			<!-- Main -->
				<div class="wrapper style1">

					<div class="container">
						<article id="main" class="special">
							<header>
								<h2>부대행사 상세보기</h2>
								<hr>
									<input type="hidden" name="no" value=<%=vo.getNo()%>>
									<table border="none">
										<tr style="border: 1px solid lightgray; border-collapse: collapse;">
											<th>행사명</th>
											<td style="padding-left: 20px;"><%=vo.getTitle()%></td>
										</tr>
										<tr style="border: 1px solid lightgray; border-collapse: collapse;">
											<th style="vertical-align: middle;">내용</th>
											<td style="padding-left: 20px;"><%=vo.getContent()%></td>
										</tr>
										<tr style="border: 1px solid lightgray; border-collapse: collapse;">
											<th>대상</th>
											<td style="padding-left: 20px;"><%=vo.getIpart()%></td>
										</tr>
										<tr style="border: 1px solid lightgray; border-collapse: collapse;">
											<th>소요시간</th>
											<td style="padding-left: 20px;"><%=vo.getReqTime()%></td>
										</tr>
										<tr style="border: 1px solid lightgray; border-collapse: collapse;">
											<th>이용시간</th>
											<td style="padding-left: 20px;"><%=vo.getStartTime()%> ~ <%=vo.getEndTime()%></td>
										</tr>
										<tr style="border: 1px solid lightgray; border-collapse: collapse;">
											<th>제공서비스</th>
											<td style="padding-left: 20px;"><%=vo.getService()%></td>
										</tr>
										<tr style="border: 1px solid lightgray; border-collapse: collapse;">
											<th>장소</th>
											<td style="padding-left: 20px;"><%=vo.getLocate()%></td>
										</tr>
										
									</table>
									<input type="button" value="글목록" onclick="javascript: history.go(-1);">
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