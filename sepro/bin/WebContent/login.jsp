<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登录</title>
    <style type="text/css">
        .content
        {
            width: 300px;
            height: auto;
            margin: 0 auto;
            border: 1px solid #CCC;
            text-align:center;
        }
        .content ul
        {
            list-style: none; padding:0;
        }
        .content ul li{ line-height:40px;}
    </style>
    <script type="text/javascript">
        function getCookie(str) {
            var arr = document.cookie.match(new RegExp("(^| )" + str + "=([^;]*)(;|$)"));
            if (arr != null) {
                return unescape(arr[2]); //unescape() 函数可对通过 escape() 编码的字符串进行解码。
            } 
            return null;
        }
        var name = getCookie("username");
        var pwd = getCookie("password");
        document.write(name+";"+pwd);
        function myLogin() {
            var username = document.getElementById("txtUserName").value;
            var password = document.getElementById("txtPassword").value;
            if (username == null || username == "") {
                alert("用户名不能为空");
            }
            else if (password == null || password == "") {
                alert("密码不能为空");
            }
            else if (username != name || password != pwd) {
                alert("用户名或密码错误");
            }
            else {
                alert("登录成功");
            }
        }
    </script>
</head>
<body>
    <div class="content">
        <ul>
            <li>登录</li>
            <li>
                用户名：<input id="txtUserName" type="text"  size="18"/></li>
            <li>
                密&nbsp;&nbsp; 码：<input id="txtPassword" type="password"  size="20" /></li>
            <li>
                <input id="btnLogin" type="button" value="登录" onclick="myLogin();"/>
                <input id="btnRegister" type="button" value="注册" onclick="javascript:window.location.href('Register.htm')" /></li>
        </ul>
    </div>
</body>
</html>