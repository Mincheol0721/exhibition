<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:choose>	
	
	<c:when test="${requestScope.msg == 'deleted'}">		
		<script>
			window.onload = function(){
				location.href = "${path}/view/mypage/iMypage.jsp";
				alert("회원 정보를 삭제했습니다.");
			}
		</script>
	</c:when>	



</c:choose>    
<!DOCTYPE html>
<html>
	<head>
		<title>마이페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		
		<style type="text/css">
			.regdiv > label {width: 20%; text-align: justify;}
			.clause {box-sizing: border-box;}
			.bn632-hover {
			  width: 160px;
			  font-size: 16px;
			  font-weight: 600;
			  color: #fff;
			  cursor: pointer;
			  margin: 20px;
			  height: 55px;
			  text-align:center;
			  border: none;
			  background-size: 300% 100%;
			  border-radius: 50px;
			  moz-transition: all .4s ease-in-out;
			  -o-transition: all .4s ease-in-out;
			  -webkit-transition: all .4s ease-in-out;
			  transition: all .4s ease-in-out;
			}
			
			.bn632-hover:hover {
			  background-position: 100% 0;
			  moz-transition: all .4s ease-in-out;
			  -o-transition: all .4s ease-in-out;
			  -webkit-transition: all .4s ease-in-out;
			  transition: all .4s ease-in-out;
			}
			
			.bn632-hover:focus {
			  outline: none;
			}
			
			.bn632-hover.bn27 {
			  background-image: linear-gradient(
			    to right,
			    #ed6ea0,
			    #ec8c69,
			    #f7186a,
			    #fbb03b
			  );
			  box-shadow: 0 4px 15px 0 rgba(236, 116, 149, 0.75);
			}
		</style>
	</head>
	<body class="no-sidebar is-preload">
		

			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="index.jsp" id="logo">예약 현황</a></h1>
							</header>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<jsp:include page="/inc/menu.jsp" />
						</nav>

				</div>
				
						
					
			<!-- Main -->
				<div class="wrapper style1" style="float: none; margin: 0 auto;">
					
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>행사 정보 번호</b></td>
			<td width="7%"><b>개인연락처</b></td>
			<td width="7%"><b>참가자명</b></td>
			<td width="7%"><b>직업체험명</b></td>
			<td width="7%"><b>체험 신청 날짜</b></td>
			<td width="7%"><b>삭제</b></td>			
		</tr>			
<c:choose>  			  
	 <c:when test="${empty requestScope.membersList}"><%-- request에 바인딩된  ArrayList배열이 없으면?(조회된 정보가 없으면?)  --%>
	 	<tr align="center">
	 		<td colspan="7">
	 			<b>신청한 예약이 없습니다.</b>
	 		</td>
	 	</tr>
	 </c:when>                  
	 <c:when test="${not empty requestScope.membersList}"> <%--request에 바인딩된 ArrayList배열이 있으면?(조회된 정보가 있으면?) --%>
	 	<%-- request에 바인딩된 ArrayList배열을 꺼내오고 MemberVO객체의 갯수만큼 반복해서 얻어 출력 --%>
	 	<c:forEach  var="mem"   items="${requestScope.membersList}"  >
	 		<tr align="center">
	 			<td>${mem.no}</td>
	 			<td>${mem.tel}</td>
	 			<td>${mem.name}</td>
	 			<td>${mem.jobexpname}</td>
	 			<td>${mem.regDate}</td>
	 			<td><a href="${path}/memberInfo/delMember.me?no=${mem.no}">삭제</a></td>	 			
	 		</tr>
	 	</c:forEach>
	 </c:when>
</c:choose>		
	</table>
	<button class="bn632-hover bn27" class="regType" id="backList" type="submit">목록으로</button>	

				</div>

			<!-- Footer -->
				<div id="footer">
					<jsp:include page="/inc/footer.jsp" />
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
			
			<script type="text/javascript">
			$("#backList").on('click',function(){
				location.href = "${path}/view/mypage/iMypage.jsp";
			})	
			</script>
	
	</body>
</html>
