<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE HTML>
	
<html>
	<head>
		<title>취업박람회 이용안내</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>	
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
	</head>		
		<div id="page-wrapper">
			
			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="#" id="logo">부산 취업박람회</a></h1>
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
								<h2><a href="#">이용 안내</a></h2>							
							</header>
							
							<section>
								<header>
									<h3>오시는 길</h3>
								</header>
								<div class="page-table-div">
								<div class="table-div">					
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
										"mapWidth" : "1000",
										"mapHeight" : "500"
									}).render();
								</script>
								
							    </div>	
								</div>	
							</section>
							<!-- 공간 띄움 -->
							<div class="wrapper style1">
								<section>
									<header>
										<h3>주차안내</h3>
									</header>
									<img src="${path}/images/parking.jpg" alt="주차안내" />							
								</section>	
							</div>
							
							<div class="wrapper style1">
								<section>
									<header>
										<h3>부대시설 안내</h3>
									</header>
									<!-- 채워넣을 생각중 -->						
								</section>	
							</div>	
																		
						</article>				
						<hr/>					
					</div>
				</div>

			<!-- Footer -->
			<div id="footer">
				<jsp:include page="/inc/footer.jsp" />
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