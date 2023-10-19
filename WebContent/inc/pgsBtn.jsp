<%@page import="java.util.List"%>
<%@page import="VO.pgsVO.PgsVO"%>
<%@page import="DAO.pgsDAO.PgsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	request.setCharacterEncoding("UTF-8"); 
	
	PgsDAO dao = new PgsDAO();
	PgsVO vo = null;
	List<PgsVO> list = null;
	
	//전체 글 개수
	int count = dao.getPgsCount();
	System.out.println("count: " + count);
	
	//하나의 화면에 띄워줄 글 개수 10
	int pageSize = 9;
	
	//현재 보여질 페이지번호 가져오기
	String pageNum = request.getParameter("pageNum");
	
	//현재 보여질 페이지 번호가 없으면 1페이지 처리
	if(pageNum == null) {
		pageNum = "1";
	}
	//System.out.println("pageNum: " + pageNum);
	
	//현재 보여질 페이지 번호 "1"을 기본정수 1로 변환
	int currentPage = Integer.parseInt(pageNum);
	//System.out.println("currentPage: " + currentPage);
	
	//각 페이지마다 맨 위에 보여질 시작 글번호 구하기
	//(현재 보여질 페이지 번호 - 1) * 한페이지당 보여줄 글 개수
	int startRow = (currentPage - 1) * pageSize;
	//System.out.println("startRow: " + startRow);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script type="text/javascript">
		$(function() {
				
			});
			
			function callPgs(pageNum, pageSize) {
				location.href='<%=request.getContextPath()%>/pgs/getList.do?pageNum=<%=pageNum%>';
			}
		</script>
		<style type="text/css">
		.conBtn {
			display: flex;
			justify-content: center;
			flex-wrap: wrap;
			margin: 10px auto;
			
		}
		button {
			--glow-color: rgb(217, 176, 255);
			--glow-spread-color: rgba(191, 123, 255, 0.781);
			--enhanced-glow-color: rgb(231, 206, 255);
			--btn-color: rgb(100, 61, 136);
			margin: 20px auto;
			border: .25em solid var(--glow-color);
			padding: 1em 3em;
			color: var(--glow-color);
			font-size: 15px;
			font-weight: bold;
			background-color: var(--btn-color);
			border-radius: 1em;
			outline: none;
			box-shadow: 0 0 1em .25em var(--glow-color),
			       0 0 4em 1em var(--glow-spread-color),
			       inset 0 0 .75em .25em var(--glow-color);
			text-shadow: 0 0 .5em var(--glow-color);
			position: relative;
			transition: all 0.3s;
		}		
		button::after {
			pointer-events: none;
			content: "";
			position: absolute;
			top: 120%;
			left: 0;
			height: 100%;
			width: 100%;
			background-color: var(--glow-spread-color);
			filter: blur(2em);
			opacity: .7;
			transform: perspective(1.5em) rotateX(35deg) scale(1, .6);
		}
		
		button:hover {
			color: var(--btn-color);
			background-color: var(--glow-color);
			box-shadow: 0 0 1em .25em var(--glow-color),
			        0 0 2em 1em var(--glow-spread-color),
			        inset 0 0 .75em .25em var(--glow-color);
		}
		
		button:active {
			box-shadow: 0 0 0.6em .25em var(--glow-color),
			        0 0 2.5em 2em var(--glow-spread-color),
			        inset 0 0 .5em .25em var(--glow-color);
		}
		</style>
	</head>
	<body>
		<div class="conBtn">
			<button type="button" class="manageBtn"> 신청자 관리 </button>
			<button type="button" class="manageBtn"> 구직자 관리 </button>
			<button type="button" class="manageBtn" onclick="callPgs();"> 프로그램 및 행사 관리 </button>
		</div>
	</body>
</html>