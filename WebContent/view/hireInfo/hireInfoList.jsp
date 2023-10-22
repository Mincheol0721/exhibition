<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="VO.hireInfoVO.HireInfoVO"%>
<%@page import="DAO.hireInfoDAO.HireInfoDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<% 
	request.setCharacterEncoding("UTF-8"); 
	
	HireInfoDAO dao = new HireInfoDAO();
	HireInfoVO vo = new HireInfoVO();
	List<HireInfoVO> list = null; 
	String cname = (String)session.getAttribute("cname");
	
	//전체 글 개수
	int count = dao.getHireInfoCount();
//	System.out.println("count: " + count);
	//하나의 화면에 띄워줄 글 개수 10
	int pageSize = 9;
	
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
		<title>채용정보 조회</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				
			});
			
			function view(cname, expireDate) {
				if(expireDate <= 0) {
					alert('접수가 끝난 정보입니다. \r\n조회만 됩니다.');
				}
				location.href='<%=request.getContextPath()%>/hireInfo/viewHireInfo.do?cname=' + cname + '&expireDate=' + expireDate;
			}
		</script>
		<style type="text/css">
			.layout {
			  width: 100%;
			  display: grid;
			  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
			  gap: 8px;
			}
			.card {
			  position: relative;
			  margin: 0 auto;
			  width: 300px;
			  height: 300px;
			  background-color: #f2f2f2;
			  border-radius: 10px;
			  display: flex;
			  align-items: center;
			  justify-content: center;
			  overflow: hidden;
			  perspective: 1000px;
			  box-shadow: 0 0 0 5px #ffffff80;
			  transition: all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
			}
			
			.card svg {
			  width: 48px;
			  fill: #333;
			  transition: all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
			}
			
			.card:hover {
			  transform: scale(1.05);
			  box-shadow: 0 8px 16px rgba(255, 255, 255, 0.2);
			  cursor: pointer;
			}
			
			.card__content {
			  position: absolute;
			  top: 0;
			  left: 0;
			  width: 100%;
			  height: 100%;
			  padding: 10px;
			  box-sizing: border-box;
			  background-color: #f2f2f2;
			  transform: rotateX(-90deg);
			  transform-origin: bottom;
			  transition: all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
			}
			
			.card__content li {
			  text-align: left;
			}
			
			.card:hover .card__content {
			  transform: rotateX(0deg);
			}
			
			.card__title {
			  margin: 0;
			  font-size: 20px;
			  color: #333;
			  font-weight: 700;
			}
			
			.card:hover svg {
			  scale: 0;
			}
			
			.card__description {
			  margin: 10px 0 0;
			  font-size: 14px;
			  color: #777;
			  line-height: 1.2;
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
								<h2>채용정보 조회</h2>
								<section class="layout">
									<c:forEach var="vo" items="${list}">
									<div class="card" onclick="view('${vo.cname}', '${vo.expireDate}')">
										<img alt="회사 로고" src="${path}/upload/${vo.fileName}" style="width: 300px;">
										<div class="card__content">
											<p class="card__title">${vo.cname}</p>
											<p class="card__description">
												<ul>
													<li>사업체구분: ${vo.divComp} </li>
													<li>모집직종: ${vo.jobtype} </li>
													<li>근무시간: ${vo.workTime} </li>
													<li>근무지역: ${vo.legal} </li>
													<li>전화번호: ${vo.htel} </li>
											<c:choose>
												<c:when test="${vo.expireDate > 0}">
													<li>D-Day: ${vo.expireDate}일</li>
												</c:when>
												<c:when test="${vo.expireDate <= 0}">
													<li>D-Day: 마감</li>
												</c:when>
											</c:choose>
												</ul>
											</p>
										</div>
									</div>
									</c:forEach>
								</section>
							
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
								    			<a href="${path}/hireInfo/getList.do?pageNum=<%=startPage - pageBlock%>" class="page-link">‹</a>
								    		</li>
			<%
										}
										
										for(int i = startPage; i <= endPage; i++) {
											if(i == currentPage) {
			%>											
								    			<li class="page-item active"><a href="${path}/hireInfo/getList.do?pageNum=<%=currentPage%>" class="page-link"><%=currentPage %></a></li>
			<%
											} else {
			%>	
								    			<li class="page-item "><a href="${path}/hireInfo/getList.do?pageNum=<%=i%>" class="page-link"><%=i %></a></li>
			<%	
											}
										
										}
										//[다음] 끝페이지 번호가 전체 페이지수 보다 작을 때
										if(endPage < pageCount) {
			%>													
											<li class="page-item">
								    			<a href="${path}/hireInfo/getList.do?pageNum=<%=startPage + pageBlock%>" class="page-link">›</a>
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