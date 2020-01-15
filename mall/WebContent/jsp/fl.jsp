<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分类-衬衫</title>
<link rel="stylesheet" type="text/css" href="css/fl.css">
</head>
<body>
	<!-- 引入公共页面 -->
	<a id="db"></a>
	<jsp:include   page="/common/header.jsp" />
	<div class="content_area"  id="content_area">
		<div class="content">
			<!-- 
			 <div class="content_topimg">
				
					<img alt="hah" src="/mall/img/wy/wy-top.jpg" class="content_topimg_img">
				
				<hr> 
			</div>-->
			<div class="maodian" id="maodian">
				<ul>
					<c:forEach  items="${subArr}" var="sub">
						<li><a href="#${sub.sub_type}"  class="maodian-a">${sub.full_name}</a></li>
					</c:forEach>
					
					
					<li><a href="#db" class="maodian-a">回到顶部</a></li>
				</ul>
			</div>
			<!-- subArr:子级菜单集合 -->
			<c:forEach items="${subArr}" var="sub">
				<div class="div_sub">
				
				<!-- 用于设置锚点 -->
      		  	<a id="${sub.sub_type }"></a>
      		  	<!-- 子级分类标题 -->
					<div class="sub_title_area"  >
						<h3>${ sub.full_name}</h3>
					</div>
		
					<div class="sub_content_area">
					
					 	<!-- 根据子级分类的id:sub_id获取该分类下所有商品的图片路径 -->
					 	<c:forEach items="${subSpuMap}" var="subSpuMap">
					 	
					 		<!-- imgMap中,key为sub_id,value为图片路径(ArrayList数组) -->
					 		<!-- 如果为同一个sub_id,则获取图片路径 -->
					 		<c:if test="${subSpuMap.key eq sub.sub_id }">
					 			<!-- 遍历子级分类下的商品 -->
					 			<c:forEach items="${subSpuMap.value}" var="SpuValue">
					 								
					 					<div class="div_sp">
					 						
					 						<a href="GoodsDetails.do?spu_no=${SpuValue.spu_no}" title="${SpuValue.goods_name } ${SpuValue.lowest_price }" >
					 							<c:forEach items="${spuImgMap}" var="spuImgMap">
					 								<c:if test="${spuImgMap.key eq SpuValue.id }">
					 									<img alt="" src="/imgPath${spuImgMap.value.img_path}${spuImgMap.value.img_name}"  class="sp-img">
					 								</c:if>
					 							</c:forEach>
					 							
					 						</a><br>
					 						
					 								<a><h6>${SpuValue.goods_name } ${spuImgMap.value.img_spec_value}</h6></a>
					 								<h6>售价:  ${SpuValue.lowest_price }</h6>
					 					</div>
					 					
					 				
					 				
					 				
					 			</c:forEach>
					 		</c:if>
					 	
					 	</c:forEach>
						
								
					
					
				
					</div>
			</div>
			
			
			</c:forEach>
			
		</div>
	<%@ include file="/common/footer.jsp" %>
	</div>
			
	
</body>
</html>