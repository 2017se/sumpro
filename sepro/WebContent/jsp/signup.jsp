<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>注册</title>
    <style type="text/css">
        .content
        {
            width: 400px;
            height: auto;
            margin: 0 auto;
            border: 1px solid #CCC;
            text-align: center;
        }
        .content ul
        {
            list-style: none;
            padding: 0;
        }
        .content ul li
        {
            line-height: 40px;
        }
        span
        {
            font-weight: bold;
            color: Red;
            font-size: 12px;
        }
        .pwdstrength
        {
            width: 50px;
            height: 25px;
            float: left;
            background-color: #CCC;
            color: #999;
            font-size: 12px;
            font-weight: bold;
        }
    </style>
    <script type="text/JavaScript">
        //刚加载页面的时候焦点移到用户名文本框内
        function myFocus() {
            document.getElementById("txtUserName").focus();
        }
        //设置cookie
        function setCookie(str, strValue) {
            var exp = new Date();
            exp.setTime(exp.getTime() + 1 * 24 * 60 * 60 * 1000);
            document.cookie = str + "=" + strValue + ";expires=" + exp.toGMTString();
            location.href = "Login.htm"; //接收页面
        }
        //验证用户名和密码
        function validateRegister() {
            var username = document.getElementById("txtUserName").value;
            var password = document.getElementById("txtPassword").value;
            var pwdOk = document.getElementById("pwdOk").value;
            if (blurName(username) && blurPwd(password) && blurPwdOk(pwdOk)) {
                setCookie("username", username);
                setCookie("password", password);
            }
        }
        //验证密码强度
        function pwdValidate() {
            var password = document.getElementById("txtPassword").value;
            if (password.length > 0 && password.length <= 4) {
                return -1;
            }
            else if (password.length > 4 && password.length <= 8) {
                return 0;
            }
            else if (password.length > 8 && password.length <= 12) {
                return 1;
            }
        }
        //焦点移走用户名框
        function blurName(name) {
            if (name == null || name == "") {
                checkName.innerHTML = "用户名不能为空";
            }
            else {
                checkName.innerHTML = "用户名可用";
                return true;
            }
        }
        //焦点移走密码框
        function blurPwd(password) {
            if (password == null || password == "") {
                checkPwd.innerHTML = "密码不能为空";
            }
            else if (password.match(/[^A-Za-z0-9]/ig)) {
                checkPwd.innerHTML = "密码必须为数字和字母";
            }
            else {
                if (pwdValidate() == -1) {
                    ruo.style.backgroundColor = "red";
                    zhong.style.backgroundColor = "#CCC";
                    qiang.style.backgroundColor = "#CCC";
                }
                else if (pwdValidate() == 0) {
                    ruo.style.backgroundColor = "#CCC";
                    zhong.style.backgroundColor = "red";
                    qiang.style.backgroundColor = "#CCC";
                }
                else if (pwdValidate() == 1) {
                    ruo.style.backgroundColor = "#CCC";
                    zhong.style.backgroundColor = "#CCC";
                    qiang.style.backgroundColor = "red";
                }
                checkPwd.innerHTML = "密码可用";
                return true;
           }
        }
       //焦点移走确认密码框
        function blurPwdOk(pwdOk) {
            var password = document.getElementById("txtPassword").value;
            if (pwdOk == null || pwdOk == "") {
                checkOk.innerHTML = "确认密码输入不能为空";
            }
            else if (password != pwdOk) {
                checkOk.innerHTML = "两次输入的密码不一致";
            }
            else {
                checkOk.innerHTML = "输入正确";
                return true;
            }
        }
    </script>
</head>
<body onload="myFocus();">
    <div class="content">
        <ul>
            <li>注册</li>
 
            <li>用户名：<input id="txtUserName" name="username" type="text" size="18" onblur="blurName(this.value);" />
                <span id="checkName"></span></li>
            <li>密&nbsp;&nbsp;&nbsp;码：<input id="txtPassword" name="password" type="password" maxlength="12"
                size="20" onblur="blurPwd(this.value);" />
                <span id="checkPwd"></span></li>
            <li style=" padding-left:150px;"><span class="pwdstrength" id="ruo">弱</span> 
                <span class="pwdstrength" id="zhong">中</span> 
                <span class="pwdstrength" id="qiang">强</span> <br /></li>
            <li>确认密码：<input id="pwdOk" name="password" type="password" size="20" onblur="blurPwdOk(this.value)" />
                <span id="checkOk"></span></li>
            <li>
                <input id="Button1" type="button" value="注册" onclick="validateRegister()" />
                <input id="Button2" type="button" value="登录" onclick="javascript:window.location.href('Login.htm')" /></li>
        </ul>
    </div>
</body>
</html>