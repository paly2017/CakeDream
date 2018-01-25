

// 判断输入的原密码是否正确
//文档就续函数
$(document).ready(function () {
    //提交的表单
    $("#change").validate({
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
                    url:"/check",
                    data:{
                        "psw":function () {
                            return $("#yuan").val();
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


    // 判断输入的原密码是否正确


    $("#add").click(function () {
        //修改表单提交路径
        $.ajax({
            type: "POST",
            url: "/addInfo",
            data: {
                "name": $(".aname").val(),
                "phone": $(".aphone").val(),
                "address": $(".address").val()
            },
            success:function (data) {
                if(data=="success"){
                    alert("信息修改成功！")
                }else{
                    alert("信息修改失败！")
                }
            }
        })
    });


    $("#modify").click(function () {
        //修改表单提交路径
        $.ajax({
            type: "POST",
            url: "/modifyPsw",
            data: {
                "passwordNew": $(".newPsw").val()
            },
            success:function (data) {
                if(data=="success"){
                    alert("密码修改成功！")
                }else{
                    alert("密码修改失败！")
                    location.reload();  //重新刷新页面
                }
            }
        })
    });

});
