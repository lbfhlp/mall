var index1 = 2; //控制颜色的行;	
var index2 = 2;	//控制尺码的行;
var index3 = 2;	//控制yanse命名
var index4 = 2;//控制尺码命名;
function addTr(id,spec){
    var tb=document.getElementById(id);
	if(id == "t2" 	){
		if(index1==11){
			alert("最多添加10项");
	 		return;
		}
		
		var newTr=tb.insertRow(index1);
		 var newTd0=newTr.insertCell();
		 newTd0.innerHTML="选项"
        var newTd1=newTr.insertCell();
        newTd1.innerHTML="<input id='ys_pit"+index3+"' type='text' name='spec1' oninput='cop(\"ys_pit"+index3+"\")' placeholder='输入颜色'  class='text'/>";
		var newTd2=newTr.insertCell();//第二格
		newTd2.innerHTML = "<input type='button' value='删除选项'  onclick='deleteTr(\"t2\",\"ys_pit"+index3+"\")' /> ";

		index1++;
		index3++;	
		
	}
	if(id == "t3"){
		if(index2==11){
			alert("最多添加10项");
			return;
		}
		var newTr2=tb.insertRow(index2);
		var newTd20=newTr2.insertCell();
		newTd20.innerHTML="选项";
        var newTd21=newTr2.insertCell();
        newTd21.innerHTML="<input type='text' name='spec2' id='cm_pit"+index4+"' oninput='cop(\"cm_pit"+index4+"\")' placeholder='输入尺码' class='text'/>";
	 	var newTd22=newTr2.insertCell();
		newTd22.innerHTML = "<input type='button' value='删除选项'  onclick='deleteTr(\"t3\",\"cm_pit"+index4+"\")' /> ";
		index2++;
		index4++;
	}
	generatetable();
}
	/**
	 * 用于删除行
	 * @param obj
	 * @param tid
	 * @param no 需要删除的选项;
	 * @returns
	 */
	function deleteTr(tbid,itid){
		
		//删除t2中的选项;
		btnTrElement =document.getElementById(itid).parentNode.parentNode;
		tbodyElemement = btnTrElement.parentNode;
		tbodyElemement.removeChild(btnTrElement);
		
		generatetable();
		
		
		
        
         if(tbid=="t2"){
        	index1--;
        }else if(tbid=="t3"){
        	index2--;
        } 
        
	};
 	
	//用于同步显示;
	 function cop(itid){
		 	
		 	
			var str=document.getElementById(itid).value;
			
			var sits = document.getElementsByName(itid);
			for(var i=0;i<sits.length;i++){
	            sits[i].value = str;
	        }
		
	        
	        
	    };
	    
	/**
	 * 生成规格/价格库存表;
	 * @returns
	 */
	function  generatetable() {
		var t5 = document.getElementById("t5");
		t5.innerHTML="<tr><td>商品图片----------------:</td></tr>";
		var t4 = document.getElementById("t4");
		t4.innerHTML="<tr><td >颜色</td><td>尺码</td><td>价格</td><td>库存</td></tr>";
		//获取t2中的选项个数;
		var t2rows = document.getElementById("t2").rows.length-2;
		//获取t3中选项个数;
		var t3rows = document.getElementById("t3").rows.length-2;
		for(var i=0;i<t2rows;i++){
			//颜色选项的id;用于设置规格/价格库存表;
			var ysid = document.getElementById("t2").rows[i+1].cells[1].firstElementChild.id;
			//生成图片表
			var t5rows = t5.rows.length;
			var t5newTr = t5.insertRow(t5rows);
			var t5newTd0 = t5newTr.insertCell(0);
			t5newTd0.innerHTML = "<div class='' id='' ><input  name='"+ysid+"'  type='text' readonly='readonly'/><input class='uploadImgBtn'  type='file' name='sku_img"+i+"' multiple ></div>";
			
			for(var j=0;j<t3rows;j++){
				var cmid = document.getElementById("t3").rows[j+1].cells[1].firstElementChild.id;
				var t4rows = t4.rows.length;
				var t4newTr = t4.insertRow(t4rows);
				//每个颜色选项只合并赋值一次
				if(j==0){
					var t4newTd0 = t4newTr.insertCell(0);
					t4newTd0.innerHTML = "<input  name='"+ysid+"'  type='text' readonly='readonly'/>";
					t4newTd0.setAttribute("rowspan",t3rows);
					cop(ysid);
				}
				var t4newTd1 = t4newTr.insertCell();
				t4newTd1.innerHTML = "<input  name='"+cmid+"'  type='text' readonly='readonly'/>";
				cop(cmid);
				var t4newTd2 = t4newTr.insertCell();
				t4newTd2.innerHTML="<input  name='price'  type='text' placeholder='输入价格' class=''/>";
				var t4newTd3 = t4newTr.insertCell();
				t4newTd3.innerHTML="<input  name='stock'  type='text' placeholder='输入库存' class=''/>";
			}
		}
		
	}
	    
	    
	    