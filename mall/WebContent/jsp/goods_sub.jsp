<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/mall/js/jquery-3.4.1.js"></script> 
<%@ include file="/common/header.jsp" %>
<style type="text/css">
	*{
		margin:0;
		padding:0;
	}
	a{
	    display:inline-block;
		text-decoration: none;
		color: #454545;
	}
	a:link{
		text-decoration: none;
    	color: #454545;
	}
	a:hover {
    	text-decoration: none;
    	color: #A52A2A;
	}
	.contentArea{
		width: 70%;
		margin:0 auto;
		font-size: 16px;
		margin-top: 3em;
	}
	table{
		 border-collapse: collapse;
		 width: 100%;
		 margin:0 auto;
	}
	td{
		border:1px solid gray;
	}
	tr td:first-child{
		width: 6em;
		height:2em;
		text-align: center;
	}
	.sort_div_content{
		width:100%;
		border-top: 1px solid gray;
	}
	.sort_div_head{
		margin-top:1em;
		border-bottom: 0.1em solid #A52A2A;
	}
	.sort_ul>li{
		float: left;
		width: 5em;
		heigth:1.5em;
		text-align: center;
		border: 0.05em solid gray;
	}
	/* 三角形 */
	/* border边框实际上是由4个三角形组成,当长宽为0,设置border为6px solid时,图形为正方形,根据对角线分开,设置border-color即可显示边框,设置为transparent即透明不显示, */
	/* x轴为右方向,y轴为下方向.此时旋转是以正方形中心为旋转中心点;图形旋转的同时,xy轴也旋转.*/
	/* 长方形设置为绝对定位后,根据旋转后的xy轴定位*/
	/* 长方形旋转时以xy轴交点为旋转中心,xy轴同时旋转 */
	 .sort_span {
	    display:inline-block;
	    position: relative;
	   	margin-left:0.2em;
	    height: 0px;
	    width: 0px;
	    border: 0.3em solid;
	    border-color: darkcyan darkcyan transparent transparent;
	    transform: rotate(135deg); 
	     -webkit-transform: rotate(135deg);
	       -moz-transform:rotate(135deg);
	}
	.sort_span:before {
	    content: '';
	    position: absolute;
	    right: 0px;  
	    display: block;
	    height: 0.3em;
	    width: 0.5em;
	    background-color: darkcyan;
	    /* translate:移动 ;transform:变形 */
       transform: rotate(-45deg) translate(0.1em, 0.05em);
       -webkit-transform: rotate(-45deg) translate(0.1em, 0.05em);  
       -moz-transform:rotate(-45deg) translate(0.1em, 0.05em);
	} 
	.red:before{
		background-color:#A52A2A;
	}
	.darkcyan:before{
		background-color:darkcyan;
	}
</style>
<script type="text/javascript">
	$(function(){
		/* 为li添加点击事件,改变箭头的颜色 */
		$(".sort_li").click(function(){
			var spanObj= $(this).find("span").eq(0);
			var otherSpanObj = $(".sort_li").not($(this));
			spanObj.css("border-color","#A52A2A #A52A2A transparent transparent");
			spanObj.removeClass("darkcyan");
			spanObj.addClass("red");
			otherSpanObj.each(function(	){
				$(this).find("span").eq(0).addClass("darkcyan"); 
				$(this).find("span").eq(0).css("border-color","darkcyan darkcyan transparent transparent");
			});
			
		});
	});
	
</script>
</head>
<body>
	<div class="contentArea">
		<div>
			<span>当前位置:<a>所有分类</a></span>
		
		</div>
		
		<div>
			<table>
				<tr>
					<td>男装</td>
					<td><span>111</span></td>
				</tr>
				<tr>
					<td>女装</td>
					<td><span>111</span></td>
				</tr>
			</table>
		</div>
		
		<div class="sort_div_area">
			<div class="sort_div_head">
				<span style="background-color: #A52A2A;color: white;display: inline-block; width: 5em;height:2em;text-align: center;">全部商品</span>
			</div>
			<div class="sort_div_content">
				<ul class="sort_ul">
				<li class="sort_li"><a href="#" title="推荐由高到低" >默认<span class="sort_span" ></span></a></li>
				<li class="sort_li"><a href="#" title="销量由高到低" >销量<span class="sort_span"></span></a></li>
				<li class="sort_li"><a href="#" title="好评由高到低" >好评<span class="sort_span"></span></a></li>
				<li class="sort_li"><a href="#" title="上架新品" >最新<span class="sort_span"></span></a></li>
				<li class="sort_li"><a href="#" title="价格由低到高" >价格<span class="sort_span"></span></a></li>
			</ul>
			</div>
			
		</div>
		
		
	</div>
</body>
</html>