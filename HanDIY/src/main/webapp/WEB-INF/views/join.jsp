<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
</head>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<body>

-------------join------------

<script type="text/javascript">
	
	// 이메일 & 비밀번호 정규표현식
	const patternEmail = RegExp(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/);
	const patternPw = RegExp(/^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$/);

	$(document).ready(function(){
	
	// 이메일 정규표현식 확인 & 중복체크
	$('#email_m').blur(function() {
		const email = $('#email_m').val();
		console.log(email);
		var idmsg = $('#idmsg');
		
		if(!patternEmail.test(email)){	// 이메일 정규표현식에 맞지 않을 때
			idmsg.text("이메일 형식 확인");
			return;
		}else{		// 이메일 정규표현식에 맞을 경우 ajax를 통해 계정 중복 테스트
			$.ajax({
				// 데이터를 get 방식으로 url에 붙여 전송
				type: "GET",
				url: 'emailCheck?email_m='+email,
				success: function(data){
					if(data>0){		// return값을 int값으로 받아와 select된 계정이 1개 이상이면 사용중인 계정
						idmsg.text('이미 사용중인 계정입니다')
						/*idmsg.css('color', 'red');  */
					}else{
						idmsg.hide();
					}
				}
			})
		}
	});
	
	// 비밀번호 정규표현식 확인
	$('#pw_m').blur(function(){
		const pw = $('#pw_m').val();
		var pwmsg = $('#pwmsg');
		
		if(!patternPw.test(pw)){
			pwmsg.text("비밀번호 형식 확인");
			return;
		}else{
			pwmsg.hide();
		}
	});
	
	});
</script>

<form method="post">
	<label for="name_m">이름</label><br>
	<input type="text" id="name_m" name="name_m" placeholder="홍길동" required><br>
	
	<label for="email_m">이메일</label><br>
	<input type="text" id="email_m" name="email_m" placeholder="example@naver.com" required><br>
	<p id="idmsg"></p>
	
	<label for="pw_m">비밀번호</label><br>
	<input type="password" id="pw_m" name="pw_m" placeholder="********" required><br>
	<p id="pwmsg"></p> 
	
	<label for="pwChk">비밀번호 확인</label><br>
	<input type="password" id="pwChk" name="pwChk" placeholder="********" required><br><br>
	<p id="cpwmsg"></p>
	
	<input type="submit" value="가입하기">
</form>

</body>
</html>