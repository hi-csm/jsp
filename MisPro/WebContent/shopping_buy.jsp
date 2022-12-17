<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="isUser_login.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
<title>购买页面</title>
</head>
<style type="text/css">
	html body{
		margin-top: 50px;
		background-color: #2a2b30;
		color: #FFF;'
	}
	table input{
	 	text-align:center; width:30%;
	  }
	.div_emptyFont{ 
		font-size:40px; color:#999; margin-top:100px; 
	}
	table{
	    text-align: center;
	}
	hr{
		height: 1px;
		background-color: #FFF;
	}
</style>
<body>
<div id="app">
<div  class="container" >
	<table class="table" >
    	<thead style="color: #FFF;">
        	<tr>
        		<th>商品编号</th>
	        	<th>商品名称</th>
	        	<th>购买数量</th>
            	<th>商品单价</th>
            	<th>总数量</th>
            	<th>商品总价</th>
            	<th>商品操作</th>
            </tr>
        </thead>
        <tbody style="color: #FFF;">
        <c:forEach items="${ca}" var="ca" varStatus="s">
        	<tr>
            	<td>${ca.getId()}</td>
                <td>${ca.getPro_name()}</td>
                <td>
                	<button type="button" class="btn btn-primary"  v-on:click="jian">-</button>
                	<input type="text" value=""  v-model = "kilometers">
                    <button type="button" class="btn btn-primary" v-on:click="jia" >+</button>
                    
                </td>
                <td>￥${ca.getPro_count()}</td>
                <td>{{kilometers}}</td>
                <td>￥{{kilometers*${ca.getPro_count()}}}</td>
                <td>
                	<button type="button" class=" btn btn-danger" v-on:click="pay(${ ca.getId()},${ca.getPro_count()})">购买</button>
                	<button type="button" class=" btn btn-danger" v-on:click="sc(${ ca.getId()})">移除</button>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table><hr/><br/>
    <button type="button" class="btn btn-primary" style="float: right;" onclick="javascrtpt:window.location.href='${ pageContext.request.contextPath }/UserLogin2'">继续购买</button>
    <p>收货人：${username.getUsername()}</p>
    <p>电话：${username.getPhone()}</p>
    <p>收货地址：${username.getAddress()}</p>
    <p></p>
	</div>
</div>

<script type="text/javascript">
var vm = new Vue({
    el: '#app',
    data(){
    	return{
    	 kilometers :1,
         moeny:0
    	}
    },
    methods: {
    	jian:function(){
    		if(this.kilometers != 0){
    			this.kilometers = this.kilometers - 1;
    		}else{
    			alert("商品数量不能少于0！！");
    		}
    	},
    	jia:function(){
    		this.kilometers = this.kilometers + 1;
    	},
    	pay:function(id,count){
    		window.document.location.href='/MisPro/PayServlet?pro_id='+id+'&moeny='+this.kilometers * count;
    	},
    	sc:function(id){
    		window.document.location.href='/MisPro/deleteCartServlet?pro_id='+id;
    	}
    }
 });

</script>
</body>
</html>