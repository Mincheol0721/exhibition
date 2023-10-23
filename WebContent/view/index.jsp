<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>2023 부산 진로·취업 박람회</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			.button {
			  padding: 1.5em 3em;
			  border: none;
			  border-radius: 5px;
			  font-weight: bold;
			  letter-spacing: 5px;
			  text-transform: uppercase;
			  color: #2c9caf;
			  transition: all 1000ms;
			  font-size: 22px;
			  position: relative;
			  overflow: hidden;
			  outline: 2px solid #2c9caf;
			}
			
			button:hover {
			  color: #ffffff;
			  transform: scale(1.1);
			  outline: 2px solid #70bdca;
			  box-shadow: 4px 5px 17px -4px #268391;
			}
			
			button::before {
			  content: "";
			  position: absolute;
			  left: -50px;
			  top: 0;
			  width: 0;
			  height: 100%;
			  background-color: #2c9caf;
			  transform: skewX(45deg);
			  z-index: -1;
			  transition: width 1000ms;
			}
			
			button:hover::before {
			  width: 250%;
			}
		</style>
	</head>
	<body class="homepage is-preload">
		 <div id="page-wrapper">

			<!-- Header -->
				<div id="header">
					
					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="${path}/view/index.jsp" id="logo">취업 박람회</a></h1>
								<hr />
								<p>우수한 기업들과 만나고 새로운 기회를 발견하세요!</p>
								<!-- ${vo.no} : 상세보기 no값 받아오는지 확인용 -->
							</header>
							<footer>
								<a href="#banner" class="button circled scrolly">Start</a>
							</footer>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<jsp:include page="/inc/menu.jsp" />
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
							<header>
							    <a href="#"><img src="${path}/images/index_microsoft.jpg" style="width: 270px; height: 170px;" alt="마이크로소프트" /></a>
							    <h3>마이크로소프트</h3>
							</header>
							<p>'IT·소프트웨어' 분야 집중 구인 중</p>
						</article>

						<article>
							<header>
								<a href="#"><img src="${path}/images/index_starbucks.jpg" style="width: 270px;height: 170px;" alt="" /></a>							
								<h3>스타벅스</h3>
							</header>
							<p>서비스직 구인 중</p>
						</article>

						<article>
							<header>
								<a href="#"><img src="${path}/images/hospital.jpg" style="width: 270px;height: 170px;" alt="" /></a>						
								<h3>A병원</h3>
							</header>
							<p>보건·의료직 구인 중</p>
						</article>

						<article>
							<header>
								<a href="#"><img src="${path}/images/index_megacoffee.jpg" style="width: 270px;height: 170px;" alt="" /></a>							
								<h3><a href="#">메가커피</a></h3>
							</header>
							<p>바리스타 자격증 소시자 우대</p>
						</article>
						<article>
							<header>
								<a href="#"><img src="${path}/images/hospital2.jpg" style="width: 270px;height: 170px;" alt="" /></a>							
								<h3><a href="#">B병원</a></h3>
							</header>
							<p>간호학과 졸업자 우대</p>
						</article>
					</div>				
				</section>
				<article id="main" class="container special">
					<footer>
						<button class="button">
							<a href="${path}/CInfo/getCInfoList.do">상세보기</a>
						</button>
					</footer>
				</article>
				<!-- 공간 띄움 -->
				<section id="banner">
					<br>
				</section>
				
			<!-- Main -->
				<div class="wrapper style2">

					<article id="main" class="container special">
						<header>
							<h2><a href="#"></a></h2>
							<a href="${path}/EventInfo/getEventInfoList.do" class="image featured"><img src="${path}/images/index_mainPoster.jpg" alt="" /></a>
						</header>
						<footer>
						<button class="button">
							<a href="${path}/EventInfo/getEventInfoList.do">상세보기</a>
						</button>
						</footer>
					</article>
 
				</div>

			<!-- Features -->
			
				<div class="wrapper style1">

					<section id="features" class="container special">
						<header>
							<p style="font-size: 25px; font-weight: bold;">
								대한민국을 대표하는 우수 중견기업이 참가하는 이번 박람회는 채용정보를 포함한 다양한 콘텐츠를 온·오프라인으로 제공합니다.
							</p>
							<p style="font-size: 24px;">
								채용정보와 취업 준비생들에게 실질적으로 도움이 되는 다채로운 프로그램을 마련했습니다.<br>
								취업을 희망하는 청년 인재 여러분의 많은 관심과 참여 부탁드립니다.
							</p>
						</header>
						<div class="row">
							<article class="col-4 col-12-mobile special">
								<br>									
								<header>
									<h3><a href="${path}/hireInfo/getList.do">채용 공고</a></h3>
								</header>														
								<a href="${path}/hireInfo/getList.do" class="image featured"><img src="${path}/images/index_cMember.jpg" alt="" /></a>															
							</article>
							<article class="col-4 col-12-mobile special">	
								<br>														
								<header>
									<h3><a href="#">취업 특강</a></h3>
								</header>
								<!-- 안내 페이지로 이동 링크 수정해야함 -->
								<a href="#" class="image featured"><img src="${path}/images/index_jobLecture.jpg" alt="" /></a>
							</article>
							<article class="col-4 col-12-mobile special">
								<br>
								<header>
									<h3><a href="${path}/event/getList.do">부대 행사</a></h3>
								</header>								
								<a href="${path}/event/getList.do" class="image featured"><img src="${path}/images/index_cjobExp.jpg" alt="" /></a>
							</article>
						</div>
					</section>

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