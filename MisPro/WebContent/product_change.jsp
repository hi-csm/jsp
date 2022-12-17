<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="isAdmin_login.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>产品修改</title>
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
	        	<div id="main_right_top3">
	        		<span><a href="index.jsp">首页</a></span>
	        		<span><a href="product_list.jsp">产品列表</a></span>
	        		<span><a href="product_change.jsp">产品修改</a></span>
	        	</div>
	        	<div id="main_right3">
	        		<c:if test="${empty param.pro_id}">
						<script type="text/javascript">
							alert("您还未选择需要修改的产品名称！");
							window.document.location.href="product_list.jsp";
						</script>
					</c:if>
					<p>当前修改产品名称：${param.pro_name}${param.pro_hard}</p>
	        		<form action="ChangeServlet" method="post">
	        			<input type="hidden" name="pro_id" value="${param.pro_id}"/>
		        		<ul>
		        			<li>总批次<input type="text" name="pro_batch" placeholder="输入数字" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');" /></li>
		        			<li>项目名<input type="text" name="pro_name"/></li>
		        			<li>硬件型号<input type="text" name="pro_hard"/></li>
		        			<li>软件版本<input type="text" name="pro_soft"/></li>
		        			<li>上线时间<input type="date" name="pro_time"/></li>
		        			<li>产品单价<input type="text" name="pro_count" placeholder="输入数字" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');" /></li>
		        			<li>Mac段<input type="text" name="pro_mac_min" style="width: 85px; margin-left: 2px; height: 20px;float: right; border: 1px solid #235176; border-radius: 4px;">
		        					 <input type="text" name="pro_mac_max" style="width: 86px; height: 20px;float: right; border: 1px solid #235176; border-radius: 4px;"></li>
		        			<li>Mac格式<input type="text" name="pro_mac_format"/></li>
		        			<li>SN段<input type="text" name="pro_sn_min" style="width: 85px; margin-left: 2px;  height: 20px; float: right; border: 1px solid #235176; border-radius: 4px;">
		        					<input type="text" name="pro_sn_max" style="width: 86px; height: 20px;float: right; border: 1px solid #235176; border-radius: 4px;"></li>
		        			<li>SN格式<input type="text" name="pro_sn_format"/></li>
		        			<li>设备码总数<input type="text" name="pro_code_count" placeholder="输入数字" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');" /></li>
		        			<li>备注<input type="text" name="pro_remark"/></li>
		        		</ul>
		        		<div id="right_foot">
	        			<input type="button" value="返回" onclick="location.href='javascript:history.go(-1);'" />
	        			<input type="submit" value="提交"/>
	        			</div>
		        	</form>
		        	<c:if test="${change >= 1}">
						<script type="text/javascript">
						window.document.location.href="product_list.jsp";
						alert("修改成功！");
						</script>
					</c:if>
		        	<c:if test="${change == 0}">
						<script type="text/javascript">
						window.document.location.href="product_list.jsp";
						alert("修改失败，数据输入有误，请检查后重新修改！");
						</script>
					</c:if>
	        	</div>
	        </div>
	        <div id="footer">
	        	<span>Copyright©2019-2020&nbsp;&nbsp;Javaweb期末作品&nbsp;&nbsp;CNightsReserved </span>
	        </div>
        </div>
</body>
</html>