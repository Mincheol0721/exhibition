<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE HTML>
	
<html>
	<head>
		<title>취업박람회 행사안내</title>
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
								<h1><a href="#" id="logo">부산 취업박람회 소개</a></h1>
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
									"부산 취업박람회"
								</p>
							</header>
							<p style="text-align:center">
								대한민국의 미래 도약을 위해 일자리 기회를 제공하고 기업 구인난 해소를 지원하고자 2023년 하반기 부산 취업박람회를 개최합니다.<br>
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
							            <td class="page-tdb page-bgcolor1">부산 취업박람회</td>
							        </tr>
							        <tr>
							            <th class="page-tda" style="text-align:center; padding:0px;">일시</th>
							            <td class="page-tdb">2023. 10. 25 ~ 2023. 11. 02</td>
							        </tr>
							        <tr>
							            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">장소</th>
							            <td class="page-tdb page-bgcolor1">벡스코 1층 다목적홀</td>
							        </tr>
							        <tr>
							            <th class="page-tda" style="text-align:center; padding:0px;">참여대상</th>
							            <td class="page-tdb">구인 · 구직을 희망하는 기업 및 구직자</td>
							        </tr>
							        <tr>
							            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">참여방법</th>
							            <td class="page-tdb page-bgcolor1">사전등록 ~ 23. 10. 24 까지, 현장접수 및 단체접수 가능</td>
							        </tr>
							        <tr>
							            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">행사내용</th>
							            <td class="page-tdb page-bgcolor1">구인 구직자 취업 컨설팅 및 부대 내 행사(이력서 사진 촬영, 스트레스 코칭)</td>
							        </tr>
							        <tr>
							            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">참여기업</th>
							            <td class="page-tdb page-bgcolor1">50여개업체 (직 · 간접 참여가능)</td>
							        </tr>
							    </table>
							    </div>	
							    <div class="img-div">
							    	<!-- 제작한 모집 광고 포스터가 들어가는 자리 -->
							    	<img src="../images/eventInfo_poster.jpg" style="width: 430px;height: 580px;" title="" id="pdfImage"/><br>	
							    	(포스터 클릭 시 PDF파일을 요청, 인쇄 가능.)							    
								</div>
								</div>	
							</section>												
						</article>				
						<hr />
						<div class="row">
							<!-- 다른 박람회 안내 -->
							<article class="col-4 col-12-mobile special">
								<header>
									<a href="#">"2023 청년 디지털 일자리 채용박람회"</a>									
								</header>
								<a href="#" class="image featured"><img src="../images/Digital_poster.jpg" alt="" /></a>
							</article>
							<article class="col-4 col-12-mobile special">
								<header>
									<a href="#">"2023 예일패션몰 퍼포먼스 마케터 채용박람회"</a>
								</header>
								<a href="#" class="image featured"><img src="../images/Yeill_poster.jpg" alt="" /></a>
							</article>
							<article class="col-4 col-12-mobile special">
								<header>
									<a href="#">"2024 대학입시 정보박람회"</a>
								</header>
								<a href="#" class="image featured"><img src="../images/Uni_poster.jpg" alt="" /></a>
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
			
			<script>
	        // 이미지를 클릭할 때 PDF를 열도록 클릭 이벤트를 추가
	        document.getElementById('pdfImage').addEventListener('click', function () {
            // PDF 파일 경로
            var pdfUrl = '../pdf/Exhibition.pdf';

            // PDF를 새 창에서 열도록 윈도우 팝업을 생성
            window.open(pdfUrl, '_blank');
        });
    </script>

	</body>
</html>