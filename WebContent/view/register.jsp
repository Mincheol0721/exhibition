<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<title>회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
				
			$(function() {
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
			
				.bn631-hover:hover {
			  background-position: 100% 0;
			  moz-transition: all .4s ease-in-out;
			  -o-transition: all .4s ease-in-out;
			  -webkit-transition: all .4s ease-in-out;
			  transition: all .4s ease-in-out;
			}
			
			.bn631-hover:focus {
			  outline: none;
			}
			
			.bn631-hover.bn27 {
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
								
								<h2>회원가입</h2>
								<div id="regBtn"> 
									<button class="bn632-hover bn27" class="regType" value="개인회원">개인회원</button>
									<button class="bn632-hover bn27"  class="regType" value="기업회원">기업회원</button>
								</div>
								<form action="${path}/Join/addIMember.do" class="indReg" method="post" enctype="multipart/form-data">
									<textarea rows="20" cols="150"  readonly="readonly">
가. 수집하는 개인정보의 항목첫째, 회사는 회원가입, 원활한 고객상담, 각종 서비스의 제공을 위해 최초 회원가입 당시 아래와 같은 최소한의 개인정보를 필수항목으로 수집하고 있습니다.
회원가입
- 이름, 생년월일, 성별, 아이디, 비밀번호, 별명, 연락처(메일주소, 휴대폰 번호 중 선택), 가입인증정보
만14세 미만 아동 회원가입
- 이름, 생년월일, 성별, 법정대리인 정보, 아이디, 비밀번호, 연락처 (메일주소, 휴대폰 번호 중 선택), 가입인증정보
단체아이디 회원가입
- 단체아이디, 회사명, 대표자명, 대표 전화번호, 대표 이메일 주소, 단체주소, 관리자 아이디, 관리자 연락처, 관리자 부서/직위
- 선택항목 : 대표 홈페이지, 대표 팩스번호
둘째, 서비스 이용과정이나 사업처리 과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.
- IP Address, 쿠키, 방문 일시, 서비스 이용 기록, 불량 이용 기록
셋째, 네이버 아이디를 이용한 부가 서비스 및 맞춤식 서비스 이용 또는 이벤트 응모 과정에서 해당 서비스의 이용자에 한해서만 개인정보 추가 수집이 발생할 수 있으며, 이러한 경우 별도의 동의를 받습니다.
넷째, 성인컨텐츠, 유료/게임 등 일부 서비스 이용시 관련 법률 준수를 위해 본인인증이 필요한 경우, 아래와 같은 정보들이 수집될 수 있습니다.
- 이름, 생년월일, 성별, 중복가입확인정보(DI), 암호화된 동일인 식별정보(CI), 휴대폰 번호(선택), 아이핀 번호(아이핀 이용시), 내/외국인 정보
다섯째, 유료 서비스 이용 과정에서 아래와 같은 결제 정보들이 수집될 수 있습니다.
- 신용카드 결제시 : 카드사명, 카드번호 등
- 휴대전화 결제시 : 이동전화번호, 통신사, 결제승인번호 등
- 계좌이체시 : 은행명, 계좌번호 등
- 상품권 이용시 : 상품권 번호
나. 개인정보 수집방법회사는 다음과 같은 방법으로 개인정보를 수집합니다.
- 홈페이지, 서면양식, 팩스, 전화, 상담 게시판, 이메일, 이벤트 응모, 배송요청
- 협력회사로부터의 제공
- 생성정보 수집 툴을 통한 수집
									</textarea>	
									<br>
									개인정보 수집 및 이용에 동의합니다. <input type="checkbox" name="clause" id="clause"> 
									<div class="container">
									<b id="agreeInput" class="regType" ></b>
									</div>
									<br>
									<div class="regdiv">
                                        <label for="file">프로필사진</label>
                                        <input class="form-control" id="file" type="file" name="file" />
                                        <br>
                                        <br>
                                    </div>
									
									<div class="regdiv">
                                        <label for="id">아이디<span><small id="chkId"></small></span></label>
                                        <input class="form-control" id="id" type="text" name="id" placeholder="한글,특수문자 없이 3~20글자사이로 작성해 주세요!
                                        "/>
                                        <br>
                                        <b id="idInput"></b> 
                                    </div>
                                    <div class="regdiv">
                                       <label for="pwd">비밀번호</label>
                                        <input class="form-control" id="pwd" type="password" name="pwd" required placeholder="한글,특수문자 없이 4글자 이상으로 작성해 주세요!
                                        "/>
                                    </div>
                                    <div class="regdiv">
                                        <label for="pwdConfirm">비밀번호 확인</label>
                                        <input class="form-control" id="pwdConfirm" type="password"  required placeholder="한글,특수문자 없이 4글자 이상으로 작성해 주세요! "/>
                                        <br>
                                        <b id="passInput"></b>
                                    </div>
                                    <div class="regdiv">
                                        <label for="name">이름</label>
                                        <input class="form-control" id="name" type="text" name="name" />
                                        <br>
                                        <b id="nameInput"></b>
                                    </div>
                                    <div class="regdiv">
                                        <label for="tel">전화번호</label>
                                        <input class="form-control" id="tel" type="tel" name="tel" placeholder="연락처를 '-'없이 적어주세요."/>
                                        <br>
                                        <b id="telInput"></b>
                                    </div>
                                    <div class="regdiv">
                                        <label for="ssn">주민등록번호</label>
                                        <input class="form-control" id="ssn" type="text" name="ssn" required="required" placeholder="주민등록번호를 '-'없이 적어주세요."/>
                                        <br>
                                        <b id="ssnInput"></b>
                                    </div>
                                   
                                    
                                    <div class="regdiv">
                                        <label for="email">이메일</label>
                                        <input class="form-control" id="email" type="email" name="email" />
                                        <br>
                                        <b id="emailInput"></b>
                                    </div>
					                <div class="form-group">
									<div class="regdiv">
										<div class="col-6">
											<%-- name속성값 address1 부터 ~~ address5 까지 입력되어 있는 주소를 모두 합쳐서 DB에 address열에  INSERT 하자. --%>
											
											 
											<input type="text" id="sample4_postcode" name="address1" class="form-control" placeholder="우편번호">
											<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="form-control"><br>
											
											<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소" class="form-control">
											<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="address3" class="form-control">
											
											<span id="guide" style="color:#999;display:none"></span>
											
											<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address4" class="form-control">
											
											<br>
											<b id="addressInput"></b>
										</div>
										</div>
										</div>
										
                                    <br>
                                
                                    <a href="#" onclick="check(); return false;" 
									   type="button"
										class="bn631-hover bn27">가입하기</a>
									
                                     <a href="#" 
									   type="reset" onclick="top.location='javascript:location.reload()'"
										class="bn631-hover bn27">다시입력</a>
								</form>
								
								<br>
								
								<!-- 기업회원가입 양식 -->
								<form action="${path}/Join/addCMember.do" class="compReg" method="post" enctype="multipart/form-data">
									<textarea rows="20" cols="150" id="agree" readonly="readonly">
가. 수집하는 개인정보의 항목첫째, 회사는 회원가 입, 원활한 고객상담, 각종 서비스의 제공을 위해 최초 회원가입 당시 아래와 같은 최소한의 개인정보를 필수항목으로 수집하고 있습니다.
회원가입
- 이름, 생년월일, 성별, 아이디, 비밀번호, 별명, 연락처(메일주소, 휴대폰 번호 중 선택), 가입인증정보
만14세 미만 아동 회원가입
- 이름, 생년월일, 성별, 법정대리인 정보, 아이디, 비밀번호, 연락처 (메일주소, 휴대폰 번호 중 선택), 가입인증정보
단체아이디 회원가입
- 단체아이디, 회사명, 대표자명, 대표 전화번호, 대표 이메일 주소, 단체주소, 관리자 아이디, 관리자 연락처, 관리자 부서/직위
- 선택항목 : 대표 홈페이지, 대표 팩스번호
둘째, 서비스 이용과정이나 사업처리 과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.
- IP Address, 쿠키, 방문 일시, 서비스 이용 기록, 불량 이용 기록
셋째, 네이버 아이디를 이용한 부가 서비스 및 맞춤식 서비스 이용 또는 이벤트 응모 과정에서 해당 서비스의 이용자에 한해서만 개인정보 추가 수집이 발생할 수 있으며, 이러한 경우 별도의 동의를 받습니다.
넷째, 성인컨텐츠, 유료/게임 등 일부 서비스 이용시 관련 법률 준수를 위해 본인인증이 필요한 경우, 아래와 같은 정보들이 수집될 수 있습니다.
- 이름, 생년월일, 성별, 중복가입확인정보(DI), 암호화된 동일인 식별정보(CI), 휴대폰 번호(선택), 아이핀 번호(아이핀 이용시), 내/외국인 정보
다섯째, 유료 서비스 이용 과정에서 아래와 같은 결제 정보들이 수집될 수 있습니다.
- 신용카드 결제시 : 카드사명, 카드번호 등
- 휴대전화 결제시 : 이동전화번호, 통신사, 결제승인번호 등
- 계좌이체시 : 은행명, 계좌번호 등
- 상품권 이용시 : 상품권 번호
나. 개인정보 수집방법회사는 다음과 같은 방법으로 개인정보를 수집합니다.
- 홈페이지, 서면양식, 팩스, 전화, 상담 게시판, 이메일, 이벤트 응모, 배송요청
- 협력회사로부터의 제공
- 생성정보 수집 툴을 통한 수집
									</textarea>	
									<br>
									개인정보 수집 및 이용에 동의합니다. <input type="checkbox" name="clause" id="clause2" > 
									<div class="container">
									<b id="agreeInput2" class="regType" ></b>
									</div>
									<br>
									<div class="regdiv">
                                        <label for="file">회사사진</label>
                                        <input class="form-control" id="file2" type="file" name="file2" />
                                        <br>
                                        <br>
                                    </div>
									<br>
									<div class="regdiv">
                                        <label for="id">회사명<span><small id="chkId"></small></span></label>
                                        <input class="form-control" id="cname" type="text" name="cname" />
                                        <br>
                                        <b id="cnameInput"></b>
                                    </div>
									<div class="regdiv">
                                        <label for="cno">사업자등록번호<span><small id="chkId"></small></span></label>
                                        <input class="form-control" id="cno" type="text" name="cno" placeholder="-를 넣어서 입력해 주세요 (ex)123-45-67890"/>
                                        <br>
                                        <b id="cnoInput"></b>
                                    </div>
                                    <div class="regdiv">
                                        <label for="name2">대표자명</label>
                                        <input class="form-control" id="name2" type="text" name="name2" />
                                        <br>
                                        <b id="nameInput2"></b>
                                    </div>
                                    <div class="regdiv">
                                        <label for="ctel">회사 전화번호</label>
                                        <input class="form-control" id="ctel" type="tel" name="ctel" />
                                        <br>
                                        <b id="ctelInput"></b>
                                    </div>
                                    <div class="regdiv">
                                       <label for="pwd">비밀번호</label>
                                        <input class="form-control" id="pwd2" type="password" name="password" required />
                                    </div>
                                    <div class="regdiv">
                                        <label for="pwdConfirm">비밀번호 확인</label>
                                        <input class="form-control" id="pwdConfirm2" type="password"  required />
                                        <br>
                                        <b id="passInput2"></b>
                                    </div>
                                    <div class="regdiv">
                                        <label for="divcomp">사업체 구분</label>
                                        <input type="radio" name="divcomp" value="일반기업" checked> 일반기업 &nbsp;&nbsp;
                                        <input type="radio" name="divcomp" value="공공기관"> 공공기관 &nbsp;&nbsp;
                                        <input type="radio" name="divcomp" value="사회적기업"> 사회적기업 &nbsp;&nbsp;
                                        <input type="radio" name="divcomp" value="기타">	기타 &nbsp;<input type="text" style="width: 300px;">
                                    </div>
                                    <div class="regdiv">
                                        <label for="jobtype">모집직종</label>
                                        <select id="jobtype" name="jobtype">
                                        	<option value="">모집직종</option>
                                        	<option value="경영·행정·사무직">경영·행정·사무직</option>
											<option value="IT·소프트웨어">IT·소프트웨어</option>
                                        	<option value="교육·법률">교육·법률</option>
                                        	<option value="보건·의료직">보건·의료직</option>
                                        	<option value="예술·디자인·방송직">예술·디자인·방송직</option>
                                        	<option value="여행·숙박">여행·숙박</option>
                                        	<option value="영업·판매직">영업·판매직</option>
                                        	<option value="운전·운송직">운전·운송직</option>
                                        	<option value="생산·단순제조직">생산·단순제조직</option>
                                        	<option value="문화·예술">문화·예술</option>
                                        	<option value="서비스직">서비스직</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
									<div class="regdiv">
										<div class="col-6">
											<%-- name속성값 address1 부터 ~~ address5 까지 입력되어 있는 주소를 모두 합쳐서 DB에 address열에  INSERT 하자. --%>
											
											 
											<input type="text" id="sample4_postcode2" name="addr1" class="form-control" placeholder="우편번호">
											<input type="button" onclick="sample4_execDaumPostcode2()" value="우편번호 찾기" class="form-control"><br>
											
											<input type="text" id="sample4_roadAddress2" name="addr2" placeholder="도로명주소" class="form-control">
											<input type="text" id="sample4_jibunAddress2" placeholder="지번주소" name="addr3" class="form-control">
											
											<span id="guide" style="color:#999;display:none"></span>
											
											<input type="text" id="sample4_detailAddress2" placeholder="상세주소" name="addr4" class="form-control">
											
											<br>
											<b id="addressInput2"></b>
										</div>
										</div>
										</div>
                                    <br>
                                    <b id="jobTypeInput"></b>
                                    <a href="#" onclick="check2(); return false;" type="button" class="bn631-hover bn27">가입하기</a>
									                  <a href="#" type="reset" class="bn631-hover bn27">다시입력</a>
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
			<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
			
			<%-- 회원가입 유효성 검사 체크 --%>
			<script src="<%=request.getContextPath()%>/js/join.js"></script>
			
	</body>
</html>
