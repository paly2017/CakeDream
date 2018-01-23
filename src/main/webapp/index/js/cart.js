
/**
 * 加入购物车
 */

    //ajax请求--加入购物车
    function add(obj,goodid) {
            $.ajax({
                type: "POST",
                url: "/getgood",
                data: {
                    "goodid": goodid
                },
                success: function (data) {
                    if (data == "empty") {
                        alert("库存不足")
                    }else{
                        //将json字符串转换成json对象
                        var jsonCart = jQuery.parseJSON(data);
                        //然后改变属性显示
                        $(obj).siblings("h3").eq(2).find("span").html("数量:"+jsonCart.count);
                    }

                }

            })
    }

/**
 * 购物车减去
 */
//ajax请求--加入购物车
    function dec(obj,goodid) {
    $.ajax({
        type: "POST",
        url: "/deccart",
        data: {
            "goodid": goodid
        },
        success:function (data) {
            if(data=="success"){
                location.reload();  //重新刷新页面
            }else{
                //将json字符串转换成json对象
                var jsonCatr = jQuery.parseJSON(data);
                //然后改变属性显示
                $(obj).siblings("h3").eq(2).find("span").html("数量:"+jsonCatr.count);
            }

        }
    })
}
/**
 * 购物车删除
 */
    function delet(goodid) {
    $.ajax({
        type: "POST",
        url: "/deletcart",
        data: {
            "goodid": goodid
        },
        success:function (data) {
            if(data=="sussess"){
                location.reload();  //重新刷新页面
            }

        }
    })

    }
