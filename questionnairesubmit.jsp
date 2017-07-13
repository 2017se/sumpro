<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.user" %>
<%@ page import="model.questionnaire" %>
<%@ page import="model.one_question" %>
<%@ page import="model.q_options" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.dataTables.min.js"></script>
	<script src="../js/dataTables.bootstrap.min.js"></script>
	<script src="../js/bootbox.min.js"></script>
	
	<script src="../js/saveAnswers.js"></script>
	

<style>
nes{color:red}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>回答问卷</title>
</head>
<body>
	<% 
		questionnaire quesContent=(questionnaire)request.getAttribute("quesContent"); 
		//user user=(user)session.getAttribute("user");
	%>
	<div class="header">
		标题:<%=quesContent.getTitle() %><br>
		说明:<%=quesContent.getInstruction() %><br>
		发布时间:<%=quesContent.getSet_time() %><br>
		截止时间:<%=quesContent.getEnd_time() %><br>
	</div><br>
	
	
	<div class="body">
	<% 
		Set<one_question> questions=quesContent.getQuestions(); 
		one_question question;
		Iterator<one_question> question_it = questions.iterator();
		
		
		while (question_it.hasNext()) {  
		  	question=question_it.next();
		  	
		  	Set<q_options> options=question.getOptions();
		  	q_options option;
		  	Iterator<q_options> option_it=options.iterator();%>
		  	<%=question.getTitle_num()%>.
		  	<%=question.getStem() %>		  
  			<% if(question.getNessecity()==1){%> 
  				<nes>*</nes><br>
  				<%}%>	
		  	<% if(question.getType()==2) { %>  
				<div class="blankQuestion">  			
		  			<form name="blankQ">
		  				<input type="text" id="<%=question.getId() %>" name="<%=question.getTitle_num() %>">
		  				<input hidden type="text" name="<%="I"+question.getTitle_num() %>" value="<%=question.getId() %>">
		  				<input hidden type="text" name="<%="T"+question.getTitle_num() %>" value="<%=question.getType() %>">
		  			</form>
		  		</div><br>
		  	<% } 
		  	else if(question.getType()==1){ %>
				<div class="mulChooseQuestion">
					<form name="mulQ">
						<input hidden type="text" name="<%="I"+question.getTitle_num() %>" value="<%=question.getId() %>">
		  				<input hidden type="text" name="<%="T"+question.getTitle_num() %>" value="<%=question.getType() %>">
						<%while(option_it.hasNext()){
							 option=option_it.next();
						%>
						<input type="checkbox" name="<%=question.getTitle_num()%>" value="<%=option.getTitle()%>"><%=option.getTitle() %>.<%=option.getProperty() %><br>
						
						<%}%>
					</form>
				
				</div><br>
			<% } 
			else { %>
				<div class="sinChooseQuestion">
					<form name="sinQ">
						<input hidden type="text" name="<%="I"+question.getTitle_num() %>" value="<%=question.getId() %>">
		  				<input hidden type="text" name="<%="T"+question.getTitle_num() %>" value="<%=question.getType() %>">
						
						<%while(option_it.hasNext()){ 
							 option=option_it.next();
						%>
						<input type="radio" name="<%=question.getTitle_num()%>" value="<%=option.getTitle()%>"><%=option.getTitle()%>.<%=option.getProperty() %><br>
						<%}%>
					</form>
				</div><br>	
		   <%}
		}%>
	</div>
	<button type="button" id="submit-answer" value="提交">提交</button>
	
	
	<!--这一段为js提供用户id,问卷长度,问卷id和当前时间--> 
	<%
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date=df.format(new Date());
	%>
  
	<p hidden>
		<input type="text" name="quesnum" value="<%=quesContent.getQuestions().size()%>">
		<input type="text" name="date" value="<%=date %>">
		<input type="text" name="userid" value="<%//=user.getId()%>">
		<input type="text" name="questionnaireid" value="<%=quesContent.getId() %>">
	</p>

</body>
</html>