<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">

</head>
<body>
	<%@ include file="../common/header.jsp" %> 
			
	<div id="div_body">
		<!-- container---图片轮播 -->
		<div class="container">
        	<div class="wrap" style="left: -980px;">
            	<img src="img/首页轮播/homepage05_cs.jpg" alt="">
            	<img src="img/首页轮播/homepage01_kz.jpg" alt="">
            	<img src="img/首页轮播/homepage02_yrf.jpg" alt="">
           	 	<img src="img/首页轮播/homepage03_zzs.jpg" alt="">
           		 <img src="img/首页轮播/homepage04_wy.jpg" alt="">
           		 <img src="img/首页轮播/homepage05_cs.jpg" alt="">
           		 <img src="img/首页轮播/homepage01_kz.jpg" alt="">
       	 	</div>
        	
        	<div class="buttons">
            	<span name="span_button" class="on"></span>
            	<span name="span_button"></span>
            	<span name="span_button"></span>
            	<span name="span_button"></span>
            	<span name="span_button"></span>
        	</div>
        	<a href="javascript:;" class="arrow arrow_left" >&lt;</a>
        	<a href="javascript:;" class="arrow arrow_right">&gt;</a>
    	</div>
		<div id="new_products">
		
      		
			  <img alt="" src="img/新品推荐.jpg">
		
			<table>
				 <tr>
					<td><a href=""><img alt="" src="img/xp_03.jpg" id="img_new_products"></a></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
				</tr> 
				<tr>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
				</tr>
				<tr>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
				</tr>
			
			</table>
		</div>
		<div id="preferred">
			<img alt="" src="img/优选推荐.jpg">
			<table>
				 <tr>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
				</tr> 
				<tr>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
					<td><img alt="" src="img/xp_03.jpg" id="img_new_products"></td>
				</tr>
			</table>
		</div>
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
	<script type="text/javascript" src="js/imgCarouse.js"></script>

</html>