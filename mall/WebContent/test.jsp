<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script> 
<style type="text/css">
	 .uploadImgBtn {

        width: 100px;
        height: 100px;
        cursor: pointer;
        position: relative;
        background: url("img/咸鱼.jpg") no-repeat;
        -webkit-background-size: cover;
        background-size: cover;
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
    //这是一个用做回显的盒子的样式
    .pic{
        width: 100px;
        height: 100px;
    }
    .pic img {
        width: 100px;
        height: 100px;
    }

</style>
<script>
    $(document).ready(function(){
        //为外面的盒子绑定一个点击事件
        $("#uploadImgBtn").click(function(){
            /*
            1、先获取input标签
            2、给input标签绑定change事件
            3、把图片回显
             */
//            1、先回去input标签
            var $input = $("#file");
//            2、给input标签绑定change事件
            $input.on("change" , function(){
                //补充说明：因为我们给input标签设置multiple属性，因此一次可以上传多个文件
                //获取选择图片的个数
                var files = this.files;
                var length = files.length;
                console.log("选择了"+length+"张图片");
                //3、回显
                $.each(files,function(key,value){
                    //每次都只会遍历一个图片数据
                    var div = document.createElement("div"),
                        img = document.createElement("img");
                    div.className = "pic";

                    var fr = new FileReader();
                    fr.onload = function(){
                        img.src=this.result;
                        div.appendChild(img);
                        document.body.appendChild(div);
                    }
                    fr.readAsDataURL(value);
                })

            })
        })

    })

</script>

<body>
	<a href="TestPool" >第三方第三方即可</a>
	<form action="ImgTestServlet" method="post" enctype="multipart/form-data">
	<div class="uploadImgBtn" id="uploadImgBtn">
        <input class="uploadImg" type="file" name="file" multiple id="file">
    </div>
    <input type="submit">
    </form>
</body>
</html>