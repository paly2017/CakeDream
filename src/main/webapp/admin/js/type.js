/***
 * 删除type
 * @param typeId
 */
function deteleType(typeId) {
    $.ajax({
        type:"post",
        url:"/deteleType",
        data:{deleteTypeId:typeId},
        success:function (msg) {
            if (msg==="no"){
                alert("不可以删除")
            }else {
                $("table").empty();
                $("table").append(" <tr> " +
                    "        <th width='5%'>ID</th>" +
                    "        <th width='10%'>名称</th> " +
                    "        <th width= '10% '>操作</th> " +
                    "    </tr>");
                $("table").trigger("create");
                var typelist = jQuery.parseJSON(msg);
                typelist.forEach(function (value,index) {
                    $("table").last().append("  <tr> " +
                        "        <td><p>"+index+"</p></td> " +
                        "        <td><p>"+value.name+"</p></td> " +
                        "        <td> " +
                        "            <a class= 'btn btn-primary ' href='/typeedit?="+value.id+"'>修改</a> " +
                        "            <a class= 'btn btn-danger ' onclick= 'deteleType("+value.id+") '>删除</a> " +
                        "        </td> " +
                        "    </tr>")
                });
                $("table").trigger("create");
                alert("删除成功")

            }
        },
        error:function () {
           alert("网络故障")
        }

    })
}
