<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	request.setCharacterEncoding("UTF-8"); 
	
	//하나의 화면에 띄워줄 글 개수 10
	int pageSize = 10;
	
	//현재 보여질 페이지번호 가져오기
	String pageNum = request.getParameter("pageNum");
	
	//현재 보여질 페이지 번호가 없으면 1페이지 처리
	if(pageNum == null) {
		pageNum = "1";
	}
//	System.out.println("pageNum: " + pageNum);
	
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
		.bn30 {
		  float: right;
		  margin: 0 5px;
		  border: 5em;
		  cursor: pointer;
		  outline: none;
		  font-size: 16px;
		  -webkit-transform: translate(0);
		  transform: translate(0);
		  background-image: linear-gradient(45deg, #4568dc, #b06ab3);
		  padding: 0.7em 2em;
		  border-radius: 65px;
		  box-shadow: 1px 1px 10px rgba(255, 255, 255, 0.438);
		  -webkit-transition: box-shadow 0.25s;
		  transition: box-shadow 0.25s;
		  color: white;
		}
		
		.bn30 .text {
		  background-clip: text;
		  -webkit-background-clip: text;
		  -webkit-text-fill-color: transparent;
		  background-image: linear-gradient(45deg, #4568dc, #b06ab3);
		}
		
		.bn30:after {
		  content: "";
		  border-radius: 18px;
		  position: absolute;
		  margin: 4px;
		  top: 0;
		  left: 0;
		  bottom: 0;
		  right: 0;
		  z-index: -1;
		  background: #0e0e10;
		}
		
		.bn30:hover {
		  background-image: linear-gradient(-45deg, #4568dc, #b06ab3);
		  box-shadow: 0 12px 24px rgba(128, 128, 128, 0.1);
		}
		
		.bn30:hover .text {
		  background-image: linear-gradient(-45deg, #4568dc, #b06ab3);
		}
		</style>
	</head>
	<body>
		<button class="bn30" value="개인회원" onclick="location.href='<%=request.getContextPath()%>/applicant/getIList.do?pageNum=<%=pageNum%>&pageSize=<%=pageSize%>'">
			개인회원
		</button>
		<button class="bn30" value="기업회원" onclick="location.href='<%=request.getContextPath()%>/applicant/getCList.do?pageNum=<%=pageNum%>&pageSize=<%=pageSize%>'">
			기업회원
		</button>
	</body>
</html>