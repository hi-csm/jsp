<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="isAdmin_login.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
	<link href="css/style.css" rel="stylesheet"/>
	<link rel="stylesheet" href="css/wicket.css">
	<link rel="stylesheet" href="font/iconfont.css">
</head>
<body>
    	<div id="nav_line"></div>
    	<div id="box">
	        <div id="nav_menu">
	        	<div id="nav_left">
	        		<ul>
	        			<li><img alt="logo" src="images/logo.png"></li>
	        			<li>
	        				<p class="icon iconfont icomar1">
	        					<a href="index.jsp" >&#xe87b;</a>
	        				</p>
	        				<a href="index.jsp">首页</a>
	        			</li>
	        			<li>
	        				<p class="icon iconfont icomar2">
	        					<a href="product_list.jsp">&#xe6f6;</a>
	        				</p>
	        				<a href="product_list.jsp">产品管理</a>
	        			</li>
	        			<li>
	        				<p class="icon iconfont icomar2">
	        					<a href="${pageContext.request.contextPath }/QueryUserServlet">&#xe6ae;</a>
	        				</p>
	        				<a href="${pageContext.request.contextPath }/QueryUserServlet">用户管理</a>
	        			</li>
	        			<li>
	        				<p class="icon iconfont icomar2">
	        					<a href="#">&#xe6c7;</a>
	        				</p>
	        				<a href="#">关于我们</a>
	        			</li>
	        		</ul>
	        	</div>
	        	<div id="nav_right">
	        		<ul>
	        			<c:if test="${not empty user}">
		        			<li>
		        				<p class="icon iconfont icomar2">
		        					<a href="QuitServlet">&#xe60c;</a>
		        				</p>
		        				<a href="QuitServlet">退出登陆</a>
		        			</li>
		        		</c:if>
		        		<c:if test="${empty user}">
		        			<li>
		        				<p class="icon iconfont icomar2">
		        					<a href="admin_login.jsp">&#xe60c;</a>
		        				</p>
		        				<a href="admin_login.jsp">点击登陆</a>
		        			</li>
		        		</c:if>
	        			<li>
	        				<i class="icon iconfont icomar1">
	        					<a href="index.jsp">&#xe6b8;</a>
	        				</i>
	        				<span>
	        				<a href="index.jsp">
	        					<c:if test="${not empty user}">${user}</c:if>
	        					<c:if test="${empty user}">未登陆</c:if>
	        				</a></span>
	        			</li>
	        		</ul>
	        	</div>
	        </div>
	        <div id="main">
	        	<div id="main_left">
	        		<div id="left_line"><p>用户</p></div>
	        		<div id="left_upper">
	        			<img src="images/hp.png" alt="">
	        			<div id="left_upper_text">
	        				<span>
	        					<c:if test="${not empty user}">${user}</c:if>
	        					<c:if test="${empty user}">未登陆</c:if>
	        				</span><br/>
	        				<span>超级管理员</span><br/>
	        			</div>
	        			<p>最后登陆时间：</p>
	        			<p>2019-12-20&nbsp;12:00</p>
	        		</div>
	        		<div id="left_line"><p>在线统计</p></div>
	        		<div id="left_lower">
	        			<img src="images/etc.png" alt=""><br/>
	        			<hr id="left_lower_tourist" />
	        			<span>游客：500</span><br/>
	        			<hr id="left_lower_member" />
	        			<span>会员：300</span>
	        		</div>
	        	</div>
	        	<div id="main_right_top">
	        		<span><a href="index.jsp">首页</a></span>
	        		<span><a href="product_list.jsp">产品列表</a></span>
	        	</div>
	        	<div id="main_right">
	        		<div id="main_right_middle">
	        			<img src="images/adm.png" alt="">
	        			<br/><br/>
	        			<p>欢迎使用企业产品信息备案查询系统</p>
	        			<p>软件版本：v.10(检查更新)</p>
	        			<p>已使用内存：20MB&nbsp;剩余内存：45MB&nbsp;最大内存：63.55MB</p>
	        		</div>
	        		<hr>
	        		<span>信息</span>
	        		<span>系统属性</span>
	        		<hr>
	        		<div id="main_right_bot">
	        			<ul>
	        				<li>运行状态：正常</li>
	        				<li>购买日期：2019-12-20</li>
	        				<li>空间大小：65.5MB</li>
	        				<li>到期日期：2020-12-20</li>
	        			</ul>
	        			<ol>
	        				<li>操作系统：web</li>
	        				<li>操作系统类型：web</li>
	        				<li>用户目录：/////</li>
	        				<li>运行环境：JAVA</li>
	        			</ol>
	        		</div>
	        		<hr/>
	        	</div>
	        </div>
	        <div id="footer">
	        	<span>Copyright©2019-2020&nbsp;&nbsp;Javaweb期末作品&nbsp;&nbsp;CNightsReserved </span>
	        </div>
        </div>
</body>
</html>