<%@page import="controller.appFormController.AppFormController"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="VO.appFormVO.AppFormVO"%>
<%@page import="DAO.appFormDAO.AppFormDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	request.setCharacterEncoding("UTF-8"); 
	
	AppFormDAO dao = new AppFormDAO();
	AppFormVO vo = new AppFormVO();
	List<AppFormVO> list = null; 
	String id = (String)session.getAttribute("id");
	if(id == null || id.length() == 0) id = " ";
// 	System.out.println("id: " + id);
	int isAdmin = 0;
	if (session.getAttribute("isAdmin") != null) {
		isAdmin = (Integer)session.getAttribute("isAdmin");
	} 
// 	System.out.println("isAdmin: " + isAdmin);
	String cno = (String)session.getAttribute("cno");
// 	if(cno == null || cno.length() == 0) cno = "";
// 	System.out.println("cno: " + cno);
	
	String cname = (String)session.getAttribute("cname");
	
	//전체 글 개수
	int count = dao.getAppFormCount(cname); 
	System.out.println("count: " + count);
	//하나의 화면에 띄워줄 글 개수 10
	int pageSize = 5;
	
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
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<title>입사지원서</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				
				
			});
		</script>
		<style type="text/css">
			.layout {
			  width: 100%;
			  margin: 20px auto;
			  display: flex;
			  flex-wrap: wrap;
			  gap: 8px;
			}
			.card {
			  width: 350px;
			  height: 250px;
			  background-image: linear-gradient(-45deg, #f89b29 0%, #ff0f7b 100% );
			  border-radius: 10px;
			  display: flex;
			  padding: 10px 30px;
			  flex-direction: column;
			  flex-grow: 3;
			  gap: 10px;
			  align-items: center;
			  justify-content: center;
			  overflow: hidden;
			  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
			}
			
			.heading {
			  font-size: 24px;
			  font-weight: 700;
			  color: #ffffff;
			}
			
			.para {
			  text-align: center;
			  color: #ffffff;
			  opacity: 0.7;
			  line-height: 1.4;
			}
			
			.overlay {
			  position: absolute;
			  top: 0;
			  left: 0;
			  width: 100%;
			  height: 100%;
			  opacity: 0;
			  background-color: rgba(0, 0, 0, 0.6);
			  transition: opacity 0.3s ease;
			  pointer-events: none;
			}
			
			.card:hover .overlay {
			  opacity: 1;
			  pointer-events: auto;
			}
			
			.card .card-btn {
			  position: absolute;
			  top: 50%;
			  left: 50%;
			  font-weight: 600;
			  padding: 10px 20px;
			  font-size: 16px;
			  transform: translate(-50%, -50%);
			  background-color: #ffffff;
			  border-radius: 50px;
			  display: flex;
			  align-items: center;
			  justify-content: center;
			  cursor: pointer;
			  z-index: 999;
			  border: none;
			  opacity: 0;
			  scale: 0;
			  transform-origin: 0 0;
			  box-shadow: 0 0 10px 10px rgba(0, 0, 0, 0.15);
			  transition: all 0.6s cubic-bezier(0.23, 1, 0.320, 1);
			}
			
			.card:hover .card-btn {
			  opacity: 1;
			  scale: 1;
			}
			
			.card .card-btn:hover {
			  box-shadow: 0 0 0px 5px rgba(0, 0, 0, 0.3);
			}
			
			.card .card-btn:active {
			  scale: 0.95;
			}
			
			.overlay::after {
			  content: "";
			  position: absolute;
			  top: 50%;
			  left: 50%;
			  transform: translate(-50%, -50%) scale(0);
			  width: 100%;
			  height: 100%;
			  background-image: linear-gradient(-45deg, #f89b2980 0%, #ff0f7b80 100% );
			  transition: transform 0.5s ease;
			}
			
			.card:hover .overlay::after {
			  transform: translate(-50%, -50%) scale(2);
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
								<h2>입사지원서</h2>
								<div class="layout">
	 								<c:forEach var="vo" items="${list}">
										<div class="card">
											<p class="heading">${vo.name}</p>
											<p class="para">${vo.addr}</p>
											<div class="overlay"></div>
											<button class="card-btn" onclick="location.href='${path}/view/viewAppFormList'">Click</button>
										</div>
									</c:forEach>
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
								    			<a href="${path}/view/appForm/appFormList.jsp?pageNum=<%=startPage - pageBlock%>" class="page-link">‹</a>
								    		</li>
			<%
										}
										
										for(int i = startPage; i <= endPage; i++) {
											if(i == currentPage) {
			%>											
								    			<li class="page-item active"><a href="${path}/view/appForm/appFormList.jsp?pageNum=<%=currentPage%>" class="page-link"><%=currentPage %></a></li>
			<%
											} else {
			%>	
								    			<li class="page-item"><a href="${path}/view/appForm/appFormList.jsp?pageNum=<%=i%>" class="page-link"><%=i %></a></li>
			<%	
											}
										
										}
										//[다음] 끝페이지 번호가 전체 페이지수 보다 작을 때
										if(endPage < pageCount) {
			%>													
											<li class="page-item">
								    			<a href="${path}/view/appForm/appFormList.jsp?pageNum=<%=startPage + pageBlock%>" class="page-link">›</a>
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

	</body>
</html>