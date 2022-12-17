<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="isUser_login.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息页面</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style type="text/css">
  html body{
  	background-color: #2a2b30;
  }
  .review{
		color:white;
		text-align:left;
	}
  </style>
</head>

<body>
<div class="jumbotron text-center" style="margin-bottom:0;background-color: #2a2b30;">
  <h3 style=" color: #ffffff;">我的订单详情</h3>
</div>
<div class="container">
<table class="table table-dark table-hover">
    <thead>
      <tr>
        <th>产品名称</th>
        <th>订单号</th>
        <th>交易金额</th>
        <th>电话</th>
        <th>地址</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${Pro_name1}</td>
        <td>${number}</td>
        <td>${moeny1}</td>
        <td>${username.getPhone()}</td>
        <td>${username.getAddress()}</td>
      </tr>
    </tbody>
  </table>
  <br/>
   <button type="button" class="btn btn-primary" onclick="javascrtpt:window.location.href='${ pageContext.request.contextPath }/UserLogin2'" style="float: right;">返回主页面</button>
</div>

</body>
</html>