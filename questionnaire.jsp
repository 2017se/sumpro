<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="model.questionnaire" %>
<%@ page import="model.one_question" %>
<%@ page import="model.q_options" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
nes{color:red}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>回答问卷</title>
</head>
<body>
	<% questionnaire quesContent=(questionnaire)request.getAttribute("quesContent"); %>
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
  			<% if(question.getNessecity()==1)%> 
  				<nes>*</nes><br>	
		  	<% if(question.getType()==2) { %>  
				<div class="blankQuestion">  			
		  			<form name="blankQ">
		  				<input type="text" name="<%=question.getId() %>">
		  			</form>
		  		</div><br>
		  	<% } 
		  	else if(question.getType()==1){ %>
				<div class="mulChooseQuestion">
					<form name="mulQ">
						<% while(option_it.hasNext()){
							option=option_it.next();
							String option_identity=String.valueOf(option.getQ_id())+option.getTitle();
						%>
						<input type="checkbox" name="<%=option_identity%>"><%=option.getTitle() %>.<%=option.getProperty() %><br>
						<% }%>
					</form>
				
				</div><br>
			<% } 
			else { %>
				<div class="sinChooseQuestion">
					<form name="sinQ">
						<%while(option_it.hasNext()){ 
							option=option_it.next();
							String option_identity=String.valueOf(option.getQ_id())+option.getTitle();
						%>
						<input type="radio" name="1"><%=option.getTitle() %>.<%=option.getProperty() %><br>
						<%}%>
					</form>
				</div><br>	
		   <%}
		}%>
	
	</div>
</body>
</html>