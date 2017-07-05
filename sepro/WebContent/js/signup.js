/**
 * 
 */
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
        	if (name.length>20){
        		checkName.innerHTML="用户名不能超过20个字符"
        	}
        	else if (name == null || name == "") {
                checkName.innerHTML = "用户名不能为空";
            }
            else {
                checkName.innerHTML = "用户名可用";
                return true;
            }
        }
        //焦点移走密码框
        function blurPwd(password) {
        	if(password.length>20){
        		checkName.innerHTML="密码不能超过20个字符"
        	}
        	
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
        
        function bluremail(mail){
        	if(mail==null || mail==""){
        		checkmail.innerHTML="邮箱不能为空";
        	}
        	else {
        		return true;
        	}
        }