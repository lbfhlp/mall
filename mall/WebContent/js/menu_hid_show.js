/**
 * 二级菜单的展示隐藏
 */
 $(function () {
    var $ali=$("#menu li")
    for(var i=0;i<$ali.length;i++){
      $ali.eq(i).hover(function () {
        if($(this).find("ul").is(':hidden')){
          $(this).find("ul").show()
        }else{
          $(this).find("ul").hide()
        }
      })

    }
  });