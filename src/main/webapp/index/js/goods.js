
/*
实现飞入购物车效果
*/

$(document).ready(function () {
    //获取购物车位置
    var offset =$("#cart").offset();
    $(".items").click(function (event) {
        var addcar = $(this);
        var img = addcar.parents().find('img').attr('src');
        var flyer = $('<img class="u-flyer" src="'+img+'" width="50px" height="50px">');
        flyer.fly({
            start: {
                left: event.pageX,
                top: event.pageY
            },
            end: {
                left: offset.left+10,
                top: offset.top+10,
                width: 0,
                height: 0
            },
            onEnd: function(){
                this.destory();
            }

        });
    });

});

/***
 * 分页请求
 * @param index
 * @param obj
 */
function pageSize(index,obj) {
    $(document).ready(function () {
        $(obj).attr("href","/pageing?index="+index)
    })
}

/***
 * 分页请求go功能
 * @param index
 */
function gopageing(index) {
    $(document).ready(function () {
       var objinput=$("#inputgo").val();
       if (objinput==null||objinput==""){
           $(this).attr("class","disabled");
       }
       if(isNaN(objinput)){
           $(this).attr("class","disabled");
       }
       if (parseInt(objinput)<=index&&parseInt(objinput)>0){
           $("#goto").attr("href","/pageing?index="+parseInt(objinput));
       }else {
           $(this).attr("class","disabled");
       }
    })
}



/***
 * min购物车异步请求
 * @param obj
 * @param goodId
 */

function cartinto(obj,goodId) {
    $(obj).ready(function () {
            $.ajax({
                type:"post",
                url:"/getgood",
                data:{goodid:goodId},
                success:function (msg) {
                    var cartmsg = jQuery.parseJSON(msg);
                    var index=0;
                   $("table").find("*").detach();
                    alert(cartmsg);
                    cartmsg.forEach(function (value) {
                        alert(index);
                        $("#mincart").append(
                            "<tr> <td> <img src='../"+value.good.cover+" 'height='80' width='80'/> </td>"+
                            "<td> <div>"+value.good.name+"</div> <div>价钱：<span class='spice'>"+value.good.price+"</span></div>"+
                            "<div>数量：<span id='cake1'>"+value.count+"</span></div> <div>"+
                            "<button class='btn-success' type='button'onclick='cartsum(this)' >加</button>"+
                            " <button class='btn-success' type='button' onclick='cartsum(this)'>减</button> </div> </td> </tr>"+
                            "<tr> <td></td> <td></td></tr>");
                        index += parseInt(value.count);
                    });
                    $("#card_num").html(index);
                }
            })
    })
}

(function () {
    $.ajax({
        type:"post",
        url:"/newpageing",
        success:function (msg) {
            if (null!=msg){
                var cartmsg = jQuery.parseJSON(msg);
                var index=0;
                cartmsg.forEach(function (value) {
                    $("#mincart").append(
                        "<tr> <td> <img src='../"+value.good.cover+" 'height='80' width='80'/> </td>"+
                        "<td> <div>"+value.good.name+"</div> <div>价钱：<span class='spice'>"+value.good.price+"</span></div>"+
                        "<div>数量：<span id='cake1'>"+value.count+"</span></div> <div>"+
                        "<button class='btn-success' type='button'onclick='cartsum(this)' >加</button>"+
                        " <button class='btn-success' type='button' onclick='cartsum(this)'>减</button> </div> </td> </tr>"+
                        "<tr> <td></td> <td></td></tr>");
                    index += parseInt(value.count);
                });
                $("#card_num").html(index);
            }
        }
    })
})(window);



function cartsum(object) {
    $(document).ready(function () {
        if($(object).html()=="加"){
            var obj = $(object).parent().siblings().add();
            var num = obj.eq(2).find("span").html();
            num = parseInt(num)+1;
            obj.eq(2).find("span").html(num);
            obj.eq(1).find("span").html(num*120 );
            var s =$(".spice").add();
            var pay=0;
            for (var i=0;i<s.length;i++){
                var ss =s.eq(i).html();
                pay+=parseInt(ss);
            }
            $("#mypay").html(pay);
        }else {
            var obj = $(object).parent().siblings().add();
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
                var ss =s.eq(i).html();
                pay+=parseInt(ss);
            }
            $("#mypay").html(pay);
        }
    })

}