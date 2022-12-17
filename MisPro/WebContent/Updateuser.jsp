<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	function alertTips(){
		alert("修改成功");
	}
</script>
<style>
*{
margin : 0 auto;
padding : 0;
}
#box{
width:400px;
height:300px;
}

</style>
<body>
<div id="box">
<form action="UpdateServlet">
<h1>用户信息修改</h1><br><br>
用  户  名:<input type="text" name="username"  readonly="readonly" value=${username}></input><br><br>
收货地址:<input type="text" name = "address" style="width:300px;" value=${address}></input><br><br>
电       话:<input type="text" name = "phone" value=${phone}></input><br><br>
<button type="submit" onclick="alertTips()">修改</button>
<input value="返回" type="button" onclick="location.href='javascript:history.go(-1);'" />
</form>
</div>
</body>
</html>