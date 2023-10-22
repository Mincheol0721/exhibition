<%@page import="java.util.List"%>
<%@page import="VO.pgsVO.PgsVO"%>
<%@page import="DAO.pgsDAO.PgsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	request.setCharacterEncoding("UTF-8"); 

	String constype = null;
	if(request.getParameter("constype") == null) {
		constype = "자기소개서";
	} else {
		constype = request.getParameter("constype");
	}
	
	//하나의 화면에 띄워줄 글 개수 10
	int pageSize = 10;
	
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
				var selMember = $('#selectMember');
				var selEvent = $('#selectEvent');
				var btn = $('#btn');
				
				btn.children().on('click', function() {
					if($(this).val() == '신청자 관리') {
						selEvent.show();
					}
				});
				
				selEvent.children().on('click', function() {
					if($(this).val() == '직업체험') {
						selMember.show();
					}
				});
				
			});
			
			function callPgs() {
				location.href='<%=request.getContextPath()%>/pgs/getList.do?pageNum=<%=pageNum%>';
			}
			
			function callCons() {
				location.href='<%=request.getContextPath()%>/applicant/getCons.do?constype=<%=constype%>';
			}
			
			function jobSeekers() {
				location.href='<%=request.getContextPath()%>/applicant/getImember.do?pageNum=<%=pageNum%>';
			}
			
		</script>
		<style type="text/css">
		.shadow__btn {
			padding: 10px 20px;
			margin: 10px auto;
			border: none;
			font-size: 17px;
			color: #fff;
			border-radius: 7px;
			letter-spacing: 4px;
			font-weight: 700;
			text-transform: uppercase;
			transition: 0.5s;
			transition-property: box-shadow;
		}
		
		.shadow__btn {
			background: rgb(0,140,255);
			box-shadow: 0 0 25px rgb(0,140,255);
		}
		
		.shadow__btn:hover {
			box-shadow: 0 0 5px rgb(0,140,255),
		    	        0 0 25px rgb(0,140,255),
		        	    0 0 50px rgb(0,140,255),
		            	0 0 100px rgb(0,140,255);
		}
		#selectMember {
			margin: 0, auto;
		}
		</style>
	</head>
	<body>
		<header>
			<div id="btn">
				<button class="shadow__btn" value="구직자 관리" onclick="jobSeekers();">
					구직자 관리
				</button>
				<button class="shadow__btn" value="신청자 관리">
					신청자 관리
				</button>
				<button class="shadow__btn" onclick="callPgs();" value="프로그램 및 행사 관리">
					프로그램 및 행사 관리
				</button>
			</div>
			<div id="selectEvent" style="display: none;">
				<button class="shadow__btn" value="직업체험" onclick="location.href='<%=request.getContextPath()%>/applicant/getIList.do?pageNum=<%=pageNum%>&pageSize=<%=pageSize%>'">
					직업체험
				</button>
				<button class="shadow__btn" value="모의면접" onclick="callCons();">
					컨설팅
				</button>
			</div>
		</header>
	</body>
</html>