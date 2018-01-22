
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
    $(this).ready(function () {
            $.ajax({
                type:"post",
                url:"/getgood",
                data:{goodid:goodId},
                success:function (msg) {
                    var  jsontype =  jQuery.parseJSON(msg);
                    $("#mincart").children("tr").append("")
                }
            })
    })
}
