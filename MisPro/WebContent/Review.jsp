<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="isAdmin_login.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
    function deleteReview(true_id){
    	alert("删除成功");
    	location.href = "${pageContext.request.contextPath}/DeleteReviewServlet?true_id="+true_id;
    }
    </script>
</head>
<body>
商品评论:<br>
<table border="1" class="review"  style="width:400px;">
        <tr class="success">
            <th>用户名</th>
            <th>评论</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${review}" var="review" varStatus="s">
            <tr>
                <td>${review.username}</td>
                <td>${review.main}</td>
                <td><a href="javascript:deleteReview(${review.true_id});">删除</a></td>
            </tr>

        </c:forEach>


    </table>
    <div>${msg}</div>
</body>
</html>