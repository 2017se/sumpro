<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.dataTables.min.js"></script>
	<script src="../js/dataTables.bootstrap.min.js"></script>
	<script src="../js/bookstore.js"></script>
	<script src="../js/bootbox.min.js"></script>

	<script src="../js/signup.js"></script>

<style>
nec{color:red}

body {
background-image:url(../picture/bg.jpg)
}

.logo_img{
position:absolute;
top:50px
}

.title{
position:absolute;
top:60px;
left:90px;

font-size:35px;
color:#000040;
font-weight:bold

}

/*按钮*/
.button {
	display: inline-block;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 14px/100% Arial, Helvetica, sans-serif;
	padding: .5em 2em .55em;
	-webkit-border-radius: .5em; 
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	-moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	box-shadow: 0 1px 2px rgba(0,0,0,.2);
}
.button:hover {
	text-decoration: none;
}
.button:active {

}
.white {
	color: #606060;
	border: solid 1px #b7b7b7;
	background: #fff;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#ededed));
	background: -moz-linear-gradient(top,  #fff,  #ededed);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#ededed');
}
.white:hover {
	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#dcdcdc));
	background: -moz-linear-gradient(top,  #fff,  #dcdcdc);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#dcdcdc');
}
.white:active {
	color: #999;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#fff));
	background: -moz-linear-gradient(top,  #ededed,  #fff);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#ffffff');
}


text_location{
	position:absolute;
	top:70px;
	left:230px	
}

log_button_location{
	position:absolute;
	top:60px;
	left:450px	
}

reg_button_location{
	position:absolute;
	top:60px;
	left:550px
}
</style>

<title>问卷网</title>

<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="../css/dataTables.responsive.css"
	rel="stylesheet">
<link href="../css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>
<body>
<div class="logo_img"><img src="../picture/logo.jpg" width="80px" height="80px" /></div>
<div class="title">问卷网</div>
<text_location><A HREF='#'>问卷广场</A>
<A HREF='#'>模板库</A>
<A HREF='#'>关于我们</A></text_location>

<log_button_location><button class="button white bigrounded" data-toggle="modal" data-target="#login">登录</button></log_button_location>
<reg_button_location><button class="button white bigrounded" data-toggle="modal" data-target="#regis" >注册</button></reg_button_location>

<div class="modal fade" id="login" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					登录
				</h4>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form" method=post action="login">
								<div class="form-group">
									<label>用户名</label><nec><label>*</label></nec> <input class="form-control" name="username">
								</div>
								<div class="form-group">
									<label>密码</label><nec><label>*</label></nec> <input class="form-control" type="password" name="password">
								</div>
							</form>
						</div>
					</div>
				</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<INPUT TYPE=SUBMIT Value="登录" class="btn btn-default">
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


<div class="modal fade" id="regis" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					注册
				</h4>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form" method=post Action="regis">
								<div class="form-group">
									<label>用户名</label><nec><label>*</label></nec> <input class="form-control" id="txtUserName" name="username" onblur="blurName(this.value)">
									<nec><span id="checkName"></span></nec>
								</div>
								<div class="form-group">
									<label>密码</label><nec><label>*</label></nec> <input class="form-control" id="txtPassword" type="password" onblur="blurPwd(this.value)" name="password">
									<nec><span id="checkPwd"></span></nec>
								</div>
								<div class="form-group">
									<label>再次输入密码</label><nec><label>*</label></nec> <input class="form-control" id="pwdOk" type="password" name="password_c"  onblur="blurPwdOk(this.value)">
									<nec><span id="checkOk"></span></nec>
								</div>
								<div class="form-group">
									<label>邮箱</label> <nec><label>*</label></nec> <input class="form-control" id="check_mail" type="email" name="email" onblur="bluremail(this.value)">
									<nec><span id="checkmail"></span></nec>
								</div>
								<div class="form-group">
									<label>姓名</label> <input class="form-control"
										name="name">
								</div>
								<div class="form-group">
									<label>qq</label> <input class="form-control" 
										name="qq">
								</div>
								<div class="form-group">
									<label>phone</label> <input class="form-control" 
										name="phone">
								</div>
							</form>
						</div>
					</div>
				</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<INPUT TYPE=SUBMIT Value="注册" class="btn btn-default" >
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

	

</body>
</html>