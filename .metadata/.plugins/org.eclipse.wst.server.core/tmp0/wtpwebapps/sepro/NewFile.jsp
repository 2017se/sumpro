<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'login.jsp' starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form name="loginForm" action="loginAction.jsp" method="post">
	  	用户名:<input type="text" name="username"/><br/>
	   	密码:<input type="text" name="password"/><br/>
	   <input type="submit" value="提交"/>
	   <input type="reset" value="重置"/>
  	</form>
  </body>
</html>
处理表单loginAction.jsp

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	if(username.equals("admin")&&password.equals("admin")){	//这里是模拟,实际和数据库打交道
		response.sendRedirect("index.jsp");//跳转到你要的界面
	}else{
		response.sendRedirect("login.jsp");
	}
%>