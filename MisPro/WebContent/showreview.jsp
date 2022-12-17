<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
*{
margin: 0 auto;
padding:0 ;
}
#main{
width:600px;
height:300px;
}
</style>
<body>
<div id = "main">
<center><h2>商品评论</h2></center>
<table border="1" class="review"   color: white; ">
        <tr class="success">
            <th>用户名</th>
            <th>评论</th>
        </tr>

        <c:forEach items="${review}" var="review" varStatus="s">
            <tr style="text-align:'left';">
                <td>${review.username}</td>
                <td>${review.main}</td>
            </tr>

        </c:forEach>


    </table>
    <div>${msg}</div><br>
    
 <form action="AddReviewServlet">
<input type="hidden" value=${username}  name="username"></input>
<input type="hidden" value=${pro_id} name="id"></input>
<input type="text"  style="width:500px; height:50px;text-align:top;" placeholder="请评论" name="main"></input>
<button type="submit">提交</button>
<input type="button" value="返回" onclick="location.href='javascript:history.go(-1);'" />
</form>
</div>
</body>
</html>