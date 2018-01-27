/****
 * 商品订单分页请求
 * @param index
 */
function pagenext(index) {
    alert(index);
    $.ajax({
        type:"post",
        url:"/pageindex",
        data:{pageindex:index},
        success:function (msg) {
            alert(msg)
            $("table").empty();
            $("table").append("<tr>\n" +
                "        <th width=\"5%\">ID</th>\n" +
                "        <th width=\"5%\">总价</th>\n" +
                "        <th width=\"15%\">商品详情</th>\n" +
                "        <th width=\"20%\">收货信息</th>\n" +
                "        <th width=\"10%\">订单状态</th>\n" +
                "        <th width=\"10%\">支付方式</th>\n" +
                "        <th width=\"10%\">下单用户</th>\n" +
                "        <th width=\"10%\">下单时间</th>\n" +
                "        <th width=\"10%\">操作</th>\n" +
                "    </tr>\n");
            var msgObj = jQuery.parseJSON(msg);
            var count=0;
            msgObj.forEach(function (value) {
                alert("123")
                var paytype;
                if (value.order.paytype==1){
                     paytype="微信支付";
                }else if (value.order.paytype==2){
                    paytype="支付宝";
                }else {
                    paytype="货到付款";
                }
                var paystats;
                if (value.order.status==1){
                    paystats="未付款"
                }else if (value.order.status==2){
                    paystats="已付款"
                }else if (value.order.status==3){
                    paystats="已发货"
                }else {
                    paystats="已收货"
                }
                ++count;
                $("table").append("<tr>"+
                "<td><p>"+count+"</p></td>"+
                "<td><p>"+value.order.total+"</p></td>"+
                "<td>"+value.good.name+" ("+value.good.price+")x"+value.order.amount+"</td>"+
                "<td>"+
                "<p>"+value.user.name+"</p>"+
                "<p>"+value.user.phone+"</p>"+
                "<p>"+value.user.address+"</p> </td><td> <p>"+
                "<span style='color:red;'>"+paystats+"</span>"+
                " </p> </td> <td> <p>"+
                    "<span style='color:green;'>"+paytype+"</span>"+
                "</p> </td> <td><p>"+value.user.username+"</p></td>"+
              "  <td><p>"+value.order.systime+"</p></td> <td>"+
                "<input type='hidden' value='"+value.order.id+"'><a class='btn btn-success' onclick='goOrder("+value.good.id+")'>发货</a>"+
                    "<a class='btn btn-danger' onclick='deleteOrder("+value.good.id+")'>删除</a> </td> </tr>")
            });

            if (index<=0){
                index=1;
            }
            var maxpage = $("#page5").html();
            if (maxpage<index){
                index=maxpage;
            }
            //设置分页属性
            $("#page4").html(index);
            $("#page2").attr("onclick","pagenext("+parseInt(index-1)+")");
            $("#page3").attr("onclick","pagenext("+parseInt(index+1)+")");
        }
    })
}

/***
 * 发货
 */
function goOrder(orderid) {
    $.ajax({
        type:"post",
        url:"/goorder",
        data:{goid:orderid},
        success:function (msg) {
            if (msg=="ok"){
                $(this).parent().siblings().eq(4).find("p").find("span").text("已发货")
            }
            if(msg=="no"){
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
                alert( $(this).parent().parent());
                $(this).parent().parent().remove()
            }
            if(msg=="no"){
                alert("发货失败")
            }
        }
    })
}

function nopay(count,index) {
    $.ajax({
        type:"post",
        url:"/nopay",
        data:{orderstatu:count,pageIndex:index},
        success:function (msg) {
            $("table").empty();
            $("table").append("<tr>\n" +
                "        <th width=\"5%\">ID</th>\n" +
                "        <th width=\"5%\">总价</th>\n" +
                "        <th width=\"15%\">商品详情</th>\n" +
                "        <th width=\"20%\">收货信息</th>\n" +
                "        <th width=\"10%\">订单状态</th>\n" +
                "        <th width=\"10%\">支付方式</th>\n" +
                "        <th width=\"10%\">下单用户</th>\n" +
                "        <th width=\"10%\">下单时间</th>\n" +
                "        <th width=\"10%\">操作</th>\n" +
                "    </tr>\n");
            var msgObj = jQuery.parseJSON(msg);
            var count=0;
            var pagecount=0
            msgObj.forEach(function (value) {
                pagecount =value.pageCount;
            var paytype;
            if (value.order.paytype==1){
                paytype="微信支付";
            }else if (value.order.paytype==2){
                paytype="支付宝";
            }else {
                paytype="货到付款";
            }
                    var paystats;
                    if (value.order.status==1){
                        paystats="未付款"
                    }else if (value.order.status==2){
                        paystats="已付款"
                    }else if (value.order.status==3){
                        paystats="已发货"
                    }else {
                        paystats="已收货"
                    }
            ++count;
            $("table").append("<tr>"+
                "<td><p>"+count+"</p></td>"+
                "<td><p>"+value.order.total+"</p></td>"+
                "<td>"+value.good.name+" ("+value.good.price+")x"+value.order.amount+"</td>"+
                "<td>"+
                "<p>"+value.user.name+"</p>"+
                "<p>"+value.user.phone+"</p>"+
                "<p>"+value.user.address+"</p> </td><td> <p>"+
                "<span style='color:red;'>"+paystats+"</span>"+
                " </p> </td> <td> <p>"+
                "<span style='color:green;'>"+paytype+"</span>"+
                "</p> </td> <td><p>"+value.user.username+"</p></td>"+
                "  <td><p>"+value.order.systime+"</p></td> <td>"+
                "<input type='hidden' value='"+value.order.id+"'><a class='btn btn-success' onclick='goOrder("+value.good.id+")'>发货</a>"+
                "<a class='btn btn-danger' onclick='deleteOrder("+value.good.id+")'>删除</a> </td> </tr>")

        });
            //设置分页属性
            if (pagecount<=0){
                pagecount=1;
            }
            $("#page4").html(index);
            $("#page5").text(pagecount);
            $("#page6").text("["+pagecount+"]");
            $("#page2").attr("onclick","pagenext("+parseInt(index-1)+")");
            $("#page3").attr("onclick","pagenext("+parseInt(index+1)+")");

        }
    })
}


