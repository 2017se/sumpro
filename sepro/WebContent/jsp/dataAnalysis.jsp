<!-- 个人中心页面 -->
<%@ page import="model.user" %>
<%@ page import="model.answers" %>
<%@ page import="model.questionnaire" %>
<%@ page import="model.one_question" %>
<%@ page import="model.answer_questionnaire" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
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
	<link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet">
	
	<script src="<%=path %>/js/jquery.min.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>问卷网-数据统计</title>
</head>

<body>
	<%
		/* get user from session, first check */
		user user = new user();
		if(session.getAttribute("user") != null){
			user = (user)session.getAttribute("user");
		}
		
		questionnaire questionnaire = null;
		if(request.getAttribute("questionnaire") != null){
			questionnaire = (questionnaire)request.getAttribute("questionnaire");
		}
		List<answer_questionnaire> ansQuesList = new ArrayList<answer_questionnaire>();
		if(request.getAttribute("ansQuesList") != null){
			ansQuesList = (List<answer_questionnaire>)request.getAttribute("ansQuesList");
		}
		Set<one_question> quesList = questionnaire.getQuestions();
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
	
	<div class="body-container-data">
		<%
			int i = 0; 
			for(one_question ques : quesList){
				i++;
		%>
		<div class="area-body-data">
			<%
				if(ques.getType() != 2){
			%>
			<!-- 选择题 -->
			<div style="margin:auto">
				<img src="showDiagram?questionId=<%=ques.getId() %>">
				<form action="downloadDiagram.action" method="post">
					<input style="display:none" type="text" name="questionId" value="<%=ques.getId()%>"/>
					<input class="submit-answer-button-data" type="submit" value="保存图片">
				</form>
			</div>
			<%
				} else {
			%>
			<!-- 填空题 -->
			<div class=""><%=ques.getTitle_num() %>. <%=ques.getStem() %></div>
			<div>
				<table class="table-data">
					<%
						int j = 0;
						for(answer_questionnaire ansQues :ansQuesList ){
							for(answers ans: ansQues.getAnsList()){
								if(ans.getO_id() == ques.getId()){
									j++;
					%>
					<tr>
						<td><%=ans.getAnswer() %></td>
					</tr>
					<%
								}
							}
						}
					%>
				</table>
			</div>
			<%
				}
			%>
		</div>
		<%
			}
		%>
				
		<form action="downloadExcel.action" method="post">
			<input style="display:none" type="text" name="questionnaireId" value="<%=questionnaire.getId() %>"/>
			<input style="float:right"class="submit-answer-button" type="submit" value="导出数据">
		</form>
	</div>
	<!-- 页面底端占位 -->
	<div class="header-placeholder"></div>
</body>
</html>