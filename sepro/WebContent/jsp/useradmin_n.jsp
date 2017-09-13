<!-- 主页面1 -->
<%@ page import="model.user" %>
<%@ page import="model.answer_questionnaire" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
button{
	width:100px;
	height:30px;
	font-size:14px;
	background-color:white;
	color:grey;
	border-radius:4px;
	text-align:center;
	border:1px solid #aaaaaa;
	cursor:pointer;
}
</style>

<html>
<head>
	<%
		String path = request.getContextPath();
	%>

	<link href="stylesheet" href="icono.min.css">
	<link href="<%=path %>/css/personalCenter.css" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet">
	<link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet">
	
	<link href="<%=path %>/css/dataTables.bootstrap.css" rel="stylesheet">
	<link href="<%=path %>/css/dataTables.responsive.css" rel="stylesheet">
	
	<script src="<%=path %>/js/jquery.min.js"></script>
	<script src="<%=path %>/js/bootstrap.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script src="<%=path %>/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path %>/js/useradmin.js"></script>
	

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>管理用户</title>
</head>

<body>
	<%
		/* get user from session, first check */
		user user = new user();
		if(session.getAttribute("user") != null){
			user = (user)session.getAttribute("user");
		}
		/* get questionnaire list created*/
		List<user> users = new ArrayList<user>();
		if(request.getAttribute("Users") != null){
			users = (List<user>)request.getAttribute("Users");
		}
	%>
	
	<!-- 标题栏 -->
	<div class="header">
		<div class="header-logo">
			<img src="<%=path %>/picture/logo.png" alt="logo">
		</div>
		<div class="header-menu">
			<span class="header-menu-span-current">
				<a href="userAdmin">用户管理</a>
			</span>
			<span class="header-menu-span">
				<a href="quesAdmin">问卷管理</a>
			</span>

		</div>
		<div class="header-username">
			<span><i class="fa fa-user"></i></span>
			<span><%=user.getUsername() %></span>
		</div>
	</div>
	<!-- 标题栏position属性为fixed，这里需要同样大小的元素来占位 -->
	<div class="header-placeholder" style="margin:0px 0px 10px 0px"></div>
	
<div class="body-container" style="width:80%">
<div class="q">
	<table class=".." id="userTable">
		<thead>
			<tr>
				<th>用户名</th>
				<th>密码</th>
				<th>姓名</th>
				<th>邮箱</th>
				<th>qq</th>
				<th>电话</th>
				<th>管理员</th>
				<th>发布问卷权限</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
				for(int i = 0; i < users.size(); i++){
					user one_user = users.get(i);
			%>
			<tr>
				<td><%=one_user.getUsername() %></td>
				<td><%=one_user.getPassword() %></td>
				<td><%=one_user.getName() %></td>
				<td><%=one_user.getMail() %></td>
				<td><%=one_user.getQq() %></td>
				<td><%=one_user.getPhone() %></td>
				
				<%
					if(one_user.getRole()==1){%>
						<td>yes</td>
					<% }else{%>
						<td></td>
					<% }
					if(one_user.getAuthority()==1){%>
						<td>yes</td>
					<% }else{%>
					 	<td></td>
					 <% }%>
				<td>
					<button class="delete" type="button" data-id="<%=one_user.getId()%>">
						注销
					</button>
					<%if(one_user.getAuthority()==1) {%>
					<button class="forbid" type="button" data-id="<%=one_user.getId()%>">
						禁止发布
					</button>
					<%}else {%>
					<button class="allow" type="button" data-id="<%=one_user.getId()%>"
		
					>
						允许发布
					</button>
					<%} %>
					<button class="assign" type="button" data-id="<%=one_user.getId()%>"
					>
						任命管理员
					</button>
				</td>
			
			</tr>
			<%
				}
			%>		
		</tbody>
	</table>
	</div>
</div>
	<script>
		$(document).ready(function() {
			$('#userTable').DataTable({
				responsive : true
			});
		});
	</script>
	

</body>
</html>