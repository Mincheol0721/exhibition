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
    <meta charset="UTF-8">
    <title>NewsLetters[뉴스레터 게시판]</title>
    
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
<body>
    <h1>전체 글 개수 : ${count}</h1>
    
    <table>
        <tr>
            <th>No.</th>
            <th>Title</th>
            <th>Date</th>
            <th>ReadCount</th>
        </tr>
        
        <c:forEach items="${list}" var="vo">
		    <tr>
		        <td>${vo.no}</td>
		        <td class="left">
		            <a href="${path}/Articles/NewsLettersDetail.do?no=${vo.no}">${vo.title}</a>
		        </td>
		        <td><c:out value="${fn:substring(vo.writeDate, 0, 10)}" /></td>
		        <td>${vo.readCount}</td>
		    </tr>
		</c:forEach>


    </table>
    
      <!-- 페이징 컨트롤 부분 -->
    <div class="pagination">
        <c:set var="pageSize" value="10" />
        <c:set var="currentPage" value="${pageNum}" />
        <c:set var="totalPages" value="${(count + pageSize - 1) / pageSize}" />
        
        <c:if test="${currentPage > 1}">
            <a href="${path}/Articles/NewsLetters.do?pageNum=${currentPage - 1}">이전</a>
        </c:if>
        
        <c:forEach var="i" begin="1" end="${totalPages}">
            <c:choose>
                <c:when test="${i == currentPage}">
                    <strong>${i}</strong>
                </c:when>
                <c:otherwise>
                    <a href="${path}/Articles/NewsLetters.do?pageNum=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        
        <c:if test="${currentPage < totalPages}">
            <a href="${path}/Articles/NewsLetters.do?pageNum=${currentPage + 1}">다음</a>
        </c:if>
    </div>
    
    <a href="${path}/Articles/NewsLettersWrite.do">뉴스레터 작성하기</a>
</body>
</html>
