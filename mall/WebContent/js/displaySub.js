function nextChange()
{
    var first = document.getElementById("first");
    var second = document.getElementById("second");
    second.options.length = 0; // 清除second下拉框的所有内容
    if(first.selectedIndex == 1)
    {
        second.options.add(new Option("休闲", "1"));
        second.options.add(new Option("商务", "2"));
    }

    if(first.selectedIndex == 2)
    {
        second.options.add(new Option("开衫", "1"));
        second.options.add(new Option("连帽", "2", false, true));  // 默认选中区
        second.options.add(new Option("圆领", "3"));
    }
    if(first.selectedIndex == 3)
    {
        second.options.add(new Option("羽绒服", "1"));
        second.options.add(new Option("大衣", "2", false, true));  // 默认选中区
        second.options.add(new Option("夹克", "3"));
        second.options.add(new Option("西服", "4"));
    }
    if(first.selectedIndex == 4)
    {
        second.options.add(new Option("棉线衫", "1"));
        second.options.add(new Option("羊毛衫", "2", false, true));  // 默认选中区
        second.options.add(new Option("空调衫", "3"));
    }
    if(first.selectedIndex == 5)
    {
        second.options.add(new Option("针织裤", "1"));
        second.options.add(new Option("休闲裤", "2", false, true));  // 默认选中区
        second.options.add(new Option("牛仔裤", "3"));
        second.options.add(new Option("工装裤", "4"));
    }
    if(first.selectedIndex == 6)
    {
        second.options.add(new Option("跑鞋", "1"));
        second.options.add(new Option("帆布鞋", "2", false, true));  // 默认选中区
        second.options.add(new Option("休闲鞋", "3"));
        second.options.add(new Option("运动鞋", "4"));
        second.options.add(new Option("皮鞋", "5"));
        second.options.add(new Option("凉鞋", "6"));
    }
    if(first.selectedIndex == 7)
    {
        second.options.add(new Option("被子", "1"));
        second.options.add(new Option("毯子", "2", false, true));  // 默认选中区
        second.options.add(new Option("围巾", "3"));
        second.options.add(new Option("枕", "4"));
        second.options.add(new Option("毛巾", "5"));
    }
}
