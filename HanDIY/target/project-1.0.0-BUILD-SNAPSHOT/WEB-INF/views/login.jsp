<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>

------------login------------

<form method="post">
	이메일<div><input type="text" name="email_m" placeholder="example@naver.com"></div>
	비밀번호<div><input type="password" name="pw_m" placeholder="********"></div>
	<div>
		<a>비밀번호 찾기</a>
		<a href="${cpath }/join">회원 가입하기</a>
	</div>
	<input type="submit" value="로그인">
</form>

</body>
</html>