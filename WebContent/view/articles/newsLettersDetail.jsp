<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" /> 

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>NewsLetters 상세 정보</title>
</head>
<body>
    <h1>NewsLetters 상세 정보</h1>
    
    <c:out value="${vo.no}" /> <br>
    <c:out value="${vo.title}" /> <br>
    <c:out value="${vo.content}" /> <br>

</body>
</html>
