<%@page import="VO.IMemberVO.IMemberVO"%>
<%@page import="VO.appFormVO.AppFormVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path"  value="${pageContext.request.contextPath}"  /> 

<% 
	request.setCharacterEncoding("UTF-8"); 
%>

<!DOCTYPE html>
<html>
	<head>
		<title>구직자 관리</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script type="text/javascript">
			$(function() {
				var radio = $('input[type=radio]');
				var isSeek = '${vo.isSeek}';
				
				$('input[type=radio][value='+isSeek+']').prop('checked', true);
				
				$('input[type=radio]').on('click', function() {
					alert('값: ' + $(this).val());
				});
				
			});
		</script>
		<style type="text/css">
		.regdiv > label {width: 20%; text-align: justify;}
		table td {
		 	vertical-align: middle;
			text-align: left;
			padding-left: 10px;
			border: 1px solid gray;
			border-collapse: collapse;
		}
		table th {
			background-color: lightgray;
			vertical-align: middle;
			border: 1px solid gray;
			border-collapse: collapse;
		}
		#photo {
			padding: 0;
			text-align: center;
			vertical-align: middle;
		}
		table input {
			border: 1px solid rgba(0, 0, 0, 0.2);
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
								<h1><a href="${path}/view/index.jsp" id="logo">부산 취업 박람회</a></h1>
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
								<h2>구직자 정보 수정</h2>
								<hr>
								<form action="${path}/applicant/modJobSeeker.do?id=${vo.id}" method="post">
								<input type="hidden" name="ssn" value="${vo.ssn}" />
									<table border="none">
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;" width="20%">구직자 ID</th>
											<td width="30%"><input type="text" name="id" value="${vo.id}" disabled></td>
											<th style="border:1px solid gray; width: 20%">구직자명</th>
											<td width="30%"><input type="text" name="name" value="${vo.name}"></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">구직자 연락처</th>
											<td><input type="tel" name="itel" value="${vo.itel}"></td>
											<th style="border:1px solid gray;">구직자 주민등록번호</th>
											<td><input type="text" value="${fn:substring(vo.ssn,0,8)}******" disabled></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">이메일 주소</th>
											<td colspan="3"><input type="email" name="email" value="${vo.email}"></td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">주소</th>
											<td colspan="3">
											<div class="regdiv">
											<%-- name속성값 address1 부터 ~~ address5 까지 입력되어 있는 주소를 모두 합쳐서 DB에 address열에  INSERT 하자. --%>
											
											 
											<input type="text" id="sample4_postcode" name="addr1" class="form-control" placeholder="우편번호" value="${vo.addr1}" style="width: 20%;">
											<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="form-control"
												   style="vertical-align: middle; text-align: center; max-width: 220px; max-height: 50px"><br>
												
											<input type="text" id="sample4_roadAddress" name="addr2" placeholder="도로명주소" class="form-control" value="${vo.addr2}">
											<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="addr3" class="form-control" value="${vo.addr3}">
											
											<span id="guide" style="color:#999;display:none"></span>
											
											<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="addr4" class="form-control" value="${vo.addr4}">
											
											<br>
											<b id="addressInput"></b>
										</div>
											</td>
										</tr>
										<tr style="border:1px solid gray;">
											<th style="border:1px solid gray;">회원가입일</th>
											<td><input type="text" name="regDate" value="${vo.regDate}"></td>
											<th style="border:1px solid gray;">구직상태</th> 
											<td>
										 	<input type="radio" name="isSeek" value="0"> 구직중
										 	<input type="radio" name="isSeek" value="1"> 재직중
										 	<input type="radio" name="isSeek" value="2"> 휴직중
											</td>
										</tr>
									</table>
									<input type="button" value="글목록" onclick="location.href='${path}/applicant/getImember.do'">
									<input type="submit" class="adminBtn" value="수정하기">
									<input type="reset" class="adminBtn" value="다시작성">
								</form>
							</header>
							</article>
					</div>

				</div>

			<!-- Footer -->
			<div id="footer">
				<jsp:include page="/inc/footer.jsp" />
			</div>
		</div>
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
		                    document.getElementById("sample4_jibunAddress").value = expJibunAddr;
		                    guideTextBox.style.display = 'block';
		                } else {
		                    guideTextBox.innerHTML = '';
		                    guideTextBox.style.display = 'none';
		                }
		            }
		        }).open();
		    }
		    
		    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
		    function sample4_execDaumPostcode2() {
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
		                document.getElementById('sample4_postcode2').value = data.zonecode;
		                document.getElementById("sample4_roadAddress2").value = roadAddr;
		                document.getElementById("sample4_jibunAddress2").value = data.jibunAddress;
		                
		                

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
	</body>
</html>