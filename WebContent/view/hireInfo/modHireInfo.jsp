<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DAO.hireInfoDAO.HireInfoDAO"%>
<%@page import="VO.hireInfoVO.HireInfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	request.setCharacterEncoding("UTF-8"); 
	//id값(cname or cno) 받아오기
	String cname = request.getParameter("cname");
	
	HireInfoVO vo = null;
	HireInfoDAO dao = new HireInfoDAO();
	
	vo = dao.getHireInfo(cname);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
%>
<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<!DOCTYPE html>
<html>
	<head>
		<title>채용정보 수정</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				var cname = '<%=vo.getCname()%>';
				
<%-- 				console.log('apptype: ', '<%=vo.getAppType()%>'); --%>
				
				if(cname != 'null' || cname != '') {
					$('#divComp').val('<%=vo.getDivComp()%>').prop("selected",true);
					$('#jobtype').val('<%=vo.getJobtype()%>').prop("selected",true);
					$('#workTime').val('<%=vo.getWorkTime()%>').prop("selected",true);
					$('#legal').val('<%=vo.getLegal()%>').prop("selected",true);
					$('#appType').val('<%=vo.getAppType()%>').prop("selected",true);
				}
				
			});
		</script>
		<style type="text/css">
			input[type="date"] {
				display: inline-block;
				border: 0;
				background: #fafafa;
				width: 28%;
				border-radius: 0.5em;
				border: solid 1px #E5E5E5;
				padding: 1em;
			}
		</style>
	</head>
	<body class="no-sidebar is-preload">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="${path}/view/index.jsp" id="logo">부산 취업 박람회</a></h1>
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
								<h2>채용정보 수정</h2>
								<hr>
								<form action="${path}/hireInfo/mod.do" method="post">
									<table border="none">
										<tr>
											<th>기업명</th>
											<td><input type="text" name="cname" value="<%=vo.getCname()%>"></td>
										</tr>
										<tr>
											<th>전화번호</th>
											<td><input type="tel" name="htel" value="<%=vo.getHtel()%>"></td>
										</tr>
										<tr>
											<th>사업체구분</th>
											<td>
												<select id="divComp" name="divComp">
													<option value="">사업체선택</option>
													<option value="일반기업">일반기업</option>
													<option value="공공기관">공공기관</option>
													<option value="사회적기업">사회적기업</option>
													<option value="기타">기타</option>
												</select>
											</td>
										</tr>
										<tr>
											<th>홈페이지링크</th>
											<td><input type="text" name="homepage" value="<%=vo.getHomepage()%>"></td>
										</tr>
										<tr>
											<th>모집직종</th>
											<td>
												<select id="jobtype" name="jobtype">
		                                        	<option value="">직종선택</option>
		                                        	<option value="경영·행정·사무직">경영·행정·사무직</option>
		                                        	<option value="IT·소프트웨어">IT·소프트웨어</option>
		                                        	<option value="교육·법률">교육·법률</option>
		                                        	<option value="보건·의료직">보건·의료직</option>
		                                        	<option value="예술·디자인·방송직">예술·디자인·방송직</option>
		                                        	<option value="여행·숙박">여행·숙박</option>
		                                        	<option value="영업·판매직">영업·판매직</option>
		                                        	<option value="운전·운송직">운전·운송직</option>
		                                        	<option value="생산·단순제조직">생산·단순제조직</option>
		                                        	<option value="문화·예술">문화·예술</option>
		                                        	<option value="서비스직">서비스직</option>
		                                        </select>
											</td>
										</tr>
										<tr>
											<th>근무시간</th>
											<td>
												<select id="workTime" name="workTime">
													<option value="">시간선택</option>
													<option value="전일제">전일제</option>
													<option value="반일제">반일제</option>
													<option value="교대근무">교대근무</option>
													<option value="시간협의">시간협의</option>
												</select>
											</td>
										</tr>
										<tr>
											<th>근무지역</th>
											<td>
												<select id="legal" name="legal">
													<option value="">지역선택</option>
													<option value="부산전체">부산전체</option>
													<option value="중구">중구</option>
													<option value="서구">서구</option>
													<option value="동구">동구</option>
													<option value="영도구">영도구</option>
													<option value="부산진구">부산진구</option>
													<option value="동래구">동래구</option>
													<option value="남구">남구</option>
													<option value="북구">북구</option>
													<option value="해운대구">해운대구</option>
													<option value="사하구">사하구</option>
													<option value="금정구">금정구</option>
													<option value="강서구">강서구</option>
													<option value="연제구">연제구</option>
													<option value="수영구">수영구</option>
													<option value="사상구">사상구</option>
													<option value="기장군">기장군</option>
													<option value="기타">기타</option>
												</select>
											</td>
										</tr>
										<tr>
											<th>모집전형</th>
											<td>
												<select name="appType" id="appType">
													<option value="">전형선택</option>
													<option value="서류">서류</option>
													<option value="면접">면접</option>
												</select>
											</td>
										</tr>
										<tr>
											<th>모집기간</th>
											<td style="justify-content: space-between; text-align: center;">
												<input type="date" value="<%=vo.getAppstart().substring(0, 10)%>" name="appstart" id="appstart">
											 	&nbsp;&nbsp;~&nbsp;&nbsp;
												<input type="date" value="<%=vo.getAppexpire().substring(0, 10)%>" name="appexpire" id="appexpire">
											</td>
										</tr>
									</table>
									<input type="submit" value="수정완료">
									<input type="reset" value="다시작성">
								</form>
							</header>
					</div>

				</div>

			<!-- Footer -->
			<div id="footer">
				<jsp:include page="/inc/footer.jsp" />
			</div>
		</div>

	</body>
</html>