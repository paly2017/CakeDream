
/*
 登录注册的表单验证--validate
*/
//文档就绪函数
$().ready(function () {
    //当前表单调用validate方法，实现表单验证
    //注册验证
   $("#rf").validate({
       // 当标签获得焦点时暂时清除表单验证
       focusCleanup:true,
       //当标签失去焦点时进行表单验证
       onfocusout: function (element) {
           $(element).valid();
       },
       //规则--必填、长度
        rules:{
            username:{
                required:true,
                rangelength:[4,10],
                remote: {
                    type: "POST",
                    url: "/deal",     //后台处理程序
                    data: {                     //要传递的数据
                        "username": function () {
                            return $("#user").val();
                        }
                    }
                }
            },
            password:{
                required:true,
                rangelength:[4,10]
            },
            name:{
                required:true
            },
            phone:{
                required:true,
                phone:true
            },
            address:{
                required:true
            }
        },
       //错误提示消息
        messages:{
            username:{
                required:"请输入用户名！",
                rangelength:"用户名长度在 4-10 之间！",
                remote:$.validator.format("用户名已存在！")
            },
            password:{
                required:"请输入密码！",
                rangelength:$.validator.format("密码长度在 4-10 之间！")
            },
            name:{
                required:"请输入收货人姓名！"
            },
            phone:{
                required:"请输入电话！",
                phone:"电话号码格式错误！"
            },
            address:{
                required:"请输入收货人地址！"
            }
        }

    });
   //自定义电话校验规则
    jQuery.validator.addMethod("phone", function(value){
        var reg ="^((1[3,8][0-9])|(14[5,7])|(15[^4\\D])|(166)|(17[3,5,6,8])|(19[8,9]))\\d{8}$";
        if(reg.test(value) && value.length==11){
            return true;
        }else{
            return false;
        }

    });

    /* //当用户名失去焦点时发送aJax请求
     $("#user").click(function () {
         alert("进入js")
         $.ajax({
             type:"post",
             url:"/deal",
             data:{
                 "username":$(this).val()
             },
             success:function (user) {
                 var obj=  jQuery.parseJSON(user);
                 if(obj==null){
                     $(this).html(obj.username);
                 }else{
                     $(this).html("");
                     $("#uspan").html("用户名已存在！")
                 }
             }
         })
     })/register = anon
     function test() {
         alert("这是一个测试")
     }*/
});

