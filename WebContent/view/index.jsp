<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<%-- 회원정보 추가, 회원정보 수정, 회원정보 삭제에 성공하면  request에 바인딩된 msg에 관한 성공메세지를 조건에 따라 결과를 보여주기 위한 코드 --%>    


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>2023 부산 진로·취업 박람회</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	</head>
	<body class="homepage is-preload">
		 <div id="page-wrapper">

			<!-- Header -->
				<div id="header">
					
					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="index.jsp" id="logo">취업 박람회</a></h1>
								<hr />
								<p>우수한 기업들과 만나고 새로운 기회를 발견하세요!</p>
							</header>
							<footer>
								<a href="#banner" class="button circled scrolly">Start</a>
							</footer>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<jsp:include page="../inc/menu.jsp" />
						</nav>

				</div>

			<!-- Banner -->
				<section id="banner">
					<header>
						<h2>2023 하반기 <strong>부산 취업박람회</strong></h2>
						<p>
							더 나은 미래를 향한 발돋움. 부산 취업박람회에서 시작됩니다. 다양한 기업을 만나고 경험을 해보세요.
						</p>
					</header>
				</section>

			<!-- Carousel -->
				<section class="carousel">
					<div class="reel">

						<article>
							<a href="#" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
							<header>
								<!-- 사진 클릭 시 해당 기업의 채용정보로 이동한다면? -->
								<a href="#"><img src="../images/index_microsoft.jpg" style="width: 270px;height: 170px;" alt="" /></a>
								<h3>마이크로소프트</h3>
							</header>
							<p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>
						</article>

						<article>
							<a href="#" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
							<header>
								<a href="#"><img src="../images/index_starbucks.jpg" style="width: 270px;height: 170px;" alt="" /></a>							
								<h3>스타벅스</h3>
							</header>
							<p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>
						</article>

						<article>
							<a href="#" class="image featured"><img src="images/pic03.jpg" alt="" /></a>
							<header>
								<a href="#"><img src="../images/pic01.jpg" style="width: 270px;height: 170px;" alt="" /></a>						
								<h3>A병원</h3>
							</header>
							<p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>
						</article>

						<article>
							<a href="#" class="image featured"><img src="images/pic04.jpg" alt="" /></a>
							<header>
								<a href="#"><img src="../images/index_megacoffee.jpg" style="width: 270px;height: 170px;" alt="" /></a>							
								<h3><a href="#">메가커피</a></h3>
							</header>
							<p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>
						</article>

						<article>
							<a href="#"><img src="../images/pic01.jpg" style="width: 270px;height: 170px;" alt="" /></a>						
							<header>
								<h3><a href="#">B병원</a></h3>
							</header>
							<p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>
						</article>

						<article>
							<a href="#"><img src="../images/pic01.jpg" style="width: 270px;height: 170px;" alt="" /></a>						
							<header>
								<h3><a href="#">기업정보6</a></h3>
							</header>
							<p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>
						</article>

						<article>
							<a href="#"><img src="../images/pic01.jpg" style="width: 270px;height: 170px;" alt="" /></a>						
							<header>
								<h3><a href="#">기업정보7</a></h3>
							</header>
							<p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>
						</article>

						<article>
							<a href="#"><img src="../images/pic01.jpg" style="width: 270px;height: 170px;" alt="" /></a>						
							<header>
								<h3><a href="#">기업정보8</a></h3>
							</header>
							<p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>
						</article>

						<article>
							<a href="#" class="image featured"><img src="images/pic04.jpg" alt="" /></a>
							<header>
								<h3><a href="#">기업정보9</a></h3>
							</header>
							<p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>
						</article>

						<article>
							<a href="#"><img src="../images/pic01.jpg" style="width: 270px;height: 170px;" alt="" /></a>						
							<header>
								<h3><a href="#">기업정보10</a></h3>
							</header>
							<p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>
						</article>

					</div>
				</section>

			<!-- Main -->
				<div class="wrapper style2">

					<article id="main" class="container special">
						<a href="#" class="image featured"><img src="images/pic06.jpg" alt="" /></a>
						<header>
							<h2><a href="#"></a></h2>
						<a href="#" class="image featured"><img src="../images/index_mainPoster.jpg" alt="" /></a>
						<footer>
							<a href="eventInfo.jsp" class="button">상세 보기</a>
						</footer>
					</article>

				</div>

			<!-- Features -->
				<div class="wrapper style1">

					<section id="features" class="container special">
						<header>
							<h3>대한민국을 대표하는 우수 중견기업이 참가하는 이번 박람회는 채용정보를 포함한 다양한 콘텐츠를 온·오프라인으로 제공합니다.<br></h3>
							<p>채용정보와 취업 준비생들에게 실질적으로 도움이 되는 다채로운 프로그램을 마련했습니다.<br>
							      취업을 희망하는 청년 인재 여러분의 많은 관심과 참여 부탁드립니다.</p>
						</header>
						<div class="row">
							<article class="col-4 col-12-mobile special">
								<a href="#" class="image featured"><img src="images/pic05.jpg" alt="" /></a>									
								<header>
									<h3><a href="#">채용 공고</a></h3>
								</header>		
								<!-- 안내 페이지로 이동 링크 수정해야함 -->					
								<a href="#" class="image featured"><img src="../images/index_cMember.jpg" alt="" /></a>															
							</article>
							<article class="col-4 col-12-mobile special">
								<a href="#" class="image featured"><img src="images/pic05.jpg" alt="" /></a>							
								<header>
									<h3><a href="#">취업 특강</a></h3>
								</header>
								<!-- 안내 페이지로 이동 링크 수정해야함 -->
								<a href="#" class="image featured"><img src="../images/index_jobLecture.jpg" alt="" /></a>
							</article>
							<article class="col-4 col-12-mobile special">
								<a href="#" class="image featured"><img src="images/pic05.jpg" alt="" /></a>							
								<header>
									<h3><a href="#">직업 체험 프로그램</a></h3>
								</header>
								<!-- 안내 페이지로 이동 링크 수정해야함 -->
								<a href="#" class="image featured"><img src="../images/index_cjobExp.jpg" alt="" /></a>
							</article>
						</div>
					</section>

				</div>

			<!-- Footer -->
				<div id="footer">
					<jsp:include page="../inc/footer.jsp" />
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