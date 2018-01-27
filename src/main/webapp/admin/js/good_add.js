/**
 * 下拉列表框的js
 */

function getType() {
    $(document).ready(function () {
        $.ajax({
            type:"post",
            url:"/getType",
            success:function (type) {
                $("#select_topic").empty();
                var typeObj= jQuery.parseJSON(type);
                //得到所有类目，循环显示
                typeObj.forEach(function (obj){
                        $("#select_topic").append("  <option value="+obj.id+">"+obj.name+"</option>");
                })
            }
        })

});
}