/**
 * 下拉列表框的js
 */

$(document).ready(
    $("#select_topic").click(function () {
        $.ajax({
            type:"post",
            url:"/getType",
            success:function (type) {
               var typeObj= jQuery.parseJSON(type);
                //得到所有类目，循环显示
                typeObj.forEach(function (obj,index) {


                })
            }


        })
    })
);