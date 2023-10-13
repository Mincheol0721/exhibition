<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				var arrow = $('.arrow');
				
				arrow.on('mouseover', function() {
					$(this).children().removeClass("fa-angle-right");
					$(this).children().addClass("fa-angle-down");
				});
				
				arrow.on('mouseout', function() {
					$(this).children().removeClass("fa-angle-down");
					$(this).children().addClass("fa-angle-right");
				});
			});
		</script>
	</head>
	<body>
		<ul>
			<li><a href="${path}/view/index.jsp">홈</a></li>
			<li>
				<a href="#">박람회안내</a>
				<ul>
					<li><a href="#">행사안내</a></li>
					<li><a href="#">이용안내</a></li>
				</ul>
			</li>
			<li>
				<a href="#">기업채용</a>
				<ul>
					<li>
						<a href="#">채용정보
						<i class="fas fa-angle-right"></i></a>
						<ul>
							<li><a href="${path}/view/hireInfoList.jsp">채용정보 확인</a></li>
							<li><a href="${path}/view/hireInfoReg.jsp">채용정보 등록</a></li>
						</ul>
					</li>
					<li><a href="#">입사지원</a></li>
				</ul>
			</li>
			<li>
				<a href="#">진로설계</a>
				<ul>
					<li><a href="#">진로상담</a></li>
					<li>
						<a href="#" class="arrow">
						컨설팅
						<i class="fas fa-angle-right"></i>
						</a>
						<ul>
							<li><a href="#">모의면접</a></li>
							<li><a href="#">자기소개서 컨설팅</a></li>
						</ul>
					</li>
				<li><a href="#">취업특강</a></li>
				</ul>
			</li>
			<li>
				<a href="#">직업체험</a>
				<ul>
					<li><a href="#">직업체험</a></li>
					<li><a href="#">부대행사</a></li>
				</ul>
			</li>
			<li>
				<a href="#">회원기능</a>
				<ul>
					<li><a href="login.jsp" class="membership">로그인</a></li>
					<li><a href="register.jsp" class="membership">회원가입</a></li>
				</ul>
			</li>
		</ul>
		
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