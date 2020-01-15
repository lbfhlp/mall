 //流程
//0.获取.wrap div,按钮arrow left arrow right,span
var wrap = document.querySelector(".wrap");
var next = document.querySelector(".arrow_right");
var prev = document.querySelector(".arrow_left");
var index = 0;	//用于标识第几张图片
var timer = null;	//定时器
var dots = document.getElementsByName("span_button");


//1.点击按钮图片切换
next.onclick = function(){
	nextPic();
}
function nextPic() {
	
	index++;
	if(index>4){	//等于4为最后一张
		index=0;
	}
	showCurrentDot();
	
	var newLeft; //切换图片后wrap的左边距
	//当到达最后一张
	if(wrap.style.left==="-5880px"){
		 newLeft = parseInt(wrap.style.left)+3920;	//显示第二张图片
	}else{
		newLeft=parseInt(wrap.style.left)-980;
	}
	
	wrap.style.left=newLeft+"px";
}

prev.onclick=function (){
	prevPic();
}

function prevPic() {
	index--;
	if(index<0){	//等于0为第一张
		index=4;
	}
	showCurrentDot();
	var newLeft;
	if(wrap.style.left!="0px"){
		newLeft=parseInt(wrap.style.left)+980;
	}else{
		newLeft=parseInt(wrap.style.left)-3920;//从5.jsp移动到4.jsp
	}
	wrap.style.left=newLeft+"px";
}
//图片切换时,span也跟着切换(切换到哪个图片,哪个图片的classname=on)

function showCurrentDot() {
	for(var i=0;i<dots.length;i++){
		dots[i].className="";
	}
	dots[index].className="on";
}

//2.点击12345切换到相应图片

	
	for(var i=0,len = dots.length;i<len;i++){
		(function(i){
            dots[i].onclick = function () {
                var dis = index - i;
                //共七张图片,当位于第一张图片,span为4,需要移动5张图片的位置
                if(index==4 && wrap.style.left ==="0px"){
                	dis=dis-5;
                }
                if(index==0 && wrap.style.left ==="-5880px"){
                	dis=dis+5;
                }
                wrap.style.left = (parseInt(wrap.style.left) +  dis * 980)+"px";
                index = i;
                showCurrentDot();
            }
        })(i);     
	}

//3.图片自动播放
function autoPlay() {
	timer = setInterval(() => {
		nextPic();
	}, 2000);
}

autoPlay();

//
function playComment() {
	var container = document.querySelector(".container");
	container.onmouseenter = function() {
		clearInterval(timer);
	}
	
	container.onmouseleave = function() {
		autoPlay();
	}
}
playComment();














