<%@page import="VO.eventInfoVO.EventInfoVO"%>
<%@page import="DAO.eventInfoDAO.EventInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE HTML>
	
<html>
	<head>
		<title>[취업박람회 행사안내]</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>	
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
	</head>		
		<div id="page-wrapper">
			
			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="#" id="logo">부산 취업 박람회 소개</a></h1>
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
								<h2><a href="#">행사 안내</a></h2>
								<p>
									"2023 하반기 부산 진로·취업 박람회"
								</p>
							</header>
							<p style="text-align:center">
								대한민국의 미래 도약을 위해 일자리 기회를 제공하고 기업 구인난 해소를 지원하고자 2023년 하반기 부산 진로·취업 박람회를 개최합니다.<br>
								적성과 적합한 직업 탐색과 진로 설계의 기회를 제공하며, 좋은 일자리를 꿈꾸는 많은 청년들을 위해 마련된 행사입니다.<br>											
							</p>
							<section>
								<header>
									<h3>행사 개요</h3>
								</header>
								<div class="page-table-div">
								<div class="table-div">					
								<table class="page-table" cellspacing="0" cellpadding="0">							
							        <tr>
							            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">행사명</th>
							            <td class="page-tdb page-bgcolor1">eventInfo테이블에서 뿌려줄 데이터</td>
							        </tr>
							        <tr>
							            <th class="page-tda" style="text-align:center; padding:0px;">일시</th>
							            <td class="page-tdb">eventInfo테이블에서 뿌려줄 데이터</td>
							        </tr>
							        <tr>
							            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">장소</th>
							            <td class="page-tdb page-bgcolor1">eventInfo테이블에서 뿌려줄 데이터</td>
							        </tr>
							        <tr>
							            <th class="page-tda" style="text-align:center; padding:0px;">참여대상</th>
							            <td class="page-tdb">eventInfo테이블에서 뿌려줄 데이터</td>
							        </tr>
							        <tr>
							            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">참여방법</th>
							            <td class="page-tdb page-bgcolor1">사전등록 ~ 23. 10. 25 까지, 현장접수 및 단체접수 가능</td>
							        </tr>
							        <tr>
							            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">행사내용</th>
							            <td class="page-tdb page-bgcolor1">행사내용 / write or remove</td>
							        </tr>
							        <tr>
							            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">참여기업</th>
							            <td class="page-tdb page-bgcolor1">eventInfo테이블에서 뿌려줄 데이터</td>
							        </tr>
							    </table>
							    </div>	
							    <div class="img-div"><!-- 모집 광고 포스터가 들어갈 자리 -->
							    <a href="#"><img src="../images/hire1.jpg" style="border-radius: 20px;width: 530px;height: 500px;" title=""/></a>									    
								</div>
								</div>	
							</section>					
						</article>
						<hr />
						<div class="row">
							<!-- 행사 안내와 더불어 다른 내용을 보여주거나 or 다른 박람회를 보여줌 // 지금은 다른 박람회의 정보도 볼 수 있게끔 제작 예정 -->
							<article class="col-4 col-12-mobile special">
								<a href="#" class="image featured"><img src="../images/job.jpg" alt="" /></a>
								<header>
									<h3><a href="#">IT 취업 박람회</a></h3>
								</header>
								<p>
									Amet nullam fringilla nibh nulla convallis tique ante proin sociis accumsan lobortis. Auctor etiam
									porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum.
								</p>
							</article>
							<article class="col-4 col-12-mobile special">
								<a href="#" class="image featured"><img src="../images/job.jpg" alt="" /></a>
								<header>
									<h3><a href="#">금융권 취업 박람회</a></h3>
								</header>
								<p>
									Amet nullam fringilla nibh nulla convallis tique ante proin sociis accumsan lobortis. Auctor etiam
									porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum.
								</p>
							</article>
							<article class="col-4 col-12-mobile special">
								<a href="#" class="image featured"><img src="../images/job.jpg" alt="" /></a>
								<header>
									<h3><a href="#">보건·의료 취업 박람회</a></h3>
								</header>
								<p>
									Amet nullam fringilla nibh nulla convallis tique ante proin sociis accumsan lobortis. Auctor etiam
									porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum.
								</p>
							</article>
						</div>
					</div>

				</div>

			<!-- Footer -->
				<div id="footer">
					<jsp:include page="../inc/footer.jsp" />
				</div>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>