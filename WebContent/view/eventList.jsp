<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="VO.eventVO.EventVO"%>
<%@page import="DAO.eventDAO.EventDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	request.setCharacterEncoding("UTF-8"); 
	
	EventDAO dao = new EventDAO();
	EventVO vo = new EventVO();
	List<EventVO> list = null; 
	
	//전체 글 개수
	int count = dao.getEventCount(); 
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
		<title>부대행사</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$.ajax({
					url: '<%=request.getContextPath()%>/event/getList.do',
					data: {pageNum:<%=pageNum%>, pageSize:<%=pageSize%>},
					async: false,
					type: 'POST',
					dataType: 'json',
					success: function(data) {
						$.each(data, function(index, vo) {
							$('.layout').append('<div class="myCard" onclick="location.href=\'${path}/view/viewEvent.jsp?no=' + vo.no + '\'">' 
													+ '<div class="innerCard">'
														+ '<div class="frontSide"> '
															+ '<p class="title"> ' + vo.title + ' </p>'
															+ '<p>' + vo.content + '</p>'
														+ '</div>'
														+ '<div class="backSide"> '
															+ '<p><ul>'
																+ '<li>대상: ' + vo.ipart + '</li>'
																+ '<li>소요시간: ' + vo.reqTime + '</li>'
																+ '<li>이용시간: ' + vo.startTime + ' ~ ' + vo.endTime + '</li>'
																+ '<li>제공서비스: ' + vo.service + '</li>'
																+ '<li>장소: ' + vo.locate + '</li>'
																+ '<button type="button" style="background-color: #caf0f8; color: #0077b6;" onclick="location.href=\'${path}/view/modEvent.jsp?no=' + vo.no + '\'">'
																+ '수정하기'
																+ '</button> &nbsp;&nbsp;&nbsp;'
																+ '<button type="button" style="background-color: #caf0f8; color: #0077b6;" onclick="location.href=\'${path}/event/delEvent.do?no=' + vo.no + '\'">'
																+ '삭제하기'
																+ '</button>'
															+ '</ul></p>'
														+ '</div>'
													+ '</div>'
												+ '</div>');
						})
					}
				});//ajax
				
			});
		</script>
		<style type="text/css">
			.layout {
			  width: 100%;
			
			  display: grid;
			  grid-template-columns: repeat(auto-fit, minmax(720px, 1fr));
			  gap: 8px;
			}
			.myCard {
			  background-color: transparent;
			  max-width: 720px;
			  width: 70%;
			  height: 320px;
			  margin: 10px auto;
			  perspective: 1000px;
			}
			
			.title {
			  font-size: 1.5em;
			  font-weight: 900;
			  text-align: center;
			  margin: 0;
			}
			
			.innerCard {
			  position: relative;
			  width: 100%;
			  height: 100%;
			  text-align: center;
			  transition: transform 0.8s;
			  transform-style: preserve-3d;
			  cursor: pointer;
			}
			
			.myCard:hover .innerCard {
			  transform: rotateY(180deg);
			}
			
			.frontSide,
			.backSide {
			  position: absolute;
			  display: flex;
			  flex-direction: column;
			  align-items: center;
			  justify-content: space-evenly;
			  width: 100%;
			  height: 100%;
			  -webkit-backface-visibility: hidden;
			  backface-visibility: hidden;
			  border: 1px solid rgba(255, 255, 255, 0.8);
			  border-radius: 1rem;
			  color: white;
			  box-shadow: 0 0 0.3em rgba(255, 255, 255, 0.5);
			  font-weight: 700;
			}
			
			.frontSide,
			.frontSide::before {
			  background: linear-gradient(43deg, rgb(65, 88, 208) 0%, rgb(200, 80, 192) 46%, rgb(255, 204, 112) 100%);
			}
			
			.backSide,
			.backSide::before {
			  background-image: linear-gradient(160deg, #0093E9 0%, #80D0C7 100%);
			}
			
			.backSide {
			  transform: rotateY(180deg);
			}
			
			.backSide li {
			  text-align: justify;
			  line-height:2em;
			  vertical-align: middle;;
			}
			
			.frontSide::before,
			.backSide::before {
			  top: 50%;
			  left: 50%;
			  transform: translate(-50%, -50%);
			  content: '';
			  width: 110%;
			  height: 110%;
			  position: absolute;
			  z-index: -1;
			  border-radius: 1em;
			  filter: blur(20px);
			  animation: animate 5s linear infinite;
			}
			
			@keyframes animate {
			  0% {
			    opacity: 0.3;
			  }
			
			  80% {
			    opacity: 1;
			  }
			
			  100% {
			    opacity: 0.3;
			  }
			}
			button {
			  width: 10em;
			  position: relative;
			  height: 3.5em;
			  border: 3px ridge #149CEA;
			  outline: none;
			  background-color: transparent;
			  transition: 1s;
			  border-radius: 0.3em;
			  font-size: 16px;
			  font-weight: bold;
			}
			[type=submit]::after, [type=button]::after {
			  content: "";
			  position: absolute;
			  top: -10px;
			  left: 3%;
			  width: 95%;
			  height: 40%;
			  background-color: none;
			  transition: 0.5s;
			  transform-origin: center;
			}
			[type=submit]::before, [type=button]::before {
			  content: "";
			  transform-origin: center;
			  position: absolute;
			  top: 80%;
			  left: 3%;
			  width: 95%;
			  height: 40%;
			  background-color: none;
			  transition: 0.5s;
			}
			
			[type=submit]:hover::after, [type=button]:hover::after, 
			[type=submit]:hover::before, [type=button]:hover::before {
			  transform: scale(0);
			}
			[type=submit]:hover, [type=button]:hover {
			  box-shadow: inset 0px 0px 25px #a2d2ff;
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
							<jsp:include page="../inc/menu.jsp" />
						</nav>

				</div>

			<!-- Main -->
				<div class="wrapper style1">
					<div class="container">
						<article id="main" class="special">
							<header>
								<h2>부대행사</h2>
								<section class="layout"></section>
								<button type="button" onclick="location.href='${path}/view/eventReg.jsp'">행사등록</button>
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
								    			<a href="${path}/view/eventList.jsp?pageNum=<%=startPage - pageBlock%>" class="page-link">‹</a>
								    		</li>
			<%
										}
										
										for(int i = startPage; i <= endPage; i++) {
											if(i == currentPage) {
			%>											
								    			<li class="page-item active"><a href="${path}/view/eventList.jsp?pageNum=<%=currentPage%>" class="page-link"><%=currentPage %></a></li>
			<%
											} else {
			%>	
								    			<li class="page-item"><a href="${path}/view/eventList.jsp?pageNum=<%=i%>" class="page-link"><%=i %></a></li>
			<%	
											}
										
										}
										//[다음] 끝페이지 번호가 전체 페이지수 보다 작을 때
										if(endPage < pageCount) {
			%>													
											<li class="page-item">
								    			<a href="${path}/view/eventList.jsp?pageNum=<%=startPage + pageBlock%>" class="page-link">›</a>
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