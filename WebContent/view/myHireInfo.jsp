<%@page import="java.util.List"%>
<%@page import="VO.hireInfoVO.HireInfoVO"%>
<%@page import="DAO.hireInfoDAO.HireInfoDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	request.setCharacterEncoding("UTF-8");

	//String memType = 
%>

<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<title>채용정보 조회</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$.ajax({
					url: '<%=request.getContextPath()%>/hireInfo/getList.do',
					type: 'POST',
					dataType: 'json',
					success: function(data) {
						$.each(data, function(index, vo) {
							$('.layout').append('<div class="card">'
													+ '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M20 5H4V19L13.2923 9.70649C13.6828 9.31595 14.3159 9.31591 14.7065 9.70641L20 15.0104V5ZM2 3.9934C2 3.44476 2.45531 3 2.9918 3H21.0082C21.556 3 22 3.44495 22 3.9934V20.0066C22 20.5552 21.5447 21 21.0082 21H2.9918C2.44405 21 2 20.5551 2 20.0066V3.9934ZM8 11C6.89543 11 6 10.1046 6 9C6 7.89543 6.89543 7 8 7C9.10457 7 10 7.89543 10 9C10 10.1046 9.10457 11 8 11Z"></path></svg>'
													+ '<div class="card__content">'
														+ '<p class="card__title"> ' + vo.cname + ' </p>'
														+ '<p class="card__description">'
															+ '<ul>'
																+ '<li>사업체구분: ' + vo.divComp + '</li>'
																+ '<li>모집직종: ' + vo.jobType + '</li>'
																+ '<li>근무시간: ' + vo.workTime + '</li>'
																+ '<li>근무지역: ' + vo.legal + '</li>'
																+ '<li>전화번호: ' + vo.htel+ '</li>'
															+ '</ul>'
														+ '</p>'
													+ '</div>'
												+ '</div>');
						})
					}
				});
			});
		</script>
		<style type="text/css">
			.layout {
			  width: 100%;
			
			  display: grid;
			  grid-template-rows: repeat(3, 1fr);
			  grid-template-columns: repeat(3, 1fr);
			  gap: 8px;
			}
			.card {
			  position: relative;
			  margin: 0 auto;
			  width: 300px;
			  height: 250px;
			  background-color: #f2f2f2;
			  border-radius: 10px;
			  display: flex;
			  align-items: center;
			  justify-content: center;
			  overflow: hidden;
			  perspective: 1000px;
			  box-shadow: 0 0 0 5px #ffffff80;
			  transition: all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
			}
			
			.card svg {
			  width: 48px;
			  fill: #333;
			  transition: all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
			}
			
			.card:hover {
			  transform: scale(1.05);
			  box-shadow: 0 8px 16px rgba(255, 255, 255, 0.2);
			}
			
			.card__content {
			  position: absolute;
			  top: 0;
			  left: 0;
			  width: 100%;
			  height: 100%;
			  padding: 20px;
			  box-sizing: border-box;
			  background-color: #f2f2f2;
			  transform: rotateX(-90deg);
			  transform-origin: bottom;
			  transition: all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
			}
			
			.card__content li {
			  text-align: left;
			}
			
			.card:hover .card__content {
			  transform: rotateX(0deg);
			}
			
			.card__title {
			  margin: 0;
			  font-size: 24px;
			  color: #333;
			  font-weight: 700;
			}
			
			.card:hover svg {
			  scale: 0;
			}
			
			.card__description {
			  margin: 10px 0 0;
			  font-size: 14px;
			  color: #777;
			  line-height: 1.4;
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
								<h1><a href="index.jsp" id="logo">부산 취업 박람회</a></h1>
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
								<h2>채용정보 조회</h2>
								<section class="layout"></section>
							</header>
						</article>
					</div>
				</div>
			<!-- Footer -->
			<div id="footer">
				<jsp:include page="../inc/footer.jsp" />
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