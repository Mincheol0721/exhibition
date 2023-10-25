<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE HTML>
<html>
	<head>
		<title>부산 취업박람회 직업체험 등록</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	</head>
	<body class="no-sidebar is-preload">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Inner -->
						<div class="inner">
							<header>
								<h1><a href="index.html" id="logo">직업체험</a></h1>
							</header>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<jsp:include page="/inc/menu.jsp" />
						</nav>

				</div>

			<form method="post"   action="${path}/jobExp/CJobExpReg2.do" enctype="multipart/form-data">
	<h1  class="text_center">참여 등록 창</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">주최기업명</td>
	      <td width="400"><input type="text" name="cname"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">글제목</td>
	      <td width="400"><input type="text" name="title"></td>
	    </tr>
	   <tr>
	      <td width="200"><p align="right">글내용</td>
	      <td width="400"><input type="text" name="content"></td>
	    </tr>
	   <tr>
	      <td width="200"><p align="right">참여대상</td>
	      <td width="400"><input type="text" name="iPart"></td>
	    </tr>
	    <tr>
	      <td width="200"><p align="right">강사</td>
	      <td width="400"><input type="text" name="teacher"></td>
	    </tr>
	   <tr>
	      <td width="200"><p align="right">이용시간(시작)</td>
	      <td width="400"><input type="text" name="startTime"></td>
	    </tr>
	   <tr>
	      <td width="200"><p align="right">이용시간(종료)</td>
	      <td width="400"><input type="text" name="endTime"></td>
	    </tr>
	   <tr>
	      <td width="200"><p align="right">행사장소</td>
	      <td width="400"><input type="text" name="locate"></td>
	    </tr>
	    </tr>
	      <td width="200"><p align="right">직업체험 사진</td>
	      <td>
	            <input type="file" name="file">   
	       </td>
        </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="신청하기"><input type="reset" value="다시입력"></td>
	    </tr>
	    
	</table>
	</form>

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

	</body>
</html>