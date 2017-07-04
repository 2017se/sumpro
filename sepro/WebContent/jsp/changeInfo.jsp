<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
</style>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%//user one_user=user(session.getAttribute("oneUser")); %>
	
	<div id="info">
		<ul class="table" id="infoList">
			<FORM METHOD=POST ACTION="judgeInfo.jsp">
			<li>用户名：<input type="text" name="username"><%//=oneUser.username %></li>
			<li>邮箱：<input type="email" name="mail"><%//=oneUser.mail %></li>
			<li>姓名：<input type="text" name="name"><%//=oneUser.name %></li>
			<li>qq：<input type="text" name="qq"><%//=oneUser.qq %></li>
			<li>电话：<input type="text" name="phone"><%//=oneUser.phone %></li>
			<input type="submit" value="确定">
			</FORM>
		</ul>
	</div>
	
	
</body>
</html>