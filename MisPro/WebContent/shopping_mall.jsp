<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="isUser_login.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<link href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css" />
	<link rel="stylesheet" type="text/css" href="css/component.css" />
	<title>海软购物商城</title>
	<style type="text/css">
		.view img{
			width:200px;
			border-radius:12px;
		}
		.view h1{
			margin: 0 auto;
			font-size: 28px;
			letter-spacing:6px;
		}
		.boot{
			font-size: 10px;letter-spacing:4px;
		}
		#nve{
			width: 450px;
			margin-top: 20px;
			height: 40px;
			font-size: 16px;
		}
		.img{
			float:right;
			margin-top:10px;
		}
	</style>
</head>
<body>
	<div class="view">
		<section class="grid">
		<h1>欢迎来到海软购物商城</h1>
		<div id="nve">欢迎：${username.getUsername()}&nbsp; &nbsp;&nbsp;&nbsp;当前余额：￥${username.getMoeny()} 
			&nbsp; &nbsp;&nbsp;&nbsp<a href="${pageContext.request.contextPath}/UpdateuserInfoServlet?name=${username.getUsername()}">修改信息</a>
			&nbsp; &nbsp;&nbsp;&nbsp;<a href="QuitUserServlet">退出登陆</a>
		</div>
		<%int i=1; %>
			<c:forEach items="${product.list}" var="product" varStatus="s">
			<!-- Products -->
			<div class="product">
				<div class="product__info">
					<img src="images/<%=i++ %>.jpg" />
					<h3>${product.pro_name}</h3>
					<p class="product__price highlight">￥${product.pro_count}</p><div class="img"><a onclick="javascrtpt:window.location.href='${ pageContext.request.contextPath }/ShowReviewServlet?pro_id=${product.pro_id}&username=${username.getUsername()}'"><img src="images/review.jpg" style="width:20px;height:20px;" /></a></div>
					<button class="action action--button action--buy" onclick="javascrtpt:window.location.href='${ pageContext.request.contextPath }/addCartServlet?id=${product.pro_id}&pro_name=${product.pro_name}&pro_count=${product.pro_count}'">
						<i class="fa fa-shopping-cart"></i>
						<span class="action__text">点击购买</span>
					</button>
				</div>
			</div>
			</c:forEach>
			
		</section>
	</div>
	<div class="related">
		<span class="boot">© 2020 HNCST 使用前必读</span>
	</div>
	<script src="js/classie.js"></script>
	<script src="js/main.js"></script>
</body>
</html>