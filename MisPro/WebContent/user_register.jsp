<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<link href="css/enroll.css" rel="stylesheet"/>
<style type="text/css">
	html {
    width: 100%;
    height: 100%;
    overflow: hidden;
    background-image: url('images/bg1.png');
}
</style>
</head>
<body>
	<div class="login">
		<h2>用户注册</h2>
		<form action="UserLogin" method="post">
		    <input type="text" name="username" placeholder="用户名" />
		    <input type="password" name="pwd" placeholder="密码" />
		    <button type="submit" class="btn btn-primary btn-block btn-large" style="color: #d6dbdb; letter-spacing: 6px;" >注册</button>
		    <p><a href="admin_login.jsp">点我登陆</a></p>
		</form>
	</div>
	<c:if test="${count >= 1}">
		<script type="text/javascript">
			alert("注册成功！");
			window.document.location.href="user_register.jsp";
		</script>
	</c:if>
	<c:if test="${count <= 0}">
		<script type="text/javascript">
			alert("注册失败！");
			window.document.location.href="user_register.jsp";
		</script>
	</c:if>
</body>
</html>