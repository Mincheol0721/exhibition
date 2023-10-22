<%@page import="VO.hireInfoVO.HireInfoVO"%>
<%@page import="DAO.hireInfoDAO.HireInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<%
	String id = (String)session.getAttribute("id");
	int isAdmin = (Integer)session.getAttribute("isAdmin");
	String cno = (String)session.getAttribute("cno");
	String cname = (String)session.getAttribute("cname");
	HireInfoVO vo = null;
	if(cname != null){
		vo = new HireInfoDAO().getHireInfo(cname);
	}
%>

<c:set var="path" value="<%=request.getContextPath()%>" />
<c:set var="id" value="${sessionScope.id}"></c:set>
<c:set var="isAdmin" value="${sessionScope.isAdmin}"></c:set>
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
				
				console.log("menu cname: <%=cname%>");
			});
			
			function reqReg() {
				alert('등록된 정보가 없습니다');
				location.href = '<%=request.getContextPath()%>/hireInfo/regPage.do?cname=<%=cname%>';
			}
			
			function reqView() {
				alert('이미 등록된 정보가 있습니다.');
				location.href = '<%=request.getContextPath()%>/hireInfo/myHireInfo.do?cname=<%=cname%>';
			}
		</script>
	</head>
	<body>
		<ul>
			<li><a href="${path}/Menu/searchIndexNo.do">홈</a></li>
			<li>
				<a href="#">박람회안내</a>
				<ul>
					<li><a href="${path}/EventInfo/getEventInfoList.do">행사안내</a></li>
					<li><a href="${path}/Menu/guide.do">이용안내</a></li>
				</ul>
			</li>
			<li>
				<a href="#">기업채용</a>
				<ul>
					<li>
						<c:choose>
						<c:when test="${cno != null && id == null}">
						<a href="#">채용정보
						<i class="fas fa-angle-right"></i></a>
						<ul>
						<% if(vo == null) { %>
							<li><a href="#" onclick="reqReg();">채용정보 확인</a></li>
							<li><a href="${path}/hireInfo/regPage.do?cname=<%=cname%>">채용정보 등록</a></li>
						<% } else { %>
							<li><a href="${path}/hireInfo/myHireInfo.do?cname=<%=cname%>">채용정보 확인</a></li>
							<li><a href="#" onclick="reqView()">채용정보 등록</a></li>
						<% } %>
						</ul>
						<li><a href="${path}/appForm/getList.do?cname=<%=cname%>">입사지원</a></li>
						</c:when>
						<c:otherwise>
						<a href="${path}/hireInfo/getList.do">채용정보</a>
						<li><a href="#">입사지원</a></li> <!-- 입사지원서 작성 페이지로 포워딩하게 주소 작성 -->
						</c:otherwise>
						</c:choose>
					</li>
					
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
					<li><a href="${path}/cjobExp/cjobExpBoard.do">직업체험</a></li>
					<li><a href="${path}/event/getList.do">부대행사</a></li>
				</ul>
			</li>
			<li>
				<a href="#">회원기능</a>
				
				<ul>
					<c:choose>
					<c:when test="${id == null && cno == null}">
					<li><a href="${path}/view/login/login.jsp" class="membership">로그인</a></li>
					<li><a href="${path}/view/register.jsp" class="membership">회원가입</a></li>
					</c:when>
					</c:choose>
					<c:choose>
					
					<%-- 개인회원일 경우 --%>
					<c:when test="${id != null && cno == null && isAdmin == 0}">
					<li><a href="${path}/logout" class="membership">로그아웃</a></li>
					<li><a href="${path}/view/mypage/iMypage.jsp" class="membership">마이페이지</a></li>
					</c:when>
					
					<%-- 관리자일 경우 --%>
					<c:when test="${id != null && isAdmin == 1}">
					<li><a href="${path}/logout" class="membership">로그아웃</a></li>
					<li><a href="${path}/admin/admin.do" class="membership">마이페이지</a></li>
					</c:when>
					
					<%-- 기업회원일 경우  --%>
					<c:when test="${cno != null && id == null}">
					<li><a href="${path}/logout" class="membership">로그아웃</a></li>
					<li><a href="${path}/view/mypage/cMypage.jsp" class="membership">마이페이지</a></li>
					</c:when>
					
					</c:choose>
		
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