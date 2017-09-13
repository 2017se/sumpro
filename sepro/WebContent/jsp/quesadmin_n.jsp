<!-- 主页面1 -->
<%@ page import="model.user" %>
<%@ page import="model.questionnaire" %>
<%@ page import="model.answer_questionnaire" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
button{
	width:70px;
	height:30px;
	font-size:14px;
	background-color:white;
	color:grey;
	border-radius:4px;
	text-align:center;
	border:1px solid #aaaaaa;
	cursor:pointer;
}
.fakebutton{
	width:70px;
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
	<link href="<%=path %>/css/publishQuestionnaire.css" rel="stylesheet">
	<link href="<%=path %>/css/questionnaireSquare.css" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet">
	
	<script src="<%=path %>/js/jquery.min.js"></script>
	<script src="<%=path %>/js/personalCenter.js"></script>
	<script>
	 $(function(){	
		$(".delete").click(function(e){
			var dataset=e.currentTarget.dataset;
			var id= dataset.id;
			jQuery.ajax({
				url: 'deleteQues',
				data:{
					id : id
				},
				success:function(data){
					location.reload();
				}
			});
		});
	})
	
	</script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>问卷网-问卷广场</title>
</head>

<body>
	<%
		/* get user from session, first check */
		user user = new user();
		if(session.getAttribute("user") != null){
			user = (user)session.getAttribute("user");
		}
		/* get questionnaire list created*/
		List<questionnaire> quesListPublished = new ArrayList<questionnaire>();
		if(request.getAttribute("quesListPublished") != null){
			quesListPublished = (List<questionnaire>)request.getAttribute("quesListPublished");
		}
	%>
	
	<!-- 标题栏 -->
	<div class="header">
		<div class="header-logo">
			<img src="<%=path %>/picture/logo.png" alt="logo">
		</div>
		<div class="header-menu">
			<span class="header-menu-span">
				<a href="userAdmin">用户管理</a>
			</span>
			<span class="header-menu-span-current">
				<a href="quesAdmin">问卷管理</a>
			</span>
			<!-- 当前页面将其header-menu-span置换为current -->
		</div>
		<div class="header-username">
			<span><i class="fa fa-user"></i></span>
			<span><%=user.getUsername() %></span>
		</div>
	</div>
	<!-- 标题栏position属性为fixed，这里需要同样大小的元素来占位 -->
	<div class="header-placeholder" style="margin:0px 0px 15px 0px"></div>
	<a class="fakebutton submit-answer-button" style="margin:2px 10px 2px 30px; padding:2px 9px" href="randomB.jsp">随机备份</a>
	<a class="fakebutton submit-answer-button" style="margin:10px; padding:2px 9px" href="fixB.jsp">固定备份</a>
	<a class="fakebutton submit-answer-button" style="margin:10px; padding:2px 9px" href="backup.jsp">立刻备份</a>
	
	
	<div class="body-container">
		<table class="ques-table">
			<%
				for(int i = 0; i < quesListPublished.size(); i++){
					questionnaire ques = quesListPublished.get(i);
				
			%>
			<tr><td class="ques-tr">
				<div class="ques-header">
					<div class="ques-title">
						<a href="showQuestionnaireAdmin.action?questionnaireId=<%=ques.getId()%>">
							<%=ques.getTitle() %>
						</a>
					</div>
					<div class="ques-date" style="margin:8px 10px 0px 0px">
						<span>截止时间：</span>
						<span><%=ques.getEnd_date() %></span>
						<span style="margin:0px 0px 0px 5px">
							<button class="delete" type="button" data-id="<%=ques.getId()%>">删除</button>
						</span>
					</div>
				</div>
				<div class="ques-profile"><%=ques.getInstruction() %></div>

			</td></tr>
			<%
				}
			%>		
		</table>
	</div>
</body>
</html>