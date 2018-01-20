$().ready(function () {
    //当前表单调用validate方法，实现表单验证
    //注册验证
    $("#lf").validate({
        // 当标签获得焦点时暂时清除表单验证
        focusCleanup:true,
        //当标签失去焦点时进行表单验证
        onfocusout: function (element) {
            $(element).valid();
        },
        rules:{
            login_username:{
                required:true,
                minlength:5
            },
            login_password:{
                required:true,
                minlength:5
            },
        },
        messages:{
            login_username:{
                required:"请输入用户名！"

            },
            login_password:{
                required:"请输入密码！"
            }
        }

    });

});