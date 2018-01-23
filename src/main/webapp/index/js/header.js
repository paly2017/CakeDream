$(document).ready(function () {
    //购物车图标计算总价钱
    $("#cart").mouseover(function () {
        var s =$(".spice").add();
        var pay=0;
        //计算购物车总价钱
        for (var i=0;i<s.length;i++){
            var ss =s.eq(i).html();
            pay+=parseInt(ss);
        }
        //当前总价钱赋值
        $("#mypay").html(pay);
        //购物车商品数量赋值
        $("#card_num").html(s.length);
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
                        $("#typeli").append("<li><a class='list' href='/typegoogs?typeId="+id+"'>"+value.name+"</a></li>")
                    }
                })
            }
        })
        });

});

