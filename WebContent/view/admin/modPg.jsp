<%@page import="DAO.pgsDAO.PgsDAO"%>
<%@page import="VO.pgsVO.PgsVO"%>
<%@page import="VO.appFormVO.AppFormVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<% 
	request.setCharacterEncoding("UTF-8"); 
	PgsVO vo = null;
	PgsDAO dao = new PgsDAO();
	int pno = Integer.parseInt(request.getParameter("pno"));
	vo = dao.getPgs(pno);
%>

<!DOCTYPE html>
<html>
	<head>
		<title>프로그램 및 행사 관리</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$('#pgtype').val('<%=vo.getPgtype()%>').prop("selected",true);
				
				//시작일자에 맞춰 종료일자를 시작일자 이전으로 설정하지 못하게 처리
				$('#startDate').on('change', function() {
					endDate.attr('min', startDate.val());
				});
				
				//시작시간에 맞춰 종료시간을 시작시간 이전으로 설정하지 못하게 처리
				var startTime = $('#startTime');
				var endTime = $('#endTime');
				
				$('#startTime').on('change', function() {
					console.log(startTime.val());
					endTime.attr("min", startTime.val());
				});
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
								<h2>프로그램 및 행사 내용 수정</h2>
								<hr>
									<form action="${path}/pgs/modPgs.do" method="post">
									<input type="hidden" name="pno" value="<%=vo.getPno()%>">
									<table border="none">
										<tr>
											<th>프로그램 종류</th>
											<td>
												<select name="pgtype" id="pgtype">
													<option value="">--------------- 선택 ---------------</option>
													<option value="상담">상담</option>
													<option value="컨설팅">컨설팅</option>
													<option value="특강">특강</option>
												</select>
											</td>
										</tr>
										<tr>
											<th>프로그램명</th>
											<td><input type="text" name="pgname" value="<%=vo.getPgname()%>"></td>
										</tr>
										<tr>
											<th>제목</th>
											<td><input type="text" name="title" value="<%=vo.getTitle()%>"></td>
										</tr>
										<tr>
											<th style="vertical-align: middle;">내용</th>
											<td><textarea name="content" cols="80"><%=vo.getContent()%></textarea></td>
										</tr>
										<tr>
											<th>대상</th>
											<td><input type="text" name="ipart" value="<%=vo.getIpart()%>"></td>
										</tr>
										<tr id="colTeacher">
											<th>강사</th>
											<td><input type="text" name="teacher" value="<%=vo.getTeacher()%>"></td>
										</tr>
										<tr>
											<th>진행 기간</th>
											<td>
												<input type="date" id="startDate" name="startDate" value="<%=vo.getStartDate().substring(0, 10)%>">
												&nbsp;&nbsp;~&nbsp;&nbsp;
												<input type="date" id="endDate" name="endDate"  value="<%=vo.getEndDate().substring(0, 10)%>">
											</td>
										</tr>
										<tr>
											<th>프로그램 시간</th>
											<td>
												<input type="time" name="startTime" id="startTime"  value="<%=vo.getStartTime()%>" required>
												&nbsp;&nbsp;~&nbsp;&nbsp;
												<input type="time" name="endTime" id="startTime" value="<%=vo.getEndTime()%>" required>
											</td>
										</tr>
										<tr>
											<th>진행 장소</th>
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