<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script> 
<style type="text/css">
*{
	padding: 0;
	margin: 0;
}	
	.uploadImgdiv{
	 width:200px;
        height: 50px;
	}
	 .uploadImgBtn {

        width:200px;
        height: 80px;
        cursor: pointer;
        position: relative;
        /* background: url("../otherImg/导入图标.jpg") no-repeat; */
       /*  -webkit-background-size: cover;
        background-size: cover; */
        overflow: hidden;
    }

    .uploadImgBtn .uploadImg {
        position: absolute;
        right: 0;
        top:0;
        width: 100%;
        height: 100%;
        opacity: 0;
        cursor: pointer;
    }
   
    table {
    	margin:0 auto;
    	
    }
	
}
	tbody{
		display: block;
		
	}
	
	
 	input{
 		 outline-style: none ;
	    border: 1px solid #ccc; 
	    border-radius: 3px;
	    padding: 13px 14px;
	    width: 150px;
	    font-size: 14px;
	    font-weight: 700;
	    font-family: "Microsoft soft";
 	
 	}
  
	.text{
   
    	width: 300px;
  
	}
	input:focus{
    border-color: #66afe9;
    outline: 0;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
}
	div{
		margin:0 auto;
		width:70%;
		text-align: center;
	}
</style>



<body >
<div>


<!-- controller 会拦截所有.do结尾的请求,进行转发 -->
<form action="GoodsAdd.do" method="post" enctype="multipart/form-data"><!--  --><!-- enctype="multipart/form-data" -->

	
	
	<table id="table1">
		<tbody>
			<tr>
				<td>商品名称:</td>
				<td><input type="text" name="goods_name" class="text"></td>
			</tr>
			<tr>
				<td>商品分组:</td>
				<td>
					<label><input type="radio" name="sex" value="1" checked="checked">男装</label>
					<label><input type="radio" name="sex" value="0">女装</label>
				</td>
			</tr>
			<tr>
				<td>商品类别:</td>
				<td> <select id="first" onChange="nextChange()" name="parent_category_id">
				        <option selected="selected">请选择</option>
				        <option value="1" >衬衫</option>
				        <option value="2">卫衣</option>
				        <option value="3">羽绒服</option>
				        <option value="4">针织衫</option>
				        <option value="5">裤装</option>
				        <option value="6">鞋</option>
				        <option value="7">家居配饰</option>
			   		</select>
				</td>
			
			</tr>
			<tr>
				<td>商品子级类别:</td>
				<td><select id="second" name="sub_category_id">
	       				 <option></option>
	   				 </select>
	   			</td>
			</tr>
	 </tbody>
	
	 <tbody id="t2">
		<tr><td>规格1:颜色</td></tr>
		<tr>															
			<td>颜色</td><td><input type="text" id="ys_pit1" name="spec1"   oninput="cop('ys_pit1')" placeholder="输入颜色" class="text"></td>
		</tr>
		<tr><td></td><td><input type="button" value="添加选项" onclick="addTr('t2','颜色')"></td></tr>
	</tbody>
	<tbody id="t3">
		<tr><td>规格2:尺码</td></tr>
		<tr>
			<td>尺码</td><td><input type="text" id="cm_pit1" name="spec2" oninput="cop('cm_pit1')" placeholder="输入尺码" class="text"></td>
		</tr>
		<tr><td></td><td><input type="button" value="添加选项" onclick="addTr('t3','尺码')"></td></tr>
	</tbody>	
	<tbody id="t4">
		<tr >
			<td >颜色</td>
			<td>尺码</td>
			<td>价格</td>
			<td>库存</td>
		</tr>
		<tr>
			<td><input  name='ys_pit1'  type='text' readonly='readonly'/></td>
			<td><input  name='cm_pit1'  type='text' readonly='readonly'/>
			<td> <input  name='price'  type='text' placeholder="输入价格" class=""/></td>
			<td> <input  name='stock'  type='text' placeholder="输入库存" class=""/></td>
		</tr>
		
	</tbody>
		
	
		
	
		
		
		
	 <tbody id="t5">
	 	<tr><td>商品图片:</td></tr>
		<tr>
			
			<td>
				<div class="" id="" >
        				<input  name='ys_pit1'  type='text' readonly='readonly'/><input class="uploadImgBtn"  type="file" name="sku_img0" multiple >
    			</div>
    			
    		</td>
		</tr>
	</tbody> 
	<tbody>
		<tr>
			<td>商品描述图片:</td>
			<td>
					<div class="" id="">
        				<input class="uploadImgBtn" type="file" name="details_img" multiple >
    				</div>
    		</td>
		</tr>  
	</tbody>
		
	<tbody>
		
		<tr> 	
			<td></td>
			<td><input type="submit" value="添加商品"></td>
		</tr> 
	</tbody>	 
		
	</table>
</form>
</div>

</body>
<script type="text/javascript" src="../js/creatTrTd.js"></script>
<script type="text/javascript" src="../js/displaySub.js"></script>
</html>