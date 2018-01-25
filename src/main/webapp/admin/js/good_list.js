/**
 * 处理商品管理页面的go跳转页面
 */

function goTop(type,obj) {
    $(document).ready(function () {
        //获取页码input输入的页码
        var num = $(".form-control").val();
        //不是数字
        if (isNaN(num)) {
            //设置herf属性跳到第一页
            $(obj).attr("href", "/tops?type=" + type + "&pageNum=1&admin=2");
        } else {
            //设置herf属性跳到第指定页
            $(obj).attr("href", "/tops?type=" + type + "&pageNum=" + num + "&admin=2");
        }
    });
}
    function goGood(obj) {
        $(document).ready(function () {
            //获取页码input输入的页码
            var num=$(".form-control").val();
            if(isNaN(num)){
                $(obj).attr("href","/allGood?pageNum=1");
            }else{
                $(obj).attr("href","/allGood?pageNum="+num);
            }

        });
}


