<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입폼</title>
	<script src="<c:url value="/javascript/jquery/jquery-3.6.0.js" />"></script>
	<script src="<c:url value="/javascript/users.js" />"></script>
</head>
<body>
	<h1>회원 가입</h1>

	
	<!-- form
		id="join-form"
		name="registerForm" 
		action="<c:url value="/users/join" />"
		method="POST"
		>
		-->
	<form:form
		modelAttribute="userVo"
		id="join-form"
		name="registerForm" 
		action="${pageContext.servletContext.contextPath }/users/join"
		method="POST">
		<!-- input type="hidden" name="a" value="join" -->

		<label for="name">이름</label>
		
		<!-- input name="name" type="text" placeholder="이름을 입력하십시오"><br -->
		<form:input path="name" placeholder="이름을 입력하십시오"/><br />
		<spring:hasBindErrors name="userVo">
			<c:if test="${errors.hasFieldErrors('name') }">
				<strong style="color:red">
					<spring:message code="${errors.getFieldError('name').codes[0] }"
						text="${errors.getFieldError('name').defaultMessage }" /><br/>
				</strong>
			</c:if>
		</spring:hasBindErrors>

		<label for="password">비밀번호</label>
		<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>

		<spring:hasBindErrors name="userVo">
			<c:if test="${errors.hasFieldErrors('password') }">
				<strong style="color:red">
					<spring:message code="${errors.getFieldError('password').codes[0] }"
						text="${errors.getFieldError('password').defaultMessage }" /><br/>
				</strong>
			</c:if>
		</spring:hasBindErrors>

		<label for="email">이메일</label>
		

		<!-- input type="text" name="email" placeholder="이메일을 입력하십시오."><br -->
		<form:input path="email" placeholder="이메일을 입력하십시오."/>

		<spring:hasBindErrors name="userVo">
			<c:if test="${errors.hasFieldErrors('email') }">
				<strong style="color:red">
					<spring:message code="${errors.getFieldError('email').codes[0] }"
						text="${errors.getFieldError('email').defaultMessage }" /><br/>
				</strong>
			</c:if>
		</spring:hasBindErrors>

		<input type="button" value="id 중복 체크"
			onclick="checkEmail(this, '<c:url value="/api/users/emailcheck" />')" />

		<label for="gender">성별</label>
		<input type="radio" name="gender" value="M" checked>남성</radio>
		<input type="radio" name="gender" value="F">여성</radio><br>
		<input type="submit" value="전송"> 

	
	<!-- /form -->
	</form:form>

</body>
</html> 