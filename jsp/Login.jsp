<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
body {
background-image:url(bg.jpg)
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
</head>
<body>
<div class="logo_img"><img src="logo.jpg" width="80px" height="80px" /></div>
<div class="title">问卷网</div>
<text_location><A HREF='#'>问卷广场</A>
<A HREF='#'>模板库</A>
<A HREF='#'>关于我们</A></text_location>

<log_button_location><button class="button white bigrounded" id="login">登录</button></log_button_location>
<reg_button_location><button class="button white bigrounded" id="regist" >注册</button></reg_button_location>

</body>
</html>