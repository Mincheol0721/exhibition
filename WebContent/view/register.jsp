<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="path" value="<%=request.getContextPath()%>" />

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
							<jsp:include page="../inc/menu.jsp" />
						</nav>

				</div>

			<!-- Main -->
				<div class="wrapper style1">

					<div class="container">
						<article id="main" class="special">
							<header>
								
								<h2>회원가입</h2>
								<div>
									<button class="bn632-hover bn27" class="regType" value="개인회원">개인회원</button>
									<button class="bn632-hover bn27" class="regType" value="기업회원">기업회원</button>
								</div>
								<form action="login.jsp" class="indReg">
									<textarea rows="20" cols="150" >
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
									개인정보 수집 및 이용에 동의합니다. <input type="checkbox" name="clause"> 
									<br>
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
                                    <div class="regdiv">
                                        <label for="pwdConfirm">비밀번호 확인</label>
                                        <input class="form-control" id="pwdConfirm" type="password"  required />
                                    </div>
                                    <div class="regdiv">
                                        <label for="name">이름</label>
                                        <input class="form-control" id="name" type="text" name="name" />
                                    </div>
                                    <div class="regdiv">
                                        <label for="mobile">전화번호</label>
                                        <input class="form-control" id="tel" type="tel" name="tel" />
                                    </div>
                                    <div class="regdiv">
                                        <label for="ssn">주민등록번호</label>
                                        <input class="form-control" id="ssn" type="text" name="ssn" />
                                    </div>
                                    <div class="regdiv">
                                        <label for="email">이메일</label>
                                        <input class="form-control" id="email" type="email" name="email" />
                                    </div>
                                    <div class="regdiv">
                                        <label for="addr">주소</label>
                                        <input class="form-control" id="addr" type="text" name="addr" />
                                    </div>
                                    <input type="submit" value="가입하기">
                                    <input type="reset" value="다시작성">
								</form>
								<form action="login.jsp" class="compReg">
									<textarea rows="20" cols="150" >
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
									개인정보 수집 및 이용에 동의합니다. <input type="checkbox" name="clause"> 
									<br>
									<br>
									<br>
									<br>
									
									<div class="regdiv">
                                        <label for="id">사업자등록번호<span><small id="chkId"></small></span></label>
                                        <input class="form-control" id="id" type="text" name="id" />
                                    </div>
                                    <div class="regdiv">
                                        <label for="name">대표자명</label>
                                        <input class="form-control" id="name" type="text" name="name" />
                                    </div>
                                    <div class="regdiv">
                                        <label for="mobile">회사 전화번호</label>
                                        <input class="form-control" id="tel" type="tel" name="tel" />
                                    </div>
                                    <div class="regdiv">
                                       <label for="pwd">비밀번호</label>
                                        <input class="form-control" id="pwd" type="password" name="pwd" required />
                                    </div>
                                    <div class="regdiv">
                                        <label for="pwdConfirm">비밀번호 확인</label>
                                        <input class="form-control" id="pwdConfirm" type="password"  required />
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
                                    <input type="submit" value="가입하기">
                                    <input type="reset" value="다시작성">
								</form>
							</header>
					</div>

				</div>

			<!-- Footer -->
				<div id="footer">
					<jsp:include page="../inc/footer.jsp" />
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