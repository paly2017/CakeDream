$.validator.setDefaults({
    submitHandler: function(form) {
        alert("提交事件!");
    }
});

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
                rangelength:[4,10]
            },
            password:{
                required:true,
                rangelength:[4,10]
            },
            name:{
                required:true
            },
            phone:{
                required:true
            },
            address:{
                required:true
            }
        },
       //错误提示消息
        messages:{
            username:{
                required:"请输入用户名！",
                rangelength:"用户名长度在 4-10 之间！"
            },
            password:{
                required:"请输入密码！",
                rangelength:$.validator.format("密码长度在 4-10 之间！")
            },
            name:{
                required:"请输入收货人姓名！"
            },
            phone:{
                required:"请输入电话！"
            },
            address:{
                required:"请输入收货人地址！"
            }
        }

    });



});
