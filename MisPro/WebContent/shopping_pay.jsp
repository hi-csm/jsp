<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="isUser_login.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>在线支付</title>
    <style type="text/css">
   		 html{
    		background-color: #2a2b30;
    		color:#FFF;
    	}
    	body{
    		color:#FFF;
    		margin-top: 30px;
    		margin-left: 50px;
    	}
    </style>
  </head>
  <body>
        <form action="${ pageContext.request.contextPath }/pay" method="get"> 
	      <input type="hidden" name="Pro_name" value="${ap.get(0).getPro_name()}" />
       	  <span>订单号：</span>
    	  <input  type="text" id="demo1" value="" disabled></input>
       	  <input type="hidden" name="number" value=<%="<div id='demo'" %>>
          <span> 支付金额：</span>
          <input type="text" value="${moeny}"  disabled></input>
          <input name="moeny" type="hidden" value="${moeny}">
          <br/><br/>
         <span>请您选择在线支付银行</span>
         <br/>
          <table>
            <tr>
             <td><input TYPE="radio" name="zf" value="a" checked/>余额支付</td>
              <td><input TYPE="radio"  name="zf" value="b"/>微信支付</td>
              <td><input TYPE="radio" name="zf" value="c"/>支付宝支付</td>
              <td><input TYPE="radio" name="zf" value="d"/>招商银行 </td>
            </tr>
            <tr>
              <td><input TYPE="radio" name="zf" value="e" />北京银行</td>
              <td><input TYPE="radio" name="zf" value="f" />兴业银行 </td>
              <td><input TYPE="radio" name="zf" value="g" />上海浦东银行 </td>
              <td><input TYPE="radio" name="zf" value="i" />中信银行</td>
            </tr>
            <tr>
              <td></td>
            </tr>
         </table>
         <INPUT TYPE="submit" value="确定支付">
           </form>
           
      <script type="text/javascript">
    	function randomString() {  
    	  e = 12;
    	  var t = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz0123456789";
    	  a = t.length;
    	  n = "";
    	  for (i = 0; i < e; i++) n += t.charAt(Math.floor(Math.random() * a));
    	  return n;
    	}
    	var s = randomString();
    	document.getElementById("demo1").value = s;
    	document.getElementById("demo").value = s;
    </script>
    <script type="text/javascript">
    var error1 =${error1};
	if(error1 != null){
		alert(error1);
	}
    </script>
  </body>
</html>