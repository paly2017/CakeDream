
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

/*****
 * 订单管理，未支付，支付完成，已发货，已完成 按钮
 */

function paying(payStatus,index) {
    if (!jQuery.isNumeric(index)){
        index = 0;
    }
    $.ajax({
        type:"POST",
        url:"/paysataus",
        data:{paying:payStatus, pageindex:index},
        success:function (msg) {
            $("table").empty();
            $("#page").empty();
            $("table").append("  <tr><th width='5%'>ID</th><th width='5%'>总价</th><th width='15%'>商品详情</th>' " +
                " <th width='20%'>收货信息</th><th width='10%'>订单状态</th>' " +
                " <th width='10%'>支付方式</th> <th width='10%'>下单用户</th>' " +
                " <th width='10%'>下单时间</th><th width='10%'>操作</th></tr>")
            var paystatus;
            var orderinfo = jQuery.parseJSON(msg);
            var paytype;
            var page=1;
            var pageIndex=1;
            if (payStatus===1){
                paystatus="未支付"
            };
            if (payStatus===2){
                paystatus="已支付"
            };
            if (payStatus===3){
                paystatus="已发货"
            };
            if (payStatus===4){
                paystatus="已完成"
            };
            orderinfo.forEach(function (value, index) {
                page = value.pageCount;
                pageIndex = value.pageIndex;
                if (value.order.paytype===1){
                    paytype="微信支付"
                }else if(value.order.paytype===2){
                    paytype="支付宝"
                }else {
                    paytype="货到付款"
                }
                if(index<4) {
                    $("table").last().append(" <tr> " +
                        "        <td><p>" + index + "</p></td> " +
                        "        <td><p>" + value.order.total + "</p></td>" +
                        "        <td>" + value.good.name + " (" + value.good.price + ")x" + value.item.amount + "</td> " +
                        "        <td>" +
                        "            <p>" + value.user.name + "</p> " +
                        "            <p>" + value.user.phone + "</p> " +
                        "            <p>" + value.user.address + "</p> " +
                        "        </td> " +
                        "        <td>" +
                        "            <p> " +
                        "                <span style=\"color:green;\">" + paystatus + "</span> " +
                        "            </p> " +
                        "        </td> " +
                        "        <td> " +
                        "            <p> " +
                        "                <span style=\"color:green;\">" + paytype + "</span>' " +
                        "            </p>' " +
                        "        </td> " +
                        "        <td><p>" + value.user.username + "</p></td> " +
                        "        <td><p>" + value.order.systime + "</p></td> " +
                        "        <td> " +
                        "            <a class=\"btn btn-success\" onclick=\"goOrder(36)\">发货</a> " +
                        "            <a class=\"btn btn-danger\" onclick=\"deleteOrder(36)\">删除</a> " +
                        "        </td>" +
                        "    </tr>");
                }
            });
            $("table").trigger("create");
            $("#page").append("<a class='btn btn-info' onclick='paying("+payStatus+","+1+")'>首页</a>" +
                "    <a class='btn btn-info' id=\"page2\" onclick='paying("+payStatus+","+parseInt(pageIndex-1)+")'>上一页</a>\n" +
                "    <h2 style='display:inline;' id='page1'>[<span id=\"page4\" >"+pageIndex+"</span>/<span id=\"page5\">"+page+"</span>]</h2>\n" +
                "    <h2 style='display:inline;'id=\"page6\">["+page+"]</h2>\n" +
                "    <a class='btn btn-info' id=\"page3\" onclick='paying("+payStatus+","+parseInt(pageIndex+1)+")'>下一页</a>\n" +
                "    <a class='btn btn-info'  onclick='paying("+payStatus+","+page+")'>尾页</a>\n" +
                "    <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info'onclick=\"pagenext(this.previousSibling.value )\">GO</a>\n")
            $("#page").trigger("create")

        }
    })
}
