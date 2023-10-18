
<%@page import="VO.IMemberVO.IMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); 
	IMemberVO vo = null;
	 vo = (IMemberVO)request.getAttribute("vo");
	
%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:choose>

	<c:when test="${requestScope.msg == 'modifyOk'}">
		<script>
			window.onload = function(){
				location.href = "${path}/view/mypage/iMypage.jsp";
				alert("수정 하였습니다.");
				
			}
		</script>
	</c:when>
</c:choose>
<!DOCTYPE html>
<html>
	<head>
		<title>회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		
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
			
			.bn631-hover {
			  width: 2000px;
			  font-size: 16px;
			  font-weight: 600;
			  color: #fff;
			  cursor: pointer;
			  padding:15px;
			  margin: 20px;
			  height: 55px;
			  text-align:center;
			  border: none;
			  background-size: 300% 100%;
			  border-radius: 15px;
			  moz-transition: all .4s ease-in-out;
			  -o-transition: all .4s ease-in-out;
			  -webkit-transition: all .4s ease-in-out;
			  transition: all .4s ease-in-out;
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
								<h1><a href="index.jsp" id="logo">회원정보 수정</a></h1>
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
								
								
								
								<form action="${path}/memberInfo/imodify.me" class="indReg" method="post">
									
									<br>
									
                                    <div class="regdiv">
                                       <label for="pwd">비밀번호</label>
                                        <input class="form-control" id="pwd" type="password" name="pwd" required value="<%=vo.getPassword()%>"/>
                                        <br>
                                        
                                    </div>
                                    
                                    <div class="regdiv">
                                        <label for="name">이름</label>
                                        <input class="form-control" id="name" type="text" name="name" required="required" value="<%=vo.getName()%>"/>
                                        <br>
                                        <b id="nameInput"></b>
                                    </div>
                                    <div class="regdiv">
                                        <label for="tel">전화번호</label>
                                        <input class="form-control" id="tel" type="tel" name="tel" required="required" value="<%=vo.getItel()%>"/>
                                        <br>
                                        <b id="telInput"></b>
                                    </div>
                                    
                                   
                                    
                                    <div class="regdiv">
                                        <label for="email">이메일</label>
                                        <input class="form-control" id="email" type="email" name="email" required="required" value="<%=vo.getEmail()%>"/>
                                        <br>
                                        <b id="emailInput"></b>
                                    </div>
					                <div class="form-group">
									<div class="regdiv">
										<div class="col-6">
											<%-- name속성값 address1 부터 ~~ address5 까지 입력되어 있는 주소를 모두 합쳐서 DB에 address열에  INSERT 하자. --%>
											
											 
											<input type="text" id="sample4_postcode" name="address1" class="form-control" placeholder="우편번호" required value="<%=vo.getAddr1()%>">
											<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="form-control"><br>
											
											<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소" class="form-control" required="required" value="<%=vo.getAddr2()%>">
											<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="address3" class="form-control" value="<%=vo.getAddr3()%>" required="required">
											
											<span id="guide" style="color:#999;display:none"></span>
											
											<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address4" class="form-control" value="<%=vo.getAddr4()%>" required="required">
											
											<br>
											<b id="addressInput"></b>
										</div>
										</div>
										</div>
                                    <br>
                                
                                
								</form>
								<div id="regBtn"> 
									<button class="bn632-hover bn27" class="regType" id="submitBtn" type="submit">수정하기</button>
									<button class="bn632-hover bn27"  class="regType" id="backBtn">뒤로</button>
								</div>
								<br>
								
								
								
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
			
			<!-- Optional JavaScript -->
			<!-- jQuery first, then Popper.js, then Bootstrap JS -->
			<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
				integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
				integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
				crossorigin="anonymous"></script>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
				integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
				crossorigin="anonymous"></script>
				
			<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<script type="text/javascript">
			
		    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
		    function sample4_execDaumPostcode() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

		                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var roadAddr = data.roadAddress; // 도로명 주소 변수
		                var extraRoadAddr = ''; // 참고 항목 변수

		                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
		                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
		                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                    extraRoadAddr += data.bname;
		                }
		                // 건물명이 있고, 공동주택일 경우 추가한다.
		                if(data.buildingName !== '' && data.apartment === 'Y'){
		                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                }
		                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
		                if(extraRoadAddr !== ''){
		                    extraRoadAddr = ' (' + extraRoadAddr + ')';
		                }

		                // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                document.getElementById('sample4_postcode').value = data.zonecode;
		                document.getElementById("sample4_roadAddress").value = roadAddr;
		                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
		                
		                

		                var guideTextBox = document.getElementById("guide");
		                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
		                if(data.autoRoadAddress) {
		                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
		                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
		                    guideTextBox.style.display = 'block';

		                } else if(data.autoJibunAddress) {
		                    var expJibunAddr = data.autoJibunAddress;
		                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
		                    guideTextBox.style.display = 'block';
		                } else {
		                    guideTextBox.innerHTML = '';
		                    guideTextBox.style.display = 'none';
		                }
		            }
		        }).open();
		    }
			</script>
			<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
			<script type="text/javascript">
			
			$("#submitBtn").on('click',function(){
				$("form").submit();
			})
			

			$("#backBtn").on('click',function(){
				
				history.go(-1);
	    		
			})
		
			
			</script>
			
			
	</body>
</html>
