<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript" src="/mall/js/jquery-3.4.1.js"></script> 

<style type="text/css">
 	*{
		margin:0;
		padding:0;
	}
	
	.contentArea{
		width: 70%;
		margin:0 auto;
		margin-top: 50px;
	}
	.goodsNavi{
	
	}
	 .goodsDetails,.goodsImg{
		display: inline-block;
		float:left;
		width:50%;
		height:600px;
	} 
	
	.goodsDesc,.goodsReview{
		text-align: center;
	}
	.goodsReview > table{
		width:80%;
	}
	#mainImg{
		width:440px;
		height:440px;
		margin-left: 20%;
	} 
	.sku_price{
		color:red;
	}
</style>
<script type="text/javascript">
 $(function(){
    $(".color_div").click(function(){
        //这个dd就是除点击对象外，所有的a类的div了。
        var dd = $(".color_div").not($(this));
		 $(".color_div").css("border","1px solid red");
		 $(".color_div").css("background-color","red");
		dd.css("border","1px solid gray");
		dd.css("background-color","white");
		$("#showSpec1").text($(this).find("span").eq(0).text());
		/* 选择颜色时,主图显示对应图片 */
		$("#mainImg").attr('src',$(this).children('img').attr("src"));
		/* span标签中是img的规格值,需要去除空格 */
		$("[name='"+$(this).find("span").eq(0).text().trim()+"']").show(); 
		$("[name='"+$(this).find("span").eq(0).text().trim()+"']:first").css("border","1px solid red");
		/* 其他图片隐藏 */
		$("#thumbnail_div img[name!='"+$(this).find("span").eq(0).text().trim()+"']").hide();
		var sizeId;
		$(".size_div").each(function () {
              if($(this).css("background-color") === "rgb(255, 0, 0)"){
                 sizeId =  $(this).find("span").eq(1).text().trim();
                
              } 
          });
		//隐藏所有价格
		$(".sku_price").hide();
		/* 价格span的id是颜色id-尺码Id */
		$("#price"+$(this).find("span").eq(1).text().trim()+"-"+sizeId).show();
		//隐藏所有库存
		$(".sku_stock").hide();
			/* 价格span的id是颜色id-尺码Id */
	 	$("#stock"+$(this).find("span").eq(1).text().trim()+"-"+sizeId).show();
		
    	});
    	
    $(".size_div").click(function(){
        //这个dd就是除点击对象外，所有的a类的div了。
        var dd = $(".size_div").not($(this));
		 $(".size_div").css("border","1px solid red");
		 $(".size_div").css("background-color","red");
		dd.css("border","1px solid gray");
		dd.css("background-color","white");
		$("#showSpec2").text($(this).find("span").eq(0).text());
		
		var colorId;
		$(".color_div").each(function () {
              if($(this).css("background-color") === "rgb(255, 0, 0)"){
                 colorId =  $(this).find("span").eq(1).text().trim();
                
              } 
          });
		//隐藏其他价格
		$(".sku_price").hide();
		/* 价格span的id是颜色id-尺码Id */
		$("#price"+colorId+"-"+$(this).find("span").eq(1).text().trim()).show();
		//隐藏所有库存
		$(".sku_stock").hide();
			/* 价格span的id是颜色id-尺码Id */
	 	$("#stock"+colorId+"-"+$(this).find("span").eq(1).text().trim()).show();
		
    });
    $(".thumbnail_img").click(function(){
    	$("#mainImg").attr('src',$(this).attr("src"));
    	 $(".thumbnail_img").css("border","1px solid gray");
    	 $(this).css("border","1px solid red");
    	
    });
}); 
 var amount = parseInt($("#amount").text());
function increaseNum(){
	if(parseInt($("#amount").text()) <50){
		$("#amount").text(parseInt($("#amount").text())+1);
	}
}
function reduceNum(){
	if(parseInt($("#amount").text()) >1){
		$("#amount").text(parseInt($("#amount").text())-1);
	}
}
</script>
</head>
<body>
	
	<div class="contentArea">
		<div class="goodsNavi">
			<a href="">首页</a>&gt;
			<c:if test="${spu.sex == 1}"><a href="">男装</a>&gt;</c:if>
			<c:if test="${spu.sex == 0}"><a href="">女装</a>&gt;</c:if>

			<a href="">${parent_full_name }</a>&gt;
			<a href="">${sub_full_name }</a>&gt;
			<b>${spu.goods_name }</b>
			
		</div>
		<div class="anchor">
			<a>${spu.goods_name }</a>
			<a>产品描述</a>
			<a>评论</a>
			<hr>
		</div>
		<div class="buyGoodsArea">
			<div class="goodsImg">
				<div>
					<img alt="范德萨发生的" src="/imgPath${imgArr[0].img_path }${imgArr[0].img_name}" id="mainImg">
				</div>
				<div style="margin-left: 20%;" id="thumbnail_div">
					<c:forEach items="${imgArr}" var="img">
								 <c:if test="${ img.img_spec_value ne 'details_img'}"> 
											<img alt="范德萨发生的" src="/imgPath${img.img_path }${img.img_name}" name="${img.img_spec_value}" class="thumbnail_img" style="width: 50px;height: 50px;display:none;" onclick="">
								</c:if> 
							</c:forEach>
				</div>
			</div>
			<div class="goodsDetails">
				<form action="">
					<table>
					<tr>
						<td>颜色:</td> 
							<c:forEach items="${imgArr}" var="img">
							<!-- 相同颜色的图片只取一张 -->
								<c:if test="${img.img_spec_value ne 'details_img' && img.img_spec_value ne spec_value }">
									<td>
										<div class="color_div" style="border: 1px solid gray;margin-right: 10px" >
											<img alt="范德萨发生的" src="/imgPath${img.img_path }${img.img_name}" class="img_spec" style="width: 50px;height: 50px">
											<c:forEach items="${spec_valueArr}" var="spec_value1">
												<c:if test="${ spec_value1.spec_id == 1 && spec_value1.spec_value == img.img_spec_value}">
															<span >${spec_value1.spec_value}</span>
															<span style="display: none">${spec_value1.id }</span>
												</c:if> 
											</c:forEach> 
										</div>
									</td>
									<c:set var="spec_value" value="${img.img_spec_value }"></c:set>
								</c:if>
							</c:forEach>
					</tr>
					<tr>	
						<td>尺码:</td>
						<c:forEach items="${spec_valueArr}" var="spec_value2">
							<c:if test="${ spec_value2.spec_id == 2}">
								<td>
									<div class="size_div"  style="border: 1px solid gray;margin-right: 10px">
										<span >${spec_value2.spec_value}</span>
										<span style="display: none">${spec_value2.id }</span>
									</div>
								</td>	
							</c:if> 
						</c:forEach> 
					</tr>
					<tr>
						<td>库存:</td>
						<td>
							 <c:forEach items="${skuArr}" var="sku">
						 		<span id="stock${sku.sku_spec_value }" class="sku_stock" style="display: none">${sku.stock }</span>
							 </c:forEach>
						</td>
					</tr>
					
					<tr  >
						<td>售价:</td> 
						 <td>
							 <c:forEach items="${skuArr}" var="sku">
						 		<span id="price${sku.sku_spec_value }" class="sku_price" style="display: none">￥${sku.price }</span>
							 </c:forEach>
						 </td>
					</tr>
					
					
					<tr>
						<td>购买数量:</td>
						<td><span onclick="reduceNum()">-</span> <span id="amount">1</span> <span onclick="increaseNum()">+</span></td>
					</tr>
					<tr><td>已选:</td><td><span id="showSpec1" style="margin: 0px 10px">-未选择颜色-</span></td>  <td><span id="showSpec2">-未选择尺码-</span></td></tr>
					
					<tr>
						<td><input type="submit" value="立刻购买"></td> 
						<td><input type="submit" value="加入购物车"></td></tr>
					</table>
				
				
				</form>
				
			</div>
			<hr>
		</div>
		<div class="goodsDesc">
			<c:forEach items="${imgArr}" var="img">
				<c:if test="${img.img_spec_value eq 'details_img' }">
					<img alt="范德萨发生的" src="/imgPath${img.img_path }${img.img_name}" class="" style="width: 90%;height: 90%">
				</c:if>
			</c:forEach>	
			<hr>
		</div>
		<div class="goodsReview">
			
				<table>
					<tr><td><b>最新评论</b><b>发表评论</b></td></tr>
					<tr><td>评论详情+具体商品</td><td>评论的用户</td></tr>
					<tr><td>评论详情+具体商品</td><td>评论的用户</td></tr>
				</table>
				
				
			
				
			
		</div>
	</div>
	
	
	
	
</body>
</html>