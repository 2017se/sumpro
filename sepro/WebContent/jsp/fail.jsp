<!-- 登录和注册失败后跳转到的页面，从该页面可以跳转到主页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>问卷网</title>
</head>
<body>
	<%
		String path = request.getContextPath();
		String action="", message = "";
		if(request.getAttribute("action") != null){
			action = (String)request.getAttribute("action");
		}
		if(request.getAttribute("message") != null){
			message = (String)request.getAttribute("message");
		}
	%>
	<div style="font-size:20px">
		<%=(action.equals("login"))?"登录":"注册"%>失败：
	</div>
	<div style="font-size:14px">
		<%=message %>
	</div>
	<a href="<%=path %>/jsp/mainpage.jsp">点此返回</a>
</body>
</html>