
/***
 * 发货
 */
function goOrder(orderid) {
    $.ajax({
        type:"post",
        url:"/goorder",
        data:{goid:orderid},
        success:function (msg) {
            if (msg==="ok"){
                $(this).parent().siblings().eq(4).find("p").find("span").text("已发货")
            }
            if(msg==="no"){
                alert("发货失败")
            }

        },
        error:function () {
            alert("发货失败");
        }
    })
}

/****
 * 删除订单
 * @param goodid
 */
function deleteOrder(goodid) {
    $.ajax({
        type:"post",
        url:"/deleteorder",
        data:{deleteorderid:goodid},
        success:function (msg) {
            if (msg=="ok"){
                $(this).parent().parent().remove()
            }
            if(msg=="no"){
                alert("删除失败")
            }
        }
    })
}




