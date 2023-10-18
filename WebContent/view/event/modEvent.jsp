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
								<h2>부대행사 등록</h2>
								<hr>
								<form action="${path}/event/modEvent.do" method="post">
									<input type="hidden" name="no" value=<%=vo.getNo()%>>
									<table border="none">
										<tr>
											<th>행사명</th>
											<td><input type="text" name="title" value="<%=vo.getTitle()%>"></td>
										</tr>
										<tr>
											<th style="vertical-align: middle;">내용</th>
											<td><textarea cols="20" name="content"><%=vo.getContent()%></textarea></td>
										</tr>
										<tr>
											<th>대상</th>
											<td><input type="text" name="ipart" value="<%=vo.getIpart()%>"></td>
										</tr>
										<tr>
											<th>소요시간</th>
											<td><input type="text" name="reqTime" value="<%=vo.getReqTime()%>"></td>
										</tr>
										<tr>
											<th>이용시간</th>
											<td><input type="text" name="startTime" style="width: 29%" value="<%=vo.getStartTime()%>"> 
											 ~ <input type="text" name="endTime" style="width: 29%" value="<%=vo.getEndTime()%>"></td>
										</tr>
										<tr>
											<th>제공서비스</th>
											<td><input type="text" name="service" value="<%=vo.getService()%>"></td>
										</tr>
										<tr>
											<th>장소</th>
											<td><input type="text" name="locate" value="<%=vo.getLocate()%>"></td>
										</tr>
										
									</table>
									<input type="submit" value="수정완료">
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