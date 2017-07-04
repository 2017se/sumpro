<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
head_location{
	position:absolute;
	top:60px;
	left:300px;
}

.head_img{
	transform:rotate(90deg);
	position:absolute;
	top:65px
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%/*
		user oneUser=request.getAttribute("oneuser"); 
		list<questionnaire> Questionnaires=request.getAttribute("questionnaire");
		list<answer_questionnaire> AnswerQuestionnaires=request.getAttribute("answerquestionnaires");
		session.setAttribute("oneUser",oneUser);
	*/%> 
	
	<A HREF=changeInfo.jsp>修改信息</A>
	<div id="info">
		<ul class="table" id="infoList">
			<li>用户名：<%//=oneUser.username %></li>
			<li>邮箱：<%//=oneUser.mail %></li>
			<li>姓名：<%//=oneUser.name %></li>
			<li>qq：<%//=oneUser.qq %></li>
			<li>电话：<%//=oneUser.phone %></li>
		</ul>
	</div>
	
<head_location>	
	头像
	<div class="head_img">
		<img src="../picture/touxiang.JPG" height=120px>
	</div>
</head_location>


<div id=pub_questionnaire>
	发布的问卷
	<% //for(int i=0;i<Questionnaires.length;i++) {%>
	<li id="<%//=Questionnaires[i].id%>"><A HREF="one_questionnaire.jsp"><img src="#" height=120px></A></li>
	<%// }%>	
</div>

<div id=ans_quesionnaire>
	回答的问卷
	<% //for(int i=0;i<AnswerQuestionnaires.length;i++) {%>
	<li id="<%//=AnswerQuestionnaires[i].id%>"><A HREF="one_questionnaire.jsp"><img src="#" height=120px></A></li>
	<%// }%>
</div>

</body>
</html>