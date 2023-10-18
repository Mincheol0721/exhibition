<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<title>로그인</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
				
			$(function() {
				$('.indReg').hide();
				$('.compReg').hide();
				
				
				$('#regBtn').children().on('click', function(e) {
					if($(this).val() == '기업회원') {
						$('.indReg').hide();
						$('.compReg').show();
					} else {
						$('.compReg').hide();
						$('.indReg').show();
					}
				});
			});
			
		</script>
		<style type="text/css">
			.regdiv > label {width: 20%; text-align: justify;}
			.clause {box-sizing: border-box;}
			.bn632-hover {
			  width: 160px;
			  font-size: 16px;
			  font-weight: 600;
			  color: #fff;
			  cursor: pointer;
			  margin: 20px;
			  height: 55px;
			  text-align:center;
			  border: none;
			  background-size: 300% 100%;
			  border-radius: 50px;
			  moz-transition: all .4s ease-in-out;
			  -o-transition: all .4s ease-in-out;
			  -webkit-transition: all .4s ease-in-out;
			  transition: all .4s ease-in-out;
			}
			
			.bn632-hover:hover {
			  background-position: 100% 0;
			  moz-transition: all .4s ease-in-out;
			  -o-transition: all .4s ease-in-out;
			  -webkit-transition: all .4s ease-in-out;
			  transition: all .4s ease-in-out;
			}
			
			.bn632-hover:focus {
			  outline: none;
			}
			
			.bn632-hover.bn27 {
			  background-image: linear-gradient(
			    to right,
			    #ed6ea0,
			    #ec8c69,
			    #f7186a,
			    #fbb03b
			  );
			  box-shadow: 0 4px 15px 0 rgba(236, 116, 149, 0.75);
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
								<h1><a href="index.jsp" id="logo">부산 취업 박람회</a></h1>
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
								
								<h2>로그인</h2>
								<div id="regBtn"> 
									<button class="bn632-hover bn27" class="regType" value="개인회원">개인회원</button>
									<button class="bn632-hover bn27" class="regType" value="기업회원">기업회원</button>
								</div>
								<form action="${path}/login/Ilogin.me" class="indReg" method="post">
									
									
									<br>
									<br>
									<br>
									
									<div class="regdiv">
                                        <label for="id">아이디<span><small id="chkId"></small></span></label>
                                        <input class="form-control" id="id" type="text" name="id" />
                                    </div>
                                    <div class="regdiv">
                                       <label for="pwd">비밀번호</label>
                                        <input class="form-control" id="pwd" type="password" name="pwd" required />
                                    </div>
                                    
                                    <br>
                                    <input type="submit" value="로그인">
                                    <input type="reset" value="다시작성">
								</form>
								
								<br>
								
								<!-- 기업회원가입 양식 -->
								<form action="${path}/login/Clogin.me" class="compReg" method="post">
	
									
									<br>
									<br>
									<br>
									<div class="regdiv">
                                        <label for="id">사업자 등록 번호<span><small id="chkId"></small></span></label>
                                        <input class="form-control" id="cno" type="text" name="cno" />
                                    </div>

                                    <div class="regdiv">
                                       <label for="pwd">비밀번호</label>
                                        <input class="form-control" id="cPwd" type="password" name="cPwd" required />
                                    </div>
                                   
                                    <br>
                                    <input type="submit" value="로그인">
                                    <input type="reset" value="다시작성">
								</form>
							</header>
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

	</body>
</html>
