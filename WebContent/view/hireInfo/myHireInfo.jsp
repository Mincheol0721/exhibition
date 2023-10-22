<%@page import="java.util.List"%>
<%@page import="VO.hireInfoVO.HireInfoVO"%>
<%@page import="DAO.hireInfoDAO.HireInfoDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	request.setCharacterEncoding("UTF-8");
	String cname = (String)session.getAttribute("cname");
	System.out.println("cname: " + cname);
	HireInfoVO vo = null;
	HireInfoDAO dao = new HireInfoDAO();
	
	vo = dao.getHireInfo(cname);
	int dday = vo.getExpireDate();
%>

<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<title>MY 채용정보</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				
			});
		</script>
		<style type="text/css">
			th {
				background-color: lightgray;
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
								<h2>MY 채용정보</h2>
								<br>
								<br>
								<form action="${path}/hireInfo/modPage.do?cname=<%=vo.getCname()%>" method="post">
									<table style="border:1px solid gray; border-collapse: collapse;">
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">기업명</th>
											<td><%=vo.getCname()%></td>
											<th style="border:1px solid gray;">대표자명</th>
											<td><%=vo.getCname()%></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">주소</th>
											<td colspan="3" style="text-align: left; padding-left: 20px;"><%=vo.getHomepage()%></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">홈페이지</th>
											<td colspan="3" style="text-align: left; padding-left: 20px;">
												<a href="<%=vo.getHomepage()%>" style="text-decoration: none;"><%=vo.getHomepage()%></a>
											</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">모집 직종</th>
											<td><%=vo.getJobtype()%></td>
											<th style="border:1px solid gray;">전화번호</th>
											<td><%=vo.getHtel()%></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">근무지역</th>
											<td><%=vo.getLegal()%></td>
											<th style="border:1px solid gray;">근무시간</th>
											<td><%=vo.getWorkTime()%></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">모집전형</th>
											<td><%=vo.getAppType()%>접수</td>
											<th style="border:1px solid gray;">접수기간</th>
											<td><%=vo.getAppstart().substring(0,10)%> ~ <%=vo.getAppexpire().substring(0,10)%> 
												(<% if(dday<=0) { %> 접수마감)<% }else { %> 
											<%=dday %>일 남음) <% } %> </td>
										</tr>
									</table>
									<button type="submit">수정하기</button>
									<button type="button" onclick="location.href='${path}/hireInfo/del.do?cname=<%=cname%>'">삭제하기</button>
								</form>
							</header>
						</article>
					</div>
				</div>
			<!-- Footer -->
			<div id="footer">
				<jsp:include page="/inc/footer.jsp" />
			</div>
		</div>

		<!-- Scripts -->
			<script src="${path}/assets.js/jquery.min.js"></script>
			<script src="${path}/assets.js/jquery.dropotron.min.js"></script>
			<script src="${path}/assets.js/jquery.scrolly.min.js"></script>
			<script src="${path}/assets.js/jquery.scrollex.min.js"></script>
			<script src="${path}/assets.js/browser.min.js"></script>
			<script src="${path}/assets.js/breakpoints.min.js"></script>
			<script src="${path}/assets.js/util.js"></script>
			<script src="${path}/assets.js/main.js"></script>

	</body>
</html>