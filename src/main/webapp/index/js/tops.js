/*
tops页面的go跳转*/

function go(type,obj) {
    $(document).ready(function () {
        var goValue= $("#hotgo").val();
        if(isNaN(goValue)){
            $(obj).attr("href","/tops?type="+type+"&pageNum=1&admin=1");
        }else{
            $(obj).attr("href","/tops?type="+type+"&pageNum="+parseInt(goValue)+"&admin=1");
        }
    });

}