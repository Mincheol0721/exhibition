<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE HTML>
	
<html>
	<head>
		<title>취업박람회 행사안내</title>
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
								<h1><a href="#" id="logo">부산 취업박람회 소개</a></h1>
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
							<h2><a href="#">행사 안내</a></h2>							
							<p>
								"${eventInfo.name}"
							</p>
						</header>
						<p style="text-align:center">		          
						        적성과 적합한 직업 탐색과 진로 설계의 기회를 제공하며, 좋은 일자리를 꿈꾸는 많은 청년들을 위해 마련된 행사입니다.<br>						  
						</p>
						<section>
							<header>
								<h3>행사 개요</h3>
							</header>
							<div class="page-table-div">
								<div class="table-div">								
									<table class="page-table" cellspacing="0" cellpadding="0">	
										<c:if test="${not empty eventInfo}">															
									        <tr>
									            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">행사명</th>
									            <td class="page-tdb page-bgcolor1" >${eventInfo.name}</td>
									        </tr>
									        <tr>
									            <th class="page-tda" style="text-align:center; padding:0px;">일시</th>
									            <td class="page-tdb">
									            	<!-- 연도, 월, 일만 보이게끔 수정했음 -->
									            	<c:out value="${fn:substring(eventInfo.startDate, 0, 10)}"/> ~ 
									            	<c:out value="${fn:substring(eventInfo.endDate, 0, 10)}" />
									            </td>
									        </tr>
									        <tr>
									            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">장소</th>
									            <td class="page-tdb page-bgcolor1">${eventInfo.locate}</td>
									        </tr>
									        <tr>
									            <th class="page-tda" style="text-align:center; padding:0px;">참여대상</th>
									            <td class="page-tdb">${eventInfo.iPart}</td>
									        </tr>
									        <tr>
									            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">참여방법</th>
									            <td class="page-tdb page-bgcolor1">${eventInfo.way}</td>
									        </tr>
									        <tr>
									            <th class="page-tda" style="text-align:center; padding:0px;">행사내용</th>
									            <td class="page-tdb">${eventInfo.content}</td>
									        </tr>
									        <tr>
									            <th class="page-tda page-bgcolor1" style="text-align:center; padding:0px;">참여기업</th>
									            <td class="page-tdb page-bgcolor1">${eventInfo.cPart}</td>
									        </tr>
								        </c:if>
								    </table>
							    </div>	
							    <div class="img-div">
							    	<!-- 제작한 모집 광고 포스터가 들어가는 자리 -->
							    	<img src="${path}/images/${eventInfo.fileName}" style="width: 430px;height: 580px;" title="" onclick="window.open(this.src)"/><br>								    						    
									(포스터 클릭 시 크게 볼 수 있습니다.)
								</div>																					
							</div>
						</section>												
					</article>	
					<!-- 뒤로가기 버튼 추가 -->
    				<button onclick="history.back()" style="display: block; margin: 0 auto; font-weight:bold; font-size: 18px; padding: 10px 20px;">뒤로 가기</button>				
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