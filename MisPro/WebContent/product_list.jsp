<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="isAdmin_login.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>产品列表</title>
	<link href="css/style.css" rel="stylesheet"/>
	<link rel="stylesheet" href="css/wicket.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="font/iconfont.css">
</head>
<body>
<c:if test="${empty pb.currentPage}"><!-- 首次访问加载servlet读取数据 -->
	<jsp:forward page="PageServlet"></jsp:forward>
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
	        				<a href="${pageContext.request.contextPath }/QueryUserServlet">用户管理</a>
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
	        		<span><a href="product_list.jsp">产品列表</a></span>
	        	</div>
	        	<div id="main_right2">
	        		<span>
	        			<a href="javascript:void(0)" onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">+添加产品</a>
	        			<form action="">
	        			产品名:<input type="text" name="pro_name"></input>
	        			<button type="submit">查询</button>
	        			</form>
	        		</span>
	        		<div class="white_content" id="light">
	        				<div id="win_content">
	        					<h3>产品添加</h3><hr/>
	        					<form action="ProductAddServlet" method="post">
	        						<label>总批次</label>
	        						<input type="text" name="pro_batch" placeholder="输入数字" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');"/>
	        						<label>项目名</label>
	        						<input type="text" name="pro_name"/>
	        						<label>硬件型号</label>
	        						<input type="text" name="pro_hard"/>
	        						<label>软件版本</label>
	        						<input type="text" name="pro_soft"/>
	        						<label>上线时间</label>
	        						<input type="date" name="pro_time"/>
	        						<label>产品单价</label>
	        						<input type="text" name="pro_count" placeholder="输入数字" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');"/>
	        						<label>Mac段</label>
	        						<input type="text" name="pro_mac_min" style="width: 88px; height: 22px; margin-bottom: 16px; margin-right: 2px; float: left; border: 1px solid #235176; border-radius: 4px;">
	        						<input type="text" name="pro_mac_max" style="width: 88px; height: 22px; margin-bottom: 16px; float: left; border: 1px solid #235176; border-radius: 4px;">
	        						<label>Mac格式</label>
	        						<input type="text" name="pro_mac_format"/>
	        						<label>SN段</label>
	        						<input type="text" name="pro_sn_min" style="width: 88px; height: 22px; margin-bottom: 16px; margin-right: 2px; float: left; border: 1px solid #235176; border-radius: 4px;">
	        						<input type="text" name="pro_sn_max" style="width: 88px; height: 22px; margin-bottom: 16px; float: left; border: 1px solid #235176; border-radius: 4px;">
	        						<label>SN格式</label>
	        						<input type="text" name="pro_sn_format"/>
	        						<label>设备码总数</label>
	        						<input type="text" name="pro_code_count" placeholder="输入数字" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');"/>
	        						<label>备注</label>
	        						<input type="text" name="pro_remark"/>
	        						<div id="win_footer">
	        							<input type="submit" value="确定"/>
	        							<input type="button" value="取消" onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">
	        						</div>
	        					</form>
	        				</div>
	        				<c:if test="${add >= 1}">
	        					<script type="text/javascript">
									alert("添加成功！");
								</script>
	        				</c:if>
			        		<c:if test="${add == 0}">
			        			<script type="text/javascript">
			        				alert("添加失败，数据输入有误，请检查后重新添加！");
								</script>
			        		</c:if>
	        			</div>
	        		<div class="black_overlay" id="fade"></div>
	        		<table>
	        			<tr>
	        				<th>编号</th>
	        				<th>项目名</th>
	        				<th>硬件型号</th>
	        				<th>软件版本</th>
	        				<th>上线时间</th>
	        				<th>产品单价</th>
	        				<th width="150px;">操作</th>
	        			</tr>
	        			<c:forEach items="${pb.list}" var="product" varStatus="s">
	        				<tr>
		        				<td>${(pb.currentPage-1)*8 + (s.index+1)}</td>
		        				<td>${product.pro_name}</td>
		        				<td>${product.pro_hard}</td>
		        				<td>${product.pro_soft}</td>
		        				<td>${product.pro_time}</td>
		        				<td>￥${product.pro_count}</td>
		        				<td>
		        					<a href="InfoServlet?pro_id=${product.pro_id}">详情</a>
		        					<a href="product_change.jsp?pro_id=${product.pro_id}&pro_name=${product.pro_name}&pro_hard=${product.pro_hard}&currentPage=${pb.currentPage}">修改</a>
		        					<a href="DeleteServlet?pro_id=${product.pro_id}&currentPage=${pb.currentPage}">删除</a>
		        					<a href="QueryReviceServlet?pro_id=${product.pro_id} " style="color: red;">评论</a>
		        				</td>
	        				</tr>
	        			</c:forEach>
	        		</table>
	        		<c:if test="${deleteCount >= 1}">
	        			<script type="text/javascript">	
	        				alert("删除成功！");
						</script>
	        		</c:if>
	        		<c:if test="${deleteCount == 0}">
	        			<script type="text/javascript">	
	        				alert("删除失败！");
						</script>
	        		</c:if>
		        	<nav aria-label="Page navigation">
		        		<ul class="pagination" style="float: left;">
		        			<c:if test="${pb.currentPage == 1}">
		        				<li class="disabled"><a href="PageServlet?currentPage=${pb.currentPage}&rows=8" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
		        			</c:if>
		        			<c:if test="${pb.currentPage != 1}">
		        				<li><a href="PageServlet?currentPage=${pb.currentPage-1}&rows=8" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
		        			</c:if>
		        			<c:forEach begin="1" end="${pb.totalPage}" var="i">
		        				<c:if test="${pb.currentPage == i}">
		        					<li class="active"><a href="PageServlet?currentPage=${i}&rows=8">${i}</a></li>
		        				</c:if>
		        				<c:if test="${pb.currentPage != i}">
		        					<li><a href="PageServlet?currentPage=${i}&rows=8">${i}</a></li>
		        				</c:if>
		        			</c:forEach>
		        			<c:if test="${pb.currentPage == pb.totalPage}">
		        				<li class="disabled"><a href="PageServlet?currentPage=${pb.currentPage}&rows=" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
		        			</c:if>
		        			<c:if test="${pb.currentPage != pb.totalPage}">
		        				<li><a href="PageServlet?currentPage=${pb.currentPage+1}&rows=" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
		        			</c:if>
						 </ul>
						 <span id="sp">共${pb.totalCount}条记录，共${pb.totalPage}页</span>
					</nav>
	        	</div>
	        </div>
	        <div id="footer">
	        	<span>Copyright©2019-2020&nbsp;&nbsp;Javaweb期末作品&nbsp;&nbsp;CNightsReserved </span>
	        </div>
        </div>
</body>
</html>