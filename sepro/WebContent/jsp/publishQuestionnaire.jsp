<!-- 主页面1 -->
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
	<%
		String path = request.getContextPath();
	%>
	<link href="stylesheet" href="icono.min.css">
	<link href="<%=path %>/css/personalCenter.css" rel="stylesheet">
	<link href="<%=path %>/css/publishQuestionnaire.css" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet">
	
	<script src="<%=path %>/js/jquery.min.js"></script>
	<script src="<%=path %>/js/personalCenter.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>问卷网-发布问卷</title>
</head>

<body>
	<%
		/* get user from session, first check */
		user user = new user();
		if(session.getAttribute("user") != null){
			user = (user)session.getAttribute("user");
		}
		/* get questionnaire list created*/
		List<questionnaire> quesListCreated = new ArrayList<questionnaire>();
		if(request.getAttribute("quesListCreated") != null){
			quesListCreated = (List<questionnaire>)request.getAttribute("quesListCreated");
		}
	%>
	
	<!-- 标题栏 -->
	<div class="header">
		<div class="header-logo">
			<img src="<%=path %>/picture/logo.png" alt="logo">
		</div>
		<div class="header-menu">
			<span class="header-menu-span-current">
				<a href="publishQuestionnaire.action?userId=<%=user.getId()%>">发布问卷</a>
			</span>
			<span class="header-menu-span">
				<a href="#">问卷模板</a>
			</span>
			<span class="header-menu-span">
				<a href="questionnaireSquare.action">问卷广场</a>
			</span>
			<!-- 当前页面将其header-menu-span置换为current -->
			<span class="header-menu-span">
				<a href="personalCenter.action">个人中心</a>
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
		
		<!-- 我创建的问卷 -->
		<div class="area-container">
			<div class="area-header">
				<span class="area-header-title">我创建的问卷</span>
				<span class="area-header-edit">[ 查看更多 ]</span>
			</div>

			<div class="area-body-noborder"><div style="min-height:320px;">
				<%
					questionnaire ques = null;
					for(int i = 0; i < quesListCreated.size(); i++){
						ques = quesListCreated.get(i);
				%>
				<div class="questionnaire-box questionnaire-created" data-quesid="<%=ques.getId()%>">
					<div class="questionnaire-title">
						<%=ques.getTitle() %>
					</div>
					<div class="questionnaire-date">
						<%if(ques.getSet_date() == null){%>
							<span>问卷状态：未发布</span>
							<!-- 隐藏表单，用于向发布前预览问卷内容页面的跳转 -->
							<form action="publishPreview" method="post" id="get-questionnaire">
								<input name="questionnaireId" value="" style="display:none">
							</form>
						<%}else{ %>
							<span>问卷状态：已发布</span>
							<!-- 隐藏表单，用于向展示问卷内容页面的跳转 -->
							<form action="getQuesContent" method="post" id="get-questionnaire">
								<input name="questionnaireId" value="" style="display:none">
							</form>
						<%} %>
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
		
		<!-- 创建新问卷 -->
		<div class="area-container">
			<div class="area-header">
				<span class="area-header-title">创建新问卷</span>
			</div>
			<div class="area-body-noborder"><div style="min-height:320px;">
				<div class="questionnaire-box">
					<div class="create-button">
						<a href="<%=path %>/jsp/createQuestionnaire.jsp"><i class="fa fa-plus-square-o"></i></a>
					</div>
				</div>
			</div></div>
		</div>
		
	</div>
</body>
</html>