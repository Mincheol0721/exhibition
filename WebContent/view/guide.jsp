<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE HTML>

<html>
	<head>
		<title>박람회 이용 안내</title>
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
								<h1><a href="index.html" id="logo">Helios</a></h1>
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
								<h2><a href="#">이용 안내</a></h2>
								<p>
									오시는 길
								</p>
							</header>							
							<!-- * 카카오맵 - 벡스코 지도퍼가기 -->
							<!-- 1. 지도 노드 -->
							<div id="daumRoughmapContainer1697532655607" class="root_daum_roughmap root_daum_roughmap_landing"></div>
							
							<!--
								2. 설치 스크립트
								* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
							-->
							<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
							
							<!-- 3. 실행 스크립트 -->
							<script charset="UTF-8">
								new daum.roughmap.Lander({
									"timestamp" : "1697532655607",
									"key" : "2ghcb",
									"mapWidth" : "640",
									"mapHeight" : "360"
								}).render();
							</script>
							
							<section>
								<header>
									<h3>Ultrices tempor sagittis nisl</h3>
								</header>
								<p>
									Nascetur volutpat nibh ullamcorper vivamus at purus. Cursus ultrices porttitor sollicitudin imperdiet
									at pretium tellus in euismod a integer sodales neque. Nibh quis dui quis mattis eget imperdiet venenatis
									feugiat. Neque primis ligula cum erat aenean tristique luctus risus ipsum praesent iaculis. Fermentum elit
									fringilla consequat dis arcu. Pellentesque mus tempor vitae pretium sodales porttitor lacus. Phasellus
									egestas odio nisl duis sociis purus faucibus morbi. Eget massa mus etiam sociis pharetra magna.
								</p>
								<p>
									Eleifend auctor turpis magnis sed porta nisl pretium. Aenean suspendisse nulla eget sed etiam parturient
									orci cursus nibh. Quisque eu nec neque felis laoreet diam morbi egestas. Dignissim cras rutrum consectetur
									ut penatibus fermentum nibh erat malesuada varius.
								</p>
							</section>
							<section>
								<header>
									<h3>Augue euismod feugiat tempus</h3>
								</header>
								<p>
									Pretium tellus in euismod a integer sodales neque. Nibh quis dui quis mattis eget imperdiet venenatis
									feugiat. Neque primis ligula cum erat aenean tristique luctus risus ipsum praesent iaculis. Fermentum elit
									ut nunc urna volutpat donec cubilia commodo risus morbi. Lobortis vestibulum velit malesuada ante
									egestas odio nisl duis sociis purus faucibus morbi. Eget massa mus etiam sociis pharetra magna.
								</p>
							</section>
						</article>
						<hr />						
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