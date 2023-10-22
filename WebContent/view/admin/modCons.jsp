<%@page import="VO.applicantVO.ApplicantVO"%>
<%@page import="DAO.applicantDAO.ApplicantDAO"%>
<%@page import="VO.pgsVO.PgsVO"%>
<%@page import="DAO.pgsDAO.PgsDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<% 
	request.setCharacterEncoding("UTF-8"); 
	
	ApplicantDAO dao = new ApplicantDAO();
	ApplicantVO vo = null;
	
	int no = Integer.parseInt(request.getParameter("no"));
	System.out.println("modMeeting에서 받아오는 글번호: " + no);
	
%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<title>신청자 관리 - 모의면접</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				var btn = $('.mod');
				<%-- 
				btn.on('click', function(e) {
					$(this).parent().parent().html('<td><input type="text" name="name" value="${vo.name}"></td>' +
													'<td><input type="tel" name="sitel" value="${vo.sitel}"></td>' +
													'<td><input type="date" name="regDate" value="${ fn:substring(vo.regDate, 0, 10) }"</td>' + 
													'<td><input type="time" name="startTime" value="${vo.startTime}"</td>' + 
													'<td><button type="button" onclick="location.href=\'<%=request.getContextPath()%>/applicant/modMeeting.do?no=${vo.no}\'">수정</button></td>' +
													'<td><button type="button" onclick="location.href=\'<%=request.getContextPath()%>/applicant/delMeeting.do?no=${vo.no}\'">삭제</button></td>');
				});
				 --%>
			});
			
		</script>
		<style type="text/css">
			.layout {
				width: 100%;
				display: grid;
				grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
				gap: 8px;
			}
			.pgTr:hover {
				cursor: pointer;
			}
			.flexbox {
				display: flex;
				justify-content: flex-end;
				align-items: flex-start;
			}
			.flexbox [type=button] {
				margin-bottom: 30px;
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
							<h2>신청자 관리 - 모의면접</h2>
							<div>
							<jsp:include page="/inc/pgsBtn.jsp" />
							</div>
							<section class="layout">
								<form action="<%=request.getContextPath()%>/applicant/modCons.do?no=<%=no%>" method="post">
	                        	<table class="table table-striped" style="font-size: 14px; vertical-align: middle; text-align: center;">
									<tr style="font-weight: 700;">
										<th>신청자명</th>
									  	<th>신청자 연락처</th>
									  	<th>신청일</th>
									  	<th>신청시간</th>
									  	<th>수정</th>
									  	<th>삭제</th>
									</tr>
									<tr class="tr">
										<td><input type="text" name="name" value="${vo.name}"></td>
										<td><input type="tel" name="sitel" value="${vo.sitel}"></td>
										<td><input type="date" name="regDate" value="${fn:substring(vo.regDate,0,10)}"></td>
										<td><input type="time" name="startTime" value="${vo.startTime}"></td>
										<td><button type="submit">수정</button></td>
										<td><button type="button" onclick="location.href='<%=request.getContextPath()%>/applicant/delcons.do?no=<%=no%>'">삭제</button></td>
									</tr>
								</table>
								</form>
							</section>
						</header>
						</article>
					</div>
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