
// 		$("input").keyup(function(){
// 	    	//모든<p>요소들의 text값을 빈공백으로 설정해 없애 준다.
// 	    	$("p").text("");
// 	    });
	    
	  	//약관동의 체크박스를 클릭했을때..
	    $("#clause").click(function(){
	    	
    		if( !($("#clause").is(":checked")) ){ 
   	    		$("#agreeInput").text("약관에 동의해 주세요!").css("color","red");
   	    		
   	    	}else{
	    	$("#agreeInput").css("display","none");
   	    	}
	   	});
	   
	    $("#id").focusout(function() {
				
	    	if($("#id").val().length >= 3 && $("#id").val().length < 20 ){
	    		
	    		//입력한 아이디가 DB에 저장되어 있는지 없는지 확인 요청
	    		//Ajax기술을 이용 하여 비동기 방식으로 MemberController로 합니다.
	    		$.ajax({
	    			url : "http://localhost:8090/Exhibition/Join/joinIdCheck.me", //요청할 주소
	    			type : "post",  //전송요청방식 설정! get 또는 post 둘중 하나를 작성
	    			async : true,  //true는 비동기방식 , false는 동기방식 으로 서버페이지 요청!
	    			data : {id : $("#id").val()}, //서버 페이지로 요청할 변수명 : 값
	    			dataType : "text", //서버페이지로 부터 응답 받을 데이터 종류 설정!
	    							   //종류는 json 또는 xml 또는 text중 하나 설정!
	    			
	    			//전송요청과 응답통신에 성공했을때
	    			//success 속성에 적힌 function(data,textStatus){}이 자동으로 호출된다.
	    			// data매개변수로는 서버페이지가 전달한 응답 데이터가 넘어옵니다.
	    			success : function(data,textStatus){
	    				//서버페이지에서 전송된 아이디 중복? 인지 아닌지 판단하여
	    				//현재 join.jsp화면에 보여주는 처리 구문 작성
	    				if(data=='usable'){ //아이디가 DB에 없으면?
	    					$("#idInput").text("사용할 수 있는 ID 입니다.").css("color","blue");
	    				}else{ //아이디가 DB에 있으면?
	    					$("#idInput").text("이미 사용중인 ID입니다.").css("color","red");
	    				}
	    				
	    			}
	    			
	    		});
	    		
    		}else{
    			$("#idInput").text("한글,특수문자 없이 3~20글자사이로 작성해 주세요!").css("color","red");
    		}
		});
		$("#pwd").focusout(function(){
			if($("#pwd").val().length < 4 ){
			
    			$("#passInput").text("한글,특수문자 없이 4글자 이상으로 작성해 주세요!").css("color","red");
    		}else {
    			$("#passInput").text("올바르게 입력되었습니다.").css("color","blue");
    		}
    			
    		
		});
		$("#pwdConfirm").focusout(function(){
			if ($("#pwd").val() != $("#pwdConfirm").val()) {
				$("#passInput").text("비밀번호가 일치하지 않습니다.").css("color","red");
			}else {
				$("#passInput").text("비밀번호가 일치합니다.").css("color","blue");
			}
		});
	    $("#name").focusout(function(){
	    	if($("#name").val().length < 2 || $("#name").val().length > 6 ){
    			$("#nameInput").text("이름을 제대로 작성하여주세요.").css("color","red");
    		}else{
    			$("#nameInput").text("이름입력완료!").css("color","blue");
    		}
	    });
	   
	   
	    $("#email").focusout(function() {
			var mail = $("#email");
    		var mailValue = mail.val();
    		var mailReg = /^\w{5,12}@[a-z]{2,10}[\\.][a-z]{2,3}[\\\\.]?[a-z]{0,2}$/;
    		var rsEmail = mailReg.test(mailValue);
    		
	    	if(!rsEmail){
    			$("#emailInput").text("이메일 형식이 올바르지 않습니다.").css("color","red");
    			
    		}else{
    			$("#emailInput").text("올바르게 입력되었습니다.").css("color","blue");
    		}
	    });
	    $("#tel").focusout(function() {
			var t = $("#tel");
    		var telVal = t.val();
    		var tReg = RegExp(/^0[0-9]{8,10}$/);
    		var rsTel = tReg.test(telVal);
    		if(!rsTel){
    			$("#telInput").text("전화번호 형식이 올바르지 않습니다.").css("color","red");
    		}else{
    			$("#telInput").text("올바르게 입력되었습니다.").css("color","blue");
    		}	
	    });
	    //123456-7890123
	    //6자리		7자리
	    $("#ssn").focusout(function() {
	    	var ssnValue = $("#ssn").val();
	    	ssnValue = ssnValue.split('');
	    	var chkArr = [2,3,4,5,6,7,8,9,2,3,4,5]; //곱해줄 숫자 배열
	    	var ssnLast = ssnValue[ssnValue.length-1];
	    	//1. 각자리에 2,3,4,5,6,7,8,9,2,3,4,5를 곱해줌. 단 마지막 자리는 빼놓음
	    	for (var i = 0; i < ssnValue.length; i++) {
				ssnValue[i] = ssnValue[i] * chkArr[i];
			}
	    	 // 주민등록번호 마지막자리 따로 빼두기
//	    	alert(ssnValue);
	    	//2. 각 자리의 숫자를 모두 더함
	    	var sum = 0;
	    	for (var i = 0; i < ssnValue.length - 1; i++) {
				sum += ssnValue[i];
			}
	    	//3. 11로 나눈 나머지 값을 구함
	    	sum = sum % 11;
	    	
	    	//4. 11에서 결과값을 뺌(단,마지막 결과가 두자리인 경우 다시 10으로 나눈 나머지 값을 구함)
	    	
	    	sum = 11- sum;
	    	
	    	//5. 결과가 주민등록번호 마지막 자리와 일치하면 유효한 주민등록번호임
	    	if(sum == ssnLast) {
	    		$("#ssnInput").text("유효한 주민등록번호 입니다.").css("color","blue");
	    	}
	    	if(sum != ssnLast && ssnLast != undefined) {
	    		$("#ssnInput").text("유효하지 않은 주민등록번호 입니다.").css("color","red");
	    	}
	    });
	    
// 	   $("#sample4_extraAddress",
// 			   "#sample4_postcode",
// 			   "#sample4_roadAddress",
// 			   "#sample4_jibunAddress",
// 			   "#sample4_detailAddress").focusout(function() {
//     		var adVal1 = $("#sample4_postcode").val();
//     		var adVal2 = $("#sample4_roadAddress").val();
//     		var adVal3 = $("#sample4_jibunAddress").val();
//     		var adVal4 = $("#sample4_detailAddress").val();
//     		var adVal5 = $("#sample4_extraAddress").val();
//     		if(adVal1 == "" || adVal2 == "" || adVal3 == "" || adVal4 == "" || adVal5 == ""){
//     			$("#addressInput").text("주소를 모두 작성하여주세요.").css("color","red");
//     		}else{
//     			$("#addressInput").text("올바르게 입력되었습니다.").css("color","blue");
//     		}
// 	    });
	    $("input[name='address1'],input[name='address2'],input[name='address3'],input[name='address4'],input[name='address5']").focusout(function() {
		    		if(	$("input[name='address1']").val()== "" || 
	    				$("input[name='address2']").val()== "" ||
	    				$("input[name='address3']").val()== "" ||
	    				$("input[name='address4']").val()== "" ){
	    				
	    			$("#addressInput").text("주소를 모두 작성하여주세요.").css("color","red");
	    		}else{
	    			$("#addressInput").css("display","none");
	    		}
		    });
	
	
		function check() {
			
			//약관동의 <input>요소를 선택해서 가져와 
   	    	var checkbox = $("#clause");
   	    	//약관동의 체크했는지 검사
   	    	//선택한 <input type="checkbox">체크박스에 체크가 되어 있지 않으면? 
   	    	//true를 리턴 해서 조건에 만족 합니다. 
   	    	if( !(checkbox.is(":checked")) ){ //== 같은 true값을 반환 한다. if(!$("#agree").prop("checked"))
   	    		$("#agreeInput").text("약관에 동의해 주세요!").css("color","red");
   	    		checkbox.focus();
   	    		return false;
   	    	}
   	    	//====================================================================================================
   	    		
   	    	var id = $("#id");
   	    	var idValue = id.val();
   	    	
   	    	var idReg = RegExp(/^[A-Za-z0-9_\-]{3,20}$/);
   	    	var resultId = idReg.test(idValue);
   	    	
    		if(!resultId){
    			$("#idInput").text("한글,특수문자 없이 3~20글자사이로 작성해 주세요!").css("color","red");
    			id.focus();
    			
    			return false;
    		}
   	    	
    		//====================================================================================================
	    		
   	    	var pwd = $("#pwd");
   	    	var passValue = pwd.val();
   	    	
   	    	var passReg = RegExp(/^[A-Za-z0-9_\-]{4,20}$/);
   	    	var resultPass = passReg.test(passValue);

    		if(!resultPass){
    			$("#passInput").text("한글,특수문자 없이 4글자 이상으로 작성해 주세요!").css("color","red");
    			pwd.focus();
    			
    			return false;
    		}else{
    			$("#passInput").text("올바르게 입력되었습니다.").css("color","blue");
    		}
    		
    		//====================================================================================================
    		
    		var pwdConfirm = $("#pwdConfirm");
   	    	
   	    	
   	    	

    		if($("#pwd").val() != $("#pwdConfirm").val()){
    			$("#passInput").text("비밀번호가 일치하지 않습니다.").css("color","red");
    			pwdConfirm.focus();
    			
    			return false;
    		}else{
    			$("#passInput").text("비밀번호가 일치합니다.").css("color","blue");
    		}
    		
    		
    		
    		//====================================================================================================
    		var name = $("#name");
   	    	var nameValue = name.val();
   	    	
   	    	var nameReg = RegExp(/^[가-힣]{2,6}$/);
   	    	var resultName = nameReg.test(nameValue);

    		if(!resultName){
    			$("#nameInput").text("이름을 한글로 작성하여주세요.").css("color","red");
    			name.focus();
    			
    			return false;
    		}else{
    			$("#nameInput").text("올바르게 입력되었습니다.").css("color","blue");
    		}
    		
    		//====================================================================================================
    		var tel = $("#tel");
    		
    		var telValue = tel.val();
    		
    		var telReg = RegExp(/^0[0-9]{8,10}$/);
    		
    		var resultTel = telReg.test(telValue);
    		
    		if(!resultTel){
    			$("#telInput").text("전화번호 형식이 올바르지 않습니다.").css("color","red");
    			
    			tel.focus();
    			
    			return false;
    		}else{
    			$("#telInput").text("올바르게 입력되었습니다.").css("color","blue");
    		}	
    		
			//====================================================================================================
					var ssn = $("#ssn");
    		    	var ssnValue = $("#ssn").val();
    		    	ssnValue = ssnValue.split('');
    		    	var chkArr = [2,3,4,5,6,7,8,9,2,3,4,5]; //곱해줄 숫자 배열
    		    	var ssnLast = ssnValue[ssnValue.length-1];
    		    	//1. 각자리에 2,3,4,5,6,7,8,9,2,3,4,5를 곱해줌. 단 마지막 자리는 빼놓음
    		    	for (var i = 0; i < ssnValue.length; i++) {
    					ssnValue[i] = ssnValue[i] * chkArr[i];
    				}
    		    	
    		    	 // 주민등록번호 마지막자리 따로 빼두기
//    		    	alert(ssnValue);
    		    	//2. 각 자리의 숫자를 모두 더함
    		    	var sum = 0;
    		    	for (var i = 0; i < ssnValue.length - 1; i++) {
    					sum += ssnValue[i];
    				}
    		    	 
    		    	//3. 11로 나눈 나머지 값을 구함
    		    	sum = sum % 11;
    		    	
    		    	//4. 11에서 결과값을 뺌(단,마지막 결과가 두자리인 경우 다시 10으로 나눈 나머지 값을 구함)
    		    	
    		    	sum = 11- sum;
    		    	
    		    	//5. 결과가 주민등록번호 마지막 자리와 일치하면 유효한 주민등록번호임
    		    	if(sum == ssnLast) {
    		    		$("#ssnInput").text("유효한 주민등록번호 입니다.").css("color","blue");
    		    	}
    		    	if(sum != ssnLast && ssnLast != undefined ) {
    		    		$("#ssnInput").text("유효하지 않은 주민등록번호 입니다.").css("color","red");
    		    		ssn.focus();
    		    		return false;
    		    	}
    		    	
    		    	if(ssnLast == undefined ) {
    		    		$("#ssnInput").text("유효하지 않은 주민등록번호 입니다.").css("color","red");
    		    		ssn.focus();
    		    		return false;
    		    	}
    		    		
    		    	//====================================================================================================
    				
    				var email = $("#email");
    	    		
    	    		var emailValue = email.val();
    	    		
    	    		var emailReg = /^\w{5,12}@[a-z]{2,10}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/;
    	    		
    	    		var resultEmail = emailReg.test(emailValue);
    	    		
    	    		if(!resultEmail){
    	    			$("#emailInput").text("이메일 형식이 올바르지 않습니다.").css("color","red");
    	    			
    	    			email.focus();
    	    			
    	    			return false;
    	    		}else{
    	    			$("#emailInput").text("올바르게 입력되었습니다.").css("color","blue");
    	    		}	   		
    		    		
    		    	
    		
    		    	  	
    		//====================================================================================================

    		var address1 = $("#sample4_postcode");
    		var address2 = $("#sample4_roadAddress"); 
    		var address3 = $("#sample4_jibunAddress")
    		var address4 = $("#sample4_detailAddress");
    		
    		var addVal1 = address1.val();
    		var addVal2 = address2.val();
    		var addVal3 = address3.val();
    		var addVal4 = address4.val();
    		
    		if(addVal1 == "" || addVal2 == "" || addVal3 == "" || addVal4 == "" ){
    			$("#addressInput").text("주소를 모두 작성하여주세요.").css("color","red");
    			address4.focus();
    			
    			return false;
    		}else{
    			$("#addressInput").text("올바르게 입력되었습니다.").css("color","blue");
    		}
    			
    		
    		
    			
			//====================================================================================================
			
			
			
    		
    		
    		alert("회원가입이 완료 되었습니다.");
   	    	
   	    	
   	    	$(".indReg").submit();
   	    	
			
		}
	
		//1111=====================================================================================================
		//약관동의 체크박스를 클릭했을때..
	    $("#clause2").click(function(){
	    	
    		if( !($("#clause2").is(":checked")) ){ 
   	    		$("#agreeInput2").text("약관에 동의해 주세요!").css("color","red");
   	    		
   	    	}else{
	    	$("#agreeInput2").css("display","none");
   	    	}
	   	});
	   
	    $("#cno").focusout(function() {
			
	    	if( /^[0-9]{3}-[0-9]{2}-[0-9]{5}$/.test( $("#cno").val() ) ){
	    		
	    		//입력한 아이디가 DB에 저장되어 있는지 없는지 확인 요청
	    		//Ajax기술을 이용 하여 비동기 방식으로 MemberController로 합니다.
	    		$.ajax({
	    			url : "http://localhost:8090/Exhibition/Join/joinCnoCheck.me", //요청할 주소
	    			type : "post",  //전송요청방식 설정! get 또는 post 둘중 하나를 작성
	    			async : true,  //true는 비동기방식 , false는 동기방식 으로 서버페이지 요청!
	    			data : {cno : $("#cno").val()}, //서버 페이지로 요청할 변수명 : 값
	    			dataType : "text", //서버페이지로 부터 응답 받을 데이터 종류 설정!
	    							   //종류는 json 또는 xml 또는 text중 하나 설정!
	    			
	    			//전송요청과 응답통신에 성공했을때
	    			//success 속성에 적힌 function(data,textStatus){}이 자동으로 호출된다.
	    			// data매개변수로는 서버페이지가 전달한 응답 데이터가 넘어옵니다.
	    			success : function(data,textStatus){
	    				//서버페이지에서 전송된 사업자등록번호 중복? 인지 아닌지 판단하여
	    				//현재 join.jsp화면에 보여주는 처리 구문 작성
	    				
	    				if(data=='checkOk'){ //사업자등록번호가 DB에 없으면?
	    					
	    					$("#cnoInput").text("사용할 수 있는 사업자번호 입니다.").css("color","blue");
	    					
	    				}else { //사업자등록번호가 DB에 있으면?
	    					
	    					$("#cnoInput").text("이미 사용중인 사업자번호 입니다.").css("color","red");
	    				}
	    				
	    			}
	    			
	    		});
	    		
    		}else{
    			$("#cnoInput").text("사업자번호를 다시 입력해주세요").css("color","red");
    		}
		});
	    $("#name2").focusout(function(){
	    	if($("#name2").val().length < 2 || $("#name").val().length > 6 ){
    			$("#nameInput2").text("이름을 제대로 작성하여주세요.").css("color","red");
    		}else{
    			$("#nameInput2").text("이름입력완료!").css("color","blue");
    		}
	    });
	    
		$("#pwd2").focusout(function(){
			if($("#pwd2").val().length < 4 ){
			
    			$("#passInput2").text("한글,특수문자 없이 4글자 이상으로 작성해 주세요!").css("color","red");
    		}else {
    			$("#passInput2").text("올바르게 입력되었습니다.").css("color","blue");
    		}
    			
    		
		});
		$("#pwdConfirm2").focusout(function(){
			if ($("#pwd2").val() != $("#pwdConfirm2").val()) {
				$("#passInput2").text("비밀번호가 일치하지 않습니다.").css("color","red");
			}else {
				$("#passInput2").text("비밀번호가 일치합니다.").css("color","blue");
			}
		});
	    $("#cname").focusout(function(){
	    	if($("#cname").val().length < 1 || $("#cname").val().length > 10 ){
    			$("#cnameInput").text("회사명을 제대로 작성하여주세요.").css("color","red");
    		}else{
    			$("#cnameInput").text("회사명입력완료!").css("color","blue");
    		}
	    });
	   
	   
	   
	    $("#ctel").focusout(function() {
			var t = $("#ctel");
    		var telVal = t.val();
    		var tReg = RegExp(/^0[0-9]{8,10}$/);
    		var rsTel = tReg.test(telVal);
    		if(!rsTel){
    			$("#ctelInput").text("전화번호 형식이 올바르지 않습니다.").css("color","red");
    		}else{
    			$("#ctelInput").text("올바르게 입력되었습니다.").css("color","blue");
    		}	
	    });
	   
	    $("#jobtype").change(function() {
	    var jobTypeValue = $("#jobtype").val();
	   
		if (jobTypeValue == "") {
		alert("모집직종을 선택해 주세요");
			
		}
	    });	
		
	    $("input[name='addr1'],input[name='addr2'],input[name='addr3'],input[name='addr4']").focusout(function() {
	    	
	    	if(	$("input[name='addr1']").val()== "" || 
				$("input[name='addr2']").val()== "" ||
				$("input[name='addr3']").val()== "" ||
				$("input[name='addr4']").val()== "" ){
				
			$("#addressInput2").text("주소를 모두 작성하여주세요.").css("color","red");
		}else{
			$("#addressInput2").css("display","none");
		}
    });
		 
	    
//=================================================================================		
		function check2() {
			
			//약관동의 <input>요소를 선택해서 가져와 
   	    	var checkbox = $("#clause2");
   	    	//약관동의 체크했는지 검사
   	    	//선택한 <input type="checkbox">체크박스에 체크가 되어 있지 않으면? 
   	    	//true를 리턴 해서 조건에 만족 합니다. 
   	    	if( !(checkbox.is(":checked")) ){ //== 같은 true값을 반환 한다. if(!$("#agree").prop("checked"))
   	    		$("#agreeInput2").text("약관에 동의해 주세요!").css("color","red");
   	    		checkbox.focus();
   	    		return false;
   	    	}
   	    	//====================================================================================================
    		var cname = $("#cname");
    		
	    		if($("#cname").val().length < 1 || $("#cname").val().length > 10 ){
	    			$("#cnameInput").text("회사명을 제대로 작성하여주세요.").css("color","red");
	    			cname.focus();
	    			return false;
	    		}else{
	    			$("#cnameInput").text("회사명입력완료!").css("color","blue");
	    		}
   	    	//====================================================================================================
   	    		
   	    	var cno = $("#cno");
   	    	var cnoValue = cno.val();
   	    	
   	    	var idReg = RegExp(/^[0-9]{3}-[0-9]{2}-[0-9]{5}$/);
   	    	var resultcno = idReg.test(cnoValue);
   	    	console.log(cno);
    		if(!resultcno){
    			$("#cnoInput").text("사업자번호를 입력해주세요").css("color","red");
    			cno.focus();
    			
    			
    		}
    			
    		
    		
    		//====================================================================================================
    		var name2 = $("#name2");
   	    	var nameValue2 = name2.val();
   	    	
   	    	var nameReg2 = RegExp(/^[가-힣]{2,6}$/);
   	    	var resultName2 = nameReg2.test(nameValue2);

    		if(!resultName2){
    			$("#nameInput2").text("이름을 한글로 작성하여주세요.").css("color","red");
    			name2.focus();
    			
    			return false;
    		}else{
    			$("#nameInput2").text("올바르게 입력되었습니다.").css("color","blue");
    		}
	    	//====================================================================================================
	    		
				var ctel = $("#ctel");
	    		
	    		var ctelValue = ctel.val();
	    		
	    		var ctelReg = RegExp(/^0[0-9]{8,10}$/);
	    		
	    		var resultcTel = ctelReg.test(ctelValue);
	    		
	    		if(!resultcTel){
	    			$("#ctelInput").text("전화번호 형식이 올바르지 않습니다.").css("color","red");
	    			
	    			ctel.focus();
	    			
	    			return false;
	    		}else{
	    			$("#telInput").text("올바르게 입력되었습니다.").css("color","blue");
	    		}	
	    		
				//====================================================================================================
   	    	var pwd2 = $("#pwd2");
   	    	var passValue2 = pwd2.val();
   	    	
   	    	var passReg2 = RegExp(/^[A-Za-z0-9_\-]{4,20}$/);
   	    	var resultPass2 = passReg2.test(passValue2);

    		if(!resultPass2){
    			$("#passInput2").text("한글,특수문자 없이 4글자 이상으로 작성해 주세요!").css("color","red");
    			pwd2.focus();
    			
    			return false;
    		}else{
    			$("#passInput2").text("올바르게 입력되었습니다.").css("color","blue");
    		}
    		
    		
    		
    		//====================================================================================================
    		
    			var pwdConfirm2 = ("#pwdConfirm2");
    			if ($("#pwd2").val() != $("#pwdConfirm2").val()) {
    				$("#passInput2").text("비밀번호가 일치하지 않습니다.").css("color","red");
    				pwdConfirm2.focus();
    				return false;
    			}else {
    				$("#passInput2").text("비밀번호가 일치합니다.").css("color","blue");
    			}
    			
    	
    			
			//====================================================================================================
    		var jobType = $("#jobtype")
			var jobTypeValue = $("#jobtype").val()
			if (jobTypeValue == '') {
				alert("모집직종을 선택해 주세요");
				jobType.focus();
				return false;
			}
    		//====================================================================================================

    		var addr1 = $("#sample4_postcode2");
    		var addr2 = $("#sample4_roadAddress2"); 
    		var addr3 = $("#sample4_jibunAddress2")
    		var addr4 = $("#sample4_detailAddress2");
    		
    		var addrVal1 = addr1.val();
    		var addrVal2 = addr2.val();
    		var addrVal3 = addr3.val();
    		var addrVal4 = addr4.val();
    		
    		if(addrVal1 == "" || addrVal2 == "" || addrVal3 == "" || addrVal4 == "" ){
    			$("#addressInput").text("주소를 모두 작성하여주세요.").css("color","red");
    			addr4.focus();
    			
    			return false;
    		}else{
    			$("#addressInput").text("올바르게 입력되었습니다.").css("color","blue");
    		}
    			
    		
    		//===================================================================================================
    		alert("회원가입이 완료 되었습니다.");
   	    	
   	    	
   	    	$(".compReg").submit();
   	    	
			
		}