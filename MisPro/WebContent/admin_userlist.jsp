<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="isAdmin_login.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
	<link href="css/style.css" rel="stylesheet"/>
	<link rel="stylesheet" href="css/wicket.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="font/iconfont.css">
</head>
<body>
<c:if test="${empty users}"><!-- 首次访问加载servlet读取数据 -->
	<jsp:forward page="QueryUserServlet"></jsp:forward>
</c:if>
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
	        				<a href="">用户管理</a>
	        			</li>
	        			<li>
	        				<p class="icon iconfont icomar2">
	        					<a href="${pageContext.request.contextPath }/QueryOrderServlet">&#xe6c7;</a>
	        				</p>
	        				<a href="${pageContext.request.contextPath }/QueryOrderServlet">订单管理</a>
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
	        					</a>
	        				</span>
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
	        	<div id="main_right_top2">
	        		<span><a href="index.jsp">首页</a></span>
	        	</div>
	        	<div id="main_right2">
	        		<span>
	        			<a href="javascript:void(0)" onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">+添加用户</a>
	        			<form action="QueryUserBynameServlet">
	        			用户名:<input type="text" name="username"></input>
	        			<button type="submit">查询</button>
	        			</form>
	        		</span>
	        		<div class="white_content" id="light">
	        				<div id="win_content">
	        					<h3>添加用户</h3><hr/>
	        					<form action="AddUserServlet" method="post">
	        						<label>用户名</label>
	        						<input type="text" name="username"/>
	        						<label>密码</label>
	        						<input type="password" name="pwd"/>
	        						<label>余额</label>
	        						<input type="text" name="moeny" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');"/>
	        						<label>收货地址</label>
	        						<input type="text" name="address"/>
	        						<label>手机号码</label>
	        						<input type="text" name="phone"/>
	        						<div id="win_footer">
	        							<input type="submit" value="确定"/>
	        							<input type="button" value="取消" onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">
	        						</div>
	        					</form>
	        				</div>
	        			</div>
	        		<div class="black_overlay" id="fade"></div>
	        		<table>
	        			<tr>
	        				<th>编号</th>
	        				<th>用户名</th>
	        				<th>余额</th>
	        				<th>收货地址</th>
	        				<th>手机号码</th>
	        				<th width="150px;">操作</th>
	        			</tr>
	        			<c:forEach items="${users}" var="u" varStatus="s">
	        				<tr>
		        				<td>${s.index+1}</td>
		        				<td>${u.username}</td>
		        				<td>${u.moeny}</td>
		        				<td>${u.address}</td>
		        				<td>${u.phone}</td>
		        				<td>
		        					<a href="admin_userChange.jsp?user_id=${u.id}&user_name=${u.username}">修改</a>
		        					<a href="${ pageContext.request.contextPath }/DeleteUserServelt?user_id=${u.id}">删除</a>
		        				</td>
	        				</tr>
	        			</c:forEach>
	        		</table>
		        	<nav aria-label="Page navigation">
		        		<ul class="pagination" style="float: left;">
		        			<li class="disabled"><a href="#"><span aria-hidden="true">&laquo;</span></a></li>
		        			<li class="active"><a href="#">1</a></li>
		        			<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						 </ul>
						 <span id="sp">共${i }条记录，共1页</span>
					</nav>
	        	</div>
	        </div>
	        <div id="footer">
	        	<span>Copyright©2019-2020&nbsp;&nbsp;Javaweb期末作品&nbsp;&nbsp;CNightsReserved </span>
	        </div>
        </div>
</body>
</html>