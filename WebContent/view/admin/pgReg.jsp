<%@page import="DAO.hireInfoDAO.HireInfoDAO"%>
<%@page import="VO.CMemberVO.CMemberVO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	request.setCharacterEncoding("UTF-8"); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String cname = request.getParameter("cname");
%>
<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<!DOCTYPE html>
<html>
	<head>
		<title>채용정보 등록</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				var startDate = $('#startDate');
				var endDate = $('#endDate'); 
				
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
			input[type="date"], input[type="time"] {
				display: inline-block;
				border: 0;
				background: #fafafa;
				width: 28%;
				border-radius: 0.5em;
				border: solid 1px #E5E5E5;
				padding: 1em;
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
								<h2>프로그램 및 행사 등록</h2>
								<hr>
								<form action="${path}/admin/reg.do" method="post">
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
											<td><input type="text" name="pgname"></td>
										</tr>
										<tr>
											<th>제목</th>
											<td><input type="text" name="title"></td>
										</tr>
										<tr>
											<th style="vertical-align: middle;">내용</th>
											<td><textarea name="content" cols="80"></textarea></td>
										</tr>
										<tr>
											<th>대상</th>
											<td><input type="text" name="ipart"></td>
										</tr>
										<tr id="colTeacher">
											<th>강사</th>
											<td><input type="text" name="teacher"></td>
										</tr>
										<tr>
											<th>진행 기간</th>
											<td>
												<input type="date" id="startDate" name="startDate" value="<%=sdf.format(new Date())%>">
												&nbsp;&nbsp;~&nbsp;&nbsp;
												<input type="date" id="endDate" name="endDate">
											</td>
										</tr>
										<tr>
											<th>프로그램 시간</th>
											<td>
												<input type="time" name="startTime" id="startTime" required>
												&nbsp;&nbsp;~&nbsp;&nbsp;
												<input type="time" name="endTime" id="startTime" required>
											</td>
										</tr>
										<tr>
											<th>진행 장소</th>
											<td><input type="text" name="locate"></td>
										</tr>
									</table>
									<input type="submit" value="등록">
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