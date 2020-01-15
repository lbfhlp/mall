<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<!-- ${pageContext.request.contextPath} 返回站点根路径:/mall -->
<c:set var="contextPath" scope="application">${pageContext.request.contextPath}</c:set>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/header.css">
<script type="text/javascript" src="${contextPath}/js/jquery-3.4.1.js"></script> 
<script type="text/javascript" src="${contextPath}/js/menu_hid_show.js"></script>

</head>
<body>
  
	<div id="Head">
		<div id="headerTopArea" class="headerTopAreaBox">
			<div id="headerTop" >
				<div id="top_welcome_login">
					<a href="GoodsAdd.do" target="_blank">添加商品入口</a>
					<span class="span_header">您好,欢迎光临非凡客诚品!</span>
					<span class="span_header"><a class="top a login" href="#">登录</a></span>
					<span>|</span>
					<span class="span_header"><a class="top a regist" href="#">注册</a></span>
				</div>
				<div id="my_order">
					<span class="span_header"><a class="top a my order" href="#">我的订单</a></span>
				</div>
			</div>
		</div>
		<div id="logoArea" class="fvanclLogoSearch">
			<div id="div_search">
				<form action="#" id="form_search">
					<input type="text" name="top search">
					<input type="submit" value="搜索">
				</form>
				<a href="#">购物车(</a><span>0</span>)
			
			</div>
			
			
		</div>
		
		
		<div id="mainNavBox" class="navlist">
			
			<ul id="menu">
				<li style="width:210px;height: 50px;margin-top: 10px" ><a href="index.jsp"><img alt="" src="${contextPath }/img/非凡客图标.jpg"/></a></li>
				<li id=""><a href="${contextPath }/index.jsp">首页</a>
					
				</li>
				
				<li id=""><a href="#">新品</a></li>
				<!-- 超链接地址避免使用../等,以防文件移动后出错 -->
				<li id=""><a href="parent.do?type=cs" target="_blank"  >衬衫</a>
					<ul class="dropdown-content">
                		<li><a href="sub.do?type=xx">休闲</a></li>
                		<li><a href="sub.do?type=sw">商务</a></li>
                	</ul>
				</li>
				
				<li id=""><a href="parent.do?type=wy" target="_blank">卫衣</a>
					<ul class="dropdown-content">
                		<li><a href="#">开衫</a></li>
                		<li><a href="#">连帽</a></li>
                		<li><a href="#">圆领</a></li>
                	</ul>
				</li>
				
				<li id=""><a href="parent.do?type=nz" target="_blank">女装</a>
					<ul class="dropdown-content">
                		<li><a href="#">大衣</a></li>
                		<li><a href="#">针织衫</a></li>
                		<li><a href="#">鞋品</a></li>
                		<li><a href="#">袜品</a></li>
                		<li><a href="#">家居配饰</a></li>
                	</ul>
				</li>
				
				<li id=""><a href="parent.do?type=yrf" target="_blank">羽绒服</a>
					<ul class="dropdown-content">
                		<li><a href="#">羽绒服</a></li>
                		<li><a href="#">大衣</a></li>
                		<li><a href="#">大衣</a></li>
                		<li><a href="#">夹克</a></li>
                		<li><a href="#">西服</a></li>
                	</ul>
				</li>
				
				<li id=""><a href="parent.do?type=zzs" target="_blank">针织衫</a>
					<ul class="dropdown-content">
                		<li><a href="#">棉线衫</a></li>
                		<li><a href="#">羊毛衫</a></li>
                		<li><a href="#">空调衫</a></li>
                	</ul>
				</li>
				
				<li id=""><a href="parent.do?type=kz" target="_blank">裤装</a>
					<ul class="dropdown-content">
                		<li><a href="#">针织裤</a></li>
                		<li><a href="#">休闲裤</a></li>
                		<li><a href="#">牛仔裤</a></li>
                		<li><a href="#">工装裤</a></li>
                	</ul>
				</li>
				
				<li id=""><a href="parent.do?type=x" target="_blank">鞋</a>
					<ul class="dropdown-content">
                		<li><a href="#">跑鞋</a></li>
                		<li><a href="#">帆布鞋</a></li>
                		<li><a href="#">休闲鞋</a></li>
                		<li><a href="#">运动鞋</a></li>
                		<li><a href="#">皮鞋</a></li>
                		<li><a href="#">凉鞋</a></li>
                	</ul>
				</li>
				
				<li id=""><a href="parent.do?type=jjps" target="_blank">家居配饰</a>
					<ul class="dropdown-content">
                		<li><a href="#">被子</a></li>
                		<li><a href="#">毯子</a></li>
                		<li><a href="#">围巾</a></li>
                		<li><a href="#">枕</a></li>
                		<li><a href="#">毛巾</a></li>
                	</ul>
				</li>
			</ul>
		</div>
		
		
	</div>
</body>

</html>