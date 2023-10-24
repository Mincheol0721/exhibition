<%@page import="VO.iapplicationVO.AllAppFormVO"%>
<%@page import="VO.appFormVO.AppFormVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="VO.iapplicationVO.CareerExpVO"%>
<%@page import="VO.IMemberVO.IMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8");
   AllAppFormVO vo = null;
   vo = (AllAppFormVO)request.getAttribute("vo");
  
   
%>

<c:choose>	
	
	<c:when test="${requestScope.msg == 'deleted'}">		
		<script>
			window.onload = function(){
				location.href = "${path}/Exhibition/view/mypage/iMypage.jsp";
				alert("입사지원서를 삭제 하였습니다..");
			}
		</script>
	</c:when>	
	</c:choose>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:formatDate pattern="yyyy-MM-dd" value="${career[0].startDate}" var="careerSDate1"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${career[1].startDate}" var="careerSDate2"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${career[2].startDate}" var="careerSDate3"/>

<fmt:formatDate pattern="yyyy-MM-dd" value="${career[0].endDate}" var="careerEDate1"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${career[1].endDate}" var="careerEDate2"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${career[2].endDate}" var="careerEDate3"/>

<fmt:formatDate pattern="yyyy-MM-dd" value="${license[0].getDate}" var="licenseDate1"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${license[1].getDate}" var="licenseDate2"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${license[2].getDate}" var="licenseDate3"/>

<fmt:formatDate pattern="yyyy-MM-dd" value="${training[0].trstartDate}" var="trainingSDate1"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${training[1].trstartDate}" var="trainingSDate2"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${training[2].trstartDate}" var="trainingSDate3"/>

<fmt:formatDate pattern="yyyy-MM-dd" value="${training[0].trendDate}" var="trainingEDate1"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${training[1].trendDate}" var="trainingEDate2"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${training[2].trendDate}" var="trainingEDate3"/>



<!DOCTYPE html>
<html>
	<head>
		<title>입사지원서</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		 <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<noscript><link rel="stylesheet" href="${path}/assets/css/noscript.css" /></noscript>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>	
		
		
		<script type="text/javascript">
		function readURL(input) {//<- onchange이벤트가 발생한  <input type="file">태그를  this키워드에 의해서 매개변수로 전달 받음
			
			console.debug( input ); //크롬 웹브라우저 F12버튼 눌러  개발자모드창의 console탭에서 출력되는지 확인 
			console.log( input.files );
			/*
				참고:
				<input type="file">인 태그 객체의 files메소드를 호출하면 ~~
				FileList라는 배열이 생성되면서 FileList배열 내부의 0번째 index위치에.....
				아래에서 선택한 (업로드할) 파일정보들을 key:value한쌍의 형태 로 묶어 저장한 File객체가 저장되어 있음 
			*/
			
		//FileList배열이 존재하고(선택한 업로드할 파일이 존재하고)
		//FIleList라는 배열의 0번째 인덱스 위치에 아래에서 파일업로드를 위해 선택한 File객체가 저장되어 있다면?
		//요약 : 아래의 <input type="file">태그에서 이미지 파일업로드를 위해 선택한 파일이 있다면?
	      if (input.files && input.files[0]) {
	    	  
	    	  //id속성의 값이 tdImg인 <td id="tdImg"></td>태그를 선택해서     
	    	   //동적으로 <img>태그를 만들어서  추가함
	    	  $("#tdImg").replaceWith("<img id='preview' src='#' width=200 height=150 class='img-thumbnail' name ='imgview'/>");
	    	  
	    	  //파일의 정보를 읽어올 객체 생성
		      var reader = new FileReader();
	    	  
	    	  //지정한 img태그에 첫번째 파일 input에 첨부한 파일에 대한 File객체의 정보를 읽어들입니다.
	    	  reader.readAsDataURL(input.files[0]);
	    	  
	    	  //첨부한 File객체의 정보를 모두 읽어 들였다면 function익명할수가 호출됩니다. 
		      reader.onload = function (ProgressEvent) {//읽어 들인 File객체 정보는 매개변수로 넘어오는 ProgressEvent객체 내부의?
		    		  						            //target속성에 대응 되는 JSON객체데이터로 저장되어 있다.
		    		  						            //또한  JSON객체 데이터 내부에는 result속성에  읽어들인 File객체 정보가 저장되어 있다.
		    		 console.log(ProgressEvent); 						            
	    		
		      		//동적으로 만든 <img>태그를 선택해서  attr메소드를 이용해 파일 첨부시 미리보기 이미지를 나타내기 위해
		      		//src속성에 new FileReader()객체를 이용하여 읽어 들인 첨부한 File객체 정보를 지정하여 추가함으로써
		      		//이미지 파일의 미리보기 기능이 가능한 것이다.
	    		     $("#preview").attr("src", ProgressEvent.target.result);
	    		     
	          }
	   
	      }
	  }  
		
		
		</script>
			

		<style type="text/css">
			.regdiv > label {width: 20%; text-align: justify;}
			.clause {box-sizing: border-box;}
			.bn632-hover {
			  width: 160px;
			  font-size: 15px;
			  font-weight: 30;
			  color: #fff;
			  cursor: pointer;
			  margin: 10px;
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
								<h1><a href="index.jsp" id="logo">입사지원서</a></h1>
							</header>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<jsp:include page="/inc/menu.jsp" />
						</nav>

				</div>

			<!-- Main -->
				<div class="wrapper style1">
					<div class="position-relative">
              			
                        <div class="container">
                        <form action="${path}/memberInfo/addRegister.me" method="post" enctype="multipart/form-data">
                        
                        	<div class="row justify-content-center">
                        <div class="input-group flex-nowrap mt-2 mb-2">
                        
                        	<span class="input-group-text" id="addon-wrapping">인적사항</span>
						<img src="${path}/upload/<%=vo.getFileRealName()%>" class="img-thumbnail" alt="사진없음" height="150px" width="200px" id="tdImg" name="imgview">
					<div class="col justify-content-center">
					<span class="input-group-text" id="addon-wrapping">
					<label for="name">이름</label>
					<input type="text" id="name" class="form-control" aria-describedby="addon-wrapping" name="name" value="${vo.getName()}" readonly="readonly">
					<label for="ssn">주민등록번호</label>
					<input type="text" id="ssn" class="form-control" aria-describedby="addon-wrapping" name="ssn" value="<%=vo.getSsn()%>" readonly="readonly">
					
					</span>
					<span class="input-group-text" id="addon-wrapping">
					<label for="address">주소</label>
					<input type="text" id="sample4_postcode" name="address1" class="form-control" placeholder="우편번호" hidden="" value="<%=vo.getAddr1()%>">
					
					<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소" class="form-control" value="<%=vo.getAddr2()%>" style="flex: 90em">
					<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="address3" class="form-control" hidden="" value="<%=vo.getAddr3()%>">
					<span id="guide" style="color:#999;display:none"></span>
					<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address4" class="form-control" style="flex: 140em" value="<%=vo.getAddr4()%>">
					<input type="button" onclick="sample4_execDaumPostcode()" value="검색" class="form-control" width="10px">
					</span>
				
					<span class="input-group-text" id="addon-wrapping">
					<label for="tel">연락처</label>
					<input style="width: 300px" type="text" id="tel" class="form-control" aria-describedby="addon-wrapping" name="tel" value="<%=vo.getItel()%>" >
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label for="">병역사항</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
		              <input type="radio" name="milServ" value="전역" checked> 전역 &nbsp;&nbsp;
		              <input type="radio" name="milServ" value="미필"> 미필 &nbsp;&nbsp;
		              <input type="radio" name="milServ" value="면제"> 면제 &nbsp;&nbsp;
		              <input type="radio" name="milServ" value="해당사항 없음"> 해당사항없음 &nbsp;&nbsp;
					</span>
		
					<span class="input-group-text" id="addon-wrapping">
						<label>최종학력</label>
						<input style="width: 300px;" type="text" id="edu" class="form-control" aria-describedby="addon-wrapping" name="edu" value="${appForm[0].edu}" >
							<label for="eduStat">재학상태</label>
						<select id="eduStat" name="eduStat">
	                       	<option value="무학" >무학</option>
	                       	<option value="재학">재학</option>
	                       	<option value="졸업">졸업</option>
	                       	<option value="휴학">휴학</option>
	                       	<option value="중퇴">중퇴</option>
                       </select>
					
					</span>
				</div>		  
           		</div>
				</div>
				<label for="file">사진변경</labeL>
                <input type="file" id="changePic" name="file" value="사진변경" onchange="readURL(this)">	    	
					    <!-- 경력사항 -->	
					    	<div class="row justify-content-center">
                        <div class="input-group flex-nowrap mt-2 mb-2">
                        	<span class="input-group-text" id="addon-wrapping" style="height: 254px; width: 200px">경력사항</span>
								
					<div class="col justify-content-center">
					<table style="border-collapse: collapse; border: 1px solid black;  background-color: gray">
						<tr>
							<td width="22%" style="text-indent: 4em">이름</td>
						    <td width="15%">사업체명</td>
						    <td>근무 시작 일시</td>
						    <td>근무 종료 일시</td>
							<td>담당 업무</td>
						</tr>
					</table>
					
					
					<!-- 경력사항 인풋1 -->
					<span class="input-group-text" id="addon-wrapping">
					<input type="text" id="no1" class="form-control" aria-describedby="addon-wrapping" name="no1" value="${career[0].no}" hidden="">
					<input type="text" id="careerName1" class="form-control" aria-describedby="addon-wrapping" name="careerName1" value="${career[0].carName}" >
					<input type="text" id="careerCname1" class="form-control" aria-describedby="addon-wrapping" name="careerCname1" value="${career[0].carcName}" >
					<input type="date" id="careerStartDate1" class="form-control" aria-describedby="addon-wrapping" name="careerStartDate1" value="${careerSDate1}" max="9999-12-31">
					<input type="date" id="careerEndDate1" class="form-control" aria-describedby="addon-wrapping" name="careerEndDate1" value="${careerEDate1}" >
					<input style="width: 300px" type="text" id="damdang1" class="form-control" aria-describedby="addon-wrapping" name="damdang1" value="${career[0].damdang}" >
					</span>															
					<!-- 경력사항 인풋2 -->
					<span class="input-group-text" id="addon-wrapping">
					<input type="text" id="no2" class="form-control" aria-describedby="addon-wrapping" name="no2" value="${career[1].no}" hidden="">
					<input type="text" id="careerName2" class="form-control" aria-describedby="addon-wrapping" name="careerName2" value="${career[1].carName}" >
					<input type="text" id="careerCname2" class="form-control" aria-describedby="addon-wrapping" name="careerCname2" value="${career[1].carcName}" >
					<input type="date" id="careerStartDate2" class="form-control" aria-describedby="addon-wrapping" name="careerStartDate2" value="${careerSDate2}" max="9999-12-31">
					<input type="date" id="careerEndDate2" class="form-control" aria-describedby="addon-wrapping" name="careerEndDate2" value="${careerEDate2}" >
					<input style="width: 300px" type="text" id="damdang2" class="form-control" aria-describedby="addon-wrapping" name="damdang2" value="${career[1].damdang}" >
					</span>
					<!-- 경력사항 인풋3 -->
					<span class="input-group-text" id="addon-wrapping">
					<input type="text" id="no2" class="form-control" aria-describedby="addon-wrapping" name="no3" value="${career[2].no}" hidden="">
					<input type="text" id="name" class="form-control" aria-describedby="addon-wrapping" name="careerName3" value="${career[2].carName}" >
					<input type="text" id="cname" class="form-control" aria-describedby="addon-wrapping" name="careerCname3" value="${career[2].carcName}" >
					<input type="date" id="startDate" class="form-control" aria-describedby="addon-wrapping" name="careerStartDate3" value="${careerSDate3}" max="9999-12-31">
					<input type="date" id="endDate" class="form-control" aria-describedby="addon-wrapping" name="careerEndDate3" value="${careerEDate3}" >
					<input style="width: 300px" type="text" id="damdang3" class="form-control" aria-describedby="addon-wrapping" name="damdang3" value="${career[2].damdang}" >
					</span>
					
				</div>
				</div>
				</div>
					 <!-- 자격면허 -->	
					    	<div class="row justify-content-center">
                        <div class="input-group flex-nowrap mt-2 mb-2">
                        	<span class="input-group-text" id="addon-wrapping" style="height: 254px; width: 200px">자격증</span>
								
					<div class="col justify-content-center">
					<table style="border-collapse: collapse; border: 1px solid black;  background-color: gray">
						<tr>
							 <td width="25%" style="text-indent: 4em">이름</td>
						    <td width="18%">종목</td>
						    <td style="text-indent: -2em">등록 번호</td>
						    <td>발급 일자</td>
						     <td>발행처</td>
						</tr>
					</table>
					<!-- 자격면허 인풋1 -->
					<span class="input-group-text" id="addon-wrapping">
					<input type="text" id="licenseName1" class="form-control" aria-describedby="addon-wrapping" name="licenseName1" value="${license[0].liname}" >
					<input type="text" id="lname1" class="form-control" aria-describedby="addon-wrapping" name="lname1" value="${license[0].lname}" >
					<input type="text" id="lnum1" class="form-control" aria-describedby="addon-wrapping" name="lnum1" value="${license[0].lnum }" >
					<input type="date" id="getDate" class="form-control" aria-describedby="addon-wrapping" name="getDate1" value="${licenseDate1}" >
					<input style="width: 300px" type="text" id="pub" class="form-control" aria-describedby="addon-wrapping" name="pub1" value="${license[0].pub}" >
					</span>
					<!-- 자격면허 인풋2 -->
					<span class="input-group-text" id="addon-wrapping">
					<input type="text" id="licenseName2" class="form-control" aria-describedby="addon-wrapping" name="licenseName2" value="${license[1].liname}" >
					<input type="text" id="lname2" class="form-control" aria-describedby="addon-wrapping" name="lname2" value="${license[1].lname}" >
					<input type="text" id="lnum2" class="form-control" aria-describedby="addon-wrapping" name="lnum2" value="${license[1].lnum}" >
					<input type="date" id="getDate2" class="form-control" aria-describedby="addon-wrapping" name="getDate2" value="${licenseDate2}" >
					<input style="width: 300px" type="text" id="pub2" class="form-control" aria-describedby="addon-wrapping" name="pub2" value="${license[1].pub}" >
					</span>
					<!-- 자격면허 인풋3 -->
					<span class="input-group-text" id="addon-wrapping">
					<input type="text" id="licenseName3" class="form-control" aria-describedby="addon-wrapping" name="licenseName3" value="${license[2].liname}" >
					<input type="text" id="lname3" class="form-control" aria-describedby="addon-wrapping" name="lname3" value="${license[2].lname}" >
					<input type="text" id="lnum3" class="form-control" aria-describedby="addon-wrapping" name="lnum3" value="${license[2].lnum}">
					<input type="date" id="getDate" class="form-control" aria-describedby="addon-wrapping" name="getDate3" value="${licenseDate3}" >
					<input style="width: 300px" type="text" id="pub3" class="form-control" aria-describedby="addon-wrapping" name="pub3" value="${license[2].pub}" >
					</span>
					
					
				</div>
				</div>
				</div>
				
				 <!-- 교육 및 훈련 -->	
					    	<div class="row justify-content-center">
                        <div class="input-group flex-nowrap mt-2 mb-2">
                        	<span class="input-group-text" id="addon-wrapping" style="height: 254px; width: 200px">교육 및 훈련</span>
								
					<div class="col justify-content-center">
					<table style="border-collapse: collapse; border: 1px solid black;  background-color: gray">
						<tr>
							
						    <td width="18%" style="text-indent: 4em">이름</td>
						    <td>교육 기관</td>
						    <td style="text-indent: -2em">교육 시작 일시</td>
						    <td style="text-indent: -4em">교육 종료 일시</td>
						    <td style="text-indent: -2em">교육 내용</td>
						</tr>
					</table>
					<!-- 교육 및 훈련 인풋1 -->
					<span class="input-group-text" id="addon-wrapping">
					<input type="text" id="tno1" class="form-control" aria-describedby="addon-wrapping" name="tno1" value="${training[0].tno}" hidden="">
					<input type="text" id="tname1" class="form-control" aria-describedby="addon-wrapping" name="tname1" value="${training[0].trname}" >
					<input type="text" id="eduName1" class="form-control" aria-describedby="addon-wrapping" name="eduName1" value="${training[0].eduName}" >
					<input type="date" id="tStartDate1" class="form-control" aria-describedby="addon-wrapping" name="tStartDate1" value="${trainingSDate1}" >
					<input type="date" id="tEndDate1" class="form-control" aria-describedby="addon-wrapping" name="tEndDate1" value="${trainingEDate1}" >
					<input style="width: 300px" type="text" id="content1" class="form-control" aria-describedby="addon-wrapping" name="content1" value="${training[0].content}" >
					</span>					
					<!-- 교육 및 훈련 인풋2 -->
					<span class="input-group-text" id="addon-wrapping">
					<input type="text" id="tno2" class="form-control" aria-describedby="addon-wrapping" name="tno2" value="${training[1].tno}" hidden="">
					<input type="text" id="tname2" class="form-control" aria-describedby="addon-wrapping" name="tname2" value="${training[1].trname}" >
					<input type="text" id="eduName2" class="form-control" aria-describedby="addon-wrapping" name="eduName2" value="${training[1].eduName}">
					<input type="date" id="tStartDate2" class="form-control" aria-describedby="addon-wrapping" name="tStartDate2" value="${trainingSDate2}" >
					<input type="date" id="tEndDate2" class="form-control" aria-describedby="addon-wrapping" name="tEndDate2" value="${trainingEDate2}" >
					<input style="width: 300px" type="text" id="content2" class="form-control" aria-describedby="addon-wrapping" name="content2" value="${training[1].content}" >
					</span>
					<!-- 교육 및 훈련 인풋3 -->
					<span class="input-group-text" id="addon-wrapping">
					<input type="text" id="tno3" class="form-control" aria-describedby="addon-wrapping" name="tno3" value="${training[2].tno}" hidden="">
					<input type="text" id="tname3" class="form-control" aria-describedby="addon-wrapping" name="tname3" value="${training[2].trname}" >
					<input type="text" id="eduName3" class="form-control" aria-describedby="addon-wrapping" name="eduName3" value="${training[2].eduName}">
					<input type="date" id="tStartDate3" class="form-control" aria-describedby="addon-wrapping" name="tStartDate3" value="${trainingSDate3}" >
					<input type="date" id="tEndDate3" class="form-control" aria-describedby="addon-wrapping" name="tEndDate3" value="${trainingEDate3}" >
					<input style="width: 300px" type="text" id="content3" class="form-control" aria-describedby="addon-wrapping" name="content3" value="${training[2].content}" >
					</span>
					
					
				</div>
				
				</div>
				<div id="regBtn"> 
					<button class="bn632-hover bn27" name="registerBtn" id="registerBtn" class="regType" value="등록하기">등록하기</button>
					<button class="bn632-hover bn27" name="backList"  class="regType" value="목록으로" type="button" id="backList">목록으로</button>
					
				</div>
				</div>
				</form>
				<button class="bn632-hover bn27"  id="delBtn" class="regType" value="삭제하기">삭제하기</button>
			</div>	
			</div>
		
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
			
			
			<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
			
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
		<script type="text/javascript">
			$("#registerBtn").on('click',function(){
				location.href = "http://localhost:8090/Exhibition/memberInfo/addRegister.me";
			})
			$("#backList").on('click',function(){
				location.href = "http://localhost:8090/Exhibition/view/mypage/iMypage.jsp";
			})
			$("#delBtn").on('click',function(){
				location.href = "http://localhost:8090/Exhibition/memberInfo/delAppForm.do?name=${vo.getName()}";
				
			})
			
			 $("input[type='radio'][value=${appForm[0].milServ}]").attr("checked", true);
                                    	
			$("option[value = ${appForm[0].eduStat}]").attr("selected", true);
			
			
		</script>
	</body>
</html>
