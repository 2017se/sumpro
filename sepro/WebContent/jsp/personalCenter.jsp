<%@ page import="model.user" %>
<%@ page import="model.questionnaire" %>
<%@ page import="model.answer_questionnaire" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<link href="stylesheet" href="icono.min.css">
	<link href="css/personalCenter.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	
	<script src="js/jquery.min.js"></script>
	<script src="js/personalCenter.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>个人中心</title>
</head>

<body>
	<%
		/* get user from session, first check */
		user user = new user();
		if(session.getAttribute("user") != null){
			user = (user)session.getAttribute("user");
		}
		/* get questionnaire list created and answered*/
		List<questionnaire> quesListCreated = new ArrayList<questionnaire>();
		if(request.getAttribute("quesListCreated") != null){
			quesListCreated = (List<questionnaire>)request.getAttribute("quesListCreated");
		}
		List<answer_questionnaire> quesListFilled = new ArrayList<answer_questionnaire>();
		if(request.getAttribute("quesListFilled") != null){
			quesListFilled = (List<answer_questionnaire>)request.getAttribute("quesListFilled");
		}
	%>
	
	<!-- 标题栏 -->
	<div class="header">
		<div class="header-logo">
			<img src="picture/logo.png" alt="logo">
		</div>
		<div class="header-menu">
			<span class="header-menu-span">
				<a href="#">问卷发布</a>
			</span>
			<span class="header-menu-span">
				<a href="#">问卷模板</a>
			</span>
			<span class="header-menu-span">
				<a href="#">问卷广场</a>
			</span>
			<!-- 当前页面将其header-menu-span置换为current -->
			<span class="header-menu-span-current">
				<a href="#">个人中心</a>
			</span>
		</div>
		<div class="header-username">
			<span><i class="fa fa-user"></i></span>
			<span><%=user.getUsername() %></span>
		</div>
	</div>
	<!-- 标题栏position属性为fixed，这里需要同样大小的元素来占位 -->
	<div class="header-placeholder"></div>
	
	<div class="body-container">
	
		<!-- 个人信息 -->
		<div class="area-container">
			<div class="area-header">
				<span class="area-header-title">个人信息</span>
				<span class="area-header-edit user-info-edit">[ 编辑 ]</span>
			</div>
			<form action="updateUserInfo" method="post" id="user-info-submit">
			<div class="area-body">
				<div class="area-body-info">
					<span class="area-body-info-title">用户名：</span>
					<span id="user-info-username"><%=user.getUsername() %></span>
				</div>
				<div class="area-body-info">
					<span class="area-body-info-title">邮箱：</span>
					<span id="user-info-mail"><%=user.getMail() %></span>
				</div>
				<div class="area-body-info">
					<span class="area-body-info-title">姓名：</span>
					<span id="user-info-name"><%=user.getName() %></span>
				</div>
				<div class="area-body-info">
					<span class="area-body-info-title">电话：</span>
					<span id="user-info-phone"><%=user.getPhone() %></span>
				</div>
				<div class="area-body-info">
					<span class="area-body-info-title">QQ：</span>
					<span id="user-info-qq"><%=user.getQq() %></span>
				</div>
				<div class="area-body-img-container">
					<div class="area-body-img-box">
						<img class="area-body-img" src="picture/user.jpg">
						<div class="area-body-img-button">[ 更换头像 ]</div>
					</div>
				</div>
			</div>
			</form>
		</div>
		
		<!-- 我创建的问卷 -->
		<div class="area-container">
			<div class="area-header">
				<span class="area-header-title">我创建的问卷</span>
				<span class="area-header-edit">[ 查看更多 ]</span>
			</div>
			<div class="area-body"><div style="min-height:320px;">
				<%
					questionnaire ques = null;
					for(int i = 0; i < quesListCreated.size(); i++){
						ques = quesListCreated.get(i);
				%>
				<div class="questionnaire-box questionnaire" data-quesid="<%=ques.getId()%>">
					<div class="questionnaire-title">
						<%=ques.getTitle() %>
					</div>
					<div class="questionnaire-date">
						<span>创建日期：</span>
					</div>
					<div class="questionnaire-date">
						<span><%=ques.getSet_date() %></span>
					</div>
					<div class="questionnaire-date">
						<span>截止日期：</span>
					</div>
					<div class="questionnaire-date">
						<span><%=ques.getEnd_date() %></span>
					</div>
				</div>
				<%
					}
				%>
			</div></div>
		</div>
		
		<!-- 我填写的问卷 -->
		<div class="area-container">
			<div class="area-header">
				<span class="area-header-title">我填写的问卷</span>
				<span class="area-header-edit">[ 查看更多 ]</span>
			</div>
			<div class="area-body"><div style="min-height:320px;">
				<%
					for(answer_questionnaire ansQues : quesListFilled){
						ques = ansQues.getQuestionnaire();
				%>
				<div class="questionnaire-box answer-questionnaire" 
						data-quesid="<%=ansQues.getQ_id()%>" 
						data-userid="<%=ansQues.getU_id() %>" >
					<div class="questionnaire-title">
						<%=ques.getTitle() %>
					</div>
					<div class="questionnaire-date">
						<span>创建日期：</span>
					</div>
					<div class="questionnaire-date">
						<span><%=ques.getSet_date() %></span>
					</div>
					<div class="questionnaire-date">
						<span>截止日期：</span>
					</div>
					<div class="questionnaire-date">
						<span><%=ques.getEnd_date() %></span>
					</div>
				</div>
				<%
					}
				%>	
			</div></div>
		</div>
	</div>
</body>
</html>