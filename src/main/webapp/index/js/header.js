$(document).ready(function () {

    //购物车图标计算总价钱
    $("#cart").mouseover(function () {
        var s =$(".spice").add();
        var pay=0;
        //计算购物车总价钱
        for (var i=0;i<s.length;i++){
            var ss =s.eq(i).html()
            pay+=parseInt(ss);
        }
        //当前总价钱赋值
        $("#mypay").html(pay);
        //购物车商品数量赋值
        $("#card_num").html(s.length);
    });
    /***
     * $("form tr td button")获取表单所有button对象，通过点击事件触发函数（根据增加或者减少改变购物悬浮窗口
     * 商品的数量及价钱，总价钱）
     * $(this)当前点击对象
     * $(this).parent().siblings().add()当前点击对象所有的父对象
     * obj.eq(2).find("span")第三个父对象下的span标签对象
     */
     $("form tr td button").click(function () {
        if($(this).html()=="加"){
            var obj = $(this).parent().siblings().add();
            var num = obj.eq(2).find("span").html();
            num = parseInt(num)+1;
            obj.eq(2).find("span").html(num);
            obj.eq(1).find("span").html(num*120 );
            var s =$(".spice").add();
            var pay=0;
            for (var i=0;i<s.length;i++){
                var ss =s.eq(i).html()
                pay+=parseInt(ss);
            }
            $("#mypay").html(pay);
        }else {
            var obj = $(this).parent().siblings().add();
            var num = obj.eq(2).find("span").html();
            num = parseInt(num)-1;
            if (num<=0){
                num=0;
            }
            obj.eq(2).find("span").html(num);
            obj.eq(1).find("span").html(num*120 );
            var s =$(".spice").add();
            var pay=0;
            for (var i=0;i<s.length;i++){
                var ss =s.eq(i).html()
                pay+=parseInt(ss);
            }
            $("#mypay").html(pay);
        }
     });
    /*****
     * header 业务请求 商品分类功能
     */
    // count 控制li标签循环次数
    var count = 0;
    $("#itemclass").click(function () {
        $.ajax({
            type:"post",
            url:"/classes",
            success:function (msg,status) {
              var  jsontype =  jQuery.parseJSON(msg);
                jsontype.forEach(function (value, index) {
                    count++;
                    if (count<=jsontype.length){
                        var id = parseInt(index)+1;
                        $("#typeli").append("<li><a class='list' href='goods.html' id='"+id+"' >"+value.name+"</a></li>")
                    }
                })
            }
        })
        })
});