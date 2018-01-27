// 判断输入的原密码是否正确
//文档就续函数


$(document).ready(function () {
    //提交的表单
    $("#adminForm").validate({
        // 当标签获得焦点时暂时清除表单验证
        focusCleanup:true,
        //当标签失去焦点时进行表单验证
        onfocusout:function (element) {
            $(element).valid();
        },
        rules:{
            password:{
                required:true,
                remote:{
                    type:"post",
                    url:"/checkAdmin",
                    data:{
                        "username":function () {
                            return $("#username").text();
                        },
                        "psw":function () {
                            return $("#input_pass1").val();
                        }
                    }
                }
            },
            passwordNew:{
                required:true,
                rangelength:[4,10]
            }
        },
        messages:{
            password:{
                required:"请输入原来的密码！",
                remote:$.validator.format("原密码输入错误！")
            },
            passwordNew:{
                required:"请输入密码！",
                rangelength:"用户名长度在 4-10 之间！"
            }
        }
    });

    /*//表单提交的ajax请求
    $("#adminSub").click(function () {
        $.ajax({
            type:"post",
            url:"/reAdmin",
            data:{
               "adminName": $("#username").text(),
                "password": $("#input_pass2").val()
            },
            success:function (data) {
                alert(data)
                if(data=="success"){
                    alert("密码修改成功！")
                }else{
                    alert("密码修改失败！")
                    location.reload();  //重新刷新页面
                }
            }
        })
    })*/
});

