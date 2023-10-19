<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 제일 먼저 열려야 하는 jsp(index.jsp 중간 부분 박람회 상세보기에 값 전달하기 위함) -->
<%
	response.sendRedirect("/exhibition/Menu/searchIndexNo.do");
%>