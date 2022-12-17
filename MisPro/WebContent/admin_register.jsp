<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员注册</title>
<link href="css/enroll.css" rel="stylesheet"/>
</head>
<body>
	<div class="login">
		<h2>管理员注册</h2>
		<form action="AdminLogin" method="post">
		    <input type="text" name="user" placeholder="用户名" />
		    <input type="password" name="password" placeholder="密码" />
		    <button type="submit" class="btn btn-primary btn-block btn-large" style="color: #d6dbdb; letter-spacing: 6px;" >注册</button>
		    <p><a href="admin_login.jsp">点我登陆</a></p>
		</form>
	</div>
	<c:if test="${count >= 1}">
		<script type="text/javascript">
			alert("注册成功！");
			window.document.location.href="admin_register.jsp";
		</script>
	</c:if>
	<c:if test="${count <= 0}">
		<script type="text/javascript">
			alert("注册失败！");
			window.document.location.href="admin_register.jsp";
		</script>
	</c:if>
</body>
</html>