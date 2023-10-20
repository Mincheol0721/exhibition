<%@page import="VO.applicantVO.ApplicantVO"%>
<%@page import="DAO.applicantDAO.ApplicantDAO"%>
<%@page import="VO.pgsVO.PgsVO"%>
<%@page import="DAO.pgsDAO.PgsDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<% 
	request.setCharacterEncoding("UTF-8"); 
	
	ApplicantDAO dao = new ApplicantDAO();
	ApplicantVO vo = null;
	List<ApplicantVO> list = null;
	
	//전체 글 수
	int count = dao.getMCount();
	System.out.println("count: " + count);
	
	//하나의 화면에 띄워줄 글 개수 10
	int pageSize = 10;
	
	//현재 보여질 페이지번호 가져오기
	String pageNum = request.getParameter("pageNum");
	
	//현재 보여질 페이지 번호가 없으면 1페이지 처리
	if(pageNum == null) {
		pageNum = "1";
	}
//	System.out.println("pageNum: " + pageNum);
	
	//현재 보여질 페이지 번호 "1"을 기본정수 1로 변환
	int currentPage = Integer.parseInt(pageNum);
//	System.out.println("currentPage: " + currentPage);
	
	//각 페이지마다 맨 위에 보여질 시작 글번호 구하기
	//(현재 보여질 페이지 번호 - 1) * 한페이지당 보여줄 글 개수
	int startRow = (currentPage - 1) * pageSize;
//	System.out.println("startRow: " + startRow);
	
	
	//날짜 포맷
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<title>신청자 관리 - 개인</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				
			});
		</script>
		<style type="text/css">
			.layout {
				width: 100%;
				display: grid;
				grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
				gap: 8px;
			}
			.pgTr:hover {
				cursor: pointer;
			}
			.flexbox {
				display: flex;
				justify-content: flex-end;
				align-items: flex-start;
			}
			.flexbox [type=button] {
				margin-bottom: 30px;
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
							<h2>신청자 관리</h2>
							<div>
							<jsp:include page="/inc/pgsBtn.jsp" />
							</div>
							<!-- 회원구분버튼 영역 -->
								<jsp:include page="/inc/selectMember.jsp" />
							<!-- 회원구분버튼 영역 -->
							<section class="layout">
	                        	<table class="table table-striped" style="font-size: 14px; vertical-align: middle; text-align: center;">
									<tr style="font-weight: 700;">
										<th>신청자명</th>
									  	<th>신청자 연락처</th>
									  	<th>신청일</th>
									  	<th>신청시간</th>
									  	<th>수정</th>
									  	<th>삭제</th>
									</tr>
								<c:forEach var="vo" items="${meetings}">
									<tr>
										<td>${vo.name}</td>
										<td>${vo.sctel}</td>
										<td>${ fn:substring(vo.regDate, 0, 10) }</td> 
										<td>${vo.ampm}&nbsp;&nbsp;${vo.startTime}&nbsp;&nbsp;~&nbsp;&nbsp;${vo.endTime}</td>
										<td><button type="button" onclick="location.href='<%=request.getContextPath()%>/applicant/modMeeting.do?no=${vo.no}'">수정</button></td>
										<td><button type="button" onclick="location.href='<%=request.getContextPath()%>/applicant/delMeeting.do?no=${vo.no}'">삭제</button></td>
									</tr>
								</c:forEach>
								</table>
							</section>
							<div class="flexbox">
								<input type="button" value="등록하기" onclick="goReg();">
							</div>
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-12">
									<nav>
										<ul class="pagination justify-content-end">
			<%
								    	//전체 페이지 수 구하기
										//전체 페이지 수 = 전체 글 / 한페이지에 보여줄 글 수 + (전체 글 수를 한페이지에 보여줄 글수로 나눈 나머지 값)
										int pageCount = count / pageSize + (count%pageSize == 0 ? 0:1);
										//한 화면에 보여줄 페이지 수 설정
										int pageBlock = 5;
										
										//시작페이지 번호 구하기
										//( 현재 보여질 페이지 번호 / 한 블럭에 보여줄 페이지 수 ) - ( 현재 보여질 페이지 번호 % 한 화면에 보여줄 페이지수 == 0 ? 1:0 )
										// * 한 블럭에 보여줄 페이지 수 + 1
										int startPage = ( (currentPage / pageBlock) - (currentPage % pageBlock == 0 ? 1 : 0) ) * pageBlock + 1;
										
										//끝페이지 번호 구하기
										int endPage = startPage + pageBlock - 1;
										//끝 페이지 번호가 전체 페이지수보다 클 때
										if(endPage > pageCount) {
											endPage = pageCount;
										}
										/* 
										System.out.println("startPage: " + startPage);
										System.out.println("pageBlock: " + pageBlock);
										System.out.println("pageCount: " + pageCount);
										System.out.println("endPage: " + endPage);
										 */
										//[이전] 시작 페이지 번호가 한 화면에 보여줄 페이지수보다 클 때
										if(startPage > pageBlock) {
			%>
											<li class="page-item">
								    			<a href="${path}/applicat/getIList.do?pageNum=<%=startPage - pageBlock%>" class="page-link">‹</a>
								    		</li>
			<%
										}
										
										for(int i = startPage; i <= endPage; i++) {
											if(i == currentPage) {
			%>											
								    			<li class="page-item active"><a href="${path}/applicant/getIList.do?pageNum=<%=currentPage%>" class="page-link"><%=currentPage %></a></li>
			<%
											} else {
			%>	
								    			<li class="page-item "><a href="${path}/applicant/getIList.do?pageNum=<%=i%>" class="page-link"><%=i %></a></li>
			<%	
											}
										
										}
										//[다음] 끝페이지 번호가 전체 페이지수 보다 작을 때
										if(endPage < pageCount) {
			%>													
											<li class="page-item">
								    			<a href="${path}/applicant/getIList.do?pageNum=<%=startPage + pageBlock%>" class="page-link">›</a>
								    		</li>
			<%													
										}
										
			%>
								    	</ul>
									</nav>
								</div>
							</div>
						</div>
						</header>
						</article>
					</div>
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