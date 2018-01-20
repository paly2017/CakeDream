


/*
 admin中用到的jQ部分
*/


//文档就绪函数
($(document).ready(function () {
    //登录用户名和密码的非空判断
      $("#username").focus(function () {
          //提示输入用户名
          $("#unspan").html("(*请输入用户名)").css("color","red").fadeOut(1000);
      });

//非空判断
//鼠标移出事件--移出时判断是否为空
    $("#username").blur(function ()  {
        if($(this).var()==null ||$(this).var()=="" ){
            $("#unspan").html("(*用户名不能为空！！！)").css("color","red").fadeOut(3000);
            $(".form-horizontal").attr("action","#");
        }else{
            $(".form-horizontal").attr("action","login.action")
        }
    });




    //密码判断
    $("#password").focus(function () {
        //提示输入用户名
        $("#pswspan").html("(*请输入密码)").css("color","red").fadeOut(3000);
    });

//非空判断
//鼠标移出事件--移出时判断是否为空
    $("#password").blur(function () {
        if($(this).var()==null ||$(this).var()=="" ){
            $("#pswspan").html("(*密码不能为空！！！)").css("color","red").fadeOut(1000);
            $(".form-horizontal").attr("action","#");
        }else{
            $(".form-horizontal").attr("action","login.action")
        }
    });











}))(jQuery);
