

/*
实现飞入购物车效果
*/

$().ready(function () {
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