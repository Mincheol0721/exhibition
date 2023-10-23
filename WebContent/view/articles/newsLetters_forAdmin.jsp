<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% 
    DAO.newsLettersDAO.NewsLettersDAO ndao = new DAO.newsLettersDAO.NewsLettersDAO();
    request.setAttribute("ndao", ndao);
%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<title>NewsLetters[뉴스레터 게시판 - 관리자용]</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="${path}/assets/css/main.css" />
	<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">    
	<!-- 페이징 -->
    <c:set var="count" value="${ndao.getBoardCount()}" />
    
    <c:set var="pageSize" value="10" />
    <c:set var="pageNum" value="${param.pageNum}" />
    <c:choose>
        <c:when test="${empty pageNum}">
            <c:set var="pageNum" value="1" />
        </c:when>
    </c:choose>
    
    <c:set var="currentPage" value="${pageNum}" />
    
    <c:set var="startRow" value="${(currentPage - 1) * pageSize}" />
    <c:set var="list" value="${ndao.getBoardList(startRow, pageSize)}" />

</head>

	<div id="page-wrapper">
			
			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="#" id="logo">부산 취업박람회</a></h1>
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
									<h2><a href="#">뉴스 레터</a></h2>							
							</header>			
						<section>						
						<table class="table table-hover">					    
					        <tr style="background-color: #dee2e6;">						        	
					            <th>글 번호</th>
					            <th>제목</th>
					            <th>작성일</th>
					            <th>조회수</th>
					            <th></th>
					        </tr>
						        	        
							<c:forEach items="${list}" var="vo" varStatus="status"> 
							    <tr>
							        <td>${vo.no}</td>
							        <td class="left">
							            <a href="${path}/Articles/NewsLettersDetail.do?no=${vo.no}">${vo.title}</a>
							        </td>
							        <td><c:out value="${fn:substring(vo.writeDate, 0, 10)}" /></td>
							        <td>${vo.readCount}</td>
							        <td>
							            <a href="javascript:void(0);" onclick="delNewsLetter(${vo.no});">삭제</a>
							        </td>							        
							    </tr>
							</c:forEach>								
						 </table>
			  					    
						      <!-- 페이징 컨트롤 부분 -->
						   <nav aria-label="Page navigation example">
							     <ul class="pagination justify-content-center">
							        <c:set var="pageSize" value="10" />
							        <c:set var="currentPage" value="${pageNum}" />
							        <c:set var="totalPages" value="${(count + pageSize - 1) / pageSize}" />
							
							        <c:if test="${currentPage > 1}">
							            <c:set var="prevPage" value="${currentPage - 1}" />
							            <li class="page-item">
							                <a class="page-link" href="${path}/Articles/NewsLetters_forAdmin.do?pageNum=${prevPage}">이전</a>
							            </li>
							        </c:if>
							
							        <c:forEach var="i" begin="1" end="${totalPages}">
							            <c:choose>
							                <c:when test="${i == currentPage}">
							                    <li class="page-item active" aria-current="page">
							                        <a class="page-link" href="#">${i}</a>
							                    </li>
							                </c:when>
							                <c:otherwise>
							                    <li class="page-item">
							                        <a class="page-link" href="${path}/Articles/NewsLetters_forAdmin.do?pageNum=${i}">${i}</a>
							                    </li>
							                </c:otherwise>
							            </c:choose>
							        </c:forEach>
							
							        <c:if test="${currentPage < totalPages}">
							            <c:set var="nextPage" value="${currentPage + 1}" />
							            <li class="page-item">
							                <a class="page-link" href="${path}/Articles/NewsLetters_forAdmin.do?pageNum=${nextPage}">다음</a>
							            </li>
							        </c:if>
							    </ul>
							</nav>
														
							<a href="${path}/Articles/NewsLettersWrite.do" style="float: right;">+ 새 글 작성</a>
								
						    <!-- <h1>전체 글 개수 : ${count}</h1> -->
						    
						</section>
					</article>
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
		
		<!-- 자바스크립트 함수 호출 구문 -->
		<script>
			function delNewsLetter(no) {
			    var confirmation = confirm("게시물을 삭제하시겠습니까?");
			    if (confirmation) {
			        window.location.href = "${path}/Articles/DelNewsLetter.do?no=" + no;
			    }
			}
		</script>

	
</html>