<!-- 输入邮箱验证码页面 -->
<%@ page import="model.user" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

	<%
		String path = request.getContextPath();
		user user = new user();
		if(session.getAttribute("user") != null){
			user = (user)request.getAttribute("user");
		}
	%>
	
	<link href="<%=path %>/css/personalCenter.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>问卷网</title>
</head>

<body>
	<div class="body-container">
	<div class="area-header">
		<span class="area-header-title">请输入验证码：</span>
		<form action="SaveUser" method="post" id="user-info-submit">
			<input name="code">
			<input type="submit" value="提交">
		</form>
	</div></div>

</body>
</html>